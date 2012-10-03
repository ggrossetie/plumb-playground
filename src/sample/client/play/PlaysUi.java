/**
 * 
 */
package sample.client.play;

import sample.shared.PlayDisplay;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
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

	    // Add some text
	    cellFormatter.setHorizontalAlignment(
	        0, 1, HasHorizontalAlignment.ALIGN_LEFT);
	    flexTable.setHTML(0, 0, "Joueur");
	    flexTable.setHTML(0, 1, "Somme");
	    flexTable.setHTML(0, 2, "Date du jeu");
	    // cellFormatter.setColSpan(0, 0, 2);

	    // Add a button that will add more rows to the table
	    /* Button addRowButton = new Button(
	        "Add", new ClickHandler() {
	          public void onClick(ClickEvent event) {
	            addRow(flexTable);
	          }
	        });
	    addRowButton.addStyleName("sc-FixedWidthButton");

	    Button removeRowButton = new Button(
	        "Remove", new ClickHandler() {
	          public void onClick(ClickEvent event) {
	            removeRow(flexTable);
	          }
	        });
	    removeRowButton.addStyleName("sc-FixedWidthButton");
	    VerticalPanel buttonPanel = new VerticalPanel();
	    buttonPanel.setStyleName("cw-FlexTable-buttonPanel");
	    buttonPanel.add(addRowButton);
	    buttonPanel.add(removeRowButton);
	    flexTable.setWidget(0, 1, buttonPanel);
	    cellFormatter.setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_TOP);*/

	    // Add two rows to start
	    // addRow(flexTable);
	    // addRow(flexTable);

	    // Return the panel
	    flexTable.ensureDebugId("cwFlexTable");
	    return flexTable;
	  }
	  
	  public void addPlay(PlayDisplay display) {
		  int numRows = flexTable.getRowCount();
		  flexTable.setHTML(numRows, 0, display.getPlayer());
		  flexTable.setHTML(numRows, 1, String.valueOf(display.getHit()));
		  flexTable.setHTML(numRows, 2, (display.getPlayDate() != null) ? DateTimeFormat.getFormat("dd/MM/yyyy").format(display.getPlayDate()) : "");
	  }

	  /**
	   * Add a row to the flex table.
	   */
	  private void addRow(FlexTable flexTable) {
	    int numRows = flexTable.getRowCount();
	    flexTable.setWidget(numRows, 0, new Label("test"));
	    flexTable.setWidget(numRows, 1, new Label("test"));
	    flexTable.getFlexCellFormatter().setRowSpan(0, 1, numRows + 1);
	  }

	  /**
	   * Remove a row from the flex table.
	   */
	  private void removeRow(FlexTable flexTable) {
//	    int numRows = flexTable.getRowCount();
//	    if (numRows > 1) {
//	      flexTable.removeRow(numRows - 1);
//	      flexTable.getFlexCellFormatter().setRowSpan(0, 1, numRows - 1);
//	    }
	  }

}
