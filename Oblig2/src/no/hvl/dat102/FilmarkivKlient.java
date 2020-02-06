package no.hvl.dat102;

import no.hvl.dat102.adt.*;

public class FilmarkivKlient {

	public static void main(String[] args) {
		
		FilmarkivADT filmarkiv = Fil.lesFraFil("fil");
	
		Meny meny = new Meny(filmarkiv);
		
		meny.start();
		
		System.out.println("Program avsluttet");
		
	}
}
