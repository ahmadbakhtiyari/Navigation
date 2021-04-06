package com.example.navigationtest.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.navigationtest.R;
import com.example.navigationtest.viewmodel.value_viewmodel;

public class Describtion extends Fragment {


    Button next , back;
    EditText Description;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_describtion, container, false);
        next = view.findViewById(R.id.Next_Description);
        back=view.findViewById(R.id.back_describtion);
        Description = view.findViewById(R.id.describtion_edittext);

        listener();

        return view;
    }




    private void listener() {
        value_viewmodel viewmodel = new ViewModelProvider(this).get(value_viewmodel.class);
        Description.setText(viewmodel.getDescription());
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewmodel.setDescription(Description.getText().toString());
                Navigation.findNavController(next).navigate(R.id.action_describtion_to_allinfo);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(back).navigate(R.id.action_describtion_to_phone_address);
                getFragmentManager().beginTransaction().remove(Describtion.this).commitAllowingStateLoss();

            }
        });
    }
}