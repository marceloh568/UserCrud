--Tabela simples. Em projetos maiores haveria criptografia da coluna do campo senha
-- -----------------------------------------------------
-- Schema usercrud
CREATE SCHEMA usercrud AUTHORIZATION postgres;


-- -----------------------------------------------------
-- Table `usercrud`.`usuario`
-- -----------------------------------------------------
CREATE TABLE usercrud.usuario (
	id_usuario serial NOT NULL,
	descricao_usuario varchar NOT NULL,
	cpf_usuario varchar(14) NOT NULL,
	email_usuario varchar(80) NULL,
	data_nascimento_usuario date NULL,
	senha_usuario varchar(20) NOT NULL,
	CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario)
);