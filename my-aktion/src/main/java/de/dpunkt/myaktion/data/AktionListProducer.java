package de.dpunkt.myaktion.data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.dpunkt.myaktion.model.Aktion;
import de.dpunkt.myaktion.model.Konto;
import de.dpunkt.myaktion.model.Spende;
import de.dpunkt.myaktion.model.Spende.Status;

@SessionScoped
@Named
public class AktionListProducer implements Serializable {

	private static final long serialVersionUID = -182866064791747156L;

	private List<Aktion> aktionen;

	public AktionListProducer() {
		aktionen = createMockAktionen();
	}

	public List<Aktion> getAktionen() {
		return aktionen;
	}

	public List<Aktion> createMockAktionen() {

		Spende spende1 = new Spende();
		spende1.setSpenderName("Heinz Schmidt");
		spende1.setBetrag(20d);
		spende1.setQuittung(true);
		spende1.setStatus(Status.UEBERWIESEN);
		spende1.setKonto(new Konto(spende1.getSpenderName(), "XXX Bank",
				"123456", "87654321"));
		Spende spende2 = new Spende();
		spende2.setSpenderName("Karl Meier");
		spende2.setBetrag(30d);
		spende2.setQuittung(false);
		spende2.setStatus(Status.IN_BEARBEITUNG);
		spende2.setKonto(new Konto(spende2.getSpenderName(), "YYY Bank",
				"654321", "86427531"));
		List<Spende> spenden = new LinkedList<Spende>();
		spenden.add(spende1);
		spenden.add(spende2);

		Aktion aktion1 = new Aktion();
		aktion1.setName("Trikots für A-Jugend");
		aktion1.setSpendenZiel(1000d);
		aktion1.setBisherGespendet(258d);
		aktion1.setSpendenBetrag(20d);
		aktion1.setKonto(new Konto("Max Mustermann", "ABC Bank", "100200300",
				"12345678"));
		aktion1.setSpenden(spenden);

		Aktion aktion2 = new Aktion();
		aktion2.setName("Rollstuhl für Maria");
		aktion2.setSpendenZiel(2500d);
		aktion2.setBisherGespendet(742d);
		aktion2.setSpendenBetrag(25d);
		aktion2.setKonto(aktion1.getKonto());
		aktion2.setSpenden(spenden);

		List<Aktion> ret = new LinkedList<Aktion>();
		ret.add(aktion1);
		ret.add(aktion2);
		return ret;
	}
}
