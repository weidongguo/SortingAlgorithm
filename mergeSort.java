public class mergeSort{
  public static void main(String argv[]){
    System.out.println(argv[0] +"\n"+"number of command line arguments: "+ argv.length);  
    char ar [] = (argv[0]).toCharArray();     

    for(char i : ar)
      System.out.print(i);
    System.out.println();             

    sort(ar);
    
    print_ar(ar);
  }

  static void sort(char [] ar){
    System.out.println("Sorting...");
    char sorted_ar[] = new char[ar.length];

    mergeSplit(ar, 0, ar.length, sorted_ar);

    ar = sorted_ar;
    
  }

  /* iBegin inclusive, iEnd exclusive */
  static void mergeSplit(char [] ar , int iBegin, int iEnd, char [] sorted_ar){
    if(iEnd - iBegin <= 1)
      return; 
    //print_ar(ar,iBegin, iEnd); 
    int iMid = (iBegin + iEnd) / 2;
    mergeSplit(ar, iBegin, iMid, sorted_ar);
    mergeSplit(ar, iMid, iEnd, sorted_ar);
    merge(ar, iBegin, iMid, iEnd, sorted_ar);
    System.arraycopy(sorted_ar, iBegin, ar, iBegin, iEnd - iBegin);//copy back the sorted array to the original
    //print_ar(ar,iBegin, iEnd);  
  }
  
  static void merge(char [] ar, int iBegin, int iMid, int iEnd, char [] sorted_ar){
    for(int i = 0, j = 0, k = 0; k < iEnd ;k++)  {
      if(iBegin+i >= iMid) {
        System.arraycopy(ar, iMid+j, sorted_ar, iBegin+k, iEnd - (iMid + j) );      
        return;
      }
      if(iMid+j >= iEnd) {
        System.arraycopy(ar, iBegin+i, sorted_ar, iBegin+k, iMid - (iBegin + i) );
        return;
      }

      if(ar[iBegin+i] < ar[iMid+j]){
        sorted_ar[iBegin+k] = ar[iBegin+i];
        i++;
      }
      else {
        sorted_ar[iBegin+k] = ar[iMid+j];
        j++;
      }
    }

  }


  static void print_ar(char [] ar){
    System.out.println("\n\n---sorted below---");       
    for(char i : ar)
      System.out.print(i);
    System.out.println("\n---sorted above---\n");
  }
  static void print_ar(char [] ar, int iBegin, int iEnd){
    System.out.println("\n\n---sorted below---");       
    for(int i = iBegin; i < iEnd; i++)
      System.out.print(ar[i]);
    System.out.println("\n---sorted above---\n");
  }

}

