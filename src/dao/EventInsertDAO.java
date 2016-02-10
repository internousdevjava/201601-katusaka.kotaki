package dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

import dto.EventDisplayDTO;
import util.MongoDBConnector;

public class EventInsertDAO {

	public boolean Eventinsert(EventDisplayDTO dto,String id,String name,double price, double ticket){

		boolean result = false;
		MongoDBConnector con = new MongoDBConnector();
		DB db = con.getConnection();
		DBCollection coll = db.getCollection("Event");
		BasicDBObject input = new BasicDBObject();
		input.put("id", id);
		input.put("name", name);
		input.put("price", price);
		input.put("ticket", ticket);
		coll.insert(input);
		result = true;
		return result;
	}

}
