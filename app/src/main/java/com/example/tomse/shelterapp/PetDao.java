package com.example.tomse.shelterapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface PetDao {

    @Insert
    void insertPet (Pet pet);

    @Update
    void updatePet (Pet pet);

    @Delete
    void deletePet (Pet pet);

    @Query ("DELETE FROM pet_table")
    void deleteAlPets();

    @Query ("SELECT * FROM pet_table ORDER BY petArrivedSuffix ASC")
    LiveData<List<Pet>> getAllPets();

}
