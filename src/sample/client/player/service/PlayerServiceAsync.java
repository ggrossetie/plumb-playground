package sample.client.player.service;

import java.util.List;

import sample.shared.PlayDisplay;
import sample.shared.PlayerDisplay;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface PlayerServiceAsync {

	void readPlayers(AsyncCallback<List<PlayerDisplay>> callback);

	void registerPlayer(PlayerDisplay d, AsyncCallback<PlayerDisplay> callback);
}
