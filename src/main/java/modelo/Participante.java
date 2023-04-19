package modelo;

import java.util.ArrayList;
import java.util.List;

public class Participante {
    private String nombre;

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    private List<Pronostico> pronosticos;

    public Participante(String nombre) {
        this.nombre = nombre;
        this.pronosticos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
