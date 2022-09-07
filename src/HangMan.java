import java.util.ArrayList;
import java.util.Scanner;

public class HangMan {
	public static ArrayList<Character> word = new ArrayList<Character>();
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int guesses = 0;
		char userGuess = ' ';
		String userWord = "";
		System.out.println("Welcome to HangMan!!");
		System.out.println("Enter a word and have your friend guess!");
		System.out.print("Enter Word: ");
		userWord = input.nextLine();
		System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < userWord.length(); i++) {
        	word.add(userWord.charAt(i));
        }
        System.out.println("hi");
        while (guesses < 6) {
        	System.out.println(drawBoard(guesses, userGuess));
        	System.out.print("Please enter your guess: ");
        	userGuess = input.nextLine().charAt(0);
        	guesses += 1;
        }
        input.close();
	}
	
	public static String drawBoard(int guesses, char userGuess) {
		String line1 = " ______\n";
		String line2 = "|      |\n";
		String line3 = "|       \n";
		String line4 = "|       \n";
		String line5 = "|       \n";
		String line6 = "|=========\n";
		String line7 = checkGuess(userGuess);
		if (guesses > 0) {
			line3 = "|      O\n";
		}
		if (guesses > 1) {
			line4 = "|      |\n";
		}
		if (guesses > 2) {
			line4 = "|     /|\n";
		}
		if (guesses > 3) {
			line4 = "|     /|\\\n";
		}
		if (guesses > 4) {
			line5 = "|     /\n";
		}
		if (guesses > 5) {
			line5 = "|     / \\\n";
		}
		return line1 + line2 + line3 + line4 + line5 + line6 + line7;
	}
	
	public static String checkGuess(char userGuess) {
		String results = "";
		for (char letter : word) {
			if (userGuess == letter) {
				results += letter;
			} else {
				results += "_";
			}
		}
		return results;
	}

}
