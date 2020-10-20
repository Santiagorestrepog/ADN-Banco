create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 apellidos varchar(100) not null,
 cedula varchar(100) not null,
 tipoDocumento varchar(100) not null,
 correo varchar(100) not null,
 clave varchar(45) not null,
 fechaCreacion date null,
 primary key (id)
);


create table credito (
 id int(11) not null auto_increment,
 valorCredito double not null,
 idUsuario int not null,
 tipoCredito varchar(100) not null,
 tasaInteres int(10) not null,
 cuotasTotales int(10) not null,
 cuotasPagadas int(10) DEFAULT 0,
 estado varchar(5) not null,
 valorActual double not null,
 interesMora double DEFAULT 0,
 fechacredito date null,
 primary key (id)
);