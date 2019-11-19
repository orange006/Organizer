package com.example.organizer.ui.home;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.organizer.R;
import com.example.organizer.adapters.RVAdapter;
import com.example.organizer.model.Note;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private RVAdapter rvAdapter;
    private List<Note> notesList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        rvAdapter = new RVAdapter(notesList);

        recyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getContext()), LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(rvAdapter);

        prepareMovieData();

        return root;
    }

    private void prepareMovieData() {
        Note note = new Note("Mad Max: Fury Road", "Action & Adventure", "2015");
        notesList.add(note);

        note = new Note("Inside Out", "Animation, Kids & Family", "2015");
        notesList.add(note);

        note = new Note("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        notesList.add(note);

        note = new Note("Shaun the Sheep", "Animation", "2015");
        notesList.add(note);

        note = new Note("The Martian", "Science Fiction & Fantasy", "2015");
        notesList.add(note);

        note = new Note("Mission: Impossible Rogue Nation", "Action", "2015");
        notesList.add(note);

        note = new Note("Up", "Animation", "2009");
        notesList.add(note);

        note = new Note("Star Trek", "Science Fiction", "2009");
        notesList.add(note);

        note = new Note("The LEGO Movie", "Animation", "2014");
        notesList.add(note);

        note = new Note("Iron Man", "Action & Adventure", "2008");
        notesList.add(note);

        note = new Note("Aliens", "Science Fiction", "1986");
        notesList.add(note);

        note = new Note("Chicken Run", "Animation", "2000");
        notesList.add(note);

        note = new Note("Back to the Future", "Science Fiction", "1985");
        notesList.add(note);

        note = new Note("Raiders of the Lost Ark", "Action & Adventure", "1981");
        notesList.add(note);

        note = new Note("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        notesList.add(note);

        rvAdapter.notifyDataSetChanged();
    }
}

