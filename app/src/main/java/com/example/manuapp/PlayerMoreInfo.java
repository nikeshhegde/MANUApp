package com.example.manuapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerMoreInfo extends AppCompatActivity {

    private Player data;
    private TextView playerDOB = null, playerJoinDate = null, playerDebutDate = null,
            playerAppearances = null , playerGoalLabel = null, playerGoals = null,
            playerCleanSheetLabel = null , playerCleanSheet = null;
    private Button moreWebButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_more_details);

        //wire the widgets
        playerDOB = findViewById(R.id.playerDOB);
        playerJoinDate = findViewById(R.id.playerJoinDate);
        playerDebutDate = findViewById(R.id.playerDebutDate);
        moreWebButton = findViewById(R.id.moreWebButton);
        playerAppearances = findViewById(R.id.playerApperances);
        playerGoalLabel  = findViewById(R.id.goalsLabel);
        playerGoals = findViewById(R.id.playerGoals);
        playerCleanSheetLabel  = findViewById(R.id.cleanSheetLabel);
        playerCleanSheet  = findViewById(R.id.playerCleanSheet);

        //get the data
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        data = (Player) bundle.getSerializable("data");

        //populate the fields
        playerDOB.setText(data.getDateOfBirth());
        playerJoinDate.setText(data.getJoinedDate());
        playerDebutDate.setText(data.getDebutDate());
        playerAppearances.setText(data.getAppearances());
        playerCleanSheet.setText(data.getCleanSheet());
        playerGoals.setText(data.getGoals());

        //if(data.getPosition().equalsIgnoreCase("Goalkeeper")){
           // playerGoalLabel.setVisibility(View.INVISIBLE);
            //playerGoals.setVisibility(View.INVISIBLE);

        //}
       // else{
        //    playerCleanSheetLabel.setVisibility(View.INVISIBLE);
        //    playerCleanSheet.setVisibility(View.INVISIBLE);
        //}


        //deal with the button
        moreWebButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(PlayerMoreInfo.this,PlayerWebView.class);
                Bundle bundle1 = new Bundle();
                //add data to bundle
                bundle1.putSerializable("url", data.getUrl());
                intent1.putExtras(bundle1);
                //start activity
                startActivity(intent1);
            }
        });

    }

}
