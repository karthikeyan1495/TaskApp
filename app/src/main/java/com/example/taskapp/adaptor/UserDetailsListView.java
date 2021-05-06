package com.example.taskapp.adaptor;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.taskapp.R;
import com.example.taskapp.UserDetailsFragment;
import com.example.taskapp.databinding.RecycleViewListBinding;
import com.example.taskapp.modal.DataModalList;

import java.util.List;

public class UserDetailsListView extends RecyclerView.Adapter<UserDetailsListView.ViewHolder> {
    FragmentActivity activity;
    List<DataModalList> lists;

    public UserDetailsListView(FragmentActivity activity, List<DataModalList> lists) {
        this.activity = activity;
        this.lists = lists;
    }

    @NonNull
    @Override
    public UserDetailsListView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecycleViewListBinding binding = DataBindingUtil.inflate(inflater, R.layout.recycle_view_list, parent, false);
        return new UserDetailsListView.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserDetailsListView.ViewHolder holder, int position) {
        DataModalList dataModalList = lists.get(position);
        holder.binding.fullName.setText("Full Name : " + dataModalList.getFull_name());
        holder.binding.name.setText("Name : " + dataModalList.getName());
        holder.binding.id.setText("ID : " + dataModalList.getId());

        Glide
                .with(activity)
                .load(dataModalList.getOwner().getAvatar_url())
                .into(holder.binding.userImg);

        holder.binding.moreDelBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle args = new Bundle();
                args.putSerializable("datalist", dataModalList);
                UserDetailsFragment userDetailsFragment = new UserDetailsFragment();
                userDetailsFragment.setArguments(args);

                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.outer_frame, userDetailsFragment)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecycleViewListBinding binding;

        public ViewHolder(@NonNull RecycleViewListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.executePendingBindings();
        }
    }
}

