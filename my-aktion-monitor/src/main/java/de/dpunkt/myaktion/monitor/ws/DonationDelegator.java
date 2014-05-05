package de.dpunkt.myaktion.monitor.ws;

import de.dpunkt.myaktion.model.Donation;
import de.dpunkt.myaktion.monitor.MonitorWebSocket;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService
public class DonationDelegator {

    private Logger logger = Logger.getLogger(DonationDelegator.class.getName());

    @WebMethod
    public void sendDonation(Long campaignId, Donation donation) {
        for (Session session : MonitorWebSocket.getSessions()) {
            Long clientCampaignId = (Long) session.getUserProperties().get(
                    MonitorWebSocket.CAMPAIGN_ID);
            if (campaignId.equals(clientCampaignId)) {
                try {
                    session.getBasicRemote().sendObject(donation);
                } catch (IOException | EncodeException e) {
                    logger.log(Level.INFO, "Keine Verbindung zu Client: "
                            + session, e);
                }
            }
        }
    }

}
