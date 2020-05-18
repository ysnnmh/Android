package com.example.grupob.beroutes;

import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.grupob.beroutes.Profile.ProfileActivity;

public class DetailsRouteActivity extends AppCompatActivity {

    private static final String TAG = "DetailsRouteActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_route);

        setupToolbar();

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
