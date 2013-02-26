<h1 class="c2 c11">
  <span class="c3">UniversitÃ  degli studi di Perugia</span><img height="424" src="images/image01.jpg" width="427" />
</h1>

<h1 class="c2 c11">
  <span class="c3">FACOLTAâ€™ DI SCIENZE MM.FF.NN.</span>
</h1>

<h1 class="c2 c11">
  <span class="c3">LAUREA TRIENNALE IN INFORMATICA</span>
</h1>

<h1 class="c2 c11">
  <span class="c3">a.a. 2012/2013</span>
</h1>

<p class="c2">
  <span class="c0 c18">Progetto di "Sistemi Aperti e Distribuiti" - WebService per un Social Network<br />Professore: Sergio Tasso</span>
</p>

<p class="c2">
  <span class="c18 c0">Studenti: Andrea Forgione e Robert Parcus</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c4">
  <span class="c0"></span>
</p>

<p class="c2">
  <span class="c0">Index:</span>
</p>

<ol class="c22" start="1">
  <li class="c9 c2 c6">
    <span class="c0">Analisi Dei Requisiti Â Â Â Â Â Â Â Â Â Â Â Â Â Â Â Â </span>
  </li>
  <li class="c9 c2 c6">
    <span class="c0">Analisi Del Progetto</span>
  </li>
  <li class="c9 c2 c6">
    <span class="c0">Il Server Apache Â Â Â Â Â Â Â Â Â Â Â Â Â Â Â Â </span>
  </li>
  <li class="c9 c2 c6">
    <span class="c0">Il Container Tomcat Â Â Â Â Â Â Â Â Â Â Â Â Â Â Â Â </span>
  </li>
  <li class="c9 c2 c6">
    <span class="c0">Il Database MySql Â Â Â Â Â Â Â Â Â Â Â Â Â Â Â Â </span>
  </li>
  <li class="c9 c2 c6">
    <span class="c0">Il Client Java Â Â Â Â Â Â Â Â Â Â Â Â Â Â Â Â </span>
  </li>
  <li class="c9 c2 c6">
    <span class="c0">Il Server Java Â Â Â Â Â Â Â Â Â Â Â Â Â Â Â Â </span>
  </li>
  <li class="c2 c6 c9">
    <span class="c0">Visualizzazione Dello Scambio Dei Messaggi SOAP Â Â Â Â Â Â Â Â </span>
  </li>
  <li class="c9 c2 c6">
    <span class="c0">WSDL</span>
  </li>
</ol>

<p class="c2 c4">
  <span class="c5 c0"></span>
</p>

<p class="c2 c4">
  <span class="c5 c0"></span>
</p>

<p class="c2 title">
  <a name="h.wjg5on9x8xea"></a><span>Struttura del progetto:</span>
</p>

<p class="c2">
  <span>Il progetto si divide in due parti essenziali: AsocialService.java che Ã¨ il webserver vero e proprio ed il sito A-Social che utilizza php e phpsoap sul lato server per simulare un semplice social network che utilizza per le sue funzioni primarie i servizi messi a disposizione dallo webservice.</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span>Il server Java si occupa del popolamento del database di A-Social, di tutte le interrogazioni verso di esso, delle operazioni di aggiornamento durante lâ€™interazione degli utenti con il sito.</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span>I risultati di queste operazioni sul database vengono inviati poi al server php che tramite soapPHP provvederÃ  ad interpretarli ed inviarli al client Â che tramite il browser cercherÃ  di visualizzare le pagine del sito.</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span>Oltre alle funzioni di gestione del database abbiamo creato una serie di funzioni particolari che potrebbero essere utili ad un vero social network.</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span>Per esempio tutti i commenti e post immessi nella base di dati vengono sottoposti ad una operazione di parsing che provvede a circondare gli indirizzi internet con il tag <a></a>, rendendoli link veri e propri. La stessa funzione che si occupa del parsing dei link ha una funzionalitÃ  specifica per tutti i link di youtube, e crea automaticamente lâ€™i-frame del video allâ€™interno del post o commento dellâ€™utente. </span>
</p>

<p class="c2">
  <span>Unâ€™altra funziona si occupa invece di ridimensionare le immagini caricare dagli utenti. Questa funzionalitÃ  Ã¨ molto utile ai siti che danno la possibilitÃ  agli utenti di caricare file immagine in qualunque formato ma hanno la necessitÃ  di utilizzare dimensioni standard per funzionare al meglio.</span>
</p>

<p class="c2 title">
  <a name="h.qk6brawsz10v"></a><span>Tecnologie utilizzate:</span>
</p>

<p class="c2 c4">
  <span class="c5 c0"></span>
</p>

<p class="c2 c4">
  <span class="c5 c0"></span>
</p>

<p class="c2 c11">
  <img height="48" src="images/image06.png" width="160" /><span class="c16">Apache HTTP Server</span>
</p>

<p class="c2 c4">
  <span class="c16"></span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span>Lâ€™Apache HTTP Server, comunemente conosciuto come Apache Ã¨ un web server che ha giocato un ruolo di primaria importanza nella crescita iniziale dello World Wide Web. Nel 2009 Ã¨ diventato il primo web server a superare la soglia dei 100 milioni di serviti. Apache Ã¨ stata la prima alternativa accettabile Â allâ€™Oracle iPlanet Web Server di Netscape Comunications Corporation e da allora Ã¨ cresciuto al punto tale di aver superato tutti gli altri webservers in termini di funzionalitÃ  e performance.</span>
</p>

<p class="c2">
  <span>Apache Ã¨ sviluppato e mantenuto da una comunitÃ  open source sotto lâ€™egida della Apache Software Foundation. </span>
</p>

<p class="c2">
  <span>Fin dal 1996 Apache Ã¨ il piÃ¹ popolare server HTTP in uso. Al Dicembre 2012 si stima che Apache serva il 63.7% di tutti i siti web attivi nella rete.</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c11">
  <img height="133" src="images/image10.png" width="200" /><span class="c16">Apache Tomcat</span>
</p>

<p class="c2 c4">
  <span class="c14"></span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span>Apache Tomcat, detto anche semplicemente Tomcat, Ã¨ un webservice opensource e un servlet container sviluppato dalla Apache Software Foundation. Tomcat implementa le specifiche create dalla Sun Microsystems per quanto riguarda il Java Servlet e le JavaServer Pages e provvede un ambiente in â€œpuro Javaâ€ per per far girare il codice Java in uno web server HTTP.</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span>Apache Tomcat Â offre anche strumenti di configurazione e gestione e puÃ² anche essere configurato modificando i file XML di configurazione.</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c11">
  <img height="183" src="images/image03.png" width="100" /><span class="c16">Il Linguaggio Java</span>
</p>

<p class="c2 c4">
  <span class="c14"></span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span>Java Ã¨ un linguaggio di programmazione general-purpose, concorrente, basato sulle classi, object-oriented che Ã¨ stato sviluppato specificamente per avere il minor numero di dipendenze di implementazione possibile. Eâ€™ stato creato per permettere agli sviluppatori di software di scrivere una sola volta, e far girare dovunque le loro applicazioni (WORA), nel senso che il codice sviluppato in una piattaforma non ha bisogno di essere ricompilato per girare su una piattoforma diferente </span>
</p>

<p class="c2">
  <span>Il codice Java Ã¨ tipicamente compilato in bytecode, il quale puÃ² girare in qualunque Java virtual machine (JVM), indifferentemente dalle architetture dei computer che lo girano.</span>
</p>

<p class="c2">
  <span>Java per lâ€™appunto Ã¨ uno dei piÃ¹ popolari linguaggi di programmazione in uso al giorno dâ€™oggi, principalmente per quanto riguarda le applicazione client-server.</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c11">
  <img height="93" src="images/image07.png" width="180" /><span class="c16">MySQL DataBase</span>
</p>

<p class="c2 c4">
  <span class="c14"></span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span>MySQL Ã¨ il piÃ¹ famoso Ã¨ piÃ¹ usato Relational Database Management System(RDBMS) open source al mondo. Eâ€™ disponibile sotto licenza GNU Genaral Public License, ma anche sotto vari accordi proprietari. </span>
</p>

<p class="c2">
  <span>Dopo essere appartenuta ad una compagnia svedese, ora MySQL Ã¨ proprietÃ  della Oracle Corporation.</span>
</p>

<p class="c2">
  <span>MySQL Ã¨ una scelta molto popolare come database da usare in applicazioni web ed Ã¨ il componente centrale del famosissimo LAMP. <br />Applicazioni che fanno uso di MySQL sono tra le tante: Joomla, WordPress, phpBB, MyBB, Drupal, etc. MySQL Ã¨ utilizzato anche in molti prodotti web di altissimo livello come Wikipedia, Google (non per le ricerche), Facebook, Twitter, Flickr, Nokia e Youtube.</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c11">
  <img height="117" src="images/image05.png" width="220" /><span class="c21">PHP:Hypertext Preprocessor</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span>Php Ã¨ un linguaggio di scripting server side e open source creato per applicazioni web ed allo scopo di produrre pagine web dinamiche. Il codice viene interpretato da uno Web Server dotato di un modulo PHP processor il quale genera la pagina web desiderata. Nel tempo il PHP si Ã¨ anche evoluto al punto di includere una interfaccia a linea di comando e di poter essere usato in alcune applicazioni grafiche standalone.</span>
</p>

<p class="c2">
  <span>Esempi di software che utilizzano PHP sono: Drupal, Joomla, MediaWiki, phpBB, WordPress, etc.</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c11">
  <span class="c10">Simple Object Access Protocol (SOAP)</span><img height="207" src="images/image13.png" width="185" />
</p>

<p class="c2 c4 c11">
  <span class="c10"></span>
</p>

<p class="c2 c4 c11">
  <span class="c10"></span>
</p>

<p class="c2 c4">
  <span class="c14"></span>
</p>

<p class="c2">
  <span>SOAP Ã¨ un protocollo utilizzato nello scambio di informazioni strutturate nella implementazione degli Web Services nelle reti di computer. SOAP si basa su XML per il formato dei suoi messaggi e di solito si appoggia ad altri protocolli del livello delle applicazioni come lâ€™HTTP o lâ€™SMTP per la negoziazione e lo scambio dei messaggi.</span>
</p>

<p class="c2">
  <span>Come suggerito dalla figura in alto, questo protocollo consiste in tre diverse parti: Un involucro, il quale definisce che cosa Ã¨ contenuto nel messaggio e come lo si deve interpretare, un insieme di regole di codifica per esprimere istanse di tipi di dato specifici per lâ€™applicazione ed una parte atta a rappresentare le chiamate e le risposte alle funzioni.</span>
</p>

<p class="c2">
  <span>SOAP Ã¨ il successore di XML-RPC.</span>
</p>

<p class="c2">
  <img height="225" src="images/image04.jpg" width="225" /><img height="145" src="images/image08.jpg" width="348" />
</p>

<p class="c2 c11">
  <span class="c10">Github.com ed il software Git</span>
</p>

<p class="c2">
  <span>Il software Git Ã¨ un sistema distribuito di revision control e di source code management che mette una certa enfasi sulla velocitÃ  di esecuzione. Git Ã¨ stato sviluppato da Linus Torvalds per lo sviluppo del kernel di Linux ma Ã¨ stato in seguito adottato da molti altri progetti. In git, ogni working directory Ã¨ una vera e propria repository con lo storico completo delle azioni e piene capacitÃ  di revisioning, senza dipendere da accessi alla rete o da un server centrale.</span>
</p>

<p class="c2">
  <span>Git Ã¨ un software gratuito distribuito sotto la licenza GNU General Public License version 2.</span>
</p>

<p class="c2 c4">
  <span class="c15 c14 c0"><a class="c13" href="http://en.wikipedia.org/wiki/GitHub#cite_note-sanfrancisco-4"></a></span>
</p>

<p class="c2">
  <span>GitHub Ã¨ un servizio di hosting basato sullo web per progetti di software development che utilizzino il Git Revision control system. GitHub offre sia servizi a pagamento per le repository private sia un servizio free per i progetti opensource. Al Maggio del 2011, github.com era il piÃ¹ popolare sito per code repositories.</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c11">
  <img height="179" src="images/image12.jpg" width="179" /><span class="c16">NetBeans</span>
</p>

<p class="c2">
  <span>Netbeans Ã¨ una piattaforma di sviluppo integrata (IDE) creata prevalentemente per progetti in Java, anche se puÃ² lavorare con molti altri linguaggi come PHP, C/C++ o HTML5. <br />NetBeans Ã¨ scritto in JAva e puÃ² girare sotto Windows, OS X, Linux, Solaris ed altre piattaforme compatibili con JVM.</span>
</p>

<p class="c2">
  <span>Nel nostro progetto Ã¨ stata cruciale la capacitÃ  di netbeans di generare progetti come webservices e di interfacciarsi elegantemente con Apache Tomcat ed il protocollo SOAP, gestendo anche la generazione del documento WSDL.</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c11 title">
  <a name="h.647wdtfrxyz4"></a><span>Come si crea un Web Service su Netbeans? </span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span>Trovare la giusta combinazione di tecnologie e configurazioni non Ã¨ stato affatto semplice. La cosa piÃ¹ difficile per noi Ã¨ stata trovare la giusta versione di Apache Tomcat che andasse bene alla nostra versione di Netbeans (al tempo la 7.2). Alla fine abbiamo scoperto che i problemi peggiori derivavano dal fatto di avere piÃ¹ versioni del server installate sulle nostre macchine allo stesso tempo, con i rispettivi file di configurazione sparsi in varie cartelle differenti.</span>
</p>

<p class="c2">
  <span><br />In seguito, queste dificoltÃ  iniziali non si sono piÃ¹ riprensetate dato che Netbeans offre giÃ  una sua versione di Tomcat di default ed Ã¨ possibile gestire praticamente tutto ciÃ² che lo riguarda direttamente dallâ€™IDE, risparmiando tutta una serie di subdoli problemi che si possono incontrare quando si lavora direttamente con i file di configurazione del/dei server.</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span>- Quindi per mettere in piedi il nostro progetto il primo passo Ã¨ stato scaricare Netbeans, e aggiungere Tomcat tra i server dellâ€™IDE, direttamente dalla wizard di installazione. <br /><br />- La seconda cosa da fare, Ã¨ creare un nuovo progetto come una Web Application, sotto la cartella Java Web.</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c11">
  <img height="283" src="images/image11.png" width="410" />
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span>- In seguito si sceglie il nome del progetto e si seleziona Tomcat come server (probabilmente anche Glassfish funzionerebbe, visto che si tratta praticamente di Tomcat con qualche cosa in piÃ¹).</span>
</p>

<p class="c2 c11">
  <img height="312" src="images/image02.png" width="484" />
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span>Per il nostro progetto non abbiamo utilizzato nessuno dei framework messi a disposizione.</span>
</p>

<p class="c2 c11">
  <span>- Andiamo ora a creare un package allâ€™interno della cartella Source Packages, il quale conterrÃ  la nostra classe Java WebService. Alla fine si dovrebbe avere una struttura piÃ¹ o meno cosÃ¬:<br /><br /></span><img height="217" src="images/image00.png" width="391" />
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span>Il codice di myWebService.java potrebbe essere per esempio il seguente:</span>
</p>

<p class="c2 c4 c11">
  <span></span>
</p>

<p class="c2">
  <span class="c8 c0">package</span><span class="c1 c0">Â Webapplication1Service;<br /><br /></span><span class="c8 c0">import</span><span class="c1 c0">Â javax.jws.WebParam;<br /></span><span class="c12 c5 c0 c17">/*</span><span class="c1 c0"><br /></span><span class="c12 c17 c5 c0">Â * qui definisci altre classi che potresti usare nello web service</span><span class="c1 c0"><br /></span><span class="c12 c17 c5 c0">Â * Non devono per forza essere classi pubbliche, anzi</span><span class="c12 c17 c5 c0">!</span><span class="c1 c0"><br /></span><span class="c12 c17 c5 c0">Â */</span><span class="c1 c0"><br /></span><span class="c8 c0">class</span><span class="c1 c0">Â classeEsempio{<br /> Â  Â </span><span class="c8 c0">protected</span><span class="c1 c0">Â </span><span class="c8 c0">static</span><span class="c1 c0">Â </span><span class="c8 c0">int</span><span class="c1 c0">Â funzioneEsempio(</span><span class="c8 c0">double</span><span class="c1 c0">Â a, </span><span class="c8 c0">double</span><span class="c1 c0">Â b, </span><span class="c8 c0">double</span><span class="c1 c0">Â c){<br /> Â  Â  Â  Â </span><span class="c8 c0">try</span><span class="c1 c0">{<br /> Â  Â  Â  Â  Â  Â </span><span class="c8 c0">return</span><span class="c1 c0">Â ((</span><span class="c8 c0">int</span><span class="c1 c0">)a+(</span><span class="c8 c0">int</span><span class="c1 c0">)b+(</span><span class="c8 c0">int</span><span class="c1 c0">)c)/</span><span class="c12 c3 c0">3</span><span class="c1 c0">;<br /> Â  Â  Â  Â }</span><span class="c8 c0">catch</span><span class="c1 c0">( Exception e){<br /> Â  Â  Â  Â  Â  Â System.</span><span class="c12 c19 c0">out</span><span class="c1 c0">.</span><span class="c12 c0 c19">println</span><span class="c0 c1">(e.</span><span class="c12 c19 c0">getMessage</span><span class="c1 c0">());<br /> Â  Â  Â  Â  Â  Â </span><span class="c8 c0">return</span><span class="c1 c0">Â -</span><span class="c3 c0 c12">1</span><span class="c1 c0">;<br /> Â  Â  Â  Â } Â  Â  Â  Â  <br /> Â  Â }<br />}<br /></span><span class="c12 c17 c5 c0">/*</span><span class="c1 c0"><br /></span><span class="c12 c17 c5 c0">Â * Questo Ã¨ lo webservice vero e proprio e per dichiarare le funzioni</span><span class="c1 c0"><br /></span><span class="c12 c17 c5 c0">Â * che vogliamo offrire si usa una sintassi molto semplice, con l'ausilio dei</span><span class="c1 c0"><br /></span><span class="c12 c17 c5 c0">Â * decoratori.</span><span class="c1 c0"><br /></span><span class="c12 c17 c5 c0">Â */</span><span class="c1 c0"><br /></span><span class="c0 c8">public</span><span class="c1 c0">Â </span><span class="c8 c0">class</span><span class="c1 c0">Â myWebService {<br /> Â  Â </span><span class="c8 c0">public</span><span class="c1 c0">Â </span><span class="c8 c0">int</span><span class="c1 c0">Â parteInteraMediaATre( Â @WebParam(name =</span><span class="c12 c3 c0">"primo"</span><span class="c1 c0">) </span><span class="c8 c0">double</span><span class="c1 c0">Â a,<br /> Â  Â  Â  Â  Â  Â @WebParam(name =</span><span class="c12 c3 c0">"secondo"</span><span class="c1 c0">) </span><span class="c8 c0">double</span><span class="c1 c0">Â b,<br /> Â  Â  Â  Â  Â  Â @WebParam(name =</span><span class="c12 c3 c0">"terzo"</span><span class="c1 c0">) </span><span class="c8 c0">double</span><span class="c1 c0">Â c Â  Â  Â  Â  Â  <br /> Â  Â  Â  Â  Â  Â )<br /> Â  Â {<br /> Â  Â  Â  Â </span><span class="c8 c0">return</span><span class="c1 c0">Â classeEsempio.</span><span class="c12 c19 c0">funzioneEsempio</span><span class="c1 c0">(a,b,c);<br /> Â  Â }<br />}</span>
</p>

<p class="c2 c4">
  <span class="c7"></span>
</p>

<p class="c2">
  <span>Ora ci basta compilare il nostro progetto e Netbeans genererÃ  il codice wsdl che dovrÃ  descrivere il nostro web service e farÃ  anche il deploy nel server prestabilito.</span>
</p>

<p class="c2">
  <span>Un deploy manuale Ã¨ possible semplicemente cliccando con il tasto destro sul progetto. <br />Aprendo la finestra dei â€œServicesâ€, vicino a â€œFilesâ€ e â€œProjectsâ€ potremo vedere come il nostro web service di esempio sia allâ€™interno del nostro server e sia pronto per essere cosumato.</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c11">
  <img height="273" src="images/image09.png" width="410" />
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c4">
  <span class="c0"></span>
</p>

<p class="c2 c4">
  <span class="c0"></span>
</p>

<p class="c2">
  <span class="c0">ASocialService - </span><span>Eâ€™ la classe che si occupa di interfacciarsi con il client. Contiene le funzioni web pubbliche chiamabili da remoto. Nel progetto vengono fruite da un sito web php.</span>
</p>

<p class="c2 c23">
  <span class="c0">URLify </span><span>(String str) : String</span>
</p>

<p class="c2 c6">
  <span class="c0">checkAvatar </span><span>(int userID) : Boolean</span>
</p>

<p class="c2 c6">
  <span class="c0">getUserName </span><span>(int userID) : String</span>
</p>

<p class="c2 c6">
  <span class="c0">hateComment </span><span>(int commentID)</span>
</p>

<p class="c2 c6">
  <span class="c0">hatePost </span><span>(int postID)</span>
</p>

<p class="c2 c6">
  <span class="c0">isAdmin </span><span>(int userID) : int</span>
</p>

<p class="c2 c6">
  <span class="c0">loginRequest </span><span>(String username, String password) : int</span>
</p>

<p class="c2 c6">
  <span class="c0">registrationRequest </span><span>(String username, String password, String pwconfirm) : String</span>
</p>

<p class="c2 c6">
  <span class="c0">remvAdmin </span><span>(int userID)</span>
</p>

<p class="c2 c6">
  <span class="c0">remvComment </span><span>(int commentID)</span>
</p>

<p class="c2 c6">
  <span class="c0">remvPost </span><span>(int postID) : int</span>
</p>

<p class="c2 c6">
  <span class="c0">remvUser </span><span>(int userID) : int</span>
</p>

<p class="c2 c6">
  <span class="c0">resizeImage </span><span>(String image, int width, int height,Boolean higherQuality) : String</span>
</p>

<p class="c2 c6">
  <span class="c0">setAdmin </span><span>(int userID)</span>
</p>

<p class="c2 c6">
  <span class="c0">setAvatar </span><span>(String userID) : Boolean</span>
</p>

<p class="c2 c6">
  <span class="c0">setComment </span><span>(int userID, int postID, String commentBody) : String</span>
</p>

<p class="c2 c6">
  <span class="c0">setPost </span><span>(int userID, String postTitle, String postBody) : String</span>
</p>

<p class="c2 c6">
  <span class="c0">updatePostXML </span><span>() : Boolean</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span class="c0">Database - </span><span>Questa classe contiene tutte le funzioni che servono per interrogare o modificare il DataBase, dal login ai post, agli strumenti di amministrazione.</span>
</p>

<p class="c2">
  <span>Â Â Â Â Â Â Â Â </span><span class="c0">checkLogin </span><span>(String user, String pwd) : int</span>
</p>

<p class="c2">
  <span>Â Â Â Â Â Â Â Â </span><span class="c0">getAvatar </span><span>(int userID) : Boolean</span>
</p>

<p class="c2">
  <span>Â Â Â Â Â Â Â Â </span><span class="c0">getComment </span><span>() : ResultSet</span>
</p>

<p class="c2 c6">
  <span class="c0">getPost </span><span>() : ResultSet</span>
</p>

<p class="c2 c6">
  <span class="c0">getComment </span><span>() : ResultSet</span>
</p>

<p class="c2 c6">
  <span class="c0">getPost </span><span>() : ResultSet</span>
</p>

<p class="c2 c6">
  <span class="c0">getUserName </span><span>(int userID) : String</span>
</p>

<p class="c2 c6">
  <span class="c0">hateComment </span><span>(int CommentID)</span>
</p>

<p class="c2 c6">
  <span class="c0">hatePost </span><span>(int postID</span>
</p>

<p class="c2 c6">
  <span class="c0">isAdmin </span><span>(int userID) : int</span>
</p>

<p class="c2 c6">
  <span class="c0">registrationRequest </span><span>(String username, String password) : String</span>
</p>

<p class="c2 c6">
  <span class="c0">remvAdmin </span><span>(int userID)</span>
</p>

<p class="c2 c6">
  <span class="c0">remvComment </span><span>(int commentID) : int</span>
</p>

<p class="c2 c6">
  <span class="c0">remvPost </span><span>(int postID) : int</span>
</p>

<p class="c2 c6">
  <span class="c0">remvUser </span><span>(int userID) : int</span>
</p>

<p class="c2 c6">
  <span class="c0">setAdmin</span><span>(int userID)</span>
</p>

<p class="c2 c6">
  <span class="c0">setAvatar </span><span>(String userID) : Boolean</span>
</p>

<p class="c2 c6">
  <span class="c0">setComment </span><span>(int userID, int postID, String commentBody) : String</span>
</p>

<p class="c2 c6">
  <span class="c0">setPost </span><span>(int userID, String postTitle, String postBody) : String</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span class="c0">ImageResize - </span><span>Classe che si occupa di ridimensionare le immagini uploadate dagli utenti.</span>
</p>

<p class="c2">
  <span>Â Â Â Â Â Â Â Â </span><span class="c0">getScaledInstance </span><span>(String address, int targetWidth, int target Height, boolean higherQuality) : String</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span class="c0">URLInString - </span><span>Classe che trova URL nei messaggi degli utenti e ne genera il codice HTML per il collegamento ipertestuale.</span>
</p>

<p class="c2">
  <span>Â Â Â Â Â Â Â Â </span><span class="c0">findURL </span><span>(String s) : String</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span class="c0">XMLCommentsFile - </span><span>Gestisce il file XML contenente i commenti.</span>
</p>

<p class="c2">
  <span>Â Â Â Â Â Â Â Â </span><span class="c0">getXML </span><span>() : Boolean</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2">
  <span class="c0">XMLPostFile - </span><span>Gestisce il file XML contenente i post.</span>
</p>

<p class="c2">
  <span>Â Â Â Â Â Â Â Â </span><span class="c0">getXML </span><span>() : Boolean</span>
</p>

<p class="c2 c4">
  <span></span>
</p>

<p class="c2 c4">
  <span class="c0"></span>
</p>
