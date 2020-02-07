package no.hvl.dat102;

import java.util.Scanner;
import no.hvl.dat102.adt.*;

public class FilmarkivKlient {

	public static void main(String[] args) {
		Scanner leser = new Scanner(System.in);
		System.out.println("Skriv filnavn p� arkiv du �nsker � �pne, eller skriv '1' for � opprette nytt arkiv");
		String svar = leser.nextLine();
		FilmarkivADT filmarkiv;
		if(svar.equals("1")) {
			filmarkiv = new Filmarkiv2();
		} else {
			filmarkiv = Fil.lesFraFil(svar);
		}
		Meny meny = new Meny(filmarkiv);
		meny.start();
		leser.close();
		System.out.println("Program avsluttet");
	}
}