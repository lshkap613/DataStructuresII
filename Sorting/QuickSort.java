
public class QuickSort<T extends Comparable<T>>{
	
	private T[] objs;
	private int lowIndex;
	private int highIndex;
	
	public QuickSort (T[] objs, int lowIndex, int highIndex) {
		this.objs = objs;
		this.lowIndex = lowIndex;
		this.highIndex = highIndex;
	}
			
	
	public T[] quickSort(T[] objs, int lowIndex, int highIndex) {		
		
		if (lowIndex < highIndex) {
			int pivotIndex = partition(objs, lowIndex, highIndex);
			
			System.out.println("\n\nPivot Index: " + pivotIndex);
			
			quickSort(objs, lowIndex, pivotIndex - 1);
			quickSort(objs, pivotIndex + 1, highIndex);
		}
		
		return objs;
	}
	
	public int partition(T[] objs, int lowIndex, int highIndex) {
		System.out.println("List: ");
		for (int i = 0; i < objs.length; i++) {
			System.out.println("\t" + i + ": " + objs[i]);
		}
		System.out.println();
		
		T pivot = objs[highIndex];
		
		int i = lowIndex - 1;
		
		for (int j = lowIndex; j <= highIndex - 1; j++) {
			if (objs[j].compareTo(pivot) < 1) {
				i++;
				swap(objs, i, j);
			}
		}
		
		swap(objs, i + 1, highIndex);
		return (i + 1);
	}
	
	public void swap(T[] objs, int i, int j) {
		System.out.println("Swapping indices " + i + " and " + j);

		T temp = objs[i];
		objs[i] = objs[j];
		objs[j] = temp;
	}

}
