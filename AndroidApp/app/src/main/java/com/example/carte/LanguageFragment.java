package com.example.carte;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LanguageFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListView simpleList;
        View root = inflater.inflate(R.layout.fragment_language, container, false);
        simpleList = root.findViewById(R.id.languagelist);
        String[] languages = {"Français", "English","Deutsch"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_language_view, R.id.textView, languages);
        simpleList.setAdapter(arrayAdapter);
        // Inflate the layout for this fragment
        return root;
    }
}