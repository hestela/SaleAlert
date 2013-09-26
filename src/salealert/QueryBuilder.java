package salealert;

/*
 * this class allows us to create the url for jason queries in any class
 */
public class QueryBuilder {
	//currently using key for MindSumo challenge
	private static String APIKey = "52ddafbe3ee659bad97fcce7c53592916a6bfd73";
	
	public String makeQueryString(QueryEnum queryType, String queryData){
		//to add other queriers for the rest of the API, this switch needs to be expanded
		switch(queryType){
		case PRODUCT:
			return "http://api.zappos.com/Product/" + queryData + "?includes=[\"styles\"]&key=" + APIKey;
		case SEARCH:
			return "http://api.zappos.com/Search?term=" + queryData + "&key=" + APIKey;
		default:
			return "ERROR: INVALID QUERY";
		}
		
	}	
}
