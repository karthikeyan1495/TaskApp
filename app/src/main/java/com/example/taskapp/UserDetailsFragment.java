package com.example.taskapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.taskapp.databinding.UserDetailsFrgBinding;
import com.example.taskapp.modal.DataModalList;

public class UserDetailsFragment extends Fragment {

    UserDetailsFrgBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bindview(inflater,container);

        return binding.getRoot();
    }

    private void bindview(LayoutInflater inflater, ViewGroup container) {
        assert getArguments() != null;
        DataModalList bundle= (DataModalList) getArguments().getSerializable("datalist");

        binding= DataBindingUtil.inflate(inflater,R.layout.user_details_frg,container,false);

        binding.id.setText("ID : "+bundle.getOwner().getId());
        binding.description.setText(bundle.getDescription());
        binding.type.setText("Type : "+bundle.getOwner().getType());
        binding.nodeId.setText("Note ID : "+bundle.getOwner().getNode_id());
        binding.organizationsUrl.setText("OrganizationsUrl : "+bundle.getOwner().getOrganizations_url());
        binding.subscriptionsUrl.setText("SubscriptionsUrl : "+bundle.getOwner().getSubscriptions_url());

        Glide
                .with(getActivity())
                .load(bundle.getOwner().getAvatar_url())
                .into(binding.userImgs);
    }
}
