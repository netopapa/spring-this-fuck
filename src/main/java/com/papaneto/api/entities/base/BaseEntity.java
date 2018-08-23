package com.papaneto.api.entities.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;

public class BaseEntity {
	
	@Getter
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
}
