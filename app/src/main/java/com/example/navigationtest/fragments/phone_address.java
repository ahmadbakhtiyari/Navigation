package com.example.navigationtest.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navigationtest.R;
import com.example.navigationtest.viewmodel.value_viewmodel;

public class phone_address extends Fragment {


    String TAG = phone_address.class.getSimpleName();
    Button next, back;
    EditText phone, address;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_phone_address, container, false);
        next = view.findViewById(R.id.Next_phone_address);
        back = view.findViewById(R.id.back_phoneAddress);
        phone = view.findViewById(R.id.phone_editText);
        address = view.findViewById(R.id.address_editText);

        button_listener();

        return view;
    }


    private void button_listener() {


        value_viewmodel viewmodel = new ViewModelProvider(this).get(value_viewmodel.class);

        phone.setText(viewmodel.getPhone());
        address.setText(viewmodel.getAddress());

        next.setOnClickListener(v -> {
            String phoneeee = phone.getText().toString();
            if (phone.getText().toString().length() == 11) {
                if (Integer.parseInt(phoneeee.substring(0, 1)) == 0) {
                    Navigation.findNavController(next).navigate(R.id.action_phone_address_to_describtion);
                    viewmodel.setPhone(phone.getText().toString());
                    viewmodel.setAddress(address.getText().toString());
                } else {
                    Toast.makeText(getActivity(), "your phone must start with 0", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), "your phone has start with 0 And your phone length shoud be 11 ", Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(back).navigate(R.id.action_phone_address_to_namemail);

                NavOptions.Builder navBuilder = new NavOptions.Builder();
                NavOptions navOptions = navBuilder.setPopUpTo(R.id.action_phone_address_to_namemail, false).build();


            }
        });
    }
}