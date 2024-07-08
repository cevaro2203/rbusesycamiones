package com.app.rbusesycamiones.ui.header;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HeaderViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public HeaderViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Automoviles, Camperos" + "\n"  + "y Camionetas");
    }

    public LiveData<String> getText() {
        return mText;
    }
}