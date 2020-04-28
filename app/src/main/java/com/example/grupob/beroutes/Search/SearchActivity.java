package com.example.grupob.beroutes.Search;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.grupob.beroutes.R;
import com.example.grupob.beroutes.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private static final String TAG = "SearchActivity";

    private static final int ACTIVITY_NUM = 2;
    private Context mContext = SearchActivity.this;
    private Spinner Categorias;
    private Spinner Dias;
    private Spinner Temporada;
    private Spinner Presupuesto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: started");

        Categorias = (Spinner)findViewById(R.id.spinner1);
        Dias = (Spinner)findViewById(R.id.spinner2);
        Temporada = (Spinner)findViewById(R.id.spinner3);
        Presupuesto = (Spinner)findViewById(R.id.spinner4);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,(List<String>) Categorias);
        Categorias.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,(List<String>) Dias);
        Dias.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,(List<String>) Temporada);
        Temporada.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, (List<String>) Presupuesto);
        Presupuesto.setAdapter(adapter3);

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
}
