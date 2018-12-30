package cogitare.problem1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
	
	public static Map<String, Map<Integer, List<Integer>>> allTrains;
	
	public static void main(String[] args) {
		//file location
		String fileName = "D:\\Job Interviews\\Cogitare\\TrainDetails.txt";
		
		//Create a map for all registered trains
		allTrains = new HashMap<String, Map<Integer,List<Integer>>>();
//		Map<Integer, List<Integer>> trainSpeedData = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			
			//Skips the header as it is not the data we need
			br.readLine();
			
			
			while ((line = br.readLine()) != null) {
				if (line.length() > 0) {
					String[] trains = line.split("-");
					
					String trainName = trains[0];
					int speed = Integer.parseInt(trains[1]);
					int energyConsumption = Integer.parseInt(trains[2]);
					
					//get the map of all speeds and energy of a specific train
					Map<Integer, List<Integer>> trainSpeedData = allTrains.get(trainName);
					
					//if trainSpeedData is null, there was nothing inserted yet
					if(trainSpeedData == null) {
						
						//create map of energyConsumption for each speed
						trainSpeedData = new HashMap<Integer, List<Integer>>();
						
				//create a new list for all energyConsumption for a particular speed
						List<Integer> energyList = new ArrayList<>();
						//add current energyConsumption to the list
						energyList.add(energyConsumption);
						
						//insert new list into the map
						trainSpeedData.put(speed, energyList);
						//add trainspeedData to the current trainName
						allTrains.put(trainName, trainSpeedData);
					}
					else {
						// get energy speed by list
						List<Integer> energyList = trainSpeedData.get(speed);
						
						// if list is null then there was no record for this train at this speed.
						if(energyList == null) {
							
							//create new list
							energyList = new ArrayList<>();
							//add energy to the list 
							energyList.add(energyConsumption);
							//add list to the speed in map
							trainSpeedData.put(speed, energyList);
							
						}
						else {
							//there is a energy list olready, just add to the list another record
							energyList.add(energyConsumption);
							//add to the map
							trainSpeedData.put(speed, energyList);
							
						}
						
					}
					
					
					
					
					// perhaps we won't need TrainData class 
					TrainData train = new TrainData(trainName, speed, energyConsumption);

					
					
					
					
//					System.out.println(train.getName());
					
				}
			}
			
			//print the trains map
			allTrains.entrySet().stream()
			.forEach(System.out::println);
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}

		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the train name: ");
//		String searchedTrain = input.next();
//		getLowestSpeed("201V");
		getHighestEnergyConsumption("157P");
		
		
	}
	
	
	public static void getLowestSpeed(String searchedTrain){
		Map<Integer, List<Integer>> trainData = allTrains.get(searchedTrain);
		boolean isTrain = searchTrain(searchedTrain);
		
		if(isTrain) {
//			List<Integer> allSpeeds = new ArrayList<>(trainData.keySet());
			int min = Collections.min(trainData.keySet());
			System.out.println("Lowest Speed: " + min);
		}
		else {
			System.out.println("No details found");
		}
			
		
		
	}
	
	
	
	public static String getHighestEnergyConsumption(String searchedTrain) {
		Map<Integer, List<Integer>> trainData = allTrains.get(searchedTrain);
		boolean isTrain = searchTrain(searchedTrain);
		String d = "ss";
		
		int maximum = -1;
		int speed = -1;
		
		for(Integer key: trainData.keySet()) {
			
			List<Integer> energies = trainData.get(key);
			
			for(Integer n : energies) {
				if( n > maximum) {
					maximum = n;
					speed = key;
				}
			}
		}
		System.out.println(maximum);
		return d;
	}
	
	
	
	
	public static boolean searchTrain(String trainName) {
		boolean train = allTrains.containsKey(trainName);
		
		return train;
	}
	
	
	
}
