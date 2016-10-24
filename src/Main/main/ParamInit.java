package Main.main;

import java.io.Serializable;

public class ParamInit implements Serializable {
	
	private String URL; 	      /*Database location*/
	private String dbName;        /*Database name*/
	private String collection;    /*Database collection*/
	private int port;             /*Database port*/
	private String targetSite;    /*Target site URL*/
	private String apikey;		  /*Target site api key*/
	/**
	 * 
	 */
	public ParamInit() {
	}
	
	/**
	 * @param uRL
	 * @param dbName
	 * @param collection
	 * @param port
	 * @param targetSite
	 * @param apikey
	 */
	public ParamInit(String uRL, String dbName, String collection, int port, String tarSite, String apikey) {
		URL = uRL;
		this.dbName = dbName;
		this.collection = collection;
		this.port = port;
		this.targetSite = tarSite;
		this.apikey = apikey;
	}

	/**
	 * @return the uRL
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * @param uRL the uRL to set
	 */
	public void setURL(String uRL) {
		URL = uRL;
	}

	/**
	 * @return the dbName
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * @param dbName the dbName to set
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	/**
	 * @return the collection
	 */
	public String getCollection() {
		return collection;
	}

	/**
	 * @param collection the collection to set
	 */
	public void setCollection(String collection) {
		this.collection = collection;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}
	
	/**
	 * @return the targetSite
	 */
	public String getTargetSite() {
		return targetSite;
	}

	/**
	 * @param port the port to set
	 */
	public void setTargetSite(String tarSite) {
		this.targetSite = tarSite;
	}

	/**
	 * @return the apikey
	 */
	public String getApikey() {
		return apikey;
	}

	/**
	 * @param apikey the apikey to set
	 */
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	
}
