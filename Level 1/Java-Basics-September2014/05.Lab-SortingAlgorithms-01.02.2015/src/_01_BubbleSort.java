import java.util.ArrayList;
import java.util.Scanner;

//import org.apache.*;
//import org.apache.commons.lang3.StringUtils;

public class _01_BubbleSort {
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

        bubbleSort();

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

	public static void bubbleSort() {
		int indexOfLastElement = numbersArr.length - 1;
		while (indexOfLastElement != 0) {
			for (int j = 0; j < indexOfLastElement; j++) {
				if (numbersArr[j] > numbersArr[j + 1]) {
					int oldValue = numbersArr[j];
					numbersArr[j] = numbersArr[j + 1];
					numbersArr[j + 1] = oldValue;
				}
			}
			indexOfLastElement--;
		}
	}

}
