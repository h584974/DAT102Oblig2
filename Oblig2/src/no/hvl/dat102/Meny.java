package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;
import java.util.Scanner;
import java.lang.NumberFormatException;

public class Meny {
	
	private FilmarkivADT filmarkiv;
	
	public Meny(FilmarkivADT filmarkiv) {
		this.filmarkiv = filmarkiv;
	}
	
	public void start()  {
		Scanner leser = new Scanner(System.in);
		int svar = 1;
		System.out.println("Hva �nsker du � gj�re? Skriv f�lgende for �nskede funksjoner:\n");
		
		while(true) {
			System.out.println("Avslutt: 1");
			System.out.println("Legg til ny film i samling: 2");
			System.out.println("Slett film fra samling: 3");
			System.out.println("Skriv ut statistikk om samling: 4");
			System.out.println("Skriv ut filmer ut i fra produsent: 5");
			System.out.println("Skriv ut film ut i fra tittel: 6");
			System.out.println("Skriv ut alle filmer i akriv: 7");
			System.out.println("Lagre filmarkiv til fil ved gitt navn: 8");
			System.out.println("Hent filmarkiv fra fil ved gitt navn: 9");
			
			try {
				svar = Integer.parseInt(leser.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Ugyldig svar angitt");
			}
			
			if(svar == 1) {
				break;
			} else if(svar == 2) {
				filmarkiv.leggTilFilm(Tekstgrensesnitt.lesFilm(leser));
				System.out.println("Film lagt til");
			} else if(svar == 3) {
				System.out.println("Skriv filmnummer:");
				int filmnummer = Integer.parseInt(leser.nextLine());
				boolean slettet = filmarkiv.slettFilm(filmnummer);
				if(slettet) {
					System.out.println("Film slettet");
				} else {
					System.out.println("Film ikke funnet");
				}
			} else if(svar == 4) {
				Tekstgrensesnitt.skrivUtStatistikk(filmarkiv);
			} else if(svar == 5) {
				System.out.println("Skriv produsent:");
				Tekstgrensesnitt.skrivUtFilmTabell(filmarkiv.sokProdusent(leser.nextLine()));
				System.out.println();
			} else if(svar == 6) {
				System.out.println("Skriv tittel:");
				Tekstgrensesnitt.skrivUtFilmTabell(filmarkiv.sokTittel(leser.nextLine()));
				System.out.println();
			} else if(svar == 7) {
				if(filmarkiv.getAntall() == 0) {
					System.out.println("Filmarkivet er tomt");
				} else {
					Tekstgrensesnitt.skrivUtFilmTabell(filmarkiv.hentFilmTabell());
				}
			} else if(svar == 8) {
				if(filmarkiv.getAntall() < 1) {
					System.out.println("Filmarkivet er tomt, ingenting � lagre til fil");
				} else {
					System.out.println("Skriv filnavn du �snker � lagre til");
					String filnavn = leser.nextLine();
					Fil.skrivTilFIl(filmarkiv, filnavn);
				}
			} else if(svar == 9) {
				System.out.println("Skriv filnavn du �snker � lese fra");
				String filnavn = leser.nextLine();
				filmarkiv = Fil.lesFraFil(filnavn);
			} else {
				System.out.println("Ingen gyldig svar angitt\n");
			}
			
			while(true) {
				try {
					System.out.println("Skriv 0 for � g� videre");
					int s = Integer.parseInt(leser.nextLine());
					if(s == 0) {
						break;
					}
				} catch(NumberFormatException e) {}
			}
		}
		
		leser.close();
	}

}
