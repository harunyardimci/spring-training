package com.gg.petclinic.web;

import com.gg.petclinic.service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: { "id": "hyardimci", "email":nosqlsolutions@gmail.com"}
 * Date: 5/11/13
 * Time: 1:58 PM
 */
@Controller
public class PetClinicController {

    @Autowired
    private PetClinicService petClinicService;

    @RequestMapping("/vets")
    public String getVets() {

        return StringUtils.collectionToCommaDelimitedString(petClinicService.getVets());

    }



}
