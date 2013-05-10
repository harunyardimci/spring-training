package com.gg.petclinic.dao;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import com.gg.petclinic.model.Owner;
import com.gg.petclinic.model.Person;
import com.gg.petclinic.model.Pet;
import com.gg.petclinic.model.Vet;
import com.gg.petclinic.model.Visit;
import org.springframework.stereotype.Repository;

@Repository("petClinicDao")
public class PetClinicDaoJdbcImpl implements PetClinicDao {

    public PetClinicDaoJdbcImpl() {
        System.out.println("pcdao created");
    }

	@Override
	public Collection<Vet> getVets() {
        Vet vet = new Vet();
        vet.setFirstName("Harun");
        vet.setLastName("Yardimci");
		return Arrays.asList(vet);
	}

	@Override
	public Collection<Owner> findOwners(String lastName) {
		return Collections.EMPTY_LIST;
	}

	@Override
	public Collection<Visit> findVisits(long petId) {
		return Collections.EMPTY_LIST;
	}

	@Override
	public Collection<Person> findAllPersons() {
		return Collections.EMPTY_LIST;
	}

	@Override
	public Owner loadOwner(long id) {
		return null;
	}

	@Override
	public Pet loadPet(long id) {
		return null;
	}

	@Override
	public Vet loadVet(long id) {
		return null;
	}

	@Override
	public void saveOwner(Owner owner) {
	}

	@Override
	public void saveVet(Vet vet) {
	}

	@Override
	public void deleteOwner(long ownerId) {
	}
}
