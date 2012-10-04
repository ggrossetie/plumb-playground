/**
 * 
 */
package sample.client.play;

import sample.shared.PlayDisplay;

import com.google.gwt.dom.client.Element;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author bkhadige
 * 
 */
public class PlaysUi extends Composite {

	/**
	 * An instance of the constants.
	 */
	// private final CwConstants constants;

	final FlexTable flexTable = new FlexTable();

	private void initTable(UIObject table, String... headerText) {
		com.google.gwt.user.client.Element thead = DOM.createTHead();
		DOM.insertChild(table.getElement(), thead, 0);
		int row = 0;
		com.google.gwt.user.client.Element tr = DOM.createTR();
		DOM.appendChild(thead, tr);
		com.google.gwt.user.client.Element th;
		for (int col = 0; col < 3; col++) {
			th = DOM.createTH();
			DOM.appendChild(tr, th);
			DOM.setInnerText(th, headerText[col]);
		}
	}

	/**
	 * Initialize this example.
	 */
	@Override
	public Widget asWidget() {
		// Create a Flex Table
		FlexCellFormatter cellFormatter = flexTable.getFlexCellFormatter();
		flexTable.addStyleName("cw-FlexTable");
		flexTable.setWidth("32em");
		flexTable.setCellSpacing(5);
		flexTable.setCellPadding(3);

		initTable();
		
		// Return the panel
		flexTable.ensureDebugId("cwFlexTable");
		return flexTable;
	}

	public void addPlay(PlayDisplay display) {
		int numRows = flexTable.getRowCount();
		flexTable.setHTML(numRows, 0, display.getPlayer());
		flexTable.setHTML(numRows, 1, String.valueOf(display.getHit()));
		flexTable.setHTML(
				numRows,
				2,
				(display.getPlayDate() != null) ? DateTimeFormat.getFormat(
						"dd/MM/yyyy").format(display.getPlayDate()) : "");
	}

	public void clearPlays() {
		flexTable.removeAllRows();
	}

	/**
	 * 
	 */
	private void initTable() {
		initTable(flexTable, "Joueur", "Somme", "Date du Jeu");
	}

}
