package esteban.g.carrera_guanoluisa_examen_2p.Dal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import esteban.g.carrera_guanoluisa_examen_2p.Entidades.UsuarioCG;

public class DalUsuarioCG {
    private DatabaseManagerCG databaseManagerCG;
    private SQLiteDatabase sqLiteDatabase;
    private Context context;

    public DalUsuarioCG(Context context) {
        this.context = context;
        this.databaseManagerCG = new DatabaseManagerCG(context,"UsuariosCG",null,1);
    }

    public List<UsuarioCG> getListUsuarios() {
        List<UsuarioCG> usuarios = new ArrayList<>();

        sqLiteDatabase = databaseManagerCG.getReadableDatabase();

        String query = "SELECT EMAILCG, PASSWORDCG FROM UsuariosCG";

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String emailCG = cursor.getString(cursor.getColumnIndex("email"));
                @SuppressLint("Range") String passwordCG = cursor.getString(cursor.getColumnIndex("password"));

                UsuarioCG usuario = new UsuarioCG(emailCG, passwordCG);
                usuarios.add(usuario);
            } while (cursor.moveToNext());
        }

        cursor.close();
        sqLiteDatabase.close();

        return usuarios;
    }

    public void insert() {

    }
}
