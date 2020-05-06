package com.rcom.red.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rcom.red.resource.Constants;


public class GenericEntityManager {

	@PersistenceContext(unitName = Constants.PresistenceUnit)
	protected EntityManager entityManager;
	
	
}
