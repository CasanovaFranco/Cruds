package org.example.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.entities.Affiliate;

@Named
public class AffiliateRepository implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "demo-crudWeb")
	private EntityManager em;

	public List<Affiliate> findAll() throws Exception {

		List<Affiliate> affiliates = new ArrayList<>();

		TypedQuery<Affiliate> query = em.createQuery("SELECT a FROM Affiliate a", Affiliate.class);
		affiliates = query.getResultList();

		return affiliates;
	}
	
	
	
	
	
	
	
	public void delete(Affiliate affiliate) throws Exception{
		em.remove(affiliate);	
		
		
		
		
	}
}
