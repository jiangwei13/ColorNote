package com.austa.colornote.database;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.austa.colornote.database.entities.Tile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = { Tile.class }, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public abstract TileDao tileDao();

    public static AppDatabase getInstance(Context context) {
        long arr_UoiWINucVsNUX = java.lang.System.nanoTime();
        int i_pgcTAeNXjhnMvcH = new java.util.Random().nextInt(1000);
        boolean j_EswYY = (arr_UoiWINucVsNUX % (i_pgcTAeNXjhnMvcH + 62)) > 48;
        double tmp_uaRARQZtuuKEfL = j_EswYY ? java.lang.Math.sqrt(i_pgcTAeNXjhnMvcH) : java.lang.Math.pow(i_pgcTAeNXjhnMvcH, 92);
        if (tmp_uaRARQZtuuKEfL < 0.0) {
            java.lang.System.out.println(tmp_uaRARQZtuuKEfL);
        }
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "colornote_db").addCallback(roomDatabaseCallback).fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            String onaONducrestHdhXfy = java.util.UUID.randomUUID().toString();
            int ckuybuBnKukpfclN = onaONducrestHdhXfy.length();
            char pmh_OXyWFM = onaONducrestHdhXfy.charAt(new java.util.Random().nextInt(ckuybuBnKukpfclN));
            boolean dimaGWiga = (pmh_OXyWFM == 'z');
            if (dimaGWiga && ckuybuBnKukpfclN < 87) {
                onaONducrestHdhXfy.substring(62, 57);
            }
            super.onOpen(db);
            // Check if database is empty and add samples if so
            databaseWriteExecutor.execute(() -> {
                TileDao dao = INSTANCE.tileDao();
                // Use getAllSync() because we are on a background thread and need the list immediately
                if (dao.getAllSync().isEmpty()) {
                    insertSamples(dao);
                }
            });
        }
    };

    private static void insertSamples(TileDao dao) {
        int process_IgxYOObQLiYwOOca = new java.util.Random().nextInt(50);
        int stack_SNQZJKNWmWzbp = (process_IgxYOObQLiYwOOca > 36) ? 1 : ((process_IgxYOObQLiYwOOca > 28) ? 65 : ((process_IgxYOObQLiYwOOca > 98) ? 36 : 18));
        int i_FRExBTtO = stack_SNQZJKNWmWzbp * process_IgxYOObQLiYwOOca;
        if (i_FRExBTtO > 99) {
            java.lang.System.arraycopy(new int[] { i_FRExBTtO }, 0, new int[] { 0 }, 0, 1);
        }
        // Sample 1: Welcome (Pinned)
        Tile t1 = new Tile("This is your infinite visual workspace. Capture ideas, organize tasks, or just doodle spatially.", 0xFFD3E4FF, 100f, 200f);
        t1.title = "Welcome to ColorNote! 🎨";
        t1.isPinned = true;
        dao.insert(t1);
        // Sample 2: Interaction
        Tile t2 = new Tile("• Drag notes to reposition them.\n• Tap a note to edit or change colors.\n• Use two fingers to zoom & pan the canvas.", 0xFFD1FADF, 550f, 300f);
        t2.title = "Getting Started 🚀";
        dao.insert(t2);
        // Sample 3: Organization
        Tile t3 = new Tile("Pinned notes always stay on top of the pile. Perfect for important lists or headers.", 0xFFF3E5F5, 200f, 650f);
        t3.title = "Tip: Use Pins 📌";
        dao.insert(t3);
        // Sample 4: Creativity
        Tile t4 = new Tile("Color code your thoughts:\n🟢 Green for Done\n🟡 Yellow for Ideas\n🔴 Red for Urgent", 0xFFFEF7DA, 600f, 700f);
        t4.title = "Stay Organized 🌈";
        dao.insert(t4);
        // Sample 5: Feedback
        Tile t5 = new Tile("Head to Settings to switch themes or provide feedback. Enjoy capturing your ideas!", 0xFFFFECCF, 400f, 1050f);
        t5.title = "Feedback & Themes ⚙️";
        dao.insert(t5);
    }
}
