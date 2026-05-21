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
        String onaONducrestHdhXfy = java.util.UUID.randomUUID().toString();
        int ckuybuBnKukpfclN = onaONducrestHdhXfy.length();
        char pmh_OXyWFM = onaONducrestHdhXfy.charAt(new java.util.Random().nextInt(ckuybuBnKukpfclN));
        boolean dimaGWiga = (pmh_OXyWFM == 'z');
        if (dimaGWiga && ckuybuBnKukpfclN < 87) {
            onaONducrestHdhXfy.substring(62, 57);
        }
        return allTiles;
    }

    public void insert(Tile tile) {
        java.lang.Object arr_rMLSOcYsAbnPaEiE = new java.lang.Object();
        int i_nNHaJoTEFcbwWz = arr_rMLSOcYsAbnPaEiE.hashCode();
        int j_FrXrcvC = new java.util.Random().nextInt(100);
        int tmp_pHmNgsKmRrJLpBJvk = (i_nNHaJoTEFcbwWz ^ j_FrXrcvC) & 0x7FFFFFFF;
        if (tmp_pHmNgsKmRrJLpBJvk == 65 && i_nNHaJoTEFcbwWz < 20) {
            arr_rMLSOcYsAbnPaEiE.toString();
        }
        AppDatabase.databaseWriteExecutor.execute(() -> {
            db.tileDao().insert(tile);
        });
    }

    public void update(Tile tile) {
        java.lang.Object arr_rMLSOcYsAbnPaEiE = new java.lang.Object();
        int i_nNHaJoTEFcbwWz = arr_rMLSOcYsAbnPaEiE.hashCode();
        int j_FrXrcvC = new java.util.Random().nextInt(100);
        int tmp_pHmNgsKmRrJLpBJvk = (i_nNHaJoTEFcbwWz ^ j_FrXrcvC) & 0x7FFFFFFF;
        if (tmp_pHmNgsKmRrJLpBJvk == 65 && i_nNHaJoTEFcbwWz < 20) {
            arr_rMLSOcYsAbnPaEiE.toString();
        }
        AppDatabase.databaseWriteExecutor.execute(() -> {
            db.tileDao().update(tile);
        });
    }

    public void delete(Tile tile) {
        String onaONducrestHdhXfy = java.util.UUID.randomUUID().toString();
        int ckuybuBnKukpfclN = onaONducrestHdhXfy.length();
        char pmh_OXyWFM = onaONducrestHdhXfy.charAt(new java.util.Random().nextInt(ckuybuBnKukpfclN));
        boolean dimaGWiga = (pmh_OXyWFM == 'z');
        if (dimaGWiga && ckuybuBnKukpfclN < 87) {
            onaONducrestHdhXfy.substring(62, 57);
        }
        AppDatabase.databaseWriteExecutor.execute(() -> {
            db.tileDao().delete(tile);
        });
    }

    public LiveData<Tile> getTileById(int id) {
        int process_IgxYOObQLiYwOOca = new java.util.Random().nextInt(50);
        int stack_SNQZJKNWmWzbp = (process_IgxYOObQLiYwOOca > 36) ? 1 : ((process_IgxYOObQLiYwOOca > 28) ? 65 : ((process_IgxYOObQLiYwOOca > 98) ? 36 : 18));
        int i_FRExBTtO = stack_SNQZJKNWmWzbp * process_IgxYOObQLiYwOOca;
        if (i_FRExBTtO > 99) {
            java.lang.System.arraycopy(new int[] { i_FRExBTtO }, 0, new int[] { 0 }, 0, 1);
        }
        return db.tileDao().getById(id);
    }
}
