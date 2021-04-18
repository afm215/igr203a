package com.example.carte;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carte.MainActivity;
public class TableNum extends Fragment {

    private EditText numero;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_table_num, container, false);
        Button button =  (Button) root.findViewById(R.id.button_num);
        numero = root.findViewById(R.id.editText);

        if(((MainActivity)getActivity()).numeroDeTable == 0){
            numero.setText("");
        }
        else{
            numero.setText(Integer.toString(((MainActivity)getActivity()).numeroDeTable));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = numero.getText().toString();
                if(num.equals("")){
                    Toast.makeText(getContext(), "Veuillez remplir le numéro de table", Toast.LENGTH_SHORT).show();
                }
                else{
                    ((MainActivity)getActivity()).numeroDeTable = Integer.parseInt(num);
                    ((MainActivity)getActivity()).navController.navigate(R.id.navigation_carte);
                }
            }
        });
        return root;
    }
}