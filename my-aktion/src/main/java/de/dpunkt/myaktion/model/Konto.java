package de.dpunkt.myaktion.model;

public class Konto {
	private String name;
	private String nameDerBank;
	private String iban;
	private String bic;
	
	public Konto() {
		this(null, null, null, null);
	}
	
	public Konto(String name, String nameDerBank, String iban, String bic) {
		super();
		this.name = name;
		this.nameDerBank = nameDerBank;
		this.iban = iban;
		this.bic = bic;
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
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	

}
