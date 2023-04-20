package modelo;

public class Pronostico {
	private String nro_ronda;
	private Participante participante;
	private Partido partido;
	private Equipo equipo1;
	private ResultadoEnum resultado;
	private Equipo equipo2;

	private int puntos;

	public Pronostico(String nro_ronda, Participante participante, Equipo equipo1, String resultado, Equipo equipo2){
		this.nro_ronda = nro_ronda;
		this.participante = participante;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		if (resultado.equals("GANADOR")) {
			this.resultado = ResultadoEnum.GANADOR;
		}
		else if  (resultado.equals("EMPATE")) {
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
		this.puntos = puntos;

		return puntos;
	}

	public Equipo getEquipo2() {return equipo2;}

	public void setEquipo2(Equipo equipo2) {this.equipo2 = equipo2;}

	public String getNro_ronda() {return nro_ronda;}

	public void setNro_ronda(String nro_ronda) {this.nro_ronda = nro_ronda;}

	public Participante getParticipante() {return participante;}

	public void setParticipante(Participante participante) {this.participante = participante;}

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
