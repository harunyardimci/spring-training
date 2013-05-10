package com.gg.petclinic.dao;

import java.util.Collection;

import com.gg.petclinic.model.Owner;
import com.gg.petclinic.model.Person;
import com.gg.petclinic.model.Pet;
import com.gg.petclinic.model.Vet;
import com.gg.petclinic.model.Visit;


public interface PetClinicDao {
	
	Collection<Vet> getVets();

	Collection<Owner> findOwners(String lastName);
	
	Collection<Visit> findVisits(long petId);
	
	Collection<Person> findAllPersons();

	Owner loadOwner(long id);

	Pet loadPet(long id);
	
	Vet loadVet(long id);

	void saveOwner(Owner owner);

	void saveVet(Vet vet);

	void deleteOwner(long ownerId);
}
