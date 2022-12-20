/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lotto649;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sourishdas
 */
public class Lotto649 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    // Rules of 649
    
        // There are 6 numbers between 1 and 49 drawn for each ticket
        // There are 6 winning numbers that are between 1 and 49
        
        // The winnings:
            // For 6/6 the prize is $6,000,000.00
            // For 5/6 the prize is $2,558.90
            // For 4/6 the prize is $83.30
            // For 3/6 the prize is $10.00
            // For 2/6 the prize is $3
            // For 1/6 there is no prize
        
            
        
    // Fundamental Functions
        Random rand = new Random();
    
        Scanner scanner = new Scanner(System.in);

        
    
    // Finding the Amount of Tickets that Need to be Generated    
        System.out.print("How many tickets are you looking to purchase between 1 & 100: ");
    
        int t = scanner.nextInt();
        
            while(t < 0||t > 100){
                System.out.print("You entered an invalid amount, please enter a value between 1 and 100: ");
            t = scanner.nextInt();
            }
        
      System.out.println();
        
      
      
    // Cost of Tickets 
        int ticketCost = 3;
        double tax = 1.13;
        double totalCost = ticketCost * tax;
    
        if (t == 1){
            System.out.println("The cost of your ticket is $" + String.format("%.2f", totalCost) + " with tax");
        }
        else {
        System.out.println("The cost of your tickets are $" + String.format("%.2f", totalCost * t) + " with tax");
        }
    
        System.out.println();
    
    
    
    // Generating the 6 Winning Numbers
        int[] winningNumbers = new int [6];
        
        boolean isRepeated;
    
        int randomNumber = 0;
        
        System.out.println("These are the winning numbers in this draw: ");
        
            for (int i = 0; i < 6; i++) {
                do {
                    isRepeated = false;
                    randomNumber = rand.nextInt(49) + 1;
                
                    for (int j = 0; j <= i; j++){
                        if (winningNumbers[j] == randomNumber) {
                            isRepeated = true;
                            break;
                        }
                    
                    }
                } while (isRepeated);
                winningNumbers[i] = randomNumber;
            System.out.println(winningNumbers[i]);
            }
    
        System.out.println();
    
  
    
    // Generating the Numbers on each of the tickets
        System.out.println("These are your tickets: ");
    
        int[][] ticketNumbers = new int [t][7];
        
        boolean repeated;
    
        int random = 0;
        
        for (int a = 0; a < t; a++) {   
            for (int i = 0; i < 7; i++) {
                    do {
                        repeated = false;
                        random = rand.nextInt(49) + 1;
                    
                        for (int j = 0; j < 6 ; j++){
                            if (ticketNumbers[a][j] == random) {
                                repeated = true;
                                break;
                            }
                    
                        }
                    } while (repeated);
                    ticketNumbers[a][i] = random;
                    ticketNumbers [a][6] = 0;
            }
        
        }
        
        
        
    // Finding and Printing the amount of Common Numbers 
    
        // Counting the amount of Numbers in Common
        for (int i = 0; i < t; i++) { 
            ticketNumbers[i][6] = 0;
            for (int j = 0; j < 6; j++) { 
                for (int z = 0; z < 6; z++){
                    if (ticketNumbers[i][j] == winningNumbers[z]) {
                        ticketNumbers[i][6]++;
                        
                    }    
                    
                }
            
            }
            
        }
        
    
    
    // Printing the ticket numbers
        for (int i = 0; i < t; i++){
            for (int j = 0; j < 6; j++){    //Only upto 6, so the number of matching numbers is not mistaken as part of the ticket
                System.out.printf("%d ", ticketNumbers[i][j]);
            
            }
            System.out.println();
        }
    
        
    
    // Finding how many tickets have 3+ numbers in common
        System.out.println();
    
        int count = 0;
        int count_1 = 0;
        int count_2 = 0;
        int count_3 = 0;
        int count_4 = 0;
        int count_5 = 0;
        int count_6 = 0;
        
        for (int i = 0; i < t; i++){
            if (ticketNumbers[i][6] == 6)
                count_6++;
            else if (ticketNumbers[i][6] == 5)
                count_5++;
            else if (ticketNumbers[i][6] == 4)
                count_4++;
            else if (ticketNumbers[i][6] == 3)
                count_3++;
            else if (ticketNumbers[i][6] == 2)
                count_2++;
            else if (ticketNumbers[i][6] == 1)
                count_1++;
            else
                count++;
        }
        
        System.out.println("Out of your " + t + " tickets, " 
                + "\n" + count_6 + " tickets have 6 common numbers" 
                + "\n" + count_5 + " tickets have 5 common numbers"
                + "\n" + count_4 + " tickets have 4 common numbers"
                + "\n" + count_3 + " tickets have 3 common numbers" 
                + "\n" + count_2 + " tickets have 2 common numbers"
                + "\n" + count_1 + " tickets have 1 common number"
                + "\n" + count + " tickets that have 0 common numbers");
        
        System.out.println();
        
        
        
    // Determining the amount of winnings

        double winnings = 0;
    
        for (int i = 0; i < t; i++) {
            if (ticketNumbers [i][6] == 6)
                winnings = winnings + 6000000;
            else if (ticketNumbers [i][6] == 5)
                winnings = winnings + 2558.90;
            else if (ticketNumbers [i][6] == 4)
                winnings = winnings + 83.30;
            else if (ticketNumbers [i][6] == 3) 
                winnings = winnings + 10;
            else if (ticketNumbers [i][6] == 2)
                winnings = winnings + 3;
            else 
                winnings = winnings + 0;
               
    } System.out.println("You will receive $" + String.format("%.2f",winnings));
    
    System.out.println();
    
    
    
    // Determining the profit from the lottery
    
        double profit = winnings - (totalCost * t);
        double loss = (winnings - (totalCost * t)) * -1;
    
        if (profit >= (totalCost * t)) {
            System.out.println("You have made $" + String.format("%.2f",profit));
        }
        else {
            System.out.println("You have lost $" + String.format("%.2f", loss));
        }
        
        
    
    // Determining what tickets to print
    
    System.out.println();
    
    System.out.print("Which tickets would you like to see; 0 to 6 common numbers: ");
    int uservisual = scanner.nextInt();
    
    while (uservisual < 0 || uservisual > 6) {
        System.out.print("You entered an invalid amount, please enter a value between 1 and 6: ");
        uservisual = scanner.nextInt();
    }
    

    for (int v = 0; v < t; v++) {
        if (uservisual == v) {
    
            for (int a = 0; a < t; a++) {
        
                if (ticketNumbers[a][6] == v) {
                    for (int j = 0; j < 6; j++){    //Only upto 6, so the number of matching numbers is not mistaken as part of the ticket
                        System.out.printf("%d ", ticketNumbers[a][j]);
                    }
                        System.out.println();
                }   
          
            }
    
        }
    }
    
    
    
    }
    
}
    

    
    
    
    
