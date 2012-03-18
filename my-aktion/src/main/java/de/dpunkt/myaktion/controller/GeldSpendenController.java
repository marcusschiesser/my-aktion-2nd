package de.dpunkt.myaktion.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import de.dpunkt.myaktion.model.Spende;

@SessionScoped
@Named
public class GeldSpendenController implements Serializable {
	private static final long serialVersionUID = 5493038842003809106L;

	private String textColor = "000000";
	private String bgColor = "ffffff";
	private Spende spende;
	
	public Spende getSpende() {
		return spende;
	}

	public void setSpende(Spende spende) {
		this.spende = spende;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}


	public String getBgColor() {
		return bgColor;
	}


	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String doSpende() {
		FacesContext.getCurrentInstance().
        	addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Vielen Dank für die Spende, " + spende.getSpenderName() + "!", null));
		this.spende = new Spende();
		return Pages.GELD_SPENDEN;
	}
	
	@PostConstruct
	public void init() {
		this.spende = new Spende();
	}
}
