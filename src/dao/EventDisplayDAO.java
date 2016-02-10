package dao;

import java.util.ArrayList;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import dto.EventDisplayDTO;
import util.MongoDBConnector;

public class EventDisplayDAO {

	private ArrayList<EventDisplayDTO> eventList = new ArrayList<EventDisplayDTO>();

	public boolean selectEvent(){
	boolean result = false;
	MongoDBConnector con = new MongoDBConnector();
	DB db = con.getConnection();
	DBCollection coll = db.getCollection("Event");
	DBCursor cursor = coll.find();

	try{
		while(cursor.hasNext()) {

			EventDisplayDTO dto = new EventDisplayDTO();
			DBObject dbs = cursor.next();


			dto.setId((String)dbs.get("id"));
			dto.setName((String)dbs.get("name"));
			dto.setPrice((double)dbs.get("price"));
			dto.setTicket((double)dbs.get("ticket"));
			eventList.add(dto);
			result = true;
		}
	}finally {
		cursor.close();
	}
	System.out.println(result);
	return result;
	}
	public ArrayList<EventDisplayDTO> getEventList(){
		return eventList;
	}
}
