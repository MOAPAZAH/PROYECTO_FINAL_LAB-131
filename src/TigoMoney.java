


public class TigoMoney 
{   //ATRIBUTOS
    private String ci;
    private String nombre;
    private int monto;
    private int codigoSeguridad;
    private int nroCelular;
    //GETTER Y SETTER
    String getCi()
    {   return this.ci;}
    String getNombre()
    {   return this.nombre;}
    int getMonto()
    {   return this.monto;}
    int getNroCelular()
    {   return this.nroCelular;}
    int getCodigoSeguridad()
    {   return this.codigoSeguridad;}
    void setMonto(int x)
    {   this.monto = this.monto;}
    //CONTRUCTOR
    public TigoMoney(String c,String nom,int mon,int segu,int cel)
    {   this.ci = c;
        this.nombre = nom;
        this.monto = mon;
        this.codigoSeguridad = segu;
        this.nroCelular = cel;
    }
    

}
