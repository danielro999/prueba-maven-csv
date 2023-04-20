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
    public int puntosPartidos( ){
        int total = pronosticos.stream().mapToInt ( s -> s.getPuntos()).sum();
        return total;
    }
    public int puntosExtras(){
        int puntosExtras = 0;
//        recorro cada uno de lod pronosticos
        for (int i = 0; i < this.pronosticos.size(); i++)
        {
            Pronostico pronosticoActua = this.pronosticos.get(i);
//			    obtengo en que ronda esta actualmente en pronostico "i"
            String nroRonda = pronosticoActua.getNro_ronda();
//			    teniendo el numero de ronda sumo cada punto de esa ronda
            int sumaPuntosPorRonda = this.pronosticos.stream().filter(s -> s.getNro_ronda().equals(nroRonda)).mapToInt(e -> e.getPuntos()).sum();
//			    obtendo el numero de rondas (cuantos partidos en ronda nro1 hay, lo mismo en la 2 y en las siguentes)
            int partidosPorRonda = this.pronosticos.stream().filter(s -> s.getNro_ronda().equals(nroRonda)).mapToInt(e -> 1).sum();
            if (sumaPuntosPorRonda == partidosPorRonda && partidosPorRonda == Integer.parseInt(nroRonda)){
                puntosExtras += 1 ;
            }
        }
        return puntosExtras;
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
