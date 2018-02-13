package sahlypeli;

import java.util.HashMap;
import java.util.Random;

public class PeliTila {
	//joukkue -> maalit
    private HashMap<Sahlyjoukkue, Integer> maalit;
    
    private boolean peliKaynnissa = false;
    private final Sahlyjoukkue[] joukkueet;
    private final Tuomari t;
    private Random rand = new Random();
    
    public PeliTila(Sahlyjoukkue j1,Sahlyjoukkue j2, Tuomari t){
        maalit = new HashMap<>();
        maalit.put(j1, 0);
        maalit.put(j2, 0);
        this.t = t;
        
        joukkueet = new Sahlyjoukkue[]{j1, j2};
        
        j1.asetaPelitila(this);
        j2.asetaPelitila(this);
    }
    
    public void lauoMaaliin(Pelaaja laukoja){
        haeVastaJoukkue(laukoja).vastaanotaLaukaus(laukoja);
    } 
    
    public void syota(Pelaaja syottaja){
        Pelaaja vastaanottaja;
        if(rand.nextInt(100) < 20){
            System.out.println("Syöttösi epäonnistui!");
            //joka viides syöttö epäonnistuu
            vastaanottaja = haeVastaJoukkueenSatunnainenPelaaja(syottaja);
        }else{
            System.out.println("Syöttösi onnistui!");
            vastaanottaja = haeJoukkueenSatunnainenPelaaja(syottaja);
        }
        vastaanottaja.asetaPallo(true);
        syottaja.asetaPallo(false);
    }
    
    private Pelaaja haeVastaJoukkueenSatunnainenPelaaja(Pelaaja p){
        Pelaaja tulos = null;
        while (tulos == null || tulos == p){
            tulos = haeVastaJoukkue(p).annaSatunnainenPelaaja();
        }
        return tulos;
    }
    
    private Pelaaja haeJoukkueenSatunnainenPelaaja(Pelaaja p){
        Pelaaja tulos = null;
        while (tulos == null || tulos == p){
            tulos = haeJoukkue(p).annaSatunnainenPelaaja();
        }
        return tulos;
    }
    
    public void teeMaali(Pelaaja p){
        maalit.put(haeJoukkue(p), maalit.get(haeJoukkue(p))+1);
        System.out.println(p+ "teki maalin! Tilanne on nyt "+maalit);
    }
    
    public boolean onkoKaynnissa(){
        return peliKaynnissa;
    }
    
    public void kaynnistaPeli(){
        peliKaynnissa = true;
        int vuoro = 0;
        
        joukkueet[rand.nextInt(2)].annaSatunnainenPelaaja().asetaPallo(true);
        
        while(onkoKaynnissa() && vuoro < 100){
            joukkueet[vuoro++ % joukkueet.length].pelaaVuoro();
        }
    }
    
    public void lopetaPeli(){
        peliKaynnissa = false;
    }
    
    private Sahlyjoukkue haeJoukkue(Pelaaja p){
        for(Sahlyjoukkue j : joukkueet){
            if(j.onkoJoukkueenPelaaja(p))
                return j;
        }
        
        //ei pitäisi koskaan tapahtua...
        throw new JoukkueetonPelaajaPoikkeus();
    }
    private Sahlyjoukkue haeVastaJoukkue(Pelaaja p){
        for(Sahlyjoukkue j : joukkueet){
            if(!j.onkoJoukkueenPelaaja(p))
                return j;
        }
        
        //ei pitäisi koskaan tapahtua...
        throw new JoukkueetonPelaajaPoikkeus();
    }
}
