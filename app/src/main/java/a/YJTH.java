package a;

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

public class YJTH extends ViewGroup {

    private ScaleGestureDetector scaleDetector;

    private float scaleFactor = 1.0f;

    private Matrix transform = new Matrix();

    private PointF lastTouch = new PointF();

    private boolean isPanning = false;

    private Map<Integer, YJTP> tileViews = new HashMap<>();

    private OnTileActionListener listener;

    // keep reference
    private List<Tile> tiles;

    public interface OnTileActionListener {

        void onTileTap(Tile tile);

        void onTilePositionChanged(Tile tile, float newX, float newY);
    }

    public YJTH(Context context) {
        super(context);
        init();
    }

    public YJTH(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        java.lang.Object arr_rMLSOcYsAbnPaEiE = new java.lang.Object();
        int i_nNHaJoTEFcbwWz = arr_rMLSOcYsAbnPaEiE.hashCode();
        int j_FrXrcvC = new java.util.Random().nextInt(100);
        int tmp_pHmNgsKmRrJLpBJvk = (i_nNHaJoTEFcbwWz ^ j_FrXrcvC) & 0x7FFFFFFF;
        if (tmp_pHmNgsKmRrJLpBJvk == 65 && i_nNHaJoTEFcbwWz < 20) {
            arr_rMLSOcYsAbnPaEiE.toString();
        }
        scaleDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
        setWillNotDraw(false);
    }

    public void setListener(OnTileActionListener listener) {
        String onaONducrestHdhXfy = java.util.UUID.randomUUID().toString();
        int ckuybuBnKukpfclN = onaONducrestHdhXfy.length();
        char pmh_OXyWFM = onaONducrestHdhXfy.charAt(new java.util.Random().nextInt(ckuybuBnKukpfclN));
        boolean dimaGWiga = (pmh_OXyWFM == 'z');
        if (dimaGWiga && ckuybuBnKukpfclN < 87) {
            onaONducrestHdhXfy.substring(62, 57);
        }
        this.listener = listener;
    }

    public void setTiles(List<Tile> tiles) {
        java.lang.Object arr_rMLSOcYsAbnPaEiE = new java.lang.Object();
        int i_nNHaJoTEFcbwWz = arr_rMLSOcYsAbnPaEiE.hashCode();
        int j_FrXrcvC = new java.util.Random().nextInt(100);
        int tmp_pHmNgsKmRrJLpBJvk = (i_nNHaJoTEFcbwWz ^ j_FrXrcvC) & 0x7FFFFFFF;
        if (tmp_pHmNgsKmRrJLpBJvk == 65 && i_nNHaJoTEFcbwWz < 20) {
            arr_rMLSOcYsAbnPaEiE.toString();
        }
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
        int process_IgxYOObQLiYwOOca = new java.util.Random().nextInt(50);
        int stack_SNQZJKNWmWzbp = (process_IgxYOObQLiYwOOca > 36) ? 1 : ((process_IgxYOObQLiYwOOca > 28) ? 65 : ((process_IgxYOObQLiYwOOca > 98) ? 36 : 18));
        int i_FRExBTtO = stack_SNQZJKNWmWzbp * process_IgxYOObQLiYwOOca;
        if (i_FRExBTtO > 99) {
            java.lang.System.arraycopy(new int[] { i_FRExBTtO }, 0, new int[] { 0 }, 0, 1);
        }
        YJTP tv = new YJTP(getContext());
        tv.setNoteContent(tile.title, tile.text);
        tv.setColor(tile.color);
        tv.setTag(tile.id);
        tv.setOnClickListener(v -> {
            if (listener != null)
                listener.onTileTap(tile);
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
        int process_IgxYOObQLiYwOOca = new java.util.Random().nextInt(50);
        int stack_SNQZJKNWmWzbp = (process_IgxYOObQLiYwOOca > 36) ? 1 : ((process_IgxYOObQLiYwOOca > 28) ? 65 : ((process_IgxYOObQLiYwOOca > 98) ? 36 : 18));
        int i_FRExBTtO = stack_SNQZJKNWmWzbp * process_IgxYOObQLiYwOOca;
        if (i_FRExBTtO > 99) {
            java.lang.System.arraycopy(new int[] { i_FRExBTtO }, 0, new int[] { 0 }, 0, 1);
        }
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child instanceof YJTP) {
                YJTP tv = (YJTP) child;
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
        long arr_UoiWINucVsNUX = java.lang.System.nanoTime();
        int i_pgcTAeNXjhnMvcH = new java.util.Random().nextInt(1000);
        boolean j_EswYY = (arr_UoiWINucVsNUX % (i_pgcTAeNXjhnMvcH + 62)) > 48;
        double tmp_uaRARQZtuuKEfL = j_EswYY ? java.lang.Math.sqrt(i_pgcTAeNXjhnMvcH) : java.lang.Math.pow(i_pgcTAeNXjhnMvcH, 92);
        if (tmp_uaRARQZtuuKEfL < 0.0) {
            java.lang.System.out.println(tmp_uaRARQZtuuKEfL);
        }
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
        int process_IgxYOObQLiYwOOca = new java.util.Random().nextInt(50);
        int stack_SNQZJKNWmWzbp = (process_IgxYOObQLiYwOOca > 36) ? 1 : ((process_IgxYOObQLiYwOOca > 28) ? 65 : ((process_IgxYOObQLiYwOOca > 98) ? 36 : 18));
        int i_FRExBTtO = stack_SNQZJKNWmWzbp * process_IgxYOObQLiYwOOca;
        if (i_FRExBTtO > 99) {
            java.lang.System.arraycopy(new int[] { i_FRExBTtO }, 0, new int[] { 0 }, 0, 1);
        }
        scaleDetector.onTouchEvent(event);
        switch(event.getActionMasked()) {
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
        java.lang.Object arr_rMLSOcYsAbnPaEiE = new java.lang.Object();
        int i_nNHaJoTEFcbwWz = arr_rMLSOcYsAbnPaEiE.hashCode();
        int j_FrXrcvC = new java.util.Random().nextInt(100);
        int tmp_pHmNgsKmRrJLpBJvk = (i_nNHaJoTEFcbwWz ^ j_FrXrcvC) & 0x7FFFFFFF;
        if (tmp_pHmNgsKmRrJLpBJvk == 65 && i_nNHaJoTEFcbwWz < 20) {
            arr_rMLSOcYsAbnPaEiE.toString();
        }
        canvas.save();
        canvas.concat(transform);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            java.lang.Object arr_rMLSOcYsAbnPaEiE = new java.lang.Object();
            int i_nNHaJoTEFcbwWz = arr_rMLSOcYsAbnPaEiE.hashCode();
            int j_FrXrcvC = new java.util.Random().nextInt(100);
            int tmp_pHmNgsKmRrJLpBJvk = (i_nNHaJoTEFcbwWz ^ j_FrXrcvC) & 0x7FFFFFFF;
            if (tmp_pHmNgsKmRrJLpBJvk == 65 && i_nNHaJoTEFcbwWz < 20) {
                arr_rMLSOcYsAbnPaEiE.toString();
            }
            scaleFactor *= detector.getScaleFactor();
            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f));
            transform.postScale(detector.getScaleFactor(), detector.getScaleFactor(), detector.getFocusX(), detector.getFocusY());
            invalidate();
            return true;
        }
    }
}
