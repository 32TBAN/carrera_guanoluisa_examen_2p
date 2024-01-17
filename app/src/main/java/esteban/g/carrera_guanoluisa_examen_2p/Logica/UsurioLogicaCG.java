package esteban.g.carrera_guanoluisa_examen_2p.Logica;

import android.content.Context;

import java.util.List;

import esteban.g.carrera_guanoluisa_examen_2p.Dal.DalUsuarioCG;
import esteban.g.carrera_guanoluisa_examen_2p.Entidades.UsuarioCG;

public class UsurioLogicaCG {


    public static List<UsuarioCG> getListUsuarios(Context context) {
        DalUsuarioCG dalUsuarioCG = new DalUsuarioCG(context);
        return dalUsuarioCG.getListUsuarios();
    }
}
