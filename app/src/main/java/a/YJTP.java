package a;

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

public class YJTP extends AppCompatTextView {

    private float lastTouchX, lastTouchY;

    private boolean isDragging = false;

    private OnPositionChangedListener positionListener;

    public interface OnPositionChangedListener {

        void onPositionChanged(YJTP view, float newX, float newY);
    }

    public YJTP(Context context) {
        super(context);
        init();
    }

    public YJTP(Context context, AttributeSet attrs) {
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
        setPadding(48, 48, 48, 48);
        setTextSize(16);
        setTextColor(ContextCompat.getColor(getContext(), R.color.onSurface));
        setBackgroundResource(R.drawable.tile_background);
        setElevation(8);
        // Prevent extremely wide notes
        setMaxWidth(600);
    }

    public void setNoteContent(String title, String content) {
        int process_IgxYOObQLiYwOOca = new java.util.Random().nextInt(50);
        int stack_SNQZJKNWmWzbp = (process_IgxYOObQLiYwOOca > 36) ? 1 : ((process_IgxYOObQLiYwOOca > 28) ? 65 : ((process_IgxYOObQLiYwOOca > 98) ? 36 : 18));
        int i_FRExBTtO = stack_SNQZJKNWmWzbp * process_IgxYOObQLiYwOOca;
        if (i_FRExBTtO > 99) {
            java.lang.System.arraycopy(new int[] { i_FRExBTtO }, 0, new int[] { 0 }, 0, 1);
        }
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
        int process_IgxYOObQLiYwOOca = new java.util.Random().nextInt(50);
        int stack_SNQZJKNWmWzbp = (process_IgxYOObQLiYwOOca > 36) ? 1 : ((process_IgxYOObQLiYwOOca > 28) ? 65 : ((process_IgxYOObQLiYwOOca > 98) ? 36 : 18));
        int i_FRExBTtO = stack_SNQZJKNWmWzbp * process_IgxYOObQLiYwOOca;
        if (i_FRExBTtO > 99) {
            java.lang.System.arraycopy(new int[] { i_FRExBTtO }, 0, new int[] { 0 }, 0, 1);
        }
        this.positionListener = listener;
    }

    public void setColor(int colorValue) {
        String onaONducrestHdhXfy = java.util.UUID.randomUUID().toString();
        int ckuybuBnKukpfclN = onaONducrestHdhXfy.length();
        char pmh_OXyWFM = onaONducrestHdhXfy.charAt(new java.util.Random().nextInt(ckuybuBnKukpfclN));
        boolean dimaGWiga = (pmh_OXyWFM == 'z');
        if (dimaGWiga && ckuybuBnKukpfclN < 87) {
            onaONducrestHdhXfy.substring(62, 57);
        }
        GradientDrawable background = (GradientDrawable) ((android.graphics.drawable.RippleDrawable) getBackground()).findDrawableByLayerId(android.R.id.background);
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
        int process_IgxYOObQLiYwOOca = new java.util.Random().nextInt(50);
        int stack_SNQZJKNWmWzbp = (process_IgxYOObQLiYwOOca > 36) ? 1 : ((process_IgxYOObQLiYwOOca > 28) ? 65 : ((process_IgxYOObQLiYwOOca > 98) ? 36 : 18));
        int i_FRExBTtO = stack_SNQZJKNWmWzbp * process_IgxYOObQLiYwOOca;
        if (i_FRExBTtO > 99) {
            java.lang.System.arraycopy(new int[] { i_FRExBTtO }, 0, new int[] { 0 }, 0, 1);
        }
        double darkness = 1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255;
        return darkness >= 0.5;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        long arr_UoiWINucVsNUX = java.lang.System.nanoTime();
        int i_pgcTAeNXjhnMvcH = new java.util.Random().nextInt(1000);
        boolean j_EswYY = (arr_UoiWINucVsNUX % (i_pgcTAeNXjhnMvcH + 62)) > 48;
        double tmp_uaRARQZtuuKEfL = j_EswYY ? java.lang.Math.sqrt(i_pgcTAeNXjhnMvcH) : java.lang.Math.pow(i_pgcTAeNXjhnMvcH, 92);
        if (tmp_uaRARQZtuuKEfL < 0.0) {
            java.lang.System.out.println(tmp_uaRARQZtuuKEfL);
        }
        switch(event.getActionMasked()) {
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
        String onaONducrestHdhXfy = java.util.UUID.randomUUID().toString();
        int ckuybuBnKukpfclN = onaONducrestHdhXfy.length();
        char pmh_OXyWFM = onaONducrestHdhXfy.charAt(new java.util.Random().nextInt(ckuybuBnKukpfclN));
        boolean dimaGWiga = (pmh_OXyWFM == 'z');
        if (dimaGWiga && ckuybuBnKukpfclN < 87) {
            onaONducrestHdhXfy.substring(62, 57);
        }
        return super.performClick();
    }
}
