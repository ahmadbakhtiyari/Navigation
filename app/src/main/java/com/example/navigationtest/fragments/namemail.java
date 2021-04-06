package com.example.navigationtest.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navigationtest.R;
import com.example.navigationtest.model.data_model;
import com.example.navigationtest.viewmodel.value_viewmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class namemail extends Fragment {

    EditText Name, Email;
    Button Next;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_namemail, container, false);
        Name = view.findViewById(R.id.name_editText);
        Email = view.findViewById(R.id.Email_editText);
        Next = view.findViewById(R.id.Sumbit_nameEmail);


        value_viewmodel viewmodel = new ViewModelProvider(this).get(value_viewmodel.class);

        Name.setText(viewmodel.getName());
        Email.setText(viewmodel.getEmail());


        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namee = Name.getText().toString();
                if (isValidEmailId(Email.getText().toString().trim()) & namee.trim().length() > 2){
                    viewmodel.setName(Name.getText().toString());
                    viewmodel.setEmail(Email.getText().toString());

                    Navigation.findNavController(Next).navigate(R.id.action_namemail_to_phone_address);

                }
                else {
                    Toast.makeText(getActivity(), "your gmail invalid \n Your name should be latest 2 character ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;

    }
    private boolean isValidEmailId(String email){

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }
}