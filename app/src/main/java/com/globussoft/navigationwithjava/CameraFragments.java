package com.globussoft.navigationwithjava;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class CameraFragments extends Fragment {


    public CameraFragments() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_camera, container, false);


        view.findViewById(R.id.button_photos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  Navigation.findNavController(v).navigate(R.id.destination_photos);

                Random random = new Random();
                CameraFragmentsDirections.NextAction directions = CameraFragmentsDirections.nextAction();

                directions.setNoOfPhotos(random.nextInt(100));
                Navigation.findNavController(v).navigate(directions);
            }
        });
        return view;
    }

}
