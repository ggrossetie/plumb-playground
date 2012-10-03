package sample.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sample.client.play.service.PlayService;
import sample.shared.PlayDisplay;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class PlayServiceImpl extends RemoteServiceServlet implements
		PlayService {

	public String greetServer(String input) throws IllegalArgumentException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity employee = new Entity("Employee", "asalieri");
		datastore.put(employee);
		return "";
	}

	@Override
	public PlayDisplay registerPlay(PlayDisplay d) {
		// define entity
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity playEntity = new Entity(PlayDisplay.class.getName());
		playEntity.setProperty("hit", d.getHit());
		playEntity.setProperty("player", d.getPlayer());
		playEntity.setProperty("playDate", d.getPlayDate());
		// save
		Key key = datastore.put(playEntity); // System.out.println(key.getId());
		return d;
	}
	
	@Override
	public List<PlayDisplay> readPlays() {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query(PlayDisplay.class.getName());
		// query.setFilter(new Query.FilterPredicate("player", FilterOperator.EQUAL, "Marina"));
		List<Entity> asList = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(10));
		List<PlayDisplay> displays = new ArrayList<PlayDisplay>();
		for (Entity e : asList) {
			PlayDisplay d = new PlayDisplay();
			d.setPlayDate((Date) e.getProperty("playDate"));
			d.setHit(((Long) e.getProperty("hit")).intValue());
			d.setPlayer((String) e.getProperty("player"));
			displays.add(d);
		}
		return displays;
	}
	
	
}
