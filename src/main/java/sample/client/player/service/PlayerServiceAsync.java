package sample.client.player.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import sample.shared.PlayerDisplay;

import java.util.List;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface PlayerServiceAsync {

	void readPlayers(AsyncCallback<List<PlayerDisplay>> callback);

	void registerPlayer(PlayerDisplay d, AsyncCallback<PlayerDisplay> callback);
}
