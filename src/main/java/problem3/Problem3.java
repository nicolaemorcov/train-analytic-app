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
	
	MyDBManager db = new MyDBManager();

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
			
			
			for(Map.Entry<String, List<TrainDataObject>> entry : trainDataMap.entrySet()) {
				for(TrainDataObject i : entry.getValue()) {
					JourneyObject jo = new JourneyObject(i.getTrainId(), i.ge, destination, driverName, journeyStatus)
				}
				
				
			}
			
			
//			trainDataMap.forEach((k, v) -> JourneyObject jo = trainDataMap.get(k)
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
