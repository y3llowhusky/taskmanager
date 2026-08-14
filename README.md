criar container docker com dois volumes (um para dados do banco, outro para backup do banco):

`docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=TaskManager#310307" -p 1433:1433 --name y3llowhusky-taskmanager -v "CAMINHO PASTA DB/DATA:/var/opt/mssql/data" -v "CAMINHO PASTA DB/BACKUPS:/var/opt/mssql/backup" -d mcr.microsoft.com/mssql/server:2022-latest`

isso cria um container chamado y3llowhusky-taskmanager no docker, com dois volumes por bind mount (não nomeados, diretamente apontados para diretórios do computador):
- um na pasta taskmanager/db/data, para guardar os bancos de dados e seus dados
- outro na pasta taskmanager/db/backups, para guardar os arquivos .bak de backup do banco, que são enviados para o repositório juntamente com o resto do projeto, para que cada banco local fique atualizado
