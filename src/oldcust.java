package My_Project.dbms;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.hibernate.Session;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.wb.swt.SWTResourceManager;

public class oldcust extends Composite {
	private Text order_id;
	private Text name;
	private Text email;
//	private Label Display;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public oldcust(Composite parent, int style, Features s) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		final Features sys = s;
		order_id = new Text(this, SWT.BORDER);
		order_id.setBounds(178, 170, 188, 29);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblNewLabel.setBounds(10, 172, 70, 17);
		lblNewLabel.setText("Order Id");
		
		final Label Display = new Label(this, SWT.BORDER);
		Display.setFont(SWTResourceManager.getFont("Umpush", 17, SWT.BOLD));
		Display.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		Display.setAlignment(SWT.CENTER);
		Display.setBounds(159, 256, 199, 88);
		Display.setText("");
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String status = sys.getOrderStatus(Integer.parseInt(order_id.getText()));
				if(status!="PLACED")
				{		Color color = new Color(getDisplay(), 100, 255, 100);
					Display.setBackground(color);
					Display.setText(status);
			}
				else
				{	Color color = new Color(getDisplay(),100,100,0);
					Display.setBackground(color);
					Display.setText(status);
				}
			}
		});
		btnNewButton.setBounds(396, 170, 93, 29);
		btnNewButton.setText("Get Status");
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int id = sys.getCustomerID(name.getText(), email.getText());
				if(id!=-1)
				{
				;
					Display.setText(""+id);
				}
				else
				{
					Color color = new Color(getDisplay(), 255, 100, 100);
					Display.setBackground(color);
					Display.setText("WRONG INFORMATION");
					
				}
			}
		});
		btnNewButton_1.setBounds(374, 64, 93, 29);
		btnNewButton_1.setText("Get Id");
		
		name = new Text(this, SWT.BORDER);
		name.setBounds(73, 37, 214, 29);
		
		email = new Text(this, SWT.BORDER);
		email.setBounds(73, 92, 240, 29);
		
		Label lblNewLabel_2 = new Label(this, SWT.NONE);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblNewLabel_2.setBounds(10, 92, 70, 17);
		lblNewLabel_2.setText("Email");
		
		Label lblNewLabel_3 = new Label(this, SWT.NONE);
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblNewLabel_3.setBounds(10, 37, 70, 17);
		lblNewLabel_3.setText("Name");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
