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

        int emailIndex = cursor.getColumnIndex("EMAILCG");
        int passwordIndex = cursor.getColumnIndex("PASSWORDCG");

        while (cursor.moveToNext()) {
            String emailCG = cursor.getString(emailIndex);
            String passwordCG = cursor.getString(passwordIndex);

            UsuarioCG usuario = new UsuarioCG(emailCG, passwordCG);
            usuarios.add(usuario);
        }

        cursor.close();
        sqLiteDatabase.close();

        return usuarios;
    }


    public void insert() {
        sqLiteDatabase = databaseManagerCG.getWritableDatabase();

        String insertQuery1 = "INSERT INTO UsuariosCG (EMAILCG, PASSWORDCG) VALUES ('steven@gmail.com', 'Mi34!@')";
        sqLiteDatabase.execSQL(insertQuery1);

        String insertQuery2 = "INSERT INTO UsuariosCG (EMAILCG, PASSWORDCG) VALUES ('esteban@gmail.com', 'Se12@@')";
        sqLiteDatabase.execSQL(insertQuery2);

        sqLiteDatabase.close();
    }
}
