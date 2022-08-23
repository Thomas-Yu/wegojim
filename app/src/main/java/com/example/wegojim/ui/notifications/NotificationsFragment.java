package com.example.wegojim.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wegojim.MainActivity;
import com.example.wegojim.R;
import com.example.wegojim.databinding.FragmentNotificationsBinding;
import com.example.wegojim.ui.CreateWorkout;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        List<String> list = new ArrayList<String>();
        list.add("Day 1 Upper");
        list.add("Day 2 Lower");
        list.add("Day 3 Upper");
        list.add("Rest Day");
        list.add("Day 4 Lower");
        list.add("Day 5 Upper");
        list.add("Rest Day");

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this.getContext(), R.layout.textview, list);
        ListView exerciseList = (ListView) root.findViewById(R.id.workoutList);
        exerciseList.setAdapter(itemsAdapter);

        Button btn = (Button) root.findViewById(R.id.createWorkoutButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateWorkout.class);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}