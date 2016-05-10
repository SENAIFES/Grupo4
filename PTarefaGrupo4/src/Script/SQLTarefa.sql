CREATE SCHEMA IF NOT EXISTS `dbtarefa` DEFAULT CHARACTER SET latin1 ;
USE `dbtarefa` ;

CREATE TABLE `dbtarefa`.`lista` (
  `idLista` INT NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idLista`));

CREATE TABLE `dbtarefa`.`tarefa` (
  `idTarefa` INT NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(100) NOT NULL,
  `Prazo` DATE NOT NULL,
  `Feito` TINYINT NOT NULL,
  `idLista` INT NOT NULL,
  PRIMARY KEY (`idTarefa`),
  INDEX `fk_idLista_idx` (`idLista` ASC),
  CONSTRAINT `fk_idLista`
    FOREIGN KEY (`idLista`)
    REFERENCES `dbtarefa`.`lista` (`idLista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
