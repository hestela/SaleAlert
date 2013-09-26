package salealert;

import java.util.Iterator;
import java.util.List;

public class ResultSearch {
	/*
	 * this class contains list of results from a search query
	 */

	private String term;
	private int currentResultCount,
				totalResultCount;
	private List<Result> results;
	
	//getter functions
	public String getTerm() {
		return term;
	}
	public int getCurrentResultCount() {
		return currentResultCount;
	}
	public int getTotalResultCount() {
		return totalResultCount;
	}
	public Iterator<Result> getIterator() {
		return results.iterator();
	}
	
	
}
