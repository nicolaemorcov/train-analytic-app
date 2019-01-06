package problem3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="train_driver_details")
public class DriverObject {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="train_id")
	private String trainId;
	@Column(name="from_station")
	private String fromStation;
	@Column(name="to_station")
	private String toStation;
	@Column(name="driver_name")
	private String driverName;
	@Column(name="journey_status")
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
}
