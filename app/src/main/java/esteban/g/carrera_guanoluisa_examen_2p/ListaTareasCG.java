package esteban.g.carrera_guanoluisa_examen_2p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import esteban.g.carrera_guanoluisa_examen_2p.Entidades.TareaCG;

public class ListaTareasCG extends AppCompatActivity {

    private LinearLayout personalTasksLayout;
    private LinearLayout businessTasksLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tareas_cg);

        personalTasksLayout = findViewById(R.id.personalTasksLayout);
        businessTasksLayout = findViewById(R.id.businessTasksLayout);

        // Verifica si hay una tarea enviada
        if (getIntent().hasExtra("tarea")) {
            TareaCG nuevaTarea = (TareaCG) getIntent().getSerializableExtra("tarea");
            agregarTarea(personalTasksLayout, nuevaTarea);
        }

        findViewById(R.id.ivAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaTareasCG.this, AgregarTareaActivityCG.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.tabPersonal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPersonalTasks();
            }
        });

        findViewById(R.id.tabBusiness).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBusinessTasks();
            }
        });
    }

    private void agregarTarea(LinearLayout layout, TareaCG nuevaTarea) {
        if (layout.getChildCount() == 0) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(nuevaTarea.getTarea());

            TextView tareaTextView = new TextView(this);
            tareaTextView.setText(nuevaTarea.getTarea());

            TextView notasTextView = new TextView(this);
            notasTextView.setText(nuevaTarea.getNotas());

            layout.addView(checkBox);
            layout.addView(tareaTextView);
            layout.addView(notasTextView);
        }
    }

    private void showPersonalTasks() {
        personalTasksLayout.setVisibility(View.VISIBLE);
        businessTasksLayout.setVisibility(View.GONE);
    }

    private void showBusinessTasks() {
        personalTasksLayout.setVisibility(View.GONE);
        businessTasksLayout.setVisibility(View.VISIBLE);
    }
}
