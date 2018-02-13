package sahlypeli;

import java.util.Random;

public abstract class Pelaaja {
	private String nimi;
    protected Pelipaikka paikka;
    protected boolean maalintekopaikassa = false;
    protected boolean pallo = false;
    private int taitotaso;
    private Random rand;
    protected PeliTila tila;
    
    public Pelaaja(String nimi, Pelipaikka paikka){
        this.paikka = paikka;
        rand = new Random();
        taitotaso = rand.nextInt(50)+50;
        this.nimi = nimi;
    }
    
    public abstract void pelaaVuoro();
    
    public void asetaPeliTila(PeliTila tila){
         this.tila = tila;
    }
    
    public PeliTila annaTila(){
        return tila;
    }
    
    public boolean onkoParempi(Pelaaja p){
        return this.taitotaso + rand.nextInt(10) > p.taitotaso + rand.nextInt(10);
    }

    public void asetaPallo(boolean onkoPallo){
        System.out.println(nimi+" sai pallon!");
        this.pallo = onkoPallo;
    }
    public boolean equals(Object o){
        return o == this;
    }
    public Pelipaikka annaPelipaikka(){
        return paikka;
    }
    
    protected void haeMaalipaikkaa(){
        maalintekopaikassa = true;
        System.out.println(this+" haki maalipaikkaa!");
    }
    
    public String toString(){
    	return nimi;
    }
}
