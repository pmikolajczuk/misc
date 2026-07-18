package pl.mikolaj.r2026.m01.sort;

import org.junit.jupiter.api.Test;
import pl.mikolaj.r2026.SortTestUtils;

class BubbleSortGenericTest {

	BubbleSortGeneric bubbleSortGeneric = new BubbleSortGeneric();

	String[] names = { "Liam", "Ava", "Noah", "Mia", "Ethan", "Sofia", "Lucas", "Emma", "Oliver", "Chloe" };

	@Test
	void sortV1() {
		SortTestUtils.processSortingMethodGeneric(bubbleSortGeneric::sortV1, names);
	}

	@Test
	void sortV4() {
		SortTestUtils.processSortingMethodGeneric(bubbleSortGeneric::sortV4, names);
	}
}