package My_Project.dbms;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.hibernate.Session;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.wb.swt.SWTResourceManager;

public class CustomerInput extends Composite {
	private Text txtName;
	private Text txtEmail;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CustomerInput(Composite parent, int style,Features sy) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		final Features sys = sy;
		setLayout(null);
		
		
		txtName = new Text(this, SWT.BORDER);
		txtName.setBounds(91, 53, 268, 29);
		
		txtEmail = new Text(this, SWT.BORDER);
		txtEmail.setBounds(91, 104, 268, 29);
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		btnNewButton.setBounds(279, 251, 106, 43);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				sys.createCustomer(txtName.getText(), txtEmail.getText());
			}
		});

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
//				System.out.println(txtName.getText());
				
			}
		});
		btnNewButton.setText("Ok");
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		btnNewButton_1.setBounds(35, 251, 128, 43);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_1.setText("Cancel");
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		lblNewLabel.setBounds(10, 53, 153, 35);
		lblNewLabel.setText("Name");
		
		Label lblEmail = new Label(this, SWT.NONE);
		lblEmail.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		lblEmail.setBounds(10, 106, 146, 43);
		lblEmail.setText("Email");
		
		Label lblCustomerInput = new Label(this, SWT.NONE);
		lblCustomerInput.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblCustomerInput.setBounds(77, 10, 192, 90);
		lblCustomerInput.setText("Customer Input");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
