package com.hashcode.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PizzaSlice {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

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

		List<Integer> g = new ArrayList<Integer>();
		for(int k=0; k<m.size();k++) {

			if(orignal.contains(m.get(k)))
			{
				g.add(orignal.indexOf(m.get(k)));		 
			}

		}
		Collections.sort(g);
		
		for(int i = 0; i < g.size(); i++) {  
	        for(int j = i + 1; j < g.size(); j++) {  
	            if(g.get(i) == g.get(j)) {       
	            System.out.print(g.get(j)+" ");
	            g.set(j, g.get(j)+1);
	         
	            }
	        }  
	    }  
		
		System.out.println(m.size());
		for (Integer integer : g) {
			System.out.print(integer+" ");
		}
	}

}
