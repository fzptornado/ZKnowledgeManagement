package Manager;

import java.util.ArrayList;
import java.util.List;


import Common.Commons;
import Common.ZCategory;
import txtFileManager.TFileManeger;;

public class ZCategoryManager {

	private TFileManeger fm;
	private static ZCategoryManager zcm; // one and only one instance of
											// ZCategoryManager
	// constructors

	public ZCategoryManager(TFileManeger fm) {
		super();
		this.fm = fm;
	}

	public ZCategoryManager() {
		super();
		this.fm = new TFileManeger("Category");
	}

	// Methods

	/**
	 * return instance of ZCategoryManager class. Singleton pattern
	 * 
	 * @return
	 */
	public static ZCategoryManager getZCategoryManager() {
		if (zcm == null)
			zcm = new ZCategoryManager();

		return zcm;
	}

	/**
	 * CategoryToString -- convert Category Class To string main Use = in store
	 * category Data in file
	 */
	private String categoryToString(ZCategory category) {
		String output = "";

		output += category.getCatId() + Commons.SPLITTER_LEVEL1 + category.getCatName();
		if (category.getCatChild().isEmpty() == false) {
			output += Commons.SPLITTER_LEVEL1;
		}
		
		boolean addSplitter = false;
		
		for (ZCategory catItem : category.getCatChild()) {
			if (addSplitter) {
				output += Commons.SPLITTER_LEVEL2 + category.getCatId(); // if item number > 1 => add splitter
			} // end of if
			else {
				output += category.getCatId();
				addSplitter = true;
			} // end of else
		}
		return output;
	} // end of CategoryToString
	
	/**
	 * StringToCategory -- convert string To Category Class 
	 *  main Use = in retrieve data from file
	 * category Data in file
	 */
	private ZCategory StringToCategory(String categoryData) {
		ZCategory category = new ZCategory();
		String[] tmp = categoryData.split(Commons.SPLITTER_LEVEL1);
		try{
			category.setCatId(Integer.parseInt(tmp[0]));
			category.setCatName(tmp[1]);
			
			if(tmp.length>2){ // add childs
				String[] childTmp = tmp[2].split(Commons.SPLITTER_LEVEL2);
			for (String str : childTmp) {
					category.addCatChild(this.SelectCategory(Integer.parseInt(str)));
				}
			} // end of if
		}catch(Exception ex ){
			return null;
		}
		
		return category;
	} // end of CategoryToString

/**
 * get all category
 */
	public List<ZCategory> SelectAll() {
		List<ZCategory> Categories = new ArrayList<>();
		String lines[];
		lines = fm.getArray();
		for (String string : lines) {
			Categories.add(StringToCategory(string));
		}		
		return Categories;		
	}
	
	public ZCategory SelectCategory(int id) {	
		List<String> lines = fm.getRowsStartWith(String.valueOf(id));
		try{
			return this.StringToCategory(lines.get(0));
		}catch(Exception ex){
			return null;
		}
	}

}
