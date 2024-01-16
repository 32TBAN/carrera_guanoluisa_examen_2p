package esteban.g.carrera_guanoluisa_examen_2p.Logica;

import java.util.List;

import esteban.g.carrera_guanoluisa_examen_2p.Dal.DalUsuarioCG;
import esteban.g.carrera_guanoluisa_examen_2p.Entidades.UsuarioCG;

public class UsurioLogicaCG {

    public static List<UsuarioCG> getListUsuarios() {
        return DalUsuarioCG.getListUsuarios();
    }
}
