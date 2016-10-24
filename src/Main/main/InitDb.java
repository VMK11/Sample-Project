package Main.main;

import java.util.List;

import org.apache.commons.csv.CSVRecord;

import com.chargebee.org.json.JSONException;
import com.chargebee.org.json.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class InitDb {
	private DB db = null;

	/*
	 * Connect with the database
	 * 
	 */
	public Boolean db_Connection (String loc, String dbnam, int Port)
	{
		try{
			db = (new MongoClient(loc, Port)).getDB(dbnam);
			System.out.println("Connected to " + loc + "\n" + "Port Number: " + Port + "\n");
			System.out.println("Connected to " + dbnam + " successfully");
		}catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage());
			return false;
		}
		return true;
	}

	/*
	 * Create or select collection
	 * 
	 */
	public void Collection (String colname, List<CSVRecord> data)
	{
		boolean collectionExists = db.collectionExists(colname);
		if (collectionExists == false) {
			db.createCollection(colname, null);
			System.out.println("Collection " + colname + " created successfully");
			DBCollection collection = db.getCollection(colname);
			if(colname.equals("coupons"))
			{
				import_coupon_Data(collection,data);
			}
			else
			{
				import_Subs_Data(collection,data);
			}
		}
		else{
			DBCollection collection = db.getCollection(colname);
			System.out.println("Collection " + colname + " selected successfully");

			DBCursor cursor = collection.find();
			while (cursor.hasNext()) {
				collection.remove(cursor.next());
			}

			if(colname.equals("coupons"))
			{
				import_coupon_Data(collection,data);
			}
			else
			{
				import_Subs_Data(collection,data);
			}
			//System.out.println(data);




		}
	}


	/*
	 * Import Subscription data
	 * 
	 */
	public void import_Subs_Data(DBCollection collObj, List<CSVRecord> Data)
	{

		BasicDBObjectBuilder SubsdocumentBuilder = BasicDBObjectBuilder.start()
				.add("Subscriptions_ID", Data.get(0).get("subscriptions.id"))
				.add("plan_id", Data.get(0).get("subscriptions.plan_id"))
				.add("plan_id", Data.get(0).get("subscriptions.plan_id"))
				.add("plan_quantity", Data.get(0).get("subscriptions.plan_quantity"))
				.add("status", Data.get(0).get("subscriptions.status"))
				.add("start_date", Data.get(0).get("subscriptions.start_date"))
				.add("trial_end", Data.get(0).get("subscriptions.trial_end"))
				.add("current_term_start", Data.get(0).get("subscriptions.current_term_start"))
				.add("current_term_end", Data.get(0).get("subscriptions.current_term_end"))
				.add("remaining_billing_cycles", Data.get(0).get("subscriptions.remaining_billing_cycles"))
				.add("created_at", Data.get(0).get("subscriptions.created_at"));

		BasicDBObjectBuilder Subs1documentBuilder = BasicDBObjectBuilder.start()
				.add("Subscriptions_ID", Data.get(1).get("subscriptions.id"))
				.add("plan_id", Data.get(1).get("subscriptions.plan_id"))
				.add("plan_id", Data.get(1).get("subscriptions.plan_id"))
				.add("plan_quantity", Data.get(1).get("subscriptions.plan_quantity"))
				.add("status", Data.get(1).get("subscriptions.status"))
				.add("start_date", Data.get(1).get("subscriptions.start_date"))
				.add("trial_end", Data.get(1).get("subscriptions.trial_end"))
				.add("current_term_start", Data.get(1).get("subscriptions.current_term_start"))
				.add("current_term_end", Data.get(1).get("subscriptions.current_term_end"))
				.add("remaining_billing_cycles", Data.get(1).get("subscriptions.remaining_billing_cycles"))
				.add("created_at", Data.get(1).get("subscriptions.created_at"));

		BasicDBObjectBuilder Subs2documentBuilder = BasicDBObjectBuilder.start()
				.add("Subscriptions_ID", Data.get(2).get("subscriptions.id"))
				.add("plan_id", Data.get(2).get("subscriptions.plan_id"))
				.add("plan_id", Data.get(2).get("subscriptions.plan_id"))
				.add("plan_quantity", Data.get(2).get("subscriptions.plan_quantity"))
				.add("status", Data.get(2).get("subscriptions.status"))
				.add("start_date", Data.get(2).get("subscriptions.start_date"))
				.add("trial_end", Data.get(2).get("subscriptions.trial_end"))
				.add("current_term_start", Data.get(2).get("subscriptions.current_term_start"))
				.add("current_term_end", Data.get(2).get("subscriptions.current_term_end"))
				.add("remaining_billing_cycles", Data.get(2).get("subscriptions.remaining_billing_cycles"))
				.add("created_at", Data.get(2).get("subscriptions.created_at"));

		BasicDBObjectBuilder Subs3documentBuilder = BasicDBObjectBuilder.start()
				.add("Subscriptions_ID", Data.get(3).get("subscriptions.id"))
				.add("plan_id", Data.get(3).get("subscriptions.plan_id"))
				.add("plan_id", Data.get(3).get("subscriptions.plan_id"))
				.add("plan_quantity", Data.get(3).get("subscriptions.plan_quantity"))
				.add("status", Data.get(3).get("subscriptions.status"))
				.add("start_date", Data.get(3).get("subscriptions.start_date"))
				.add("trial_end", Data.get(3).get("subscriptions.trial_end"))
				.add("current_term_start", Data.get(3).get("subscriptions.current_term_start"))
				.add("current_term_end", Data.get(3).get("subscriptions.current_term_end"))
				.add("remaining_billing_cycles", Data.get(3).get("subscriptions.remaining_billing_cycles"))
				.add("created_at", Data.get(3).get("subscriptions.created_at"));
		collObj.insert(SubsdocumentBuilder.get());
		collObj.insert(Subs1documentBuilder.get());
		collObj.insert(Subs2documentBuilder.get());
		collObj.insert(Subs3documentBuilder.get());
		DBCursor cursorDocBuilder = collObj.find();
		while (cursorDocBuilder.hasNext()) {
			System.out.println(cursorDocBuilder.next());
		}
	} 

	/*
	 * Import Coupon data
	 * 
	 */
	public void import_coupon_Data(DBCollection collObj, List<CSVRecord> Data)
	{

		BasicDBObjectBuilder Coup0documentBuilder = BasicDBObjectBuilder.start()
				.add("CouponId", Data.get(0).get("Coupon Id"))
				.add("Name", Data.get(0).get("Name"))
				.add("Invoice Name", Data.get(0).get("Invoice Name"))
				.add("Discount Type", Data.get(0).get("Discount Type"))
				.add("Discount Percentage", Data.get(0).get("Discount Percentage"))
				.add("DiscountAmount", Data.get(0).get("Discount Amount"))
				.add("DiscountQuantity", Data.get(0).get("Discount Quantity"))
				.add("DurationType", Data.get(0).get("Duration Type"))
				.add("Duration Month", Data.get(0).get("Duration Month"))
				.add("MaxRedemptions", Data.get(0).get("Max Redemptions"))
				.add("ValidTill", Data.get(0).get("Valid Till"))
				.add("Redemptions", Data.get(0).get("Redemptions"))
				.add("Status", Data.get(0).get("Status"))
				.add("ArchivedAt", Data.get(0).get("Archived At"))
				.add("CreatedAt", Data.get(0).get("Created At"))
				.add("Currency", Data.get(0).get("Currency"));


		BasicDBObjectBuilder Coup1documentBuilder = BasicDBObjectBuilder.start()
				.add("CouponId", Data.get(1).get("Coupon Id"))
				.add("Name", Data.get(1).get("Name"))
				.add("Invoice Name", Data.get(1).get("Invoice Name"))
				.add("Discount Type", Data.get(1).get("Discount Type"))
				.add("Discount Percentage", Data.get(1).get("Discount Percentage"))
				.add("DiscountAmount", Data.get(1).get("Discount Amount"))
				.add("DiscountQuantity", Data.get(1).get("Discount Quantity"))
				.add("DurationType", Data.get(1).get("Duration Type"))
				.add("Duration Month", Data.get(1).get("Duration Month"))
				.add("MaxRedemptions", Data.get(1).get("Max Redemptions"))
				.add("ValidTill", Data.get(1).get("Valid Till"))
				.add("Redemptions", Data.get(1).get("Redemptions"))
				.add("Status", Data.get(1).get("Status"))
				.add("ArchivedAt", Data.get(1).get("Archived At"))
				.add("CreatedAt", Data.get(1).get("Created At"))
				.add("Currency", Data.get(1).get("Currency"));

		BasicDBObjectBuilder Coup2documentBuilder = BasicDBObjectBuilder.start()
				.add("CouponId", Data.get(2).get("Coupon Id"))
				.add("Name", Data.get(2).get("Name"))
				.add("Invoice Name", Data.get(2).get("Invoice Name"))
				.add("Discount Type", Data.get(2).get("Discount Type"))
				.add("Discount Percentage", Data.get(2).get("Discount Percentage"))
				.add("DiscountAmount", Data.get(2).get("Discount Amount"))
				.add("DiscountQuantity", Data.get(2).get("Discount Quantity"))
				.add("DurationType", Data.get(2).get("Duration Type"))
				.add("Duration Month", Data.get(2).get("Duration Month"))
				.add("MaxRedemptions", Data.get(2).get("Max Redemptions"))
				.add("ValidTill", Data.get(2).get("Valid Till"))
				.add("Redemptions", Data.get(2).get("Redemptions"))
				.add("Status", Data.get(2).get("Status"))
				.add("ArchivedAt", Data.get(2).get("Archived At"))
				.add("CreatedAt", Data.get(2).get("Created At"))
				.add("Currency", Data.get(2).get("Currency"));


		collObj.insert(Coup0documentBuilder.get());
		collObj.insert(Coup1documentBuilder.get());
		collObj.insert(Coup2documentBuilder.get());

		DBCursor cursorDocBuilder = collObj.find();
		while (cursorDocBuilder.hasNext()) {
			System.out.println(cursorDocBuilder.next());
		}
	}
}

