package com.example.grupob.beroutes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.grupob.beroutes.Fav.FavActivity;
import com.example.grupob.beroutes.Profile.ProfileActivity;
import com.example.grupob.beroutes.RoutesCreation.PhotosActivity;
import com.example.grupob.beroutes.RoutesCreation.RoutesCreation;
import com.example.grupob.beroutes.Search.SearchActivity;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RoutesListActivity extends AppCompatActivity {

    ImageView ivProfile;
    BottomNavigationItemView bnivFavorites, bnivSearch, bnivCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes_list);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_favorites, R.id.navigation_search, R.id.navigation_create)
                .build();

        bnivFavorites = (BottomNavigationItemView) findViewById(R.id.navigation_favorites);
        bnivSearch = (BottomNavigationItemView) findViewById(R.id.navigation_search);
        bnivCreate = (BottomNavigationItemView) findViewById(R.id.navigation_create);

        bnivFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RoutesListActivity.this, FavActivity.class));
            }
        });

        bnivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RoutesListActivity.this, SearchActivity.class));
            }
        });

        bnivCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RoutesListActivity.this, RoutesCreation.class));
            }
        });

        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //NavigationUI.setupWithNavController(navView, navController);

        ivProfile = (ImageView) findViewById(R.id.profile);

        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RoutesListActivity.this, ProfileActivity.class));
            }
        });
    }

    public void cargarDetalles(View view) {
        startActivity(new Intent(RoutesListActivity.this, DetailsRouteActivity.class));
    }
}
