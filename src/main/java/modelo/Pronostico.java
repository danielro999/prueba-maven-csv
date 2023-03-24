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

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public ResultadoEnum getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoEnum resultado) {
		this.resultado = resultado;
	}
  
}
