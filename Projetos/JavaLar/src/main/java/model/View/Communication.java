package model.View;

import java.util.Scanner;

//Class to provide information to the user
public class Communication {

    Scanner cop = new Scanner(System.in);

    private int instants;
    private int instantAccumulator;
    private int bugs;
    private int devs;

    //Main menu
    public boolean menu() {
        System.out.println("==============Enter your choice of option=======================");
        System.out.println("1 - Moving the JavaLar system");
        System.out.println("2 - Close the program");
        if (cop.nextInt() == 1) {
            cop.nextLine();
            moveQuest();
            return true;
        } else {
            return false;
        }
    }

    //User questions
    public void moveQuest() {
        instants = getPositiveIntegerInput("How many moments do you want to move the system? ");
        instantAccumulator += instants;
        bugs = getPositiveIntegerInput("How many bugs do you want to create? ");
        devs = getPositiveIntegerInput("How many devs do you want to create? ");

    }


    public int getPositiveIntegerInput(String quest) {
        while (true) {
            try {
                System.out.print(quest);
                String input = cop.nextLine();
                int number = Integer.parseInt(input);

                if (number < 0) {
                    throw new IllegalArgumentException("Negative numbers are not allowed");
                }

                return number;
            } catch (NumberFormatException e) {
                System.out.println("Error: Entry is not a valid integer.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public int getInstants() {
        return instants;
    }

    public int getBugs() {
        return bugs;
    }

    public int getDevs() {
        return devs;
    }

    public int getInstantAccumulator() {
        return instantAccumulator;
    }

}
