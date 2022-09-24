



Create Table Cliente (
	idCliente int auto_increment not null PRIMARY KEY,
    Nome varchar(40) not null,
	Cpf varchar(11) not null,
    Telefone varchar(14) not null,
	Cep varchar(08),
    Rua varchar(50),
    Numero varchar(05),
    Bairro varchar(40),
    Cidade varchar(40)
   
);

CREATE TABLE Passagem (
    CodBilhete int auto_increment not null PRIMARY KEY,
    Data_PG date not null,
    Tipo_PG varchar(15) not null,
	Valor_PG decimal(10,2) not null
);

CREATE TABLE Agendamento (
    Id_Agenda int auto_increment not null PRIMARY KEY,
	Classe varchar(20) not null,
	Data_Ida date not null,
    Data_Volta date not null,
    Qtd_Crianca varchar(02) not null,
    Qtd_Adulto varchar(02) not null,
    Origem varchar(20) not null,
    Destino varchar(20) not null,
    fk_Passagem_CodBilhete int,
    fk_Cliente_idCliente int
);
 
ALTER TABLE Agendamento ADD CONSTRAINT FK_Agendamento_2
    FOREIGN KEY (fk_Passagem_CodBilhete)
    REFERENCES Passagem (CodBilhete)
    ON DELETE CASCADE;
 
ALTER TABLE Agendamento ADD CONSTRAINT FK_Agendamento_3
    FOREIGN KEY (fk_Cliente_idCliente)
    REFERENCES Cliente (idCliente)
    ON DELETE CASCADE;