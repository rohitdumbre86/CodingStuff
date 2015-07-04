package com.company.arrays.strings;

public class RowColoumnZero
{



  public void makeRowZero(int[][] array)
   {
      boolean[] row = new boolean[array.length];
      boolean[] coloumn = new boolean[array.length];

      for(int i=0; i<array.length;i++)
       {
         for(int j=0; j<array.length;j++)
           {
              if(array[i][j]==0)
               {
                  row[i]=true;
                  coloumn[j]=true;
               }

           }

        }

      for(int i=0;i<row.length;i++)
        {
           if(row[i])
           nullifyRow(array,i);
        }       
      
      for(int j=0; j<coloumn.length;j++)
        {
           if(coloumn[j])
             nullifyColoumn(array,j);         
        }    

      
           
   }

  public void printArray(int[][] array)
  {
     
      for(int i=0; i<array.length;i++)
       { System.out.println();
         for(int j=0; j<array.length;j++)
          {
            System.out.print(array[i][j]+" ");
          }
       }
  }

  public void nullifyRow(int[][] array, int row)
  {

    for(int i=0; i<array.length;i++)
      array[row][i]=0;
  }

  public void nullifyColoumn(int[][] array, int coloumn)
  {
     for(int j=0; j<array.length;j++)
       array[j][coloumn]=0;
  }

  public static void main(String[] args)
  {
    int[][] arrays = new int[][]
                         {
                           {1,2,3,4},
                           {5,0,7,8},
                           {9,6,3,1},
                           {3,4,5,6}
                         };

     RowColoumnZero zero = new RowColoumnZero();
     zero.printArray(arrays);
     zero.makeRowZero(arrays);
     System.out.println();
     zero.printArray(arrays);
  }

}