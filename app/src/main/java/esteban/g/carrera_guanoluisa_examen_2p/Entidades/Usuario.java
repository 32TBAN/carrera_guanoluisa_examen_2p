package esteban.g.carrera_guanoluisa_examen_2p.Entidades;

package uta.fisei.app_004.entities;

public class Usuario {

    private String usernameCG;
    private String password;

    public Usuario() {
    }

    public Usuario(String usernameCG, String password) {
        this.usernameCG = usernameCG;
        this.password = password;
    }

    public String getUsernameCG() {
        return usernameCG;
    }

    public void setUsernameCG(String usernameCG) {
        this.usernameCG = usernameCG;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
