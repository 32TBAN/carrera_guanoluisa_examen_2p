package esteban.g.carrera_guanoluisa_examen_2p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import esteban.g.carrera_guanoluisa_examen_2p.Entidades.TareaCG;

public class BusinessTasksActivityCG extends AppCompatActivity {

    private EditText tareaCgEditText;
    private EditText notaCgEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_tasks_cg);
        tareaCgEditText = findViewById(R.id.tareaCg);
        notaCgEditText = findViewById(R.id.notaCG);

        findViewById(R.id.ivAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tarea = tareaCgEditText.getText().toString();
                String notas = notaCgEditText.getText().toString();

                TareaCG nuevaTarea = new TareaCG(tarea, notas);

                Intent intent = new Intent(BusinessTasksActivityCG.this, ListaTareasCG.class);
                intent.putExtra("tarea", nuevaTarea);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.iconDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}