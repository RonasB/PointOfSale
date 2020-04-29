package view;

import controller.Controller;

public class View {

	private Controller contr;

	public View(Controller contr) {

		this.contr = contr;
	}
	public void execute()
	{
		System.out.println("Sale started");
		contr.startSale();
		System.out.println("Entering items...");
		System.out.println("-------------------------------------------------");
		System.out.println(contr.registerItem("Mango", 1));
		System.out.println(contr.registerItem("Kiwi", 2));
		System.out.println(contr.registerItem("Kiwi", 2));
		System.out.println(contr.registerItem("Banana", 2));
		System.out.println(contr.registerItem("Pineapple", 3));
		System.out.println(contr.registerItem("Banana", 1));
		System.out.println(contr.registerItem("Mango", 2));
		System.out.println("-------------------------------------------------");
		System.out.println(contr.endSale());
		contr.registerAmountPaid(40);

	}

}
