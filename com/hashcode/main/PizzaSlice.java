package com.hashcode.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PizzaSlice {

	public static void main(String[] args) {
		try {Scanner scanner = new Scanner(new File("E:\\e_also_big.in"));
		List<Integer> tall = new ArrayList<Integer>();

		while(scanner.hasNextInt()){
			tall.add(scanner.nextInt());

		}
		scanner.close();
		
		int maximumSlices = tall.get(0);
		tall.remove(0);
		int pizzaVarieties = tall.get(0);	
		tall.remove(0);
		List<Integer> orignal = new ArrayList<Integer>();
		orignal.addAll(tall);

		int sum = 0;

		ArrayList<Integer> m = new ArrayList<Integer>();


		for(int j=0; j < pizzaVarieties; j++) {	

			sum+=Collections.max(tall);			 

			m.add(Collections.max(tall));

			tall.remove(Collections.max(tall));

			if(sum > maximumSlices) {
				sum-=Collections.min(m);
				m.remove(Collections.min(m));
			}
			;

		}

		ArrayList<Integer> g = new ArrayList<Integer>();
		for(int k=0; k<m.size();k++) {

			if(orignal.contains(m.get(k)))
			{
				g.add(orignal.indexOf(m.get(k)));		 
			}

		}
		Collections.sort(g);

		FileWriter fileWriter = new FileWriter("E:/pizzaOutput.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print(m.size());
		printWriter.println();
		for (Integer integer : g) {
			printWriter.print(integer+" ");
		}

		printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
