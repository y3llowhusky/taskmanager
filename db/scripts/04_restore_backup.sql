USE master;
GO

RESTORE DATABASE [taskmanager]
FROM DISK = N'/var/opt/mssql/backup/taskmanager_bkp.bak'
WITH MOVE 'taskmanager' TO '/var/opt/mssql/data/taskmanager.mdf',
	 MOVE 'taskmanager_log' TO '/var/opt/mssql/data/taskmanager_log.ldf',
	 REPLACE
GO