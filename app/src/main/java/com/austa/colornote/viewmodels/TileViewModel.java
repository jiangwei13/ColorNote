package com.austa.colornote.viewmodels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.austa.colornote.database.AppDatabase;
import com.austa.colornote.database.entities.Tile;
import java.util.List;

public class TileViewModel extends AndroidViewModel {
    private AppDatabase db;
    private LiveData<List<Tile>> allTiles;

    public TileViewModel(Application application) {
        super(application);
        db = AppDatabase.getInstance(application);
        allTiles = db.tileDao().getAll();
    }

    public LiveData<List<Tile>> getAllTiles() {
        return allTiles;
    }

    public void insert(Tile tile) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            db.tileDao().insert(tile);
        });
    }

    public void update(Tile tile) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            db.tileDao().update(tile);
        });
    }

    public void delete(Tile tile) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            db.tileDao().delete(tile);
        });
    }

    public LiveData<Tile> getTileById(int id) {
        return db.tileDao().getById(id);
    }
}