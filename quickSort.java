import java.lang.Math;

public class quickSort{
	static void swap(int ar[], int a, int b){
		int tmp = ar[a];
		ar[a] = ar[b];
		ar[b] = tmp;					
	}
	
	static int partition(int ar[], int lo, int hi){
		int pivot = (lo + hi) / 2;	
		int pValue = ar[pivot];		 
		swap(ar, pivot, hi);	
		int storeIndex = lo;
		
		for(int i = lo; i < hi; i++){
			if( ar[i] < pValue)	{
					swap(ar, i, storeIndex); 
					storeIndex++;	
			}
		}
		swap(ar, storeIndex, hi);
		return storeIndex;
	}

	public static void quickSort(int ar[], int lo, int hi){
		if(lo < hi) {	 /* error checking */
			int pivot = partition(ar, lo, hi);	
			quickSort(ar, lo, pivot-1);
			quickSort(ar, pivot+1, hi);
	/* not including pivot because the value at index pivot is correct */
		}
	}

	public static void quickSort(int ar[]){
		quickSort(ar, 0, ar.length - 1);
	}
}
