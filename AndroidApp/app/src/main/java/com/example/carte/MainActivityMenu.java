package com.example.carte;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.google.android.material.navigation.NavigationView;

public class MainActivityMenu   extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_menu1, R.id.navigation_menu2, R.id.navigation_menu3,R.id.navigation_menu4)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_menu);
        NavGraph graph = navController.getGraph();
        graph.setStartDestination(R.id.navigation_menu1);
        navController.setGraph(graph);

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);



        NavigationView navigationView = findViewById(R.id.humberger_view);
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
                System.out.println("cliiiiiiiicked");
                startActivity(new Intent(MainActivityMenu.this,MainActivityCarte.class));
                break;
        }
        return true;
    }
}