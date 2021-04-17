package com.example.carte.ui.Boissons;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BoissonsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BoissonsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Boissons fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}