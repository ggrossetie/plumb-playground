package sample.client.play;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import plumb.client.display.ui.DisplayEditView;
import sample.client.play.service.PlayService;
import sample.client.play.service.PlayServiceAsync;
import sample.shared.PlayDisplay;

import java.util.List;

public class PlayUi extends Composite implements HasText {

	
	PlayServiceAsync service = GWT.create(PlayService.class);
	
	private static LoginUiBinder uiBinder = GWT
			.create(LoginUiBinder.class);

	interface LoginUiBinder extends UiBinder<Widget, PlayUi> {
	}

	public PlayUi() {
		editView = new DisplayEditView<PlayDisplay>(new PlayDisplay());
		initWidget(uiBinder.createAndBindUi(this));
		playListContainer.add(playsUi.asWidget());
		fetchExistingPlays();
	}
	
	@UiField(provided=true) 
	DisplayEditView<PlayDisplay> editView = null;

	@UiField
	Button button;
	
	@UiField
	FlowPanel playListContainer;
	
	PlaysUi playsUi = new PlaysUi();
	
	@UiField TextBox playerFilter;
	
	@UiField Button buttonFilter;

	public PlayUi(String firstName) {
		this();
		button.setText(firstName);
	}
	
	private void fetchExistingPlays() {
		readPlays();
	}

	/**
	 * 
	 */
	private void readPlays() {
		service.readPlays(new AsyncCallback<List<PlayDisplay>>() {
			@Override
			public void onFailure(Throwable caught) {
				GWT.log("", caught);
			}
			@Override
			public void onSuccess(List<PlayDisplay> plays) {
				playsUi.clearPlays();
				for (PlayDisplay playDisplay : plays) {
					playsUi.addPlay(playDisplay);
				}
			}
		});
	}
	
	@UiHandler("playerFilter")
	void onClick(com.google.gwt.event.dom.client.FocusEvent e) {
		playerFilter.setText("");
	}
	
	@UiHandler("buttonFilter")
	void onClickFilter(ClickEvent e) {
		if (! "".equals(playerFilter.getText()) && ! "filtrer par joueur".equals(playerFilter.getText())) {
			filterByPlayer();
		} else {
			readPlays();
		}
	}

	/**
	 * 
	 */
	private void filterByPlayer() {
		service.filterByPlayer(playerFilter.getValue(), new AsyncCallback<List<PlayDisplay>>() {
			@Override
			public void onFailure(Throwable caught) {
			}
			@Override
			public void onSuccess(List<PlayDisplay> plays) {
				playsUi.clearPlays();
				for (PlayDisplay playDisplay : plays) {
					playsUi.addPlay(playDisplay);
				}
			}
		});
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		PlayDisplay flush = editView.flush();
		if (editView.hasErrors()) {
			Window.alert("merci de compléter les champs manquants");
		} else {
			service.registerPlay(flush, new AsyncCallback<PlayDisplay>() {
				@Override
				public void onFailure(Throwable caught) {
					Window.alert(caught.getMessage());
				}
				@Override
				public void onSuccess(PlayDisplay result) {
					playsUi.addPlay(result);
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
