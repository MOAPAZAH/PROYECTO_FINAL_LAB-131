

public class CSCircularTigoMoney
{   private int fin,ini,max;
    private TigoMoney[]v = new TigoMoney[50];
    CSCircularTigoMoney()
    {   max = 50;
        ini = 0;
        fin = 0;  
    }
    boolean esVacia()
    {   
        if (nElem()==0) 
        return true;
        else return false;   
    }
    boolean esLlena()
    {   if (nElem()==(max-1)) 
        return true;
        else return false; 
    }
    void adicionar(TigoMoney x)
    {   if (!esLlena()) 
        {fin=(fin+1)%max;
         v[fin]=x;    
        }
        else System.out.println("Cola LLena");
    }
    TigoMoney eliminar()
    {   TigoMoney x=null;
        if (!esVacia()) 
        {ini=(ini+1)%max;
         x = v[ini];
        }
        else System.out.println("Cola Vacia ...");
        return x;
    }

    void vaciar(CSCircularTigoMoney B)
    {   while(!B.esVacia())
        {   adicionar(B.eliminar());
        }   
    }
    int nElem()
    { 
     return ((fin-ini+max)%max);
    }
    void saldoTigoMoney(String ci,int mon)
    {   TigoMoney x; int n=nElem(); int nn=0; boolean sw = false;
        if (!esVacia()) 
        {while(n>0)
         {x = null;
          x = eliminar();   n--;
             if (x.getCi().equals(ci)) 
             { x.setMonto((x.getMonto()- mon));  sw = true;  
             }
          nn++;
          adicionar(x);
         }  
        }
      
    }
  boolean estaRegistrado(String ci, int ncel)
   {   boolean sw = false;
       int n = this.nElem();
        while(n>0)
        {   TigoMoney dato = null;
            dato = this.eliminar();
            if (dato.getCi().equals(ci)||dato.getNroCelular() == ncel) 
            { sw = true;}
            n--;
            this.adicionar(dato);
        }
        return sw;
   }

}
