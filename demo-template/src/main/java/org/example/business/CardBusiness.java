package org.example.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.entities.Card;
import org.example.repository.CardRepository;

@Named
public class CardBusiness implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CardRepository cardRepository;
	
	
	
	@Transactional
	public Long insert(Card card) throws Exception{
		return cardRepository.insert(card);
	}
	
	
	
	@Transactional
	public Long update(Card card) throws Exception{
		return cardRepository.update(card);
	}
	
	
	
	@Transactional
	public void delete(Card card) throws Exception{
		cardRepository.delete(card);
	}
	

	
	public List<Card> getAll() throws Exception{
		return cardRepository.findAll();
	}
	
	
	public List<Card> getCardsByName(String name) throws Exception{
		return cardRepository.findByName(name);
	}
}



