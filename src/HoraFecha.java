import java.util.Calendar;
public class HoraFecha {
    private String fecha,hora;
    public HoraFecha()
    { Calendar cal = Calendar.getInstance();
        this.fecha = cal.get(Calendar.DATE)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR);
        this.hora = cal.get(cal.HOUR_OF_DAY)+":"+cal.get(cal.MINUTE)+":"+cal.get(cal.SECOND);  
    }
    String getFecha()
    {return this.fecha;}
    String getHora()
    {return this.hora;}
    
}
