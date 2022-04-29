package org.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.example.business.AffiliateBusiness;
import org.example.business.TravelPlanBusiness;
import org.example.entities.Affiliate;
import org.example.entities.TravelPlan;
import org.example.util.Message;
import org.primefaces.event.SelectEvent;

@Named
@SessionScoped
public class TravelPlanController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TravelPlanBusiness travelplanBusiness;
	@Inject
	private AffiliateBusiness affiliateBusiness;

	private TravelPlan travelplan;
	private TravelPlan travelplanSelected;
	private List<TravelPlan> travelplans;

	private Affiliate affiliate;
	private List<Affiliate> affiliates;

	private String filterName;

	@PostConstruct
	public void init() {
		travelplan = new TravelPlan();
		travelplanSelected = new TravelPlan();
		travelplans = new ArrayList<>();

		affiliate = new Affiliate();
		affiliates = new ArrayList<>();

		getAllTravelPlans();
	}

	public void getAllTravelPlans() {
		try {
			travelplans = travelplanBusiness.getAll();
		} catch (Exception e) {

		}
	}

	public String newTravelPlan() {
		try {
			this.affiliates = affiliateBusiness.getAllAffiliates();
			this.resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "insert.xhtml";
	}

	public String saveTravelPlan() {
		String view = "";

		try {
			if (travelplan.getId() != null) {
				travelplan.setAffiliate(affiliate);
				travelplanBusiness.update(travelplan);
				Message.messageInfo("Registro actualizado exitosamente");

			} else {
				travelplan.setAffiliate(affiliate);
				travelplanBusiness.insert(travelplan);
				Message.messageInfo("Registro guardado exitosamente");
			}

			this.getAllTravelPlans();
			this.resetForm();
			view = "list";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Message.messageInfo("Error TravelPlanController:" + e.getMessage());
		}

		return view;
	}

	public String editTravelPlan() {
		String view = "";

		try {
			if (this.travelplanSelected != null) {
				this.travelplan = travelplanSelected;
				view = "/travelplan/update";

			} else {

				Message.messageInfo("Debe seleccionar un plan");
			}
		} catch (Exception e) {
			Message.messageInfo("Error TravelPlanController:" + e.getMessage());
		}

		return view;

	}
	
	public String deletePlanTravel() {
		String view = "";
		try {
			if (this.travelplanSelected != null) {				
				travelplanBusiness.delete(travelplanSelected);
				getAllTravelPlans();
				view = "/travelplan/list";
			} else {
				Message.messageInfo("Debe seleccionar un plan");
			}

		} catch (Exception e) {
			Message.messageError("Error CardController:" + e.getMessage());
		}

		return view;
	}
	
	

	public void selectTravelPlan(SelectEvent e) {
		this.travelplanSelected = (TravelPlan) e.getObject();

	}

	
	public void resetForm() {
		travelplan = new TravelPlan();
	}
	

	public void searchTravelPlanByName() {
		try {
			travelplans = travelplanBusiness.getTravelPlanByName(filterName.trim());
			resetForm();
			if (travelplans.isEmpty()) {
				Message.messageInfo("No se encontraron planes con dicho nombre");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public String listTravelPlan() {
		return "list.xhtml";
	}

	
	public TravelPlan getTravelplan() {
		return travelplan;
	}

	
	public void setTravelplan(TravelPlan travelplan) {
		this.travelplan = travelplan;
	}

	
	public List<TravelPlan> getTravelplans() {
		return travelplans;
	}

	public void setTravelplans(List<TravelPlan> travelplans) {
		this.travelplans = travelplans;
	}

	public Affiliate getAffiliate() {
		return affiliate;
	}

	public void setAffiliate(Affiliate affiliate) {
		this.affiliate = affiliate;
	}

	public List<Affiliate> getAffiliates() {
		return affiliates;
	}

	public void setAffiliates(List<Affiliate> affiliates) {
		this.affiliates = affiliates;
	}

	public TravelPlan getTravelplanSelected() {
		return travelplanSelected;
	}

	public void setTravelplanSelected(TravelPlan travelplanSelected) {
		this.travelplanSelected = travelplanSelected;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

}
