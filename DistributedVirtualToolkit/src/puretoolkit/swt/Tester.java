package puretoolkit.swt;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Tester {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		
		GridLayout layout = new GridLayout(2,false);
		layout.horizontalSpacing = shell.getSize().x/layout.numColumns;
		shell.setLayout(layout);
		
		Button button = new Button(shell, SWT.PUSH);
		button.setText("1");
		
		button = new Button(shell, SWT.PUSH);
		button.setText("2");
		
		button = new Button(shell, SWT.PUSH);
		button.setText("3");
		
		button = new Button(shell, SWT.PUSH);
		button.setText("4");
		
		shell.open();
		while (!shell.isDisposed()){
			if (!display.readAndDispatch())
				display.sleep();			
		}
		display.dispose();
	}

}
