package com.example.navigationtab.Utils;

/**
 * Created by subratkumar on 21-05-2017.
 */
public class MileStoneItemObject {
    private String name;
    private int image ;


    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }


    public MileStoneItemObject(int image,String name){
        this.image=image;
        this.name=name;
    }

}
