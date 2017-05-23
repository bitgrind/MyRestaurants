package com.example.guest.myrestaurants;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Typeface;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.findRestaurantsButton) Button mFindRestaurantButton;
    @Bind(R.id.findAlphabetButton) Button mFindAlphabetButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;
    private String TAG = "alphabet Location";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface solo = Typeface.createFromAsset(getAssets(), "fonts/champ2.ttf");
        mAppNameTextView.setTypeface(solo);

        mFindRestaurantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String location = mLocationEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == mFindRestaurantButton) {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
        if (v == mFindAlphabetButton) {
            Log.i(TAG,"go to alphabet location");
            Intent intent = new Intent(MainActivity.this, AlphabetActivity.class);
            startActivity(intent);
        }
    }
}
