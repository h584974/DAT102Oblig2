package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
	
	private int antall;
	private LinearNode<Film> start;

	public Filmarkiv2() {
		this.antall = 0;
		this.start = new LinearNode<Film>();
	}
	
	@Override
	public int getAntall() {
		return this.antall;
	}
	
	@Override
	public Film[] hentFilmTabell() {
		
		Film[] filmer = new Film[this.antall];
		LinearNode<Film> node = start;
		int indeks = 0;
		
		while(node.getElement() != null) {
			filmer[indeks] = node.getElement();
			indeks++;
			if(indeks == this.antall) {
				break;
			}
		}
		forkortFilmTabell(filmer);
		
		System.out.println("REEEE: " + filmer.length);
		return filmer;
	}
	
	public static void forkortFilmTabell(Film[] filmer) {
		
		int indeks = -1;
		
		for(int i = 0; i < filmer.length; i++) {
			if(filmer[i] == null) {
				indeks = i;
				break;
			}
		}
		
		if(indeks > -1) {
			Film[] tempfilmer = new Film[indeks];
			
			for(int i = 0; i < tempfilmer.length; i++) {
				tempfilmer[i] = filmer[i];
			}
			
			filmer = tempfilmer;
		}
	}
	
	@Override
	public void leggTilFilm(Film film) {
		
		LinearNode<Film> node = new LinearNode<Film>(film);
		
		node.setNeste(this.start);
		
		this.start = node;
		
		this.antall++;
	}
	
	@Override
	public boolean slettFilm(int filmnummer) {
		
		if(this.start.getElement().getFilmnummer() == filmnummer) {
			this.start = this.start.getNeste();	
			return true;
		} else{
			LinearNode<Film> node = this.start.getNeste();
			LinearNode<Film> forrige = this.start;
		
			while(node.getElement() != null) {
				if(node.getElement().getFilmnummer() == filmnummer) {
					forrige.setNeste(node.getNeste());
					node.setElement(null);
					node = null;
					return true;
				} else{
					node = node.getNeste();
					forrige = forrige.getNeste();
				}
			}
		}
		return false;
	}
	
	@Override
	public Film[] sokTittel(String titteldelstreng) {
		
		Film[] filmer = new Film[this.antall];
		LinearNode<Film> node = start;
		int indeks = 0;
		
		while(node.getElement() != null) {
			if(node.getElement().getTittel().toLowerCase().contains(titteldelstreng.toLowerCase())) {
				filmer[indeks] = node.getElement();
			}
			indeks++;
			node = node.getNeste();
		}
		forkortFilmTabell(filmer);
		return filmer;
	}
	
	@Override
	public Film[] sokProdusent(String produsentdelstreng) {
		
		Film[] filmer = new Film[this.antall];
		LinearNode<Film> node = start;
		int indeks = 0;
		
		while(node.getElement() != null) {
			if(node.getElement().getProdusent().toLowerCase().contains(produsentdelstreng.toLowerCase())) {
				filmer[indeks] = node.getElement();
			}
			indeks++;
			node = node.getNeste();
		}
		forkortFilmTabell(filmer);
		return filmer;
	}
	
	@Override
	public int antallSjanger(Sjanger sjanger) {
		
		int antallSjanger = 0;
		LinearNode<Film> node = start;
		
		while(node.getElement() != null) {
			if(node.getElement().getSjanger() == sjanger) {
				antallSjanger++;
			}
		}
		return antallSjanger;
	}
	
}








