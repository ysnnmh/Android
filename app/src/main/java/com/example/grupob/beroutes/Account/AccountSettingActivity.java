package com.example.grupob.beroutes.Account;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.example.grupob.beroutes.Profile.EditProfileFragment;
import com.example.grupob.beroutes.Profile.ProfileActivity;
import com.example.grupob.beroutes.Profile.SignOutFragment;
import com.example.grupob.beroutes.R;
import com.example.grupob.beroutes.Utils.SectionsStatePagerAdapter;
import java.util.ArrayList;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import de.hdodenhof.circleimageview.CircleImageView;

public class AccountSettingActivity extends AppCompatActivity {

    private static final String TAG = "AccountSettingActivity";

    private Context mContext;

    private SectionsStatePagerAdapter pagerAdapter;
    private ViewPager mViewPager;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);
        mContext = AccountSettingActivity.this;
        Log.d(TAG, "onCreate: started.");
        mViewPager = findViewById(R.id.container);
        mRelativeLayout = findViewById(R.id.relLayout1);

        setupSettingsList();
        setupFragments();
        setupToolbar();

    }

    private void setupFragments(){

        pagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile_fragment)); //fragment 0
        pagerAdapter.addFragment(new SignOutFragment(), getString(R.string.sign_out_fragment)); //fragment 1
    }

    private void setViewPager(int fragmentNumber){
        mRelativeLayout.setVisibility((View.GONE));
        Log.d(TAG, "setViewPager: navigation to fragment #: " + fragmentNumber);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setCurrentItem(fragmentNumber);
    }

    private void setupSettingsList(){
        Log.d(TAG, "setupSettingsList: initializing 'Account Settings' list ");
        ListView listView = (ListView) findViewById(R.id.lvAccountSettings);

        ArrayList<String> option = new ArrayList<>();
        option.add(getString(R.string.edit_profile_fragment)); //fragment 0
        option.add(getString(R.string.sign_out_fragment)); //fragment 1

        ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, option);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: navigating to fragment#: " + position);
                setViewPager(position);
            }
        });
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
