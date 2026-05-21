package com.austa.colornote.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.austa.colornote.R;
import com.austa.colornote.database.entities.Tile;
import com.austa.colornote.viewmodels.TileViewModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TileViewActivity extends AppCompatActivity {
    private TextView tvTitle, tvContent, tvInfo;
    private TileViewModel viewModel;
    private Tile currentTile;
    private int tileId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tile_view);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());

        View root = findViewById(R.id.view_root);
        View contentContainer = findViewById(R.id.content_container);
        FloatingActionButton fabEdit = findViewById(R.id.fab_edit);

        ViewCompat.setOnApplyWindowInsetsListener(root, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            
            View appBar = findViewById(R.id.app_bar_layout);
            if (appBar != null) {
                appBar.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
            }
            
            if (contentContainer != null) {
                contentContainer.setPadding(0, 0, 0, systemBars.bottom);
            }
            
            ViewGroup.MarginLayoutParams fabParams = (ViewGroup.MarginLayoutParams) fabEdit.getLayoutParams();
            int margin24dp = (int) (24 * getResources().getDisplayMetrics().density);
            fabParams.bottomMargin = margin24dp + systemBars.bottom;
            fabEdit.setLayoutParams(fabParams);

            return WindowInsetsCompat.CONSUMED;
        });

        tvTitle = findViewById(R.id.tv_title);
        tvContent = findViewById(R.id.tv_content);
        tvInfo = findViewById(R.id.tv_info);

        viewModel = new ViewModelProvider(this).get(TileViewModel.class);

        tileId = getIntent().getIntExtra("tile_id", -1);
        if (tileId != -1) {
            viewModel.getTileById(tileId).observe(this, tile -> {
                if (tile != null) {
                    currentTile = tile;
                    displayTile(tile);
                } else {
                    // If the note is deleted while we are viewing it (e.g. from edit screen), close the viewer
                    finish();
                }
            });
        } else {
            finish();
        }

        fabEdit.setOnClickListener(v -> {
            Intent intent = new Intent(this, EditTileActivity.class);
            intent.putExtra("tile_id", tileId);
            startActivity(intent);
        });
    }

    private void displayTile(Tile tile) {
        if (tile.title != null && !tile.title.isEmpty()) {
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setText(tile.title);
        } else {
            tvTitle.setVisibility(View.GONE);
        }
        
        tvContent.setText(tile.text);
        
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault());
        String created = getString(R.string.created_at, sdf.format(new Date(tile.createdAt)));
        String modified = getString(R.string.last_modified_at, sdf.format(new Date(tile.lastModified)));
        tvInfo.setText(created + "\n" + modified);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tile_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_share) {
            shareNote();
            return true;
        } else if (id == R.id.action_delete) {
            if (currentTile != null) {
                viewModel.delete(currentTile);
                finish();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareNote() {
        if (currentTile == null) return;
        String content = (currentTile.title != null ? currentTile.title : "") + "\n\n" + currentTile.text;
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, content.trim());
        startActivity(Intent.createChooser(intent, getString(R.string.share_note)));
    }
}