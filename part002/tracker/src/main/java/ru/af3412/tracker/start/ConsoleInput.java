package ru.af3412.tracker.start;
import java.util.*;

/**
 * The type Console input.
 */
public class ConsoleInput implements Input{

	private Scanner scanner = new Scanner(System.in);

	public String ask(String question) {
		System.out.print(question);
		return scanner.nextLine();
	}

}