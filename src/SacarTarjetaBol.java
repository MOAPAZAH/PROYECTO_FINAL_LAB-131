
public class SacarTarjetaBol {
    //ATRIBUTOS
    private String nombreR;
    private String  CIR;
    private String tipoR;
    private int montoR;
    private String fecha;
    private String hora;
    private int contraseña;
    //CONSTRUCTOR
    public SacarTarjetaBol(String nombreR,String CIR,String tipoR,int montoR,String fe,String ho,int con)
    { this.nombreR = nombreR;
      this.CIR = CIR;
      this.tipoR = tipoR;
      this.montoR = montoR;
      this.fecha = fe;
      this.hora = ho;
      this.contraseña = con;
    }
    //GETTER Y SETTER
    String getNombreR()
    {   return this.nombreR;}
    String getCIR()
    {   return this.CIR;}
    String getTipoR()
    {   return this.tipoR;}
    String getFecha()
    {   return this.fecha;}
    String getHora()
    {   return this.hora;}
    int getContraseña()
    {   return this.contraseña;}
    int getMontoR()
    {   return this.montoR;}
    void setNombreR(String dato)
    {   this.nombreR = dato;}
    void setCIR(String dato)
    {   this.CIR = dato;}
    void setTipoR(String dato)
    {   this.tipoR= dato;}
    void setMontoR(int dato)
    {   this.montoR = dato;}
   
}
