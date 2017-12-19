Instruções para uso:
Para ser possível executar esse projeto é necessário que o mysql esteja instalado no computador.
Além disso, também é necessário que existam:

- um banco de dados chamado "db_example";
- um usuário chamado "springuser" em "localhost" e com senha "admin123";
- permissões para o usuário anterior acessar "db_example";

Os seguintes comandos podem ser usados para garantir as restrições anteriores:

CREATE DATABASE  IF NOT EXISTS `db_example`;
CREATE USER IF NOT EXISTS 'springuser'@'localhost' identified by 'admin123';
GRANT ALL ON `db_example`.* TO 'springuser'@'localhost';

 