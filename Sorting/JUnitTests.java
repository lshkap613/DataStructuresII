import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JUnitTests {

	@Test
	void test_QuickSortWorksOnStrings() {
		String[] letters = {"B", "Y", "H", "P", "A", "S"};
		String[] expectedSortedLetters = {"A", "B", "H", "P", "S", "Y"};
		QuickSort<String> qs = new QuickSort<String>(letters, 0, letters.length - 1);
		String[] sortedLetters = qs.quickSort(letters, 0, letters.length - 1);
		
		Assertions.assertArrayEquals(sortedLetters, expectedSortedLetters);
	}
	
	@Test
	void test_QuickSortWorksOnDoubles() {
		Double[] letters = {7.3, -2.8, 14.9, 13.3, 3.0, 4.5};
		Double[] expectedSortedLetters = {-2.8, 3.0, 4.5, 7.3, 13.3, 14.9};
		QuickSort<Double> qs = new QuickSort<Double>(letters, 0, letters.length - 1);
		Double[] sortedLetters = qs.quickSort(letters, 0, letters.length - 1);
		
		Assertions.assertArrayEquals(sortedLetters, expectedSortedLetters);
	}

	@Test
	void test_MergeSortWorksOnStrings() {
		String[] letters = {"B", "Y", "H", "P", "A", "S"};
		String[] expectedSortedLetters = {"A", "B", "H", "P", "S", "Y"};
		MergeSort<String> ms = new MergeSort<String>(letters);
		String[] sortedLetters = ms.mergeSort();
		
		Assertions.assertArrayEquals(sortedLetters, expectedSortedLetters);
	}
	
	@Test
	void test_MergeSortWorksOnDoubles() {
		Double[] letters = {7.3, -2.8, 14.9, 13.3, 3.0, 4.5};
		Double[] expectedSortedLetters = {-2.8, 3.0, 4.5, 7.3, 13.3, 14.9};
		MergeSort<Double> ms = new MergeSort<Double>(letters);
		Double[] sortedLetters = ms.mergeSort();
		
		Assertions.assertArrayEquals(sortedLetters, expectedSortedLetters);
	}
}
