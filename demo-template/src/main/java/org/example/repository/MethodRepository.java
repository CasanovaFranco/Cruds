package org.example.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.entities.Method;

@Named
public class MethodRepository implements  Serializable{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "demo-crudWeb")
	private EntityManager em;

	public List<Method> findAllMethods() throws Exception {

		List<Method> methods = new ArrayList<>();

		TypedQuery<Method> query = em.createQuery("SELECT m FROM Method m", Method.class);
		methods = query.getResultList();

		return methods;
	}
	
}
