package problem3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Problem3 {
	
	static MyDBManager db = new MyDBManager();
	
	public static void registerTrainDriverDetails(DriverObject journey) {
		db.startTransaction();
		db.persist(journey);
		db.closeTransaction();
	}

	public static void main(String[] args) {
		

		Map<String, List<TrainDataObject>> trainDataMap = new HashMap<String, List<TrainDataObject>>();
		
		//file location
		String fileName = "D:\\Job Interviews\\Cogitare\\DriverAndDelayDetails.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			
			String line;
			
			//skip the header
			br.readLine();
			
			while((line = br.readLine()) != null) {
				String[] trainData = line.split("\\|");
				String trainId = trainData[0];
				
				List<TrainDataObject> tdoList = trainDataMap.get(trainId);
				TrainDataObject tdo = new TrainDataObject(trainData[0], trainData[1], trainData[2], trainData[3], trainData[4]);
				
				if(tdoList == null) {
					tdoList = new ArrayList<>();
					tdoList.add(tdo);
					System.out.println("fdes");
					trainDataMap.put(trainId, tdoList);
				}
				else {
					tdoList.add(tdo);
					trainDataMap.put(trainId, tdoList);
				}
				
				
				
			}
			
			trainDataMap.forEach((trainId, trainDataList) -> {
				
				
				TrainDataObject fromStationObject = null;
				TrainDataObject toStationObject = null;
				
				if(trainDataList.size() == 1) {
					// db.getLastDelayDataObject
				}
				
				for(int i = 0; i < trainDataList.size(); i++) {
					if(i == 0 && trainDataList.size()>1) {
						continue;
					}
					
					if(fromStationObject == null) {
						fromStationObject = trainDataList.get(i-1);
					}
					toStationObject = trainDataList.get(i);
					
					DriverObject driverObject = new DriverObject();
					
					driverObject.setFromStation(fromStationObject.getStation());
					driverObject.setToStation(toStationObject.getStation());
					driverObject.setDriverName(fromStationObject.getDriverName());
					driverObject.setTrainId(fromStationObject.getTrainId());
					
					String trainStatus = "INPROGRESS";
					if(toStationObject.getDepartureLateness().equalsIgnoreCase("NA")){
						trainStatus = "COMPLETED";
					}
					
					driverObject.setJourneyStatus(trainStatus);
					System.out.println(driverObject.getTrainId() + " =====  " + driverObject.getJourneyStatus() );
					
					
//					registerTrainDriverDetails(driverObject);
					
					if(i == 1) {
						
						DelayObject do1 = new DelayObject();
						do1.setTrainId(trainId);
						do1.setStation(fromStationObject.getStation());
						do1.setDepartureTimeAtStation(fromStationObject.getActualDepartureTime());
						do1.setDepartureLateness(fromStationObject.getDepartureLateness());
//						db.persist(do1);
					}
					
					DelayObject do2 = new DelayObject();
					do2.setTrainId(trainId);
					do2.setStation(toStationObject.getStation());
					do2.setDepartureTimeAtStation(toStationObject.getActualDepartureTime());
					do2.setDepartureLateness(toStationObject.getDepartureLateness());
//					db.persist(do2);
					
					if(trainDataList.iterator().hasNext()) {
						fromStationObject = trainDataList.get(i);
					}
					
					
					
				}
				
				
				
				
			});
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
