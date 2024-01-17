package esteban.g.carrera_guanoluisa_examen_2p.Dal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseManagerCG extends SQLiteOpenHelper {
    final String CREATE_USERCG = "CREATE TABLE UsuariosCG (EMAILCG TEXT, " +
                                                            "PASSWORDCG TEXT)";
    final String DROP_TABLECG = "DROP TABLE IF EXISTS UsuariosCG";
    public DatabaseManagerCG(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USERCG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLECG);
        db.execSQL(CREATE_USERCG);
    }
}
