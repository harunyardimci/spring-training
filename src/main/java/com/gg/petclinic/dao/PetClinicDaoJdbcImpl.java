package com.gg.petclinic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import com.gg.petclinic.model.Owner;
import com.gg.petclinic.model.Person;
import com.gg.petclinic.model.Pet;
import com.gg.petclinic.model.Vet;
import com.gg.petclinic.model.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("petClinicDao")
public class PetClinicDaoJdbcImpl implements PetClinicDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PetClinicDaoJdbcImpl() {
        System.out.println("pcdao created");
    }

	@Override
	public Collection<Vet> getVets() {

        System.out.println("called pcdao");
        return jdbcTemplate
                .query("select p.first_name, p.last_name, p.id from persons p, vets v where v.id = p.id",
                        new RowMapper<Vet>() {

                            @Override
                            public Vet mapRow(ResultSet resultSet, int i) throws SQLException {
                                Vet vet = new Vet();
                                vet.setId(resultSet.getLong("id"));
                                vet.setFirstName(resultSet.getString("first_name"));
                                vet.setLastName(resultSet.getString("last_name"));
                                return vet;
                            }
                        }

                );
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
