package hamburger;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class AsciiChars {

	public static void printNumbers() {
		for (int i = 48; i < 58; i++) {
			String n = Character.toString((char) i);
			System.out.println(n);
		}
	}

	public static void printLowerCase() {
		for (int i = 97; i < 123; i++) {
			String l = Character.toString((char) i);
			System.out.println(l);
		}
	}

	public static void printUpperCase() {
		for (int i = 65; i < 90; i++) {
			String u = Character.toString((char) i);
			System.out.println(u);
		}
	}

	public static void main(String[] args) {
//		System.out.println("Hello World");
//		printNumbers();
//		printLowerCase();
//		printUpperCase();

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String custName = scanner.next();

		System.out.println("Hello, " + custName);

		System.out.println("Would you like to continue? ('y' or 'n')");
		String keepGoing = scanner.nextLine();
		while (!scanner.hasNext("[yn]")) {
			System.out.println("Please input either 'y' or 'n'!");
			scanner.nextLine();
		}
		keepGoing = scanner.next();
		if (keepGoing.equals("y")) {

			System.out.println("Do you have a red car? ('y' or 'n')");
			String car = scanner.nextLine();
			while (!scanner.hasNext("[yn]")) {
				System.out.println("Please input either 'y' or 'n'!");
				scanner.nextLine();
			}
			keepGoing = scanner.next();

			System.out.println("What is the name of your favorite pet? ");
			String favPet = scanner.next();

			int petAge;
			do {
				System.out.println("What is your pets age?");
				while (!scanner.hasNextInt()) {
					System.out.println("That's not a number!");
					scanner.next();
				}
				petAge = scanner.nextInt();
			} while (petAge < 0);
			{

			}

			int luckyNum;
			do {
				System.out.println("What is your lucky number?");
				while (!scanner.hasNextInt()) {
					System.out.println("That's not a number!");
					scanner.next();
				}
				luckyNum = scanner.nextInt();
			} while (luckyNum <= 0);

			int carYear;
			do {
				System.out.println("What is the two digit model year of your car?");
				while (!scanner.hasNextInt()) {
					System.out.println("That's not a number!");
					scanner.next();
				}
				carYear = scanner.nextInt();
			} while (carYear <= 0);

			System.out.println("Enter a whole number between 1 and 50. ");
			int wholeNum = scanner.nextInt();
			if (wholeNum > 50 || wholeNum < 1) {
				System.out.println("That's not a valid number!");
				scanner.next();
			}

			System.out.println("What is the first name of your favorite actor or actress?");
			String favAct = scanner.next();
			byte[] actByte = favAct.getBytes(StandardCharsets.US_ASCII);

			System.out.println("Do you have a favorite Quarterback? \n ('y' or 'n')");
			String favQB = scanner.next();
			if (favQB.equals("y")) {
				int favQBNumber;
				do {
					System.out.println("What is your favorite QB's jersey number?");
					while (!scanner.hasNextInt()) {
						System.out.println("That's not a number!");
						scanner.next();
					}
					favQBNumber = scanner.nextInt();
				} while (favQBNumber <= 0);
			}

			System.out.println("Thank you.\n");

			int randNum1 = (int) (Math.random() * 50 + 1);
			int randNum2 = (int) (Math.random() * 50 + 1);
			int randNum3 = (int) (Math.random() * 50 + 1);

			byte[] catByte = favPet.getBytes(StandardCharsets.US_ASCII);

			// Magic ball
			int magicBall = (luckyNum * randNum1);
			while (magicBall > 75) {
				magicBall = Math.subtractExact(magicBall, 75);
			}

			// Powerball 1 car year + lucky number (less than 65)
			int pB1 = (carYear + luckyNum);
			while (pB1 > 65) {
				pB1 = Math.subtractExact(pB1, randNum3);
			}

			// Powerball 2 user random number - generated random number (greater than 0)
			int pB2 = (wholeNum - randNum2);
			while (pB2 < 0) {
				pB2 = Math.multiplyExact(pB2, -1);
			}

			// Powerball 3 pet age + car year (less than 65)
			int pB3 = (petAge + carYear);
			while (pB3 > 65) {
				pB3 = Math.subtractExact(pB3, randNum3);
			}

			// Powerball 4 third letter of pets name in ASCII (less than 65)
			while (catByte[2] > 65) {
				catByte[2] = (byte) Math.subtractExact(catByte[2], randNum2);
			}

			// Powerball 5 Actor/Actress first name first letter in ASCII (less than 65)
			while (actByte[0] > 65) {
				actByte[0] = (byte) Math.subtractExact(actByte[0], randNum1);
			}

			// Compare numbers
			if (pB1 == pB2 || pB1 == pB3 || pB1 == catByte[2] || pB1 == actByte[0] || pB1 == magicBall && pB1 < 65) {
				pB1 = (pB1++);
			}
			if (pB2 == pB1 || pB2 == pB3 || pB2 == catByte[2] || pB2 == actByte[0] || pB2 == magicBall && pB2 < 65) {
				pB2 = (pB2++);
			}
			if (pB3 == pB1 || pB3 == pB2 || pB3 == catByte[2] || pB3 == actByte[0] || pB3 == magicBall && pB3 < 65) {
				pB3 = (pB3++);
			}
			if (catByte[2] == pB1 || catByte[2] == pB2 || catByte[2] == pB3 || catByte[2] == actByte[0]
					|| catByte[2] == magicBall && catByte[2] < 65) {
				catByte[2] = (catByte[3]);
			}
			if (actByte[0] == pB1 || actByte[0] == pB2 || actByte[0] == pB3 || actByte[0] == catByte[2]
					|| actByte[0] == magicBall && actByte[0] < 65) {
				actByte[0] = (actByte[1]);
			}

			int[] powerBall = new int[] { pB1, pB2, pB3, catByte[2], actByte[0] };
			Arrays.sort(powerBall);
			String superPowerBall = String.join(", ",
					Arrays.stream(powerBall).mapToObj(String::valueOf).toArray(n -> new String[n]));

			System.out.printf("Lottery numbers: " + superPowerBall + "  Magic ball: %s \n", magicBall);

			System.out.printf("Would you like to play again? \n ('y' or 'n')");
			String playAgain = scanner.next();
			if (playAgain.equals("y")) {
				main(args);

			} else {
				System.out.println("Thank you, come again.");
				return;
			}

		} else {
			System.out.println("Please come back later when you can complete the survey.");
			return;
		}
	}
}