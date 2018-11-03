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
    private int petAge;

    @NonNull
    private String petArrived;


    public Pet(int id, @NonNull int petImage, @NonNull String petName,
               @NonNull String petSpecies, String petBreed, @NonNull String petGender,
               @NonNull int petAge, @NonNull String petArrived) {
        this.id = id;
        this.petImage = petImage;
        this.petName = petName;
        this.petSpecies = petSpecies;
        this.petBreed = petBreed;
        this.petGender = petGender;
        this.petAge = petAge;
        this.petArrived = petArrived;
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
    public int getPetAge() {
        return petAge;
    }

    @NonNull
    public String getPetArrived() {
        return petArrived;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setPetImage(@NonNull int petImage) {
        this.petImage = petImage;
    }

    public void setPetName(@NonNull String petName) {
        this.petName = petName;
    }

    public void setPetSpecies(@NonNull String petSpecies) {
        this.petSpecies = petSpecies;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public void setPetGender(@NonNull String petGender) {
        this.petGender = petGender;
    }

    public void setPetAge(@NonNull int petAge) {
        this.petAge = petAge;
    }

    public void setPetArrived(@NonNull String petArrived) {
        this.petArrived = petArrived;
    }
}
