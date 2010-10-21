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
package it.uniba.di.cdg.econference.planningpoker.jabber;

import static it.uniba.di.cdg.smackproviders.SmackCommons.CDG_NAMESPACE;
import it.uniba.di.cdg.jabber.IPacketExtension;

import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Packet;

/**
 * Deprecated, going to be removed from repo as soon as porting
 * from eC 3.5 to eC 4.0 is verified
 * @deprecated
 */
public class EstimateSessionStatusPacket implements IPacketExtension {

	
	public static String ELEMENT_NS = CDG_NAMESPACE;
	
	public static String ELEMENT_NAME = "estimate-session";
	public static String ELEMENT_STATUS = "status";
	public static String ELEMENT_STORY_ID = "storyId";
	public static String ELEMENT_ESTIMATE_ID = "id";
	
	
	private String storyId;
	private String id;
	private String status;
	
	  /**
     * Filter this kind of packets.
     */
    public static final PacketFilter FILTER = new PacketFilter() {
        public boolean accept( Packet packet ) {
            return packet.getExtension( ELEMENT_NAME, ELEMENT_NS ) != null;
        }
    };
    
    
	public EstimateSessionStatusPacket() {
		
	}

	public EstimateSessionStatusPacket(String storyId, String id, String status) {
		super();
		this.storyId = storyId;
		this.id = id;
		this.status = status;
	}

	public String getStoryId() {
		return storyId;
	}

	public void setStoryId(String storyId) {
		this.storyId = storyId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getElementName() {
		return ELEMENT_NAME;
	}

	@Override
	public String getNamespace() {	
		return ELEMENT_NS;
	}

	@Override
	public String toXML() {
		String xml = String.format("<%s xmlns=\"%s\">" +
				"<%s>%s</%s>" +
				"<%s>%s</%s>" +
				"<%s>%s</%s>" +
				"</%s>", ELEMENT_NAME, ELEMENT_NS, 
				ELEMENT_STATUS, status,ELEMENT_STATUS,
				ELEMENT_STORY_ID, storyId, ELEMENT_STORY_ID,
				ELEMENT_ESTIMATE_ID, id , ELEMENT_ESTIMATE_ID, 
				ELEMENT_NAME);
		//System.out.println(xml);
		return xml;
	}

	@Override
	public Object getProvider() {
		return EstimateSessionStatusPacket.class;
	}

}