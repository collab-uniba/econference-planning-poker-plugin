

# How to use eConference3P #

This tutorial will show you how to use the eConference3P, according to the role you will play during a Planning Poker for user stories estimation.

## Download ##
You can get the latest build of eConference from the [Download](http://code.google.com/p/econference-planning-poker-plugin/downloads/list) page.

## The eConference3P UI ##

This perspective contains following views (as numbered in Figure 1):

<p align='center'><img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/PPPerspectivePresentazione.PNG' width='800px' /></p>

<p align='center'><b>Figure 1. The Planning Poker Plug-in</b>  </p>


<a href='Hidden comment: 
Have a look to the [PlanningPokerPerspective Planning Poker perspective page] to understand the meaning of the main views. '></a>

  1. **Presence**: here are listed all partecipants; the blue icon means session moderator; a pencil appearing near an icon means the participant is a scribe (see Decision Place view); a card appering near an icon means the participant can vote user stories (see Card Deck view); the moderator can be a scribe but never a voter.
  1. **Backlog**: here are listed the stories that have to be estimated; this view shows the description of the story and all the meta-data associate with it, such as Owner, Priority and so on; user stories can be entered using a form editor; stories can also be exported/imported to/from file or web;
  1. **Message Board**: here are stored conversation about questions asked from team members to the Product Owner, it could be useful during the estimation task;
  1. **Decision Place**: here any of the scribes can write some inportant notes she thinks will be helpful when this story is being programmed and tested.
  1. **Card Deck**: here are the cards for estimating. User should select a card during the estimation task.
  1. **Estimates**: here are listed cards selected by all estimators; estimates are visible to participants only once all votes have been collected (until then votes are private and can be changed).

The rest of this how to will further detail how each view works.

## Running the tool ##
After downloading the tool, extract it and double click on the .exe in the folder. If you already know what network to use (e.g. Skype), then launch the batch file named _skype-startup-ec3p.bat_.


## Connecting ##
Click on the Plug icon in the top-left corner of the GUI.

**Option 1.** If you are using the **Skype** network, **remember to have the Skype client installed and running before launching eConference3P.**
The first time you run eConference you will have to allow the tool to connect to attach to the Skype network through the Skype client. You will se the Skype icon glowing and a notification like the one in Figure 2a appear in the top of the client window. Press allow to let eConference3P connect.


<p align='center'><img src='http://econference4.googlecode.com/svn/wiki/img/skypeaccess.png' width='680px' /></p>
<p align='center'><b>Figure 3b. Allow eC3P to connect to Skype (first run only)</b> </p>

**Option 2.** When using **XMPP/GMail** accounts, instead, a Login Dialog is displayed (see Figure  2b) fill in only the email and password fields, as server settings are automatically entered for you. Check the checkbox and your profile will be stored and available when you reconnect.


<p align='center'><a href='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/Connessione.PNG'>http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/Connessione.PNG</a></p>
<p align='center'><b>Figure 2b. The login Dialog</b> </p>



To check whether you are connected, see if the light bulb in the bottom-right corner is enabled and move the mouse over it: the tooltip should display all the connection details.

If you don't see anyone in the roster, then it means you have no buddies. ATM, you can add contacts only when using XMPP/GMail network. This feature does not work with Skype yet (see [issue 21](http://code.google.com/p/econference4/issues/detail?id=21)).

## Organizing an eConference3P event ##
This section will show you how to create a Planning Poker meeting only if you are the **moderator** elected.

To organize the event, start the wizard as shown in Figure 3.

<p align='center'><img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/startwizard.png' /></p>
<p align='center'><b>Figure  3. Start the organization of a PP event</b></p>

### When using Skype ###
In the first page of the wizard (see Figure 4) you will have to enter the moderator id (Conference chair, in this case _cohn_), which  99.9% of the time will be your account id.

Then enter the conference name. Please note that when using Skype, _the conference name must be in this format: **conference-name$moderator-id**._ In the example, the full conference name is _my3ptest$cohn_. Feel free to specify the topic or leave this field blank.

Afterwards, choose the schedule and where to store file. Choose the location (the default is _Folder-Profile\.econference\_. You can choose the location, but you **cannot change the filename, nor the extension** (e.g. in the example, the file name must stay _my3ptest$cohn.ecx_).

<p align='center'><img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/startwizard-geninfo.png' width='660px' /></p>
<p align='center'><b>Figure  4. Wizard step 1: general info</b></p>

In the second step, you can select participants from your contact list. Both online and offile buddies are shown (see Figure 5).

<p align='center'><img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/startwizard-invite1.png' width='660px' /></p>
<p align='center'><b>Figure  5. Wizard step 2: select participant from contacts</b></p>

Only when using skype you can invite to the meeting people whose contact id is known, even though they are not in your buddy list, in this case the contact _Fabio_ (see Figure 6).

Unfortunately, when using Skype, you can't use eConference3P to send invitation emails. You will have to manually send such emails to participants, attaching the ecx file that will be stored once you click finish. However, you are still able to invite them by sending an IM.

<p align='center'><img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/startwizard-invite2.png' width='660px' /></p>
<p align='center'><b>Figure  6. Wizard step 3: add participant not in your contact list</b></p>

### When using XMPP/GMail ###
TBD

## Joining an eConference3P event ##
This section will show you how to join a Planning Poker meeting when you are either the moderator or a participant.

### The Moderator point of view ###
You are going to role-play the moderator during aPlanning Poker session. You have a couple of options to create and join the session.

**Option 1.** If you created the meeting using the Wizard, then you should see the event displayed in the Stored Events view of the tool. In the example below (see Figure 7), you see highlighted in event _my3ptest_ that we organized in the previous section. Double click on it, and a dialogue will appear.

**Option 2.** If you are the moderator, but you didn't create the event thru the wizard yourself, the you should have received the config file .ecx somehow. Therefore, click on the "Open PP configuration file" icon in the toolbar (see Figure 7), then browse and select the file. Alternatively, go to the menu "File > Planning Poker > Load configuration". Click OK and a dialogue will appear.

<p align='center'><img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/join3p-moderator.png' /></p>
<p align='center'><b>Figure  7. Joining the PP session as a moderator.</b></p>

In the dialogue, choose the name that will be displayed to other participants (e.g. _Mike Cohn_) and your role. Typically, the moderator is also the project owner, then you could write _PO_. Feel free to leave the role empty if you prefer. The checkbox tells the tool to send invitations to all the participants registered in the configuration. Be sure to leave it checked, otherwise you will have to invite each of them manually. Press ok and you will see the GUI changing and showing the new perspective for the structured conversation.

**Please, keep in mind that the room gets created when the moderator enters it for the first time. So, be sure to be online _before_ any other participant joins**.

<a href='Hidden comment: 
<p align="center">http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/LoadConf.PNG

Unknown end tag for &lt;/p&gt;


<p align="center">*Figure  3. Loading the .ecx file*

Unknown end tag for &lt;/p&gt;




<p align="center">http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/SetRole.PNG

Unknown end tag for &lt;/p&gt;


<p align="center">*Figure  4. Moderator is about to create and join the event*

Unknown end tag for &lt;/p&gt;


'></a>


### The participant point of view ###
If you are a participant, you have a couple of options to join the event.

**Option 1**. Just be sure to connect and see if you have received an online invitation as an IM: it will show up as an item in the Events pane (see Figure 8). This invitation will be displayed in this pane, and stored until you delete it. When you select an invitation, the details about the event will be show in the lower part of the Events pane. Typically, it is not a problem if the IM invitation was sent to you while you were offline. The server will store it for you and send it as soon as you get connected. Double click on it and a dialogue will appear.

<p align='center'><img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/onlineinvitation.png' width='660px' /> </p>
<p align='center'><b>Figure  8. The participant enters the PP session using the online invitation</b></p>

**Option 2.** Other then online invitations, you can enter a Planning Poker session loading the configuration file, provided that the moderator has sent the .ecx file to you. Download the attachment and store it somewhere. Then, press on the "Open PP configuration file" icon in the toolbar (see Figure 6), then browse and select the file. Alternatively, go to the menu "File > Planning Poker > Load configuration". Click OK and a dialogue will appear.


Now to join an eConference event, select your name and roloe (e.g. developer, tester, etc.) press Yes as pictured below (Figure 9), and you will see the GUI change, showing the new perspective for the Planning Poker session..


<p align='center'><a href='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/SetRoleInvitee.PNG'>http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/SetRoleInvitee.PNG</a> </p>
<p align='center'><b>Figure  9. The participant select username and role and enters the PP session.</b></p>


## How to participate in an eConference3P Event ##
This section will briefly show what the views are meant for, and what action each participant can do on them.

Once you have entered the event, you will see the online stakeholders in the Who's on view (see Figure 10 below). The blue icon indicates the Moderator. All the other participants are Voters (i.e. can assign scores to user stories).

Before the event starts, the Moderator usually grants him-/herself the Scribe right, given that he/she cannot vote. To accomplish this by right-clicking the selected stakeholder and select the 'Grant scribe right' item from the popup menu (see figure below). Note that the scribe can be changed on the fly and that there can be multiple scribes at the same time. When a user receives the scribe privilege, a pencil will appear on the his/her icon.

By default all participants (apart the moderator) have the Voter privilege. Voter privilege is represented by cards appearing on online users icons.

<b><font color='red'>Note: due to a known bug (see <a href='https://code.google.com/p/econference-planning-poker-plugin/issues/detail?id=42'>issue 42</a>), sometimes when the <i>Who's on view</i> refreshes, the icons representing the privileges may disappear.</font></b> However, this is only a graphical glitch, privileges keep working.

<p align='center'><a href='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/RevokeVoter.PNG'>http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/RevokeVoter.PNG</a></p>

<p align='center'><b>Figure  10. Who's on list, showing online stakeholders and granting special privileges</b></p>

Also note that the moderator can even revoke the rights to contribute messages <a href='Hidden comment: and to vote'></a>. As the moderator, be _**extremely careful**_ when using these features.


#### What does being a Scribe mean? ####
If you have been selected as a Scribe, then you will see the refresh icon in the Decisions Place view enabled now (Figure 11). When the discussion takes place, you will have to sum-up all the decisions that have been taken about each user story, as it is being discussed. Thus, you will edit an ongoing minute of the event. Be sure to press the refresh icon at every significant update, so that to show what you have written to the other stakeholders.


<p align='center'><img src='http://econference.googlecode.com/svn/wiki/img/decisions_place.png' />  </p>

<p align='center'><b>Figure  11. Decision places view being edited</b> </p>



### The Structured Conversation ###
As soon as you enter the event the eConference is still stopped, but you can freely chat with the participants who are currently online while you wait for the others to join. When everyone is online, the moderator decides that it is time to start the Planning Poker meeting and presses the start button in the Backlog View (Figure 12).

This view basically shows the list of the user stories that the stakeholders have to discuss about. This view is read only for all of the participants. Instead the **moderator** uses it to:

**Start / stop the meeting**

->After pressing the start button, the moderator can select the current story from the list. This means that the discussion must be about the current story only.

**Start the estimation process of a story**

->Only if the meeting has already started. Clicking on the icon in the right-top corner, a popup is displayed so that the moderator can start estimating the selected story. All the changes are propagated to all the online participants

**Add new story**

->Rightclick on the backlog list and choose from the popup menu the option to enter the new story. All the changes are propagated to all the online participants. Please note that _at least the **story id** and **story text** must be entered_ (Figure 13).


**Edit a story**

->Rightclick on the backlog list and choose from the popup menu the option to edit the selected story. All the changes are propagated to all the online participants.

**Delete a story**

->Rightclick on the backlog list and choose from the popup menu the option to delete the selected story. All the changes are propagated to all the online participants

**Import / Export the Backlog**

->Clicking on the icons in the right-top corner of the view the moderator can, respectively (i) export the backlog to a file ![http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/export.png](http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/export.png), (ii) import the backlog from a file previously exported  ![http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/importfile.png](http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/importfile.png), and (iii) import from a the issue trackers of aproject hosted on sites such as Google Code, Assembla, Github, and so on  ![http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/importweb.png](http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/importweb.png).

<p align='center'><a href='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/StoryMenu.PNG'>http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/StoryMenu.PNG</a></p>
<p align='center'><b>Figure  12. The Backlog view</b> </p>

<p align='center'><a href='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/NewStory.PNG'>http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/NewStory.PNG</a></p>
<p align='center'><b>Figure  13. Adding a new story (id and text are mandatory fields)</b> </p>

When roleplaying the moderator, the tool is assuming you enter the room first and then wait for other participants/voters to join. Adding user stories to the backlog while waiting is a real time-saver for the moderator. All the changes are automatically propagated to other participants since the moment they join the meeting.



## Starting the session & the group call ##

Once all invited participants have shown up in the presence panel and the user stories have been added to the backlog, it's time for the moderator to make the group call. **This feature is currently available only with Skype**.

The moderator should type a message and ask everyone to make a test call using the Skype client, to test that audio equipment and settings are OK.

### Enable call recording ###
In order to enable automatic Skype call recording, download and install this free tool, [MP3 Skype Recorder](http://voipcallrecording.com/MP3SkypeRecorder.zip) (Windows only).
This simple tool will automatically start when Windows starts, and likewise will automatically record your calls.

_**Just in case MP3 Skype Recorder wouldn't work, you might use [iFree Skype Recorder](http://www.ifree-recorder.com/download.htm) instead, which is absolutely equivalent to the former, and works much like described below.**_

MP3 Skype Recorder will try to connect to Skype on the first start, and will be waiting for authorization.
<p align='center'><img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/MP3SkypeRecorderWaintingAuthorization.png' /> </p>

Skype client will ask you for a permission to allow MP3 Skype Recorder to connect to Skype during the first start of the program. Click Allow Access, as shown on the picture.

<p align='center'><img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/Skype_authorization_1.png' /> </p>

Choose Allow this program to use Skype and click OK
<p align='center'><img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/Skype%20authorization%20window.gif' /> </p>

**NOTE:** If for some reason you don't see _Allow Access panel_ (as shown above), or you accidentally clicked "Deny Access", you will need to go to the _Tools->Options_ in the top Skype menu (as shown on the picture).

<p align='center'><img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/Skype_authorization_2.png' /> </p>

Click Advanced tab on the right and click Manage other program's access to Skype link in the bottom in the Skype Options window.

<p align='center'><img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/Skype_authorization_3.png' /> </p>

The new widow (Skype - Manage API access control) should open with the listing of 3rd parties programs connected or not allowed to connect to Skype. If MP3SkypeRecorder.exe is marked as Not allowed to use skype. Choose it from the list by clicking on it and click Change on the right.

Skype options window<p align='center'><img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/Skype_authorization_4.png' /> </p>

Choose Allow the program to use Skype, by clicking radio button and click OK.

<p align='center'><img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/Skype_authorization_5.png' /> </p>

When the first call starts, your personal firewall might ask you to allow opening some ports for the MP3 Skyper Recorder. Do so, it's absolutely safe.

_**For more information or other troubles see the [official manual page](http://voipcallrecording.com/skyperecorderhelp183).**_

### Starting the call ###
Now, the moderator can press the button circled in Figure 14. Then, from the popup make sure to select all the participants in the conference (make sure you don't really miss anyone!!!). A classic Skype call will, and will just need to accept it as a usual Skype call.

<p align='center'><img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/groupcall.png' /> </p>

<p align='center'><b>Figure  14. Group call during a PP session</b> </p>

To start the session, the moderator starts tehe meeting and selects the first story in the Backlog, you will see the talk view tab renamed from 'Free talk' into the id of the story. Also, all the previous messages will be hidden, just to show only the newly-entered statements related to the current story (see Figure 15).

<p align='center'><img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/StartMeeting.png' /> </p>

<p align='center'><b>Figure  15. Conversation about User Story 1</b> </p>

After discussing about the current story, it's time to estimate the story. To do so, participants that have the Voter privileges, drag and drop the selected card form deck (Figure 16). When you are not allowed to vote, the drop-zone will display the message _You can't vote_. Otherwise, you will read the message _Drag your vote here_. As a voter you have the chance to change your vote until all votes have not been collected.

<p align='center'><img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/deck.png' /></p>
<p align='center'><b>Figure  16. Selecting a card from deck</b></p>

Note that cards in the deck could be changed during the meeting. It means that moderator can remove and change the order of cards in the deck with the dialog in Figure 17. All changes are propagate to all the online participants.

<p align='center'><a href='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/DeckEditor.PNG'>http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/DeckEditor.PNG</a></p>
<p align='center'><b>Figure  17. Changing the deck</b>  </p>

As soon as a participant selects a card, his name appears in the estimate view without the value of the estimation. When all participant have selected a card, results are shown in the estimate view as showed below in Figure 18.

<p align='center'><a href='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/EstimateDifferent.PNG'>http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/EstimateDifferent.PNG</a></p>
<p align='center'><b>Figure  18. The estimate view</b></p>

The voting session is automatically closed as soon as all estimates are collected. The right part of the view is visible only for the moderator and allows him to set the final estimation value (should be done only if a consensus is reached) or repeat the estimation process (if estimates are different, i.e. no consensus).

<font color='red'><b><i>Please note that the moderator can forcefully close a voting session by entering and accepting an estimate value. This is particularly useful when a voter accidentally disconnects. Once he/she re-enters, he-she must wait the next estimate session to vote again.</i></b></font>

### Moving to the estimation of another story ###

Suppose you have reached a consensus about the current story, and the Scribe has summed up the decisions taken: It is time to move the another story. The Moderator selects it in the Backlog. All the statements about story 1 are hidden, and the talk view is again clean, ready to list only the statements related to story 2.

Yeah, but suppose that during the discussion of the story 2 new facts are came out and this facts have impact with the previous estimated story that now needs to be estimated again? Can we move back??? Sure, you can. Furthermore, as soon as you move back to a story that has been previously estimated, all the messages already sent will appear in the talk view again The dashes indicates the beginning of a new session in the conversation about the Story 1.

The discussion goes on for each single item, until all have been discussed and consensus on them reached. Then the Moderator presses the Stop button and you are back in the free talk view to say Ciao to the stakeholders.


### Save your logs ###
The event is over. As soon as you try to disconnect, close the perspective or even shut down the application you will be prompted to save both the conversation logs and the Decisions place content (see Figure  19). Be sure to say yes, as you will need them for sure.

<p align='center'><a href='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/logs.PNG'>http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/logs.PNG</a></p>
<p align='center'><b>Figure  19. Save your logs</b></p>

## Troubleshooting ##
### Missing estimate from a voter ###
Remember that an estimate session is closed when all experts have sent in their estimates.
In case of a missing estimate, from a voter whose client has crashed or connection has gone down, the moderator can force to close the estimate session by watching at available estimates and selecting a share one, that is, by entering a value and pressing the _Accept_ button in the _Estimates_ view).

### Tool begins to behave erratically? Save, clean and restore the tool state ###
In this case, the moderator should:
  1. Export the current backlog to file
  1. **DO NOT** hang up the call; Instead, use _the voice channel to coordinate next steps._
  1. Tell the participants to leave & quit the tool.
  1. Restart the tool yourself and join the event again.
  1. Tell the participants to relaunch the tool and join the event again.
  1. Import the backlog from the file that you created in the first step

Now that you have reset the tool to the previous, but clean, state you are good to go on with the meeting.