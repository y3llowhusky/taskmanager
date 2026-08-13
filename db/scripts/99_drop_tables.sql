ALTER TABLE dbo.tarefas
DROP CONSTRAINT fk_tarefa_criador;

ALTER TABLE dbo.tarefas
DROP CONSTRAINT fk_tarefa_responsavel;

DROP TABLE tarefas;
DROP TABLE usuarios;
