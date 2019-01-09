package problem3;

public class DataService {

	MyDBManager db;

	public DataService(MyDBManager db) {
		this.db = new MyDBManager();
	}
	
	
	public DriverObject getDriverObjectBy(String trainId, String driverName) {
		db.startTransaction();
		
		String sql = ("FROM DriverObject WHERE train_id='" + trainId + "' AND " + " driver_name='" + driverName + "'");
		DriverObject do1 = (DriverObject) db.getSingleResult(sql);
		
		db.closeTransaction();
		return do1;
	}
	
	public void registerObject(Object Object) {
		db.startTransaction();
		db.persist(Object);
		db.closeTransaction();
	}
	public void mergeObject(Object arg) {
		db.startTransaction();
		db.merge(arg);
		db.closeTransaction();
	}
	
	public void update(DriverObject driverObject) {
		db.startTransaction();
		db.saveOrUpdate(driverObject);
		db.closeTransaction();
	}
	
}
