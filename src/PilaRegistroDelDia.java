
import java.util.Scanner;
public class PilaRegistroDelDia {
    //ATRIBUTOS
    private int tope,max;
    private RegistroDelDia []v = new RegistroDelDia [50];
    //CONSTRUCTOR
    public PilaRegistroDelDia()
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
   void adicionar(RegistroDelDia item)
   {if (!esLlena()) 
       {    tope++;
            v[tope]=item;
       }
   else System.out.println(" Pila llena");
   }
   RegistroDelDia eliminar()
   { RegistroDelDia item=null;
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
   void vaciar(PilaRegistroDelDia T)
   { while(!T.esVacia())
     {  this.adicionar(T.eliminar());
     }
   }
   
}
