import java.util.Scanner;

/*SITO FATTO BENE DI RIFERIMENTO:  http://www.simplesoft.it/algoritmi-di-ordinamento-in-java.html  */
public class MetodiOrdinamento {
	

	public static void main(String[] args) {//MAIN
		import java.util.Scanner;
	}
	                                      //------------------------METODI UTILI DI SUPPORTO--------------------------------//
	public static void Scambia(int[] V, int i, int j) {//FUNZIONE CHE SCAMBIA DUE ELEMENTI IN UN VETTORE
		int tmp = V[i];
		V[i]=V[j];
		tmp=V[j];
		}
	
	public static void StampaVettore(int[]V){//STAMPA ELEMENTI DEL VETTORE
		for(int i=0;i<V.length;i++){
			System.out.println(" "+ V[i]+ " ");
		}
	}
	
	public static int [] RiempiVettore (){//CREA UN VETTORE DI DIMENSIONE E ELEMENTI SPECIFICATI IN INPUT DA UTENTE
		System.out.println("Inserire Dimensione Intera del Vettore da Creare:");
		Scanner kb= new Scanner(System.in);
		int n= kb.nextInt();//si salva dimensione array presa in input
		int [] Z= new int[n];//si crea vettore di dimensione specificata da utente
		//riempiamo il vettore con un ciclo popolandolo con elementi specificati da utente
		for(int i=0;i<Z.length;i++){
			System.out.println("Inserire Elemento Intero del Vettore in posizione:"+" "+ i);
			Z[i]=kb.nextInt();
		}
		return Z;
		}
	
                                        
	
	                                   //------------------------------------RICERCA LINEARE----------------------------// 
	/*L’algoritmo di ricerca lineare (o sequenziale) in una sequenza
	 * (array) è basato sulla seguente strategia:
 1)Gli elementi dell’array vengono analizzati in sequenza,
confrontandoli con l’elemento da ricercare (chiave) per determinare
se almeno uno degli elementi è uguale alla chiave.
2)Quando si trova un elemento uguale alla chiave la ricerca termina.
 La ricerca è sequenziale, nel senso che gli elementi dell’array
vengono scanditi uno dopo l’altro sequenzialmente.
3)L’algoritmo prevede che al più tutti gli elementi dell’array
vengano confrontati con la chiave(CASO PEGGIORE). Se l’elemento viene trovato
prima di raggiungere la fine della sequenza non sarà necessario
proseguire la ricerca*/
	      
	public static int RicercaLineareI(int chiave,int [] A) {//METODO DI RICERCA LINEARE VERSIONE ITERATIVA
	   
		for(int i=0;i<A.length;i++){//scandiamo vettore e i suoi elementi
			if(chiave==A[i]) {return i;}// se elemento c'è si restituisce posizione in cui è contenuto
			else{return -1;} // se elemento non c'è si restituisce -1
	}
}
	/*COMPLESSITA' METODO RicercaLineareI(int chiave,int [] A)
   * O(1)=complessità spaziale non ci sono creazioni di nessun tipo di oggetto o ricorsione
	 * O(1)=complessità temporale del caso migliore in cui la chiave si trova in prima posizione 
	 *O(n)=complessità temporale del caso peggiore in cui la chiave si trova in ultima posizione o non è contenuta
	 *n=dimensione del vettore*/
	public static void RicercaLineareEfficiente(int chiave,int [] V) {//METODO DI RICERCA LINEARE EFFICIENTE
		//NB:si assume che il vettore V è ordinato in modo non decrescente
		int i=0; //permette di scorrere il vettore
		while(i<V.length && V[i]<=chiave){i++;}
		if(i<V.length && V[i]==chiave){System.out.println("Elemento trovato in posizione" + i);}
		else{System.out.println("Elemento non trovato posizione");}
		}
	/*COMPLESSITA' DEL METODO public static void RicercaLineareEfficiente(int chiave,int [] V)
	 * O(n)= complessità temporale del caso peggiore in cui la chiave sia maggiore dell'elemento in ultima posizione(elemento non presente) o vi sia uguale.
	 * in tal caso si deve scandire intero vettore*/
                  
	
	                     //--------------------------------USO RICERCA LINEARE PER CONTARE OCCORRENZE---------------------//
	/*L’algoritmo di ricerca lineare può essere usato per
verificare quante volte un elemento è presente in
una sequenza:
1. Gli elementi dell’array vengono analizzati in sequenza,
confrontandoli con l’elemento da ricercare (chiave) per
determinare se uno degli elementi è uguale alla chiave.
2. Quando si trova un elemento uguale alla chiave si
incrementa un contatore e il passo 1 viene rieseguito
fino alla fine della sequenza. */
	public static int ContaOccorrenze(int[] seq, int chiave){
	 int i=0; // indice per la scansione di seq
	 int occorre=0; // valore delle occorrenze della chiave in seq

	 for(i=0; i<seq.length; i++){
	 if (seq[i] == chiave)occorre++;
	 }
	 return occorre;
	} 
	/*COMPLESSITA' DEL METODO ContaOccorrenze(int[] seq, int chiave) */
	//O(n)= complessità temporale in tal caso si deve scandire intero vettore
	                                          
	
	                                                     //--------------------RICERCA BINARIA--------------------//
	/*Se la sequenza su cui occorre effettuare la ricerca è ordinata si
può usare un algoritmo di ricerca molto più efficiente che cerca
la chiave sfruttando il fatto che gli elementi della sequenza sono
già disposti in un dato ordine.In questi casi si usa un algoritmo di ricerca binaria che è più
efficiente perché riduce lo spazio di ricerca
L’algoritmo di ricerca binaria cerca un elemento in una
sequenza ordinata in maniera crescente (o non decrescente)
eseguendo i passi seguenti finché l’elemento viene trovato o si
è si è completata la ricerca senza trovarlo:
1. Confronta la chiave con l’elemento centrale della sequenza,
2. Se la chiave è uguale all’elemento centrale, allora la ricerca
termina positivamente,
3. Se invece la chiave è maggiore dell’elemento centrale si effettua
la ricerca solo sulla sottosequenza a destra,
4. Se invece la chiave è minore dell’elemento centrale dello spazio di
ricerca, si effettua la ricerca solo sulla sottosequenza a sinistra. */
	public static int RicercaBinariaI(int[] seq, int chiave){ //METODO DI RICERCA BINARIA VERSIONE ITERATIVA
		//NB:si assume che seq è ordinato in modo non decrescente
	 
	 int inizio=0; //indica posizione iniziale del vettore
	 int fine=(seq.length)-1; //indica posizione finale del vettore
	 //indica posizione centrale del vettore
	 while (inizio <= fine){
	     int centro = (inizio+fine)/2;//indica posizione centrale del vettore
	     if (seq[centro]==chiave){ // elemento trovato
	          return centro;}
	     else{
	             if (chiave > seq[centro]){ // continua a destra
	             inizio = centro + 1;}//partendo dalla posizione successiva del centro attuale
	            else { // continua a sinistra
	            	fine = centro - 1;//finendo alla posizione precedente del centro attuale
	              }
	             }
	 return -1;
	} 
	
} 

	/*COMPLESSITà DEL METODO public static int RicercaBinariaI(int[] seq, int chiave)
	 * Inizialmente la ricerca è fatta su N elementi dove N indica la lunghezza della sequenza (lo spazio di ricerca ha dimensione N).
	 * O(log2 N)= complessità del caso peggiore che si ha quando l’elemento cercato non si trova nella sequenza (non esiste un elemento uguale alla chiave).
	 * Ad ogni iterazione lo spazio della ricerca si riduce di “circa” la metà. Potremmo dire che si passa da N ad N/2 e cosi via.*/
	
public static int RicercaBinariaR(int[] seq, int chiave,int inizio , int fine){ //METODO DI RICERCA BINARIA VERSIONE RICORSIVA
	//NB:si assume che seq è ordinato in modo non decrescente
	 
		 inizio=0; //indica posizione iniziale del vettore
		 fine=(seq.length)-1; //indica posizione finale del vettore
		 if(inizio>fine){return -1;}//caso in cui la funzione richiama se stessa e non trova nulla
		 else{
			 int centro=(fine+inizio)/2;//indica poszione centrale del vettore
			 if(chiave==centro)
			 {return centro;}//elemento trovato
			 if(chiave>seq[centro])
			 {return  RicercaBinariaR(seq,chiave,centro+1,fine);}//continua in sottosequenza destra richiamando la funzione ricorsivamente
			 else
			 {return RicercaBinariaR(seq,chiave,inizio,centro-1);}//continua in sottosequenza sinistra richiamando la funzione ricorsivamente
			 }
}
/*COMPLESSITA' DEL METODO public static int RicercaBinariaR(int[] seq,int chiave,int inizio,int fine)
 * O(1)=complessità spaziale e temporale del caso migliore (n<=1)
 * O(log2n)=complessità spaziale e temporale del caso peggiore (n>1)*/

                                              

                                                      
                                                                  //----------------INSERTION SORT------------//


/*L'Insertion Sort é un'altro noto e semplice algoritmo di ordinamento che si basa sul concetto di ordinamento in maniera crescente per inserzione degli elementi di un vettore*/
//PAG 176 LIBRO DI TESTO


public static void InsertionSort1(int [] V){
	for(int i=0; i<V.length-1;i++){//scorre elementi del vettore fino al penultimo
		for(int j=i+1;j<V.length;j++){//confronta ogni elemento del primo ciclo con quelli a seguire
			if(V[i]>V[j]){Scambia(V,i,j);}//se un elemento in poszione i è maggiore di un suo successivo in poszione j li scambia
			
		}		
	}
}
/*COMPLESSITA' DEL METODO InsertionSort1(int [] V)
 * La complessitá dell' algoritmo sia in numero di confronti che di scambi é quadratica nel caso peggioreO(n^2).
 * Mentre risulta lineare O(n) nel caso migliore (quando il vettore risulta parzialmente ordinato). */


public static void InsertionSort2(int [] V){
	for(int i=1; i<V.length-1;i++){//scandiamo in vettore partendo da elemento in pozione 1
		int key=V[i];//salviamo elemento scandito alla i-esima iterazione
		int j= i-1;//indice di posizione precedente ad i
		while(j>=0 && V[j]>key){//se il precedente in poszione j è maggiore del successivo in poszione i
			V[j+1]=V[j];//spostiamo elemento in posizione j nella posizione i successiva e viceversa
			i--;
		}
		V[j+1]=key;// aggiorniamo le posizioni 
	}
	
}




                                                                 //---------------SELECTIONSORT--------------------//

/*Questo algoritmo ordina una sequenza di elementi andando a trovare l’elemento minore e portandolo nella posizione
iniziale della sequenza, e l’elemento in posizione iniziale nella
posizione occupata del valore minore.Quindi sulla sotto-sequenza non ordinata effettua la stessa
operazione fino a che rimane un solo elemento (che è ordinato).L’algoritmo opera su una sequenza non ordinata come se fosse
composta di due sotto-sequenze: la prima ordinata e la seconda non-ordinata,andando a cercare il valore minimo nella sequenza nonordinata e 
portandolo nella ultima posizione della sequenzaordinata. 
Quando la sotto-sequenza non ordinata è composta da un solo elemento l’ordinamento è terminato (l’ultimo elemento è il maggiore).*/

public static void SelectionSort(int[]vet){
	
	for (int i = 0; i < vet.length-1; i++){//Si usano due indici i e j: i scorre su tutto l’array
	int pos_min = i;//All’inizio si assume che la posizione dell’elemento minore è 0 e dalla posizione 1 fino alla fine si cerca il valore minimo.
	     for (int j = i+1; j < vet.length; j++){// j scorre sulla parte dell’array non ordinata dalle posizioni successive ed i
	           if (vet[pos_min] > vet[j]){pos_min = j;}//se l'elemento nella posizione minima è maggiore dell'elemento in una posizione successiva j
	                                                  //(nella sottosequenza non ordinata) , la nuova posizione di minimo diventa j
	     if (pos_min != i){Scambia(vet,vet[i],vet[j]);}//Se minimo e diverso dall' elemento di partenza allora avviene lo scambio
	
	 } 
}
}
/*COMPLESSITA' DEL METODO SelectionSort(int[]vet)
 * In questo caso la complessitá risulta quadratica O(n^2) sia nel caso peggiore e migliore. Il numero di confronti é O(n^2) in ogni caso. 
 * Mentre il numero di scambi è lineare O(n) nel caso peggiore , mentre é costante O(1) nel caso migliore. */


                                                   //-------------------BUBBLE SORT-----------------------//
/*• Opera per “passate successive” sull’array v:
– a ogni iterazione, considera una ad una tutte le possibili coppie di elementi adiacenti,
scambiandoli se risultano nell’ordine errato(ovvero elemento a sinistra > elemento a destra)
– così, dopo ogni iterazione, l’elemento massimo è in fondo alla parte di array considerata
• Quando non si verificano scambi dopo aver scandito tutta la sequenza v , l’array v  è ordinato, e l’algoritmo termina*/

public static void BubbleSort(int [] v){
	for(int i=0;i<v.length;i++){
		boolean ordinato=false;
		for(int j=0;j<=v.length-1;j++){
			/*se elemento in posizione j è maggiore del suo successivo in poszione j+1 si effettua lo scambio*/
			if(v[j]>v[j+1]){
				Scambia(v,j,j+1);
				ordinato=true;
				}
		}
		if(!ordinato) break; //Se ordinato=false allora vuol dire che nell' ultima iterazione
                         //non ci sono stati scambi, quindi il metodo può terminare poiché l' array risulta ordinato
	}
}
/*CONSIDERAZIONE:Un insieme di ottimizzazioni si basa sull'osservazione che se, in una data iterazione, non avviene più alcuno scambio,
 * l'array è necessariamente ordinato e l'algoritmo può essere terminato anticipatamente (ovvero senza giungere alla N-1esima iterazione).
 *  Una tecnica di ottimizzazione può dunque essere applicata usando una variabile booleana (o equivalente) usata come "ordinato" che indica se nell'iterazione corrente
 *   si è eseguito almeno uno scambio
 * La variabile viene reimpostata a false all'inizio di ogni iterazione, e impostata a true solo nel caso in cui si proceda a uno scambio.
 *  Se al termine di una iterazione completa il valore della variabile "ordinato" è false, l'array è ordinato e l'intero algoritmo viene terminato.*/
/*COMPLESSITA' DEL METODO BubbleSort(int [] v)
 * La complessitá dell' algoritmo in numero di confronti é quadratica nel caso peggiore O(n^2) caso in cui vettore è ordinato in maniera decrescente, 
 * mentre risulta lineare O(n) nel caso migliore (quando il vettore risulta ordinato).
 *  Mentre per il numero scambi é quadratica nel caso peggiore O(n^2), mentre risulta costante O(1) nel cosa migliore in quanto non si effettuano scambi.*/

                                         //---------------------MERGE SORT------------------------------//
/*Il Merge Sort (ordinamento per fusione) a differenza degli algoritmi visti in precedenza,
 * é un algoritmo di ordinamento piú complesso, ma molto efficiente.Il meccanismo di ordinamento di questo algoritmo fa uso della tecnica Divide et Impera.
 * E' una tecnica che consiste nel suddividere ricorsivamente un problema complesso 
 * in due o piú sotto-problemi piú semplici e poi si ricombinano le soluzioni trovate per ricostruire la soluzione del problema complessivo.
 *1) La sequennza v viene suddivisa in due metà(divide);
 *2)Entrambe le due sottosequenze vengono ordinate,applicando ricorsivamente l'algoritmo(impera).
 *3)Le due sottosequenze vengno fuse(merge).Per fare questo si estrae ripetutamente il minimo delle due sottosequenze e lo si pone nella sequenza in uscita che risulterà ordinata.
 *NB:se la sequenza è vuota o contiene un elemento è gia ordinata !.*/

public void MergeSort(int [] v, int inizio, int fine) {//O(log2n)
	//inizio=posizione iniziale del vettore v
	//fine=posizione finale del vettore v
	if(inizio<fine){
		int centro=(fine+inizio)/2;//posizione centrale del vettore v
		//si richiama ricorsivamente algoritmo per ordinare due sottosequenze
		MergeSort(v,inizio,centro); // Primo sotto-vettore
        MergeSort(v,centro+1,fine); // Secondo sotto-vettore
        Merge(v,inizio,centro,fine);
        }
}
private static void Merge(int []v,int inizio,int centro,int fine){//O(2n)
	int[]w=new.int[fine-inizio+1];//si crea nuovo vettore
	int i=inizio;//scorre primo sottovettore
	int j= centro+1;//scorre secondo sottovettore
	int k=0;//punta al primo elemento di w
	while(i<=centro+1 &&  j<=fine){
		
		if(v[i]<=v[j])  {w[k++]=v[i++];}
		
		else/*(v[i]>v[j])*/ {w[k++]=v[j++];}
	}
	while(i<=centro){//copia elementi nel primo sottovettore
		w[k++]=v[i++];
	}
	while(j<=fine){//copia elementi nel secondo sottovettore
		w[k++]=v[j++];
	}
	for(int k=0;k<v.length;k++)    {V[inizio+k]=w[k];}
	
	}
/*COMPLESSITA DEL METODO MergeSort(int [] v, int inizio, int fine)
 * O(nxlog2n)=complessità temporale essendo i due metodi innestati.
 * La complessita della fusione (metodo merge) é lineare O(2n) poichè usa un vettore di appoggio da scorrere con due while a metà e un for completo sul vettore,
 *  mentre la funzione mergeSort richiama se stessa due volte ogni volta su metà del vettore di input, 
 *  quindi se associamo la funzione temporale al tempo di esecuzione del mergeSort essa sarà O(log2n). 
 *La complessitá rimane la stessa sia nel caso peggiore e migliore, poiché il processo ricorsivo non puó essere arrestato anticipatamente la complessitá é O(nxlog2n) in ogni caso.*/

                           //---------------------MERGE SORT DI DUE VETTORI GIA' ORDINATI------------------------------//
/*Questo metodo prendo in input due vettori , Già Ordinati, li concatena e restituisce un unico vettore i cui elementi sono ordinati*/

public static int[] MergeSort(int [] a, int [] b) {
	int [] c =new.int(a.length + b.length);//creiamo nuovo vettore che conterrà gli elementi dei due vettori a e b riordinati totalmente
	int i=0;//scorre vettore a
	int j=0;//scorre vettore b
	int k=0;//scorre vettore c
while(i<a.length &&  j<b.length){//scorriamo i vettori con  i due indici e confrontiamo elementi nelle medesime posizioni .Il minore dei due va inserito in c
		
		if(a[i]<=b[j])  {c[k++]=a[i++];}
		
		else/*(a[i]>b[j])*/ {c[k++]=b[j++];}
	}
while(i<a.length)/*scorre vettore a */  {c[k++]=a[i++];}
while(j<b.length)/*scorre vettore b */  {c[k++]=b[j++];}
	return c;
	
}

                                 //-----------------------------QUICK SORT-------------------//
/*può essere utile partizionare l’array in due parti, ordinarle separatamente,  infine fonderle insieme.In pratica:
– si suddivide il vettore in due “sub-array”, delimitati da un elemento “sentinella” (pivot)
– il primo array deve contenere solo elementi minori o uguali al pivot, il secondo solo elementi maggiori del pivot.
Algoritmo ricorsivo:
• i due sub-array ripropongono un problema
di ordinamento in un caso più semplice
(array più corti);
• a forza di scomporre un array in sub-array,
si giunge a un array di un solo elemento,
che è già ordinato (caso banale);


STRUTTURA ALGORITMO
Struttura dell’algoritmo:
• scegliere un elemento come pivot
• partizionare l’array nei due sub-array
• ordinarli separatamente (ricorsione)

L’operazione-base è il partizionamento(METODO PARTITION) dell’array nei due sub-array. Per farla:
• se il primo sub-array ha un elemento > pivot, e il secondo array un elemento < pivot, questi due elementi vengono scambiati Poi si riapplica quicksort ai due sub-array.*/

public void QuickSort(int [] v, int inizio, int fine) {
	//inizio=posizione iniziale del vettore v
   //fine=posizione finale del vettore v
	
	if(inizio<fine){
		int m= Partition(v;inizio;fine);//restituisce punto di separazione tra i due indici i e j
		QuickSort(v,inizio,m);
		QuickSort(v,m+1,fine);
	}
}

private static int Partition (int []v; int inizio;int fine){
	//si inizializano indici i e j per poi usarli nel cilo
	int i= inizio-1;
	int j= fine+1;
	int pivot=v[inizio];
	while(i<j){
		//NB.si pone uguaglianza ad uno dei due per considerare elementi che si ripetono
		do{i++;} while(v[i]<=pivot);
		
		do{j--;} while(v[j]>pivot);
		
		if(i<j){Scambia(v;i;j);}
		
	}
	return j;
}

/*COMPLESSITA' DEL METODO QuickSort(int [] v, int inizio, int fine)
 * La complessità dipende dalla scelta del pivot:
• se il pivot è scelto male (uno dei due sub-array ha lunghezza zero), i confronti sono O(n^2) con O(n^2) scambi nel caso peggiore
• se però il pivot è scelto bene (in modo da avere due sub-array di egual dimensione):
---• si hanno log2n attivazioni di quicksort;
---• il numero di confronti ad ogni livello è sempre n (L confronti per ciascuno dei 2k array)
---• Numero globale di confronti: O(N log2 N)*/


}
