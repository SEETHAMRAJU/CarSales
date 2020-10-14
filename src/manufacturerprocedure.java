package My_Project.dbms;

import org.eclipse.swt.widgets.Composite;
import org.hibernate.Session;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class manufacturerprocedure extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public manufacturerprocedure(Composite parent, int style,Features sy) {
		super(parent, style);
		final Features sys = sy;

		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
					sys.produceVehicle();
			}
		});
		btnNewButton.setBounds(162, 118, 176, 60);
		btnNewButton.setText("Manufacture Vehicles");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
