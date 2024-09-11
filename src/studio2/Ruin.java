package studio2;

import java.util.Scanner;

public class Ruin {
	
	public static void main(String[] args) { 	
		Scanner in = new Scanner(System.in);
		System.out.println("What's your starting money?");
		int startAmount = in.nextInt();
		System.out.println("What's your wining probability?");
		double winChance = in.nextDouble();
		System.out.println("What's your win limit?");
		int winLimit = in.nextInt();
		System.out.println("How many days?");
		int totalSimulations = in.nextInt();
		int temp = startAmount;
		int count = 0;
		double ruin = 0;
		for (int i = 0;i  <= totalSimulations; i++)
		{
			while (startAmount <= winLimit && startAmount != 0 ) 
			{
				if ( (Math.random()*100)+1 <= winChance*100 )
				{
					
					startAmount += 1;
					count++;

				}
				else 
				{
					
					startAmount -= 1;
					count++;
				}

				
			}
			if (startAmount >= winLimit)
			{
				System.out.println("DAY: "+ i+ " Rounds: "+ count+ " YOU WON.");
				
			}
			else
			{
				System.out.println ("DAY: "+ i+ " Rounds: "+ count+ " YOU LOST");
				ruin ++;
			}
			
			count = 0;
			startAmount = temp;
		}
		double a = (1 - winChance)/winChance;
		if (winChance == 0.5) {
			
			double expectedruin = ((1-((startAmount)/winLimit)));
			System.out.print("Ruin Rate from Simulation: " + ruin/totalSimulations + " Expected Ruin Rate: " + expectedruin);
		}
		else {
			double expectedruin = ((((Math.pow(a, startAmount) - Math.pow(a, winLimit))/(1-Math.pow(a, winLimit)))));
			System.out.print("Ruin Rate from Simulation: " + ruin/totalSimulations + " Expected Ruin Rate: " + expectedruin);

		}

	}
	


}


