package knapsack;

import java.util.Comparator;

public class Sorted implements Comparator<Tut> {

	@Override
	public int compare(Tut o1, Tut o2) {
		
		return o2.pperw >= o1.pperw ? 1 : -1;
	}

}
