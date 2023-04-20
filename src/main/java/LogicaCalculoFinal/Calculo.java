package LogicaCalculoFinal;

import modelo.Participante;
import modelo.Partido;
import modelo.Pronostico;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Calculo {
    private List<Participante> participanteList;

    public List<Participante> instancidorParticipantes(List<String[]> listaPronosticosString) {
        participanteList = new ArrayList<>();
        //set para no repetir los nombres
        Set<String> setNombres = new HashSet<>();
        for (String[] pronosticoString : listaPronosticosString) {
            setNombres.add(pronosticoString[2]);
        }
        for (String nombre : setNombres) {
            Participante participante = new Participante(nombre);
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

                if (partidoEq1.equals(partidoPronosticoEq1) && partidoEq2.equals(partidoPronosticoEq2)) {
                    pronostico.setPartido(partido);
                    System.out.println("Pronostico " + participanteNombre + " => " + partidoEq1 + " " + pronostico.getResultado() + " vs " + partidoPronosticoEq2);
                    System.out.println("resultado real => " + partido.resultadoEquipo1());
                    System.out.println("puntos por acierto => " + pronostico.puntos() + "\n");
                }
            }
        }
    }

    public void agregarPuntosParticipante(List<Participante> participanteList, List<Pronostico> pronosticoList){
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
            System.out.println(participante.getNombre());
            System.out.println(participante.puntosTotales());

        }

    }
}






