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
    private static final String HUNDRED = "hundred";
    private static final String ZERO = "zero";
    private static final String SEPARATOR = "-";
    private static final String[] ORDERS = new String[] { "", "thousand", "million", "billion", "trillion" };

	
	public static void main(String[] args) {
		// System.out.println("Input a number:");
		// Scanner sc = new Scanner(System.in);
		// int input = sc.nextInt();
		// System.out.println(compose(input));
		// sc.close();
		sortNumbersAlphabetically(MAX_VALUE);
//		System.out.println(firstWord());
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
	
	
	public static String firstWord() {
		int i = 0;
		char target = 'a';
		while (true) {
			String word = compose(i);
			if (word.indexOf(target)>0) {
				return word;
			}
			i++;
		}
	}


	/*
	 * Return the text representation of an integer.
	 */
	public static String compose(int num) {
        StringBuilder answer = new StringBuilder();
        if (num == 0)
            answer.append(ZERO);
        else {
            int glob = 0;
            while (num > 0) {
                String text = threeDigit(num % 1000);
                if (answer.length() > 0 && text.length() > 0)
                    answer.insert(0, ", ");
                if (text.length() > 0) {
                    answer.insert(0, ORDERS[glob]);
                    answer.insert(0, ' ');
                    answer.insert(0, text);
                }
                num = num / 1000;
                glob++;
            }
        }
        return answer.toString().trim();
	}


	/*
	 * Return the text representation of a one-, two-, or three-digit integer.
	 */
    static String threeDigit(int input) {
        StringBuilder answer = new StringBuilder();
        if (input >= 100) {
            answer.append(oneDigit(input / 100));
            answer.append(" ");
            answer.append(HUNDRED);
            if (input % 100 != 0)
                answer.append(" ");
        }
        answer.append(twoDigit(input % 100));
        return answer.toString();
    }
	
	
	/*
	 * Return the text representation of a one- or two-digit integer.
	 */
    static String twoDigit(int input) {
        StringBuilder answer = new StringBuilder();
        if (input < 10)
            answer.append(oneDigit(input));
        else if (input < 20)
            answer.append(TEENS[input - 10]);
        else {
            answer.append(TENS[input / 10]);
            if (input % 10 != 0) {
                answer.append(SEPARATOR);
                answer.append(oneDigit(input % 10));
            }
        }
        return answer.toString();
    }

	
	/*
	 * Return the text representation of a one-digit integer.
	 */
	static String oneDigit(int input) {
		return ONES[input];
	}

}
