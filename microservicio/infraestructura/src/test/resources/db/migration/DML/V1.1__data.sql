insert into usuario (id, nombre,apellidos,cedula,tipoDocumento,correo,fechaCreacion)
values (1,'Felipe', 'restrepo', 43529937, 'CC', 'Hola@hola.com' , now());

insert into usuario (id, nombre,apellidos,cedula,tipoDocumento,correo,fechaCreacion)
values (2,'Ramon', 'Gamboa', 4352349937, 'CC', 'Hola2@hola.com' , now());

insert into usuario (id, nombre,apellidos,cedula,tipoDocumento,correo,fechaCreacion)
values (3,'Fernando', 'angel', 431349937, 'CC', 'Hola3@hola.com' , now());

insert into usuario (id, nombre,apellidos,cedula,tipoDocumento,correo,fechaCreacion)
values (4,'Ronaldo', 'angel', 431369937, 'CC', 'Hola4@hola.com' , now());

INSERT INTO tasainteres (id, nombre, tasa)
VALUES (1, 'Libre inversion', 5);

INSERT INTO tasainteres (id, nombre, tasa)
VALUES (2, 'Vivienda', 3);

INSERT INTO credito ( idUsuario, idTasa, valorCredito, valorCreditoInteres, valorTotalPagar, valorTotalPagado, valorCuotas, cuotasTotales, cuotasPagadas, interesMora, estado, fechaCredito)
VALUES ( 1, 1, 100000, 105000, 0, 105000, 35000, 3, 3, 0, '0', '2020-08-14');

INSERT INTO credito ( idUsuario, idTasa, valorCredito, valorCreditoInteres, valorTotalPagar, valorTotalPagado, valorCuotas, cuotasTotales, cuotasPagadas, interesMora, estado, fechaCredito)
VALUES ( 2, 1, 100000, 105000, 0, 105000, 35000, 3, 3, 0, '1', '2020-08-14');



