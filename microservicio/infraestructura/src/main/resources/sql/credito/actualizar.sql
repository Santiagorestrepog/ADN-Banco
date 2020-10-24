update credito
set idUsuario = :idUsuario,
    idTasa = :idTasa,
    valorCredito = :valorCredito,
    valorCreditoInteres = :valorCreditoInteres,
    valorTotalPagar = :valorTotalPagar,
    valorTotalPagado = :valorTotalPagado,
    valorCuotas = :valorCuotas,
    cuotasTotales = :cuotasTotales,
    cuotasPagadas = :cuotasPagadas,
    interesMora = :interesMora,
    estado = :estado,
    fechaCredito = :fechaCredito
where id = :id