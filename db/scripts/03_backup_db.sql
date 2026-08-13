USE taskmanager;
GO

EXEC ('BACKUP DATABASE [taskmanager] TO DISK = ''' +
	'/var/opt/mssql/backup' + -- caminho interno do bind mount do docker
	'/taskmanager_bkp.bak'' WITH FORMAT, COMPRESSION');