package com.example.carte.ui.Menus;

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

public class Menu1Fragment extends Fragment {

    private String[] listeEntree;
    private String[] listeDessert;
    private String[] listePlats;
    private String[] entreeDrawable;
    private String[] platDrawable;
    private String[] dessertDrawable;

    private RecyclerView recyclerViewEntree;
    private RecyclerView recyclerViewPlats;
    private RecyclerView recyclerViewDessert;
    private ArrayList<ItemData> itemArrayList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_menu1, container, false);

        listeEntree = getResources().getStringArray(R.array.menu1entrees);
        entreeDrawable = getResources().getStringArray(R.array.menu1entreesDrawable);

        recyclerViewEntree = root.findViewById(R.id.recyclerViewMenuEntree);

        // created new array list..
        itemArrayList = new ArrayList<>();
        for (int i=0;i<listeEntree.length;i++){
            int resourceId = getResources().getIdentifier(entreeDrawable[i], "drawable", getContext().getPackageName());
            itemArrayList.add(new ItemData(listeEntree[i],resourceId));
        }

        // added data from arraylist to adapter class.
        CustomAdapter adapter=new CustomAdapter(itemArrayList,getContext(),1);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);

        // at last set adapter to recycler view.
        recyclerViewEntree.setLayoutManager(layoutManager);
        recyclerViewEntree.setAdapter(adapter);

        listePlats = getResources().getStringArray(R.array.menu1plats);
        platDrawable = getResources().getStringArray(R.array.menu1platsDrawable);

        recyclerViewPlats = root.findViewById(R.id.recyclerViewMenuPlat);

        // created new array list..
        itemArrayList = new ArrayList<>();
        for (int i=0;i<listePlats.length;i++){
            int resourceId = getResources().getIdentifier(platDrawable[i], "drawable", getContext().getPackageName());
            itemArrayList.add(new ItemData(listePlats[i],resourceId));
        }

        // added data from arraylist to adapter class.
        CustomAdapter adapter2=new CustomAdapter(itemArrayList,getContext(),1);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager2=new GridLayoutManager(getContext(),2);

        // at last set adapter to recycler view.
        recyclerViewPlats.setLayoutManager(layoutManager2);
        recyclerViewPlats.setAdapter(adapter2);

        listeDessert = getResources().getStringArray(R.array.menu1desserts);
        dessertDrawable = getResources().getStringArray(R.array.menu1dessertsDrawable);

        recyclerViewDessert = root.findViewById(R.id.recyclerViewMenuDessert);

        // created new array list..
        itemArrayList = new ArrayList<>();
        for (int i=0;i<listeDessert.length;i++){
            int resourceId = getResources().getIdentifier(dessertDrawable[i], "drawable", getContext().getPackageName());
            itemArrayList.add(new ItemData(listeDessert[i],resourceId));
        }

        // added data from arraylist to adapter class.
        CustomAdapter adapter3=new CustomAdapter(itemArrayList,getContext(),1);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager3=new GridLayoutManager(getContext(),2);

        // at last set adapter to recycler view.
        recyclerViewDessert.setLayoutManager(layoutManager3);
        recyclerViewDessert.setAdapter(adapter3);



        return root;
    }
}