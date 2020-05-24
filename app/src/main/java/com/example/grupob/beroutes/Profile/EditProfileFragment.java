package com.example.grupob.beroutes.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.grupob.beroutes.Account.AccountSettingActivity;
import com.example.grupob.beroutes.R;
import com.example.grupob.beroutes.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class EditProfileFragment extends Fragment {

    private static final String TAG = "EditProfileFragment";
    private ImageView mProfilePhoto;

    ImageView backArrow;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);
        mProfilePhoto = (ImageView) view.findViewById(R.id.profile_photo);

        setProfileImage();

        //Toolbar
        setupToolbar();

        return view;
    }

    //setear la imagen para cogerla desde una URL
   private void setProfileImage(){
        Log.d(TAG, "setProfileImage: setting image.");
        //introducir la URL correspondiente a la foto de perfil
       String imgURL = "www.androidcentral.com/sites/androidcentral.com/files/styles/xlarge/public/article_images/2016/08/ac-lloyd.jpg?itok=bb72IeLf";
       UniversalImageLoader.setImage(imgURL, mProfilePhoto, null, "https://");
    }

    private void setupToolbar(){

        backArrow = (ImageView) getView().findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating back");
                getActivity().finish();
            }
        });
    }
}
