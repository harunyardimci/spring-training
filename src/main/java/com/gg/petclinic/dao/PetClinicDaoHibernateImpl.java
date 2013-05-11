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
            String strQuery = new String("select distinct v from Vet v left join fetch v.specialties");
            Query query = session.createQuery(strQuery);
            return query.list();
        } finally {
            session.close();
        }
    }

    @Override
    public Collection<Owner> findOwners(String lastName) {
        String qry = new String("from Owner o where o.lastName = :lastName");
        return sessionFactory.getCurrentSession().createQuery(qry).setParameter("lastName", lastName).list();
    }

    @Override
    public Collection<Visit> findVisits(long petId) {
        return sessionFactory.getCurrentSession().createQuery("from Visit v where v.pet.id = ?").setParameter(0, petId).list();
    }

    @Override
    public Collection<Person> findAllPersons() {
        return sessionFactory.getCurrentSession().createQuery("from Person").list();
    }

    @Override
    public Owner loadOwner(long id) {
        return (Owner) sessionFactory.getCurrentSession().get(Owner.class, id);
    }

    @Override
    public Pet loadPet(long id) {
        return (Pet) sessionFactory.getCurrentSession().createQuery("from Pet p where p.id = ?").setParameter(0, id).uniqueResult();
    }

    @Override
    public Vet loadVet(long id) {
        return (Vet) sessionFactory.getCurrentSession().get(Vet.class, id);
    }

    @Override
    public void saveOwner(Owner owner) {
        sessionFactory.getCurrentSession().saveOrUpdate(owner);
    }

    @Override
    public void saveVet(Vet vet) {
        sessionFactory.getCurrentSession().save(vet);
    }

    @Override
    public void deleteOwner(long ownerId) {
        Owner owner = new Owner();
        owner.setId(ownerId);

        sessionFactory.getCurrentSession().delete(owner);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}