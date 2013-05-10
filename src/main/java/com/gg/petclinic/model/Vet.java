package com.gg.petclinic.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="vets")
@PrimaryKeyJoinColumn
public class Vet extends Person {
	
	private static final long serialVersionUID = 1L;
	
	public Vet() {
		System.out.println("vet created");
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="vet_specialties",joinColumns={@JoinColumn(name="vets_id")},inverseJoinColumns={@JoinColumn(name="specialties_id")})
	private Set<Specialty> specialties = new HashSet<Specialty>();

	public Set<Specialty> getSpecialties() {
		return Collections.unmodifiableSet(specialties);
	}
	
	public void addSpecialty(Specialty specialty) {
		specialties.add(specialty);
	}
}
