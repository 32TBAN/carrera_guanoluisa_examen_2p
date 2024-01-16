package esteban.g.carrera_guanoluisa_examen_2p.Dal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseManagerCG extends SQLiteOpenHelper {
    final String CREATE_CLIENTS = "CREATE TABLE UsuariosCG (EMAILCG TEXT, " +
                                                            "PASSWORDCG TEXT)";
    final String DROP_TABLE = "DROP TABLE IF EXISTS UsuariosCG";
    public DatabaseManagerCG(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // sql para definir la estructura de la BD.
        db.execSQL(CREATE_CLIENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // sql para realizar cambios en la estructura de la base datos
        db.execSQL(DROP_TABLE);
        db.execSQL(CREATE_CLIENTS);
    }
}
