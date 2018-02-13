package sahlypeli;

import java.util.ArrayList;
import java.util.Random;

public class Sahlyjoukkue {
    
    ArrayList<Pelaaja> pelaajat;
    
    public Sahlyjoukkue(){
        pelaajat = new ArrayList<Pelaaja>();
    }
    
    public void lisaaPelaaja(Pelaaja p){
        pelaajat.add(p);
    }
    
    public void pelaaVuoro(){
        for(Pelaaja p : pelaajat){
            p.pelaaVuoro();
        }
    }
    public boolean onkoJoukkueenPelaaja(Pelaaja p){
        return pelaajat.contains(p);
    }
    
    public Pelaaja annaSatunnainenPelaaja(){
        Random r = new Random();
        return pelaajat.get(r.nextInt(pelaajat.size()));
    }
    
    public boolean vastaanotaLaukaus(Pelaaja p){
        try{
            Pelaaja maalivahti = etsiMaalivahti();
            if(p.onkoParempi(maalivahti)){
                p.annaTila().teeMaali(p);
                return true;
            }
            System.out.println("Maalia ei tullut!");
            return false;
        }catch(EiMaalivahtiaPoikkeus e){
            p.annaTila().teeMaali(p);
            //maalinteko onnistuu aina, jos maalivahtia ei ole
            return true;
        }
    }
    
    private Pelaaja etsiMaalivahti(){
        for(Pelaaja p : pelaajat){
            if (p.annaPelipaikka()==Pelipaikka.MAALIVAHTI)
                return p;
        }
        
        throw new EiMaalivahtiaPoikkeus();
    }

	public void asetaPelitila(PeliTila peliTila) {
		for(Pelaaja p : pelaajat){
			p.asetaPeliTila(peliTila);
		}
	}
}
