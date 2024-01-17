package esteban.g.carrera_guanoluisa_examen_2p.Entidades;
import java.io.Serializable;

public class TareaCG implements Serializable {
    private String tarea;
    private String notas;

    public TareaCG(String tarea, String notas) {
        this.tarea = tarea;
        this.notas = notas;
    }

    public String getTarea() {
        return tarea;
    }

    public String getNotas() {
        return notas;
    }
}

