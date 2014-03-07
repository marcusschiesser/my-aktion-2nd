package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.model.Spende.Status;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class SpendeListController implements Serializable {
    private static final long serialVersionUID = 437878972432L;

    public String doOk() {
        return Pages.AKTION_LIST;
    }

    public String convertStatus(Status status) {
        switch (status) {
            case UEBERWIESEN:
                return "überwiesen";
            case IN_BEARBEITUNG:
                return "in Bearbeitung";
            default:
                return "";
        }
    }

}
