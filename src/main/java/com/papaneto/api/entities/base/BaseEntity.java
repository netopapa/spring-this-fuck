package com.papaneto.api.entities.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public class BaseEntity {
	
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
}
