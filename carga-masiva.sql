use agenda;

LOAD DATA
LOCAL INFILE 'E:/ALONSO/Desarrollo/Java/Netbeans/AgendaElectronica/apoderados.csv'
INTO TABLE apoderado
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES;

LOAD DATA
LOCAL INFILE 'E:/ALONSO/Desarrollo/Java/Netbeans/AgendaElectronica/profesores.csv'
INTO TABLE profesor
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES;

LOAD DATA
LOCAL INFILE 'E:/ALONSO/Desarrollo/Java/Netbeans/AgendaElectronica/alumnos.csv'
INTO TABLE alumno
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES
(idAlumno,primer_nombre,segundo_nombre,apellido,apellido2,@fecha,idApoderado)
SET fecha_nacimiento = str_to_date(@fecha, '%d/%m/%Y');

INSERT INTO periodo(anio, estado) values (2017,'ACTIVO');

INSERT INTO bimestre(nroBimestre, estado, idPeriodo) values (1,'INACTIVO', 1);
INSERT INTO bimestre(nroBimestre, estado, idPeriodo) values (2,'ACTIVO', 1);
INSERT INTO bimestre(nroBimestre, estado, idPeriodo) values (3,'INACTIVO', 1);
INSERT INTO bimestre(nroBimestre, estado, idPeriodo) values (4,'INACTIVO', 1);

INSERT INTO grado(nroGrado) values (1);
INSERT INTO grado(nroGrado) values (2);
INSERT INTO grado(nroGrado) values (3);
INSERT INTO grado(nroGrado) values (4);
INSERT INTO grado(nroGrado) values (5);
INSERT INTO grado(nroGrado) values (6);

INSERT INTO seccion(letraSeccion,idGrado,idProfesor) values ('A',5,5);

INSERT INTO matricula(idAlumno, idSeccion, idPeriodo) values (1,1,1);
INSERT INTO matricula(idAlumno, idSeccion, idPeriodo) values (2,1,1);
INSERT INTO matricula(idAlumno, idSeccion, idPeriodo) values (3,1,1);
INSERT INTO matricula(idAlumno, idSeccion, idPeriodo) values (4,1,1);
INSERT INTO matricula(idAlumno, idSeccion, idPeriodo) values (5,1,1);
INSERT INTO matricula(idAlumno, idSeccion, idPeriodo) values (6,1,1);
INSERT INTO matricula(idAlumno, idSeccion, idPeriodo) values (7,1,1);
INSERT INTO matricula(idAlumno, idSeccion, idPeriodo) values (8,1,1);
INSERT INTO matricula(idAlumno, idSeccion, idPeriodo) values (9,1,1);
