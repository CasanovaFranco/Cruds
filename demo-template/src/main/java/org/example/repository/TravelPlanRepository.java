package org.example.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.entities.TravelPlan;

@Named
public class TravelPlanRepository implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "demo-crudWeb")
	private EntityManager em;

	public Long insert(TravelPlan travelplan) throws Exception {
		em.persist(travelplan);
		return travelplan.getId();
	}

	public Long update(TravelPlan travelplan) throws Exception {
		em.merge(travelplan);
		return travelplan.getId();
	}
	
	public void delete(TravelPlan travelplan) throws Exception {
		em.remove(em.merge(travelplan));
	}

	public List<TravelPlan> findAll() throws Exception {

		List<TravelPlan> travelplans = new ArrayList<>();

		TypedQuery<TravelPlan> query = em.createQuery("FROM TravelPlan t", TravelPlan.class);
		travelplans = query.getResultList();

		return travelplans;
	}

	public List<TravelPlan> findByName(String name) throws Exception {

		List<TravelPlan> travelplans = new ArrayList<>();
		TypedQuery<TravelPlan> query = em.createQuery("FROM TravelPlan t WHERE t.name LIKE ?1", TravelPlan.class);
		query.setParameter(1, "%" + name + "%");
		travelplans = query.getResultList();
		return travelplans;
	}
}