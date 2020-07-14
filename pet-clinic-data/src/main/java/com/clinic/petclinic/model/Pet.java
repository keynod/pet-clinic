package com.clinic.petclinic.model;

import java.time.LocalDate;

public class Pet {

    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;

    public com.clinic.petclinic.model.PetType getPetType() {
        return petType;
    }

    public void setPetType(com.clinic.petclinic.model.PetType petType) {
        this.petType = petType;
    }

    public com.clinic.petclinic.model.Owner getOwner() {
        return owner;
    }

    public void setOwner(com.clinic.petclinic.model.Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
