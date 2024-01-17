package esteban.g.carrera_guanoluisa_examen_2p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
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

        validarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DalUsuarioCG dalUsuarioCG = new DalUsuarioCG(MainActivity.this);
                dalUsuarioCG.insert();
                if (validarUsuarioeditTextPasswordCG(editTextPasswordCG.getText().toString())) {
                    List<UsuarioCG> listaUsuarioCG = UsurioLogicaCG.getListUsuarios(MainActivity.this);
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