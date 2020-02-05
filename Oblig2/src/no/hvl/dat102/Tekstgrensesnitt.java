package no.hvl.dat102;

import java.util.Scanner;
import no.hvl.dat102.adt.*;

public class Tekstgrensesnitt {

	public static void skrivUtFilmDelstrengTittel(FilmarkivADT filmarkiv, String tittelstreng) {
		skrivUtFilmTabell(filmarkiv.sokTittel(tittelstreng));
	}
	
	public static void skrivUtFilmDelstrengProdusent(FilmarkivADT filmarkiv, String produsentstreng) {
		skrivUtFilmTabell(filmarkiv.sokProdusent(produsentstreng));
	}
	
	public static void skrivUtStatistikk(FilmarkivADT filmarkiv) {
		int antall = filmarkiv.getAntall();
		int antallFANTASI = filmarkiv.antallSjanger(Sjanger.FANTASI);
		int antallSCIFI = filmarkiv.antallSjanger(Sjanger.SCIFI);
		int antallDOKUMENTAR = filmarkiv.antallSjanger(Sjanger.DOKUMENTAR);
		
		System.out.println("-----------------------------------");
		System.out.println(String.format("%20s", "Antall filmer:") + "   " + String.format("%5d", antall));
		System.out.println(String.format("%20s", "Antall FANTASI:") + "   " + String.format("%5d", antallFANTASI));
		System.out.println(String.format("%20s", "Antall SCIFI:") + "   " + String.format("%5d", antallSCIFI));
		System.out.println(String.format("%20s", "Antall DOKUMENTAR:") + "   " + String.format("%5d", antallDOKUMENTAR));
		System.out.println("-----------------------------------");
	}
	
	public static Film lesFilm(Scanner leser) {
		System.out.println("Skriv Filmnummer:");
		int filmnummer = Integer.parseInt(leser.nextLine());
		while(filmnummer < 0) {
			System.out.println("Filmnummer kan ikke være negativ");
			filmnummer = Integer.parseInt(leser.nextLine());
		}
		
		System.out.println("Skriv Tittel:");
		String tittel = leser.nextLine();
		
		System.out.println("Skriv utgivelseår");
		int utgivelseaar = Integer.parseInt(leser.nextLine());
		while(utgivelseaar < 0) {
			System.out.println("Utgivelseår kan ikke være negativ");
			utgivelseaar = Integer.parseInt(leser.nextLine());
		}
		
		System.out.println("Skriv sjanger (SCIFI, DOKUMENTAR, FANTASI):");
		Sjanger sjanger = Sjanger.finnSjanger(leser.nextLine());
		while(sjanger == null) {
			System.out.println("Ugyldig sjanger valgt, prøv igjen:");
			sjanger = Sjanger.finnSjanger(leser.nextLine());
		}
		
		System.out.println("Skriv filmselskap:");
		String filmselskap = leser.nextLine();
		
		System.out.println("Skriv produsent");
		String produsent = leser.nextLine();
		
		Film film = new Film(filmnummer, produsent, tittel, utgivelseaar, sjanger, filmselskap);
		
		return film;
		
	}
	
	public static void skrivUtFilmTabell(Film[] filmer) {
		
		System.out.println("----------------------------------------");
		for(Film i : filmer) {
			visFilm(i);
			System.out.println("----------------------------------------");
		}
	}
	
	public static void visFilm(Film film) {
		
		try {
			String output = String.format("%15s", "Filmnummer") + String.format("%25d",film.getFilmnummer()) + "\n";
			output += String.format("%15s", "Tittel:") + String.format("%25s", film.getTittel()) + "\n";
			output += String.format("%15s", "Sjanger:") + String.format("%25s", film.getSjanger()) + "\n";
			output += String.format("%15s", "År utgitt:") + String.format("%25d", film.getUtgivelseaar()) + "\n";
			output += String.format("%15s", "Filmselskap:") + String.format("%25s", film.getFilmselskap()) + "\n";
			output += String.format("%15s", "Produsent:") + String.format("%25s", film.getProdusent());
		
			System.out.println(output);
		} catch(NullPointerException e) {
			System.out.println("NullPointerException, verdi for Film ikke funnet i Tekstgrensesnitt.visFilm");
		}
	}
	
}
