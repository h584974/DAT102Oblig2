package no.hvl.dat102;

import java.util.Scanner;
import no.hvl.dat102.adt.*;

public class FilmarkivKlient {

	public static void main(String[] args) {
		Scanner leser = new Scanner(System.in);
		System.out.println("Skriv filnavn på arkiv du ønsker å åpne, eller skriv '1' for å opprette nytt arkiv");
		String svar = leser.nextLine();
		leser.close();
		FilmarkivADT filmarkiv;
		if(svar.equals("1")) {
			filmarkiv = new Filmarkiv2();
		} else {
			filmarkiv = Fil.lesFraFil(svar);
		}
		Meny meny = new Meny(filmarkiv);
		meny.start();
		
		System.out.println("Program avsluttet");
	}
}