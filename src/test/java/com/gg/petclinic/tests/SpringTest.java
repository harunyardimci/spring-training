package com.gg.petclinic.tests;

import com.gg.petclinic.model.Vet;
import com.gg.petclinic.service.PetClinicService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: { "id": "hyardimci", "email":nosqlsolutions@gmail.com"}
 * Date: 5/9/13
 * Time: 11:48 AM
 */
public class SpringTest {

    private ClassPathXmlApplicationContext applicationContext;
    private PetClinicService petClinicService;

    @Before
    public void setUp() {
        //applicationContext = new ClassPathXmlApplicationContext("/appcontext/beans-dao.xml", "/appcontext/beans-service.xml", "/appcontext/beans-config.xml");
        applicationContext = new ClassPathXmlApplicationContext("classpath*:/appcontext/beans-*.xml");
        applicationContext.registerShutdownHook();

        System.out.println("application context created");
        petClinicService = applicationContext.getBean("petClinicService", PetClinicService.class);
    }

    @After
    public void destroy() {

    }

    @Test
    public void testGetVets() {

        Collection<Vet> vets = petClinicService.getVets();

        for (Vet vet: vets) {
            System.out.println(vet);
        }
    }

    @Test
    public void testSaveVet() {

        Vet vet = new Vet();
        vet.setId(123L);
        vet.setFirstName("Harun2");
        vet.setLastName("Yardimci2");

        petClinicService.saveVet(vet);
    }
}
