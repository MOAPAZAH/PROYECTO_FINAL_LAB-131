


public class CSCircularTarjeta
{   private int fin,ini,max;
    private Tarjeta []v = new Tarjeta[50];
    CSCircularTarjeta()
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
    void adicionar(Tarjeta x)
    {   if (!esLlena()) 
        {fin=(fin+1)%max;
         v[fin]=x;    
        }
        else System.out.println("Cola LLena");
    }
    Tarjeta eliminar()
    {   Tarjeta x=null;
        if (!esVacia()) 
        {ini=(ini+1)%max;
         x=v[ini];

        }
        else System.out.println("Cola Vacia ...");
        return x;
    }
    boolean cargarTarjeta(String ci,int mon)
    {   Tarjeta x; int n=nElem(); int nn=0; boolean sw = false;
        if (!esVacia()) 
        {while(n>0)
         {x = null;
          x = eliminar();   n--;
             if (x.getCIT().equals(ci)) 
             { x.setMONTOT((x.getMONTOT()+mon));  sw = true;  
             }
          nn++;
          adicionar(x);
         }  
        }
        return sw;
    }

    void vaciar(CSCircularTarjeta B)
    {   while(!B.esVacia())
        {   adicionar(B.eliminar());
        }   
    }
    int nElem()
    { 
     return ((fin-ini+max)%max);
    }
    /*void llenarEnteros(int n)
    { super.llenaEnteros((n+1));
    }*/
}
