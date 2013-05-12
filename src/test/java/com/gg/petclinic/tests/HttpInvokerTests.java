package com.gg.petclinic.tests;

import com.gg.petclinic.service.PetClinicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: { "id": "hyardimci", "email":nosqlsolutions@gmail.com"}
 * Date: 5/12/13
 * Time: 10:24 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config.xml")
public class HttpInvokerTests {

    @Autowired
    private PetClinicService petClinicService;

    @Test
    public void testHttpInvoker() {
        System.out.println("Vet returned :" + petClinicService.loadVet(1L));
    }
}
