package sample.client.play.service;

import java.util.List;

import sample.shared.PlayDisplay;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface PlayServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
	
	void registerPlay(PlayDisplay d, AsyncCallback<PlayDisplay> callback);

	void readPlays(AsyncCallback<List<PlayDisplay>> callback);
}
