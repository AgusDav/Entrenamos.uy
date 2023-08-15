package logica;

import java.time.LocalDate;
import java.time.LocalTime;

public class Clase {
    private String nombre;
    private LocalDate fecha;
    private LocalTime hora;
    private String url;
    private LocalDate fechaReg;


    public Clase(){
        super();
    }

    public Clase(String nombre, LocalDate fecha, LocalTime hora, String url, LocalDate fechaReg){
        super();
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.url = url;
        this.fechaReg = fechaReg;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public LocalDate getFecha(){
        return this.fecha;
    }

    public void setFecha(LocalDate fecha){
        this.fecha = fecha;
    }

    public LocalTime getHora(){
        return this.hora;
    }

    public void setHora(LocalTime hora){
        this.hora = hora;
    }

    public String getUrl(){
        return this.url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public LocalDate getFechaReg(){
        return this.fechaReg;
    }

    public void setFechaReg(LocalDate fechaReg){
        this.fechaReg = fechaReg;
    }

}
