package com.naridsara.myapplication_test;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.naridsara.myapplication_test.model.Restaurants;

public class RestaurantsDetailViewModel extends ViewModel {
    private Repository repository = new Repository();


    LiveData<Restaurants> responseRestaurantsDetail() {
        return repository.responseRestaurantsDetail();
    }

    void requestRestaurantsDetail(int Restaurants_id) {
        repository.requestRestaurantsDetail(Restaurants_id);
    }
}
