import java.util.*;

// singleton

// this is terminal-based for now
// GUI perhaps later
public enum UI {
	INSTANCE;
	
	UI() {
		System.out.println("UI initiated");
	}
	
	String prompt(String p) {
		System.out.println(p);
		
		return null;
	}
	
	String prompt(String p, ArrayList<String> options) {
		System.out.println(p);
		
		// for each option, do:
		// System.out.println("\t" + option);
		return null;
	}
	
	void display(String s) {
		System.out.println(s);
	}
	
	void display(ArrayList<String> lines) {
		for (String line : lines) {
			System.out.println(line);
		}
	}
	
}