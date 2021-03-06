CREATE TABLE concesionaria (
	id BIGINT IDENTITY
	, nombre VARCHAR(100) NOT NULL
	, config VARCHAR(100) NOT NULL
	, fecha_registracion DATETIME NOT NULL DEFAULT GETDATE()
	, fecha_alta DATETIME NULL
	, codigo VARCHAR(50) NULL
	, direccion VARCHAR(100) NOT NULL
	, cuit VARCHAR(50) NOT NULL
	, tel VARCHAR(50) NOT NULL
	, email VARCHAR(50) NOT NULL
	, PRIMARY KEY(id)
	, FOREIGN KEY(config) REFERENCES config_tecnologica(nombre)
	, UNIQUE(config, id)
	, UNIQUE(cuit)
);