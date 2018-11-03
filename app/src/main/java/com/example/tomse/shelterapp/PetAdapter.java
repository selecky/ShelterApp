package com.example.tomse.shelterapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetHolder>{
    private List<Pet> allPets = new ArrayList<>();

    @NonNull
    @Override
    public PetHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View itemView = LayoutInflater.from(viewGroup.getContext())
               .inflate(R.layout.pet_card, viewGroup, false);

        return new PetHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PetHolder petHolder, int position) {
        Pet currentPet = allPets.get(position);

        petHolder.petImageView.setImageResource(currentPet.getPetImage());
        petHolder.petNameView.setText(currentPet.getPetName());
        petHolder.petSpeciesView.setText(currentPet.getPetSpecies());
        petHolder.petBreedView.setText(currentPet.getPetBreed());
        petHolder.petGenderView.setText(currentPet.getPetGender());
        petHolder.petAgeView.setText(String.valueOf(currentPet.getPetAge()));
        petHolder.petArrivedView.setText(currentPet.getPetArrived());
        petHolder.petBreedView.setText(currentPet.getPetBreed());

    }

    @Override
    public int getItemCount() {
        return allPets.size();
    }


     public void setAllPets(List<Pet> allPets){
        this.allPets = allPets;
        notifyDataSetChanged();
     }





    class PetHolder extends RecyclerView.ViewHolder {
        private ImageView petImageView;
        private TextView petNameView;
        private TextView petSpeciesView;
        private TextView petBreedView;
        private TextView petGenderView;
        private TextView petAgeView;
        private TextView petArrivedView;


        public PetHolder(@NonNull View itemView) {
            super(itemView);
            petImageView = itemView.findViewById(R.id.pet_image);
            petNameView = itemView.findViewById(R.id.pet_name);
            petSpeciesView = itemView.findViewById(R.id.pet_species);
            petBreedView = itemView.findViewById(R.id.pet_breed);
            petGenderView = itemView.findViewById(R.id.pet_gender);
            petAgeView = itemView.findViewById(R.id.pet_age);
            petArrivedView = itemView.findViewById(R.id.pet_arrived);


        }
    }



}
