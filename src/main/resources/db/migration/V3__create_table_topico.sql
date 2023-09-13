create table topico(
    id bigint not null,
    titulo varchar(50) not null,
    mensagem varchar(300) not null,
    data_criacao datetime not null,
    status varchar(20) not null,
    curso_id bigint not null,
    autor_id bigint not null,
    primary key(id),
    foreign key(curso_id) references curso(id)
    foreign key(autor_id) references usuario(id)
);

insert into usuario values(1, 'Ana da Silva', 'ana@email.com');