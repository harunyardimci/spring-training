package com.gg.petclinic.dao;

import com.gg.petclinic.model.*;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: { "id": "hyardimci", "email":nosqlsolutions@gmail.com"}
 * Date: 5/10/13
 * Time: 3:29 PM
 */
@Repository
@Qualifier("petClinicDao")
public class PetClinicDaoHibernateImpl implements PetClinicDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Collection<Vet> getVets() {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Vet");
            return query.list();
        } finally {
            session.close();
        }
    }

    @Override
    public Collection<Owner> findOwners(String lastName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Visit> findVisits(long petId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Person> findAllPersons() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Owner loadOwner(long id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Pet loadPet(long id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Vet loadVet(long id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveOwner(Owner owner) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveVet(Vet vet) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteOwner(long ownerId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
