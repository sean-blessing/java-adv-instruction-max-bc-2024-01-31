package ui;

import java.util.ArrayList;
import java.util.List;

import util.Console;

public class WizardInventoryApp {
	private static final String COMMAND_SHOW="show";
	private static final String COMMAND_GRAB="grab";
	private static final String COMMAND_EDIT="edit";
	private static final String COMMAND_DROP="drop";
	private static final String COMMAND_EXIT="exit";

	public static void main(String[] args) {
		System.out.println("The Wizard Inventory Game");
		String command = "";
		List<String> itemsList = new ArrayList<>();
		itemsList.add("wooden staff");
		itemsList.add("wizard hat");
		itemsList.add("cloth shoes");
		
		while (!command.equalsIgnoreCase(COMMAND_EXIT)) {
			command = promptCommandMenu();
			// if or switch statement
			switch (command) {
				case COMMAND_SHOW:
					showItems(itemsList);
					break;
				case COMMAND_GRAB:
					grabItem(itemsList);
					break;
				case COMMAND_EDIT:
					editItem(itemsList);
					break;
				case COMMAND_DROP:
					dropItem(itemsList);
					break;
				case COMMAND_EXIT:
					System.out.println("Exit app:");
					break;
				default:
					System.out.println("Invalid command.");
			}
		}
		
		System.out.println("bye");

	}
	
	private static String promptCommandMenu() {
		System.out.println("\nCOMMAND MENU:");
		System.out.println("==================================");
		System.out.println(COMMAND_SHOW+" - Show all items");
		System.out.println(COMMAND_GRAB+" - Grab (Add) an item");
		System.out.println(COMMAND_EDIT+" - Edit an item");
		System.out.println(COMMAND_DROP+" - Drop an item");
		System.out.println(COMMAND_EXIT+" - Exit program");
		return Console.getString("Command: ");
	}
	
	private static void showItems(List<String> items) {
		System.out.println("Show all items:");
		System.out.println("---------------");
		for (int i = 1; i <= items.size(); i++) {
			System.out.println(i+". "+items.get(i - 1));
		}
	}

	private static void grabItem(List<String> items) {
		System.out.println("Grab (Add) an item:");
		System.out.println("---------------");
		
		if (items.size() >= 4) {
			System.out.println("You can't carry any more items. Drop something first.");
		}
		else {
			String itemName = Console.getString("Item name: ");
			items.add(itemName);
			System.out.println(itemName + " was added.");
		}
	}
	private static void editItem(List<String> items) {
		System.out.println("Edit an item:");
		System.out.println("---------------");
		
		int itemNbr = itemExists(items);
		if (itemNbr != 0) {
			// edit the item
			String updatedName = Console.getString("Updated name: ");
			items.set(itemNbr - 1, updatedName);
		}
		else {
			System.out.println("Error - item doesn't exist.");
		}
		
		System.out.println("Item # "+itemNbr+" was updated.");
	}
	
	private static void dropItem(List<String> items) {
		System.out.println("Drop an item:");
		System.out.println("---------------");
		
		int itemNbr = itemExists(items);
		String itemRemoved = "";
		if (itemNbr != 0) {
			// delete the item
			itemRemoved = items.remove(itemNbr-1);
		}
		else {
			System.out.println("Error - item doesn't exist.");
		}
		
		System.out.println(itemRemoved+" was deleted.");
	}
	
	// Prompt the user for the item #
	// Validate that an item exists in that position
	private static int itemExists(List<String> items) {
		int itemNbr = 0;
		itemNbr = Console.getInt("Enter item #: ", 0, items.size() + 1);
		return itemNbr;

	}
}
