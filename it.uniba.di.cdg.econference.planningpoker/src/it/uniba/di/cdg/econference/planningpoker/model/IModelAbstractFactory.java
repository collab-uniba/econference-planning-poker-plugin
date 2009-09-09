package it.uniba.di.cdg.econference.planningpoker.model;

import it.uniba.di.cdg.econference.planningpoker.dialogs.IUserStoryDialog;
import it.uniba.di.cdg.econference.planningpoker.model.backlog.IBacklogViewUIProvider;
import it.uniba.di.cdg.econference.planningpoker.model.deck.IDeckViewUIHelper;
import it.uniba.di.cdg.econference.planningpoker.model.estimates.IEstimatesViewUIProvider;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public interface IModelAbstractFactory {

	IUserStoryDialog createUserStoryDialog(Shell shell);
	
	IBacklogViewUIProvider createBacklogViewUIProvider();
	
	/**
	 * The UI Helper takes the Composite control of the view, in order to create
	 * the graphic component n the card that are actually in the
	 * card deck
	 * @param parent 
	 * 
	 * 
	 * @return the UI Helper
	 */
	IDeckViewUIHelper createCardDeckViewUIHelper(Composite parent);
	
	
	IEstimatesViewUIProvider createEstimateViewUIHelper();
	
	
	IBacklogContextLoader createBacklogContextLoader();	
	
	/*FIXME: the factory should create the packet product too,
	/* but this plugin has to be independent of the implementation
	 * plugin, like jabber or smack?
	 */
	//public IBacklogPacket createBacklogJabberPacket();

}