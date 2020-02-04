package no.hvl.dat102;

public class LinearNode<T> {

	private LinearNode<T> neste;
	private T element;
	
	public LinearNode() {
		neste = null;
		element = null;
	}
	
	public LinearNode(T element) {
		neste = null;
		this.element = element;
	}
	
	public LinearNode<T> getNeste() {
		return this.neste;
	}
	
	public void setNeste(LinearNode<T> node) {
		this.neste = node;
	}
	
	public T getElement() {
		return this.element;
	}
	
	public void setElement(T element) {
		this.element = element;
	}
	
}
