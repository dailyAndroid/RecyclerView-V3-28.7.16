package com.example.hwhong.recyclerviewv3;

import java.util.ArrayList;

/**
 * Created by hwhong on 7/28/16.
 */
public class Data {

    public static ArrayList<Information> getData() {

        ArrayList<Information> list = new ArrayList<>();

        int[] images = {
                R.drawable.amazon,
                R.drawable.android,
                R.drawable.beme,
                R.drawable.fb,
                R.drawable.google,
                R.drawable.instagram,
                R.drawable.linkedin,
                R.drawable.nyt,
                R.drawable.skyscanner,
                R.drawable.snapchat,
                R.drawable.tumblr,
                R.drawable.twitter,
                R.drawable.uber
        };

        String[] titles  = {"Amazon", "Android", "Beme", "Facebook", "Google", "Instagram",
                "Linkedin", "New York Times", "Skyscanner", "Snapchat",
                "Tumblr", "Twitter", "Uber"};

        for (int x = 0; x < images.length; x++) {
            Information information = new Information();
            information.imageID = images[x];
            information.title = titles[x];

            //populate the list with the individual items that includes a image and the title of the image
            list.add(information);
        }

        return list;
    }


}
