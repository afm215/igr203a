package com.example.carte.ui.Entrées;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EntreesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public EntreesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Entrées fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}