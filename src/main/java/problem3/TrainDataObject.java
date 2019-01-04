package problem3;

import java.util.List;
import java.util.Map;

public class TrainDataObject {

	private Map<String, List<String>> data;
	
	private String trainId;
	private String station;
	private String actualDepartureTime;
	private String driverName;
	private String departureLateness;
	
	
	public TrainDataObject(String trainId, String station, String actualDepartureTime, String driverName,
			String departureLateness) {
		this.trainId = trainId;
		this.station = station;
		this.actualDepartureTime = actualDepartureTime;
		this.driverName = driverName;
		this.departureLateness = departureLateness;
	}


	
	
	
	@Override
	public String toString() {
		return "TrainDataObject [data=" + data + ", trainId=" + trainId + ", station=" + station
				+ ", actualDepartureTime=" + actualDepartureTime + ", driverName=" + driverName + ", departureLateness="
				+ departureLateness + "]";
	}





	public Map<String, List<String>> getData() {
		return data;
	}





	public void setData(Map<String, List<String>> data) {
		this.data = data;
	}





	public String getTrainId() {
		return trainId;
	}


	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}


	public String getStation() {
		return station;
	}


	public void setStation(String station) {
		this.station = station;
	}


	public String getActualDepartureTime() {
		return actualDepartureTime;
	}


	public void setActualDepartureTime(String actualDepartureTime) {
		this.actualDepartureTime = actualDepartureTime;
	}


	public String getDriverName() {
		return driverName;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	public String getDepartureLateness() {
		return departureLateness;
	}


	public void setDepartureLateness(String departureLateness) {
		this.departureLateness = departureLateness;
	}
	
	
	
	
	
}
