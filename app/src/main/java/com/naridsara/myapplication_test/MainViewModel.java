package com.naridsara.myapplication_test;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.naridsara.myapplication_test.model.Restaurants;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private Repository repository = new Repository();


    LiveData<ArrayList<Restaurants>> responseRestaurants() {
        return repository.responseRestaurants();
    }

    void requestRestaurants() {
        repository.requestRestaurants();
    }
}