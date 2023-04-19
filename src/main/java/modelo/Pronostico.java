package modelo;

public class Pronostico {
	private String nro_ronda;
	private String participante;
	private Partido partido;
	private Equipo equipo1;
	private ResultadoEnum resultado;
	
	public Pronostico(Partido partido, Equipo equipo, DatosPronostico listaPronostico){
		this.partido = partido;
		this.equipo1 = equipo;
		if (listaPronostico.getGana1().equals("X")) {
			this.resultado = ResultadoEnum.GANADOR;
		}
		else if  (listaPronostico.getEmpate().equals("X")) {
			this.resultado = ResultadoEnum.EMPATE;
		} else {
			this.resultado = ResultadoEnum.PERDEDOR;
		}
	}
	public int puntos() {
		int puntos = 0;
		ResultadoEnum resultadoRealEquipo = this.partido.resultadoEquipo1();
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

	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public ResultadoEnum getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoEnum resultado) {
		this.resultado = resultado;
	}
  
}
