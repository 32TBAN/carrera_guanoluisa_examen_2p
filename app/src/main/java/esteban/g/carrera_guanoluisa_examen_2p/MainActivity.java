package esteban.g.carrera_guanoluisa_examen_2p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import esteban.g.carrera_guanoluisa_examen_2p.Dal.DalUsuarioCG;
import esteban.g.carrera_guanoluisa_examen_2p.Entidades.UsuarioCG;
import esteban.g.carrera_guanoluisa_examen_2p.Logica.UsurioLogicaCG;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUserCG, editTextPasswordCG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUserCG = findViewById(R.id.etUsuarioCG);
        editTextPasswordCG = findViewById(R.id.etContraseñaCG);

        Button validarButton = findViewById(R.id.btnIniciarSesionCG);
        TextView tvInfoLoginCG = findViewById(R.id.tvInfoLoginCG);
        List<UsuarioCG> listaUsuarioCG = UsurioLogicaCG.getListUsuarios(MainActivity.this);

        String usuario1Info = String.format("User 1: %s, Password: %s\n",
                listaUsuarioCG.get(0).getUsernameCG(), listaUsuarioCG.get(0).getPassword());

        String usuario2Info = String.format("User 2: %s, Password: %s\n",
                listaUsuarioCG.get(1).getUsernameCG(), listaUsuarioCG.get(1).getPassword());

        tvInfoLoginCG.setText(usuario1Info + usuario2Info);

        validarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DalUsuarioCG dalUsuarioCG = new DalUsuarioCG(MainActivity.this);
                //dalUsuarioCG.insert();
                if (validarUsuarioeditTextPasswordCG(editTextPasswordCG.getText().toString())) {

                    for (int i = 0; i < listaUsuarioCG.toArray().length; i++) {
                        String contra = listaUsuarioCG.get(i).getPassword();
                        String user = listaUsuarioCG.get(i).getUsernameCG();
                        String textContra = editTextPasswordCG.getText().toString();
                        String tectUser = editTextUserCG.getText().toString();
                        if (user.equals(tectUser) && contra.equals(textContra)) {
                            Intent intent = new Intent(MainActivity.this, ListaTareasCG.class);
                            startActivity(intent);
                            break;
                        } else {
                            Toast.makeText(MainActivity.this, "Contrasenia o usuarios incorectos", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Error de validación", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validarUsuarioeditTextPasswordCG(String passwordCG) {
        String regexCG = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d.*\\d)(?=.*[@#$%^&+=])(?=\\S+$).{6,}$";
        Pattern patternCG = Pattern.compile(regexCG);
        Matcher matcherCG = patternCG.matcher(passwordCG);

        if (matcherCG.matches()) {
            return true;
        } else {
            Toast.makeText(MainActivity.this, "La contraseña no cumple con los requisitos", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}