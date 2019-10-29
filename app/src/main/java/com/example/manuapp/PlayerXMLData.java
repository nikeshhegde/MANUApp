package com.example.manuapp;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class PlayerXMLData {

    private  Player [] data;
    private Context context;

    public PlayerXMLData(Context c){
        this.context = c;

        //get an inputstream to xml
        InputStream stream = this.context.getResources().openRawResource(R.raw.playerdata);


        DocumentBuilder builder = null;
        Document xml = null;
        //parse xml to a document
        try{
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xml = builder.parse(stream);
        }
        catch(Exception e){}

        //slice document into 5 Nodelists for name,address etc
        NodeList nameList = xml.getElementsByTagName("name");
        NodeList numberList = xml.getElementsByTagName("number");
        NodeList positionList = xml.getElementsByTagName("position");
        NodeList imageList = xml.getElementsByTagName("image");
        NodeList countryList = xml.getElementsByTagName("country");
        NodeList countryImageList = xml.getElementsByTagName("country_image");
        NodeList joinedDateList = xml.getElementsByTagName("join_date");
        NodeList dateOfBirthList = xml.getElementsByTagName("date_of_birth");
        NodeList debutDateList = xml.getElementsByTagName("debut_date");
        NodeList urlList = xml.getElementsByTagName("url");
        NodeList ageList = xml.getElementsByTagName("age");
        NodeList appearancesList = xml.getElementsByTagName("apperances");
        NodeList cleanSheetList = xml.getElementsByTagName("clean_sheets");
        NodeList goalsList = xml.getElementsByTagName("goals");

        //traverse the list to make data
        data = new Player[nameList.getLength()];

        for(int i= 0; i<data.length; i++){
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String number = numberList.item(i).getFirstChild().getNodeValue();
            String position = positionList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String country = countryList.item(i).getFirstChild().getNodeValue();
            //String countryImage = "nikes";
            String countryImage = countryImageList.item(i).getFirstChild().getNodeValue();
            String joinedDate = joinedDateList.item(i).getFirstChild().getNodeValue();
            String dateOfBirth = dateOfBirthList.item(i).getFirstChild().getNodeValue();
            String debutDate = debutDateList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();
            String age = ageList.item(i).getFirstChild().getNodeValue();
            String appearances = appearancesList.item(i).getFirstChild().getNodeValue();
            String cleanSheet = cleanSheetList.item(i).getFirstChild().getNodeValue();
            String goals = goalsList.item(i).getFirstChild().getNodeValue();
            //put data in array
            data[i] =new Player(name, number, position,image, url, country, countryImage, joinedDate, dateOfBirth, debutDate,age,appearances,cleanSheet,goals);
        }

    }

    public Player getPlayer(int i){return  data[i];}
    public int getLength(){return data.length;}

    public String[] getNames(){
        //construct the string[]

        String [] names= new String[data.length];
        for (int i = 0; i < data.length; i++){
            names[i] = data[i].getName();
        }
        return names;
    }

    public String[] getPosition(){
        //construct the string[]

        String [] pos= new String[data.length];
        for (int i = 0; i < data.length; i++){
            pos[i] = data[i].getPosition();
        }
        return pos;
    }

    public String[] getImage(){
        //construct the string[]

        String [] img= new String[data.length];
        for (int i = 0; i < data.length; i++){
            img[i] = data[i].getImage();
        }
        return img;
    }

}
