
public class RegistroDelDia {
    //ATRIBUTOS
    private String nombreR;
    private String  CIR;
    private String tipoR;
    private int montoR;
    private String fecha,hora;
    //CONSTRUCTOR
    public RegistroDelDia(String nombreR,String CIR,String tipoR,int montoR,String fe,String ho)
    { this.nombreR = nombreR;
      this.CIR = CIR;
      this.tipoR = tipoR;
      this.montoR = montoR;
      this.fecha = fe;
      this.hora = ho;
    }
    //GETTER Y SETTER
    String getNombreR()
    {   return this.nombreR;}
    String getCIR()
    {   return this.CIR;}
    String getTipoR()
    {   return this.tipoR;}
    String getMontoR()
    {   String dato = ""+this.montoR;
        return dato;
    }
    String getFecha()
    {   return this.fecha;}
    String getHora()
    {   return this.hora;}
    void setNombreR(String dato)
    {   this.nombreR = dato;}
    void setCIR(String dato)
    {   this.CIR = dato;}
    void setTipoR(String dato)
    {   this.tipoR= dato;}
    void setMontoR(int dato)
    {   this.montoR = dato;}
   
}
