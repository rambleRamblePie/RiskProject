// singleton

// this is terminal-based for now
// GUI perhaps later
enum UI {
	INSTANCE;
	
	UI() {
		System.out.prinln("UI initiated");
	}
	
	String prompt(String p, ArrayList<String> options = null) {
		System.out.println(p);
		
		return null;
	}
	
	void display(String s) {
		System.out.println(s);
	}
	
	void display(ArrayList<String> lines) {
		for (line : lines) {
			System.out.println(line);
		}
	}
	
}