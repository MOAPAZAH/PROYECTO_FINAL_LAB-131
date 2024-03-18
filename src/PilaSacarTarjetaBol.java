
import java.util.Scanner;
public class PilaSacarTarjetaBol {
    //ATRIBUTOS
    private int tope,max;
    private SacarTarjetaBol []v = new SacarTarjetaBol[50];
    //CONSTRUCTOR
    public PilaSacarTarjetaBol()
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
   void adicionar(SacarTarjetaBol item)
   {if (!esLlena()) 
       {    tope++;
            v[tope]=item;
       }
   else System.out.println(" Pila llena");
   }
   SacarTarjetaBol eliminar()
   { SacarTarjetaBol item=null;
       if (esVacia()) 
       System.out.println("Pila Vacia");
       else {item=v[tope];  tope--;
       }   
       return item;
   }
   int nroElem()
   {    return this.tope;
   }
   /*void mostrar()
   {  Pila aux=new Pila(this.max);
      while(!esVacia())
      {  aux.adicionar(eliminar());
      }
      while(!aux.esVacia())
      { RegistroDelDia  dato=null;
        dato=aux.eliminar();
        dato.mostrar();
        adicionar(dato);
      }
   }*/
   void vaciar(PilaSacarTarjetaBol T)
   { while(!T.esVacia())
     {  this.adicionar(T.eliminar());
     }
   }
   
}
