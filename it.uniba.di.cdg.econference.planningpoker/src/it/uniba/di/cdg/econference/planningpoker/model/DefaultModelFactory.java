/**
 * This file is part of the eConference project and it is distributed under the 

 * terms of the MIT Open Source license.
 * 
 * The MIT License
 * Copyright (c) 2005 Collaborative Development Group - Dipartimento di Informatica, 
 *                    University of Bari, http://cdg.di.uniba.it
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this 
 * software and associated documentation files (the "Software"), to deal in the Software 
 * without restriction, including without limitation the rights to use, copy, modify, 
 * merge, publish, distribute, sublicense, and/or sell copies of the Software, and to 
 * permit persons to whom the Software is furnished to do so, subject to the following 
 * conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies 
 * or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package it.uniba.di.cdg.econference.planningpoker.model;

import it.uniba.di.cdg.econference.planningpoker.model.backlog.DefaultBacklogContextLoader;
import it.uniba.di.cdg.econference.planningpoker.model.backlog.IBacklogContextLoader;
import it.uniba.di.cdg.econference.planningpoker.model.backlog.IBacklogViewUIProvider;
import it.uniba.di.cdg.econference.planningpoker.model.backlog.IUserStoryDialog;
import it.uniba.di.cdg.econference.planningpoker.model.deck.CardDeck;
import it.uniba.di.cdg.econference.planningpoker.model.deck.IDeckViewUIHelper;
import it.uniba.di.cdg.econference.planningpoker.model.estimates.IEstimatesViewUIProvider;
import it.uniba.di.cdg.econference.planningpoker.ui.DefaultBacklogViewUIProvider;
import it.uniba.di.cdg.econference.planningpoker.ui.DefaultDeckViewUIHelper;
import it.uniba.di.cdg.econference.planningpoker.ui.DefaultEstimatesViewUIProvider;
import it.uniba.di.cdg.econference.planningpoker.ui.dialogs.DefaultUserStoryDialog;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public class DefaultModelFactory implements IModelAbstractFactory {


	@Override
	public IUserStoryDialog createUserStoryDialog(Shell shell) {
		return new DefaultUserStoryDialog(shell);
	}

	@Override
	public IBacklogViewUIProvider createBacklogViewUIProvider() {
		return new DefaultBacklogViewUIProvider();
	}
	
	@Override
	public IDeckViewUIHelper createCardDeckViewUIHelper(Composite parent, CardDeck deck) {
		return new DefaultDeckViewUIHelper(parent,deck);
	}

	@Override
	public IEstimatesViewUIProvider createEstimateViewUIProvider() {
		return new DefaultEstimatesViewUIProvider();
	}
	
	@Override
	public IBacklogContextLoader createBacklogContextLoader(){
		return new DefaultBacklogContextLoader();
	}

}
