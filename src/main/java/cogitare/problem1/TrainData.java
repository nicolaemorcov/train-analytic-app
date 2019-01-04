package cogitare.problem1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainData {

	private Map<Integer,List<Integer>> data;
	
	int lowestSpeed;
	int highestEnergyConsumption;
	
	
	
	
	public TrainData() {
		this.data = new HashMap<Integer, List<Integer>>();
		this.lowestSpeed = -1;
	}

	
	public void setSpeedAndEnergy(int speed, int energyConsumption) {
		//create a new list for all energyConsumption for a particular speed
		List<Integer> energyList = new ArrayList<>();
		//add current energyConsumption to the list
		energyList.add(energyConsumption);
		
		if(lowestSpeed == -1) {
			lowestSpeed = speed;
		}
		else {
			if(speed < lowestSpeed) {
				lowestSpeed = speed;
			}
		}
		
		if(highestEnergyConsumption == -1) {
			highestEnergyConsumption = energyConsumption;
		}
		else {
			if(energyConsumption > highestEnergyConsumption) {
				highestEnergyConsumption = energyConsumption;
			}
		}
		
		
		//insert new list into the map
		data.put(speed, energyList);
	}
	
	


	
	
	public Map<Integer, List<Integer>> getData() {
		return data;
	}


	public void setData(Map<Integer, List<Integer>> data) {
		this.data = data;
	}


	public int getLowestSpeed() {
		return lowestSpeed;
	}


	public void setLowestSpeed(int lowestSpeed) {
		this.lowestSpeed = lowestSpeed;
	}


	public int getHighestEnergyConsumption() {
		return highestEnergyConsumption;
	}


	public void setHighestEnergyConsumption(int highestEnergyConsumption) {
		this.highestEnergyConsumption = highestEnergyConsumption;
	}


	@Override
	public String toString() {
		return "TrainData [data=" + data + "]";
	}
	
	
	
	
}
