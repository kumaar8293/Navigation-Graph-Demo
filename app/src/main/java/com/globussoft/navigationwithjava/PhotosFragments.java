package com.globussoft.navigationwithjava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhotosFragments extends Fragment {

    private TextView textView_num;

    public PhotosFragments() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_photos_fragments, container, false);

        view.findViewById(R.id.button_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Navigation.findNavController(v).navigate(R.id.destination_home);

                NavDirections directions = PhotosFragmentsDirections.actionDestinationHome();

                Navigation.findNavController(v).navigate(directions);
            }
        });

        view.findViewById(R.id.button_camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  NavDirections directions = PhotosFragmentsDirections.actionDestinationCamera();
                Navigation.findNavController(v).navigate(directions);
*/
                if (getActivity() != null)
                    getActivity().onBackPressed();

            }
        });

        textView_num = view.findViewById(R.id.textView_num);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            PhotosFragmentsArgs value = PhotosFragmentsArgs.fromBundle(bundle);
            textView_num.setText(("No of photos : " + value.getNoOfPhotos()));
        }
    }
}
