package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.data.AktionListProducer;
import de.dpunkt.myaktion.data.AktionProducer;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class AktionEditController implements Serializable {
    private static final long serialVersionUID = 2815796004558360299L;

    @Inject
    private AktionListProducer aktionListProducer;

    @Inject
    private AktionProducer aktionProducer;

    public String doSave() {
        if (aktionProducer.isAddMode()) {
            aktionListProducer.getAktionen().add(aktionProducer.getSelectedAktion());
        }
        return Pages.AKTION_LIST;
    }

    public String doCancel() {
        return Pages.AKTION_LIST;
    }

}
