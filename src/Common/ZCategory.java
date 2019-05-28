package Common;

public class ZCategory {

	private int zcatId; // Store category Id
	private String zcatName; // Store Category Name
	
	// Constructor
	public ZCategory(int zcatId, String zcatName) {
		super();
		this.zcatId = zcatId;
		this.zcatName = zcatName;
	} // end of Constructor
	
	// Setter and Getter
	public int getZcatId() {
		return zcatId;
	}

	public void setZcatId(int zcatId) {
		this.zcatId = zcatId;
	}

	public String getZcatName() {
		return zcatName;
	}

	public void setZcatName(String zcatName) {
		this.zcatName = zcatName;
	}
	

	// override toString Method
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getZcatName();
	} // end of ToString
	
}
