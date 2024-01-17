package esteban.g.carrera_guanoluisa_examen_2p;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonalTaskAdapter extends RecyclerView.Adapter<PersonalTaskAdapter.PersonalTaskViewHolder> {

    private List<Task> personalTaskList;
    private OnItemClickListener onItemClickListener;

    public PersonalTaskAdapter(List<Task> personalTaskList) {
        this.personalTaskList = personalTaskList;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public PersonalTaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_personal_taskcg, parent, false);

        return new PersonalTaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonalTaskViewHolder holder, int position) {
        Task currentTask = personalTaskList.get(position);

        // Configura los datos en el elemento de la lista
        holder.textViewTaskName.setText(currentTask.getName());
        holder.checkBoxTaskCompleted.setChecked(currentTask.isCompleted());

        // Maneja el clic en el elemento de la lista
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return personalTaskList.size();
    }

    public static class PersonalTaskViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTaskName;
        public CheckBox checkBoxTaskCompleted;

        public PersonalTaskViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTaskName = itemView.findViewById(R.id.textViewTaskName);
            checkBoxTaskCompleted = itemView.findViewById(R.id.checkBoxTaskCompleted);
        }
    }
}
