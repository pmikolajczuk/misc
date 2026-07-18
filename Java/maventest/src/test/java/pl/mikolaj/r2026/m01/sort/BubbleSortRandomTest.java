package pl.mikolaj.r2026.m01.sort;

import org.junit.jupiter.api.Test;
import pl.mikolaj.r2026.SortTestUtils;

public class BubbleSortRandomTest {

	BubbleSort bubbleSort = new BubbleSort();

	@Test
	void sortV1() {
		SortTestUtils.processSortingMethod(bubbleSort::sortV1, bubbleSort::getStepsCounter);
	}

	@Test
	void sortV4() {
		SortTestUtils.processSortingMethod(bubbleSort::sortV4, bubbleSort::getStepsCounter);
	}

	@Test
	void sortV5() {
		SortTestUtils.processSortingMethod(bubbleSort::sortV5, () -> -1);
	}
}
