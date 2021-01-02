package com.pmprogramms.facebook_clone.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pmprogramms.facebook_clone.R;
import com.pmprogramms.facebook_clone.recyclerview.PostRecyclerViewAdapter;

public class HomePageFragment extends Fragment {

    private RecyclerView postRecyclerView;
    private PostRecyclerViewAdapter postRecyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_page_fragment, container, false);
        postRecyclerView = rootView.findViewById(R.id.post_recyclerview);
        postRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        postRecyclerView.setLayoutManager(layoutManager);

        postRecyclerViewAdapter = new PostRecyclerViewAdapter(getContext());
        postRecyclerView.setAdapter(postRecyclerViewAdapter);

        return rootView;
    }
}
