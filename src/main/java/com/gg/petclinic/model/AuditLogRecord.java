package com.gg.petclinic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity 
@Table(name="audit_logs")
public class AuditLogRecord extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name="message",nullable=false)
	public String message;
	
	@Column(name="entity_id",nullable=false)
	public Long entityId;
	
	@Column(name="entity_class",nullable=false)
	public Class<? extends BaseEntity> entityClass;
	
	@Column(name="user_id",nullable=false)
	public Long userId;
	
	@Column(name="created",nullable=false)
    public Date created;

	AuditLogRecord() {}

	public AuditLogRecord(String message,
						  Long entityId,
						  Class<? extends BaseEntity> entityClass,
						  Long userId) {
		this.message = message;
		this.entityId = entityId;
		this.entityClass = entityClass;
		this.userId = userId;
		this.created = new Date();
	}
    
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }

	public String getMessage() {
		return message;
	}

	public Long getEntityId() {
		return entityId;
	}

	public Class<? extends BaseEntity> getEntityClass() {
		return entityClass;
	}

	public Long getUserId() {
		return userId;
	}

	public Date getCreated() {
		return created;
	}
}
