package com.example.navigationtest.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.navigationtest.R;
import com.example.navigationtest.viewmodel.value_viewmodel;

public class allinfo extends Fragment {


    Button back;
    TextView Name , Email , Phone , Address , Description ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_allinfo, container, false);
        back = view.findViewById(R.id.back_allinfo);
        Name = view.findViewById(R.id.Name_textview);
        Email = view.findViewById(R.id.Email_Textview);
        Phone = view.findViewById(R.id.Phone_textview);
        Address = view.findViewById(R.id.Address_textview);
        Description = view.findViewById(R.id.Description_textview);



        value_viewmodel viewmodel = new ViewModelProvider(this).get(value_viewmodel.class);



        Name.setText(viewmodel.getName());
        Email.setText(viewmodel.getEmail());
        Phone.setText(viewmodel.getPhone());
        Address.setText(viewmodel.getAddress());
        Description.setText(viewmodel.getDescription());


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(back).navigate(R.id.action_allinfo_to_describtion);

            }
        });





        return  view;
    }
}