1 - Instalar banco de dados mysql\
2 - Entrar na shell SQL, e criar banco:\
    <pre><code>$ cd SistemaAgendamento
    $ mysql -u $SQL_USER -p
    sql> source ./db/MySQL/createTables.sql
    sql> \q
    </code></pre>


3 - Dar deploy no projeto.\
    <pre><code>$ mvn tomcat7:deploy
    </code></pre>


4 - Acessá-lo pelo navegador:\
    http://localhost:8080/SistemaAgendamento/

