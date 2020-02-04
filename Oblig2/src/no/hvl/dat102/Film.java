package no.hvl.dat102;

public class Film {
	
	private int filmnummer;
	private String produsent;
	private String tittel;
	private int utgivelseaar;
	private Sjanger sjanger;
	private String filmselskap;
	
	public Film() {
		this(0,null,null,0,null,null);
	}
	
	public Film(int filmnummer, String produsent, String tittel, int utgivelseaar, Sjanger sjanger, String filmselskap) {
		this.filmnummer = filmnummer;
		this.produsent = produsent;
		this.tittel = tittel;
		this.utgivelseaar = utgivelseaar;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;
	}

	public int getFilmnummer() {
		return filmnummer;
	}

	public void setFilmnummer(int filmnummer) {
		this.filmnummer = filmnummer;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getUtgivelseaar() {
		return utgivelseaar;
	}

	public void setUtgivelseaar(int utgivelseaar) {
		this.utgivelseaar = utgivelseaar;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmselskap() {
		return filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}

}
