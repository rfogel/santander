package challange;

import java.util.Scanner;

public class TriangleIdentifier {

	private final static String ISOSCELES = "Isosceles";
	private final static String EQUILATERAL = "Equilateral";
	private final static String NONE_OF_THESE = "None of these";

	public String[] detectTypes(String[] values) throws Exception {
		int size = values.length;
		String[] result = new String[size];
		int index = 0;
		for (String value : values) {
			result[index++] = detectType(value);
		}
		return result;
	}

	public String detectType(String values) throws Exception {

		String[] trianguleSides = values.split(" ");

		int side1 = Integer.valueOf(trianguleSides[0]);
		int side2 = Integer.valueOf(trianguleSides[1]);
		int side3 = Integer.valueOf(trianguleSides[2]);

		if (side1 <= 0 || side2 <= 0 || side3 <= 0) 
			return NONE_OF_THESE;
		else if (side1 == side2 && side2 == side3)
			return EQUILATERAL;
		else if (side1 == side2 || side3 == side1 || side3 == side2)
			return ISOSCELES;
		return NONE_OF_THESE;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		try {

			int sequenceSize = Integer.valueOf(scanner.nextLine());

			String[] sides = new String[sequenceSize];
			int index = 0;
			for (int i = 0; i < sequenceSize; i++) {
				sides[index++] = scanner.nextLine();
			}

			TriangleIdentifier ti = new TriangleIdentifier();

			String[] trianguleTypes = ti.detectTypes(sides);

			for (String type : trianguleTypes) {
				System.out.println(type);
			}
		} catch (NumberFormatException e) {
			System.err.println("wrong number format");
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			System.err.println("wrong number of triangule sides");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			scanner.close();
		}
	}
}
