﻿#pragma checksum "C:\Users\LAD\Documents\Visual Studio 2010\Projects\MobileConference\MobileConference\GroupDiscussionPivot.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "A14805383771AAD2C8456701BB3AEEF7"
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.269
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using Microsoft.Phone.Controls;
using System;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Automation.Peers;
using System.Windows.Automation.Provider;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Interop;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;
using System.Windows.Resources;
using System.Windows.Shapes;
using System.Windows.Threading;


namespace MobileConference {
    
    
    public partial class GroupDiscussionPivot : Microsoft.Phone.Controls.PhoneApplicationPage {
        
        internal System.Windows.Controls.Grid LayoutRoot;
        
        internal Microsoft.Phone.Controls.Pivot GroupChatPivot;
        
        internal System.Windows.Controls.TextBlock currTopic;
        
        internal System.Windows.Controls.ScrollViewer ScrollItem;
        
        internal System.Windows.Controls.TextBlock itemDisc;
        
        internal System.Windows.Controls.ListBox GroupChat;
        
        internal System.Windows.Controls.TextBox msg;
        
        internal System.Windows.Controls.TextBlock SelectItem;
        
        internal System.Windows.Controls.ListBox agendaList;
        
        internal System.Windows.Controls.TextBlock wrtItem;
        
        internal System.Windows.Controls.TextBox itemToAdd;
        
        internal System.Windows.Controls.RichTextBox decision;
        
        internal System.Windows.Documents.Run decisionText;
        
        internal System.Windows.Controls.TextBox writeDecision;
        
        internal System.Windows.Controls.Grid PresencePanel;
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Windows.Application.LoadComponent(this, new System.Uri("/MobileConference;component/GroupDiscussionPivot.xaml", System.UriKind.Relative));
            this.LayoutRoot = ((System.Windows.Controls.Grid)(this.FindName("LayoutRoot")));
            this.GroupChatPivot = ((Microsoft.Phone.Controls.Pivot)(this.FindName("GroupChatPivot")));
            this.currTopic = ((System.Windows.Controls.TextBlock)(this.FindName("currTopic")));
            this.ScrollItem = ((System.Windows.Controls.ScrollViewer)(this.FindName("ScrollItem")));
            this.itemDisc = ((System.Windows.Controls.TextBlock)(this.FindName("itemDisc")));
            this.GroupChat = ((System.Windows.Controls.ListBox)(this.FindName("GroupChat")));
            this.msg = ((System.Windows.Controls.TextBox)(this.FindName("msg")));
            this.SelectItem = ((System.Windows.Controls.TextBlock)(this.FindName("SelectItem")));
            this.agendaList = ((System.Windows.Controls.ListBox)(this.FindName("agendaList")));
            this.wrtItem = ((System.Windows.Controls.TextBlock)(this.FindName("wrtItem")));
            this.itemToAdd = ((System.Windows.Controls.TextBox)(this.FindName("itemToAdd")));
            this.decision = ((System.Windows.Controls.RichTextBox)(this.FindName("decision")));
            this.decisionText = ((System.Windows.Documents.Run)(this.FindName("decisionText")));
            this.writeDecision = ((System.Windows.Controls.TextBox)(this.FindName("writeDecision")));
            this.PresencePanel = ((System.Windows.Controls.Grid)(this.FindName("PresencePanel")));
        }
    }
}

