package org.example.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.entities.Supplier;

@Named
public class SupplierRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "demo-crudWeb")
	private EntityManager em;
	
	public List<Supplier> findAll()throws Exception{
		List<Supplier> suppliers=new ArrayList<>();	
		//SELECT s FROM Supplier s ==> JPQL Java Persistence Query Language
		TypedQuery<Supplier> query=em.createQuery("SELECT s FROM Supplier s", Supplier.class);
		suppliers=query.getResultList();		
		return suppliers;
	}
	
}
