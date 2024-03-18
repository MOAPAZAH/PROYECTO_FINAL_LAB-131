
public class Usuarios {
    private String nombre;
    private String telefono;
    private String direccion;
    private int edad;
    private String sexo;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public Usuarios(String nombre, String telefono, String direccion, int edad, String sexo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.edad = edad;
        this.sexo = sexo;
    }
}
