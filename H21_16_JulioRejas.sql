
use master
GO
-- Creación de Base de Datos:
CREATE DATABASE dbeecuyo
GO

--Uso de Base de datos:
USE dbeecuyo
GO
-- tables
-- Table: Administrador
CREATE TABLE Administrador (
    DNIADM char(8)  NOT NULL,
    NOMADM varchar(50)  NOT NULL,
    APEADM varchar(50)  NOT NULL,
    CELADM char(9)  NOT NULL,
    CONSTRAINT Administrador_pk PRIMARY KEY  (DNIADM)
);

-- Table: Cliente
CREATE TABLE Cliente (
    DNICLI char(8)  NOT NULL,
    NOMCLI varchar(50)  NOT NULL,
    CELCLI char(9)  NOT NULL,
    APECLI varchar(50)  NOT NULL,
    DIRCLI varchar(50)  NOT NULL,
    CONSTRAINT Cliente_pk PRIMARY KEY  (DNICLI)
);

-- Table: Despachadores
CREATE TABLE Despachadores (
    DNIDES char(8)  NOT NULL,
    NOMDES varchar(50)  NOT NULL,
    APEDES varchar(50)  NOT NULL,
    CELDES varchar(50)  NOT NULL,
    DNIADM char(8)  NOT NULL,
    CODSUC int  NOT NULL,
    CONSTRAINT Despachadores_pk PRIMARY KEY  (DNIDES)
);

-- Table: Destino
CREATE TABLE Destino (
    CODDEST int  NOT NULL IDENTITY (1,1),
    DIRDES varchar(50)  NOT NULL,
    CODSUC int  NOT NULL,
    DNIDES char(8)  NOT NULL,
    CONSTRAINT Destino_pk PRIMARY KEY  (CODDEST)
);

-- Table: JefeSurcursal
CREATE TABLE JefeSurcursal (
    DNIJEF char(8)  NOT NULL,
    NOMJEF varchar(50)  NOT NULL,
    APEJEF varchar(50)  NOT NULL,
    CELJEF char(9)  NOT NULL,
    DNIADM char(8)  NOT NULL,
    CONSTRAINT JefeSurcursal_pk PRIMARY KEY  (DNIJEF)
);

-- Table: Pizza
CREATE TABLE Pizza (
    CODPIZ int  NOT NULL IDENTITY (1,1),
    NOMPIZ varchar(60)  NOT NULL,
    TIPPIZ varchar(50)  NOT NULL,
    PREPPIZ decimal(10,2)  NOT NULL,
    STOPIZ int  NOT NULL,
    DNIVEN char(8)  NOT NULL,
    DNIJEF char(8)  NOT NULL,
    CONSTRAINT Pizza_pk PRIMARY KEY  (CODPIZ)
);

-- Table: Sucursal
CREATE TABLE Sucursal (
    CODSUC int  NOT NULL IDENTITY (1,1),
    LUGSUC varchar(20)  NOT NULL,
    DNIADM char(8)  NOT NULL,
    DNIJEF char(8)  NOT NULL,
    CONSTRAINT Sucursal_pk PRIMARY KEY  (CODSUC)
);

-- Table: Vendedores
CREATE TABLE Vendedores (
    DNIVEN char(8)  NOT NULL,
    NOMVEN varchar(50)  NOT NULL,
    APEVEN varchar(50)  NOT NULL,
    CELVEN char(9)  NOT NULL,
    DNIADM char(8)  NOT NULL,
    DNIJEF char(8)  NOT NULL,
    CODSUC int  NOT NULL,
    CONSTRAINT Vendedores_pk PRIMARY KEY  (DNIVEN)
);

-- Table: Venta
CREATE TABLE Venta (
    CODVENT int  NOT NULL IDENTITY (1,1),
    TOTVENT decimal(10,2)  NOT NULL,
    CANPROVENT char(4)  NOT NULL,
    FECVEN date  NOT NULL,
    DNIADM char(8)  NOT NULL,
    CODSUC int  NOT NULL,
    DNIVEN char(8)  NOT NULL,
    DNIJEF char(8)  NOT NULL,
    DNIDES char(8)  NOT NULL,
    DNICLI char(8)  NOT NULL,
    CONSTRAINT Venta_pk PRIMARY KEY  (CODVENT)
);

-- Table: Venta_Detalle
CREATE TABLE Venta_Detalle (
    CODVEDE int  NOT NULL IDENTITY (1,1),
    CODVENT int  NOT NULL,
    CODPIZ int  NOT NULL,
    CONSTRAINT Venta_Detalle_pk PRIMARY KEY  (CODVEDE)
);

-- foreign keys
-- Reference: Despachador_Administrador (table: Despachadores)
ALTER TABLE Despachadores ADD CONSTRAINT Despachador_Administrador
    FOREIGN KEY (DNIADM)
    REFERENCES Administrador (DNIADM);

-- Reference: Despachadores_Sucursal (table: Despachadores)
ALTER TABLE Despachadores ADD CONSTRAINT Despachadores_Sucursal
    FOREIGN KEY (CODSUC)
    REFERENCES Sucursal (CODSUC);

-- Reference: Destino_Despachadores (table: Destino)
ALTER TABLE Destino ADD CONSTRAINT Destino_Despachadores
    FOREIGN KEY (DNIDES)
    REFERENCES Despachadores (DNIDES);

-- Reference: Destino_Sucursal (table: Destino)
ALTER TABLE Destino ADD CONSTRAINT Destino_Sucursal
    FOREIGN KEY (CODSUC)
    REFERENCES Sucursal (CODSUC);

-- Reference: JefeSurcursal_Administrador (table: JefeSurcursal)
ALTER TABLE JefeSurcursal ADD CONSTRAINT JefeSurcursal_Administrador
    FOREIGN KEY (DNIADM)
    REFERENCES Administrador (DNIADM);

-- Reference: Pizza_JefeSurcursal (table: Pizza)
ALTER TABLE Pizza ADD CONSTRAINT Pizza_JefeSurcursal
    FOREIGN KEY (DNIJEF)
    REFERENCES JefeSurcursal (DNIJEF);

-- Reference: Pizza_Vendedores (table: Pizza)
ALTER TABLE Pizza ADD CONSTRAINT Pizza_Vendedores
    FOREIGN KEY (DNIVEN)
    REFERENCES Vendedores (DNIVEN);

-- Reference: Sucursal_Administrador (table: Sucursal)
ALTER TABLE Sucursal ADD CONSTRAINT Sucursal_Administrador
    FOREIGN KEY (DNIADM)
    REFERENCES Administrador (DNIADM);

-- Reference: Sucursal_JefeSurcursal (table: Sucursal)
ALTER TABLE Sucursal ADD CONSTRAINT Sucursal_JefeSurcursal
    FOREIGN KEY (DNIJEF)
    REFERENCES JefeSurcursal (DNIJEF);

-- Reference: Vendedores_Administrador (table: Vendedores)
ALTER TABLE Vendedores ADD CONSTRAINT Vendedores_Administrador
    FOREIGN KEY (DNIADM)
    REFERENCES Administrador (DNIADM);

-- Reference: Vendedores_JefeSurcursal (table: Vendedores)
ALTER TABLE Vendedores ADD CONSTRAINT Vendedores_JefeSurcursal
    FOREIGN KEY (DNIJEF)
    REFERENCES JefeSurcursal (DNIJEF);

-- Reference: Vendedores_Sucursal (table: Vendedores)
ALTER TABLE Vendedores ADD CONSTRAINT Vendedores_Sucursal
    FOREIGN KEY (CODSUC)
    REFERENCES Sucursal (CODSUC);

-- Reference: Venta_Administrador (table: Venta)
ALTER TABLE Venta ADD CONSTRAINT Venta_Administrador
    FOREIGN KEY (DNIADM)
    REFERENCES Administrador (DNIADM);

-- Reference: Venta_Cliente (table: Venta)
ALTER TABLE Venta ADD CONSTRAINT Venta_Cliente
    FOREIGN KEY (DNICLI)
    REFERENCES Cliente (DNICLI);

-- Reference: Venta_Despachadores (table: Venta)
ALTER TABLE Venta ADD CONSTRAINT Venta_Despachadores
    FOREIGN KEY (DNIDES)
    REFERENCES Despachadores (DNIDES);

-- Reference: Venta_Detalle_Pizza (table: Venta_Detalle)
ALTER TABLE Venta_Detalle ADD CONSTRAINT Venta_Detalle_Pizza
    FOREIGN KEY (CODPIZ)
    REFERENCES Pizza (CODPIZ);

-- Reference: Venta_Detalle_Venta (table: Venta_Detalle)
ALTER TABLE Venta_Detalle ADD CONSTRAINT Venta_Detalle_Venta
    FOREIGN KEY (CODVENT)
    REFERENCES Venta (CODVENT);

-- Reference: Venta_JefeSurcursal (table: Venta)
ALTER TABLE Venta ADD CONSTRAINT Venta_JefeSurcursal
    FOREIGN KEY (DNIJEF)
    REFERENCES JefeSurcursal (DNIJEF);

-- Reference: Venta_Sucursal (table: Venta)
ALTER TABLE Venta ADD CONSTRAINT Venta_Sucursal
    FOREIGN KEY (CODSUC)
    REFERENCES Sucursal (CODSUC);

-- Reference: Venta_Vendedores (table: Venta)
ALTER TABLE Venta ADD CONSTRAINT Venta_Vendedores
    FOREIGN KEY (DNIVEN)
    REFERENCES Vendedores (DNIVEN);

-- End of file.


--Insertando registros de las tablas 
USE master

USE dbeecuyo;
GO

-- Insertar Datos del Administrador
INSERT INTO Administrador
	(DNIADM, NOMADM, APEADM, CELADM) 
	VALUES 
('70245673','Flavio','Martins','915356250')
GO
SELECT * FROM Administrador
GO
   

-- Insertar Datos del JefeSurcursal
 INSERT INTO JefeSurcursal
  (DNIJEF, NOMJEF, APEJEF, CELJEF, DNIADM) 
	VALUES 
('71245645','Marcelo','Rojas','905356004','70245673'),
('78275873','Eduardo','Garay','915346111','70245673'),
('73244160','Diego','Pardo','965386201','70245673')
GO
SELECT * FROM JefeSurcursal
GO


-- Insertar Datos de la Sucursal
 INSERT INTO Sucursal
  (LUGSUC, DNIADM , DNIJEF) 
	VALUES 
('San Vicente','70245673','71245645'),
('Imperial','70245673', '78275873'),
('Nuevo Imperial','70245673', '73244160')
GO

SELECT * FROM Sucursal
GO


-- Insertar Datos del Cliente
Insert Into Cliente
(DNICLI,NOMCLI,APECLI,DIRCLI,CELCLI) values 
('71245677','Lidia','Uribe','Los libertadores','965386254'),
('73244669','Rosa','Reyes','Av 28 Julio','985346268'),
('15245673','Luciano','Contreras','9 de diciembre','935346658'),
('13245677','Jose','Mendoza','San Aguistin','925341254'),
('71244669','Fabiano','Alzamora','Los Cipreces','925343458'),
('74243679','Julian','Vargas','Ramos Larrea','935346658')
GO

SELECT * FROM Cliente
GO


INSERT INTO Despachadores
 (DNIDES, NOMDES, APEDES, CELDES, DNIADM, CODSUC)
 VALUES
 ('75022476','Juan','Lujan','98942576','70245673','1'),
 ('77023450','Angel','Lujan','90144511','70245673','2'),
 ('72021444','Armando','Lujan','91041509','70245673','3'),
 ('71025492','Jesus','Lujan','99946565','70245673','1'),
 ('70028421','Fermando','Lujan','94440536','70245673','1'),
 ('15002890','Antonio','Smitt','91102454','70245673','1')
GO

SELECT * FROM Despachadores
GO


-- Insertar Datos de los Vendedores
INSERT INTO Vendedores
 (DNIVEN, NOMVEN, APEVEN, CELVEN, DNIADM, DNIJEF, CODSUC)
	VALUES
('15245673','Ruben','Venegas','935356254','70245673','71245645','1'),
('14275873','Julian','Gutierrez','985346254','70245673','78275873','2'),
('15245643','Roberto','Garcia','935356254','70245673','73244160','3')
GO

SELECT * FROM Vendedores
GO


INSERT INTO Destino
 (DIRDES, DNIDES,CODSUC)
 VALUES
 ('Jr Sepulveda','75022476','1'),
 ('28 de Julio','77023450','2'),
 ('Asunción 8','72021444','3'),
 ('Av Libertadores','75022476','1'),
 ('Jr Santa Rosa','75022476','1'),
 ('Jr San Agustin','75022476','1')
 GO

 SELECT * FROM Destino
GO

-- Insertar Datos de los Productos
 INSERT INTO Pizza
  ( NOMPIZ, TIPPIZ, PREPPIZ , STOPIZ, DNIVEN, DNIJEF) 
	VALUES 
('Pizza','Americana','30.50','2','15245673','71245645'),
('Pizza','Pepperoni','20.50','3','14275873','78275873'),
('Pizza','Vegetariana','10.50','4','15245643','73244160'),
('Pizza','Mozarella','21.50','9','15245673','71245645'),
('Pizza','Hawaiana','16.50','6','15245673','71245645'),
('Pizza','Continentalle','35.50','6','15245643','73244160'),
('Pizza','Española','18.50','2','15245643','73244160'),
('Pizza','Súper Margarita 6 Quesos','25.50','13','14275873','78275873'),
('Pizza','La Rocoto Relleno','15.50','9','15245643','73244160')
GO
   

SELECT * FROM Pizza
GO


-- Formato de fecha 
SET DATEFORMAT dmy 
GO

-- Insertar Datos de la Venta
INSERT INTO Venta
 (TOTVENT, CANPROVENT, FECVEN, DNIADM, CODSUC, DNIVEN, DNIJEF, DNIDES,DNICLI)
	VALUES


('20.50','1','21/07/10', '70245673','1','15245673','71245645','75022476','71245677'),
('30.50','8','21/08/14', '70245673','2','14275873','78275873','77023450','73244669'),
('25.50','2','21/09/18', '70245673','3','15245643','73244160','72021444','15245673'),
('35.50','3','21/05/15', '70245673','1','15245673','73244160','72021444','13245677'),
('15.50','1','21/03/01', '70245673','2','14275873','73244160','72021444','71244669'),
('10.50','2','21/05/17', '70245673','3','15245643','73244160','72021444','74243679')

GO





SELECT * FROM Venta
GO

-- Insertar Datos de la Venta_Detalle
INSERT INTO Venta_Detalle
 (CODVENT, CODPIZ)
	VALUES
('1','1'),
('2','2'),
('3','3'),
('4','1'),
('5','2'),
('6','3')
GO

SELECT * FROM Venta_Detalle
GO




-- Creando Vistas 
-- Vista 1




CREATE VIEW vwAdministrador
AS
SELECT 
	V.CANPROVENT AS 'Pizzas Vendidas',
	(V.CANPROVENT * V.TOTVENT) AS 'Monto de Venta',
	S.LUGSUC AS 'Sucursal'
FROM dbo.Vendedores AS VE
INNER JOIN dbo.Venta AS V
ON VE.DNIVEN = V.DNIVEN
INNER JOIN dbo.Sucursal AS S
ON V.CODSUC = S.CODSUC
GO



-- Vista 2

CREATE VIEW vwVendedor
AS
SELECT 
(VE.NOMVEN) + ', ' + (VE.APEVEN) AS 'Vendedor',
V.CANPROVENT AS 'Rankig de Vendedores'
FROM dbo.Vendedores AS VE
INNER JOIN dbo.Venta AS V
ON VE.DNIVEN = V.DNIVEN
GO

-- Vista 3

CREATE VIEW vwVendedores
AS
SELECT 
(VE.NOMVEN) + ', ' + (VE.APEVEN) AS 'Vendedor',
	V.FECVEN AS 'Fecha de Venta',
	V.CANPROVENT AS 'Pizzas Vendidos'
FROM dbo.Vendedores AS VE
INNER JOIN dbo.Venta AS V
ON VE.DNIVEN = V.DNIVEN