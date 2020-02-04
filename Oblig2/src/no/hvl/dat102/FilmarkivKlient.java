package no.hvl.dat102;

import no.hvl.dat102.adt.*;

public class FilmarkivKlient {

	public static void main(String[] args) {
		
		FilmarkivADT filmarkiv = new Filmarkiv2();
		
		filmarkiv.leggTilFilm(new Film(1,"produsent", "tittel", 1999, Sjanger.FANTASI, "Selskap"));
		
		Meny meny = new Meny(filmarkiv);
		
		meny.start();
		
		System.out.println("Program avsluttet");
		
	}
}
