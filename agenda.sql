-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema agenda
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema agenda
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `agenda` DEFAULT CHARACTER SET utf8 ;
USE `agenda` ;

-- -----------------------------------------------------
-- Table `agenda`.`PROFESOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`PROFESOR` ;

CREATE TABLE IF NOT EXISTS `agenda`.`PROFESOR` (
  `idProfesor` INT NOT NULL AUTO_INCREMENT,
  `primer_nombre` VARCHAR(45) NOT NULL,
  `segundo_nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `apellido2` VARCHAR(45) NOT NULL,
  `dni` VARCHAR(8) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProfesor`),
  UNIQUE INDEX `usuario_UNIQUE` (`usuario` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agenda`.`APODERADO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`APODERADO` ;

CREATE TABLE IF NOT EXISTS `agenda`.`APODERADO` (
  `idApoderado` INT NOT NULL AUTO_INCREMENT,
  `primer_nombre` VARCHAR(45) NOT NULL,
  `segundo_nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `apellido2` VARCHAR(45) NOT NULL,
  `dni` VARCHAR(8) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idApoderado`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC),
  UNIQUE INDEX `usuario_UNIQUE` (`usuario` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agenda`.`ALUMNO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`ALUMNO` ;

CREATE TABLE IF NOT EXISTS `agenda`.`ALUMNO` (
  `idAlumno` INT NOT NULL AUTO_INCREMENT,
  `primer_nombre` VARCHAR(45) NOT NULL,
  `segundo_nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `apellido2` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `idApoderado` INT NOT NULL,
  PRIMARY KEY (`idAlumno`),
  INDEX `fk_ALUMNO_APODERADO1_idx` (`idApoderado` ASC),
  CONSTRAINT `fk_ALUMNO_APODERADO1`
    FOREIGN KEY (`idApoderado`)
    REFERENCES `agenda`.`APODERADO` (`idApoderado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agenda`.`GRADO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`GRADO` ;

CREATE TABLE IF NOT EXISTS `agenda`.`GRADO` (
  `idGrado` INT NOT NULL AUTO_INCREMENT,
  `nroGrado` INT NOT NULL,
  PRIMARY KEY (`idGrado`),
  UNIQUE INDEX `nroGrado_UNIQUE` (`nroGrado` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agenda`.`SECCION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`SECCION` ;

CREATE TABLE IF NOT EXISTS `agenda`.`SECCION` (
  `idSeccion` INT NOT NULL AUTO_INCREMENT,
  `letraSeccion` CHAR(1) NOT NULL,
  `idGrado` INT NOT NULL,
  `idProfesor` INT NOT NULL,
  PRIMARY KEY (`idSeccion`),
  INDEX `fk_SECCION_GRADO_idx` (`idGrado` ASC),
  INDEX `fk_SECCION_PROFESOR1_idx` (`idProfesor` ASC),
  CONSTRAINT `fk_SECCION_GRADO`
    FOREIGN KEY (`idGrado`)
    REFERENCES `agenda`.`GRADO` (`idGrado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SECCION_PROFESOR1`
    FOREIGN KEY (`idProfesor`)
    REFERENCES `agenda`.`PROFESOR` (`idProfesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agenda`.`COMUNICADO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`COMUNICADO` ;

CREATE TABLE IF NOT EXISTS `agenda`.`COMUNICADO` (
  `idComunicado` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  `cuerpo` VARCHAR(400) NOT NULL,
  `idSeccion` INT NOT NULL,
  PRIMARY KEY (`idComunicado`),
  INDEX `fk_COMUNICADO_SECCION1_idx` (`idSeccion` ASC),
  CONSTRAINT `fk_COMUNICADO_SECCION1`
    FOREIGN KEY (`idSeccion`)
    REFERENCES `agenda`.`SECCION` (`idSeccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agenda`.`CITACION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`CITACION` ;

CREATE TABLE IF NOT EXISTS `agenda`.`CITACION` (
  `idCitacion` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  `cuerpo` VARCHAR(400) NOT NULL,
  `apoderaConfirm` TINYINT NOT NULL DEFAULT 0,
  `profesorConfirm` TINYINT NOT NULL DEFAULT 0,
  `idApoderado` INT NOT NULL,
  `idProfesor` INT NOT NULL,
  PRIMARY KEY (`idCitacion`),
  INDEX `fk_CITACION_APODERADO1_idx` (`idApoderado` ASC),
  INDEX `fk_CITACION_PROFESOR1_idx` (`idProfesor` ASC),
  CONSTRAINT `fk_CITACION_APODERADO1`
    FOREIGN KEY (`idApoderado`)
    REFERENCES `agenda`.`APODERADO` (`idApoderado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CITACION_PROFESOR1`
    FOREIGN KEY (`idProfesor`)
    REFERENCES `agenda`.`PROFESOR` (`idProfesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agenda`.`PERIODO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`PERIODO` ;

CREATE TABLE IF NOT EXISTS `agenda`.`PERIODO` (
  `idPeriodo` INT NOT NULL AUTO_INCREMENT,
  `anio` INT NOT NULL,
  `estado` VARCHAR(45) NULL,
  PRIMARY KEY (`idPeriodo`),
  UNIQUE INDEX `anio_UNIQUE` (`anio` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agenda`.`MATRICULA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`MATRICULA` ;

CREATE TABLE IF NOT EXISTS `agenda`.`MATRICULA` (
  `idMatricula` INT NOT NULL AUTO_INCREMENT,
  `idAlumno` INT NOT NULL,
  `idSeccion` INT NOT NULL,
  `idPeriodo` INT NOT NULL,
  PRIMARY KEY (`idMatricula`),
  INDEX `fk_MATRICULA_ALUMNO1_idx` (`idAlumno` ASC),
  INDEX `fk_MATRICULA_SECCION1_idx` (`idSeccion` ASC),
  INDEX `fk_MATRICULA_PERIODO1_idx` (`idPeriodo` ASC),
  CONSTRAINT `fk_MATRICULA_ALUMNO1`
    FOREIGN KEY (`idAlumno`)
    REFERENCES `agenda`.`ALUMNO` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MATRICULA_SECCION1`
    FOREIGN KEY (`idSeccion`)
    REFERENCES `agenda`.`SECCION` (`idSeccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MATRICULA_PERIODO1`
    FOREIGN KEY (`idPeriodo`)
    REFERENCES `agenda`.`PERIODO` (`idPeriodo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agenda`.`ASISTENCIA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`ASISTENCIA` ;

CREATE TABLE IF NOT EXISTS `agenda`.`ASISTENCIA` (
  `idAsistencia` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NULL,
  `estado` VARCHAR(12) NULL DEFAULT 'INASISTENCIA',
  `idMATRICULA` INT NOT NULL,
  PRIMARY KEY (`idAsistencia`),
  INDEX `fk_ASISTENCIA_MATRICULA1_idx` (`idMATRICULA` ASC),
  CONSTRAINT `fk_ASISTENCIA_MATRICULA1`
    FOREIGN KEY (`idMATRICULA`)
    REFERENCES `agenda`.`MATRICULA` (`idMatricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agenda`.`CURSO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`CURSO` ;

CREATE TABLE IF NOT EXISTS `agenda`.`CURSO` (
  `idCurso` INT NOT NULL AUTO_INCREMENT,
  `nombreCurso` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idCurso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agenda`.`BIMESTRE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`BIMESTRE` ;

CREATE TABLE IF NOT EXISTS `agenda`.`BIMESTRE` (
  `idBimestre` INT NOT NULL AUTO_INCREMENT,
  `nroBimestre` INT NOT NULL,
  `estado` VARCHAR(45) NULL,
  `idPeriodo` INT NOT NULL,
  PRIMARY KEY (`idBimestre`),
  INDEX `fk_BIMESTRE_PERIODO1_idx` (`idPeriodo` ASC),
  CONSTRAINT `fk_BIMESTRE_PERIODO1`
    FOREIGN KEY (`idPeriodo`)
    REFERENCES `agenda`.`PERIODO` (`idPeriodo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agenda`.`EVALUACION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`EVALUACION` ;

CREATE TABLE IF NOT EXISTS `agenda`.`EVALUACION` (
  `idEvaluacion` INT NOT NULL AUTO_INCREMENT,
  `tipoEval` VARCHAR(45) NOT NULL,
  `pesoEval` DECIMAL(4,2) NOT NULL DEFAULT 0,
  `nota` DECIMAL(4,2) NULL DEFAULT 0,
  `idMatricula` INT NOT NULL,
  `idCurso` INT NOT NULL,
  `idBimestre` INT NOT NULL,
  PRIMARY KEY (`idEvaluacion`),
  INDEX `fk_EVALUACION_MATRICULA1_idx` (`idMatricula` ASC),
  INDEX `fk_EVALUACION_CURSO1_idx` (`idCurso` ASC),
  INDEX `fk_EVALUACION_BIMESTRE1_idx` (`idBimestre` ASC),
  CONSTRAINT `fk_EVALUACION_MATRICULA1`
    FOREIGN KEY (`idMatricula`)
    REFERENCES `agenda`.`MATRICULA` (`idMatricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EVALUACION_CURSO1`
    FOREIGN KEY (`idCurso`)
    REFERENCES `agenda`.`CURSO` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EVALUACION_BIMESTRE1`
    FOREIGN KEY (`idBimestre`)
    REFERENCES `agenda`.`BIMESTRE` (`idBimestre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agenda`.`OBSERVACION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`OBSERVACION` ;

CREATE TABLE IF NOT EXISTS `agenda`.`OBSERVACION` (
  `idObservacion` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  `cuerpo` VARCHAR(400) NOT NULL,
  `idProfesor` INT NOT NULL,
  `idAlumno` INT NOT NULL,
  PRIMARY KEY (`idObservacion`),
  INDEX `fk_OBSERVACION_PROFESOR1_idx` (`idProfesor` ASC),
  INDEX `fk_OBSERVACION_ALUMNO1_idx` (`idAlumno` ASC),
  CONSTRAINT `fk_OBSERVACION_PROFESOR1`
    FOREIGN KEY (`idProfesor`)
    REFERENCES `agenda`.`PROFESOR` (`idProfesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OBSERVACION_ALUMNO1`
    FOREIGN KEY (`idAlumno`)
    REFERENCES `agenda`.`ALUMNO` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agenda`.`CURSO_SECCION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agenda`.`CURSO_SECCION` ;

CREATE TABLE IF NOT EXISTS `agenda`.`CURSO_SECCION` (
  `idSeccion` INT NOT NULL,
  `idCurso` INT NOT NULL,
  PRIMARY KEY (`idSeccion`, `idCurso`),
  INDEX `fk_CURSO_SECCION_CURSO1_idx` (`idCurso` ASC),
  CONSTRAINT `fk_CURSO_SECCION_SECCION1`
    FOREIGN KEY (`idSeccion`)
    REFERENCES `agenda`.`SECCION` (`idSeccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CURSO_SECCION_CURSO1`
    FOREIGN KEY (`idCurso`)
    REFERENCES `agenda`.`CURSO` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
