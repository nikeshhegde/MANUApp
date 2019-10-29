package com.example.manuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView playerListView = null;
    private ArrayAdapter<Player> adapter = null;
    private PlayerXMLData playerListData = null;
    private List<Player> playerList = new ArrayList<Player>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //wire the data from XML values
        playerListData = new PlayerXMLData(this);
        playerListView = findViewById(R.id.listView);

        for(int i = 0 ; i< playerListData.getLength(); i++){
            playerList.add(playerListData.getPlayer(i));
        }

        CustomPlayerAdapter adapter = new CustomPlayerAdapter(this, R.layout.activity_list_layout, playerList);
        // bind intrinsic ListView to custom adapter
        playerListView.setAdapter(adapter);

        playerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,PlayerDetails.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("key",playerListData.getPlayer(i));
                Log.d("Debug", "onItemClick: "+playerListData.getPlayer(i).getName());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }



}
