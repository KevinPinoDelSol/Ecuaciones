
package sistemaspolinomicos;

import java.util.Scanner;

/**
 *
 * @author Kevin
 */
public class SistemasPolinomicos {
    public Ecuacion[] ec;
    public Variable[] var;
    
    
    public static void main(String[] args) {
        Scanner read=new Scanner(System.in);
//        System.out.println("Introduzca todas las variables separadas por un unico espacio.");
  //      String EntradaVariables=read.nextLine();
        
        System.out.println("Diga la cantidad de ecuaciones");
        short numeroEcuacion=read.nextShort();
        Ecuacion[] ec=new Ecuacion[numeroEcuacion];
        for(int i=0;i<numeroEcuacion;i++){
            System.out.println("Diga la ecuacion numero "+(i+1)+" igualada a 0.");
            String text=read.nextLine();
            ec[i]=new Ecuacion(text);
        }
            
        
        
        SistemasPolinomicos sistema=new SistemasPolinomicos(ec);
        
    }
    
    public static boolean IsNumber(char x){
        if(x=='1'||x=='2'||x=='3'||x=='4'||x=='5'||x=='6'||x=='7'||x=='8'||x=='9'||x=='0')
            return true;
        else
            return false;
    }

    private SistemasPolinomicos(Ecuacion[] ec) {
        this.ec=ec;
    }
    
    /*public double[][] respuestas(){
        short count=0;
        for(int i=0 ; i<3;){
            
        }
    }*/
}

