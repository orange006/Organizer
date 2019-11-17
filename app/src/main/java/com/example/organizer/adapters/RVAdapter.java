package com.example.organizer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.organizer.R;
import com.example.organizer.model.Note;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder>{

    private LayoutInflater inflater;
    private List<Note> notes;

    public RVAdapter(Context context, List<Note> phones) {
        this.notes = phones;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.layout_listitem, parent, false);

        //View view = inflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RVAdapter.ViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.contentNote.setText(note.getContent());
        holder.dateNote.setText(note.getDate());
        holder.categoryNote.setText(note.getCategory());
    }

    @Override
    public int getItemCount() {
        int size;

        if(notes != null && !notes.isEmpty()) {
            size = notes.size();
        }
        else {
            size = 0;
        }

        return size;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView contentNote;
        private TextView dateNote;
        private TextView categoryNote;

        ViewHolder(View view){
            super(view);
            contentNote = view.findViewById(R.id.contentNote);
            dateNote = view.findViewById(R.id.dateNote);
            categoryNote = view.findViewById(R.id.categoryNote);
        }
    }
}
