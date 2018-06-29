--Tabela simples. Em projetos maiores haveria criptografia da coluna do campo senha
-- -----------------------------------------------------
-- Schema usercrud
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `usercrud` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `usercrud` ;

-- -----------------------------------------------------
-- Table `usercrud`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usercrud`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `descricao_usuario` VARCHAR(45) NOT NULL,
  `cpf_usuario` VARCHAR(14) NOT NULL,
  `email_usuario` VARCHAR(80),
  `data_nascimento_usuario` datetime,
  `senha_usuario` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_usuario`) ,
  UNIQUE INDEX `cpf_usuario_UNIQUE` (`cpf_usuario` ASC))
ENGINE = InnoDB;