package de.dpunkt.myaktion.model;

import java.util.List;

public class Aktion {
    private String name;
    private Double spendenZiel;
    private Double spendenBetrag;
    private Double bisherGespendet;
    private Konto konto;
    private Long aktionId;
    private List<Spende> spenden;

    public Aktion() {
        konto = new Konto();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSpendenZiel() {
        return spendenZiel;
    }

    public void setSpendenZiel(Double spendenZiel) {
        this.spendenZiel = spendenZiel;
    }

    public Double getSpendenBetrag() {
        return spendenBetrag;
    }

    public void setSpendenBetrag(Double spendenBetrag) {
        this.spendenBetrag = spendenBetrag;
    }

    public Double getBisherGespendet() {
        return bisherGespendet;
    }

    public void setBisherGespendet(Double bisherGespendet) {
        this.bisherGespendet = bisherGespendet;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }

    public void setId(Long aktionId) {
        this.aktionId = aktionId;
    }

    public Long getId() {
        return aktionId;
    }

    public List<Spende> getSpenden() {
        return spenden;
    }

    public void setSpenden(List<Spende> spenden) {
        this.spenden = spenden;
    }

}
