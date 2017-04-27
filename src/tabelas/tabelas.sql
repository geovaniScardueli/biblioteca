create table informacoes(
NR_SEQUENCIA int primary key auto_increment,
CLASSIFICACAO varchar(50),
AUTOR varchar(50),
TITULO varchar(50),
EDITORA varchar(50),
ANO varchar(50)
);

create table livro(
NR_SEQUENCIA int primary key auto_increment,
PAGINAS int,
ISBN varchar(15),
NR_INFORMACOES int,
foreign key(NR_INFORMACOES) references informacoes(NR_SEQUENCIA)
);

create table cd(
NR_SEQUENCIA int primary key auto_increment,
TEMPO int,
NR_INFORMACOES int,
foreign key(NR_INFORMACOES) references informacoes(NR_SEQUENCIA)
);

create table livrocd(
NR_SEQUENCIA int primary key auto_increment,
NR_LIVRO int,
NR_CD int,
foreign key(NR_LIVRO) references livro(NR_SEQUENCIA),
foreign key(NR_CD) references cd(NR_SEQUENCIA)
);

create table usuario(
NR_SEQUENCIA int primary key auto_increment,
NOME varchar(50),
TIPO varchar(2),
MULTA int,
EMPRESTIMO varchar(11)
);

create table exemplar(
NR_SEQUENCIA int primary key auto_increment,
COD_BARRAS int,
PATRIMONIO int,
NR_LIVRO int,
NR_USUARIO int,
foreign key(NR_LIVRO) references livro(NR_SEQUENCIA) on delete cascade,
foreign key(NR_USUARIO) references usuario(NR_SEQUENCIA)
);

create table emprestimo(
NR_SEQUENCIA int primary key auto_increment,
LIVRO varchar(50),
USUARIO varchar(50),
EMPRESTIMO varchar(11),
NR_EXEMPLAR int,
foreign key(NR_EXEMPLAR) references exemplar(NR_SEQUENCIA) on delete cascade
);








