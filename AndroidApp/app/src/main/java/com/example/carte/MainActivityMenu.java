package com.example.carte;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.google.android.material.navigation.NavigationView;

public class MainActivityMenu   extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private NavController navController;
    private BottomNavigationView navView;
    private AppBarConfiguration appBarConfiguration;
    private NavigationView navigationView;
    private NavGraph graph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_menu1, R.id.navigation_menu2, R.id.navigation_menu3,R.id.navigation_menu4)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_menu);
        NavGraph graph = navController.getGraph();
        graph.setStartDestination(R.id.navigation_menu1);
        navController.setGraph(graph);

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);



        navigationView = findViewById(R.id.humberger_view);
        //NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(this);
        /*DrawerLayout drawer = findViewById(R.id.drawer_layout);

        AppBarConfiguration mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_cartes, R.id.nav_commande, R.id.nav_langues)
                .setDrawerLayout(drawer)
                .build();*/
        //NavController navControllersecond = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navControllersecond, mAppBarConfiguration);
        //NavigationUI.setupWithNavController(navigationView, navController);

        navView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_cartes:
                setContentView(R.layout.fragment_carte);
                navigationView = findViewById(R.id.humberger_view);
                navView = findViewById(R.id.nav_view);
                navigationView.setNavigationItemSelectedListener(this);
                // Passing each menu ID as a set of Ids because each
                // menu should be considered as top level destinations.
                appBarConfiguration = new AppBarConfiguration.Builder(
                        R.id.navigation_entrees, R.id.navigation_plats, R.id.navigation_desserts,R.id.navigation_boissons)
                        .build();

                navController = Navigation.findNavController(this, R.id.nav_host_fragment_carte);
                graph = navController.getGraph();
                graph.setStartDestination(R.id.navigation_entrees);
                navController.setGraph(graph);


                NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
                NavigationUI.setupWithNavController(navView, navController);

                //NavigationUI.setupWithNavController(navigationView, navController);

                navView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
                break;

            case R.id.nav_menus:

                setContentView(R.layout.activity_main_menu);
                navigationView = findViewById(R.id.humberger_view);
                // Passing each menu ID as a set of Ids because each
                // menu should be considered as top level destinations.
                appBarConfiguration = new AppBarConfiguration.Builder(
                        R.id.navigation_menu1, R.id.navigation_menu2, R.id.navigation_menu3,R.id.navigation_menu4)
                        .build();
                navController = Navigation.findNavController(this, R.id.nav_host_fragment_menu);
                graph = navController.getGraph();
                graph.setStartDestination(R.id.navigation_menu1);
                navController.setGraph(graph);

                NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
                NavigationUI.setupWithNavController(navView, navController);

                //NavigationUI.setupWithNavController(navigationView, navController);
        /*DrawerLayout drawer = findViewById(R.id.drawer_layout);

        AppBarConfiguration mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_cartes, R.id.nav_commande, R.id.nav_langues)
                .setDrawerLayout(drawer)
                .build();*/
                //NavController navControllersecond = Navigation.findNavController(this, R.id.nav_host_fragment);
                //NavigationUI.setupActionBarWithNavController(this, navControllersecond, mAppBarConfiguration);
                //NavigationUI.setupWithNavController(navigationView, navController);

                navView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);

        }
        return true;
    }
}