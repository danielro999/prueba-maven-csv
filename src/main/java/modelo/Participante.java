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
        this.pronosticos = new ArrayList<>();
    }


}
