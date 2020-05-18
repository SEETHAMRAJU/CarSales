package My_Project.dbms;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Dealer_Making extends Composite {
	private Text text;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Dealer_Making(Composite parent, int style,Features sy) {
		super(parent, style);
		final Features sys = sy;
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(156, 66, 172, 34);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBounds(22, 79, 98, 40);
		lblNewLabel.setText("Dealer Name");
		
		final Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblNewLabel_1.setBounds(156, 233, 166, 55);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int id = sys.createDealer(text.getText());
				lblNewLabel_1.setText("Your ID : "+id);
			
			}
		});
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		btnNewButton.setBounds(173, 145, 137, 34);
		btnNewButton.setText("Create Dealer");
		
	
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
