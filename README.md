# prueba-maven-csv

<h3>Esquemas<h3>

[Link esquema](https://drive.google.com/file/d/1b2Ss12_kjdYnmFD2imOndcH2X94pTYT8/view?usp=sharing)
  


<h3> Sentencias basicas SQL <h3>
  
  ~~~
CREATE DATABASE prode; 
  
CREATE TABLE prode.equipo(
    id_equipo INT PRIMARY KEY AUTO_INCREMENT,
    nombre CHAR(50),
    descripcion CHAR(100)); 

CREATE TABLE prode.participante(
    id_participante INT PRIMARY KEY AUTO_INCREMENT,
    nombre CHAR(50)); 

CREATE TABLE prode.ronda(
    nro_ronda INT PRIMARY KEY AUTO_INCREMENT,
    nombre_fase CHAR(80)); 

CREATE TABLE prode.pronostico(
id_pronostico INT PRIMARY KEY AUTO_INCREMENT,
    id_participante INT,
    nro_ronda INT,
    id_equipo1 INT,
    id_equipo2 INT,
    resultado CHAR(8),
    CONSTRAINT fk_equipo1 FOREIGN KEY(id_equipo1) REFERENCES equipo(id_equipo),
    CONSTRAINT fk_equipo2 FOREIGN KEY(id_equipo2) REFERENCES equipo(id_equipo),
    CONSTRAINT fk_participante FOREIGN KEY(id_participante) REFERENCES participante(id_participante),
    CONSTRAINT fk_ronda FOREIGN KEY(nro_ronda) REFERENCES ronda(nro_ronda)
  );
  ~~~



  ~~~
USE prode;

INSERT INTO equipo (nombre) VALUES("argentina");
INSERT INTO equipo (nombre) VALUES("arabia saudita");
INSERT INTO equipo (nombre)VALUES ("polonia");
INSERT INTO equipo (nombre) VALUES("mexico");

INSERT INTO ronda (nombre_fase) VALUES ("fase grupo");
INSERT INTO ronda (nombre_fase) VALUES ("fase grupo");


INSERT INTO participante (nombre) VALUES ("mariana");
INSERT INTO participante (nombre) VALUES ("pedro");

INSERT INTO ronda (nombre_fase) VALUES ("fase grupo");
INSERT INTO pronostico (id_participante, nro_ronda, id_equipo1, id_equipo2, resultado) VALUES(1,1,1,2,"GANADOR");
INSERT INTO pronostico (id_participante, nro_ronda, id_equipo1, id_equipo2, resultado) VALUES(1,1,3,4,"EMPATE");
INSERT INTO pronostico (id_participante, nro_ronda, id_equipo1, id_equipo2, resultado) VALUES(1,2,1,4,"GANADOR");
INSERT INTO pronostico (id_participante, nro_ronda, id_equipo1, id_equipo2, resultado) VALUES(1,2,2,3,"PERDEDOR");
INSERT INTO pronostico (id_participante, nro_ronda, id_equipo1, id_equipo2, resultado) VALUES(1,3,1,3,"GANADOR");
INSERT INTO pronostico (id_participante, nro_ronda, id_equipo1, id_equipo2, resultado) VALUES(1,3,2,4,"PERDEDOR");
INSERT INTO pronostico (id_participante, nro_ronda, id_equipo1, id_equipo2, resultado) VALUES(2,1,1,2,"GANADOR");
INSERT INTO pronostico (id_participante, nro_ronda, id_equipo1, id_equipo2, resultado) VALUES(2,1,3,4,"PERDEDOR");
INSERT INTO pronostico (id_participante, nro_ronda, id_equipo1, id_equipo2, resultado) VALUES(2,2,1,4,"GANADOR");
INSERT INTO pronostico (id_participante, nro_ronda, id_equipo1, id_equipo2, resultado) VALUES(2,2,2,3,"EMPATE");
INSERT INTO pronostico (id_participante, nro_ronda, id_equipo1, id_equipo2, resultado) VALUES(2,3,1,3,"GANADOR");
INSERT INTO pronostico (id_participante, nro_ronda, id_equipo1, id_equipo2, resultado) VALUES(2,3,2,4,"EMPATE");
~~~
