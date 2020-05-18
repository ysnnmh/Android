package com.example.grupob.beroutes.RoutesCreation;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

import com.example.grupob.beroutes.Profile.ProfileActivity;
import com.example.grupob.beroutes.R;
import com.example.grupob.beroutes.Tools.InputFilterMinMax;

public class RoutesCreation extends AppCompatActivity {

    private static final String TAG = "RoutesCreationActivity";


    ImageView ivCargarImg;
    Button btnMaps;
    Button btnPhotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes_creation);

        setupToolbar();

        ivCargarImg = (ImageView) findViewById(R.id.iVCargarImg);

        //Spinner
        Spinner dynamicSpinner = (Spinner) findViewById(R.id.dynamic_spinner);

        String[] items = new String[] { "Naturaleza", "Urbano", "Familia", "Amigos", "Románticas", "Mochileros" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);

        dynamicSpinner.setAdapter(adapter);

        dynamicSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        //Fin Spinner

        //Filtrado de precio
        EditText editTextPrice = (EditText) findViewById(R.id.price);
        editTextPrice.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "99999999")});
        //Fin filtrado de precio

        //Filtrado de dias
        EditText editTextDays = (EditText) findViewById(R.id.days);
        editTextDays.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "365")});
        //Fin filtrado de dias

        //Inicio de redirección de los botones
        btnMaps = (Button) findViewById(R.id.btnMaps);

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RoutesCreation.this, MapsActivity.class));
            }
        });

        btnPhotos = (Button) findViewById(R.id.btnPhotos);

        btnPhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RoutesCreation.this, PhotosActivity.class));
            }
        });
        //Fin de redirección de los botones
    }

    //Inicio de cargar imagen
    public void cargarImg(View view) {
        cargarImagen();
    }

    private void cargarImagen() {
        Intent intent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Selecciona la aplicación"), 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK) {
            Uri path = data.getData();
            ivCargarImg.setImageURI(path);
        }
    }
    //Fin de cargar imagen

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
