create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 apellidos varchar(100) not null,
 cedula varchar(20) not null,
 tipoDocumento varchar(2) not null,
 correo varchar(100) not null,
 fechaCreacion date not null,
 primary key (id)
);

create table tasaInteres (
 id int(11) not null auto_increment,
 nombre varchar(30) not null,
 tasa double not null,
 primary key (id)
);

create table credito (
 id int(11) not null auto_increment,
 idUsuario int not null,
 idTasa int(10) not null,
 valorCredito double not null,
 valorCreditoInteres double not null,
 valorTotalPagar double not null,
 valorTotalPagado double DEFAULT 0.0,
 valorCuotas double not null,
 cuotasTotales int(10) not null,
 cuotasPagadas int(10) DEFAULT 0,
 interesMora double DEFAULT 0,
 estado varchar(5) not null,
 fechaCredito date null,
 primary key (id),
 foreign key (idUsuario) REFERENCES usuario(id),
 foreign key (idTasa) REFERENCES tasaInteres(id)
);

create table detallePagoCredito (
 id int(11) not null auto_increment,
 idCredito int not null,
 valorCuota double not null,
 valorMora double DEFAULT 0,
 fechaPago date not null,
 primary key (id),
 foreign key (idCredito) REFERENCES credito(id)
);