package it.uniba.di.cdg.econference.agile.planningpoker.test.ui;

import it.uniba.di.cdg.econference.planningpoker.ui.dialogs.JoinPPDialog;
import junit.framework.TestCase;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class JoinPPDialogTest extends TestCase{
	
	private JoinPPDialog ppFile;


	
	@Override
	protected void setUp() throws Exception {
		Display display = new Display();
		Shell shell = new Shell(display);
    	
		ppFile = new JoinPPDialog(shell);
	}
	
	
	public void testDialog() {			
		if(ppFile.open() == Dialog.OK){
								
		}else{
			
		}
		
	}	

}
