package esteban.g.carrera_guanoluisa_examen_2p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUser, editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUser = findViewById(R.id.etUsuario);
        editTextPassword = findViewById(R.id.etContraseña);

        Button validarButton = findViewById(R.id.btnIniciarSesion);

        validarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validarUsuario(correoEditText.getText().toString(), claveEditText.getText().toString())) {
                    Intent intent = new Intent(ValidationActivity.this, TaskListActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(ValidationActivity.this, "Error de validación", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}