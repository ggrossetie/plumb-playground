package sample.server;

import sample.client.message.LoginMessage;
import sample.client.message.Response;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * A very simple CDI based service.
 */
@ApplicationScoped
public class LoginService {

	@Inject
	private Event<Response> responseEvent;

	public void handleMessage(@Observes LoginMessage event) {
		System.out.println("Received LoginMessage from client {login," + event.getLogin() + "}, {password," + event.getPassword() + "}");
		for (int i = 1; i < 11; i++) {
			try {
				Thread.sleep(Math.round(Math.random() * 2000));
			} catch (InterruptedException e) {
				throw new RuntimeException("", e);
			}
			responseEvent.fire(new Response(i * 10));
		}
	}
}
