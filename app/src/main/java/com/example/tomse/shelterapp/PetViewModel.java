package com.example.tomse.shelterapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class PetViewModel extends AndroidViewModel {
    public PetRepository petRepository;
    private LiveData<List<Pet>> allPets;


    public PetViewModel(@NonNull Application application) {
        super(application);

        petRepository = new PetRepository(application);
        allPets = petRepository.getAllPets();
    }

    public void insertPet (Pet pet) {
        petRepository.insertPet(pet);

    }

    public void updatePet (Pet pet) {
        petRepository.updatePet(pet);

    }
    public void deletePet (Pet pet) {
        petRepository.deletePet(pet);

    }

    public void deleteAllPets () {
        petRepository.deleteAllPets();

    }

    public LiveData<List<Pet>> getAllPets() {
        return allPets;
    }
}
