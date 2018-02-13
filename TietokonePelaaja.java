package sahlypeli;

public class TietokonePelaaja extends Pelaaja {
	
    public TietokonePelaaja(String nimi, Pelipaikka paikka){
        super(nimi,paikka);
	}
	
	public void pelaaVuoro(){
	    if(pallo && maalintekopaikassa){
	        tila.lauoMaaliin(this);
	        maalintekopaikassa = false;
	    }else if( pallo & !maalintekopaikassa){
	        tila.syota(this);
	        maalintekopaikassa = false;
	    }else{
	        haeMaalipaikkaa();
	    }
	}
	
}
