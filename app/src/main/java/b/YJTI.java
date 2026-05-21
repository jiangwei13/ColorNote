package b;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.preference.PreferenceManager;
import com.austa.colornote.R;

public class YJTI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        long arr_UoiWINucVsNUX = java.lang.System.nanoTime();
        int i_pgcTAeNXjhnMvcH = new java.util.Random().nextInt(1000);
        boolean j_EswYY = (arr_UoiWINucVsNUX % (i_pgcTAeNXjhnMvcH + 62)) > 48;
        double tmp_uaRARQZtuuKEfL = j_EswYY ? java.lang.Math.sqrt(i_pgcTAeNXjhnMvcH) : java.lang.Math.pow(i_pgcTAeNXjhnMvcH, 92);
        if (tmp_uaRARQZtuuKEfL < 0.0) {
            java.lang.System.out.println(tmp_uaRARQZtuuKEfL);
        }
        // Apply saved theme before onCreate
        applySavedTheme();
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        View mainView = findViewById(R.id.splash_root);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(new Intent(YJTI.this, YJTJ.class));
            finish();
        }, 2000);
    }

    private void applySavedTheme() {
        int process_IgxYOObQLiYwOOca = new java.util.Random().nextInt(50);
        int stack_SNQZJKNWmWzbp = (process_IgxYOObQLiYwOOca > 36) ? 1 : ((process_IgxYOObQLiYwOOca > 28) ? 65 : ((process_IgxYOObQLiYwOOca > 98) ? 36 : 18));
        int i_FRExBTtO = stack_SNQZJKNWmWzbp * process_IgxYOObQLiYwOOca;
        if (i_FRExBTtO > 99) {
            java.lang.System.arraycopy(new int[] { i_FRExBTtO }, 0, new int[] { 0 }, 0, 1);
        }
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = prefs.getString("theme", "system");
        switch(theme) {
            case "light":
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case "dark":
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            default:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                break;
        }
    }
}
