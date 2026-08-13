IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = 'taskmanager')
BEGIN
	CREATE DATABASE taskmanager;
END
GO

USE taskmanager;
GO

-- CREATE TABLES

CREATE TABLE usuarios (
    usuario_id       	BIGINT IDENTITY(1,1) PRIMARY KEY,
    nome            	VARCHAR(50) NOT NULL,
    email           	VARCHAR(50) NOT NULL UNIQUE,
    senha           	VARCHAR(50) NOT NULL,
    telefone        	VARCHAR(20),
    data_nascimento  	DATE        NOT NULL,
    data_cadastro    	DATE        NOT NULL,
    status          	VARCHAR(20) NOT NULL,
    tipo_usuario     	VARCHAR(20) NOT NULL
);

CREATE TABLE tarefas (
    tarefa_id        	BIGINT IDENTITY(1,1) PRIMARY KEY,
    nome            	VARCHAR(50) NOT NULL,
    descricao       	VARCHAR(MAX),
    data_criacao     	DATE        NOT NULL,
    situacao_tarefa  	VARCHAR(20) NOT NULL,
    criador_id       	BIGINT,
    responsavel_id   	BIGINT,
    prazo_entrega    	DATE
);

-- FOREIGN KEYS

ALTER TABLE tarefas
ADD CONSTRAINT fk_tarefa_criador
FOREIGN KEY (criador_id) REFERENCES usuarios (usuario_id);

ALTER TABLE tarefas
ADD CONSTRAINT fk_tarefa_responsavel
FOREIGN KEY (responsavel_id) REFERENCES usuarios (usuario_id);

-- CHECK

ALTER TABLE usuarios
ADD CONSTRAINT ck_usuarios_status
CHECK (status IN ('ATIVO', 'INATIVO'));

ALTER TABLE usuarios
ADD CONSTRAINT ck_usuarios_tipo
CHECK (tipo_usuario IN ('PADRAO', 'ADMIN'));

ALTER TABLE tarefas
ADD CONSTRAINT ck_tarefas_situacao
CHECK (situacao_tarefa IN ('PENDENTE', 'CONCLUIDA', 'CANCELADA'));
