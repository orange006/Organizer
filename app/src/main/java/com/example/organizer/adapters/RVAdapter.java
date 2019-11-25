package com.example.organizer.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.organizer.R;
import com.example.organizer.activities.activity_edit_note;
import com.example.organizer.model.Note;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {

    private List<Note> notesList;
    private Context context;

    public RVAdapter(Context context, List<Note> notesList) {
        this.notesList = notesList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
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

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, activity_edit_note.class);

                intent.putExtra("content_name", notesList.get(position).getContent());
                intent.putExtra("date_name", notesList.get(position).getDate());
                intent.putExtra("category_name", notesList.get(position).getCategory());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView content;
        private TextView date;
        private TextView category;
        private RelativeLayout parentLayout;

        MyViewHolder(View view) {
            super(view);
            content = view.findViewById(R.id.rvContent);
            date = view.findViewById(R.id.rvDate);
            category = view.findViewById(R.id.rvCategory);
            parentLayout = view.findViewById(R.id.note_list_row_id);
        }
    }
}
