/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package b.skmotorsauction;
import java.util.Scanner;

public class SkMotorsAuction {
    public static void main(String[] args) {
        
        try (java.util.Scanner input = new Scanner(System.in)) {
            // Vehicle details
            System.out.print("Enter vehicle registration number: ");
            String regNo = input.nextLine();
            
            System.out.print("Enter vehicle cost: ");
            double vehicleCost = input.nextDouble();
            input.nextLine(); 
            
            System.out.print("Enter balance left on the vehicle: ");
            double balance = input.nextDouble();
            input.nextLine();
            
            System.out.print("Enter total deposits made on the vehicle: ");
            double deposits = input.nextDouble();
            input.nextLine();
            
            System.out.print("Enter total expenses incurred on the vehicle: ");
            double expenses = input.nextDouble();
            input.nextLine();
            
            // bidders
            double highestBid = 0;
            String highestBidder = "";
            
            for (int i = 1; i <= 3; i++) {
                System.out.print("Enter bidder " + i + " name: ");
                String bidderName = input.nextLine();
                
                System.out.print("Enter bidder " + i + " price: ");
                double bidPrice = input.nextDouble();
                input.nextLine(); 
                
                if (bidPrice > highestBid) {
                    highestBid = bidPrice;
                    highestBidder = bidderName;
                }
            }
            
            
            System.out.println("\nVehicle " + regNo + " sold to " + highestBidder + " at price: " + highestBid);
            
            
            double totalCost = vehicleCost + expenses - deposits; 
            double profitOrLoss = highestBid - (totalCost + balance);
            
            System.out.println("Vehicle Cost: " + vehicleCost);
            System.out.println("Deposits: " + deposits);
            System.out.println("Expenses: " + expenses);
            System.out.println("Balance: " + balance);
            System.out.println("Total Net Cost: " + totalCost);
            System.out.println("Profit/Loss: " + profitOrLoss);
            
            if (profitOrLoss > 0) {
                System.out.println("Result: PROFIT");
            } else if (profitOrLoss < 0) {
                System.out.println("Result: LOSS");
            } else {
                System.out.println("Result: BREAK-EVEN");
            }
        }
    }
}
