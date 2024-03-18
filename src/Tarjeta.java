public class Tarjeta 
{   //ATRIBUTOS
    private String ciT;
    private String nombreT;
    private int montoT;
    //GETTER Y SETTER 
    String getCIT()
    { return this.ciT;}
    int getMONTOT()
    { return this.montoT;}
    String getNOMBRET()
    {return this.nombreT;}
    void setMONTOT(int x)
    { this.montoT = this.montoT+x;}
    //CONTRUCTOR
    public Tarjeta(String ciT,String nom,int mont)
    {   this.ciT = ciT;
        this.nombreT = nom;
        this.montoT = mont;
    }
    
    

}
