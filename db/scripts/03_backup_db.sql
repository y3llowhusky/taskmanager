-- INSERIR CAMINHO DO ARQUIVO NA LINHA COMENTADA, EXEMPLO:
-- 'C:\Users\Chiemi Hayashi\Desktop\programacao\java\taskmanager\db\backups'

USE taskmanager;
GO

EXEC ('BACKUP DATABASE [taskmanager] TO DISK = ''' +
	'C:\Users\Chiemi Hayashi\Desktop\programacao\java\taskmanager\db\backups' + -- INSIRA APENAS O CAMINHO DA PASTA AQUI!!
	'\taskmanager_bkp.bak'' WITH FORMAT, COMPRESSION');