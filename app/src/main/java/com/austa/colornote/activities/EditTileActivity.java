package com.austa.colornote.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.textfield.TextInputEditText;
import com.austa.colornote.R;
import com.austa.colornote.database.entities.Tile;
import com.austa.colornote.viewmodels.TileViewModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EditTileActivity extends AppCompatActivity {
    private TextInputEditText editTitle, editNote;
    private AutoCompleteTextView colorDropdown;
    private MaterialSwitch switchPin;
    private MaterialButton btnSave, btnDelete;
    private TextView tvLastModified;
    private TileViewModel viewModel;
    private Tile currentTile;
    private int tileId = -1;
    private boolean isFavorite = false;

    private static final int[] COLOR_RES_IDS = {
            R.color.tile_red,
            R.color.tile_blue,
            R.color.tile_green,
            R.color.tile_yellow,
            R.color.tile_purple,
            R.color.tile_orange
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tile);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());

        View root = findViewById(R.id.edit_root);
        View contentScroll = findViewById(R.id.content_scroll);

        ViewCompat.setOnApplyWindowInsetsListener(root, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            
            // Apply top padding to the toolbar/appbar
            View appBar = findViewById(R.id.app_bar_layout);
            if (appBar != null) {
                appBar.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
            }
            
            // Apply bottom padding to the scrollable content container
            if (contentScroll != null) {
                contentScroll.setPadding(0, 0, 0, systemBars.bottom);
            }
            
            return WindowInsetsCompat.CONSUMED;
        });

        editTitle = findViewById(R.id.edit_title);
        editNote = findViewById(R.id.edit_note);
        switchPin = findViewById(R.id.switch_pin);
        colorDropdown = findViewById(R.id.color_dropdown);
        btnSave = findViewById(R.id.btn_save);
        btnDelete = findViewById(R.id.btn_delete);
        tvLastModified = findViewById(R.id.tv_last_modified);

        viewModel = new ViewModelProvider(this).get(TileViewModel.class);

        String[] colors = getResources().getStringArray(R.array.tile_colors);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, colors);
        colorDropdown.setAdapter(adapter);

        tileId = getIntent().getIntExtra("tile_id", -1);
        if (tileId != -1) {
            viewModel.getTileById(tileId).observe(this, tile -> {
                if (tile != null && currentTile == null) {
                    currentTile = tile;
                    editTitle.setText(tile.title);
                    editNote.setText(tile.text);
                    switchPin.setChecked(tile.isPinned);
                    isFavorite = tile.isFavorite;
                    invalidateOptionsMenu();
                    
                    int index = getColorIndex(tile.color);
                    colorDropdown.setText(colors[index], false);
                    btnDelete.setVisibility(View.VISIBLE);
                    
                    updateLastModifiedText(tile.lastModified);
                }
            });
        }

        btnSave.setOnClickListener(v -> saveNote());
        btnDelete.setOnClickListener(v -> {
            if (currentTile != null) viewModel.delete(currentTile);
            finish();
        });
    }

    private void saveNote() {
        String titleText = editTitle.getText().toString().trim();
        String noteText = editNote.getText().toString().trim();
        if (noteText.isEmpty() && titleText.isEmpty()) {
            Toast.makeText(this, "Note cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        String selectedColorText = colorDropdown.getText().toString();
        int selectedIndex = 0;
        String[] colors = getResources().getStringArray(R.array.tile_colors);
        for (int i = 0; i < colors.length; i++) {
            if (colors[i].equals(selectedColorText)) {
                selectedIndex = i;
                break;
            }
        }
        int selectedColor = ContextCompat.getColor(this, COLOR_RES_IDS[selectedIndex]);

        if (currentTile == null) {
            Tile tile = new Tile(noteText, selectedColor, 100f, 100f);
            tile.title = titleText;
            tile.isPinned = switchPin.isChecked();
            tile.isFavorite = isFavorite;
            viewModel.insert(tile);
        } else {
            currentTile.title = titleText;
            currentTile.text = noteText;
            currentTile.color = selectedColor;
            currentTile.isPinned = switchPin.isChecked();
            currentTile.isFavorite = isFavorite;
            currentTile.lastModified = System.currentTimeMillis();
            viewModel.update(currentTile);
        }
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit_note, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem favItem = menu.findItem(R.id.action_favorite);
        if (favItem != null) {
            favItem.setIcon(isFavorite ? android.R.drawable.btn_star_big_on : android.R.drawable.btn_star_big_off);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_share) {
            shareNote();
            return true;
        } else if (id == R.id.action_favorite) {
            isFavorite = !isFavorite;
            invalidateOptionsMenu();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareNote() {
        String content = editTitle.getText().toString() + "\n\n" + editNote.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, content);
        startActivity(Intent.createChooser(intent, "Share Note"));
    }

    private void updateLastModifiedText(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault());
        tvLastModified.setText("Last modified: " + sdf.format(new Date(timestamp)));
    }

    private int getColorIndex(int colorValue) {
        for (int i = 0; i < COLOR_RES_IDS.length; i++) {
            if (ContextCompat.getColor(this, COLOR_RES_IDS[i]) == colorValue) return i;
        }
        return 0;
    }
}