CREATE DATABASE baseloginp;

CREATE TABLE usuario (
    nusario    varchar(30) not null,
    nombre     varchar(60),
    apellidos  varchar(110),    
    edad          int
);

comment on table usuario
is 'La tabla de usuario contiene toda la informacion referente a un usuario del sistema';

CREATE TABLE login (
    nusario    varchar(30) not null,  
    password   varchar(32) not null
);
comment on table login
is 'La tabla de log in contiene el nombre de usuario y su contraseña';

alter table usuario add constraint pknusuario primary key (nusario);
alter table login add constraint pklogin primary key (nusario);
alter table login add constraint fknusuario foreign key (nusario) references usuario (nusario);

insert into usuario (nusario,nombre,apellidos,edad) values ('juil30','Julio','Moran', 32);
insert into usuario (nusario,nombre,apellidos,edad) values ('pedro21','Pedro','Lopez', 40);
insert into usuario (nusario,nombre,apellidos,edad) values ('mary78','Maria','Mendoza', 17);
insert into usuario (nusario,nombre,apellidos,edad) values ('mau16','Mauricio','Campos', 23);
insert into usuario (nusario,nombre,apellidos,edad) values ('ilseSu9','Ilse','Peña', 23);

insert into login (nusario,password) values ('juil30',MD5('ki129i'));
insert into login (nusario,password) values ('pedro21',MD5('sjcb12'));
insert into login (nusario,password) values ('mary78',MD5('mmks24'));
insert into login (nusario,password) values ('mau16',MD5('loi232'));
insert into login (nusario,password) values ('ilseSu9',MD5('0mkl2'));
