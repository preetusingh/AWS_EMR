

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class RandomSetGenerate {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("How many Random values set is required: ");
		int set = sc.nextInt();
			
		System.out.print("Enter the Radius value of the Circle: ");
		int radius = sc.nextInt();
		int diameter = 2*radius;
		

		int r =radius;
		double [][][] randomSet = new double [set][1][2];
		for(int i =0;i<randomSet.length;i++){
			for(int j =0;j<randomSet[i].length;j++){
				for(int k =0;k<randomSet[i][j].length;k++){
		 randomSet[i][j][k]=(double)(Math.random()*diameter);	
		}
		}
		}
				
		System.out.println("Randomly generated set value: "+Arrays.deepToString(randomSet));
		
		double distance[] = new double[set];
		for(int i =0; i< randomSet.length;i++){
			for(int j =0;j<randomSet[i].length;j++){
				double x = randomSet[i][j][0];
				double y = randomSet[i][j][1];
				
				distance[i]=(double)Math.sqrt(((r-x)*(r-x) +(r-y)*(r-y)));	
				
			}		
		}
		
		System.out.println("distance :"+Arrays.toString(distance));
	
		
		try { 
			PrintStream myconsole =  new PrintStream(new File("D:/trial//PiCalculationInput.txt"));
			System.setOut(myconsole);
			for(int i =0; i< distance.length;i++){
			if(distance[i]<1) 
				myconsole.print("I ");
			else
								
				myconsole.print("O ");
		}
		}
		catch(FileNotFoundException fx){
			System.out.println("File not found");	
		}
		
		
	}
}

