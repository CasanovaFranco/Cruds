package org.example.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.example.entities.Card;

@Named
public class CardRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "demo-crudWeb")
	private EntityManager em;
	
	public Long insert(Card card) throws Exception{
		em.persist(card);
		return card.getId();
	}
	
	public Long update(Card card) throws Exception{
		em.merge(card);
		return card.getId();
	}
	
	public void delete(Card card) throws Exception{
		em.remove(em.merge(card));		
	}
	
	public List<Card> findAll()  throws Exception{
		List<Card> cards=new ArrayList<>();
		TypedQuery<Card> query=em.createQuery("FROM Card c", Card.class);
		cards=query.getResultList();		
		return cards;
	}
	
	
	public List<Card> findByName(String name)  throws Exception{
		List<Card> cards=new ArrayList<>();
		TypedQuery<Card> query=em.createQuery("FROM Card c WHERE c.name LIKE ?1", Card.class);
		query.setParameter(1, "%"+name+"%");
		cards=query.getResultList();		
		return cards;
	}
}





