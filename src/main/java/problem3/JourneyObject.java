package problem3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="train_driver_details")
public class JourneyObject {

	@Column(name="train_id")
	private String trainId;
	private String origin;
	private String destination;
	private String driverName;
	private String journeyStatus;
	
	
	
	
	
	public JourneyObject(String trainId, String origin, String destination, String driverName, String journeyStatus) {
		super();
		this.trainId = trainId;
		this.origin = origin;
		this.destination = destination;
		this.driverName = driverName;
		this.journeyStatus = journeyStatus;
	}
	public String getTrainId() {
		return trainId;
	}
	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
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
