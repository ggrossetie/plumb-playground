package sample.client.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class ProgressBar extends Composite {

	private static ProgressBarBinder uiBinder = GWT
			.create(ProgressBarBinder.class);

	interface ProgressBarBinder extends UiBinder<Widget, ProgressBar> {
	}

	public ProgressBar() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	FlowPanel progressBar;

	@UiField
	FlowPanel progressBloc;

	public void setProgress(int progress) {
		progressBar.getElement().setAttribute("style", "width: " + (progress) + "%;");
	}
}
