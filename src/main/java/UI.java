class UI {
	
	UI() {
		system.out.prinln("UI initiated");
	}
	
	String prompt(String p, ArrayList<String> options = null) {
		system.out.println(p);
		
		return null;
	}
	
	void display(String s) {
		system.out.println(s);
	}
	
	void display(ArrayList<String> lines) {
		for (line : lines) {
			system.out.println(line);
		}
	}
	
	
}