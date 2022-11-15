package sistemaspolinomicos;

/**
 *
 * @author Kevin
 */
public class Ecuacion {
    Monomio[] MI;
    Monomio [] MD;
    
    public Ecuacion(String texto){
        short count=1;
        
        for(int i=1 ; texto.charAt(i)!='=' ; i++){
            if(texto.charAt(i)=='+'||texto.charAt(i)=='-')
                count++;
        }
        MI=new Monomio[count];
        
        count=1;
        for(int i=texto.indexOf("=") ; i<texto.length() ; i++){
            if(texto.charAt(i)=='+'||texto.charAt(i)=='-')
                count++;
        }
        MD=new Monomio[count];
        
        count=0;
        
        int readerPoint=1;
        int leftSide=0;
        do{
            if((texto.charAt(readerPoint)=='+'
                    ||texto.charAt(readerPoint)=='-'
                    ||texto.charAt(readerPoint)=='='))
            {
                MI[count]=new Monomio(texto.substring(leftSide, readerPoint));
                leftSide=readerPoint;
            }
            
            readerPoint++;
        }while(texto.charAt(readerPoint)!='=');
        
    }
    public double[] getSmallestPow(){
        double[] pows={99,99,99};
        
        
        for(int monomio=0;monomio<MI.length;monomio++){
            for(int variable=0;variable<3;variable++){
                pows[variable]=Math.min(pows[variable], MI[monomio].potencias[variable]);
            }
        }
        return pows;
    }
    public void reduxPow(){
        double[] redux=this.getSmallestPow();
        
        for(int monomio=0;monomio<MI.length;monomio++){
            for(int variable=0;variable<3;variable++){
                MI[monomio].potencias[variable]-=redux[variable];
            }
        }
    }
    public int PuedeFactorComun(){
        double[] potencias={MI[0].potencias[0],MI[0].potencias[1],MI[0].potencias[2]};
        int respuesta=-1;
        
        for (int monomio = 1; monomio < MI.length; monomio++) {
            for (int variable = 0; variable < 10; variable++) {
                if(MI[monomio].potencias[variable]!=potencias[variable])potencias[variable]=Double.MAX_VALUE;
            }
        }
        
        for (int i = 0; i < 3; i++) {
            if(potencias[i]!=Double.MAX_VALUE)respuesta=i;
        }
        return respuesta;
    }
    
}