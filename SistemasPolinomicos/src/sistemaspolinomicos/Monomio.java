
package sistemaspolinomicos;

/**
 *
 * @author Kevin
 */
public class Monomio {
    public double[] potencias;
    public double coeficiente;

    Monomio(String text) {
        potencias=new double[3];
        int inicioVariables;
        int lugarX=99;
        int lugarY=99;
        int lugarZ=99;
        
        if(text.contains("x")){
            potencias[0]=1;
            lugarX = text.indexOf("x");
            try{
            potencias[0]=Integer.valueOf(text.substring(lugarX+1,lugarX+2));
            } catch (Exception e){}
        }
        
        if(text.contains("y")){
            potencias[1]=1;
            lugarY = text.indexOf("y");
            try{
            potencias[1]=Integer.valueOf(text.substring(lugarY+1,lugarY+2));
            } catch (Exception e){}
        }
        
        if(text.contains("z")){
            potencias[2]=1;
            lugarZ = text.indexOf("z");
            try{
            potencias[2]=Integer.valueOf(text.substring(lugarZ+1,lugarZ+2));
            } catch (Exception e){}
        }
        
        
        inicioVariables=Math.min(Math.min(lugarX, lugarY), lugarZ);
        
        coeficiente=Double.valueOf(text.substring(0, inicioVariables));
        
        
        
    }
    
    public void print(){
        if (this.coeficiente>0)System.out.print("+");
        System.out.print(this.coeficiente);
        
        if(potencias[0]>0)System.out.print("x");
        if(potencias[0]>1)System.out.print(potencias[0]);
        
        if(potencias[1]>0)System.out.print("y");
        if(potencias[1]>1)System.out.print(potencias[1]);
        
        if(potencias[2]>0)System.out.print("y");
        if(potencias[2]>1)System.out.print(potencias[2]);
    }
    
    
    public double getDespejable(){
        double pow=0;
        for(int var=0;var<this.potencias.length;var++){
            if(pow==0)pow=potencias[var];
            else if(potencias[var]!=0)pow=-1;
        }
        return pow;
    }
    
    
}

