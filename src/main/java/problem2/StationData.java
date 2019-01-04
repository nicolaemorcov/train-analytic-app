package problem2;

import java.util.Map;

public class StationData {

	Map<String, Integer> stationDemand;
	Map<String, Map<String, Integer>> maximumDemand;
	private String station;
	
	
	
	public StationData(String station, Map<String, Integer> stationDemand) {
		this.stationDemand = stationDemand;
		this.station = station;
	}



	public void setPassengerDemand(String station, int demand) {
		
		
		
	}
	
	
}
