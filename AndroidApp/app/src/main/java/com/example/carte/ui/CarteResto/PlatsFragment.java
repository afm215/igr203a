package com.example.carte.ui.CarteResto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carte.R;
import com.example.carte.ui.CustomAdapter;
import com.example.carte.ui.ItemData;

import java.util.ArrayList;

public class PlatsFragment extends Fragment {

    private String[] platsListe;
    private String[] drawablesListe;

    private RecyclerView recyclerView;
    private ArrayList<ItemData> itemArrayList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_plats, container, false);

        platsListe = getResources().getStringArray(R.array.platsListe);
        drawablesListe = getResources().getStringArray(R.array.platsDrawable);

        recyclerView = root.findViewById(R.id.recyclerViewCarte);


        // created new array list..
        itemArrayList = new ArrayList<>();
        for (int i=0;i<platsListe.length;i++){
            int resourceId = getResources().getIdentifier(drawablesListe[i], "drawable",getContext().getPackageName());
            itemArrayList.add(new ItemData(platsListe[i],resourceId));
        }

        // added data from arraylist to adapter class.
        CustomAdapter adapter=new CustomAdapter(itemArrayList,getContext());

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return root;
    }
}