package esteban.g.carrera_guanoluisa_examen_2p;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class ListaTareasCG extends AppCompatActivity {
    private RecyclerView recyclerViewPersonal;
    private RecyclerView recyclerViewBusiness;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerViewPersonal = findViewById(R.id.recyclerViewPersonal);
        recyclerViewBusiness = findViewById(R.id.recyclerViewBusiness);

        showPersonalTasks();
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
        recyclerViewPersonal.setVisibility(View.VISIBLE);
        recyclerViewBusiness.setVisibility(View.GONE);

        PersonalTaskAdapterCG personalTaskAdapter = new PersonalTaskAdapterCG(/* ... */);
        personalTaskAdapter.setOnItemClickListener(new PersonalTaskAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Maneja el clic en una tarea personal
                openEditTaskActivity(position);
            }
        });
        recyclerViewPersonal.setAdapter(personalTaskAdapter);
    }

    private void showBusinessTasks() {
        recyclerViewPersonal.setVisibility(View.GONE);
        recyclerViewBusiness.setVisibility(View.VISIBLE);
    }
}