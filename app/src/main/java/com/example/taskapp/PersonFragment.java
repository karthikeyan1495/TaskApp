package com.example.taskapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.taskapp.databinding.PersonFrgBinding;
import com.example.taskapp.modal.DataModalList;
import com.example.taskapp.util.InternetChecker;
import com.example.taskapp.viewmodal.PersonVm;

public class PersonFragment extends Fragment {

    PersonFrgBinding binding;
    PersonVm personVm;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        bindview(inflater,container,savedInstanceState);
        return binding.getRoot();
    }

    private void bindview(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            binding= DataBindingUtil.inflate(inflater,R.layout.person_frg,container,false);
            personVm = new PersonVm(getActivity(), binding);
            binding.setPersonVm(personVm);
    }
}
