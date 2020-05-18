package com.example.grupob.beroutes.Add;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.grupob.beroutes.Profile.ProfileActivity;
import com.example.grupob.beroutes.R;
import com.example.grupob.beroutes.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class AddActivity extends AppCompatActivity {
    private static final String TAG = "AddActivity";

    private static final int ACTIVITY_NUM = 1;
    private Context mContext = AddActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: started");

        setupToolbar();
        setupBottomNavigationView();
    }
    /*
    SETUP DE BARRA DE NAVEGACION
     */
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    private void setupToolbar(){
        //Setup de la flecha de navegación de vuelta a la pantalla anterior
        ImageView backArrow = (ImageView) findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating back");
                finish();
            }
        });

        //Setup de la flecha de navegación de vuelta a la pantalla anterior
        CircleImageView profileImage = findViewById(R.id.iconProfileImage);
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating to 'ProfileActivity'");
                Intent intent = new Intent(v.getContext(), ProfileActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
