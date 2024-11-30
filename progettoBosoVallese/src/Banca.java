import java.util.Scanner;

public class Banca {

    public static void menu(int settimana) {
        System.out.println("Settimana " + settimana);
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

    public static void menu2() {
        System.out.println("------ MENU INVESTIMENTI ------");
        System.out.println("1 --> investimento di breve durata");
        System.out.println("2 --> investimento di media durata ");
        System.out.println("3 --> investimento di lunga durata ");
        System.out.println("Fai la tua scelta: ");
    }

    public static void menu3() {
        System.out.println("------ MENU INVESTIMENTI 2 ------");
        System.out.println("1 --> investimento a basso rischio e con basso guadagno ");
        System.out.println("2 --> investimento a medio rischio e con medio guadagno  ");
        System.out.println("3 --> investimento a alto rischio e con alto guadagno ");
        System.out.println("Fai la tua scelta: ");
    }

    public static int stringToInt(String s, int max, int min) {
        int n;
        try {
            n = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }
        if (SceltaCorretta(n, max, min)) return n;
        else return -1;
    }

    public static boolean SceltaCorretta(int n, int z, int min) {
        if (n < min || n > z) return false;
        return true;
    }

    public static Double stringToDouble(String s) {
        Double n;
        try {
            n = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return -1.0;
        }
        return n;
    }

    public static double mostraSoldi(double soldi) {
        return soldi;
    }

    // modifica la quantità di soldi nel portafoglio
    public static double modificaPortafoglio(double portafoglio, double x, int a) {
        if (a == 1) portafoglio += x; // prelievo
        else if (a == 2) portafoglio -= x; // deposita
        return portafoglio;
    }

    // modifica la quantità di soldi nel conto
    public static double modificaConto(double x, double conto, int a) {
        if (a == 1) conto -= x; // prelievo
        else if (a == 2) conto += x; // deposita
        return conto;
    }

    public static double livelloinvestimenti(int soglia, double soldi, int perc) {
        int n = (int) (Math.random() * 100);
        double guadagno;

        if (n < soglia) {
            guadagno = soldi * (1 + (perc / 100.0));
        } else {
            guadagno = soldi * (1 - (perc / 100.0));
        }

        return guadagno;
    }

    
    
    
    
    
    
    
    public static void main(String[] args) {

        Scanner tastiera = new Scanner(System.in);
        
        double portafoglio = 100, conto = 0;
        
        int settimana = 1;
        
        boolean ciclo = true, 
        		
        		investimento=true;//temporaneo
       
       double soldiInvestiti = 0;  // Salva l'importo investito
       int settimaneInvestimento=0;
       double guadagnoInvestimento = 0;  // Salva il guadagno o la perdita
       int percentualeInvestimento = 0;  // Salva la percentuale di guadagno o perdita

        while (ciclo) {

            menu(settimana);
            String stringScelta = tastiera.nextLine();
            int scelta = stringToInt(stringScelta, 6,0);
            while (scelta == -1) {
                System.out.println("ERRORE!!");
                System.out.println("RIINSERISCI LA SCELTA: ");
                stringScelta = tastiera.nextLine();
                scelta = stringToInt(stringScelta, 6,0);
            }
           
            switch (scelta) {
                case 1: {
                    if (conto == 0) {
                        System.out.println("Non hai soldi in banca");
                        break;
                    }

                    double x;
                    do {
                        System.out.print("Inserisci quanti soldi prelevare dalla banca --> ");
                        String sx = tastiera.nextLine();
                        x = stringToDouble(sx);
                    } while (x > conto || x < 0);

                    conto = modificaConto(x, conto, 1);
                    System.out.println("Prelievo avvenuto con successo\nIl tuo conto adesso è di -->" + conto);

                    portafoglio = modificaPortafoglio(portafoglio, x, 1);
                    System.out.print("Ora nel tuo portafoglio hai --> " + portafoglio);

                    break;
                }
                case 2: {
                    if (portafoglio == 0) {
                        System.out.println("Non hai soldi in portafoglio");
                        break;
                    }
                    double x;
                    do {
                        System.out.print("Inserisci quanti soldi depositare in banca --> ");
                        String sx = tastiera.nextLine();
                        x = stringToDouble(sx);
                    } while (x > portafoglio || x < 0);

                    portafoglio = modificaPortafoglio(portafoglio, x, 2);
                    conto = modificaConto(x, conto, 2);

                    System.out.println("Hai depositato i soldi con successo!!\nOra nel tuo portafoglio hai --> " + portafoglio + " euro");
                    System.out.println("Ora il tuo conto in banca è di --> " + conto + " euro");

                    break;
                }

                case 3: {
                    System.out.println("I soldi che hai all'interno del tuo conto in banca sono --> " + mostraSoldi(conto));
                    break;
                }
                case 4: {
                    System.out.println("I soldi che hai all'interno del tuo portafoglio sono --> " + mostraSoldi(portafoglio));
                    break;
                }

                case 5: {
                    
                	if (investimento) {
                        menu2();
                        String stringScelta2 = tastiera.nextLine();
                        int scelta2 = stringToInt(stringScelta2, 3,1);

                        while (scelta2 == -1) {
                            System.out.println("ERRORE!!");
                            System.out.println("RIINSERISCI LA SCELTA: ");
                            stringScelta2 = tastiera.nextLine();
                            scelta2 = stringToInt(stringScelta2, 3,1);
                        }

                        switch (scelta2) {
                            case 1:
                            	settimaneInvestimento=1;
                                break;
                            case 2:
                            	settimaneInvestimento=2;
                                break;
                            case 3:
                            	settimaneInvestimento=3;
                                break;
                        }

                        menu3();
                        double soldi ;
                        String stringScelta3 = tastiera.nextLine();
                        int scelta3 = stringToInt(stringScelta3, 3,1);

                        while (scelta3 == -1) {
                            System.out.println("ERRORE!!");
                            System.out.println("RIINSERISCI LA SCELTA: ");
                            stringScelta3 = tastiera.nextLine();
                            scelta3 = stringToInt(stringScelta3, 3,1);
                        }

                        
                        do {
                            System.out.println("Inserisci la quantità da investire: ");
                            String sSoldi = tastiera.nextLine();
                           soldi = stringToDouble(sSoldi);
                        } while (soldi < 0 || soldi > portafoglio);

                        int perc=0;
                        int soglia=0;
                        switch (scelta3) {
                        
                            case 1: {
                                perc = (int) (Math.random() * 10);
                                soglia=80;
                                break;
                            }
                            case 2: {
                                perc = (int) ((Math.random() * 40) + 10);
                                soglia=50;
                                break;
                            }
                            case 3: {
                                perc = (int) ((Math.random() * 50) + 50);
                                soglia=30;
                                break;
                            }
                        }

                        double guad = livelloinvestimenti(soglia, soldi, perc);
                        
                        investimento=false;
                        portafoglio = portafoglio -soldi;
                        guadagnoInvestimento = livelloinvestimenti(soglia, soldi, perc);
                        soldiInvestiti = soldi;  // Salva l'importo investito
                        percentualeInvestimento = perc;  // Salva la percentuale di guadagno/perdita
                        
                        
                        
	                        
                	}else {
                		System.out.println("non puoi investire più volte contemporaneamente");
                	}
                        


                  
                    
                    break;
                }

                
             
                //avanza di settimana
                
                case 6: {
                    
                    settimana++;
                    settimaneInvestimento--;
                    if (settimaneInvestimento == 0) {
                    	portafoglio = portafoglio  + guadagnoInvestimento;
                        // Stampa il risultato dell'investimento
                    	System.out.print("da un investimento precedente ");
                        if (guadagnoInvestimento < soldiInvestiti) {
                            System.out.println("hai perso il " + percentualeInvestimento + "%");
                        } else {
                            System.out.println("hai vinto il " + percentualeInvestimento + "%");
                        }
                        System.out.println("Investito: " + soldiInvestiti + " --> Guadagnato: " + guadagnoInvestimento);
                        System.out.println("Portafoglio: " + portafoglio);
                        
                        investimento = true;  // Rendi possibile un nuovo investimento
                    }

                    portafoglio = portafoglio + 100;  // Aggiungi 100 euro alla settimana
                    System.out.println("Una nuova settimana è iniziata! Ti sono stati aggiunti 100 euro. Ora hai " + portafoglio + " euro nel tuo portafoglio.");
                    break;
                }
                case 0: {
                    ciclo = false;
                    break;
                }
            } // switch

            System.out.println("\nPremi un tasto per continuare... ");
            tastiera.nextLine();
        } // ciclo

    } // main
} // class