update usuario
set nombre = :nombre,
    apellidos = :apellidos,
    cedula = :cedula,
    tipoDocumento = :tipoDocumento,
    correo = :correo
where id = :id