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
	
	public static Map<String, TrainData> allTrains;
	
	public static void main(String[] args) {
		//file location
		String fileName = "D:\\Job Interviews\\Cogitare\\TrainDetails.txt";
		
		//Create a map for all registered trains
		allTrains = new HashMap<String, TrainData>();
//		Map<Integer, List<Integer>> trainSpeedData = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			
			//Skips the header as it is not the data we need
			br.readLine();
			
			
			while ((line = br.readLine()) != null) {
				
				//checks if the line is not empty
				if (line.length() > 0) {
					String[] trains = line.split("-");
					
					String trainName = trains[0];
					int speed = Integer.parseInt(trains[1]);
					int energyConsumption = Integer.parseInt(trains[2]);
					
					//get the map of all speeds and energy of a specific train
					TrainData trainData = allTrains.get(trainName);
					
					//if trainSpeedData is null, there was nothing inserted yet
					if(trainData == null) {
						
						//create map of energyConsumption for each speed
						trainData = new TrainData();
						
						
					}

					trainData.setSpeedAndEnergy(speed, energyConsumption);
					
					
					//add trainspeedData to the current trainName
					allTrains.put(trainName, trainData);
					
					
					
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
		String searchedTrain = input.next();
		getLowestSpeed(searchedTrain);
		getHighestEnergyConsumption(searchedTrain);
		
		
	}
	
	
	public static void getLowestSpeed(String searchedTrain){
		TrainData trainData = allTrains.get(searchedTrain);
		boolean isTrainFound = trainData != null;
		
		if(isTrainFound) {
//			List<Integer> allSpeeds = new ArrayList<>(trainData.keySet());
//			int min = Collections.min(trainData.getData().keySet());
			System.out.println("Lowest Speed: " + trainData.getLowestSpeed());
			
		}
		else {
			System.out.println("No details found");
		}
			
		
		
	}
	
	
	
	public static String getHighestEnergyConsumption(String searchedTrain) {
		TrainData trainData = allTrains.get(searchedTrain);
		
		boolean isTrainFound = trainData != null;
		
		String d = "ss";
		
		int maximum = -1;
		int speed = -1;
		
		for(Integer key: trainData.getData().keySet()) {
			
			List<Integer> energies = trainData.getData().get(key);
			
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
	
	
	
	
}
