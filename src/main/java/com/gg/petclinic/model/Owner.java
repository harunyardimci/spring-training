package com.gg.petclinic.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@PrimaryKeyJoinColumn
@Table(name="owners")
public class Owner extends Person {
	
	private static final long serialVersionUID = 1L;
	
	@Embedded
	private Address address = new Address(this);

	@OneToMany(mappedBy="owner")
	private Set<Pet> pets = new HashSet<Pet>();
	
	public Set<Pet> getPets() {
		return Collections.unmodifiableSet(pets);
	}
	
	public void addPet(Pet pet) {
		pet.setOwner(this);
		pets.add(pet);
	}

	public Address getAddress() {
		return address;
	}

    @Override
    public void save() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
