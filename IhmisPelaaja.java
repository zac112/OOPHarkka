package sahlypeli;

import java.util.Scanner;

public class IhmisPelaaja extends Pelaaja {
	
	 public IhmisPelaaja(String nimi, Pelipaikka paikka){
         super(nimi,paikka);
	 }
	 
	 public void pelaaVuoro(){
	     System.out.println("Olet "+paikka+". Sinulla "+ (pallo ? "on pallo." : "ei ole palloa.") +" Mitä teet?\n 1) Syötät.\n 2)Yrität maalia.\n 3)Hae maalintekopaikkaa.");
	     Scanner s = new Scanner(System.in);
	     int aie = s.nextInt();
	     switch(aie){
	         case 1://syötä
	             if(pallo){
	                 tila.syota(this);
	             }
	             maalintekopaikassa = false;
	             break;
	         case 2://maali
	             if(maalintekopaikassa && pallo){
	                 tila.lauoMaaliin(this);
	             }
	             maalintekopaikassa = false;
	             break;
	         case 3://haepaikkaa
	        	 haeMaalipaikkaa();
	             break;
	         default:
	             break;
	     }
	 }
	
}
