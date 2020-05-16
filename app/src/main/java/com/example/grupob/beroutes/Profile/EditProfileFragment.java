package com.example.grupob.beroutes.Profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.grupob.beroutes.R;
import com.example.grupob.beroutes.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class EditProfileFragment extends Fragment {

    private static final String TAG = "EditProfileFragment";
    private ImageView mProfilePhoto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);
        mProfilePhoto = (ImageView) view.findViewById(R.id.profile_photo);

        initImageLoader();
        setProfileImage();

        return view;
    }

    //inicializar el imageLoader
    private void initImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(getActivity());
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }


            //setear la imagen para cogerla desde una URL
    private void setProfileImage(){
        Log.d(TAG, "setProfileImage: setting image.");
        String imgUrl = "https://i2.wp.com/digitalpolicylaw.com/wp-content/uploads/2019/03/wjoel_180413_1777_android_001.0.jpg?fit=1200%2C800&ssl=1";
        UniversalImageLoader.setImage(imgUrl, mProfilePhoto, null, "https://");
    }
}
