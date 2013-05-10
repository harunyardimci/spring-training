package com.gg.petclinic.event;

import com.gg.petclinic.model.BaseEntity;
import org.springframework.context.ApplicationEvent;

/**
 * Created with IntelliJ IDEA.
 * User: { "id": "hyardimci", "email":nosqlsolutions@gmail.com"}
 * Date: 5/10/13
 * Time: 9:59 AM
 */
public class EntitySaveEvent extends ApplicationEvent {

    private BaseEntity entity;

    public EntitySaveEvent(Object source) {
        super(source);
    }

    public BaseEntity getEntity() {
        return entity;
    }

    public void setEntity(BaseEntity entity) {
        this.entity = entity;
    }
}
