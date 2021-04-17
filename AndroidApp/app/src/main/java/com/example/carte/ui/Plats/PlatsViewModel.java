package com.example.carte.ui.Plats;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlatsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PlatsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Plats fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}