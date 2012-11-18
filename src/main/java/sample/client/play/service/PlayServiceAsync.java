package sample.client.play.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import sample.shared.PlayDisplay;

import java.util.List;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface PlayServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
	
	void registerPlay(PlayDisplay d, AsyncCallback<PlayDisplay> callback);

	void readPlays(AsyncCallback<List<PlayDisplay>> callback);

	void filterByPlayer(String player, AsyncCallback<List<PlayDisplay>> callback);
}
