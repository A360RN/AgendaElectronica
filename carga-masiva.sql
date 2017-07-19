use agenda;
/*
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
*/

/* INSERT QUERY */
INSERT INTO Apoderado(
idApoderado, primer_nombre, segundo_nombre,
apellido, apellido2, dni, usuario,
password
)
VALUES
(
1, 'JOSE', 'MARTIN', 'DIAZ', 'DIAZ',
78945613, 'jose.diaz', 123
);
/* INSERT QUERY */
INSERT INTO Apoderado(
idApoderado, primer_nombre, segundo_nombre,
apellido, apellido2, dni, usuario,
password
)
VALUES
(
2, 'MIGUEL', 'JOSE', 'CHAVEZ', 'TORRES',
78956321, 'miguel.ct', 123
);
/* INSERT QUERY */
INSERT INTO Apoderado(
idApoderado, primer_nombre, segundo_nombre,
apellido, apellido2, dni, usuario,
password
)
VALUES
(
3, 'MARIELA', 'DIANA', 'CARRASCO',
'GOMEZ', 89745978, 'mari.carr', 123
);
/* INSERT QUERY */
INSERT INTO Apoderado(
idApoderado, primer_nombre, segundo_nombre,
apellido, apellido2, dni, usuario,
password
)
VALUES
(
4, 'ELENA', 'CARMEN', 'TORREALVA',
'DIAZ', 12358976, 'el.car', 123
);
/* INSERT QUERY */
INSERT INTO Apoderado(
idApoderado, primer_nombre, segundo_nombre,
apellido, apellido2, dni, usuario,
password
)
VALUES
(
5, 'PATRICIO', 'JOSE', 'GOMEZ', 'CANO',
78963215, 'patri.gom', 123
);

/* INSERT QUERY */
INSERT INTO Profesor(
idProfesor, primer_nombre, segundo_nombre,
apellido, apellido2, dni, usuario,
password
)
VALUES
(
1, 'MARTIN', 'ANDRES', 'CHUMPITAZ',
'TORRES', 78945618, 'martin.a.1',
123
);
/* INSERT QUERY */
INSERT INTO Profesor(
idProfesor, primer_nombre, segundo_nombre,
apellido, apellido2, dni, usuario,
password
)
VALUES
(
2, 'JOSE', 'MIGUEL', 'TORRES', 'TORRES',
45897698, 'jose.t.1', 123
);
/* INSERT QUERY */
INSERT INTO Profesor(
idProfesor, primer_nombre, segundo_nombre,
apellido, apellido2, dni, usuario,
password
)
VALUES
(
3, 'DARIO', 'JOSE', 'ALVA', 'ALVA',
45879311, 'dario.a.1', 123
);
/* INSERT QUERY */
INSERT INTO Profesor(
idProfesor, primer_nombre, segundo_nombre,
apellido, apellido2, dni, usuario,
password
)
VALUES
(
4, 'SANDRA', 'MARIA', 'ALVA', 'TORRES',
41879612, 'sandra.a.1', 123
);
/* INSERT QUERY */
INSERT INTO Profesor(
idProfesor, primer_nombre, segundo_nombre,
apellido, apellido2, dni, usuario,
password
)
VALUES
(
5, 'MARIA', 'ANDREA', 'MEDINA', 'DIAZ',
54897896, 'maria.a.1', 123
);
/* INSERT QUERY */
INSERT INTO Profesor(
idProfesor, primer_nombre, segundo_nombre,
apellido, apellido2, dni, usuario,
password
)
VALUES
(
6, 'JUANA', 'MARIA', 'DIAZ', 'ALVA',
45698712, 'juana.d.1', 123
);

/* INSERT QUERY */
INSERT INTO Alumno(
idAlumno, primer_nombre, segundo_nombre,
apellido, apellido2, fecha_nacimiento,
idApoderado
)
VALUES
(
1, 'JOSE', 'MIGUEL', 'DIAZ', 'MIGUEZ',
'2007-12-01', 1
);
/* INSERT QUERY */
INSERT INTO Alumno(
idAlumno, primer_nombre, segundo_nombre,
apellido, apellido2, fecha_nacimiento,
idApoderado
)
VALUES
(
2, 'JOSE', 'CARLOS', 'DIAZ', 'MIGUEZ',
'2007-03-01', 1
);
/* INSERT QUERY */
INSERT INTO Alumno(
idAlumno, primer_nombre, segundo_nombre,
apellido, apellido2, fecha_nacimiento,
idApoderado
)
VALUES
(
3, 'MARIA', 'JENNY', 'DIAZ', 'MIGUEZ',
'2007-04-01', 1
);
/* INSERT QUERY */
INSERT INTO Alumno(
idAlumno, primer_nombre, segundo_nombre,
apellido, apellido2, fecha_nacimiento,
idApoderado
)
VALUES
(
4, 'MIGUEL', 'ANTONIO', 'CHAVEZ', 'CANO',
'2007-02-15', 2
);
/* INSERT QUERY */
INSERT INTO Alumno(
idAlumno, primer_nombre, segundo_nombre,
apellido, apellido2, fecha_nacimiento,
idApoderado
)
VALUES
(
5, 'RAUL', 'ARTURO', 'CHAVEZ', 'CANO',
'2007-09-12', 2
);
/* INSERT QUERY */
INSERT INTO Alumno(
idAlumno, primer_nombre, segundo_nombre,
apellido, apellido2, fecha_nacimiento,
idApoderado
)
VALUES
(
6, 'MARIA', 'CARMEN', 'TORRES', 'CARRASCO',
'2007-08-19', 3
);
/* INSERT QUERY */
INSERT INTO Alumno(
idAlumno, primer_nombre, segundo_nombre,
apellido, apellido2, fecha_nacimiento,
idApoderado
)
VALUES
(
7, 'MARIA', 'JOSE', 'TORRES', 'CARRASCO',
'2007-09-15', 3
);
/* INSERT QUERY */
INSERT INTO Alumno(
idAlumno, primer_nombre, segundo_nombre,
apellido, apellido2, fecha_nacimiento,
idApoderado
)
VALUES
(
8, 'JUAN', 'ARTURO', 'DIAZ', 'TORREALVA',
'2007-06-12', 4
);
/* INSERT QUERY */
INSERT INTO Alumno(
idAlumno, primer_nombre, segundo_nombre,
apellido, apellido2, fecha_nacimiento,
idApoderado
)
VALUES
(
9, 'JUAN', 'JOSE', 'GOMEZ', 'SOLANO',
'2007-08-14', 5
);

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
