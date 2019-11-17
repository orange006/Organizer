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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private List<Note> notes;
    private static RecyclerView recyclerView;

    private static RVAdapter adapter;

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

        notes = new ArrayList<>();
        Note note = new Note("time", "Life", "content");
        Note note2 = new Note("time2", "Life2", "content2");
        notes.add(note);
        notes.add(note2);

        try {
            recyclerView = this.findViewById(R.id.recViewNote);
            recyclerView.setHasFixedSize(true);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            adapter = new RVAdapter(this, notes);
            recyclerView.setAdapter(adapter);

        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setColorBar() {
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(Color.rgb(12, 68, 248)));

        StatusBarColor statusBarColor = new StatusBarColor();
        Window window = getWindow();

        statusBarColor.changeStatusBarColor("blue", window);
    }

    public void TEST(View view) {
        String q = Note.notes.get(0).toString();
        TextView tv = findViewById(R.id.textView);
        tv.setText(q);
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
