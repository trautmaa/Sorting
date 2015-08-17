

import java.util.*;

public class Sorting {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>(14);
		numbers.add(2);
		numbers.add(5);
		numbers.add(1);
		numbers.add(32);
		numbers.add(15);
		numbers.add(77);
		numbers.add(54);
		numbers.add(22);
		numbers.add(23);
		numbers.add(21);
		numbers.add(20);
		numbers.add(99);
		numbers.add(59);
		numbers.add(52);
		numbers.add(28);
		numbers.add(72);

		System.out.println("Original unsorted list: ");
		System.out.println(numbers.toString());
		ArrayList<Integer> bubNums = bubbleSort(numbers);
		System.out.println("Bubblesort: ");
		printer(bubNums);
		ArrayList<Integer> mergeNums = mergeSort(numbers);
		System.out.println("Mergesort: ");
		printer(mergeNums);
	}


	public static ArrayList<Integer> mergeSort(ArrayList<Integer> numbers) {

		/*base case*/
		if (numbers.size() <2) {
			return numbers;
		}

		/*
		Split in two
		*/
		ArrayList<Integer> list1 = new ArrayList<Integer>(numbers.size()/2);
		ArrayList<Integer> list2 = new ArrayList<Integer>(numbers.size()/2);
		for (int x = numbers.size()-1; x>-1; x--) {
			if (x<numbers.size()/2) {
				list1.add(numbers.get(x));
			}
			else {
				list2.add(numbers.get(x));
			}
		}


		/*Recursively call mergesort*/
		list1 = mergeSort(list1);
		list2 = mergeSort(list2);

		/*Merge the lists*/
		numbers = merge(list1,list2);

		return numbers;
	}

	public static ArrayList<Integer> merge(ArrayList<Integer> list1,ArrayList<Integer> list2) {


		ArrayList<Integer> list3 = new ArrayList<Integer>(list1.size()*2);
		while(list1.size()>0 & list2.size()>0) {
			if (list1.get(0)<list2.get(0)) {
				list3.add(list1.get(0));
				list1.remove(0);
			}
			else {
				list3.add(list2.get(0));
				list2.remove(0);
			}
		}

		while (list1.size()>0) {
			list3.add(list1.get(0));
			list1.remove(0);
		}

		while (list2.size()>0) {
			list3.add(list2.get(0));
			list2.remove(0);
		}

		return list3;
	}

	public static ArrayList<Integer> bubbleSort(ArrayList<Integer> numbers) {
		for(int x = numbers.size(); x > 1; x--){
			for(int y = 0; y < x-1; y++){
				if (numbers.get(y) > numbers.get(y+1)){
					swapper(y,y+1,numbers);
				}
			}
		}
		return numbers;
	}

	public static void printer(ArrayList<Integer> toPrint) {
		System.out.println(toPrint.toString());
		System.out.println("----------------");

	}

	public static void swapper(int a, int b, ArrayList<Integer> arrayToSwap){
		int x = arrayToSwap.get(a);
		arrayToSwap.set(a,arrayToSwap.get(b));
		arrayToSwap.set(b,x);
	}



}