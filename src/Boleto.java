


public class Boleto 
{    //ATRIBUTOS
    private int ciB;
    private String nombreB;
    private double montoB;
    private boolean recogio;
    //GETTER Y SETTER
    int getCi()
    {   return this.ciB;}
    String getNombre()
    {   return this.nombreB;}
    double getmonto()
    {   return this.montoB;}
    boolean getRecogio()
    {   return this.recogio;}
    void setCi(int x)
    {   this.ciB = x;}
    void setNombre(String x)
    {   this.nombreB = x;}
    void setMonto(double x)
    {   this.montoB = x;}
    void setMonto(boolean x)
    {   this.recogio = x;}
}
