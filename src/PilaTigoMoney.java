

import java.util.Scanner;
public class PilaTigoMoney {
    //ATRIBUTOS
    private int tope,max;
    private TigoMoney[]v = new TigoMoney[50];
    //CONSTRUCTOR
    public PilaTigoMoney()
    {   this.max=50;
        this.tope=0;
    }
    //METODOS
   boolean esLlena()
   {if (this.tope==this.max)
      return true;
        else return false;
   }
   boolean esVacia()
   {if (this.tope==0) 
       return true;
       else return false;
   }
   void adicionar(TigoMoney item)
   {if (!esLlena()) 
       {    tope++;
            v[tope]=item;
       }
   else System.out.println(" Pila llena");
   }
   TigoMoney eliminar()
   { TigoMoney item=null;
       if (esVacia()) 
       System.out.println("Pila Vacia");
       else {item=v[tope];  tope--;
       }   
       return item;
   }
   int nroElem()
   {    return this.tope;
   }
   void vaciar(PilaTigoMoney T)
   { while(!T.esVacia())
     {  this.adicionar(T.eliminar());
     }
   }
   int estaRegistrado(String ci, int ncel)
   {   int sw = 0;
       PilaTigoMoney au = new PilaTigoMoney();
        while(!this.esVacia())
        {   TigoMoney dato = null;
            dato = this.eliminar();
            if (dato.getCi().equals(ncel)) 
            { sw++;}
            if (dato.getNroCelular() == ncel)
            { sw++;}  
        }
        this.vaciar(au); 
        
        return sw;
   }
   
}
