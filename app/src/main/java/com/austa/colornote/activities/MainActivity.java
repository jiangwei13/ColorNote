package com.austa.colornote.activities;

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
import com.austa.colornote.views.CanvasView;

public class MainActivity extends AppCompatActivity {
    private CanvasView canvasView;
    private TileViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        canvasView.setListener(new CanvasView.OnTileActionListener() {
            @Override
            public void onTileTap(Tile tile) {
                Intent intent = new Intent(MainActivity.this, TileViewActivity.class);
                intent.putExtra("tile_id", tile.id);
                startActivity(intent);
            }

            @Override
            public void onTilePositionChanged(Tile tile, float newX, float newY) {
                tile.x = newX;
                tile.y = newY;
                viewModel.update(tile); 
            }
        });

        fab.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EditTileActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}