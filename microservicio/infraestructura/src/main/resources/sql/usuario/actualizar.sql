update usuario
set nombre = :nombre,
    apellidos = :apellidos,
    cedula = :cedula,
    tipoDocumento = :tipoDocumento,
    correo = :correo,
    clave = :clave,
	fechaCreacion = :fechaCreacion
where id = :id