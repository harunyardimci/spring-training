package com.gg.petclinic.tests;

import com.gg.petclinic.model.Vet;
import com.gg.petclinic.service.PetClinicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: { "id": "hyardimci", "email":nosqlsolutions@gmail.com"}
 * Date: 5/9/13
 * Time: 11:48 AM
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/appcontext/beans-*.xml"})
@DirtiesContext //applicationContext bastan yaratilir..
public class SpringTest {

    //@Qualifier("petClinicService")
    @Autowired
    private PetClinicService petClinicService;

    @Test
    public void testGetVets() {

        Collection<Vet> vets = petClinicService.getVets();

        System.out.println("testGetVets ->");
        for (Vet vet: vets) {
            System.out.println("Vet: " + vet);
        }
    }

    @Test
    @DirtiesContext //Bu methoddan sonra application Context bastan yaratilir
    @Transactional
    @Rollback(false)
    public void testSaveVet() {

        Vet vet = new Vet();
        //vet.setId(123L); Auto generated
        vet.setFirstName("Harun234");
        vet.setLastName("Yardimci234");

        petClinicService.saveVet(vet);
    }


    @Test
    @DirtiesContext //Bu methoddan sonra application Context bastan yaratilir
    @Transactional
    @Rollback(false)
    public void testSaveVet2() {

        Vet vet = new Vet();
        //vet.setId(123L); Auto generated
        vet.setFirstName("Harun999");
        vet.setLastName("Yardimci999");
        vet.save();
    }

}