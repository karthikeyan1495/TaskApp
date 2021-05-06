package com.example.taskapp.api;

import com.example.taskapp.modal.DataModalList;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

public interface APICall {

    @GET("repositories")
    Observable<Response<List<DataModalList>>> getData();

}
