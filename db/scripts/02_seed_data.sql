-- =====================================================
-- DML - POPULACAO DAS TABELAS (dados de teste/exemplo)
-- Projeto: taskmanager
-- =====================================================

IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = 'taskmanager')
BEGIN
	CREATE DATABASE taskmanager;
END
GO

USE taskmanager;
GO

-- ---------------------------------------------------
-- USUARIOS (10 registros)
-- 5 PADRAO / 5 ADMIN | 7 ATIVO / 3 INATIVO
-- ---------------------------------------------------

INSERT INTO usuarios (nome, email, senha, telefone, data_nascimento, data_cadastro, status, tipo_usuario)
VALUES ('Ana Beatriz Souza', 'ana.souza@email.com', 'hash_senha_001', '11987654321', '1995-03-12', '2026-01-10', 'ATIVO', 'ADMIN');

INSERT INTO usuarios (nome, email, senha, telefone, data_nascimento, data_cadastro, status, tipo_usuario)
VALUES ('Bruno Carvalho Lima', 'bruno.lima@email.com', 'hash_senha_002', '11976543210', '1990-07-25', '2026-01-15', 'ATIVO', 'ADMIN');

INSERT INTO usuarios (nome, email, senha, telefone, data_nascimento, data_cadastro, status, tipo_usuario)
VALUES ('Camila Rodrigues Alves', 'camila.alves@email.com', 'hash_senha_003', '11965432109', '1998-11-02', '2026-01-20', 'ATIVO', 'ADMIN');

INSERT INTO usuarios (nome, email, senha, telefone, data_nascimento, data_cadastro, status, tipo_usuario)
VALUES ('Daniel Ferreira Costa', 'daniel.costa@email.com', 'hash_senha_004', NULL, '1988-05-19', '2026-02-01', 'INATIVO', 'ADMIN');

INSERT INTO usuarios (nome, email, senha, telefone, data_nascimento, data_cadastro, status, tipo_usuario)
VALUES ('Eduarda Martins Pereira', 'eduarda.pereira@email.com', 'hash_senha_005', '11954321098', '1993-09-30', '2026-02-05', 'ATIVO', 'ADMIN');

INSERT INTO usuarios (nome, email, senha, telefone, data_nascimento, data_cadastro, status, tipo_usuario)
VALUES ('Felipe Augusto Santos', 'felipe.santos@email.com', 'hash_senha_006', '11943210987', '1997-01-14', '2026-02-10', 'ATIVO', 'PADRAO');

INSERT INTO usuarios (nome, email, senha, telefone, data_nascimento, data_cadastro, status, tipo_usuario)
VALUES ('Gabriela Nunes Oliveira', 'gabriela.oliveira@email.com', 'hash_senha_007', '11932109876', '2000-04-08', '2026-02-12', 'ATIVO', 'PADRAO');

INSERT INTO usuarios (nome, email, senha, telefone, data_nascimento, data_cadastro, status, tipo_usuario)
VALUES ('Henrique Barbosa Ramos', 'henrique.ramos@email.com', 'hash_senha_008', NULL, '1992-12-22', '2026-02-18', 'INATIVO', 'PADRAO');

INSERT INTO usuarios (nome, email, senha, telefone, data_nascimento, data_cadastro, status, tipo_usuario)
VALUES ('Isabela Cristina Gomes', 'isabela.gomes@email.com', 'hash_senha_009', '11921098765', '1996-06-17', '2026-03-01', 'ATIVO', 'PADRAO');

INSERT INTO usuarios (nome, email, senha, telefone, data_nascimento, data_cadastro, status, tipo_usuario)
VALUES ('Joao Pedro Almeida', 'joao.almeida@email.com', 'hash_senha_010', '11910987654', '1994-10-05', '2026-03-05', 'INATIVO', 'PADRAO');


-- ---------------------------------------------------
-- TAREFAS (20 registros)
-- 15 com responsavel definido / 5 abertas (responsavel_id NULL)
-- 10 com prazo_entrega / 10 sem prazo (NULL)
-- Mix de PENDENTE / CONCLUIDA / CANCELADA, com datas coerentes
-- (data de hoje considerada: 2026-08-13)
-- ---------------------------------------------------

-- Tarefas CONCLUIDAS (prazo no passado, coerente com already finalizada)
INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Configurar ambiente de desenvolvimento', 'Instalar JDK, Eclipse, Tomcat e configurar o workspace inicial do projeto.', '2026-01-12', 'CONCLUIDA', 1, 6, '2026-01-20');

INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Modelar entidades do sistema', 'Criar as classes Usuario, Tarefa e os enums de dominio.', '2026-01-18', 'CONCLUIDA', 2, 7, '2026-01-25');

INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Elaborar script DDL do banco', 'Criar as tabelas usuarios e tarefas com PK, FK e constraints de check.', '2026-01-22', 'CONCLUIDA', 1, 9, '2026-02-02');

INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Revisar regras de negocio de usuarios', 'Validar unicidade de email e regras de ativacao/inativacao.', '2026-02-03', 'CONCLUIDA', 3, 6, '2026-02-14');

INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Documentar arquitetura em camadas', 'Descrever responsabilidade de model, repository, service e controller.', '2026-02-06', 'CONCLUIDA', 2, NULL, '2026-02-20');

-- Tarefas PENDENTES (prazo futuro)
INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Implementar UsuarioRepository', 'Criar operacoes de CRUD via JDBC puro para a entidade Usuario.', '2026-07-10', 'PENDENTE', 1, 7, '2026-08-25');

INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Implementar TarefaRepository', 'Criar operacoes de CRUD via JDBC puro para a entidade Tarefa.', '2026-07-12', 'PENDENTE', 1, 9, '2026-08-28');

INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Criar camada de service de usuarios', 'Aplicar validacoes de negocio como hash de senha e checagem de email duplicado.', '2026-07-15', 'PENDENTE', 3, 6, '2026-09-05');

INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Criar camada de service de tarefas', 'Aplicar regras de permissao: apenas ADMIN cria, altera e exclui tarefas.', '2026-07-18', 'PENDENTE', 2, 7, '2026-09-10');

INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Criar servlet de listagem de tarefas', 'Endpoint GET que retorna a lista de tarefas via Thymeleaf.', '2026-07-20', 'PENDENTE', 1, NULL, '2026-09-15');

-- Tarefas PENDENTES sem prazo definido
INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Estudar diferencas entre JDBC e JPA', 'Pesquisar e anotar principais diferencas para o proximo projeto.', '2026-07-25', 'PENDENTE', 4, 9, NULL);

INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Revisar nomenclatura de colunas do banco', 'Avaliar padronizacao snake_case em todas as tabelas.', '2026-07-28', 'PENDENTE', 3, NULL, NULL);

INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Planejar testes unitarios das camadas service', 'Levantar cenarios de teste para regras de negocio criticas.', '2026-08-01', 'PENDENTE', 2, 6, NULL);

INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Avaliar uso de connection pool', 'Pesquisar viabilidade de HikariCP para evolucao futura do projeto.', '2026-08-03', 'PENDENTE', 1, NULL, NULL);

INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Escrever README do projeto', 'Documentar setup do ambiente, tecnologias usadas e como rodar localmente.', '2026-08-05', 'PENDENTE', 5, NULL, NULL);

-- Tarefas CANCELADAS
INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Integrar com API de terceiros para notificacoes', 'Cancelada por estar fora do escopo do projeto de treino.', '2026-02-10', 'CANCELADA', 2, 8, '2026-03-01');

INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Criar app mobile complementar', 'Cancelada, projeto restrito a aplicacao web para fins didaticos.', '2026-03-15', 'CANCELADA', 1, NULL, '2026-04-01');

INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Migrar projeto para nuvem paga', 'Cancelada para evitar custos durante a fase de aprendizado.', '2026-04-02', 'CANCELADA', 3, 10, NULL);

-- Tarefas PENDENTES adicionais para completar distribuicao (responsavel definido, sem prazo)
INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Padronizar mensagens de erro da aplicacao', 'Definir formato unico de mensagens de validacao exibidas ao usuario.', '2026-08-08', 'PENDENTE', 4, 7, NULL);

INSERT INTO tarefas (nome, descricao, data_criacao, situacao_tarefa, criador_id, responsavel_id, prazo_entrega)
VALUES ('Configurar backup automatico do banco', 'Definir rotina periodica de backup para ambiente local.', '2026-08-10', 'PENDENTE', 5, 9, '2026-09-20');