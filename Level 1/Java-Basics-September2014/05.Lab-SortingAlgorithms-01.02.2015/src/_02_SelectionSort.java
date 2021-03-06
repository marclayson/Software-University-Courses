import java.util.ArrayList;
import java.util.Scanner;

//import org.apache.*;
//import org.apache.commons.lang3.StringUtils;

public class _02_SelectionSort {
	static int[] numbersArr;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

        String[] numbers = scan.nextLine().replace("[", "").replace("]", "").split(", ");
        numbersArr = new int[numbers.length];
        
        //TODO: Parse the numbers and add them to the list
        for (int i = 0; i < numbers.length; i++) {
			numbersArr[i] = Integer.parseInt(numbers[i]);
		}

        //StopWatch stopWatch = new StopWatch();
        //stopWatch.start();

        selectionSort();

        printArray();
//        stopWatch.stop();
//        long time = stopWatch.getTime();

        //System.out.println(numbersArr);
//        System.out.println(time/1000.0);
	}
	
	private static void printArray() {
		System.out.print("[");
		for (int i = 0; i < numbersArr.length; i++) {
			if (i != numbersArr.length - 1) {
				System.out.print(numbersArr[i] + ", ");
			}
			else {
				System.out.print(numbersArr[i]);
			}
		}
		System.out.println("]");
		
	}

	public static void selectionSort() {
		int indexOfFirstElement = 0;
		while (indexOfFirstElement != numbersArr.length - 1) {
			int smallestNum = Integer.MAX_VALUE;
			int smallestNumIndex = 0;
			
			for (int j = indexOfFirstElement; j < numbersArr.length; j++) {
				if (numbersArr[j] < smallestNum) {
					smallestNum = numbersArr[j];
					smallestNumIndex = j;
				}
			}
			
			int oldValue = numbersArr[smallestNumIndex];
			numbersArr[smallestNumIndex] = numbersArr[indexOfFirstElement];
			numbersArr[indexOfFirstElement] = oldValue;
			indexOfFirstElement++;
		}
	}

}
