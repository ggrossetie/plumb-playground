package sample.client.player;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import plumb.client.display.ui.DisplayEditView;
import sample.client.player.service.PlayerService;
import sample.client.player.service.PlayerServiceAsync;
import sample.shared.PlayerDisplay;

public class PlayerUi extends Composite implements HasText {

	private static LoginUiBinder uiBinder = GWT
			.create(LoginUiBinder.class);
	
	PlayerServiceAsync service = GWT.create(PlayerService.class);

	interface LoginUiBinder extends UiBinder<Widget, PlayerUi> {
	}

	public PlayerUi() {
		editView = new DisplayEditView<PlayerDisplay>(new PlayerDisplay());
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiField(provided=true) 
	DisplayEditView<PlayerDisplay> editView = null;

	@UiField
	Button button;

	public PlayerUi(String firstName) {
		this();
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		PlayerDisplay flush = editView.flush();
		if (editView.hasErrors()) {
			Window.alert("merci de compléter les champs manquants");
		} else {
			service.registerPlayer(flush, new AsyncCallback<PlayerDisplay>() {
				@Override
				public void onSuccess(PlayerDisplay result) {
					Window.alert("Ok");
				}
				@Override
				public void onFailure(Throwable caught) {
					GWT.log("", caught);
				}
			});
		}
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

}
