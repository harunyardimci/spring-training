package com.gg.petclinic.service;

import java.util.Collection;

import com.gg.petclinic.dao.PetClinicDao;
import com.gg.petclinic.event.EntitySaveEvent;
import com.gg.petclinic.model.Owner;
import com.gg.petclinic.model.Person;
import com.gg.petclinic.model.Pet;
import com.gg.petclinic.model.Vet;
import com.gg.petclinic.model.Visit;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;


@Service("petClinicService")
public class PetClinicServiceImpl implements PetClinicService, InitializingBean, DisposableBean, ApplicationContextAware {
	
	private PetClinicDao petClinicDao;
    private ApplicationContext applicationContext;

//    public PetClinicServiceImpl() {
//    }
//
//    public void setPetClinicDao(PetClinicDao dao) {
//        this.petClinicDao = dao;
//    }

    @Autowired
	public PetClinicServiceImpl(PetClinicDao petClinicDao) {
        System.out.println("pcs created");
        this.petClinicDao = petClinicDao;
	}

	public Collection<Vet> getVets() {
		return petClinicDao.getVets();
	}

	public Collection<Owner> findOwners(String lastName) {
		return petClinicDao.findOwners(lastName);
	}

	public Collection<Visit> findVisits(long petId) {
		return petClinicDao.findVisits(petId);
	}

	public Collection<Person> findAllPersons() {
		return petClinicDao.findAllPersons();
	}

	public Owner loadOwner(long id) {
		return petClinicDao.loadOwner(id);
	}

	public Pet loadPet(long id) {
		return petClinicDao.loadPet(id);
	}

	public Vet loadVet(long id) {
		return petClinicDao.loadVet(id);
	}

	public long saveOwner(Owner owner) {
		petClinicDao.saveOwner(owner);
		return owner.getId();
	}

	public void saveVet(Vet vet) {
		petClinicDao.saveVet(vet);
        EntitySaveEvent saveEvent = new EntitySaveEvent(this);
        saveEvent.setEntity(vet);
        applicationContext.publishEvent(saveEvent);
	}

	public void deleteOwner(long ownerId) {
		petClinicDao.deleteOwner(ownerId);
	}

    @Override
    public void destroy() throws Exception {
        System.out.println("pcs destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("pcs initialized");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
