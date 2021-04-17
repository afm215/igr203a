package com.example.carte.ui.Boissons;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carte.R;
import com.example.carte.ui.CustomAdapter;
import com.example.carte.ui.ItemData;

import java.util.ArrayList;
import java.util.Arrays;

public class BoissonsFragment extends Fragment {

    private String[] boissonsListe;
    private String[] drawablesListe;

    private RecyclerView recyclerView;
    private ArrayList<ItemData> itemArrayList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_boissons, container, false);

        boissonsListe = getResources().getStringArray(R.array.boissonsListe);
        drawablesListe = getResources().getStringArray(R.array.boissonsDrawable);
        recyclerView = root.findViewById(R.id.recyclerViewBoissons);

        // created new array list..
        itemArrayList = new ArrayList<>();
        for (int i=0;i<boissonsListe.length;i++){
            int resourceId = getResources().getIdentifier(drawablesListe[i], "drawable",getContext().getPackageName());
            itemArrayList.add(new ItemData(boissonsListe[i],resourceId));
        }

        // added data from arraylist to adapter class.
        CustomAdapter adapter=new CustomAdapter(itemArrayList);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return root;
    }
}