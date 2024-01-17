// ListaTareasCG.java
package esteban.g.carrera_guanoluisa_examen_2p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import esteban.g.carrera_guanoluisa_examen_2p.Entidades.TareaCG;

public class ListaTareasCG extends AppCompatActivity {

    private LinearLayout personalTasksLayout;
    private LinearLayout businessTasksLayout;
    private static List<TareaCG> tareasList = new ArrayList<>();
    private static List<TareaCG> tareasListBusunes = new ArrayList<>();
    private static final int REQUEST_CODE_ADD_TASK = 1;
    private boolean isBusinessTask = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tareas_cg);

        personalTasksLayout = findViewById(R.id.personalTasksLayout);
        businessTasksLayout = findViewById(R.id.businessTasksLayout);

        if (getIntent().hasExtra("tarea")) {
            TareaCG nuevaTarea = (TareaCG) getIntent().getSerializableExtra("tarea");
            if (isBusinessTask){
                tareasListBusunes.add(nuevaTarea);
                agregarTarea(businessTasksLayout, nuevaTarea);
            }else{
                tareasList.add(nuevaTarea);
                agregarTarea(personalTasksLayout, nuevaTarea);
            }
        }
        findViewById(R.id.iconDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarTareasMarcadas();
            }
        });

        findViewById(R.id.ivAdd).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (isBusinessTask) {
                    Intent intent = new Intent(ListaTareasCG.this, BusinessTasksActivityCG.class);
                    startActivityForResult(intent,REQUEST_CODE_ADD_TASK);
                } else {
                    Intent intent = new Intent(ListaTareasCG.this, AgregarTareaActivityCG.class);
                    startActivityForResult(intent, REQUEST_CODE_ADD_TASK);
                }
            }
        });

        findViewById(R.id.tabPersonal).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                isBusinessTask = false;
                showPersonalTasks();
            }
        });

        findViewById(R.id.tabBusiness).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                isBusinessTask = true;
                showBusinesTasks();
            }
        });

        for (TareaCG tarea : tareasList) {
            agregarTarea(personalTasksLayout, tarea);
        }
    }

    private void agregarTarea(LinearLayout layout, TareaCG nuevaTarea) {
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

    private void showPersonalTasks() {
        personalTasksLayout.setVisibility(View.VISIBLE);
        businessTasksLayout.setVisibility(View.GONE);
    }

    private void showBusinesTasks() {
        personalTasksLayout.setVisibility(View.GONE);
        businessTasksLayout.setVisibility(View.VISIBLE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADD_TASK && resultCode == RESULT_OK) {
            TareaCG nuevaTarea = (TareaCG) data.getSerializableExtra("tarea");

            if (isBusinessTask) {
                tareasListBusunes.add(nuevaTarea);
                agregarTarea(businessTasksLayout, nuevaTarea);
            } else {
                tareasList.add(nuevaTarea);
                agregarTarea(personalTasksLayout, nuevaTarea);
            }
        }
    }
    private void eliminarTareasMarcadas() {

        if (isBusinessTask) {
            eliminarTareasMarcadas(businessTasksLayout, tareasListBusunes);
        } else {
            eliminarTareasMarcadas(personalTasksLayout, tareasList);
        }
    }

    private void eliminarTareasMarcadas(LinearLayout layout, List<TareaCG> listaTareas) {
        int childCount = layout.getChildCount();
        List<Integer> itemsToRemove = new ArrayList<>();

        for (int i = childCount - 1; i >= 0; i--) {
            View child = layout.getChildAt(i);
            if (child instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) child;
                if (checkBox.isChecked()) {
                    itemsToRemove.add(i / 3);
                }
            }
        }

        for (int position : itemsToRemove) {
            listaTareas.remove(position);
            layout.removeViews(position * 3, 3);
        }
    }

}
