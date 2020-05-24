package com.example.grupob.beroutes;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.grupob.beroutes.Profile.ProfileActivity;
import com.example.grupob.beroutes.Utils.Utilidades;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class DetailsRouteActivity2 extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    ImageView backArrow;
    ImageView ivProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_route2);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map1);
        mapFragment.getMapAsync( this);

        //Toolbar
        setupToolbar();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng center = null;
        ArrayList<LatLng> points = null;
        PolylineOptions lineOptions = null;

        points = new ArrayList<LatLng>();
        lineOptions = new PolylineOptions();

        LatLng position = new LatLng(40.747848, -73.983086);
        points.add(position);
        LatLng position2 = new LatLng(40.756772,-74.004385);
        points.add(position2);

        // Agregamos todos los puntos en la ruta al objeto LineOptions
        lineOptions.addAll(points);
        //Definimos el grosor de las Polilíneas
        lineOptions.width(6);
        //Definimos el color de la Polilíneas
        lineOptions.color(Color.BLUE);

        center = new LatLng(40.753678,-73.996934);

        // Dibujamos las Polilineas en el Google Map para cada ruta
        mMap.addPolyline(lineOptions);

        LatLng origen = new LatLng(40.747848, -73.983086);
        mMap.addMarker(new MarkerOptions().position(origen).title("Lat: "+Utilidades.coordenadas.getLatitudInicial()+" - Long: "+Utilidades.coordenadas.getLongitudInicial()));

        LatLng destino = new LatLng(40.756772,-74.004385);
        mMap.addMarker(new MarkerOptions().position(destino).title("Lat: "+Utilidades.coordenadas.getLatitudFinal()+" - Long: "+Utilidades.coordenadas.getLongitudFinal()));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(center, 14));
        /////////////

    }

    private void setupToolbar(){

        backArrow = (ImageView) findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ivProfile = (ImageView) findViewById(R.id.profile);
        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailsRouteActivity2.this, ProfileActivity.class));
            }
        });
    }
}

