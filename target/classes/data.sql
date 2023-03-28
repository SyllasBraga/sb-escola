drop database if exists sb_escola;
create database sb_escola;
use sb_escola;

create table aluno(
id int primary key not null auto_increment,
nome_completo varchar(255) not null,
data_matricula date not null,
endereco varchar(255) not null
);

create table professor(
id int primary key not null auto_increment,
nome_completo varchar(255) not null,
data_matricula date not null,
endereco varchar(255) not null,
salario double not null,
graduacao varchar(255) not null
);

create table turma(
id int not null primary key auto_increment,
serie varchar(255) not null,
disciplina varchar(255) not null,
id_professor int not null
);

create table aluno_turma(
id_aluno int not null,
id_turma int not null
);

alter table aluno_turma
add foreign key fk_aluno(id_aluno) references aluno(id);
alter table aluno_turma
add foreign key fk_turma(id_turma) references turma(id);

alter table turma
add foreign key fk_professor(id_professor) references professor(id);

insert into aluno values (default, "Josefino Andrade Finíssimo", "2001-10-01", "Bairro das Pêras, Lugar Distante"),
(default, "Josefina Andrade Finíssima", "2010-01-10", "Bairro das Limões, Lugar Distante"),
(default, "José Pedro", "2001-10-01", "Bairro das Maçãs, Lugar Distante"),
(default, "Pedro José", "2003-08-22", "Bairro das Goiabas, Lugar Distante");

insert into professor values (default, "Maria Conceição", "1989-10-07", "Bairro das Pêras, Lugar Distante", 8999.1, "Licenciatura em matemática"),
(default, "Carlos Braga", "1990-03-10", "Bairro das Goiabas, Lugar Distante", 8999.1, "Licenciatura em informática"),
(default, "Mariana Gomez", "1999-08-25", "Bairro das Pêras, Lugar Distante", 8999.1, "Letras");

insert into turma values (default, "1º Ensino Médio", "Matemática I", 1),
(default, "1º Ensino Médio", "Português I", 3),
(default, "1º Ensino Médio", "Linguagem de Programação I", 2),
(default, "1º Ensino Médio", "Banco de Dados I", 2);

insert into aluno_turma values (1, 1), (1, 2),(1, 3),(1, 4), (2, 1), (2, 2),(3, 1), (3, 2),(3, 3),(3, 4), (4, 1), (4, 2),(4, 3),(4, 4);

DELIMITER $$
CREATE PROCEDURE pr_aluno_turma (id_aluno int)
BEGIN
	select t.* from turma t 
	inner join aluno_turma atu on atu.id_turma = t.id
	inner join aluno a on a.id = atu.id_aluno
    where a.id=id_aluno;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE pr_alunos_turma (id_turma int)
BEGIN
	select al.* from aluno al
	inner join aluno_turma atu on al.id = atu.id_aluno
	inner join turma tm on atu.id_turma = tm.id
	where tm.id=id_turma;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE pr_professor_turma (id_turma int)
BEGIN
	select pf.* from professor pf
	inner join turma tm on pf.id = tm.id_professor
	where tm.id = id_turma;
END $$
DELIMITER ;