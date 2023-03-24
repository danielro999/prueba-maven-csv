package modelo;

public class Pronostico {
	private Partido partido;
	private Equipo equipo;
	private ResultadoEnum resultado;
	
	public int puntos() {
		int puntos = 0;
		ResultadoEnum resultadoRealEquipo = this.partido.resultado(this.equipo);
		if (resultadoRealEquipo == this.resultado) {
			puntos = 1;
		}
		return puntos;
	}
  
}
