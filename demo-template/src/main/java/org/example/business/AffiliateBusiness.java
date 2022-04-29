package org.example.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.entities.Affiliate;
import org.example.repository.AffiliateRepository;

@Named

public class AffiliateBusiness implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private AffiliateRepository affiliateRepository;

	public List<Affiliate> getAllAffiliates() throws Exception {
		return affiliateRepository.findAll();

	}
	
	
	
	
	
	@Transactional
	public void delete(Affiliate affiliate) throws Exception{
		affiliateRepository.delete(affiliate);
	}

}
