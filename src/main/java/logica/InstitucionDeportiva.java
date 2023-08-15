package logica;

public class InstitucionDeportiva {
    private String nombre;
    private String descripcion;
    private String url;


    public InstitucionDeportiva(){
        super();
    }

    public InstitucionDeportiva(String nombre, String descripcion, String url){
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getUrl(){
        return this.url;
    }

    public void setUrl(String url){
        this.url = url;
    }
}
