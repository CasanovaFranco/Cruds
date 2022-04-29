package org.example.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.entities.TravelPlan;
import org.example.repository.TravelPlanRepository;

@Named

public class TravelPlanBusiness implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private TravelPlanRepository travelPlanRepository;

	
	@Transactional
	public Long insert(TravelPlan travelplan) throws Exception {
		return travelPlanRepository.insert(travelplan);
	}

	
	@Transactional
	public Long update(TravelPlan travelplan) throws Exception {
		return travelPlanRepository.update(travelplan);
	}
	

	@Transactional
	public void delete(TravelPlan travelplan) throws Exception {
	travelPlanRepository.delete(travelplan);
	}
	
	

	
	public List<TravelPlan> getAll() throws Exception {
		return travelPlanRepository.findAll();

	}

	
	public List<TravelPlan> getTravelPlanByName(String name) throws Exception {
		return travelPlanRepository.findByName(name);

	}

}
