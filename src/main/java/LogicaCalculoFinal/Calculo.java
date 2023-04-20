package LogicaCalculoFinal;

import modelo.Equipo;
import modelo.Participante;
import modelo.Partido;
import modelo.Pronostico;

import java.util.ArrayList;
import java.util.List;

public class Calculo {
    private List<Participante> participanteList;
    private List<Pronostico> pronosticoList;
    public List<Pronostico> crearPronosticosList(List<String[]> listaPronosticosString){
    //      pronostico = {fase, nro_ronda, nombre, id_Equipo1, resultado, id_Equipo2 }
            pronosticoList = new ArrayList<>();
            for (String[] pronosticoString : listaPronosticosString) {
                Participante participante = new Participante(pronosticoString[2]);
                Equipo equipo1 = new Equipo(pronosticoString[3]);
                Equipo equipo2 = new Equipo(pronosticoString[5]);

               // System.out.println(equipo1.getNombre()+" "+equipo2.getNombre());
                Pronostico pronostico = new Pronostico(pronosticoString[1],participante,equipo1,pronosticoString[4],equipo2);
            pronosticoList.add(pronostico);
            }
        return pronosticoList;
    }

    public void puntosPorPartido (List<Pronostico> pronosticoList, List<Partido> partidoList){
        for (Pronostico pronostico: pronosticoList) {

            for (Partido partido:partidoList) {
                String partidoEq1 = partido.getEquipo1().getNombre();
                String partidoEq2 = partido.getEquipo2().getNombre();
                String partidoPronosticoEq1 = pronostico.getEquipo1().getNombre();
                String partidoPronosticoEq2 = pronostico.getEquipo2().getNombre();
                String participanteNombre = pronostico.getParticipante().getNombre();

                if (partidoEq1.equals(partidoPronosticoEq1) && partidoEq2.equals(partidoPronosticoEq2)){
                    pronostico.setPartido(partido);
                    System.out.println("Pronostico " + participanteNombre +" => " + partidoEq1+ " " + pronostico.getResultado()+ " vs " + partidoPronosticoEq2);
                    System.out.println( "resultado real => " + partido.resultadoEquipo1());
                    System.out.println("puntos => " + pronostico.puntos()+ "\n");
                }
            }
        }
    }

    public void puntosTotales(String participante, int multiplicador ){
        int total = 0;
        for (Pronostico pronostico: pronosticoList) {
            if (participante.equals(pronostico.getParticipante().getNombre())){
                total += pronostico.puntos()*multiplicador;
            }
        }
        System.out.println(participante+ " " + total);

    }








//    public List<Participante> puntoIndividual (List<Partido> listaResulPartidos, List<String[]> listaPronosticos){
//        listParticipantes = new ArrayList<>();
//        Participante participante = new Participante(listaPronosticos.get(0)[2]);
//
//        for (String[] pronostico : listaPronosticos) {
//            //pronostico = {fase, nro_ronda, nombre, id_Equipo1, resultado, id_Equipo2 }
//            if(participante.getNombre().equals(pronostico[2])){
//                participante = null;
//            }
//            else {
//                participante = new Participante(pronostico[2]);
//            }
//          //  System.out.println(participante.getNombre());
//            Equipo equipo1 = null;
//            Equipo equipo2 = null;
//
//            for (Partido partido : listaResulPartidos) {
//                if (partido.getEquipo1().getNombre().equals(pronostico[3]) && partido.getEquipo2().getNombre().equals(pronostico[5])) {
//                    equipo1 = partido.getEquipo1();
//                    equipo2 = partido.getEquipo2();
//                }
//            }
//
//            Pronostico pronosticoParticipante = new Pronostico(pronostico[1], participante, equipo1, pronostico[4], equipo2);
//
//            for (Partido partido : listaResulPartidos) {
//                String partidoEq1 =partido.getEquipo1().getNombre();
//                String partidoEq2 =partido.getEquipo2().getNombre();
//                String partidoPronosticoEq1 = pronosticoParticipante.getEquipo1().getNombre();
//                String partidoPronosticoEq2 = pronosticoParticipante.getEquipo2().getNombre();
//              //  String participanteNombre = pronosticoParticipante.getParticipante().getNombre();
//
//                if (partidoEq1.equals(partidoPronosticoEq1) && partidoEq2.equals(partidoPronosticoEq2))
//                {
//                    pronosticoParticipante.setPartido(partido);
////                    System.out.println("Pronostico " + partici +" => " + partidoEq1+ " " + pronosticoParticipante.getResultado()+ " vs " + partidoPronosticoEq2);
////                    System.out.println( "resultado real => " + partido.resultadoEquipo1());
////                    System.out.println("puntos => " + pronosticoParticipante.puntos()+ "\n");
//
//                    participante.getPronosticos().add(pronosticoParticipante);
//                    listParticipantes.add(participante);
//                }
//            }
//        }
//        return listParticipantes;
//    }


}
