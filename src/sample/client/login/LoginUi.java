package sample.client.login;

import java.util.HashSet;
import java.util.Set;

import plumb.client.display.ui.CustomWidget;
import plumb.client.display.ui.DisplayEditView;
import sample.client.play.PlayUi;
import sample.client.player.PlayerUi;
import sample.shared.LoginDisplay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class LoginUi extends Composite implements HasText {

	private static LoginUiBinder uiBinder = GWT
			.create(LoginUiBinder.class);

	interface LoginUiBinder extends UiBinder<Widget, LoginUi> {
	}

	public LoginUi() {
		Set<CustomWidget> customWidgets = new HashSet<CustomWidget>();
		customWidgets.add(new CustomWidget("password", new PasswordTextBox()));
		editView = new DisplayEditView<LoginDisplay>(new LoginDisplay(), customWidgets);
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiField(provided=true) 
	DisplayEditView<LoginDisplay> editView = null;

	@UiField
	Button button;

	public LoginUi(String firstName) {
		this();
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		LoginDisplay flush = editView.flush();
		if (editView.hasErrors()) {
			Window.alert("merci de compléter les champs manquants");
		} else {
			
			MenuBar menuBar = new MenuBar();
			
			menuBar.addItem(new MenuItem("Jouer", new Command() {
				@Override
				public void execute() {
					RootPanel.get("bodyContainer").clear();
					RootPanel.get("bodyContainer").add(new PlayUi());
						
				}
			}));
			
			menuBar.addItem(new MenuItem("Nouveau Joueur", new Command() {
				@Override
				public void execute() {
					RootPanel.get("bodyContainer").clear();
					RootPanel.get("bodyContainer").add(new PlayerUi());
						
				}
			}));
			
			RootPanel.get("bodyContainer").clear();
			RootPanel.get("menuContainer").add(menuBar);
			
			
			
		}
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

}
