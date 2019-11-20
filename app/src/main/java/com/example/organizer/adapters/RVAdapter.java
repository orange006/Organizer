package com.example.organizer.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.organizer.R;
import com.example.organizer.model.Note;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {

    private List<Note> notesList;

    class MyViewHolder extends RecyclerView.ViewHolder {
         private TextView content;
         private TextView date;
         private TextView category;

         MyViewHolder(View view) {
            super(view);
            content = view.findViewById(R.id.rvContent);
            date = view.findViewById(R.id.rvDate);
            category = view.findViewById(R.id.rvCategory);
         }
    }

    public RVAdapter(List<Note> notesList) {
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Note note = notesList.get(position);

        if(note.getContent().length() < 15) {
            holder.content.setText(note.getContent());
        }
        else {
            String tempContent = note.getContent().substring(0, 15) + "...";
            holder.content.setText(tempContent);
        }

        holder.date.setText(note.getDate());
        holder.category.setText(note.getCategory());
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }
}
