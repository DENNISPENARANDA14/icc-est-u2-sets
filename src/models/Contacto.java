package models;

public class Contacto {
    private String nombre;
    private String Apellido;
    private String telefono;
    
    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        Apellido = apellido;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    

    @Override
    public int hashCode() {
        return nombre.hashCode() + Apellido.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contacto other = (Contacto) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Contacto [nombre=" + nombre + ", Apellido=" + Apellido + ", telefono=" + telefono + "]";
    }

    
    
}
