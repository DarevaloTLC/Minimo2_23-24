package edu.upc.dsa.models;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FormData {
    private String nombre;
    private String email;
    private String mensaje;

    // Constructor
    public FormData() {
    }

    public FormData(String nombre, String email, String mensaje) {
        this.nombre = nombre;
        this.email = email;
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
