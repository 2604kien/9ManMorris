package src.game.utils;

import java.util.Scanner;

public class GameManager {
    public static int chooseModeItem(){
        int choice=0;

        Scanner sel = new Scanner(System.in);
        do {
            String menu = "";
            menu += "\n---------------------";
            menu += " MENU ";
            menu += "---------------------\n";
            System.out.print(menu);

            System.out.println("(1) Normal Mode / (2) Tutorial Mode / (3) Exit");

            System.out.print("Please select one:");
            choice = Integer.parseInt(sel.nextLine());

            System.out.println("Your choice:" + choice);

            return choice;
        }
        while(choice!=1 && choice!=2 && choice!=3);
    }

    public static int menuItem() {
        int choice=0;

        Scanner sel = new Scanner(System.in);
        do {
            String menu = "";
            menu += "\n---------------------------------------";
            menu += " MENU ";
            menu += "---------------------------------------\n";
            System.out.print(menu);

            System.out.println("(1) Choose a Player / (2) Place a Token / (3) Move a Token / (4) Fly Token / (5) Exit");
            System.out.print("Please select one:");
            choice = Integer.parseInt(sel.nextLine());

            System.out.println("Your choice:" + choice);

            return choice;
        }
        while(choice!=1 && choice!=2 && choice!=3 && choice!=4 && choice!=5);
    }
}
