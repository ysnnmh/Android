package com.example.grupob.beroutes.Profile;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.grupob.beroutes.Account.AccountSettingActivity;
import com.example.grupob.beroutes.LoginActivity;
import com.example.grupob.beroutes.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SignOutFragment extends Fragment {

    private static final String TAG = "SignOutFragment";
    private ProgressBar mProgressBar;
    private TextView tvSignOut, tvSigningOut;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signout, container, false);

        tvSignOut = (TextView) view.findViewById(R.id.tvConfirmSignout);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        tvSigningOut = (TextView) view.findViewById(R.id.tvSigningOut);
        Button btnConfirmSignout = (Button) view.findViewById(R.id.btnConfirmSignout);

        btnConfirmSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: attempting to sing out");
                mProgressBar.setVisibility(View.VISIBLE);
                tvSigningOut.setVisibility(View.VISIBLE);

                //falta añadir accion de salir de la bd

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("EXIT", true);
                startActivity(intent);

            }
        });

        return view;
    }
/**
 * Añadir funcionalidad para que cuando confirmen el signOut volver a la pantalla de login, pero borrando la actividad
 */

}
