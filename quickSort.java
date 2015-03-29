import java.lang.Math;

public class quickSort{
	static void swap(int ar[], int a, int b){
		int tmp = ar[a];
		ar[a] = ar[b];
		ar[b] = tmp;					
	}
	
	static int partition(int ar[], int lo, int hi){
		int pivot = (lo + hi) / 2;	/* pivot coulve have been chosen randomly */
		int pValue = ar[pivot];		 
		swap(ar, pivot, hi); /* swap ar[pivot] and ar[hi] */	
		int storeIndex = lo;
		
		for(int i = lo; i < hi; i++){ /* compare all elements except for ar[hi] */
			if( ar[i] < pValue)	{
					swap(ar, i, storeIndex);/* so the value < pValue stores at ar[storeIndex] and value > pValue is stored at ar[i] */
					storeIndex++;	
			}
		}
		swap(ar, storeIndex, hi);
		return storeIndex;
	}

  /* swap ar[pivot] and ar[hi] because all elements beside
		 ar[hi] is going to be compared with pValue to determine whether they go below the pivot all above the pivot. 
		 By the end, we just simply swap ar[hi] (the pivot) with ar[storeIndex] where storeIndex is the next index
		 for value smaller than the pivot. However, at the end, it becomes the index that is for the pivot because
		 there are no more values smaller than the pivot				
	 */

	public static void quickSort(int ar[], int lo, int hi){
		if(lo < hi) {	 /* error checking */
			int pivot = partition(ar, lo, hi);	
			quickSort(ar, lo, pivot-1);
			quickSort(ar, pivot+1, hi);
	/* not including pivot because the value at index pivot is correct */
		}
	}

	public static void quickSort(int ar[]){ /* driver */
		quickSort(ar, 0, ar.length - 1);
	}
}

