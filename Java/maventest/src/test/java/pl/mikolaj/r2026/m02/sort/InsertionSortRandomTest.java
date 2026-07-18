package pl.mikolaj.r2026.m02.sort;

import org.junit.jupiter.api.Test;
import pl.mikolaj.r2026.SortTestUtils;

public class InsertionSortRandomTest {

	InsertionSort insertionSort = new InsertionSort();

	@Test
	void sort() {
		SortTestUtils.processSortingMethod(insertionSort::sort, insertionSort::getCounter);
	}
}
