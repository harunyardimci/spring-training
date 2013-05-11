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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


@Service("petClinicService")
@Transactional
public class PetClinicServiceImpl implements PetClinicService, InitializingBean, DisposableBean, ApplicationContextAware {
	
	private PetClinicDao petClinicDao;
    private ApplicationContext applicationContext;


    @Autowired
    private PlatformTransactionManager transactionManager;

//    public PetClinicServiceImpl() {
//    }
//
//    public void setPetClinicDao(PetClinicDao dao) {
//        this.petClinicDao = dao;
//    }

    @Autowired
	public PetClinicServiceImpl(@Qualifier("petClinicDao") PetClinicDao petClinicDao) {
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

	public void saveVet(final Vet vet) {
        TransactionTemplate template = new TransactionTemplate(transactionManager);
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                petClinicDao.saveVet(vet);
                EntitySaveEvent saveEvent = new EntitySaveEvent(this);
                saveEvent.setEntity(vet);
                applicationContext.publishEvent(saveEvent);
            }
        });
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
