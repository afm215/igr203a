package com.example.carte.ui.CarteResto;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carte.MainActivity;
import com.example.carte.R;
import com.example.carte.ui.CustomAdapter;
import com.example.carte.ui.ItemData;

import java.util.ArrayList;

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
        recyclerView = root.findViewById(R.id.recyclerViewCarte);


        // created new array list..
        itemArrayList = new ArrayList<>();
        for (int i=0;i<boissonsListe.length;i++){
            int resourceId = getResources().getIdentifier(drawablesListe[i], "drawable",getContext().getPackageName());
            itemArrayList.add(new ItemData(boissonsListe[i],resourceId));
        }

        // added data from arraylist to adapter class.
        CustomAdapter adapter=new CustomAdapter(itemArrayList,getContext(),0);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        ArrayList<Integer> listOfResources = new ArrayList<>();
        for (int i=0;i<boissonsListe.length;i++){
            int resourceId = getResources().getIdentifier(drawablesListe[i], "drawable", getContext().getPackageName());
            listOfResources.add(resourceId);
        }

        EditText editResearch  = ((MainActivity) getActivity()).searchfield;
        editResearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // created new array list..
                itemArrayList = new ArrayList<>();
                for (int i=0;i<boissonsListe.length;i++){
                    if (boissonsListe[i].toLowerCase().contains(s.toString().trim().toLowerCase())) {
                        int resourceId = listOfResources.get(i);
                        itemArrayList.add(new ItemData(boissonsListe[i], resourceId));
                    }
                }

                // added data from arraylist to adapter class.
                CustomAdapter adapter=new CustomAdapter(itemArrayList,getContext(),0);

                recyclerView.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return root;
    }
}