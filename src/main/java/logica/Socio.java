package logica;

import datatypes.DtFecha;

import java.time.LocalDate;

public class Socio extends Usuario{
    public Socio(String n, String nom, String a, String e, LocalDate f) {
        super(n, nom, a, e, f);
    }
}