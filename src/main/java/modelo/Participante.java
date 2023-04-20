package modelo;

import java.util.ArrayList;
import java.util.List;

public class Participante {
    private String nombre;
    private List<Pronostico> pronosticos;
    public Participante(){};
    public Participante(String nombre) {
        this.nombre = nombre;
        this.pronosticos = new ArrayList<>();
    }

    public int puntosTotales ( ){
        int total = 0;
        for (Pronostico pronostico: pronosticos) {
            total+=pronostico.puntos();
        }
        return total;
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
