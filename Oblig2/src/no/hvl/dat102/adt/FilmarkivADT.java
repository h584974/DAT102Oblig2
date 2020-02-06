package no.hvl.dat102.adt;

import no.hvl.dat102.*;

public interface FilmarkivADT {
	
	Film[] hentFilmTabell();
	
	void leggTilFilm(Film film);
	
	boolean slettFilm(int filmnummer);
	
	Film[] sokTittel(String tittelstreng);
	
	Film[] sokProdusent(String produsentstreng);
	
	int antallSjanger(Sjanger sjanger);
	
	int getAntall();
}
