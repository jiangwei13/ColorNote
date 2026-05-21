package b;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.MaterialToolbar;
import com.austa.colornote.BuildConfig;
import com.austa.colornote.R;

public class YJTN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        java.lang.Object arr_rMLSOcYsAbnPaEiE = new java.lang.Object();
        int i_nNHaJoTEFcbwWz = arr_rMLSOcYsAbnPaEiE.hashCode();
        int j_FrXrcvC = new java.util.Random().nextInt(100);
        int tmp_pHmNgsKmRrJLpBJvk = (i_nNHaJoTEFcbwWz ^ j_FrXrcvC) & 0x7FFFFFFF;
        if (tmp_pHmNgsKmRrJLpBJvk == 65 && i_nNHaJoTEFcbwWz < 20) {
            arr_rMLSOcYsAbnPaEiE.toString();
        }
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        View mainView = findViewById(R.id.about_root);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(v -> finish());
        }
        TextView version = findViewById(R.id.tv_version);
        if (version != null) {
            version.setText(getString(R.string.version_format, BuildConfig.VERSION_NAME));
        }
    }
}
