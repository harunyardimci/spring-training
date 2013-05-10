package com.gg.petclinic.event;

import org.springframework.context.ApplicationListener;

/**
 * Created with IntelliJ IDEA.
 * User: { "id": "hyardimci", "email":nosqlsolutions@gmail.com"}
 * Date: 5/10/13
 * Time: 10:06 AM
 */
public class PetClinicSaveEventHandler implements ApplicationListener<EntitySaveEvent> {
    @Override
    public void onApplicationEvent(EntitySaveEvent entitySaveEvent) {
        System.out.println("entity save event handled:" + entitySaveEvent);
    }
}
