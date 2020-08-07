package challange;

import java.util.Scanner;
import java.util.TreeMap;

public class Romanizer {

	private final TreeMap<Integer, String> map = new TreeMap<Integer, String>();

	public Romanizer() {

		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
	}
	
	public String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }
	
	public String[] convertToRoman(int[] numbers) {
		int size = numbers.length;
		String[] result = new String[size];
		int index = 0;
		for (int num : numbers) {
			result[index++] = toRoman(num);
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			int sequenceSize = Integer.valueOf(scanner.next());
			
			int[] numbers = new int[sequenceSize];
			int index = 0;
			for (int i = 0; i < sequenceSize; i++) {
				numbers[index++] = Integer.valueOf(scanner.next());
			}
			
			Romanizer romanizer = new Romanizer();
			
			String[] numbersConverted = romanizer.convertToRoman(numbers);
			
			for (String number : numbersConverted) {
				System.out.println(number);
			}			
		} catch (NumberFormatException e) {
			System.err.println("wrong number format");
		} finally {
			scanner.close();			
		}	
	}
}
