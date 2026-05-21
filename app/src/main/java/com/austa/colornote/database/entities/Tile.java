package com.austa.colornote.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tiles")
public class Tile {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String title;
    public String text;
    public int color;
    public float x;
    public float y;
    public long createdAt;
    public long lastModified;
    public boolean isPinned;
    public boolean isFavorite;

    public Tile(String text, int color, float x, float y) {
        this.title = "";
        this.text = text;
        this.color = color;
        this.x = x;
        this.y = y;
        this.createdAt = System.currentTimeMillis();
        this.lastModified = System.currentTimeMillis();
        this.isPinned = false;
        this.isFavorite = false;
    }
}