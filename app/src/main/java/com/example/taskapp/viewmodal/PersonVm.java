package com.example.taskapp.viewmodal;

import android.app.Activity;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.taskapp.R;
import com.example.taskapp.adaptor.UserDetailsListView;
import com.example.taskapp.api.APICall;
import com.example.taskapp.api.APIConfiguration;
import com.example.taskapp.api.APIErrorHandler;
import com.example.taskapp.databinding.PersonFrgBinding;
import com.example.taskapp.modal.DataModalList;
import com.example.taskapp.util.InternetChecker;
import com.example.taskapp.util.MyProgressDialog;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class PersonVm {
    FragmentActivity activity;
    MyProgressDialog myProgressDialog;
    PersonFrgBinding binding;
    UserDetailsListView userDetailsListView;
    public PersonVm(FragmentActivity activity, PersonFrgBinding binding) {
        this.activity= activity;
        this.binding=binding;
        myProgressDialog=new MyProgressDialog();
        getDataApi();
    }

    private void getDataApi() {
        binding.recycleViewPerson.setLayoutManager(new LinearLayoutManager(activity));
        /*if (InternetChecker.getInstance().isReachable()) {*/
            myProgressDialog.showDialog(activity);
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<List<DataModalList>>>observable = api.getData();
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        myProgressDialog.dismissDialog();
                        if (responses.code() == 200) {
                            List<DataModalList> response = responses.body();
                            setuprecycleViewList(response);
                        }
                        else {
                            if (responses.body() != null) {
                                APIErrorHandler.getInstance().errorHandler(activity, responses.code(), responses.body().toString());
                            } else {
                                APIErrorHandler.getInstance().errorHandler(activity, responses.code(), responses.errorBody().string());
                            }
                        }
                    }, throwable -> {
                        myProgressDialog.dismissDialog();
                        Toast.makeText(activity, activity.getString(R.string.something_went_wrong_while_retrieving_information), Toast.LENGTH_LONG).show();

                    });
       /* } else {
            Toast.makeText(activity, activity.getString(R.string.no_internet), Toast.LENGTH_LONG).show();
        }*/

    }

    private void setuprecycleViewList(List<DataModalList> lists) {

         userDetailsListView=new UserDetailsListView(activity,lists);
        binding.recycleViewPerson.setAdapter(userDetailsListView);
    }
}
