package com.gg.petclinic.tests;

import com.gg.petclinic.model.Vet;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

/**
 * User: { "id": "hyardimci", "email":nosqlsolutions@gmail.com"}
 * Date: 5/11/13
 * Time: 5:16 PM
 */
public class RestTest {



    @Test
    public void testLoadVet() {

        RestTemplate template = new RestTemplate();
        Vet vet = template.getForObject("http://localhost:8080/mvc/vet/{vetId}", Vet.class, 1L);

        System.out.println("Vet returned" + vet);

    }




}
