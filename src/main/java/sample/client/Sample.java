package sample.client;

import com.google.gwt.user.client.ui.RootPanel;
import sample.client.login.LoginUi;
import sample.client.login.ProgressBar;
import sample.client.message.LoginMessage;
import sample.client.message.Response;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
@org.jboss.errai.ioc.client.api.EntryPoint
public class Sample {

	@Inject
	private Event<LoginMessage> loginEvent;

	private LoginUi loginUi;

	@PostConstruct
	public void buildUI() {
		this.loginUi = new LoginUi(loginEvent);
		RootPanel.get("bodyContainer").add(loginUi);
	}

	public void response(@Observes Response event) {
		int progress = event.getProgress();
		final ProgressBar progressBar = loginUi.getProgressBar();
		progressBar.setVisible(true);
		progressBar.setProgress(progress);
		if (progress >= 100) {
			loginUi.getButton().setEnabled(true);
			loginUi.moveToHomepage();
		}
	}
}
