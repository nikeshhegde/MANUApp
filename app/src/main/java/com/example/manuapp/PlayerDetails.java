package com.example.manuapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerDetails extends AppCompatActivity {

    private ImageView imgPlayer, imgCountry = null;
    private Player data;
    private TextView playerNumber = null, playerName = null, playerPosition = null, playerCountry = null, playerAge = null;
    private Button moreButton = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);

        //wire the widgets
        imgPlayer = findViewById(R.id.playerImage);
        playerNumber = findViewById(R.id.playerNumber);
        playerName = findViewById(R.id.playerName);
        playerPosition = findViewById(R.id.playerPosition);
        playerCountry = findViewById(R.id.playerCountry);
        playerAge = findViewById(R.id.playerAge);
        imgCountry = findViewById(R.id.imageCountry);
        moreButton = findViewById(R.id.moreWebButton);

        //get the data
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        data = (Player) bundle.getSerializable("key");

        //populate the fields
        imgPlayer.setImageResource(removeImageExtension(data.getImage()));
        playerNumber.setText(data.getNumber());
        playerName.setText(data.getName());
        playerPosition.setText(data.getPosition());
        playerCountry.setText(data.getCountry());
       playerAge.setText(data.getAge());
        imgCountry.setImageResource(removeImageExtension(data.getCountryImage()));


        //deal with the button
        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(PlayerDetails.this,PlayerMoreInfo.class);
                Bundle bundle1 = new Bundle();
                //add data to bundle
                bundle1.putSerializable("data", data);
                intent1.putExtras(bundle1);
                //start activity
                startActivity(intent1);
            }
        });

    }

    public int removeImageExtension(String image){
        int imageId = 0;
        Log.d(image, "removeImageExtension: imagename");
        // remove the extension from the name
        String imageName = image;
        if(imageName.contains("."))
        imageName = imageName.substring(0, imageName.indexOf("."));

        imageId = this.getResources().getIdentifier(
                imageName,
                "drawable",
                this.getPackageName());
        return imageId;
    }

}