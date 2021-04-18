package com.example.carte;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.carte.MainActivity;
public class TableNum extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_table_num, container, false);
        Button button =  (Button) root.findViewById(R.id.button_num);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Yoooooo!");
               ((MainActivity)getActivity()).navController.navigate(R.id.navigation_carte);
            }
        });
        return root;
    }
}