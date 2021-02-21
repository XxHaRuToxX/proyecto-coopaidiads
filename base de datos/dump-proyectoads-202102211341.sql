-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: proyectoads
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.38-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `cargo_Cliente` varchar(20) DEFAULT NULL,
  `contraseña_Cliente` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `persona` (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (2,'Cliente','72817272'),(8,'Cliente','12345');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL,
  `nombres` varchar(30) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `fecha_Nacimiento` date DEFAULT NULL,
  `genero` varchar(10) DEFAULT NULL,
  `usuario` varchar(60) DEFAULT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Pedro','Mauricio','72817272','1999-12-23','Masculino','Cidsa','av.juan','938271211'),(2,'Lucas','Pana','72817272','1999-12-23','Masculino','CL001','av.juan','938271211'),(5,'Mateo','Carrasco','72817272','1999-12-23','Masculino','CC002','av.juan','938271211'),(6,'Marcos','Sajami','72817271','2001-12-23','Masculino','marcos12','av.juan','938271211'),(7,'Javier','Moreno','72817271','2001-12-23','Masculino','20javierem','av.juan','938271211'),(8,'Javier','Moreno','72817271','2001-12-23','Masculino','usuario1','av.juan','938271211'),(9,'Luis','Coronavirus','94373232','1999-03-23','Masculino','luisxx','Av, Lucre','984737222');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `codigo_producto` varchar(4) DEFAULT NULL,
  `nombre_producto` varchar(30) DEFAULT NULL,
  `precio_producto` float DEFAULT NULL,
  `desc_producto` varchar(150) DEFAULT NULL,
  `cantidad_producto` float DEFAULT NULL,
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'TROP','C. Tropical',15,'mal estado',15),(2,'TROP','C. Tropical',15,'Buen Estado',40),(4,'TROP','C. Criollo',20,'Buen Estado',40),(5,'CRIO','C. Criollo',20,'Buen Estado',40);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `id_proveedor` int(11) NOT NULL,
  `direccion_proveedor` varchar(150) DEFAULT NULL,
  `razon_social` varchar(50) DEFAULT NULL,
  `ruc_proveedor` varchar(11) DEFAULT NULL,
  `telefono_proveedor` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'Jiron Manzanares','Los caramelos SAC','10928383121','973646273'),(2,'Jiron Lucre','Los Cementos SAC','10494848321','966563373'),(3,'Av. Lucas','Los casa de','18737223234','974636212'),(6,'Av. Marcos','Los Soplones Sac','10983842232','938373722'),(7,'Av. Manzanares','Los Sanguchitos EIRL','92838821212','928273232'),(8,'av lucre','Los Montesino Sac','28283727271','938727322'),(11,'Av. Los Morenos','Mazamorras Sac','23901929383','987473232'),(12,'Av. Mazamorras','ssssdfff','232323','46565454'),(13,'ddddd','sssdsdsd','3344343','45553'),(14,'ffdddd','hhhhhh','3344343','45553'),(15,'','','','193838828'),(16,'Av. Lima','Los caramelos sac','1233243333','323423323'),(17,'dssdsd','ddsdsd','221222','345665443'),(18,'sada','sasdad','12212212','121212122');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockproductos`
--

DROP TABLE IF EXISTS `stockproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockproductos` (
  `id_stockproducto` int(11) NOT NULL,
  `stock_criollo` float DEFAULT NULL,
  `stock_tropical` float DEFAULT NULL,
  `stock_amazonico` float DEFAULT NULL,
  PRIMARY KEY (`id_stockproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockproductos`
--

LOCK TABLES `stockproductos` WRITE;
/*!40000 ALTER TABLE `stockproductos` DISABLE KEYS */;
INSERT INTO `stockproductos` VALUES (1,75,20,45),(2,25,20,45),(3,25,10,45),(4,65,10,45),(5,65,10,45);
/*!40000 ALTER TABLE `stockproductos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajador`
--

DROP TABLE IF EXISTS `trabajador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabajador` (
  `id_trabajador` int(11) NOT NULL,
  `sueldo` float DEFAULT NULL,
  `cargo_Trabajador` varchar(20) DEFAULT NULL,
  `contraseña_Trabajador` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_trabajador`),
  CONSTRAINT `trabajador_ibfk_1` FOREIGN KEY (`id_trabajador`) REFERENCES `persona` (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajador`
--

LOCK TABLES `trabajador` WRITE;
/*!40000 ALTER TABLE `trabajador` DISABLE KEYS */;
INSERT INTO `trabajador` VALUES (5,6050,'Administrador','12345'),(6,7050,'Administrador','12345'),(7,5050,'Contador','12345'),(9,6000,'Almacenero','12345');
/*!40000 ALTER TABLE `trabajador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'proyectoads'
--
/*!50003 DROP FUNCTION IF EXISTS `fnIdPersona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnIdPersona`() RETURNS int(11)
begin 
	declare fIdP int;
	if((select count(id_persona) from persona)=0) then
		set fIdP=1;
	else 
		set fIdP=(select max(id_persona)+1 from persona);
	end if;

	return fIdP;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fnIdProducto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnIdProducto`() RETURNS int(11)
begin 
	declare fIdP int;
	if((select count(id_producto) from producto )=0) then
		set fIdP=1;
	else 
		set fIdP=(select max(id_producto)+1 from producto);
	end if;

	return fIdP;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fnIdProveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnIdProveedor`() RETURNS int(11)
begin 
	declare fIdP int;
	if((select count(id_proveedor) from proveedor )=0) then
		set fIdP=1;
	else 
		set fIdP=(select max(id_proveedor)+1 from proveedor);
	end if;

	return fIdP;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fnIdStockProducto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnIdStockProducto`() RETURNS int(11)
begin 
	declare fIdP int;
	if((select count(id_stockproducto) from stockProducto )=0) then
		set fIdP=1;
	else 
		set fIdP=(select max(id_stockproducto)+1 from stockProducto);
	end if;

	return fIdP;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fnIdStockProductos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnIdStockProductos`() RETURNS int(11)
begin 
	declare fIdP int;
	if((select count(id_stockproducto) from stockProductos )=0) then
		set fIdP=1;
	else 
		set fIdP=(select max(id_stockproducto)+1 from stockProductos);
	end if;

	return fIdP;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fnProductoAmazonico` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnProductoAmazonico`() RETURNS varchar(60) CHARSET latin1
begin 
	Declare vUserCliente varchar(60);
	Declare vUserCliInt varchar(60);
	Set vUserCliInt = (Select right(max(codigo_producto),3)+1 from producto);
		IF (vUserCliInt<=9) THEN
			Set vUserCliente = concat('A00',vUserCliInt);
		ELSEIF (vUserCliInt>9 && vUserCliInt<=99) THEN
			Set vUserCliente = concat('A0',vUserCliInt);
		ELSEIF (vUserCliInt>99 && vUserCliInt<=999) THEN
			Set vUserCliente = concat('A',vUserCliInt);
		END IF;
	
	RETURN vUserCliente;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fnProductoCriollo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnProductoCriollo`() RETURNS varchar(4) CHARSET latin1
begin 
	Declare vUserCliente varchar(60);
	Declare vUserCliInt varchar(60);
	Set vUserCliInt = (Select right(max(codigo_producto),3)+1 from producto);
		IF (vUserCliInt<=9) THEN
			Set vUserCliente = concat('C00',vUserCliInt);
		ELSEIF (vUserCliInt>9 && vUserCliInt<=99) THEN
			Set vUserCliente = concat('C0',vUserCliInt);
		ELSEIF (vUserCliInt>99 && vUserCliInt<=999) THEN
			Set vUserCliente = concat('C',vUserCliInt);
		END IF;
	
	RETURN vUserCliente;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fnProductoTropical` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnProductoTropical`() RETURNS varchar(4) CHARSET latin1
begin 
	
	declare vUserTrabajador varchar(60);
	Declare vUserTraInt varchar(60);
	Set vUserTraInt = (Select right(max(codigo_producto),3)+1 from producto);
		IF (vUserTraInt<=9) THEN
			Set vUserTrabajador = concat('T00',vUserTraInt);
		ELSEIF (vUserTraInt>9 && vUserTraInt<=99) THEN
			Set vUserTrabajador = concat('T0',vUserTraInt);
		ELSEIF (vUserTraInt>99 && vUserTraInt<=999) THEN
			Set vUserTrabajador = concat('T',vUserTraInt);
		END IF;
	return vUserTrabajador;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fnUsuarioCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnUsuarioCliente`() RETURNS varchar(60) CHARSET latin1
begin 
	Declare vUserCliente varchar(60);
	Declare vUserCliInt varchar(60);
	Set vUserCliInt = (Select right(max(usuario_Cliente),3)+1 from cliente);
		IF (vUserCliInt<=9) THEN
			Set vUserCliente = concat('C00',vUserCliInt);
		ELSEIF (vUserCliInt>9 && vUserCliInt<=99) THEN
			Set vUserCliente = concat('C0',vUserCliInt);
		ELSEIF (vUserCliInt>99 && vUserCliInt<=999) THEN
			Set vUserCliente = concat('C',vUserCliInt);
		END IF;
	
	RETURN vUserCliente;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fnUsuarioTrabajador` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnUsuarioTrabajador`() RETURNS varchar(60) CHARSET latin1
begin 
	
	declare vUserTrabajador varchar(60);
	Declare vUserTraInt varchar(60);
	Set vUserTraInt = (Select right(max(usuario_Trabajador),3)+1 from trabajador);
		IF (vUserTraInt<=9) THEN
			Set vUserTrabajador = concat('T00',vUserTraInt);
		ELSEIF (vUserTraInt>9 && vUserTraInt<=99) THEN
			Set vUserTrabajador = concat('T0',vUserTraInt);
		ELSEIF (vUserTraInt>99 && vUserTraInt<=999) THEN
			Set vUserTrabajador = concat('T',vUserTraInt);
		END IF;
	return vUserTrabajador;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deletePersona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deletePersona`(
in pIdcli int,
in pIdPer int
)
begin
	declare vFlag int;
	set vFlag=(select id_trabajador from trabajador where id_trabajador=pIdcli);
	delete from trabajador where id_trabajador =vFlag;
	delete from persona where id_persona =pIdPer;
	
	
	
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spGestionarPersona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spGestionarPersona`(
in op char,
in pId int,
in pDireccion varchar(150),
in pTelefono varchar(9),
in pSueldo float,
in pCargo varchar(20),
in pContraseña varchar(20)
)
begin
	
	if op='a' then 
		update persona set direccion=pDireccion,telefono =pTelefono where id_persona =pid;
		update trabajador set sueldo =pSueldo, cargo_Trabajador=pCargo,contraseña_Trabajador=pContraseña where id_trabajador=pid;
		update cliente set cargo_Cliente=pCargo, contraseña_Cliente=pContraseña where id_cliente =pid;
	else
		if op='e' then
			delete from trabajador where id_trabajador=pid;
			delete from cliente where id_cliente=pid;
			delete from persona where id_persona =pid;
		end if;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spGestionarProducto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spGestionarProducto`(
in vFlag char(1),
in vIdPro int,
in vCodigo varchar(4),
in vNombre varchar(30), 
in vPrecio float,
in vDesc varchar(150),
in vCantidad float
)
begin 
		declare varCantDB float;
	declare varidstock1 int;
	declare  varCantidad float;
	 declare varCantDB1 float;
	 declare varCantDB2 float;
	 declare varID int;
	declare varIDstock int;
	set varID=(select id_stockproducto from producto inner join stockproductos on id_producto=id_stockproducto where id_stockproducto =(select max(id_stockproducto ) from stockproductos));
	set varidstock=(select max(id_stockproducto) from stockproductos);
	set varidstock1=(select cantidad_producto from producto where id_producto =vIdPro);
	-- set varId=(select count(id_stockproducto) from stockProductos);
	 set varCantidad = (select cantidad_producto from producto where id_producto=vIdPro);
	 set varCantDB = (select stock_criollo from stockProductos where id_stockproducto = varidstock);
	 set varCantDB1 = (select stock_tropical from stockProductos where id_stockproducto = varidstock);
	 set varCantDB2 = (select stock_amazonico from stockProductos where id_stockproducto = varidstock);
	
	 
	 -- set varCantDB1 = (select stock_tropical from stockProductos where id_stockproducto = varidstock);
	 -- set varCantDB2 = (select stock_amazonico from stockProductos where id_stockproducto = varidstock);
	case vFlag 
		when 'c' then 				
				insert into producto values(fnIdProducto(),vcodigo ,vNombre,vPrecio,vDesc,vCantidad);
				if(vcodigo='CRIO')then
					insert into stockproductos values(fnIdStockProductos(),varCantDB+vCantidad,varCantDB1,varCantDB2);
				-- update stockproductos set stock_criollo=stock_criollo+vCantidad where id_stockproducto=varidstock;
				elseif(vcodigo='TROP')then
					insert into stockproductos values(fnIdStockProductos(),varCantDB,varCantDB1+vCantidad,varCantDB2);
				-- update stockproductos set stock_tropical=stock_tropical+vCantidad where id_stockproducto=varidstock;
				elseif(vcodigo='FAMA')then
					insert into stockproductos values(fnIdStockProductos(),varCantDB,varCantDB1,varCantDB2+vCantidad);
				-- update stockproductos set stock_amazonico=stock_amazonico+vCantidad where id_stockproducto=varidstock;
				end if;
		when 'a'then
			update producto set  codigo_producto =vCodigo , nombre_producto =vNombre ,precio_producto =vPrecio,desc_producto =vDesc,cantidad_producto=vCantidad where id_producto =vIdPro;
			if(vcodigo='CRIO')then
					update stockproductos set stock_criollo=stock_criollo+(vCantidad-varCantidad) where id_stockproducto=varidstock;
				elseif(vcodigo='TROP')then
					update stockproductos set stock_tropical=stock_tropical+(vCantidad-varCantidad) where id_stockproducto=varidstock;
				elseif(vcodigo='FAMA')then
					update stockproductos set stock_amazonico=stock_amazonico+(vCantidad-varCantidad) where id_stockproducto=varidstock;
				end if;
		when 'e' then 
			-- delete from stockproductos where id_stockproducto=varidstock;
			delete from producto where id_producto =vIDPro;
				if(vcodigo='CRIO')then
					update stockproductos set stock_criollo=stock_criollo-varCantidad where id_stockproducto=varidstock;
				elseif(vcodigo='TROP')then
					update stockproductos set stock_tropical=stock_tropical-varCantidad where id_stockproducto=varidstock;
				elseif(vcodigo='FAMA')then
					update stockproductos set stock_amazonico=stock_amazonico-varCantidad where id_stockproducto=varidstock;
				end if;
			
	end case;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spGestionarProveedores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spGestionarProveedores`(
in vFlag char(1),
in vIdPro int(11),
in vDireccion varchar(150),
in vRazon varchar(50), 
in vRuc varchar(11),
in vTele varchar(9)
)
begin 
	case vFlag 
		when 'c' then 
			insert into proveedor values(fnIdProveedor(),vDireccion,vRazon,vRuc,vTele);
		when 'a'then
			update proveedor set  direccion_proveedor =vDireccion, razon_social =vRazon,ruc_proveedor =vRuc,telefono_proveedor =vTele where id_proveedor =vIDPro;
		when 'e' then 
			delete from proveedor where id_proveedor =vIDPro;
	end case;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spInsertarPersona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spInsertarPersona`(
in pNombre varchar(30),
in pApellidos varchar(50),
in pDni varchar(8),
in pNacimiento date,
in pGenero varchar(10),
in pUsuario varchar(60),
in pDireccion varchar(150),
in pTelefono varchar(9),
in pSueldo float,
in pCargo varchar(20),
in pContraseña varchar(20)
)
begin
			declare varID,varIDalterno int;
			declare varFlag int;
			
			select count(id_persona),id_persona into varFlag,varIDalterno from persona
			where nombres=pNombre and apellidos=pApellidos and dni=pDni and fecha_Nacimiento=pNacimiento and 
			genero=pGenero and usuario=pUsuario and direccion=pDireccion and telefono=pTelefono;
			
			select max(id_persona) + 1 into varID from persona;
			
			/*set varID=(select max(id_perosna)+1 from perosna);*/
			if(varFlag>0)then
				if(psueldo=0)then
				insert into cliente() values(varIDalterno,pCargo,pContraseña);
				else
				insert into trabajador() values(varIDalterno,pSuelto,pCargo,pContraseña);
				end if;
			else
			
			insert into Persona() values (varID,pNombre,pApellidos,pDNI,pNacimiento,pGenero,pUsuario,pDireccion,pTelefono);
			if(psueldo=0)then
				insert into cliente() values(varID,pCargo,pContraseña);
				else
				insert into trabajador() values(varID,pSueldo,pCargo,pContraseña);
				end if;
			end if;
	
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-21 13:41:46
