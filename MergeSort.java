import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> {
	
	private T[] arrayToSort;
	private int firstIndex = 0;
	private int lastIndex = 0;
	private int size = 0;
	
	public MergeSort (T[] xArrayToSort) {
		this.arrayToSort = xArrayToSort;
		this.firstIndex = 0;
		this.lastIndex = xArrayToSort.length - 1;
		this.size = xArrayToSort.length;
		System.out.println("Splitting list (indexes " + firstIndex + "-" + lastIndex + ") into arrays of length 1...\n");
	}
	
	public T[] mergeSort() {
        return mergeSortSplit(firstIndex, lastIndex);
    }

	public T[] mergeSortSplit (int firstIndex, int lastIndex) {
		
		if (firstIndex < lastIndex) {
			int midPoint = (lastIndex + firstIndex)/2;
			mergeSortSplit(firstIndex, midPoint);
			mergeSortSplit(midPoint + 1, lastIndex);
			
			return mergeTogether(firstIndex, midPoint, midPoint + 1, lastIndex, arrayToSort.getClass().getComponentType());
		}
		return Arrays.copyOfRange(arrayToSort, firstIndex, firstIndex + 1);

	}
	
	public T[] mergeTogether (int leftFirst, int leftLast, int rightFirst, int rightLast, Class<?> classType) {
		int tempPos = leftFirst;
		T[] tempArray = (T[]) Array.newInstance(classType, rightLast + 1);
		int startLocation = leftFirst;

		System.out.println("Merging sublists indices " + leftFirst + "-" + leftLast + " and " + rightFirst + "-" + rightLast);
		
		while(leftFirst <= leftLast && rightFirst <= rightLast) {
			if (this.arrayToSort[leftFirst].compareTo(this.arrayToSort[rightFirst]) <= 0) {
				tempArray[tempPos++] = this.arrayToSort[leftFirst++];
			} else {
				tempArray[tempPos++] = this.arrayToSort[rightFirst++];
			}
		}
		
		while (leftFirst <= leftLast) {
			tempArray[tempPos++] = this.arrayToSort[leftFirst++];
		}
		
		while (rightFirst <= rightLast) {
			tempArray[tempPos++] = this.arrayToSort[rightFirst++];
		}
		
		for (tempPos = startLocation; tempPos <= rightLast; tempPos++) {
			this.arrayToSort[tempPos] = tempArray[tempPos];
		}
		
		return tempArray;
	}

}
