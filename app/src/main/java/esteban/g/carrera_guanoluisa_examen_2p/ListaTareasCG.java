package esteban.g.carrera_guanoluisa_examen_2p;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ListaTareasCG extends AppCompatActivity {

    private LinearLayout personalTasksLayout;
    private LinearLayout businessTasksLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tareas_cg);

        personalTasksLayout = findViewById(R.id.personalTasksLayout);
        businessTasksLayout = findViewById(R.id.businessTasksLayout);

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

    private void showPersonalTasks() {
        personalTasksLayout.setVisibility(View.VISIBLE);
        businessTasksLayout.setVisibility(View.GONE);
    }

    private void showBusinessTasks() {
        personalTasksLayout.setVisibility(View.GONE);
        businessTasksLayout.setVisibility(View.VISIBLE);
    }
}
