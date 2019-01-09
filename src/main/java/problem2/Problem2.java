package problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.jakewharton.fliptables.FlipTableConverters;

public class Problem2 {

	public static void printRow(int[] row) {
		for (int i : row) {
			System.out.print(i);
			System.out.print("\t");
		}
		System.out.println();
	}
	
	public static void printMinimumDemand(int demand, int[] row) {
		for(int d : row) {
			if(d >= demand) {
				System.out.println(d);
			}
		}
	}

	public static void main(String[] args) {

		// Ask user to insert all stations
		Scanner input = new Scanner(System.in);
		List<String> stationsList = new ArrayList<>();

		int maximumDemand = -1;
		String destionation = "";
		String origin = "";

		Map<String, Integer> stationDemand = new HashMap<String, Integer>();

		System.out.println("Insert the stations: ");
		String stationsInput = input.next();

		System.out.println(stationsInput);

		String[] stationArray = stationsInput.split(",");

		List<int[][]> matrix = new ArrayList<>();
		int[][] passengerDemands = new int[stationArray.length][stationArray.length];
		
		int i=0;

		for(String originStation : stationArray) {
			int j =0;
			
			for(String destinationStation : stationArray) {
				if(originStation.equalsIgnoreCase(destinationStation)) {
					passengerDemands[i][j] = 0;
				}
				else {
					System.out.println("Insert passenger demand from " + originStation + " to " + destinationStation + ":");
					int demand = input.nextInt();
					passengerDemands[i][j] = demand;
					if(demand > maximumDemand) {
						maximumDemand = demand;
						origin = originStation;
						destionation = destinationStation;
					}
				}
				j++;
			}
			i++;

			
			stationDemand.put(destionation, maximumDemand);
			
			matrix.add(passengerDemands);
			
		}
		
//		 print the table
		for(String destinationStation : stationArray) {
			System.out.print("\t" + destinationStation);
		}
		int n=0;
		System.out.println("\n");
		for (int[] row : passengerDemands) {
			System.out.print(stationArray[n]);
			System.out.print("\t");
			printRow(row);
			n++;
		
	}
		
		System.out.println("\nMaximum demand is between " + origin + " to " + destionation + "(" + maximumDemand + ")");
		
		
		
		System.out.println("Enter minimum demand for investigation: ");
		int userDemand = input.nextInt();
		for(int[] row: passengerDemands) {
			printMinimumDemand(userDemand, row);

		}
	}
	}
