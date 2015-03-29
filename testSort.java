public class testSort{	
	static int randomInt(int hi){
		return (int)(Math.random()*100) % hi;
	}	
	
	public static void main(String argv[]){
		int size = 20;	
		int ar[] = new int[size];		
		for( int i = 0 ; i < size; i++)	
			ar[i] = randomInt(20); 
		for( int i = 0 ; i < size; i++)
			System.out.print(ar[i] + " ");
		System.out.println();
		
		quickSort.quickSort(ar);	
		//mergeSort.mergeSort(ar);	
			
		for( int i = 0 ; i < size; i++)
			System.out.print(ar[i] + " ");
		System.out.println();

	}
}
