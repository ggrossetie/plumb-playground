package sample.client.player.service;

import java.util.List;

import sample.shared.PlayerDisplay;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("player")
public interface PlayerService extends RemoteService {

	PlayerDisplay registerPlayer(PlayerDisplay d);

	List<PlayerDisplay> readPlayers();
}
