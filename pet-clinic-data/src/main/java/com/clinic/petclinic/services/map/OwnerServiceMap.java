package com.clinic.petclinic.services.map;

import com.clinic.petclinic.model.Owner;
import com.clinic.petclinic.model.Pet;
import com.clinic.petclinic.services.OwnerService;
import com.clinic.petclinic.services.PetService;
import com.clinic.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if (object != null) {

            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("PetType is required");
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(object);

        } else {
            return null;
        }

    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
