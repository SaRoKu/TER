package Minimax.utils;

public class Pair<A,B>{

	private A first;
	private B second;

	public Pair(A first, B second){

		this.first = first;
		this.second = second;
	}

	public Pair(){}

	public A getFirst() {

		return first;
	}

	public void setFirst(A first) {

		this.first = first;
	}

	public B getSecond() {

		return second;
	}

	public void setSecond(B second) {

		this.second = second;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (!(o instanceof Pair)) return false;
		Pair<?,?> pair = (Pair<?,?>)o;
		return this.first.equals(pair.first) && this.second.equals(pair.second);
	}
}