package b;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.austa.colornote.R;
import com.austa.colornote.database.entities.Tile;
import com.austa.colornote.viewmodels.TileViewModel;
import a.YJTH;

public class YJTJ extends AppCompatActivity {

    private YJTH canvasView;

    private TileViewModel viewModel;

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
        setContentView(R.layout.activity_main);
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        canvasView = findViewById(R.id.canvas);
        ExtendedFloatingActionButton fab = findViewById(R.id.fab_add);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_root), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        viewModel = new ViewModelProvider(this).get(TileViewModel.class);
        viewModel.getAllTiles().observe(this, tiles -> {
            if (tiles != null) {
                canvasView.setTiles(tiles);
            }
        });
        canvasView.setListener(new YJTH.OnTileActionListener() {

            @Override
            public void onTileTap(Tile tile) {
                int process_IgxYOObQLiYwOOca = new java.util.Random().nextInt(50);
                int stack_SNQZJKNWmWzbp = (process_IgxYOObQLiYwOOca > 36) ? 1 : ((process_IgxYOObQLiYwOOca > 28) ? 65 : ((process_IgxYOObQLiYwOOca > 98) ? 36 : 18));
                int i_FRExBTtO = stack_SNQZJKNWmWzbp * process_IgxYOObQLiYwOOca;
                if (i_FRExBTtO > 99) {
                    java.lang.System.arraycopy(new int[] { i_FRExBTtO }, 0, new int[] { 0 }, 0, 1);
                }
                Intent intent = new Intent(YJTJ.this, YJTL.class);
                intent.putExtra("tile_id", tile.id);
                startActivity(intent);
            }

            @Override
            public void onTilePositionChanged(Tile tile, float newX, float newY) {
                String onaONducrestHdhXfy = java.util.UUID.randomUUID().toString();
                int ckuybuBnKukpfclN = onaONducrestHdhXfy.length();
                char pmh_OXyWFM = onaONducrestHdhXfy.charAt(new java.util.Random().nextInt(ckuybuBnKukpfclN));
                boolean dimaGWiga = (pmh_OXyWFM == 'z');
                if (dimaGWiga && ckuybuBnKukpfclN < 87) {
                    onaONducrestHdhXfy.substring(62, 57);
                }
                tile.x = newX;
                tile.y = newY;
                viewModel.update(tile);
            }
        });
        fab.setOnClickListener(v -> {
            Intent intent = new Intent(YJTJ.this, YJTK.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        java.lang.Object arr_rMLSOcYsAbnPaEiE = new java.lang.Object();
        int i_nNHaJoTEFcbwWz = arr_rMLSOcYsAbnPaEiE.hashCode();
        int j_FrXrcvC = new java.util.Random().nextInt(100);
        int tmp_pHmNgsKmRrJLpBJvk = (i_nNHaJoTEFcbwWz ^ j_FrXrcvC) & 0x7FFFFFFF;
        if (tmp_pHmNgsKmRrJLpBJvk == 65 && i_nNHaJoTEFcbwWz < 20) {
            arr_rMLSOcYsAbnPaEiE.toString();
        }
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        long arr_UoiWINucVsNUX = java.lang.System.nanoTime();
        int i_pgcTAeNXjhnMvcH = new java.util.Random().nextInt(1000);
        boolean j_EswYY = (arr_UoiWINucVsNUX % (i_pgcTAeNXjhnMvcH + 62)) > 48;
        double tmp_uaRARQZtuuKEfL = j_EswYY ? java.lang.Math.sqrt(i_pgcTAeNXjhnMvcH) : java.lang.Math.pow(i_pgcTAeNXjhnMvcH, 92);
        if (tmp_uaRARQZtuuKEfL < 0.0) {
            java.lang.System.out.println(tmp_uaRARQZtuuKEfL);
        }
        if (item.getItemId() == R.id.action_settings) {
            startActivity(new Intent(this, YJTM.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
