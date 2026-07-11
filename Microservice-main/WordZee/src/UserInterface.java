import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a sentence ");
		String sentence = sc.nextLine();

		String words[] = sentence.split(" ");
		for (String s : words) {
			for (int i = 0; i < s.length(); i++) {
				if (!Character.isLetterOrDigit(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
					System.out.println(sentence + " is an invalid sentence");
					sc.close();
					return;
				}
			}
		}
		System.out.println("Enter a word ");
		String word = sc.nextLine();
		for (int i = 0; i < word.length(); i++) {
			if (!Character.isLetterOrDigit(word.charAt(i)) || Character.isDigit(word.charAt(i))) {
				System.out.println(word + " is an invalid word");
				sc.close();
				return;
			}
		}

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word)) {
				StringBuilder str = new StringBuilder();
				String rev = str.append(words[i]).reverse().toString();
				words[i] = rev;
				String result = String.join(" ", words);
				System.out.println(result);
				sc.close();
				return;
			}
		}
		System.out.println(word + " is not in the sentence");
		sc.close();
	}

}
