package com.example.manuapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomPlayerAdapter extends ArrayAdapter <Player>{

    Context context;
    List<Player> playerList;
    int resource;

    public CustomPlayerAdapter( Context context, int layoutToBeInflated, List<Player> playerList) {
        super(context, R.layout.activity_list_layout, playerList);
        this.context = context;
        this.resource = layoutToBeInflated;
        this.playerList= playerList;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.activity_list_layout, null);
        TextView nameView = (TextView) row.findViewById(R.id.textView1);
        TextView playerPosition = (TextView) row.findViewById(R.id.textView2);
        ImageView img = (ImageView) row.findViewById(R.id.imageView);
        nameView.setText(playerList.get(position).getName());
        playerPosition.setText(playerList.get(position).getPosition());

        // remove the extension from the name
        String image = playerList.get(position).getImage();
        image = image.substring(0, image.indexOf("."));

        int imageId = context.getResources().getIdentifier(image,
                "drawable",
                context.getPackageName());

        img.setImageResource(imageId);
        return (row);
    }
}
