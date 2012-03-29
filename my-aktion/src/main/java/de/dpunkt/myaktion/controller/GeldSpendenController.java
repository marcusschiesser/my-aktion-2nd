package de.dpunkt.myaktion.controller;

import java.io.Serializable;

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
	private Long aktionId;
	private Spende spende;

	public GeldSpendenController() {
		this.spende = new Spende();
	}
	
	public Long getAktionId() {
		return aktionId;
	}

	public void setAktionId(Long aktionId) {
		this.aktionId = aktionId;
	}

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
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Vielen Dank für die Spende, "
								+ spende.getSpenderName() + "!", null));
		this.spende = new Spende();
		return Pages.GELD_SPENDEN;
	}

}
