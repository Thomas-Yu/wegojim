package com.example.wegojim.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wegojim.R;
import com.example.wegojim.databinding.FragmentHomeBinding;
import com.example.wegojim.ui.AddWorkout;
import com.example.wegojim.ui.CreateWorkout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        List<String> list = new ArrayList<String>();
        list.add("Bench Press");
        list.add("Wide Grip Lat Pulldown");
        list.add("Shoulder Fly Superset");
        list.add("Preacher Curls");
        list.add("Cross Body Cable Extensions");

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this.getContext(), R.layout.textview, list);
        ListView exerciseList = (ListView) root.findViewById(R.id.workoutToday);
        exerciseList.setAdapter(itemsAdapter);

        Button btn = (Button) root.findViewById(R.id.selectWorkoutButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddWorkout.class);
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