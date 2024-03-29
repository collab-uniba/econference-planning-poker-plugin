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
package it.uniba.di.cdg.econference.planningpoker.model.backlog;


import it.uniba.di.cdg.xcore.econference.model.IItemList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Backlog {


	private Set<IBacklogListener> listeners;
	
	private List<IUserStory> stories;

	private int current;

	
	public Backlog() {
		 this(IItemList.NO_ITEM_SELECTED);
	}
	
	public Backlog(int initialIndex) {
		 current = initialIndex;
		 listeners  = new HashSet<IBacklogListener>();
		 stories = new ArrayList<IUserStory>();
	}
	
	


	public IUserStory[] getUserStories() {
		IUserStory[] result = new IUserStory[stories.size()];
		for (int i = 0; i < stories.size(); i++) {
			result[i] = stories.get(i);
		}
		return result;
	}


	public void addUserStory(IUserStory item) {
		stories.add((IUserStory) item);
		 for (IBacklogListener l : listeners)
	            l.contentChanged( this );
	}
	

	
	public void setBacklogContent(IUserStory[] stories) {
		this.stories.clear();
		for(IUserStory story : stories)
			this.stories.add((IUserStory) story);
		for (IBacklogListener l : listeners)
            l.contentChanged( this );		
	}

	public void addListener(IBacklogListener listener) {
		listeners.add(listener);
		
	}



	public int getCurrentItemIndex() {
		return current;
	}

	public Object getUserStory(int itemIndex) {
		return stories.get(itemIndex);
	}


	public void removeUserStory(IUserStory story) {
		if(this.current==stories.indexOf(story))
			setCurrentItemIndex(IItemList.NO_ITEM_SELECTED);
		for (IBacklogListener l : listeners)
            l.itemRemoved(story);	
		stories.remove(story);
			
	}
	
	public void removeItem(int itemIndex) {	
		IUserStory item = stories.get( itemIndex );       
		removeUserStory(item);
        
	}


	public void removeListener(IBacklogListener listener) {
		listeners.remove(listener);
		
	}

	public void setCurrentItemIndex(int itemIndex) {
		if (itemIndex >= size() || itemIndex < -1)
            //throw new IllegalArgumentException( "itemIndex out of range" );
			this.current = IItemList.NO_ITEM_SELECTED;
		else
			this.current = itemIndex;
        
        for (IBacklogListener l : listeners)
            l.currentSelectionChanged( current );
		
	}

	public int size() {		
		return stories.size();
	}

	public void dispose() {
		//Perform clean-up operations
		 listeners.clear();
	}
	
	public int indexOf(IUserStory story){
		return stories.indexOf(story);
	}

	public IUserStory getStoryById(String id){
		for (IUserStory story : getUserStories()) {
			if(story.getId().equals(id))
				return story;
		}
		return null;		
	}
	
	
	public void assignEstimateToStory(String storyId, String estimate){
		IUserStory story = getStoryById(storyId);
		if(story!=null){
			story.setEstimate(estimate);
		}
		for (IBacklogListener l : listeners){
			l.contentChanged(this);
            l.estimateAssigned(storyId, estimate);
		}
	}


}
