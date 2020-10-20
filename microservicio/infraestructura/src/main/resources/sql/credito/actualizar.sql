update CREDITO
set valorCredito = :valorCredito,
    idUsuario = :idUsuario,
    tipoCredito = :tipoCredito,
    tasaInteres = :tasaInteres,
    cuotasTotales = :cuotasTotales,
    cuotasPagadas = :cuotasPagadas,
	estado = :estado,
	valorActual = :valorActual,
	interesMora = :interesMora
where id = :id