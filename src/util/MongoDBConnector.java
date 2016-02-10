package util;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDBConnector {

	private MongoClient client = null;

	public DB getConnection() {
		DB db = null;
		try {
			client = new MongoClient("localhost", 27017);
			db = client.getDB("rakugo");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return db;
	}
	public void closeConnection() {
		client.close();
	}
}
