/**
 * 
 */
package Main.main;

import java.io.IOException;
import java.util.Arrays;

import com.chargebee.Environment;
import com.chargebee.ListResult;
import com.chargebee.filters.enums.SortOrder;
import com.chargebee.models.Card;
import com.chargebee.models.Customer;
import com.chargebee.models.Subscription;
import com.chargebee.models.Subscription.Status;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

/**
 * @author vmk
 *
 */
public class DataRetrieve {
	/**
	 * NEVER USED - It was supposed to be used along with the webhookeventhandler to retrieve the latest changes in the database
	 */
	public DataRetrieve(String site, String apikey) {
		Environment.configure(site,apikey);
	}

	public String retrieve_Data ()
	{
		String resString = "";
		String str = "";
		ListResult result;
		try {

			result = Subscription.list()
					//.limit(5)
					//.planId().is("cbdemo_scale")
					.status().is(Status.ACTIVE)	
					.sortByCreatedAt(SortOrder.ASC).request();	
			for(ListResult.Entry entry:result){
				Subscription subscription = entry.subscription();
				Customer customer = entry.customer();
				Card card = entry.card();
				//System.out.println(customer);

			}
			Object[] resArray = result.toArray();

			resString = Arrays.deepToString(resArray);
			str = resString.substring(1, resString.length() - 1);	
			//System.out.println(loginToken);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return str;
	}


}



