package problem3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="train_delay_details")
public class DelayObject {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="train_id")
	String trainId;
	String station;
	@Column(name="departure_time_at_station")
	String departureTimeAtStation;
	@Column(name="departure_lateness_in_seconds")
	String departureLateness;
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
	public String getDepartureTimeAtStation() {
		return departureTimeAtStation;
	}
	public void setDepartureTimeAtStation(String departureTimeAtStation) {
		this.departureTimeAtStation = departureTimeAtStation;
	}
	public String getDepartureLateness() {
		return departureLateness;
	}
	public void setDepartureLateness(String departureLateness) {
		this.departureLateness = departureLateness;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
