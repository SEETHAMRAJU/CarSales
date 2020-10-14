package My_Project.dbms;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Session;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class Menu extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Menu(Composite parent, int style,StackLayout layout,Session sessi) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		final StackLayout lay = layout;
		final Session session = sessi;
		final Composite mine = parent;
		final Features system = new Features(session);
		
		Button btnNewButton = new Button(this, SWT.BORDER | SWT.FLAT);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lay.topControl = new CustomerInput(mine,SWT.NONE,system);
				mine.layout();
			}
		});
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnNewButton.setBounds(318, 406, 127, 29);
		btnNewButton.setText("New Customer");
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lay.topControl = new DealerInput(mine,SWT.NONE,system);
				mine.layout();
				}
		});
		btnNewButton_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnNewButton_1.setBounds(38, 562, 127, 29);
		btnNewButton_1.setText("Dealer");
		
		Button btnNewButton_2 = new Button(this, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lay.topControl = new manufacturerprocedure(mine,SWT.NONE,system);
				mine.layout();

			}
		});
		btnNewButton_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnNewButton_2.setBounds(604, 562, 127, 29);
		btnNewButton_2.setText("Manufacturer");
		
		Button btnNewButton_3 = new Button(this, SWT.NONE);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lay.topControl = new oldcust(mine,SWT.NONE,system);
				mine.layout();
			}
		});
		btnNewButton_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnNewButton_3.setBounds(615, 35, 127, 29);
		btnNewButton_3.setText("Loyal Customer");
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Ubuntu", 54, SWT.NORMAL));
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblNewLabel.setBounds(149, 123, 563, 232);
		lblNewLabel.setText("     Car Sales");
		
		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Ubuntu", 55, SWT.NORMAL));
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		lblNewLabel_1.setBounds(174, 224, 495, 155);
		lblNewLabel_1.setText("Management");
		
		Button btnNewButton_4 = new Button(this, SWT.NONE);
		btnNewButton_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			lay.topControl = new Dealer_Making(mine,SWT.NONE,system);
			mine.layout();
			}
		});
		btnNewButton_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnNewButton_4.setBounds(38, 35, 111, 29);
		btnNewButton_4.setText("New Dealer");
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
