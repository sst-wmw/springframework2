
-- 1º Criar a base de dados
create database springframework;

-- 2º Criar a tabela de Pedido
create table pedido (
	cdPedido decimal(9) not null,
	nmCliente varchar(100) not null,
	vlPedido decimal(9,2) not null,
	primary key (cdPedido)
);

-- 3º Criar a tabela de ItemPedido
create table itemPedido (
	cdPedido decimal(9) not null,
	cdProduto decimal(9) not null,
	dsProduto varchar(100) not null,
	vlProduto decimal(9,2) not null,
	primary key (cdPedido)
);