package sample.client.play.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import sample.shared.PlayDisplay;

import java.util.List;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("play")
public interface PlayService extends RemoteService {
	String greetServer(String name) throws IllegalArgumentException;

	PlayDisplay registerPlay(PlayDisplay d);

	List<PlayDisplay> readPlays();
	
	List<PlayDisplay> filterByPlayer(String player);
}
