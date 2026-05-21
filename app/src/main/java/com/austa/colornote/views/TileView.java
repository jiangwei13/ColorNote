package com.austa.colornote.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.austa.colornote.R;

public class TileView extends AppCompatTextView {
    private float lastTouchX, lastTouchY;
    private boolean isDragging = false;
    private OnPositionChangedListener positionListener;

    public interface OnPositionChangedListener {
        void onPositionChanged(TileView view, float newX, float newY);
    }

    public TileView(Context context) {
        super(context);
        init();
    }

    public TileView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setPadding(48, 48, 48, 48);
        setTextSize(16);
        setTextColor(ContextCompat.getColor(getContext(), R.color.onSurface));
        setBackgroundResource(R.drawable.tile_background);
        setElevation(8);
        setMaxWidth(600); // Prevent extremely wide notes
    }

    public void setNoteContent(String title, String content) {
        if (title == null || title.isEmpty()) {
            setText(content);
        } else {
            SpannableStringBuilder builder = new SpannableStringBuilder();
            builder.append(title);
            builder.setSpan(new StyleSpan(Typeface.BOLD), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            builder.setSpan(new RelativeSizeSpan(1.2f), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            
            if (content != null && !content.isEmpty()) {
                builder.append("\n\n");
                builder.append(content);
            }
            setText(builder);
        }
    }

    public void setPositionListener(OnPositionChangedListener listener) {
        this.positionListener = listener;
    }

    public void setColor(int colorValue) {
        GradientDrawable background = (GradientDrawable) ((android.graphics.drawable.RippleDrawable) getBackground())
                .findDrawableByLayerId(android.R.id.background);
        if (background == null) {
            background = (GradientDrawable) getBackground();
        }
        
        if (background != null) {
            background.setColor(colorValue);
        } else {
            setBackgroundColor(colorValue);
        }
        
        if (isDarkColor(colorValue)) {
            setTextColor(Color.WHITE);
        } else {
            setTextColor(Color.BLACK);
        }
    }

    private boolean isDarkColor(int color) {
        double darkness = 1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255;
        return darkness >= 0.5;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                lastTouchX = event.getRawX();
                lastTouchY = event.getRawY();
                isDragging = false;
                break;
            case MotionEvent.ACTION_MOVE:
                float deltaX = event.getRawX() - lastTouchX;
                float deltaY = event.getRawY() - lastTouchY;
                if (Math.abs(deltaX) > 10 || Math.abs(deltaY) > 10) {
                    isDragging = true;
                    setTranslationX(getTranslationX() + deltaX);
                    setTranslationY(getTranslationY() + deltaY);
                    lastTouchX = event.getRawX();
                    lastTouchY = event.getRawY();
                }
                break;
            case MotionEvent.ACTION_UP:
                if (!isDragging) {
                    performClick();
                } else {
                    if (positionListener != null) {
                        positionListener.onPositionChanged(this, getTranslationX(), getTranslationY());
                    }
                }
                break;
        }
        return true;
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }
}