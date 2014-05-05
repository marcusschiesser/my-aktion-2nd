package de.dpunkt.myaktion.monitor;

import de.dpunkt.myaktion.model.Donation;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Dependent
@ServerEndpoint(value = "/donation", encoders = {DonationEncoder.class})
public class MonitorWebSocket {
    public static final String CAMPAIGN_ID = "CampaignId";

    private Logger logger = Logger.getLogger(MonitorWebSocket.class.getName());

    @Inject
    private DonationListProvider donationListProvider;

    private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    public static Set<Session> getSessions() {
        return sessions;
    }

    @OnOpen
    public void onOpen(Session session) {
        logger.info("Client hat sich verbunden: " + session);
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        logger.info("Client hat Verbindung getrennt: " + session);
        sessions.remove(session);
    }

    @OnMessage
    public void setCampaignId(Long campaignId, Session session) {
        logger.info("Client " + session.getId() + " hat Aktion " + campaignId
                + " ausgewählt.");
        try {
            List<Donation> donations = new LinkedList<>();
            try {
                donations = donationListProvider.getDonationList(campaignId);
            } catch (NotFoundException e) {
                session.getBasicRemote().sendText(
                        "Die Aktion mit der ID: " + campaignId
                                + " ist nicht verfügbar"
                );
            } catch (WebApplicationException e) {
                logger.log(Level.SEVERE, "Die Spendenliste für Aktion mit ID: "
                        + campaignId
                        + " konnte nicht abgerufen werden. Läuft der JBoss?", e);
                session.getBasicRemote().sendText(
                        "Fehler beim Abruf der initialen Spendenliste.");
            }
            session.getUserProperties().put(CAMPAIGN_ID, campaignId);
            for (Donation donation : donations) {
                logger.info("Sende " + donation + " an Client " + session.getId());
                session.getBasicRemote().sendObject(donation);
            }
            session.getBasicRemote().sendText("Aktion geändert zu: " + campaignId);
        } catch (IOException | EncodeException e) {
            logger.log(Level.INFO, "Keine Verbindung zu Client: " + session, e);
        }
    }

}
