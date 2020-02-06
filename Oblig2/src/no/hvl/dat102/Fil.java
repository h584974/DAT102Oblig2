package no.hvl.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import no.hvl.dat102.adt.FilmarkivADT;

public class Fil {

	private final static String SKILLE = "#";
	
	public static Filmarkiv2 lesFraFil(String filnavn) {
		
		FileReader filleser = null;
		Filmarkiv2 filmarkiv = new Filmarkiv2();
		
		try {
			filleser = new FileReader(filnavn);
		} catch(FileNotFoundException e) {
			System.out.println("Fil ikke funnet");
			System.exit(1);
		}
		
		try {
			BufferedReader leser = new BufferedReader(filleser);
			leser.readLine();
			
			while(true) {
				String tempstring = leser.readLine();
			
				if(tempstring == null || tempstring.equals("")) {
					break;
				}
			
				String[] stringliste = tempstring.split(SKILLE);
				
				int filmnummer = Integer.parseInt(stringliste[0]);
				String tittel = stringliste[1];
				int utgivelseaar = Integer.parseInt(stringliste[2]);
				Sjanger sjanger = Sjanger.finnSjanger(stringliste[3]);
				String filmselskap = stringliste[4];
				String produsent = stringliste[5];
				filmarkiv.leggTilFilm(new Film(filmnummer, produsent, tittel, utgivelseaar, sjanger, filmselskap));
			}
			leser.close();
		} catch(IOException e) {
			System.out.println("IOException leser");
			System.exit(2);
		}
		return filmarkiv;
	}
	
	public static void skrivTilFIl(FilmarkivADT filmarkiv, String filnavn) {
		
		try {
			FileWriter filskriver = new FileWriter(filnavn);
			
			BufferedWriter skriver = new BufferedWriter(filskriver);
			
			Film[] filmtabell = filmarkiv.hentFilmTabell();
			skriver.write(filmarkiv.getAntall() + "\n");
			
			for(int i = 0; i < filmtabell.length; i++) {
				String filmstreng = "";
				filmstreng += filmtabell[i].getFilmnummer() + SKILLE;
				filmstreng += filmtabell[i].getTittel() + SKILLE;
				filmstreng += filmtabell[i].getUtgivelseaar() + SKILLE;
				filmstreng += filmtabell[i].getSjanger() + SKILLE;
				filmstreng += filmtabell[i].getFilmselskap() + SKILLE;
				filmstreng += filmtabell[i].getProdusent() + "\n";
				skriver.write(filmstreng);
			}
			
			skriver.close();
			
		} catch(IOException e) {
			System.out.println("IOException skriver");
			System.exit(3);
		}
		
	}
	
}