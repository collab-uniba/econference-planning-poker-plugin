package it.uniba.di.cdg.econference.planningpoker.usimport.wizard;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class TracWizardFirst extends WizardPage implements MouseListener{

	public static Text projectNameText;
	String name="";
	public TracWizardFirst(){
		super("TracFirst");
		setTitle("Trac project URL");
		setDescription("Enter project URL in Trac");

	}

	public void createControl(Composite parent) {
		setPageComplete(false);

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		new Label(composite, SWT.LEFT).setText("Project URL:");
		projectNameText=new Text(composite,SWT.BORDER);
		projectNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Font f=new Font(composite.getDisplay(), "Arial", 9, SWT.ITALIC);
		projectNameText.setFont(f);
		projectNameText.setText("enter project URL...");

		projectNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				name = projectNameText.getText();
				if (name.length()==0)
					setErrorMessage("Type project URL is empty");
				else setErrorMessage(null);
				setPageComplete(name.length()>0);

			}
		});

		projectNameText.addMouseListener(this);

		setControl(composite);
	}

	public IWizardPage getNextPage() {


		return super.getNextPage();  
	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDown(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	public void mouseUp(MouseEvent e) {
		projectNameText.selectAll();		
	}

}
