package com.example.taskapp;

import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.taskapp.databinding.HomeFrgBinding;

public class HomeFragment extends Fragment {
    HomeFrgBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        bindview(inflater,container);

        return binding.getRoot();
    }

    private void bindview(LayoutInflater inflater, ViewGroup container) {

        binding= DataBindingUtil.inflate(inflater,R.layout.home_frg,container,false);

    }
}
