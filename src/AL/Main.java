package AL;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        testDriver(scn, list);
    }

    /**
     * menu Prints a menu of choices for the user to select for interacting with an ArrayList object.
     */
    public static void menu() {
        System.out.print("Methods for ArrayList\n1 - ADD - Adds an element into the ArrayList\n2 - CONTAINS - " +
                "Checks if an element is contained in the ArrayList\n3 - REMOVE - Removes an element from the " +
                "ArrayList\n4 - GET - retrieves an element at a specified index\n5 - IS EMPTY - Checks if the " +
                "ArrayList is empty\n6 - IS FULL - Checks if the ArrayList is full\n7 - SIZE - Retrieves the number" +
                " of elements in the ArrayList\n8 - CLEAR - Clears the ArrayList of all elements\n9 - INDEX OF - " +
                "Retrieves the first index of an element, if present\n10 - LAST INDEX OF - Retrieves the last " +
                "index of an element, if present\n11 - SET - Sets an index to a value\n12 - TO STRING - Returns a " +
                "String of the elements in the ArrayList\nX - Terminate\n\nEnter choice: ");
    }

    /**
     * testDriver A test driver method for interacting with an ArrayList object.
     * @param scn A Scanner object for user input.
     * @param list An ArrayList object.
     */
    public static void testDriver(Scanner scn, ArrayListInterface<Integer> list) {
        String choice = "";
        while(!choice.equalsIgnoreCase("X")) {
            menu();
            choice = scn.nextLine();
            if(choice.equals("1")) {
                System.out.print("Enter an integer element to add in the ArrayList: ");
                int input = scn.nextInt();
                scn.nextLine();
                System.out.println(input + " added: " + list.add(input));
            } else if(choice.equals("2")) {
                System.out.print("Enter an integer to search that element in the ArrayList: ");
                int input = scn.nextInt();
                scn.nextLine();
                System.out.println(input + " found: " + list.contains(input));
            } else if(choice.equals("3")) {
                System.out.print("Enter an integer element to remove from the ArrayList: ");
                int input = scn.nextInt();
                scn.nextLine();
                System.out.println(input + " removed: " + list.remove(input));
            } else if(choice.equals("4")) {
                System.out.print("Enter an index to retrieve an element from that location: ");
                int input = scn.nextInt();
                scn.nextLine();
                System.out.println("Index " + input + " value: " + list.get(input));
            } else if(choice.equals("5")) {
                System.out.println("Empty ArrayList: " + list.isEmpty());
            } else if(choice.equals("6")) {
                System.out.println("Full ArrayList: " + list.isFull());
            } else if(choice.equals("7")) {
                System.out.println("Number of elements in ArrayList: " + list.size());
            } else if(choice.equals("8")) {
                list.clear();
                System.out.println("ArrayList cleared");
            } else if(choice.equals("9")) {
                System.out.print("Enter an integer element to retrieve the first index of that element: ");
                int input = scn.nextInt();
                scn.nextLine();
                System.out.println("Element " + input + " first found at index: " + list.indexOf(input));
            } else if(choice.equals("10")) {
                System.out.print("Enter an integer element to retrieve the last index of that element: ");
                int input = scn.nextInt();
                scn.nextLine();
                System.out.println("Element " + input + " last found at index: " + list.lastIndexOf(input));
            } else if(choice.equals("11")) {
                System.out.print("Enter an index to set: ");
                int index = scn.nextInt();
                scn.nextLine();
                System.out.print("Enter a value for that index: ");
                int value = scn.nextInt();
                scn.nextLine();
                System.out.println("Index/value set: " + list.set(index, value));
            } else if(choice.equals("12")) {
                String result = list.toString();
                System.out.println("String representation of ArrayList elements:\n" + list.toString());
            } else if(choice.equalsIgnoreCase("X")) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}
