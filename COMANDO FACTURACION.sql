#CREAR BASE DE DATOS
CREATE DATABASE facturacion

USE facturacion;

#CREAR TABLA TBLUSURIO
CREATE TABLE tblusuario
(codigo INT PRIMARY KEY AUTO_INCREMENT,
usuario VARCHAR(50) NOT NULL, 
email VARCHAR(320) NOT NULL,
contraseña VARCHAR(20)  NOT NULL,
nombre VARCHAR(50) NOT NULL,
rol varchar(50) NOT NULL);

#CREAR TABLA TBLCLIENTE
CREATE TABLE tblcliente
(codigo varchar(20) PRIMARY KEY,
nombre VARCHAR(50) NOT NULL,
apellido VARCHAR(50) NOT NULL,
genero VARCHAR(50) NOT NULL,
dni BIGINT NOT NULL,
telefono VARCHAR(10) NOT NULL,
ruc BIGINT NOT NULL,
email VARCHAR(320),
direcion VARCHAR(100));

#CREAR TABLA TBLMUNICIPIO
create table municipio
(codigomunicipio bigint primary key,
nombre varchar(255));

select * from municipio;
select * from tblcliente;
select * from tblproducto;

insert into municipio 
values(1, 'MEDELLIN - MEDELLIN - ANTIOQUIA');
insert into municipio 
values(2,'PALMITAS - MEDELLIN - ANTIOQUIA');
insert into municipio 
values(3,'SANTA ELENA - MEDELLIN - ANTIOQUIA');

select c.codigo, c.nombre, c.apellido, c.genero, c.dni, c.telefono, c.ruc, c.email, c.direcion, m.nombre 
from tblcliente c inner join municipio m
on c.codigo = m.codigodepartamento
where c.nombre = 'juan';

#CREAR TABLA TBLPRODUCTO
CREATE TABLE tblproducto
(codigo VARCHAR(10) PRIMARY KEY,
nombre VARCHAR(50) NOT NULL,
descripcion VARCHAR(100),
categoria VARCHAR(50),
estado VARCHAR(30),
stock SMALLINT,
preciounitario FLOAT,
foto blob, 
ruta varchar(50));

#RELACION CLIENTE - MINICPIP
alter table tblcliente 
add codmunicipio bigint;

alter table tblcliente
add foreign key(codmunicipio)
references municipio(codigomunicipio);

#-----------------------------------------------------------------
#---SOLO LAS TABLAS DE ARRIBA---------


#CREAR TABLA TIPO ROL
CREATE TABLE tblrol
(codrol INT,
rol VARCHAR(50) NOT NULL,
PRIMARY KEY(codrol, rol));

ALTER TABLE tblrol
ADD FOREIGN KEY(codrol)
REFERENCES tblusuario(codigo);

select codigo, nombre, descripcion, categoria, estado, stock, preciounitario
from tblproducto
where codigo = 'prod0003';


insert into tblproducto(codigo, nombre, descripcion, categoria, estado, stock, preciounitario, foto, ruta)
values ('prod0000', 'camisa', 'camisa xl', 'textil', 'Activo', 12, 200000, null, null);

insert into tblusuario values
('juan', 'juan@gmail.com','123', 'juan', 'Usuario');

select * from tblproducto;
select * from tblusuario;
truncate table tblproducto;

#CREAR TABLA TBLFACTURA
CREATE TABLE TBLFACTURA
(CODIGO VARCHAR(10),
FECHA DATE NOT NULL,
CANTIDAD SMALLINT NOT NULL,
PRECIOVENTA FLOAT NOT NULL,
SUBTOTAL FLOAT NOT NULL,
TOTALPAGAR FLOAT NOT NULL,
IVA FLOAT  NOT NULL);

#CREAR TABLA TBLGENERADOR
CREATE TABLE tblgenerador
(nombretabla VARCHAR(30) PRIMARY KEY NOT NULL,
numero SMALLINT NOT NULL);



