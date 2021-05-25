create database Agendamento;

use Agendamento;

create table Cliente (id int unsigned not null auto_increment, nome varchar(256), email varchar(256), senha varchar(50), CPF varchar(10), telefone varchar(15),
                     sexo varchar(15), dataNascimento date, papel varchar(10), primary key(id), constraint unique(CPF, email));

create table Profissional(id int unsigned not null auto_increment, nome varchar(256), email varchar(256), senha varchar(50), CPF varchar(10), 
			              especialidade varchar(100), curriculo varchar(256), papel varchar(10), primary key(id), constraint unique(CPF, email));
			           
INSERT INTO Profissional(nome, email, senha, CPF, especialidade, curriculo, papel) VALUES ("Wesley Souza", "welsey@gmail.com", "12345", "1452642355", "estudante", "teste", "user");
INSERT INTO Profissional(nome, email, senha, CPF, especialidade, curriculo, papel) VALUES ("Wesley Souza2", "welsey2@gmail.com", "12345", "1452642356", "estudante", "teste", "user");
INSERT INTO Profissional(nome, email, senha, CPF, especialidade, curriculo, papel) VALUES ("Wesley Souza3", "welsey3@gmail.com", "12345", "1452642357", "estudante", "teste", "user");
INSERT INTO Cliente(nome, email, senha, CPF, telefone, sexo, dataNascimento, papel) VALUES ("Wesley Souza Us", "welseyu@gmail.com", "12345", "0452642355", "415264745", "Masculino", "1999-09-01","user");
INSERT INTO Cliente(nome, email, senha, CPF, telefone, sexo, dataNascimento, papel) VALUES ("Wesley Souza Us2", "welseyu2@gmail.com", "12345", "0052642355", "415264745", "Masculino", "1999-09-01","user");
INSERT INTO Cliente(nome, email, senha, CPF, telefone, sexo, dataNascimento, papel) VALUES ("Wesley Souza Ad", "welseyd@gmail.com", "12345", "0152642355", "415264745", "Masculino", "1999-09-01","admin");
