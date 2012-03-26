package de.dpunkt.myaktion.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.dpunkt.myaktion.controller.AktionEditController.Mode;
import de.dpunkt.myaktion.model.Aktion;

@RequestScoped
@Named
public class AktionListController {
	@Inject
	private AktionEditController aktionEditController;

	@Inject
	private SpendeListController spendeListController;

	public String doAddAktion() {
		aktionEditController.setAktionToEdit(Mode.ADD);
		return Pages.AKTION_EDIT;
	}

	public String doEditAktion(Aktion aktion) {
		aktionEditController.setAktionToEdit(Mode.EDIT, aktion);
		return Pages.AKTION_EDIT;
	}

	public String doEditSpendeForm(Aktion aktion) {
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
