CREATE TABLE login (
	id BIGINT IDENTITY NOT NULL
	, username VARCHAR(100) NOT NULL
	, loginTime DATETIME NOT NULL DEFAULT GETDATE()
	, logoutTime DATETIME DEFAULT NULL
	, PRIMARY KEY(id)
	, FOREIGN KEY(username) REFERENCES usuario(username)
);