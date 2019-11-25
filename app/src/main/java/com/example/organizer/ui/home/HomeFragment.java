package com.example.organizer.ui.home;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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
import com.example.organizer.utils.Constants;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private RVAdapter rvAdapter;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        Constants.DATABASE_REFERENCE_NOTES.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                RecyclerView recyclerView = root.findViewById(R.id.recycler_view);

                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

                rvAdapter = new RVAdapter(Note.notes);

                recyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getContext()), LinearLayoutManager.VERTICAL));

                recyclerView.setAdapter(rvAdapter);

                Note.notes.clear();

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Note.notes.add(postSnapshot.getValue(Note.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(null, databaseError.toException());
            }
        });

        return root;
    }
}

