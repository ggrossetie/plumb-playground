package sample.client.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import plumb.client.display.ui.CustomWidget;
import plumb.client.display.ui.DisplayEditView;
import sample.client.message.LoginMessage;
import sample.client.play.PlayUi;
import sample.client.player.PlayerUi;
import sample.shared.LoginDisplay;

import javax.enterprise.event.Event;
import java.util.HashSet;
import java.util.Set;

public class LoginUi extends Composite {

	private Event<LoginMessage> loginEvent;
	private ProgressBar progressBar;

	private static LoginUiBinder uiBinder = GWT
			.create(LoginUiBinder.class);

	interface LoginUiBinder extends UiBinder<Widget, LoginUi> {
	}

	public LoginUi(Event<LoginMessage> loginEvent) {
		this();
		this.loginEvent = loginEvent;
	}

	public LoginUi() {
		Set<CustomWidget> customWidgets = new HashSet<CustomWidget>();
		customWidgets.add(new CustomWidget("password", new PasswordTextBox()));
		editView = new DisplayEditView<LoginDisplay>(new LoginDisplay(), customWidgets);
		KeyDownHandler submitHandler = new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent keyDownEvent) {
				if (keyDownEvent.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					logIn();
				}
			}
		};
		editView.addKeyDownHandler("password", submitHandler);
		editView.addKeyDownHandler("login", submitHandler);
		initWidget(uiBinder.createAndBindUi(this));
		// Initialize the progress bar
		progressBar = new ProgressBar();
		progressBar.setVisible(false);
		progress.add(progressBar);
	}

	@UiField(provided = true)
	DisplayEditView<LoginDisplay> editView = null;

	@UiField
	Button button;

	@UiField
	FlowPanel progress;


	public void moveToHomepage() {
		MenuBar menuBar = new MenuBar();

		menuBar.addItem(new MenuItem("Play", new Command() {
			@Override
			public void execute() {
				RootPanel.get("bodyContainer").clear();
				RootPanel.get("bodyContainer").add(new PlayUi());

			}
		}));

		menuBar.addItem(new MenuItem("New player", new Command() {
			@Override
			public void execute() {
				RootPanel.get("bodyContainer").clear();
				RootPanel.get("bodyContainer").add(new PlayerUi());

			}
		}));

		RootPanel.get("bodyContainer").clear();
		RootPanel.get("menuContainer").add(menuBar);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		logIn();
	}

	private void logIn() {
		LoginDisplay flush = editView.flush();
		if (editView.hasErrors()) {
			Window.alert("merci de compléter les champs manquants");
		} else {
			logIn(flush.getLogin(), flush.getPassword());
		}
	}

	private void logIn(String login, String password) {
		button.setEnabled(false);
		loginEvent.fire(new LoginMessage(login, password));
	}

	public Button getButton() {
		return button;
	}

	public ProgressBar getProgressBar() {
		return progressBar;
	}
}
