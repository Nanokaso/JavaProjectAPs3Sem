package TOs;

public class GenericTO<T1, T2> {
	private T1 t1;
	private T2 t2;

	public T1 getT1() {
		return t1;
	}

	public T2 getT2() {
		return t2;
	}
	public GenericTO<T1, T2> SetAll(T1 t, T2 tt) {
		t1 = t;
		t2 = tt;
		return this; 
	}
}
