package coll;

import java.util.*;

public class CollectionTest {
	Collection<Integer> numList = new ArrayList<>();
	
	void run() {
		makeRandomNumbers(numList, 10);
		Collection<Integer> newList = new ArrayList<>();
		makeRandomNumbers(newList, 10);
		printNumbers("numlist",numList);
		Collections.shuffle((List<?>) numList);
		printNumbers("numlist",numList);
		printNumbers("newList", newList);
		Collection<Integer> hap = new ArrayList<>(numList);
		hap.addAll(newList);
		Collection<Integer> cha = new ArrayList<>(numList);
		cha.removeAll(newList);
		printNumbers("합", hap);
		printNumbers("차", cha);

	}
	Random rand = new Random();
	void makeRandomNumbers(Collection<Integer> c, int n) {
		for (int i = 0; i < 10; i++)
			c.add(rand.nextInt(20));
	}
	void printNumbers(String name, Collection<Integer> c) {
		System.out.printf("=======  %s  ===========\n", name);
		for (int n : c) {
			System.out.print(n + ", ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		CollectionTest test = new CollectionTest();
		test.run();
	}
}
