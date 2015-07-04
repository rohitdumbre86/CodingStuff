package com.company.arrays.strings;



public class FindMinimumUnSortedArray
{



  public void printUnSortedArray(int[] array)
  {
     int i = 0; 
     int j = array.length - 1;

     while(array[i]<array[i+1])
       {
          i++;
       }

     if(i+1==j)
      {
        System.out.println("This array is sorted");
        return;
      }

     while(array[j]>array[j-1])
     {
       j--;
     }

     int max = array[i];
     int min = array[i];

     for(int k = i; k<=j;k++)
     {
        if(array[k] < min)
        { 
          min = array[k];
        }

        if(array[k] > max)
        {
          max = array[k];  
        }
     }

     for(int l = 0; l< i ; l++)
     {
        if(array[l] > min) 
         {
           i = l;
           break;    
         }
     }

   for(int m = j+1; m<array.length; m++)
   {
      if(max > array[m]) 
      {
          j = m;
          break;
      }
 
  }

  for(int s = i;s<=j;s++)
  {
    System.out.print(array[s]+" ");
  }

 System.out.println();


 }

  public static void main(String[] args)
  {
    FindMinimumUnSortedArray unsortedLength = new FindMinimumUnSortedArray();
    int[] sortedAsSuch = new int[]{10,12,20,30,25,40,32,31,35,50,60};
    unsortedLength.printUnSortedArray(sortedAsSuch);


  }

}