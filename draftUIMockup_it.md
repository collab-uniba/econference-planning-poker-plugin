

# Le prospettive e le views individuate (Draft) #

Il mock-up è organizzato seguendo il paradigma a Workbench, tipico delle applicazioni sviluppate con la teconologia Eclipse RCP. La scelta è obbligata per il semplice motivo che eConference utilizza questo paradigma per le sue interfacce utente.

Uno dei vantaggi offerti dal modello Workbench è che l’organizzazione degli elementi nell’interfaccia non è statica, ma varia a seconda della modalità di utilizzo dell’applicazione. Le diverse modalità di utilizzo sono rappresentate dalle Perspective, le quali stabiliscono le Views da mostrare e la loro posizione.

Considerando lo svolgimento del Planning Poker, possiamo distinguere due attività principali che richiedono due diverse modalità di utilizzo del sistema:

  * la discussione sulla story e la stima
  * la discussione sulle stime


Nel primo caso gli sviluppatori fanno domande (principalmente al Product Owner) atte ad avere una conoscenza completa della story per poi effettuare la stima scegliendo una delle carte dal deck. L’interfaccia, quindi, dovrà mostrare:

  * le caratteristiche della User Story, ossia la descrizione con le eventuali meta-informazioni associate (titolo, priorità, autore, ecc.);
  * lo strumento per porre le domande e ricevere risposte ( nel nostro caso una finestra  multi-chat di eConference );
  * il deck delle carte per la scelta della propria stima.


Nel secondo caso la discussione verte sulle stime date da tutti i partecipanti, nella discussione parte degli sviluppatori dovrà fornire le proprie motivazioni circa la stima scelta. In questo caso l’interfaccia deve mostrare la stima fornita da ogni sviluppatore (preferibilmente presentando i valori in maniera ordinata per rendere immediata la conoscenza dei valori estremi) e lo strumento per attuare la discussione sulle stime (in questo caso dovrebbe intervenire l’ODR o comunque la multi-chat di eConference). In aggiunta, potrebbe essere utile visualizzare la story con la discussione chiarificatrice avvenuta inizialmente.

Un’altra differenziazione di modalità di utilizzo è determinata dai tipi di ruoli che l’utente può assumere nel gioco. Gli sviluppatori dovranno soltanto vedere le carte che hanno a disposizione, la Story corrente e le finestre di chat, mentre il Product Owner, dovrà determinare la chiusura della discussione sulla Story, avviare la discussione sulle stime e iniziare la discussione relativa alla Story successiva.

In questo caso, tuttavia, non occorre una suddivisione in prospettive poiché la differenza può essere realizzata con l’aggiunta di funzionalità privilegiate per il Product Owner e per il moderatore.

La prospettiva dello sviluppatore è utile per tutti i ruoli (ad eccezione del deck di carte che non serve al Product Owner), in aggiunta il moderatore avrà il permesso di scrivere in una view apposita (per prendere nota di considerazioni importanti sullo sviluppo futuro della story) e potrà avviare le discussione sulle nuove story, mentre il Product Owner potrà determinare la fine della discussione sulla story e l’inizio della discussione sulle stime una volta che avrà ricevuto i voti di tutti gli sviluppatori (eventualmente sarà l'unica persona abilitata a conoscere in tempo reale le carte scelte dagli sviluppatori).

Alla luce di queste considerazioni possono essere delineate le viste e le prospettive che faranno parte del sistema.

## La prospettiva per la stima ##
Di seguito viene mostrata la prospettiva per la discussione e la stima della story corrente.


<img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/Prospettiva_Stima.jpeg' width='700px' />

La prospettiva contiene le seguenti viste:


  1. **Participants**: contiene la lista dei contatti che partecipano al Planning Poker: i ruoli privilegiati dovranno essere opportunamente differenziati.
  1. **User Stories**: contiene la lista delle Story individuate in precedenza e che devono essere sottoposte al processo di stima: il moderatore e/o il Product Owner possono utilizzare questa view per avviare la discussione sulle diverse stories. Circa la realizzazione di questa funzionalità, si può usare il meccanismo dell’agenda di eConference: utilizzando l’agenda, il moderatore, può passare da un argomento di discussione ad un altro ed eventualmente tornare indietro. In questo caso gli argomenti possono essere rappresentati dalle User stories.
  1. **Story Properties**: qui vengono mostrate le caratteristiche della Story in oggetto, ossia la descrizione e tutte le eventuali meta-informazioni (Titolo, Autore, Priorità, ecc.)  associate.
  1. **Card Deck**: contiene le carte per attribuire la stima alla story: visibile solo per i membri che attribuiscono le stime.
  1. **Story discussion**: la view riporta la sessione di chat sostenuta per avere chiarimenti sulla User Story. Durante il processo di stima e l’eventuale discussione successiva, può essere utile ricordare i chiarimenti sulla Story per una stima più corretta.

## La prospettiva per la discussione sulle stime ##

Di seguito viene mostrata la prospettiva per la discussione sulle stime, attivata dopo che tutti gli sviluppatori avranno scelto la propria carta.
Naturalmente, nel caso in cui tutte le carte siano equivalenti (si è raggiunta l’unanimità) questa prospettiva non dovrebbe essere mostrata e si dovrebbe passare alla stima della story successiva.


<img src='http://econference-planning-poker-plugin.googlecode.com/svn/wiki/img/Prospettiva_Discussione_Stime.jpeg' width='700px' />

La prospettiva contiene le seguenti viste:
  1. **Participants**.
  1. **Story Properties**.
  1. **Story discussion**: viene riportato il contenuto della discussione sulla story avvenuta inizialmente.
  1. **Decision Place**: è la view dedicata al moderatore, nella quale egli riporta tutto ciò che ritiene importante per lo sviluppo futuro della User Story.
  1. **Estimates**: vengono mostrate, in maniera ordinata, le stime date dagli sviluppatori alla story;
  1. **Estimations Discussion**: la view che consente di visualizzare l’andamento della discussione sulle stime a seguito di carte differenti. Nel caso dell’utilizzo di una tecnica di ODR, qui dovrebbe essere mostrato l’output del sistema che utilizza tale tecnica, mentre nella sezione dedicata all’inserimento dei messaggi dovrebbe essere mostrato il [form/template](formMessaggioODR.md) per l’inserimento di un messaggio ODR strutturato.