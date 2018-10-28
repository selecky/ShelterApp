package com.example.tomse.shelterapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class PetRepository {

    private PetDao petDao;
    private LiveData<List<Pet>> allPets;

    public PetRepository (Application application) {
        PetDatabase petDatabase = PetDatabase.getInstance(application);
        petDao = petDatabase.getPetDao();
        allPets = petDao.getAllPets();
    }

    public void insertPet(Pet pet){
        InsertPetAsyncTask insertPetAsyncTask = new InsertPetAsyncTask(petDao);
        insertPetAsyncTask.execute(pet);

    }

    public void updatePet(Pet pet){
        UpdatePetAsyncTask updatePetAsyncTask = new UpdatePetAsyncTask(petDao);
        updatePetAsyncTask.execute(pet);
    }

    public void deletePet(Pet pet){
        DeletePetAsyncTask deletePetAsyncTask = new DeletePetAsyncTask(petDao);
        deletePetAsyncTask.execute(pet);
    }

    public void deleteAllPets(){
        DeleteAllPetsAsyncTask deleteAllPetsAsyncTask = new DeleteAllPetsAsyncTask(petDao);
        deleteAllPetsAsyncTask.execute();
    }

    public LiveData<List<Pet>> getAllPets() {
        return allPets;
    }

private static class InsertPetAsyncTask extends AsyncTask <Pet, Void, Void> {
        PetDao asyncTaskDao;

    public InsertPetAsyncTask(PetDao asyncTaskDao) {
        this.asyncTaskDao = asyncTaskDao;
    }

    @Override
    protected Void doInBackground(Pet... pets) {
        asyncTaskDao.insertPet(pets[0]);
        return null;
    }
}

    private static class UpdatePetAsyncTask extends AsyncTask <Pet, Void, Void> {
        PetDao asyncTaskDao;

        public UpdatePetAsyncTask(PetDao asyncTaskDao) {
            this.asyncTaskDao = asyncTaskDao;
        }

        @Override
        protected Void doInBackground(Pet... pets) {
            asyncTaskDao.updatePet(pets[0]);
            return null;
        }
    }


    private static class DeletePetAsyncTask extends AsyncTask <Pet, Void, Void> {
        PetDao asyncTaskDao;

        public DeletePetAsyncTask(PetDao asyncTaskDao) {
            this.asyncTaskDao = asyncTaskDao;
        }

        @Override
        protected Void doInBackground(Pet... pets) {
            asyncTaskDao.deletePet(pets[0]);
            return null;
        }
    }

    private static class DeleteAllPetsAsyncTask extends AsyncTask <Void, Void, Void> {
        PetDao asyncTaskDao;

        public DeleteAllPetsAsyncTask(PetDao asyncTaskDao) {
            this.asyncTaskDao = asyncTaskDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            asyncTaskDao.deleteAlPets();
            return null;
        }
    }


}
