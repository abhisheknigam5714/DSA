package RecusionBasics;

public class BasicsPrograms {

	public static void reverse(char[] arr, int i, int j) {
		if (i >= j) {
			return;
		}

		// swap
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

		reverse(arr, i + 1, j - 1);
	}

	public static void reverse(int[] arr, int i, int j) {
		if (i >= j) {
			return;
		} else {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			reverse(arr, i + 1, j - 1);
		}
	}

	public static int fact(int n) {
		if (n == 1) {
			return 1;
		} else
			return n * fact(n - 1);
	}

	public static int sum(int num) {
		if (num == 0) {
			return 0;
		} else
			return num + sum(num - 1);
	}

	public static void main(String[] args) {

		String str = "name";

		char[] arr = str.toCharArray(); // convert string to char array
		reverse(arr, 0, arr.length - 1);

		System.out.println(new String(arr)); // convert back to string

		System.out.println(sum(4));
		System.out.println(fact(4));

		int arr1[] = { 8, 5, 2, 1 };
		reverse(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}
