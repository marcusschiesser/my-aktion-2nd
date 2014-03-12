package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.model.Donation.Status;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class ListDonationsController implements Serializable {
    private static final long serialVersionUID = 437878972432L;

    public String doOk() {
        return Pages.LIST_CAMPAIGNS;
    }

}
