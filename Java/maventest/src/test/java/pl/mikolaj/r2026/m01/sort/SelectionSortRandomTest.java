package pl.mikolaj.r2026.m01.sort;

import org.junit.jupiter.api.Test;
import pl.mikolaj.r2026.SortTestUtils;

public class SelectionSortRandomTest {

	SelectionSort selectionSort = new SelectionSort();

	@Test
	void sortV1() {
		SortTestUtils.processSortingMethod(selectionSort::sortV1, selectionSort::getStepsCounter);
	}
}
