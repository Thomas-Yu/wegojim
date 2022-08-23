package com.example.wegojim.ui.dashboard;

import com.example.wegojim.R;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wegojim.databinding.FragmentDashboardBinding;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private ListView exerciseList;
    protected ArrayList<String> exerciseNames;
    private Object TextView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //  <-------My code------->

        exerciseNames = new ArrayList<>();

        final EditText edittext = (EditText) root.findViewById(R.id.enterExercise);
        edittext.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    String temp = edittext.getText().toString();
                    exerciseNames.add(temp);
                    return true;
                }
                return false;
            }
        });

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this.getContext(), R.layout.textview, exerciseNames);
        exerciseList = (ListView) root.findViewById(R.id.exerciseList);
        exerciseList.setAdapter(itemsAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}