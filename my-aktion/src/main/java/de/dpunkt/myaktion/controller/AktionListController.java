package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.data.AktionProducer;
import de.dpunkt.myaktion.model.Aktion;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class AktionListController implements Serializable {

    private static final long serialVersionUID = 8693277383648025822L;

    @Inject
    private AktionProducer aktionProducer;

    public String doAddAktion() {
        aktionProducer.prepareAddAktion();
        return Pages.AKTION_EDIT;
    }

    public String doEditAktion(Aktion aktion) {
        aktionProducer.prepareEditAktion(aktion);
        return Pages.AKTION_EDIT;
    }

    public String doEditSpendeForm(Aktion aktion) {
        aktionProducer.setSelectedAktion(aktion);
        return Pages.SPENDE_FORM_EDIT;
    }

    public String doListSpende(Aktion aktion) {
        aktionProducer.setSelectedAktion(aktion);
        return Pages.SPENDE_LIST;
    }

    public void doDeleteAktion(Aktion aktion) {
        System.out.println("Aktion löschen noch nicht implementiert");
    }

}
