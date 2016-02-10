package dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import util.MongoDBConnector;

public class EventUpdateDAO {
	public boolean EventUpdate(String id,String name,double price,double ticket){
		boolean result = false;

		MongoDBConnector con = new MongoDBConnector();
		DB db = con.getConnection();
		DBCollection coll = db.getCollection("Event");
		BasicDBObject query = new BasicDBObject("id", id);
		DBCursor cursor = coll.find(query);

		if(cursor.hasNext()){
			DBObject doc = cursor.next();
			doc.put("name", name);
			doc.put("price", price);
			doc.put("ticket", ticket);
			coll.save(doc);
			result = true;
		}

		return result;
	}

}
