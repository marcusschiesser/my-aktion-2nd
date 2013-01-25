package de.dpunkt.myaktion.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import de.dpunkt.myaktion.model.Aktion;

@SessionScoped
@Named
public class SpendeFormEditController implements Serializable {
	
	private static final long serialVersionUID = -4210085664588144340L;

	private String textColor = "000000";
	private String bgColor = "ffffff";
	private Aktion aktion;

	public String doOk() {
		return Pages.AKTION_LIST;
	}
	
	private String getAppUrl() {
		HttpServletRequest req =
			(HttpServletRequest)FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();

		String scheme = req.getScheme();             
		String serverName = req.getServerName();     
		int serverPort = req.getServerPort();        
		String contextPath = req.getContextPath();   
		
		return scheme+"://"+serverName+":"+serverPort+contextPath;		
	}
	
	public String getUrl() {
		return getAppUrl()+"/"+Pages.GELD_SPENDEN+".jsf" + "?bgColor=" + bgColor
				 + "&textColor=" + textColor + "&aktionId=" + aktion.getId();
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
	
	public Aktion getAktion() {
		return aktion;
	}

	public void setAktion(Aktion aktion) {
		this.aktion = aktion;
	}

}
