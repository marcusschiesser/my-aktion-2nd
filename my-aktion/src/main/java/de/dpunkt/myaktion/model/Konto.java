package de.dpunkt.myaktion.model;

public class Konto {
	private String name;
	private String nameDerBank;
	private String iban;

    public Konto() {
		this(null, null, null);
	}
	
	public Konto(String name, String nameDerBank, String iban) {
		super();
		this.name = name;
		this.nameDerBank = nameDerBank;
		this.iban = iban;
    }

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameDerBank() {
		return nameDerBank;
	}
	public void setNameDerBank(String nameDerBank) {
		this.nameDerBank = nameDerBank;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}


}
