package startup;

import controller.Controller;
import integration.ItemIdentifierNotFoundException;
import view.View;
import integration.SystemCreator;
import integration.Printer;

public class Main {


	public static void main(String[] args) {
		SystemCreator creator = new SystemCreator();
		Printer printer = new Printer();
		Controller contr = new Controller(creator, printer);
		View view = new View(contr);
		view.execute();
	}

}
