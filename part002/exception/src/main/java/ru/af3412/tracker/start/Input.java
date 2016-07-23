package ru.af3412.tracker.start;

public interface Input {

	String ask(String question);

	int ask(String question, int[] range);
	
}