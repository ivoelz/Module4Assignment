package edu.wctc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

    final static Scanner keyboard = new Scanner(System.in);
    private static PaintCalculator paintCalculator = new PaintCalculator();
    static boolean exit = true;

    private static void printMenu() {
        System.out.println("1. Add room");
        System.out.println("2. View rooms");
        System.out.println("3. Read rooms from file");
        System.out.println("4. Write rooms to file");
        System.out.println("5. Exit program");

        System.out.println("Enter Selection: ");
    }

    private static double promptForDimension(String dimensionName) {
        System.out.println("Enter " + dimensionName + ": ");
        return Double.parseDouble(keyboard.nextLine());
    }

    private static void createRoom() {
        double length = promptForDimension("length");
        double width = promptForDimension("width");
        double height =promptForDimension("height");
        paintCalculator.addRoom(length, width, height);
    }

    private static void readFile() {
        try {
            FileInputStream file = new FileInputStream("paintCalculator.txt");
            ObjectInputStream input = new ObjectInputStream(file);
            paintCalculator = (PaintCalculator) input.readObject();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File was not found");
        }
        catch (IOException e)
        {
            System.out.println("Error initializing stream");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private static void writeFile() {
        try {
            FileOutputStream file = new FileOutputStream("paintCalculator.txt");
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(paintCalculator);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File was not found");
        }
        catch (IOException e)
        {
            System.out.println("Error initializing stream");
        }
    }

    public static void main(String[] args) {
        while (exit) {
            printMenu();
            int userSelection = Integer.parseInt(keyboard.nextLine());

            if (userSelection == 1)
            {
                createRoom();
            }
            else if (userSelection == 2)
            {
                System.out.println(paintCalculator.toString());
            }
            else if (userSelection == 3)
            {
                readFile();
            }
            else if (userSelection == 4)
            {
                writeFile();
            }
            else if (userSelection == 5)
            {
                exit = false;
            }
            else {
                System.out.println("Please enter a number from the menu");
            }
        }
    }
}
