package modelo;

import java.util.ArrayList;
import java.util.List;

public class Participante {
    private String nombre;
    private List<Pronostico> pronosticos;

    public Participante(String nombre) {
        this.nombre = nombre;
        this.pronosticos = new ArrayList<>();
    }

    public int puntosTotales ( String nombre, List<Participante> listParticipantes){
        int total = 0;
        String nombrePart = "";
        for (int i = 0; i < listParticipantes.size(); i++){
            Participante participante = listParticipantes.get(i);
            String participanteNombre = listParticipantes.get(i).getNombre();

            if(participanteNombre.equals(nombre)){
                nombrePart = nombre;
                for (Pronostico proParticipanta : participante.getPronosticos())
                {
                   total+= proParticipanta.puntos();
                }
            }
        }
        System.out.println(total + " " + nombrePart );
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
