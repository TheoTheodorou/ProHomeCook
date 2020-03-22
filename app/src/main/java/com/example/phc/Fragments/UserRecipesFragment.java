package com.example.phc.Fragments;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phc.MainActivity;
import com.example.phc.R;
import com.example.phc.ViewModels.UserRecipesViewModel;

public class UserRecipesFragment extends Fragment {

    private UserRecipesViewModel mViewModel;

    public static UserRecipesFragment newInstance() {
        return new UserRecipesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.user_recipes_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel =new ViewModelProvider(this).get(UserRecipesViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.init((MainActivity) this.getActivity());
    }
}
