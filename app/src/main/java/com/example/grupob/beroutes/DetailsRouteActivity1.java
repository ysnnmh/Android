package com.example.grupob.beroutes;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.grupob.beroutes.Utils.Utilidades;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class DetailsRouteActivity1 extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_route1);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map1);
        mapFragment.getMapAsync( this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng center = null;
        ArrayList<LatLng> points = null;
        PolylineOptions lineOptions = null;

        points = new ArrayList<LatLng>();
        lineOptions = new PolylineOptions();

        LatLng position = new LatLng(37.763413, -122.434205);
        points.add(position);
        LatLng position2 = new LatLng(37.772851, -122.422318);
        points.add(position2);

        // Agregamos todos los puntos en la ruta al objeto LineOptions
        lineOptions.addAll(points);
        //Definimos el grosor de las Polilíneas
        lineOptions.width(6);
        //Definimos el color de la Polilíneas
        lineOptions.color(Color.BLUE);

        center = new LatLng(37.769588, -122.426497);

        // Dibujamos las Polilineas en el Google Map para cada ruta
        mMap.addPolyline(lineOptions);

        LatLng origen = new LatLng(37.763413, -122.434205);
        mMap.addMarker(new MarkerOptions().position(origen).title("Lat: "+Utilidades.coordenadas.getLatitudInicial()+" - Long: "+Utilidades.coordenadas.getLongitudInicial()));

        LatLng destino = new LatLng(37.772851, -122.422318);
        mMap.addMarker(new MarkerOptions().position(destino).title("Lat: "+Utilidades.coordenadas.getLatitudFinal()+" - Long: "+Utilidades.coordenadas.getLongitudFinal()));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(center, 14));
        /////////////

    }

}

