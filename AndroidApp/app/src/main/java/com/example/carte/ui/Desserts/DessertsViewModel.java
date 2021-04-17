package com.example.carte.ui.Desserts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DessertsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DessertsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Desserts fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}