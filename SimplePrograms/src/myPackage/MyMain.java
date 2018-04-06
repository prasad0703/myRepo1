package myPackage;

import java.util.ArrayList;
import java.util.Arrays;

public class MyMain {
	public static int n0=0,n1=1,n2=0,sum=0;
	public static String reverse = "";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//fibonacci(10);
		//recursiveFibonacci1(10-2);
		//System.out.println(recursiveFibonacci2(10));
		//System.out.println(recursiveFactorial(3));
		//factorial(3);	
		//printTriangle1(10);
		//printTriangle2(10);
		//findSecondHighestInArray();
		//anagrams();
		//duplicateNoInARange();
		//System.out.println(recursiveStringReverse("This is my String"));
		//reverseANumber();
		//decimalToBinary();
		//binaryToDecimal();
		//isPerfectNumber();
		//swapTwoNoWithoutTemp();
		//System.out.println(recursiveSumOfDigits(123));
		//isPrimeNumber(7);
		//bubbleSort();
		//distinctArrayElements();
		//sumOfFirstNPrimeNumbers();
		//removeDuplicatesFromSortedArray();
		//addFibonacciSeries()
		//maxOccuredCharInString("ababaccccbbd");
		
	}
	//--------------------------------------------------------------
	public static void fibonacci(int nmax) {
		int[] fib = new int[nmax];
		fib[0] = 0;
		fib[1] = 1;
		for(int i=2; i<nmax; i++) {
			fib[i]=fib[i-1]+fib[i-2];
		}
		System.out.println(Arrays.toString(fib));
	}
	//--------------------------------------------------------------
	public static void recursiveFibonacci1(int nmax) {
		if(nmax>0) {
			n2 = n1+n0;
			System.out.println(n2);
			n0=n1;
			n1=n2;
			recursiveFibonacci1(--nmax);
		}
	}
	//--------------------------------------------------------------
	public static int recursiveFibonacci2(int nmax) {
		if(nmax<=1)
			return nmax;
		return recursiveFibonacci2(nmax-1) + recursiveFibonacci2(nmax-2);
	}
	//--------------------------------------------------------------
	public static void factorial(int n) {
		int fact = 1;
		for(int i=1;i<=n;i++) {
			fact = fact * i;
		}
		System.out.println(fact);
	}
	//--------------------------------------------------------------
	public static int recursiveFactorial(int n) {
		if(n==0) {
			return 1;
		}else
			return n*recursiveFactorial(n-1);
	}
	//--------------------------------------------------------------
	public static void printTriangle1(int rows) {
		for(int i=1;i<=rows;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j); 
			}
			System.out.println();
		}
	}
	
	//--------------------------------------------------------------
	public static void printTriangle2(int num) {
		int temp = 1 ;
		for(int i = 1; i <= num; i++){
			for(int j = i; j <num; j++)
				System.out.print(" ");
			for(int k = 1; k <= i; k++){
				System.out.print("" +temp+ " ");
				temp++;
				if(temp>15){
					break;
				}
			}
			System.out.println();
			if(temp>15){
				break;
			}
		}
	}
	//--------------------------------------------------------------
	public static void findSecondHighestInArray() {
		int[] arr = {2,4,23,5,6,3,45,2};
		int highest = 0;
		int sHighest = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>highest) {
				sHighest = highest;
				highest = arr[i];
			}else
				if(arr[i]>sHighest) {
					sHighest = arr[i];
				}
		}
		System.out.println(sHighest);
	}
	//--------------------------------------------------------------
	public static void anagrams() {
		String s1 = "bemrU";
		String s2 = "Mureb";
		char[] carr1 = s1.toLowerCase().toCharArray();
		char[] carr2 = s2.toLowerCase().toCharArray();
		Arrays.sort(carr1);
		Arrays.sort(carr2);
		if(String.valueOf(carr1).equals(String.valueOf(carr2))) {
			System.out.println("Anagrams");
		}else
			System.out.println("Not anagrams");
	}
	//--------------------------------------------------------------	
	public static void duplicateNoInARange() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=1;i<=15;i++) {
			al.add(i);
		}
		//add duplicate
		al.add(7);
		//get sum of all elements
		int sum = 0;
		for(int a : al) {
			sum = sum +a;
		}
		int duplicateNo = sum - (15*16/2);//n(n+1)/2
		System.out.println(duplicateNo);
	}
	//--------------------------------------------------------------
	public static String recursiveStringReverse(String str) {
		if(str.length()==1) {
			return str;
		}
		reverse = str.charAt(str.length()-1)+recursiveStringReverse(str.substring(0, str.length()-1));
		return reverse;
	}
	//--------------------------------------------------------------
	public static void reverseANumber(){
		int num = 1234;
		int reverse = 0;
		while(num!=0) {
			reverse = (reverse*10)+(num%10);
			num = num/10;
		}
		System.out.println(reverse);
	}
	//--------------------------------------------------------------
	public static void decimalToBinary() {
		int[] bArray = new int[25];
		int num = 5;
		int index = 0;
		while(num>0) {
			bArray[index++] = num%2;
			num = num/2;
		}
		for(int i=bArray.length-1;i>=0;i--) {
			System.out.print(bArray[i]);
		}
	}
	//--------------------------------------------------------------
	public static void binaryToDecimal() {
		int binNum = 101;
		int decNum = 0;
		int i = 0;
		while(binNum!=0) {
			decNum = (int) (decNum + ((binNum%10)*Math.pow(2, i)));
			i++;
			binNum = binNum/10;
		}
		System.out.println(decNum);
	}
	//--------------------------------------------------------------
	public static void isPerfectNumber() {
		int num = 6;
		int sum = 0;
		//sum of its divisors is equal to number
		for(int i=1;i<=num/2;i++) {
			if((num%i)==0) {
				sum = sum+i;
			}
		}
		if(sum==num) {
			System.out.println("The number is perfect number");
		}else
			System.out.println("The number is NOT a perfect number");
	}
	//--------------------------------------------------------------
	public static void swapTwoNoWithoutTemp() {
		int x = 2;
		int y = 3;
		x = x+y;
		y = x-y;
		x = x-y;
		System.out.println(x+" "+y);
	}
	//--------------------------------------------------------------
	public static int recursiveSumOfDigits(int num) {
		if(num!=0) {
			sum = sum+(num%10);
			recursiveSumOfDigits(num/10);
		}
		return sum;
	}
	//--------------------------------------------------------------
	public static boolean isPrimeNumber(int num) {
		boolean bFlag = true;
		for(int i=2;i<=num/2;i++) {
			if(num%i==0) {
				bFlag = false;
				break;
			}
		}
		if(bFlag) {
			System.out.println(num + " is Prime Number");
		}else
			System.out.println(num + " is NOT Prime Number");
		return bFlag;
	}
	//--------------------------------------------------------------
	public static void bubbleSort() {
		int[] arr = {1,4,3,2,5,76,5,4,6,0};
		int temp = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	//--------------------------------------------------------------
	public static void distinctArrayElements() {
		int[] arr = {2,3,45,6,3,1,3,3,2,2,4,6,8};
		boolean isDistinct = false;
		for(int i=0;i<arr.length;i++) {
			isDistinct = true;
			for(int j=0;j<i;j++) {
				if(arr[i]==arr[j]) {
					isDistinct = false;
				}
			}
			if(isDistinct) {
				System.out.println(arr[i]);
			}
		}
	}
	//--------------------------------------------------------------
	public static void sumOfFirstNPrimeNumbers() {
		int sum = 0;
		int primeCount = 0;
		int num=2;
		while(primeCount<5) {
			if(isPrimeNumber(num)) {
				sum = sum + num;
				primeCount++;
			}
			num++;
		}
		System.out.println(sum);
	}
	//--------------------------------------------------------------
	public static void removeDuplicatesFromSortedArray() {
		int[] arr = {1,1,1,4,5,5,7,8,8,9};
		int j=0;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]!=arr[i+1]) {
				arr[j++] = arr[i];
			}
		}
		arr[j]=arr[arr.length-1];
		System.out.println(Arrays.toString(arr));
	}
	//--------------------------------------------------------------
	public static void maxOccuredCharInString(String str) {
		char[] cArray = str.toCharArray();
		Arrays.sort(cArray);
		char maxChar = cArray[0];
		int maxCount = 0;
		for(int i=0,j=0; i<str.length()-1; i=j) {
			int count = 1;
			while(++j<str.length() && cArray[i]==cArray[j]) {
				count++;
			}
			if(count>maxCount) {
				maxChar = cArray[i];
				maxCount = count;
			}
		}
		System.out.println("Max Char: "+maxChar+" Count: "+maxCount);
	}

}
