package com.example.tomse.shelterapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;


@Entity (tableName = "pet_table")
public class Pet {

    @PrimaryKey (autoGenerate = true)
    private int id;

    @NonNull
    private int petImage;

    @NonNull
    private String petName;

    @NonNull
    private String petSpecies;

    private String petBreed;

    @NonNull
    private String petGender;

    @NonNull
    private String petAge;

    @NonNull
    private String petArrivedSuffix;


    public Pet(int id, @NonNull int petImage, @NonNull String petName,
               @NonNull String petSpecies, String petBreed, @NonNull String petGender,
               @NonNull String petAge, @NonNull String petArrivedSuffix) {
        this.id = id;
        this.petImage = petImage;
        this.petName = petName;
        this.petSpecies = petSpecies;
        this.petBreed = petBreed;
        this.petGender = petGender;
        this.petAge = petAge;
        this.petArrivedSuffix = petArrivedSuffix;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public int getPetImage() {
        return petImage;
    }

    @NonNull
    public String getPetName() {
        return petName;
    }

    @NonNull
    public String getPetSpecies() {
        return petSpecies;
    }

    public String getPetBreed() {
        return petBreed;
    }

    @NonNull
    public String getPetGender() {
        return petGender;
    }

    @NonNull
    public String getPetAge() {
        return petAge;
    }

    @NonNull
    public String getPetArrivedSuffix() {
        return petArrivedSuffix;
    }
}
