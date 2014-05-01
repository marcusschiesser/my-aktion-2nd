package de.dpunkt.myaktion.monitor;

import de.dpunkt.myaktion.model.Donation;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import java.text.NumberFormat;

public class DonationEncoder implements Encoder.Text<Donation> {
    @Override
    public String encode(Donation donation) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        String amount = format.format(donation.getAmount());
        Object args[] = {donation.getDonorName(), amount};
        return String.format("%s hat %s gespendet.", args);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(EndpointConfig arg0) {
    }

}
