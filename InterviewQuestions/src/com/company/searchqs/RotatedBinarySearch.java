package com.company.searchqs;

public class RotatedBinarySearch {

	public int findPivot(int[] arr, int low, int high) {
		if (low > high)
			return -1;

				
		if (low == high - 1) {
			if (arr[low] <= arr[high])
				return high;
			else {
				return low;
			}
		} else {

			int mid = low + (high - low) / 2;
			if (arr[mid] >= arr[low]) {
				return findPivot(arr, mid, high);
			}

			else {

				return findPivot(arr, low, mid);
			}
		}

	}
	
	
	public int findIndex(int[] arr,int low, int high, int k)
	{
		int pivot = findPivot(arr,low,high);
		
		//This is not a rotated array.
		if(pivot < 0)
		  return binarySearch(arr,low,high,k);
		
		if(arr[pivot]==k) return pivot;
		
		if(arr[pivot+1]<=k && arr[low]<=k)
		{
			return binarySearch(arr,low,pivot-1,k);
		}
		else if(arr[pivot+1]<=k && arr[low]>=k )
		{
			return binarySearch(arr,pivot+1,high,k);
		}
		else 
			return binarySearch(arr,low,high,k);
	}
	
	
	
	public int binarySearch(int[] arr, int low, int high,int k)
	{
		if (low > high)
		  return -1;
		
		int mid = low + (high-low)/2;
		if(arr[mid]==k) return mid;
		
		if(arr[mid]<k)
			return binarySearch(arr,mid+1,high,k);
		else
			return binarySearch(arr,low,mid-1,k);
	}

	public static void main(String[] args) {
		RotatedBinarySearch rotatedBinarySearch = new RotatedBinarySearch();
		int[] array = new int[]{10,11,12,19,1,4,5};
		int value = rotatedBinarySearch.findIndex(array, 0, array.length-1,19);
        System.out.println(array[value]);
	}

}
