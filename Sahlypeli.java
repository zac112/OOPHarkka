package sahlypeli;

import java.util.Scanner;

public class Sahlypeli {
    public static void main(String args[]) {
        Tuomari t = new Tuomari(50);
        Sahlyjoukkue j1 = luoJoukkue();
        Sahlyjoukkue j2 = luoJoukkue();
        
        PeliTila kentta= new PeliTila(j1, j2, t);
        
        kentta.kaynnistaPeli();
    }
    
    private static Sahlyjoukkue luoJoukkue(){
        Sahlyjoukkue j = new Sahlyjoukkue();
        Scanner s = new Scanner(System.in);
        System.out.println("Anna joukkueen nimi:");
        s.nextLine();
        for(int i=0; i< 1; i++){
            System.out.println("Anna pelaajan nimi");
            String nimi = s.nextLine();
            System.out.println("Anna pelaajan pelipaikka:");
            for(Pelipaikka pelip : Pelipaikka.values()){
                System.out.println(pelip.ordinal() + " " + pelip);
            }
            Pelipaikka pp = Pelipaikka.values()[s.nextInt()];
            System.out.println("Pelaaja on \n1) Ihminen\n2) Tietokone");
            int tietokone = s.nextInt();
            
            s.reset();
            
            Pelaaja p;
            if(tietokone == 2){
                p = new TietokonePelaaja(nimi, pp);
            }else{
                p = new IhmisPelaaja(nimi, pp);
            }

            j.lisaaPelaaja(p);
        }
        
        return j;
    }
    
}
