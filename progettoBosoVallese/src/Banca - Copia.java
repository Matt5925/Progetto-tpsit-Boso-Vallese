import java.util.Scanner;

public class Banca {

	public static void menu(int settimana){
		System.out.println("Settimana "+settimana);
		System.out.println("------ MENU ------");
		System.out.println("1 --> preleva");
		System.out.println("2 --> deposita");
		System.out.println("3 --> vedi conto in banca ");
		System.out.println("4 --> vedi portafoglio");
		System.out.println("5 --> investi");
		System.out.println("6 --> avanza di settimana ");
		System.out.println("0 --> ESCI \n");
		System.out.println("Fai la tua scelta: ");
	}

	public static void menu2(){
		System.out.println("------ MENU INVESTIMENTI ------");
		System.out.println("1 --> investimento di breve durata");
		System.out.println("2 --> investimento di media durata ");
		System.out.println("3 --> investimento di lunga durata ");
	}

	public static void menu3(){
		System.out.println("------ MENU INVESTIMENTI 2 ------");
		System.out.println("1 --> investimento a basso rischio e con basso guadagno ");
		System.out.println("2 --> investimento a medio rischio e con medio guadagno  ");
		System.out.println("3 --> investimento a alto rischio e con alto guadagno ");
	}


	
	
	public static int stringToInt(String s, int z) {
		int n;
		try {
			 n = Integer.parseInt(s);
		}catch(NumberFormatException e) {
	        return -1;  
	    }
		if(SceltaCorretta(n,z))return n;
		else return -1;
	}
	
	
	public static boolean SceltaCorretta(int n, int z) {
		if (n<0||n>z)return false;
		return true;
		
	}
	

	public static double mostraSoldi(double soldi){
		return soldi;
	}

	


	
//modifica la quantità di soldi nel portafoglio
	public static double modificaPortafoglio(double portafoglio,double x,int a) {
		if (a==1)portafoglio+=x;//prelievo
		else if (a==2)portafoglio-=x;//deposita
		return portafoglio;

	}

	
//modifica la quantità di soldi nel conto
	public static double modificaConto (double x,double conto, int a) {
		if (a==1)conto-=x;//prelievo
		else if(a==2)conto+=x;//deposita
		return conto;

	}

	public static double livelloinvestimenti(int soglia, int rischio, double soldi
		int n=random(1-100);
		if (n<soglia){
		guadagno=soldi+soldi/(n/rischio);
		}else{
		guadagno=soldi-soldi/((n-20)/rischio);
	}
		return guadagno;
	}

	public static int duratainvestimento(){
	
	}
	
		public static void main(String []args) {
			
			Scanner tastiera=new Scanner(System.in);
			double portafoglio=100,conto=0;
			int settimana=1;
			boolean ciclo=true;
			
			System.out.print("premi un tasto per iniziare: ");
			while(ciclo) {
				
				menu(settimana);
				String stringScelta=tastiera.nextLine();
				int scelta=stringToInt(stringScelta,6);
					while (scelta==-1) {
						System.out.println( "ERRORE!!");
						System.out.println( "RIINSERISCI LA SCELTA: ");
						stringScelta=tastiera.nextLine();
						scelta=stringToInt(stringScelta);
					}
					
					
					
					switch(scelta) {
							/*preleva
							 * aggiunge al portafoglio
							 * rimuove al conto
							 * */
							case 1:{
								if (conto==0) {
									System.out.println("Non hai soldi in banca");
									break;
								}
								
								System.out.print("Inserisci quanti soldi prelevare dalla banca --> ");

								double x=tastiera.nextDouble();

								
								while(x>conto) {
									System.out.println("Non hai abbastanza soldi in banca\nInserisci quanti soldi prelevare dalla banca --> ");
									x=tastiera.nextDouble();
								}

								conto=modificaConto(x,conto,1);
									System.out.println("Prelevo avvenuto con successo\nIl tuo conto adesso e' di -->" +conto);
									
								portafoglio=modificaPortafoglio(portafoglio,x,1);
									System.out.print("Ora nel tuo portafoglio hai --> "+portafoglio);
									
								break;
							}
							/*deposita
							 * aggiunge al conto
							 * rimuove al portafoglio
							 * */
							case 2:{
								if (portafoglio==0) {
									System.out.println("Non hai soldi in portafoglio");
									break;
								}
								double x;

								System.out.print("Inserisci quanti soldi depositare in banca --> ");

								x=tastiera.nextDouble();

								while(x>portafoglio) {

									System.out.println("Non hai abbastanza soldi nel portafoglio\nInserisci quanti soldi depositare in banca --> ");
									x=tastiera.nextDouble();
								}

								portafoglio=modificaPortafoglio(portafoglio,x,2);

								System.out.println("Hai depositato i soldi con successo!!\nOra nel tuo portafoglio hai --> "+portafoglio+" euro");

								conto=modificaConto(x,conto,2);
								System.out.println("Ora il tuo conto in banca e' di --> "+conto+" euro");

								break;
							}
						
							case 3:{
								System.out.println("i soldi che hai all'interno del tuo conto in banca sono --> "+mostraSoldi(conto));
								break;
							}
							case 4:{
								System.out.println("i soldi che hai all'interno del tuo portafoglio sono --> "+mostraSoldi(portafoglio));
								break;
							}
							
							case 5:{
								menu3();
								String stringScelta2=tastiera.nextLine();
								int scelta2=stringToInt(stringScelta);

										while (scelta2==-1) {
											System.out.println( "ERRORE!!");
											System.out.println( "RIINSERISCI LA SCELTA: ");
											stringScelta2=tastiera.nextLine();
											scelta2=stringToInt(stringScelta2,3);
										}
					
								break;
							}
							case 6:{
								settimana++;
								portafoglio=portafoglio+100;
								System.out.println("Una nuova settimana è iniziata!\nPer ringraziarti della tua fedeltà ti abbiamo dato 100 euro.\nOra hai "+portafoglio+" euro nel tuo portafoglio");
								break;
							}
							case 0:{
								ciclo=false;
								break;
							}
					}//swich
					
					System.out.println("\n");
					System.out.println("Premi un tasto per continuare...");
					tastiera.nextLine();
			}//ciclo

		}//main
}//class
