1 - Instalar banco de dados mysql
2 - Entrar na shell SQL, e criar banco:
    ```$ cd SistemaAgendamento```
    ```$ mysql -u $SQL_USER -p```
    ```sql> source ./db/MySQL/createTables.sql```
    ```sql> \q```
3 - Dar deploy no projeto
    ```$ mvn tomcat7:deploy```
4 - Acessá-lo pelo navegador:
    http://localhost:8080/SistemaAgendamento/

