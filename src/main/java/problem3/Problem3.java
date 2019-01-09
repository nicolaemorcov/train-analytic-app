package problem3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem3 {

	public static MyDBManager db;
	public static DataService service = new DataService(db);

	public static void main(String[] args) {

		Map<String, List<TrainDataObject>> trainDataMap = new HashMap<String, List<TrainDataObject>>();

		// file location
		String fileName = "D:\\Job Interviews\\Cogitare\\DriverAndDelayDetails.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;

			// skip the header
			br.readLine();

			while ((line = br.readLine()) != null) {
				String[] trainData = line.split("\\|");
				String trainId = trainData[0];

				List<TrainDataObject> tdoList = trainDataMap.get(trainId);
				TrainDataObject tdo = new TrainDataObject(trainData[0], trainData[1], trainData[2], trainData[3],
						trainData[4]);

				if (tdoList == null) {
					tdoList = new ArrayList<>();
					tdoList.add(tdo);
					trainDataMap.put(trainId, tdoList);
				} else {
					tdoList.add(tdo);
					trainDataMap.put(trainId, tdoList);
				}

			}

			trainDataMap.forEach((trainId, trainDataList) -> {
				

				TrainDataObject fromStationObject = null;
				TrainDataObject toStationObject = null;
				
				String trainStatus = "INPROGRESS";
				
				// fromStation will always be null at this point in this forEach.
				// but in the future I can check fromStation object against the database if 
				// there is any records on this particular journey
				if (fromStationObject == null) {
					fromStationObject = trainDataList.get(0);
					
				}
				
				DriverObject driverObject = service.getDriverObjectBy(trainId, fromStationObject.getDriverName());
				if((driverObject == null) || (driverObject.getJourneyStatus().equalsIgnoreCase("COMPLETED"))) {
					driverObject = new DriverObject();
					driverObject.setDriverName(fromStationObject.getDriverName());
					driverObject.setTrainId(trainId);
					driverObject.setFromStation(fromStationObject.getStation());
					driverObject.setJourneyStatus(trainStatus);
					service.registerObject(driverObject);
					System.out.println(driverObject.toString());
				}
				

				
				for (int i = 0; i < trainDataList.size(); i++) {
					
					//skips the first index, as it is already set in method above
					if (i == 0 && trainDataList.size() > 1) {
						continue;
					}
					
					toStationObject = trainDataList.get(i);
						


					
					if (toStationObject.getDepartureLateness().equalsIgnoreCase("NA")) {
						trainStatus = "COMPLETED";
					}

					// if currentDriverName notEqual to fromStation.DriverName
					// db.persist(driverObject)
					// create new driverObject and set fromStation from fromStationObject
					String driverFromStation = fromStationObject.getDriverName();
					String driverAtNextStation = toStationObject.getDriverName();
					if(!driverFromStation.equalsIgnoreCase(driverAtNextStation)) {
						//persist current driver
						service.update(driverObject);
						// create new driver who will start at the next station
						driverObject = new DriverObject();
						driverObject.setFromStation(toStationObject.getStation());
						driverObject.setDriverName(toStationObject.getDriverName());
						driverObject.setTrainId(toStationObject.getTrainId());
					}
					
					
					driverObject.setToStation(toStationObject.getStation());
					driverObject.setJourneyStatus(trainStatus);
					System.out.println(driverObject.getTrainId() + " =====  " + driverObject.getJourneyStatus());



					if (i == 1) {

						DelayObject do1 = new DelayObject();
						do1.setTrainId(trainId);
						do1.setStation(fromStationObject.getStation());
						do1.setDepartureTimeAtStation(fromStationObject.getActualDepartureTime());
						do1.setDepartureLateness(fromStationObject.getDepartureLateness());
						System.out.println(do1.getTrainId() + " " + do1.getStation() + " "
								+ do1.getDepartureTimeAtStation() + " " + do1.getDepartureLateness().toUpperCase());
						service.registerObject(do1);
					}

					// Delay object coyuld be persisted in batches
					DelayObject do2 = new DelayObject();
					do2.setTrainId(trainId);
					do2.setStation(toStationObject.getStation());
					do2.setDepartureTimeAtStation(toStationObject.getActualDepartureTime());
					do2.setDepartureLateness(toStationObject.getDepartureLateness());
					service.registerObject(do2);

					if (trainDataList.iterator().hasNext()) {
						fromStationObject = trainDataList.get(i);
					}

				}
				service.update(driverObject);

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
