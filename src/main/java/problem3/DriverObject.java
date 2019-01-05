package problem3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="train_driver_details")
public class DriverObject {

	@Column(name="train_id")
	private String trainId;
	private String fromStation;
	private String toStation;
	private String driverName;
	private String journeyStatus;
	public String getTrainId() {
		return trainId;
	}
	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}
	public String getFromStation() {
		return fromStation;
	}
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	public String getToStation() {
		return toStation;
	}
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getJourneyStatus() {
		return journeyStatus;
	}
	public void setJourneyStatus(String journeyStatus) {
		this.journeyStatus = journeyStatus;
	}
	
	
	
	
	
	
}
