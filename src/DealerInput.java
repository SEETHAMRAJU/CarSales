package My_Project.dbms;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Session;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DealerInput extends Composite {
	private Text Cust;
	private Text de;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public DealerInput(Composite parent, int style,Features sy) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		final Features sys = sy;
		
		Cust = new Text(this, SWT.BORDER);
		Cust.setBounds(148, 36, 269, 29);
		
		de = new Text(this, SWT.BORDER);
		de.setBounds(148, 84, 269, 29);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblNewLabel.setBounds(10, 36, 93, 17);
		lblNewLabel.setText("Customer Id");
		
		final Label lblNewLabel_2 = new Label(this, SWT.NONE);
		lblNewLabel_2.setAlignment(SWT.CENTER);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		lblNewLabel_2.setBounds(184, 207, 125, 48);
		lblNewLabel_2.setText("");
		
		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblNewLabel_1.setText("Dealer Id");
		lblNewLabel_1.setBounds(10, 84, 111, 17);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(Cust.getText());
				lblNewLabel_2.setText("ORDER ID: "+sys.placeOrder(Integer.parseInt(Cust.getText()),Integer.parseInt(de.getText())));
				
			}
		});
		btnNewButton.setBounds(196, 157, 93, 29);
		btnNewButton.setText("Place order");
		
		Button Contact = new Button(this, SWT.NONE);
		Contact.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				sys.contactCustomer();
				
			}
		});
		Contact.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		Contact.setBounds(42, 288, 173, 64);
		Contact.setText("Contact Customers");
		
		Button btnNewButton_2 = new Button(this, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				sys.deliverCustomer();
			}
		});
		btnNewButton_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		btnNewButton_2.setBounds(259, 288, 173, 64);
		btnNewButton_2.setText("Deliver Product");
		
		

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
