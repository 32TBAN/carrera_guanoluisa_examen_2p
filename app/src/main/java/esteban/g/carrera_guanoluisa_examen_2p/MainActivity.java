package esteban.g.carrera_guanoluisa_examen_2p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                if (validarUsuarioeditTextPasswordCG(editTextUserCG.getText().toString(), editTextPasswordCG.getText().toString())) {

                } else {
                    Toast.makeText(MainActivity.this, "Error de validación", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validarUsuarioeditTextPasswordCG(String correo, String clave) {

        return true;
    }
}