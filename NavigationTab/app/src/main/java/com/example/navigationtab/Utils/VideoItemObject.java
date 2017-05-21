package com.example.navigationtab.Utils;

/**
 * Created by subratkumar on 21-05-2017.
 */
public class VideoItemObject {
    private int screenShot;
    private String musicName;
    private String musicAuthor;
    private String uploadHr;
    private int upTime;
    public VideoItemObject(int screenShot, String musicName,String musicAuthor,String uploadHr,int upTime){
        this.screenShot=screenShot;
        this.musicName=musicName;
        this.musicAuthor=musicAuthor;
        this.uploadHr=uploadHr;
        this.upTime=upTime;

    }
    public String getMusicAuthor() {
        return musicAuthor;
    }

    public int getScreenShot() {
        return screenShot;
    }

    public String getMusicName() {
        return musicName;
    }

    public String getUploadHr() {
        return uploadHr;
    }

    public int getUpTime() {
        return upTime;
    }

}
