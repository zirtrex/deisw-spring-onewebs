INSERT INTO `users` VALUES
    (1,1,'$2a$10$kLqB99f2EztGnF2AJ2qrIOZOgYrNd6l7005NAV9GlLrD04CyDGBrC','police1'),
    (2,1,'$2a$10$B3Q6sY7asLdbP/7QkKyhbua.Dm4YwfqVHNsVU5aq29IdrlQjfHIr.','commissar1'),
    (3,1,'$2a$10$RZXJ8Jspz2LPOo4DsZYW4eVrXpPmRgLW3nF2zgrhUiG2z4LI1ixVC','commander1'),
    (4,1,'$2a$10$dq.kaKm.0CamocEkaCptfevGpGuc12YKlMzuzoeMPUiuuvzsyzV3a','police2'),
    (5,1,'$2a$10$ty5PRLmIkTpDDup0eOy.fenLBSgyq/y3MkIPjQFoBAFkbfYh0eqsW','police3');
INSERT INTO `authorities` VALUES
    (3,'ACCESS_ADDDETAINEE',1),
    (2,'ACCESS_ADDMULCT',1),(1,'ROLE_POLICE',1),(5,'ACCESS_DELMULCT',2),
    (7,'ACCESS_EDITDETAINEE',2),(6,'ACCESS_EDITMULCT',2),(4,'ROLE_COMMISSAR',2),
    (11,'ACCESS_ADDPOLICESTATION',3),(9,'ACCESS_DELMULCT',3),(10,'ACCESS_EDITMULCT',3),
    (8,'ROLE_COMMANDER',3),(14,'ACCESS_ADDDETAINEE',4),(13,'ACCESS_ADDMULCT',4),
    (12,'ROLE_POLICE',4),(17,'ACCESS_ADDDETAINEE',5),(16,'ACCESS_ADDMULCT',5),
    (15,'ROLE_POLICE',5);
INSERT INTO `comisarias` VALUES
    (1,'Fuerte policia de San isidro','Av. breasil ','SAN ISIDRO'),
    (2,'Comisaria La Victoria','Jr. Luna Pizarro','La VIctoria');
INSERT INTO `detenidos` VALUES
    (1,'CHURA','Chorrillos','41526395','2003-02-05','JOSE'),
    (2,'MARTINEZ','CHORRILLOS','48596351','2020-08-25','MARCO'),
    (3,'SANCHEZ','VILLA','47589632','1999-02-17','CARLOS'),
    (4,'GREGORINI','SURCO','75869322','2000-01-01','FRANCO'),
    (5,'DE LA FLOR','Chorrillos','74859632','2005-06-05','GUILLERMOS'),
    (6,'MACURI LUMBE','SURCO','74859632','2004-05-06','HIRO'),
    (7,'TARDILLO','Chorrillos','78965412','2020-05-01','JAHIR'),
    (8,'MERCADO','Breña','74589632','2020-05-01','JESUS'),
    (9,'MELENDEZ','Breña','41526396','2020-04-30','ROSA'),
    (10,'LOPEZ','Surco','47586932','2020-05-06','MARCOS'),
    (12,'LUNA PIZARRO','BREÑA','12345678','1998-05-19','JORGE ARTURO'),
    (13,'PRADO LOZA','SAN ISIDRO','74859612','1957-03-20','JAVER'),
    (14,'DEL POZO HONDO','Jesus Maria II','99887766','2000-08-09','JOSE CARLOS CARLIN');
INSERT INTO `multas` VALUES
    (1,'Av, 28 de julio','2020-06-11 05:00:00.000000','DL-1253',325,9),
    (2,'Av. Wilson','2020-07-20 05:00:00.000000','DL-1252',211,7),
    (3,'Jr. Luna pizzaro 1526','2019-12-31 05:00:00.000000','DL-1254',480,10),
    (4,'Av.  Javier Prado 1856','2020-05-12 05:00:00.000000','DL-1252',180,6),
    (5,'Av. La marina 1582','1998-05-15 05:00:00.000000','DL-1252',580,4),
    (6,'Av. Foucet 1458','2003-08-20 05:00:00.000000','DL-1252',150,8),
    (7,'Av. Ricardo Palma','2003-08-20 05:00:00.000000','DL-1252',250,8),
    (8,'Av. Ricardo Palma','2003-08-20 05:00:00.000000','DL-1252',250,8),
    (9,'Av. Peti tuart','2003-08-20 05:00:00.000000','DL-1252',250,8),
    (10,'Av. Peti tuart','2003-08-20 05:00:00.000000','DL-1252',250,8),
    (11,'Av. Universitaria','2020-06-26 05:00:00.000000','DL-1252',99,8),
    (12,'Av. Universitaria','2020-06-26 05:00:00.000000','DL-1252',99,5),
    (13,'Av. Foucet','2020-06-10 00:00:00.000000','DL-1252',99,2),
    (14,'Av. Universitaria','2020-06-26 05:00:00.000000','DL-1252',99,2),
    (15,'Av. Universitaria','2020-06-26 00:00:00.000000','DL-1252',99,2),
    (16,'Av. Universitaria','2020-06-26 00:00:00.000000','DL-1252',99,2),
    (17,'Av. La MAR','2020-06-01 00:00:00.000000','DL-1251',159,1);
