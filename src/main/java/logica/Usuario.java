package logica;

import java.time.LocalDate;
import datatypes.DtClase;
import datatypes.DtUsuario;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@DiscriminatorColumn(name="TIPOUSUARIO")
public abstract class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Nickname")
    protected String nickname;
    protected String nombre;
    protected String apellido;
    protected String email;
    @Temporal(TemporalType.DATE)
    protected LocalDate fecNac;


    public Usuario(){
        super();
    }

    public Usuario(String nickname, String nombre, String apellido, String email, LocalDate fecNac){
        super();
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fecNac = fecNac;
    }
    
    public abstract DtUsuario getDtUsuario();

    public String getNickname(){
        return this.nickname;
    }

    public void setNickname(String nickname){
        this.nickname =  nickname;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public LocalDate getFecNac(){
        return this.fecNac;
    }

    public void setFecNac(LocalDate fecNac){
        this.fecNac = fecNac;
    }


}

