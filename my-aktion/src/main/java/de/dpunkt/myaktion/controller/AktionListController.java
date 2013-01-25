package de.dpunkt.myaktion.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.dpunkt.myaktion.controller.AktionEditController.Mode;
import de.dpunkt.myaktion.model.Aktion;

@SessionScoped
@Named
public class AktionListController implements Serializable {

	private static final long serialVersionUID = 25875238972L;

	@Inject
	private AktionEditController aktionEditController;

	@Inject
	private SpendeListController spendeListController;
	
	@Inject
	private SpendeFormEditController spendeFormEditController;

	public String doAddAktion() {
		aktionEditController.setAktionToEdit(Mode.ADD);
		return Pages.AKTION_EDIT;
	}

	public String doEditAktion(Aktion aktion) {
		aktionEditController.setAktionToEdit(Mode.EDIT, aktion);
		return Pages.AKTION_EDIT;
	}

	public String doEditSpendeForm(Aktion aktion) {
		spendeFormEditController.setAktion(aktion);
		return Pages.SPENDE_FORM_EDIT;
	}

	public String doListSpende(Aktion aktion) {
		spendeListController.setAktion(aktion);
		return Pages.SPENDE_LIST;
	}

	public void doDeleteAktion(Aktion aktion) {
		System.out.println("Aktion löschen noch nicht implementiert");
	}

}
