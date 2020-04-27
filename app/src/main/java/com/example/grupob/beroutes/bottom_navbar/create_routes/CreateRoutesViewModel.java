package com.example.grupob.beroutes.bottom_navbar.create_routes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CreateRoutesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CreateRoutesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is create_routes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}