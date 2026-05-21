package com.austa.colornote.database;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.austa.colornote.database.entities.Tile;
import java.util.List;

@Dao
public interface TileDao {
    @Query("SELECT * FROM tiles ORDER BY id DESC")
    LiveData<List<Tile>> getAll();

    @Query("SELECT * FROM tiles")
    List<Tile> getAllSync();

    @Insert
    void insert(Tile tile);

    @Update
    void update(Tile tile);

    @Delete
    void delete(Tile tile);

    @Query("SELECT * FROM tiles WHERE id = :id")
    LiveData<Tile> getById(int id);
    
    @Query("SELECT * FROM tiles WHERE id = :id")
    Tile getByIdSync(int id);
}