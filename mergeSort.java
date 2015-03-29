import java.lang.*; /* for the function copyarray() */
/* TOP DOWN MERGE SORT */
public class mergeSort{

	static void merge(int ar[],int iBegin, int iMid, int iEnd, int sorted_ar[]){
		int a = iBegin;
		int b = iMid + 1 ;	
			
		for(int i = iBegin; i <= iEnd; i++){
			if( (a <= iMid) && ( b > iEnd || ar[a] < ar[b] ) ){
				sorted_ar[i] = ar[a];
				a++;
			}
			else{
				sorted_ar[i] = ar[b];
				b++;
			}
		}
	}
/*	merge by copying each element over to a new array (sorted_ar)
		following the procedure below;
 *  compare the front of each subarray(let say subarray A and B)
		the smaller one is put into the sorted_ar, and the front of that
		subarray is incremented, but the front for the other subarray 
		remains unchanged. And dont forget to increment the index for 
		sorted_ar; ( sorted_ar's length is the sum of the two subarray);
 *  there are some boundary checking such as 
 		a <= iMid; it's in case subarray A is smaller than subarray B,
		then when A runs out of elements to compare with B, then
		just copy the rest of B to the sorted_ar 		
		
		b > iEnd; it's in case subarray B is smaller than subarray A,
		then when B runs out of elements to compare with A, then
		just copy the rest of A to the sorted_ar 
 *  Note: b > iEnd has to be checked before ar[a] < ar[b] because
 *  ar[b] may trigger out of bound error
 */
				
	static void split_and_merge(int ar[], int iBegin, int iEnd, int sorted_ar[])
	{ /* both iBegin and iEnd are inclusive */

		if(iBegin >= iEnd)/* when there is only 1 element or fewer */
						return;					
		int iMid = (iBegin+iEnd)/2;	
		split_and_merge(ar, iBegin, iMid, sorted_ar);	
		split_and_merge(ar, iMid+1, iEnd, sorted_ar);
		merge(ar, iBegin, iMid, iEnd, sorted_ar);
		System.arraycopy(sorted_ar, iBegin, ar, iBegin, iEnd - iBegin+1);
		/* copy the sorted subarray back to the corresponding part of the
		   original array ar */	
	}
	

	static void mergeSort(int ar[]){ /* driver */
		int sorted_ar[] = new int[ar.length];
		split_and_merge(ar, 0, ar.length - 1, sorted_ar);		
	}
}
