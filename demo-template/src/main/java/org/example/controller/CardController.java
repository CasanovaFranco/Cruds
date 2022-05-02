package org.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.example.business.CardBusiness;
import org.example.business.MethodBusiness;
import org.example.business.TravelPlanBusiness;
import org.example.entities.Card;
import org.example.entities.Method;
import org.example.entities.TravelPlan;
import org.example.util.Message;
import org.primefaces.event.SelectEvent;

@Named
@SessionScoped
public class CardController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CardBusiness cardBusiness;

	@Inject
	private TravelPlanBusiness travelplanbusiness;
	
	@Inject
	private MethodBusiness methodBusiness;
	

	private Card card;
	private Card cardSelected;
	private List<Card> cards;

	private TravelPlan travelplan;
	private List<TravelPlan> travelplans;
	
	private Method method;
	private List<Method> methods;
	


	private String filterName;

	@PostConstruct
	public void init() {

		card = new Card();
		cardSelected = new Card();
		cards = new ArrayList<>();

		travelplan = new TravelPlan();
		travelplans = new ArrayList<>();
		

		getAllCards();
		getAllTravelPlans();
		getAllMethods();

	}

	public void getAllCards() {
		try {
			cards = cardBusiness.getAll();
		} catch (Exception e) {

		}
	}
	
	
	public void getAllTravelPlans() {
		try {
			this.travelplans = travelplanbusiness.getAll();
		} catch (Exception e) {

		}
	}
	
	public void getAllMethods() {
		try {
			this.methods = methodBusiness.getAllMethod();
		} catch (Exception e) {

		}
	}
	
	

	public String newCard() {
		try {
			getAllTravelPlans();
			getAllMethods();
			this.resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert.xhtml";
	}

	public String saveCard() {
		String view = "";

		try {
			if (card.getId() != null) {// update
				card.setTravelplan(travelplan);
				card.setMethod(method);
				cardBusiness.update(card);
				Message.messageInfo("Registro actualizado exitosamente");

			} else {// save
				card.setTravelplan(travelplan);
				card.setMethod(method);
				cardBusiness.insert(card);
				Message.messageInfo("Registro guardado exitosamente");
			}
			this.getAllCards();
			this.resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error CardController:" + e.getMessage());
		}

		return view;
	}
	


	public String editCard() {
		String view = "";
		try {
			if (this.cardSelected != null) {
				this.card = cardSelected;
				view = "/card/update";
			} else {
				Message.messageInfo("Debe seleccionar una tarjeta");
			}

		} catch (Exception e) {
			Message.messageError("Error CardController:" + e.getMessage());
		}

		return view;
	}
	
	public String deleteCard() {
		String view = "";
		try {
			if (this.cardSelected != null) {				
				cardBusiness.delete(cardSelected);
				getAllCards();
				view = "/card/list";
			} else {
				Message.messageInfo("Debe seleccionar una tarjeta");
			}

		} catch (Exception e) {
			Message.messageError("Error CardController:" + e.getMessage());
		}

		return view;
	}

	

	public void selectCard(SelectEvent e) {
		this.cardSelected = (Card) e.getObject();
	}

	public void resetForm() {
		card = new Card();
	}
	

	public void searchCardByName() {
		try {
			cards = cardBusiness.getCardsByName(filterName.trim());
			resetForm();

			if (cards.isEmpty()) {
				Message.messageInfo("No se encontraron tarjetas con dicho nombre");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	

	public String listCard() {
		return "list.xhtml";
	}

	
	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public List<Method> getMethods() {
		return methods;
	}

	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Card getCardSelected() {
		return cardSelected;
	}

	public void setCardSelected(Card cardSelected) {
		this.cardSelected = cardSelected;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
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

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	
}
