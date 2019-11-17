package com.example.organizer;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.organizer.adapters.RVAdapter;
import com.example.organizer.model.Note;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private List<Note> notesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RVAdapter mAdapter;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        setColorBar();

        recyclerView = findViewById(R.id.recycler_view);
        mAdapter = new RVAdapter(notesList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);

        prepareMovieData();

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

        note = new Note("Goldfinger", "Action & Adventure", "1965");
        notesList.add(note);

        note = new Note("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        notesList.add(note);

        mAdapter.notifyDataSetChanged();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setColorBar() {
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(Color.rgb(12, 68, 248)));

        StatusBarColor statusBarColor = new StatusBarColor();
        Window window = getWindow();

        statusBarColor.changeStatusBarColor(window);
    }

    public void openAddNoteActivity(View view) {
        Intent intent = new Intent(this, activity_add_note.class);

        startActivity(intent);
    }

    public void openActivityToDos(View view) {
        Intent intent = new Intent(this, activity_todos.class);

        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
