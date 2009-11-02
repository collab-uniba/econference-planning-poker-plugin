package it.uniba.di.cdg.econference.planningpoker.utils;

import it.uniba.di.cdg.econference.planningpoker.model.backlog.Backlog;
import it.uniba.di.cdg.econference.planningpoker.model.backlog.DefaultUserStory;
import it.uniba.di.cdg.econference.planningpoker.model.backlog.IUserStory;
import it.uniba.di.cdg.econference.planningpoker.usimport.CreateStandardXML;

import java.io.InputStream;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;

public class XMLUtils {
	
	
	public static String ELEMENT_BACKLOG = "Backlog";
	public static String ELEMENT_STORY = "StoryCard";
	public static String ELEMENT_STORY_ID = "ID";
	public static String ELEMENT_STORY_TEXT = "Name";
	public static String ELEMENT_STORY_NOTES = "Description";
	public static String ELEMENT_STORY_ESTIMATE = "MostLikely";
	public static String ELEMENT_STORY_ITERATION_ID = "Parent";
	
	
	public static String ELEMENT_ITERATION = "Iteration";
	public static String ELEMENT_ITERATION_ID = "ID";
	public static String ELEMENT_ITERATION_NAME = "Name";
	public static String ELEMENT_ITERATION_START_DATE = "StartDate";
	
	
    /**
     * XML DOM helper.
     * 
     * @param is
     * @return the XML DOM document object
     * @throws Exception
     */
    public static Document loadDocument( InputStream is ) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse( is );
        return doc;
    }
    
    
    /**
     * Convert the Backlog object in the Agile Planner XML Standard
     * 
     * @param backlog
     * @return the serialized xml string
     * @throws TransformerException
     * @throws IllegalArgumentException 
     */
    public static String convertDefaultBacklogToStandardXML(Backlog backlog) throws IllegalArgumentException{    	
    	if(backlog!=null && backlog.size()>0){
	    	LinkedList<String> id = new LinkedList<String>();
	    	LinkedList<String> storyText = new LinkedList<String>();
	    	LinkedList<String> milestoneId = new LinkedList<String>();
	    	LinkedList<String> notes = new LinkedList<String>();
	    	LinkedList<String> estimates = new LinkedList<String>();
	    	LinkedList<String> milestoneDescriptions = new LinkedList<String>();
	    	LinkedList<String> milestoneCreationDates = new LinkedList<String>();
	    	for (IUserStory story : backlog.getUserStories()) {	  
	    		if(story instanceof DefaultUserStory){
	    			DefaultUserStory defStory = (DefaultUserStory)story;
					id.add(defStory.getId());
					storyText.add(defStory.getStoryText());
					notes.add(defStory.getNotes());
					milestoneId.add(defStory.getMilestoneId());
					estimates.add(defStory.getEstimate().toString());					
					milestoneCreationDates.add(DateUtils.formatDate(defStory.getMilestoneCreationDate()));
					milestoneDescriptions.add(defStory.getMilestoneName());
	    		}else{
	    			throw new IllegalArgumentException("Wrong User Story type: only DefaultUserStory type " +
	    					"can be printed with this transformer.");
	    		}
			}
	    	
	    	CreateStandardXML standardXML = new CreateStandardXML(storyText,notes,id,estimates,milestoneId, null, 
	    			milestoneCreationDates, milestoneDescriptions);
	    	return standardXML.getXMLString();
    	}else{
    		throw new IllegalArgumentException("Backlog is empty");
    	}
    	
//    	String xml ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
//		xml+=String.format("<%s>", ELEMENT_BACKLOG);
//		for(int i=0; i < backlog.getUserStories().length; i++){
//			DefaultUserStory story = (DefaultUserStory) backlog.getUserStories()[i];
//			xml+=String.format("<%s>", ELEMENT_STORY);			
//			xml+=String.format("<%s>%s</%s>", ELEMENT_STORY_ID, story.getId(), ELEMENT_STORY_ID );
//			xml+=String.format("<%s>%s</%s>", ELEMENT_STORY_CREATED_ON, 
//					formatDate(story.getCreatedOn()), ELEMENT_STORY_CREATED_ON );
//			xml+=String.format("<%s>%s</%s>", ELEMENT_STORY_LAST_UPDATE,
//					formatDate(story.getLastUpdate()), ELEMENT_STORY_LAST_UPDATE );
//			xml+=String.format("<%s>%s</%s>", ELEMENT_STORY_TEXT, story.getStoryText(), ELEMENT_STORY_TEXT );
//			xml+=String.format("<%s>%s</%s>", ELEMENT_STORY_NOTES, story.getNotes(), ELEMENT_STORY_NOTES);
//			xml+=String.format("<%s>%s</%s>", ELEMENT_STORY_STATUS, story.getStatus(), ELEMENT_STORY_PRIORITY);
//			xml+=String.format("<%s>%s</%s>", ELEMENT_STORY_ESTIMATE, story.getEstimate().toString(), ELEMENT_STORY_ESTIMATE);
//			xml+=String.format("</%s>", ELEMENT_STORY);
//		}
//		xml += String.format("</%s>", ELEMENT_BACKLOG);
//    	return xml;
    	
    }
   

}