package dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import util.MongoDBConnector;

public class EventDeleteDAO {
	public boolean EventDelete(String id){
		boolean result = false;

		MongoDBConnector con = new MongoDBConnector();
		DB db = con.getConnection();

		DBCollection coll = db.getCollection("Event");
		BasicDBObject query = new BasicDBObject("id", id);
		DBCursor cursor = coll.find(query);
		try{
			while(cursor.hasNext()){
				DBObject doc = cursor.next();
				coll.remove(doc);
				result = true;
			}

		}finally{
			cursor.close();
		}
		return result;
	}



}
