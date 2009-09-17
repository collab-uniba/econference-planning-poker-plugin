package it.uniba.di.cdg.econference.planningpoker.dialogs;

import it.uniba.di.cdg.econference.planningpoker.PlanningPokerPlugin;
import it.uniba.di.cdg.econference.planningpoker.model.deck.CardDeck;
import it.uniba.di.cdg.econference.planningpoker.model.deck.DefaultPokerCard;
import it.uniba.di.cdg.econference.planningpoker.model.deck.IPokerCard;
import it.uniba.di.cdg.xcore.aspects.SwtAsyncExec;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class DefaultDeckEditorDialog extends TitleAreaDialog implements IDeckEditorDialog {

	private CardDeck deck;
	
	private TableViewer actualCardsViewer;
	
	private TableViewer availableCardsViewer;
	
	private ITableLabelProvider labelProvider = new ITableLabelProvider(){

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			DefaultPokerCard card = (DefaultPokerCard)element;
			String label ="";
			switch(columnIndex){
			case 0: 
				label = card.getStringValue();
			break;
			}
			return label;
		}

		@Override
		public void addListener(ILabelProviderListener listener) {}

		@Override
		public void dispose() {}

		@Override
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub
			
		}
		
	};

	
	private IStructuredContentProvider contentProvider = new IStructuredContentProvider(){

		@Override
		public Object[] getElements(Object inputElement) {
			return (Object[]) inputElement;
		}

		@Override
		public void dispose() {}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput,
				Object newInput) {}
		
	};
	
	
	
	
	public DefaultDeckEditorDialog(Shell parentShell, CardDeck deck) {
		super(parentShell);	
		this.deck = deck;		
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		newShell.setText("Default Deck Editor");
		super.configureShell(newShell);
	}
	
	
	private void fillLists(){
		actualCardsViewer.setInput(deck.getCards());
		availableCardsViewer.setInput(deck.getHiddenCards());
	}
	
	@Override
	public CardDeck getFinalDeck() {
		return deck;
	}

	@Override
	public void setCardDeck(CardDeck deck) {
		this.deck = deck;	
		fillLists();
	}

	@Override
	public int show() {
		return this.open();
	}
	
	
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Change your deck configuration");		
		
		Composite root = parent;
		root.setLayout(new GridLayout(3,false));
		
		GridData gd = new GridData();
		
		//If you want add new card, uncomment following lines
//		gd.horizontalSpan = 3;
//		
//		Button newCard = new Button(root, SWT.PUSH);
//		newCard.setText("Add new Card");
//		newCard.setLayoutData(gd);
//		
//		gd = new GridData();
		gd.horizontalAlignment = SWT.CENTER;
		
		Label availableLabel = new Label(root, SWT.NONE);
		availableLabel.setText("Available Cards");
		availableLabel.setLayoutData(gd);
		
		gd = new GridData();
		gd.horizontalSpan = 2;
		gd.horizontalAlignment = SWT.CENTER;
		
		Label actualLabel = new Label(root, SWT.NONE);
		actualLabel.setText("Selected Cards");
		actualLabel.setLayoutData(gd);
				
		gd = new GridData();
		
		gd.verticalSpan = 4;
		gd.widthHint = 150;
		gd.heightHint = 120;
		
		availableCardsViewer = new TableViewer(root, SWT.FULL_SELECTION | SWT.BORDER | SWT.H_SCROLL  | SWT.V_SCROLL);	
		availableCardsViewer.getTable().setLayoutData(gd);
		availableCardsViewer.setContentProvider(contentProvider);
		availableCardsViewer.setLabelProvider(labelProvider);
		
		gd = new GridData();	
		gd.widthHint = 30;
		gd.verticalAlignment = SWT.TOP;
		
		Button removeCard = new Button(root, SWT.PUSH);
		removeCard.setText("<<");
		removeCard.setLayoutData(gd);
		removeCard.addSelectionListener(new SelectionAdapter(){
	    	@Override
	    	public void widgetSelected(SelectionEvent e) {
	    		removeSelectedCard();
	    	}
		});

		gd = new GridData();
		gd.verticalSpan = 4;
		gd.widthHint = 150;
		gd.heightHint = 120;
		
		actualCardsViewer = new TableViewer(root, SWT.FULL_SELECTION | SWT.BORDER | SWT.H_SCROLL  | SWT.V_SCROLL);	
		actualCardsViewer.getTable().setLayoutData(gd);
		actualCardsViewer.setContentProvider(contentProvider);
		actualCardsViewer.setLabelProvider(labelProvider);
		
		gd = new GridData();
		gd.widthHint = 30;
		gd.verticalAlignment = SWT.CENTER;
		
		Button upButton = new Button(root, SWT.PUSH);
		ImageDescriptor upImage = PlanningPokerPlugin.imageDescriptorFromPlugin(
				PlanningPokerPlugin.ID, "icons/deck/up16x16.png" );
		if(upImage!=null){
			upButton.setImage(upImage.createImage());
		}else{
			upButton.setText("Up");
		}
		upButton.setLayoutData(gd);
		upButton.addSelectionListener(new SelectionAdapter(){
        	@Override
        	public void widgetSelected(SelectionEvent e) {
        		moveCardUp();
        	}
		});
		
		gd = new GridData();
		gd.widthHint = 30;
		gd.verticalAlignment = SWT.CENTER;

		Button downButton = new Button(root, SWT.PUSH);
		ImageDescriptor downImage = PlanningPokerPlugin.imageDescriptorFromPlugin(
				PlanningPokerPlugin.ID, "icons/deck/down16x16.png" );
		if(downImage!=null){
			downButton.setImage(downImage.createImage());
		}else{
			downButton.setText("Down");
		}
		downButton.setLayoutData(gd);
		downButton.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				moveCardDown();
			}
		});
		
		gd = new GridData();
		gd.widthHint = 30;
		gd.verticalAlignment = SWT.BOTTOM;
		
		Button addCard = new Button(root, SWT.PUSH);
		addCard.setText(">>");
		addCard.setLayoutData(gd);
		addCard.addSelectionListener(new SelectionAdapter(){
        	@Override
        	public void widgetSelected(SelectionEvent e) {
        		addSelectedCard();
        	}
		});
		
			
		
		fillLists();
		
		
		return root;
	}

	protected void moveCardDown() {
		IPokerCard card = getSelectedCard(actualCardsViewer);
		if(card!=null){
			int index = indexOf(card);
			if(index!=-1 && index!=deck.size()-1){
				deck.removeCard(index);	
				deck.addCard(card, ++index);
			}
			fillLists();
		}			
	}

	protected void moveCardUp() {
		IPokerCard card = getSelectedCard(actualCardsViewer);
		if(card!=null){
			int index = indexOf(card);
			if(index!=-1 && index!=0){
				deck.removeCard(index);	
				deck.addCard(card, --index);
			}
			fillLists();
		}		
	}	

	private int indexOf(IPokerCard card) {
		int index  = -1;
		for (int i = 0; i < deck.getCards().length; i++) {
			IPokerCard currentCard = deck.getCard(i);
			if(currentCard.equals(card)){
				index = i;
			}
		}
		return index;
	}

	@SwtAsyncExec
	private void addSelectedCard() {
		IPokerCard card = getSelectedCard(availableCardsViewer);
		if(card!=null){
			deck.addCard(card);
			deck.removeHiddenCard(card);			
			fillLists();
		}
		
	}

	@SwtAsyncExec
	private void removeSelectedCard() {
		IPokerCard card = getSelectedCard(actualCardsViewer);
		if(card!=null){
			deck.removeCard(card);
			deck.addHiddenCard(card);	
			fillLists();
		}
	}
	
	
	private IPokerCard getSelectedCard(TableViewer viewer){
		ISelection selection = viewer.getSelection();
		if(selection!=null && selection instanceof IStructuredSelection){
			IStructuredSelection sel = (IStructuredSelection)selection;
			return (IPokerCard) sel.getFirstElement();
		}else{
			return null;
		}
	}

}
