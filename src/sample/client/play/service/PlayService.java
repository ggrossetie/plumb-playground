package sample.client.play.service;

import java.util.List;

import sample.shared.PlayDisplay;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

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
