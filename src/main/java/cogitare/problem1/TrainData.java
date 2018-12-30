package cogitare.problem1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainData {

	private String name;
	private int speed;
	private int energyConsumption;
	
	private Map<Integer,List<Integer>> data;
	
	
	
	public TrainData(String name, int speed, int energyConsumption) {
		this.name = name;
		this.speed = speed;
		this.energyConsumption = energyConsumption;
		this.data = new HashMap<Integer, List<Integer>>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getEnergyConsumption() {
		return energyConsumption;
	}

	public void setEnergyConsumption(int energyConsumption) {
		this.energyConsumption = energyConsumption;
	}
	
	
	
}
