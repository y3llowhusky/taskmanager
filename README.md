criar container docker com dois volumes nomeados (um para dados do banco, outro para backup do banco):

docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=TaskManager#310307" -p 1433:1433 --name y3llowhusky-taskmanager -v "D:\programacao\java\taskmanager\db\data:/var/opt/mssql/data" -v "D:\programacao\java\taskmanager\db\backups:/var/opt/mssql/backup" -d mcr.microsoft.com/mssql/server:2022-latest
