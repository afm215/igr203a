package com.example.carte;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class FragmentCarte extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_carte, container, false);

        BottomNavigationView navView = root.findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_entrees, R.id.navigation_plats, R.id.navigation_desserts,R.id.navigation_boissons)
                .build();

        View navhost = root.findViewById(R.id.nav_host_fragment_carte);
        NavController navController = Navigation.findNavController(navhost);

        NavGraph graph = navController.getGraph();
        graph.setStartDestination(R.id.navigation_entrees);
        navController.setGraph(graph);

        NavigationUI.setupWithNavController(navView, navController);
        ((MainActivity) getActivity()).displayHumberger();


        navView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);


        return root;
    }


}