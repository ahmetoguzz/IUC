package zTest1;

import java.util.Random;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Random random = new Random();
		Random random1 = new Random();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Hey.");

		int condition;

		do {

			int a = (random.nextInt(10) + 1);
			int b = (random.nextInt(10) + 1);
			int c = (random1.nextInt(3));

			System.out.println("Question: ");

			if (c == 0) {
				System.out.println(a + " + " + b + " = ?");
				int result = scanner.nextInt();
				int realResult = a + b;
				if (result == realResult) {
					System.out.println("Correct!");
				} else {
					System.out.println("Wrong. The correct answer was: " + realResult);
				}
			} else if (c == 1) {
				System.out.println(a + " - " + b + " = ?");
				int result = scanner.nextInt();
				int realResult = a - b;
				if (result == realResult) {
					System.out.println("Correct!");
				} else {
					System.out.println("Wrong. The correct answer was: " + realResult);
				}
			} else if (c == 2) {
				System.out.println(a + " * " + b + " = ?");
				int result = scanner.nextInt();
				int realResult = a * b;
				if (result == realResult) {
					System.out.println("Correct!");
				} else {
					System.out.println("Wrong. The correct answer was: " + realResult);
				}
			}

			System.out.println("To exit program, type 4, otherwise, type in 1");
			condition = scanner.nextInt();

		} while (condition != 4);

	}

}
