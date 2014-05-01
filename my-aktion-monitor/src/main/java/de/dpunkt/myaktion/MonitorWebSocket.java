package de.dpunkt.myaktion;

import de.dpunkt.myaktion.model.Donation;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ServerEndpoint(value = "/donation", encoders = {DonationEncoder.class})
public class MonitorWebSocket {
    private Logger logger = Logger.getLogger(MonitorWebSocket.class.getName());

    @OnOpen
    public void onOpen(Session session) {
        logger.info("Client hat sich verbunden: " + session);
    }

    @OnClose
    public void onClose(Session session) {
        logger.info("Client hat Verbindung getrennt: " + session);
    }

    @OnMessage
    public void setCampaignId(Long campaignId, Session session) {
        logger.info("Client " + session.getId() + " hat Aktion " + campaignId
                + " ausgewählt.");
        try {
            Donation s1 = new Donation();
            s1.setAmount(20.0);
            s1.setDonorName("Heinz Schmidt");
            Donation s2 = new Donation();
            s2.setAmount(30.0);
            s2.setDonorName("Karl Meier");
            List<Donation> donations = Arrays.asList(s1, s2);
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
