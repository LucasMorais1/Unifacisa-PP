create table conta(
	numeroConta bigint not null auto_increment,
	numeroAgencia bigint not null,
	titular varchar(60) not null,
	saldo decimal(10,2) not null,
	
	primary key (numeroConta)
	
)