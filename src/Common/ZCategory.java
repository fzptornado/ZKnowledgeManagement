package Common;

import java.util.ArrayList;
import java.util.List;

public class ZCategory {

	private int catId; // Store category Id
	private String catName; // Store Category Name
	private List<ZCategory> catChild;

	// Constructor
	public ZCategory(int catId, String catName,List<ZCategory> catChild) {
		super();
		this.catId = catId;
		this.catName = catName;
		this.catChild = catChild;
	} // end of Constructor
	
	public ZCategory() {
		
		this.catChild = new ArrayList<>();
	} // end of Constructor
	
	// Setter and Getter
	public int getCatId() {
		return catId;
	}

	public void setCatId(int zcatId) {
		this.catId = zcatId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String zcatName) {
		this.catName = zcatName;
	}
	public List<ZCategory> getCatChild() {
		return catChild;
	}

	public void setCatChild(List<ZCategory> catChild) {
		this.catChild = catChild;
	}
	
	public void addCatChild(ZCategory catChild) {
		boolean hasChild = false;
		
		for (ZCategory zCategory : this.catChild) {
			if(catChild.getCatId() == zCategory.getCatId())
				return;
		}
		this.catChild.add(catChild);
	}


	// override toString Method
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getCatName();
	} // end of ToString
	
}
