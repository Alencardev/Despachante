create database despach;

use despach;

create table cadastro(
id int not null auto_increment primary key,
placa_veiculo varchar(8),
marca_veiculo varchar(55),
modelo_veiculo varchar(55),
ano_veiculo int);
