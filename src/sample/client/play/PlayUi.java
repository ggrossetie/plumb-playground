package sample.client.play;

import plumb.client.display.ui.DisplayEditView;
import sample.shared.PlayDisplay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class PlayUi extends Composite implements HasText {

	private static LoginUiBinder uiBinder = GWT
			.create(LoginUiBinder.class);

	interface LoginUiBinder extends UiBinder<Widget, PlayUi> {
	}

	public PlayUi() {
		editView = new DisplayEditView<PlayDisplay>(new PlayDisplay());
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiField(provided=true) 
	DisplayEditView<PlayDisplay> editView = null;

	@UiField
	Button button;

	public PlayUi(String firstName) {
		this();
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		PlayDisplay flush = editView.flush();
		if (editView.hasErrors()) {
			Window.alert("merci de compléter les champs manquants");
		} else {
			Window.alert(flush.toString());
		}
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

}
