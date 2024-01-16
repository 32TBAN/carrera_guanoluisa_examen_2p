package esteban.g.carrera_guanoluisa_examen_2p.Entidades;

public class UsuarioCG {

    private String emailCG;
    private String password;

    public UsuarioCG() {
    }

    public UsuarioCG(String usernameCG, String password) {
        this.emailCG = usernameCG;
        this.password = password;
    }

    public String getUsernameCG() {
        return emailCG;
    }

    public void setUsernameCG(String usernameCG) {
        this.emailCG = usernameCG;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
