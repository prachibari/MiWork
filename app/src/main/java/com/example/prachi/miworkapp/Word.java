package com.example.prachi.miworkapp;

/**
 * Created by Prachi on 28-06-2017.
 */

public class Word {

   private String englishTranslation;
   private String miTransalation;
   private int imageResourceId;
    private static int NO_IMAGE_PROVIDED = -1;

    private int audioResourceId;

    public Word(String englishTranslation, String miTransalation,int imageResourceId, int audioResourceId) {
        this.englishTranslation = englishTranslation;
        this.miTransalation = miTransalation;
        this.imageResourceId = imageResourceId;
        this.audioResourceId = audioResourceId;
        NO_IMAGE_PROVIDED = 0;

    }


    public Word(String englishTranslation, String miTransalation, int audioResourceId) {
        this.englishTranslation = englishTranslation;
        this.miTransalation = miTransalation;
        this.audioResourceId = audioResourceId;
    }
    public int getAudioResourceId() {
        return audioResourceId;
    }



    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getMiTransalation() {
        return miTransalation;
    }

    public void setMiTransalation(String miTransalation) {
        this.miTransalation = miTransalation;
    }

    public String getEnglishTranslation() {

        return englishTranslation;
    }

    public void setEnglishTranslation(String englishTranslation) {
        this.englishTranslation = englishTranslation;
    }

    public boolean hasImage()
    {
        return imageResourceId != NO_IMAGE_PROVIDED;
    }
}
