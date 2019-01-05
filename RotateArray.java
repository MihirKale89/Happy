// Java program to rotate an array by
// d elements
class RotateArray {
	/*Function to left rotate arr[] of siz n by d*/
	void leftRotate(int arr[], int d, int n)
	{
		int i, j, k, temp;
		for (i = 0; i < gcd(d, n); i++) {
			/* move i-th values of blocks */
			temp = arr[i];
			j = i;
			while (true) {
				k = j + d;
				if (k >= n)
					k = k - n;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
				System.out.print("In while loop j: "+j+" arr[j] :"+arr[j]+". ");
				printArray(arr);
			}
			arr[j] = temp;
			System.out.print("Outside while loop j: "+j+" arr[j] :"+arr[j]+". ");
			printArray(arr);
		}
	}

	/*UTILITY FUNCTIONS*/

	/* function to print an array */
	void printArray(int arr[])
	{
		int i;
		System.out.print("The array elements are: [");
		for (i = 0; i < arr.length; i++)
			System.out.print(" "+arr[i]);
		System.out.print("]\n");
	}

	/*Fuction to get gcd of a and b*/
	int gcd(int a, int b)
	{
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	// Driver program to test above functions
	public static void main(String[] args)
	{
		RotateArray rotate = new RotateArray();
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		rotate.printArray(arr);
		rotate.leftRotate(arr, 5, 12);
		System.out.println("The GCD is "+rotate.gcd(12,5));
		rotate.printArray(arr);
	}
}

// This code has been contributed by Mayank Jaiswal
// Time complexity O(n)
// Space complexity O(1)
