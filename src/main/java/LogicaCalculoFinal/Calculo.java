package LogicaCalculoFinal;

import modelo.Participante;
import modelo.Partido;
import modelo.Pronostico;
import serealizacion.ConfigPuntos;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Calculo {
    private List<Participante> participanteList;

    public List<Participante> instancidorParticipantes(List<String[]> listaPronosticosString, ConfigPuntos configPuntos) {
        participanteList = new ArrayList<>();
        //set para no repetir los nombres de participantes
        Set<String> setNombres = new HashSet<>();
        // set(sin repetid) con los nombres de los participantes
        for (String[] pronosticoString : listaPronosticosString) {
            setNombres.add(pronosticoString[2]);
        }
        // por cada String con el nombre creo una instancia de Participante,  mas los puntajes que se le van a sumar por acierto
        for (String nombre : setNombres) {
            Participante participante = new Participante(nombre, configPuntos);
            participanteList.add(participante);
        }
        return participanteList;
    }

    public void puntosPorPartido(List<Pronostico> pronosticoList, List<Partido> partidoList) {

        for (Pronostico pronostico : pronosticoList) {
            for (Partido partido : partidoList) {
                String partidoEq1 = partido.getEquipo1().getNombre();
                String partidoEq2 = partido.getEquipo2().getNombre();
                String partidoPronosticoEq1 = pronostico.getEquipo1().getNombre();
                String partidoPronosticoEq2 = pronostico.getEquipo2().getNombre();
                String participanteNombre = pronostico.getParticipante();
                String fase = pronostico.getFase();
                String ronda = pronostico.getNro_ronda();

                if (partidoEq1.equals(partidoPronosticoEq1) && partidoEq2.equals(partidoPronosticoEq2)) {
                    pronostico.setPartido(partido);
                    System.out.println( participanteNombre + " "+ fase + " " + ronda + " " + partidoEq1 + " "
                            + pronostico.getResultado() + " vs " + partidoPronosticoEq2 + " "
                            + "resultado real => " + partido.resultadoEquipo1()
                            + " puntos => " + pronostico.puntos());
                }
            }
        }
        System.out.println("\n");
    }

    public void agregarPronosticosParticipante(List<Participante> participanteList, List<Pronostico> pronosticoList){
        for (Participante participante: participanteList) {
//			System.out.println("nombre " +participante.getNombre());
            for (Pronostico pronostico: pronosticoList) {
                if(participante.getNombre().equals(pronostico.getParticipante())){
                    participante.getPronosticos().add(pronostico);
//					System.out.println(participante.getNombre() + " " + pronostico.puntos());
                }
            }
        }
    }

    public void puntosFinalParticipantes(List<Participante> participanteList) {
        for (Participante participante : participanteList) {
            int puntoExtras =  participante.puntosExtras();
            int puntosPartidos = participante.puntosPartidos();
            int total = puntosPartidos + puntoExtras;
            String nombreParticipante = participante.getNombre();
            System.out.println( nombreParticipante +" puntos por partidos " + puntosPartidos + " + " + "puntos Extras " +puntoExtras + " = " + total + "\n");

        }

    }
}






