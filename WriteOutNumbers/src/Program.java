import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Program {

	public static final int MAX_VALUE = 1000000;
	private static final String[] ONES = new String[] { "", "one", "two", "three", "four", "five", "six", "seven",
			"eight", "nine" };
	private static final String[] TEENS = new String[] { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
			"sixteen", "seventeen", "eighteen", "nineteen" };
	private static final String[] TENS = new String[] { "", "", "twenty", "thirty", "forty", "fifty", "sixty",
			"seventy", "eighty", "ninety" };
	private static final String[] ORDERS = new String[] { "", "thousand", "million", "billion", "trillion" };

	
	public static void main(String[] args) {
		// System.out.println("Input a number:");
		// Scanner sc = new Scanner(System.in);
		// int input = sc.nextInt();
		// System.out.println(compose(input));
		// sc.close();
		sortNumbersAlphabetically(MAX_VALUE);
	}

	
	public static void sortNumbersAlphabetically(int limit) {
		ArrayList<String> words = new ArrayList<String>();
		for (int i = 0; i < limit; i++) {
			words.add(compose(i));
		}
		Collections.sort(words);

		for (String w : words)
			System.out.println(w);
	}


	/*
	 * Return the text representation of an integer.
	 */
	public static String compose(int input) {
		String answer = "";
		if (input == 0)
			answer = "zero";
		else {
			int glob = 0;
			while (input > 0) {
				String text = threeDigit(input % 1000);
				if (answer.length() > 0 && text.length() > 0)
					answer = ", " + answer;
				if (text.length() > 0)
					answer = text + " " + ORDERS[glob] + answer;
				input = input / 1000;
				glob++;
			}
		}
		return answer.trim();
	}


	/*
	 * Return the text representation of a one-, two-, or three-digit integer.
	 */
	static String threeDigit(int input) {
		String answer = "";
		if (input >= 100) {
			answer += oneDigit(input / 100);
			answer += " hundred";
			if (input % 100 != 0)
				answer += " ";
		}
		answer += twoDigit(input % 100);
		return answer;
	}
	
	
	/*
	 * Return the text representation of a one- or two-digit integer.
	 */
	static String twoDigit(int input) {
		String answer = "";
		if (input < 10)
			answer = oneDigit(input);
		else if (input < 20)
			answer = TEENS[input - 10];
		else {
			answer = TENS[input / 10];
			if (input % 10 != 0) {
				answer += "-";
				answer += oneDigit(input % 10);
			}
		}
		return answer;
	}

	
	/*
	 * Return the text representation of a one-digit integer.
	 */
	static String oneDigit(int input) {
		return ONES[input];
	}

}
