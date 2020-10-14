package My_Project.dbms;

//import java.awt.Button;
import org.eclipse.swt.widgets.Button;

import java.util.Scanner;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



/**
 * S PURVAJ 
 * DBMS PROJECT 
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        
        Configuration c = new Configuration().configure().addAnnotatedClass(Dealer.class).addAnnotatedClass(Order.class).addAnnotatedClass(Customer.class).addAnnotatedClass(Vehicle.class);
        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
        SessionFactory sf = c.buildSessionFactory(sr);        
        Session session = sf.openSession();
        String inp;
        Features sys = new Features(session);
        Scanner scan = new Scanner(System.in);
        	Display display = new Display();
        	Shell shell = new Shell(display);
        	shell.setLayout(new GridLayout(1,false));
        	shell.setSize(500,500);
        	final Composite contentPanel = new Composite(shell, SWT.BORDER);
        	contentPanel.setBounds(100,100,500,200);


        	final StackLayout layout =  new StackLayout();       
        	contentPanel.setLayout(layout);

        	final Menu menu = new Menu(contentPanel,SWT.NONE,layout,session);
        	layout.topControl = menu;
        	contentPanel.layout();

        	Button home = new Button(shell,SWT.NONE);
        	home.setText("Home");
        	home.setBounds(10, 10, 80, 25);
        	home.addListener(SWT.Selection,new Listener() {
        		public void handleEvent(Event event) {
        			layout.topControl = menu;
        			contentPanel.layout();
        		}
        	
        	
        	});
        
        	shell.pack();
        	shell.open();
        	while(!shell.isDisposed()) {
        
        		if(!display.readAndDispatch()) {
        			display.sleep();
        		}
        	}
        session.close();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        
    }
}
