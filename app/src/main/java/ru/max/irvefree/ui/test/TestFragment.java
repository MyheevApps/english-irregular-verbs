package ru.max.irvefree.ui.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import ru.max.irvefree.R;

public class TestFragment extends Fragment {

    private ListView lvLevels;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_test, container, false);
        lvLevels = (ListView) root.findViewById(R.id.lvLevels);

        List<String> lvList = new ArrayList<>();
        lvList.add("Elementary");
        lvList.add("Pre-intermediate");
        lvList.add("Intermediate");
        lvList.add("Upper-intermediate");
        lvList.add("Advanced");
        lvList.add("Proficiency");
        lvList.add("Marathon");
        lvList.add("Deprecated");

        LevelAdapter adapter = new LevelAdapter(lvList);
        lvLevels.setAdapter(adapter);
        return root;
    }

}
