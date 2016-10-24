package Main.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVRecord;

import com.chargebee.Environment;
import com.chargebee.ListResult;
import com.chargebee.filters.enums.SortOrder;
import com.chargebee.models.Card;
import com.chargebee.models.Customer;
import com.chargebee.models.Subscription;
import com.chargebee.models.Subscription.Status;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;



/**
 * Servlet implementation class MySample
 */
public class MySample extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ParamInit parInit;
	private static InitDb initdb;
	private static DataRetrieve dtr;
	private static csvParser MappedObj;
	private static Boolean succ = false;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MySample() {
		super();
		parInit = new ParamInit();
		initdb  = new InitDb();
		MappedObj = new csvParser();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * Set Initial Parameters for database
		 * 
		 */
		parInit.setURL("localhost");
		parInit.setDbName("db");
		parInit.setCollection("Subscriptions");
		parInit.setPort(27017);
		
		/*
		 * Get Initial Parameters for database
		 * 
		 */
		String dbLocation = parInit.getURL();
		String dbName = parInit.getDbName();
		String collName = parInit.getCollection();
		int port = parInit.getPort();
		
		/*
		 * Set Initial Parameters to retrieve data
		 * 
		 */
		parInit.setTargetSite("projectdemo-test");
		parInit.setApikey("test_79LRLyAZxoumniD0uejz3TmMYKByY7AV");
		
		/*
		 * Get Initial Parameters to retrieve data
		 * 
		 */
		String site = parInit.getTargetSite();
		String apikey = parInit.getApikey();
		
		/*
		 * Data retrieval
		 * 
		 */
		dtr = new DataRetrieve(site,apikey);
		//String retrStr = dtr.retrieve_Data();
		List<CSVRecord> parsedSubsData = csvParser.readCsv("C:/Users/vmk/workspace2/Sample-Project/csvFiles/Subscriptions.csv");
		
		/*
		 * Establish connection with database
		 * 
		 */
		succ = initdb.db_Connection(dbLocation, dbName, port);
		
		/*
		 * In case of connection success start the process
		 * 
		 */
		if(succ.TRUE){initdb.Collection(collName,parsedSubsData);}else{System.out.println("Failure connecting to database");}
		
		/*
		 * Define new collection to store coupons
		 * 
		 */
		parInit.setCollection("coupons");
		String collName_2 = parInit.getCollection();
		List<CSVRecord> parsedCoupData = csvParser.readCsv("C:/Users/vmk/workspace2/Sample-Project/csvFiles/Coupons.csv");

		/*
		 * Store coupon data
		 * 
		 */
		if(succ.TRUE){initdb.Collection(collName_2,parsedCoupData);}else{System.out.println("Failure connecting to database");}
		
		
		
		
		
		PrintWriter out = response.getWriter();
		
		
		
		
	
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
}

}
