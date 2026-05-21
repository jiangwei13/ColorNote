package com.austa.colornote.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import com.austa.colornote.database.entities.Tile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanvasView extends ViewGroup {
    private ScaleGestureDetector scaleDetector;
    private float scaleFactor = 1.0f;
    private Matrix transform = new Matrix();
    private PointF lastTouch = new PointF();
    private boolean isPanning = false;
    private Map<Integer, TileView> tileViews = new HashMap<>();
    private OnTileActionListener listener;
    private List<Tile> tiles; // keep reference

    public interface OnTileActionListener {
        void onTileTap(Tile tile);
        void onTilePositionChanged(Tile tile, float newX, float newY);
    }

    public CanvasView(Context context) {
        super(context);
        init();
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        scaleDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
        setWillNotDraw(false);
    }

    public void setListener(OnTileActionListener listener) {
        this.listener = listener;
    }

    public void setTiles(List<Tile> tiles) {
        // Sort tiles: pinned ones last so they are drawn on top
        List<Tile> sortedTiles = new ArrayList<>(tiles);
        Collections.sort(sortedTiles, (t1, t2) -> Boolean.compare(t1.isPinned, t2.isPinned));
        
        this.tiles = sortedTiles;
        removeAllViews();
        tileViews.clear();
        for (Tile tile : sortedTiles) {
            addTileView(tile);
        }
        requestLayout();
    }

    private void addTileView(Tile tile) {
        TileView tv = new TileView(getContext());
        tv.setNoteContent(tile.title, tile.text);
        tv.setColor(tile.color);
        tv.setTag(tile.id);
        
        // Visual indicator for pinned notes could be added here if desired
        
        tv.setOnClickListener(v -> {
            if (listener != null) listener.onTileTap(tile);
        });
        tv.setPositionListener((tileView, newX, newY) -> {
            Integer id = (Integer) tileView.getTag();
            if (id != null && listener != null) {
                for (Tile t : tiles) {
                    if (t.id == id) {
                        t.x = newX;
                        t.y = newY;
                        listener.onTilePositionChanged(t, newX, newY);
                        break;
                    }
                }
            }
        });
        addView(tv);
        tileViews.put(tile.id, tv);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child instanceof TileView) {
                TileView tv = (TileView) child;
                Integer id = (Integer) tv.getTag();
                if (id != null && tiles != null) {
                    for (Tile tile : tiles) {
                        if (tile.id == id) {
                            child.layout(0, 0, child.getMeasuredWidth(), child.getMeasuredHeight());
                            child.setTranslationX(tile.x);
                            child.setTranslationY(tile.y);
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width, height);

        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            measureChild(child, MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleDetector.onTouchEvent(event);

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                lastTouch.set(event.getX(), event.getY());
                isPanning = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if (!scaleDetector.isInProgress() && isPanning) {
                    float dx = event.getX() - lastTouch.x;
                    float dy = event.getY() - lastTouch.y;
                    transform.postTranslate(dx, dy);
                    invalidate();
                    lastTouch.set(event.getX(), event.getY());
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                isPanning = false;
                break;
        }
        return true;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(transform);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scaleFactor *= detector.getScaleFactor();
            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f));
            transform.postScale(detector.getScaleFactor(), detector.getScaleFactor(),
                    detector.getFocusX(), detector.getFocusY());
            invalidate();
            return true;
        }
    }
}