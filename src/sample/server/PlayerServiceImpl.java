package sample.server;

import java.util.ArrayList;
import java.util.List;

import sample.client.player.service.PlayerService;
import sample.shared.PlayerDisplay;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class PlayerServiceImpl extends RemoteServiceServlet implements
		PlayerService {

	@Override
	public PlayerDisplay registerPlayer(PlayerDisplay d) {
		// define entity
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity playEntity = new Entity(PlayerDisplay.class.getName());
		playEntity.setProperty("nickname", d.getNickname());
		playEntity.setProperty("firstName", d.getFirstName());
		playEntity.setProperty("lastName", d.getLastName());
		playEntity.setProperty("email", d.getEmail());
		playEntity.setProperty("city", d.getCity());
		playEntity.setProperty("cellPhone", d.getCellPhone());
		playEntity.setProperty("birthday", d.getBirthday());
		// save
		Key key = datastore.put(playEntity); // System.out.println(key.getId());
		return d;
	}
	
	@Override
	public List<PlayerDisplay> readPlayers() {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query(PlayerDisplay.class.getName());
		// query.setFilter(new Query.FilterPredicate("player", FilterOperator.EQUAL, "Marina"));
		List<Entity> asList = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(10));
		List<PlayerDisplay> displays = new ArrayList<PlayerDisplay>();
		for (Entity e : asList) {
			PlayerDisplay d = new PlayerDisplay();
//			d.setPlayDate((Date) e.getProperty("playDate"));
//			d.setHit(((Long) e.getProperty("hit")).intValue());
//			d.setPlayer((String) e.getProperty("player"));
			displays.add(d);
		}
		return displays;
	}
	
	
}
