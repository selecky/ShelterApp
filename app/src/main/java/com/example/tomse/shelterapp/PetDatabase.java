package com.example.tomse.shelterapp;

import android.app.Activity;
import android.app.Application;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;

@Database (entities = Pet.class, version = 1)
public abstract class PetDatabase extends RoomDatabase {

    public abstract PetDao getPetDao();
    private static PetDatabase instance;

    public static synchronized PetDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    PetDatabase.class, "pet_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;


    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);


            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private PetDao petDao;
        protected Context context;

        private PopulateDbAsyncTask(PetDatabase petDatabase) {
            petDao = petDatabase.getPetDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {

            int cat1 = context.getResources().getIdentifier("cat1","drawable",context.getPackageName());

            petDao.insertPet(new Pet(1, cat1, "Groomy","Cat", "",
                    "Male", 1, "Today"));
            return null;
        }
    }

}
