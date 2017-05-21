package com.example.navigationtab.Utils;

import com.example.navigationtab.drawerFragment.ImageFragment;

/**
 * Created by subratkumar on 21-05-2017.
 */
public class ImageItemObject {
    private int image;
    private String name;

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }


    public ImageItemObject(int image,String name){
        this.image=image;
        this.name=name;
    }
}
