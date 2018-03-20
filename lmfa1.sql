-- MySQL dump 10.16  Distrib 10.1.31-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: lmfa
-- ------------------------------------------------------
-- Server version	10.1.31-MariaDB

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
-- Table structure for table `Articulo`
--

DROP TABLE IF EXISTS `Articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Articulo` (
  `categoria` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `proveedor` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `precio` double(5,2) NOT NULL,
  PRIMARY KEY (`nombre`,`proveedor`),
  KEY `categoria` (`categoria`),
  KEY `proveedor` (`proveedor`),
  CONSTRAINT `Articulo_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `Categoria` (`categoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Articulo_ibfk_2` FOREIGN KEY (`proveedor`) REFERENCES `Proveedor` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Articulo`
--

LOCK TABLES `Articulo` WRITE;
/*!40000 ALTER TABLE `Articulo` DISABLE KEYS */;
INSERT INTO `Articulo` VALUES ('Productos de media y baja rotación','Air T, Inc.','BALON',404.22),('Productos de alta rotación','Eagle Bulk Shipping Inc.','BALON',908.47),('Productos importados','Eldorado Resorts, Inc.','BALON',663.55),('Productos de temporada','Finjan Holdings, Inc.','BALON',772.29),('Productos importados','Global Eagle Entertainment Inc.','BALON',999.99),('Productos de temporada','Mesabi Trust','BALON',196.82),('Productos de consumo popular','National Beverage Corp.','BALON',271.00),('Productos de alta rotación','Scorpio Bulkers Inc.','BALON',614.32),('Productos gancho','Alexander & Baldwin Holdings, Inc.','BUFFANDA',999.99),('Productos de impulso','Xencor, Inc.','BUFFANDA',285.70),('Productos de temporada','Air T, Inc.','CARCASA DE CELULAR',717.17),('Productos de impulso','Global Eagle Entertainment Inc.','CARCASA DE CELULAR',999.99),('Productos gancho','L3 Technologies, Inc.','CARCASA DE CELULAR',999.99),('Productos importados','Mesabi Trust','CARCASA DE CELULAR',131.76),('Productos gancho','U.S. Bancorp','CARCASA DE CELULAR',396.72),('Productos de alta rotación','UMH Properties, Inc.','CARCASA DE CELULAR',999.99),('Productos importados','Workiva Inc.','CARCASA DE CELULAR',999.99),('Productos importados','Zillow Group, Inc.','CARCASA DE CELULAR',999.99),('Productos gancho','America First Multifamily Investors, L.P.','CARTERA',999.99),('Productos de impulso','Coherent, Inc.','CARTERA',999.99),('Productos de temporada','Douglas Dynamics, Inc.','CARTERA',999.99),('Productos de media y baja rotación','Giga-tronics Incorporated','CARTERA',327.16),('Productos importados','Kelly Services, Inc.','CARTERA',818.48),('Productos de alta rotación','The Community Financial Corporation','CARTERA',133.40),('Productos importados','Virtu Financial, Inc.','CARTERA',999.99),('Productos de impulso','Western Asset/Claymore U.S Treasury Inflation Prot','CARTERA',999.99),('Productos de alta rotación','Yangtze River Development Limited','CARTERA',239.89),('Productos de alta rotación','Motorcar Parts of America, Inc.','CASCO',139.53),('Productos de alta rotación','Virtu Financial, Inc.','CASCO',999.99),('Productos de alta rotación','Yingli Green Energy Holding Company Limited','CASCO',999.99),('Productos de consumo popular','Amedica Corporation','CHAMARRA',913.26),('Productos gancho','Cato Corporation (The)','CHAMARRA',579.08),('Productos de media y baja rotación','Changyou.com Limited','CHAMARRA',183.19),('Productos importados','Gabelli Convertible and Income Securities Fund, In','CHAMARRA',707.79),('Productos de temporada','Teekay Tankers Ltd.','CHAMARRA',999.99),('Productos de media y baja rotación','Virtu Financial, Inc.','CHAMARRA',837.04),('Productos de impulso','Yingli Green Energy Holding Company Limited','CHAMARRA',470.04),('Productos de alta rotación','Copa Holdings, S.A.','CHAPATAS',50.00),('Productos gancho','Frontline Ltd.','CUADRO',480.36),('Productos importados','Symantec Corporation','CUADRO',344.19),('Productos importados','W.W. Grainger, Inc.','CUADRO',623.93),('Productos importados','America First Multifamily Investors, L.P.','ESTAMPA',999.99),('Productos importados','Copa Holdings, S.A.','ESTAMPA',999.99),('Productos de alta rotación','Motorcar Parts of America, Inc.','ESTAMPA',999.99),('Productos de media y baja rotación','UMH Properties, Inc.','ESTAMPA',320.15),('Productos de alta rotación','Copa Holdings, S.A.','GORRA',100.00),('Productos de temporada','Giga-tronics Incorporated','GORRA',999.99),('Productos de alta rotación','Global Eagle Entertainment Inc.','GORRA',999.99),('Productos de temporada','Live Oak Bancshares, Inc.','GORRA',628.11),('Productos de impulso','Magic Software Enterprises Ltd.','GORRA',200.87),('Productos de alta rotación','Nuveen Municipal 2021 Target Term Fund','GORRA',999.99),('Productos de temporada','SMART Global Holdings, Inc.','GORRA',999.99),('Productos de media y baja rotación','W.W. Grainger, Inc.','GORRA',999.99),('Productos importados','Zafgen, Inc.','GORRA',529.42),('Productos de media y baja rotación','PowerShares Russell 1000 Low Beta Equal Weight Por','HOODIE',161.43),('Productos de media y baja rotación','Zafgen, Inc.','HOODIE',457.97),('Productos de alta rotación','Air T, Inc.','JERSEY',117.60),('Productos gancho','Gabelli Convertible and Income Securities Fund, In','JERSEY',999.99),('Productos gancho','Ingevity Corporation','JERSEY',403.55),('Productos gancho','UMH Properties, Inc.','JERSEY',999.99),('Productos de impulso','American Vanguard Corporation','LLAVERO',599.77),('Productos gancho','Flagstar Bancorp, Inc.','LLAVERO',999.99),('Productos gancho','Frontline Ltd.','LLAVERO',999.99),('Productos importados','Insight Select Income Fund','LLAVERO',351.69),('Productos gancho','MaxPoint Interactive, Inc.','LLAVERO',999.99),('Productos gancho','PennantPark Investment Corporation','LLAVERO',121.52),('Productos importados','The Obesity ETF','LLAVERO',649.97),('Productos de impulso','Air T, Inc.','PELUCHE',580.62),('Productos gancho','Ottawa Bancorp, Inc.','PELUCHE',702.56),('Productos de impulso','Symantec Corporation','PELUCHE',999.99),('Productos importados','The Community Financial Corporation','PELUCHE',999.99),('Productos de impulso','Amedica Corporation','PLAYERA',245.05),('Productos de impulso','ClearBridge Energy MLP Opportunity Fund Inc.','PLAYERA',999.99),('Productos de alta rotación','L3 Technologies, Inc.','PLAYERA',319.66),('Productos de media y baja rotación','Luxoft Holding, Inc.','PLAYERA',999.99),('Productos de consumo popular','Motorcar Parts of America, Inc.','PLAYERA',999.99),('Productos de consumo popular','Shaw Communications Inc.','PLAYERA',390.07),('Productos de consumo popular','UMH Properties, Inc.','PLAYERA',390.07),('Productos importados','Community Health Systems, Inc.','POSTER',416.74),('Productos importados','Copa Holdings, S.A.','POSTER',999.99),('Productos importados','Frontline Ltd.','POSTER',100.00),('Productos de media y baja rotación','Oritani Financial Corp.','POSTER',500.60),('Productos de temporada','Frontline Ltd.','POSTERSITO',148.57),('Productos de consumo popular','Air T, Inc.','TENNIS',682.31),('Productos de impulso','EDAP TMS S.A.','TENNIS',677.65),('Productos de impulso','II-VI Incorporated','TENNIS',950.16),('Productos de temporada','Inseego Corp.','TENNIS',999.99),('Productos de media y baja rotación','The Obesity ETF','TENNIS',740.83),('Productos de media y baja rotación','The Obesity ETF','TENNISHOES',740.83),('Productos de impulso','American Capital Senior Floating, Ltd.','VASO',676.99),('Productos de consumo popular','Brixmor Property Group Inc.','VASO',999.99),('Productos de consumo popular','Scorpio Bulkers Inc.','VASO',967.67),('Productos de temporada','Shaw Communications Inc.','VASO',960.20),('Productos importados','Virtu Financial, Inc.','VASO',397.80);
/*!40000 ALTER TABLE `Articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BonoEMpleado`
--

DROP TABLE IF EXISTS `BonoEMpleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BonoEMpleado` (
  `CURP` varchar(18) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fecha` date NOT NULL,
  `monto` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`CURP`,`fecha`),
  CONSTRAINT `BonoEMpleado_ibfk_1` FOREIGN KEY (`CURP`) REFERENCES `Empleado` (`CURP`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BonoEMpleado`
--

LOCK TABLES `BonoEMpleado` WRITE;
/*!40000 ALTER TABLE `BonoEMpleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `BonoEMpleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Calle`
--

DROP TABLE IF EXISTS `Calle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Calle` (
  `nombreColonia` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombreCalle` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`nombreCalle`),
  KEY `nombreColonia` (`nombreColonia`),
  CONSTRAINT `Calle_ibfk_1` FOREIGN KEY (`nombreColonia`) REFERENCES `Colonia` (`nombreColonia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Calle`
--

LOCK TABLES `Calle` WRITE;
/*!40000 ALTER TABLE `Calle` DISABLE KEYS */;
INSERT INTO `Calle` VALUES ('ALPIZAHUA','Fair Oaks'),('CARREON (CARRION)','Linden'),('CARREON (CARRION)','Merry'),('CARREON (CARRION)','Miller'),('CARREON (CARRION)','Novick'),('CARREON (CARRION)','Reinke'),('CUALE','Hauk'),('CUALE','Meadow Vale'),('CUALE','Shoshone'),('EL AGOSTADERO','Doe Crossing'),('EL CORRIDO','Talisman'),('EL QUINCE (SAN JOSE EL QU','Welch'),('EL SAUCILLO','Kinsman'),('EL SAUCITO','Moose'),('EL TARAY','High Crossing'),('EL ZOQUITE','Briar Crest'),('ENCARNACION DE DIAZ','Rusk');
/*!40000 ALTER TABLE `Calle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Categoria`
--

DROP TABLE IF EXISTS `Categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Categoria` (
  `categoria` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Categoria`
--

LOCK TABLES `Categoria` WRITE;
/*!40000 ALTER TABLE `Categoria` DISABLE KEYS */;
INSERT INTO `Categoria` VALUES ('Productos de alta rotación',' Son los que se producen en gran cantidad, rápidamente y para una temporada corta (por ejemplo, esferas navideñas, trajes de baño, tiendas de campaña, impermeables, etcétera)'),('Productos de consumo popular','Son productos fabricados y destinados a consumidores finales sin la necesidad de un proceso industrial adicional. Se encuentran en lugares accesibles al público en general y se compran regularmente pa'),('Productos de impulso','Furgen como base para dar a conocer otros productos de reciente creación y características similares; en ocasiones se hacen modificaciones a su diseño antes de su decadencia'),('Productos de media y baja rotación','éstos no tienen una producción masiva. La producción es baja o intermedia de acuerdo con el pedido de cada una de las empresas. Entre otros, pueden citarse mosaicos, materiales eléctricos, estambres y'),('Productos de temporada',' Son aquellos que se producen como respuesta a la demanda en las diferentes épocas del año (por ejemplo, juguetes, útiles escolares, etcétera) '),('Productos gancho','Estos productos no reditúan una ganancia considerable a la empresa, pero sirven para vender otros o para dar una imagen al consumidor de que la empresa cuenta con todo lo necesario'),('Productos importados','Son productos elaborados en el extranjero, cuyo precio a veces es muy alto ');
/*!40000 ALTER TABLE `Categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CategoriaUsuario`
--

DROP TABLE IF EXISTS `CategoriaUsuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CategoriaUsuario` (
  `categoria` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CategoriaUsuario`
--

LOCK TABLES `CategoriaUsuario` WRITE;
/*!40000 ALTER TABLE `CategoriaUsuario` DISABLE KEYS */;
INSERT INTO `CategoriaUsuario` VALUES ('ADMINISTRADOR DE EQUIPO'),('ADMINISTRADOR DE LIGA'),('GERENTE DE VENTAS'),('VENDEDOR');
/*!40000 ALTER TABLE `CategoriaUsuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ciudad`
--

DROP TABLE IF EXISTS `Ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Ciudad` (
  `nombreCiudad` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombreEstado` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`nombreCiudad`,`nombreEstado`),
  KEY `nombreEstado` (`nombreEstado`),
  CONSTRAINT `Ciudad_ibfk_1` FOREIGN KEY (`nombreEstado`) REFERENCES `Estado` (`nombreEstado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ciudad`
--

LOCK TABLES `Ciudad` WRITE;
/*!40000 ALTER TABLE `Ciudad` DISABLE KEYS */;
INSERT INTO `Ciudad` VALUES ('Aguascalientes','Baja California Sur'),('Cárdenas','Hidalgo'),('Cárdenas','Sinaloa'),('Chilpancingo','Distrito Federal'),('Chilpancingo','Querétaro'),('Chilpancingo','Veracruz de Ignacio '),('Ciudad del Carmen','Distrito Federal'),('Colima-Villa de Álvarez','Chihuahua'),('Colima-Villa de Álvarez','Coahuila de Zaragoza'),('Cuernavaca','Chiapas'),('Culiacán','Querétaro'),('Durango','Hidalgo'),('Durango','México'),('Durango','Tlaxcala'),('Guanajuato','Quintana Roo'),('Irapuato','Coahuila de Zaragoza'),('Los Mochis','Hidalgo'),('Manzanillo','Durango'),('Manzanillo','Tabasco'),('Matamoros','Distrito Federal'),('Mazatlán','Quintana Roo'),('Mérida','Morelos'),('Mexicali','Tabasco'),('Minatitlán','Guanajuato'),('Monclova-Frontera','Campeche'),('Monclova-Frontera','Hidalgo'),('Monterrey','Durango'),('Oaxaca','Michoacán de Ocampo'),('Ocotlán','Sinaloa'),('Querétaro','Colima'),('Reynosa-Río Bravo','Coahuila de Zaragoza'),('Reynosa-Río Bravo','Durango'),('Salamanca','Puebla'),('Salamanca','Tamaulipas'),('San Luis Potosí-Soledad','México'),('San Luis Potosí-Soledad','Michoacán de Ocampo'),('San Luis Potosí-Soledad','Sonora'),('Tehuacán','Oaxaca'),('Tepic','Sonora'),('Tlaxcala-Apizaco','Campeche'),('Tulancingo','Campeche'),('Tulancingo','Colima'),('Tulancingo','Jalisco'),('Tuxtla Gutiérrez','Hidalgo'),('Villahermosa','Coahuila de Zaragoza'),('Xalapa','Distrito Federal');
/*!40000 ALTER TABLE `Ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Colonia`
--

DROP TABLE IF EXISTS `Colonia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Colonia` (
  `nombreDelegacion` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombreColonia` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`nombreColonia`),
  KEY `nombreDelegacion` (`nombreDelegacion`),
  CONSTRAINT `Colonia_ibfk_1` FOREIGN KEY (`nombreDelegacion`) REFERENCES `Delegacion` (`nombreDelegacion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Colonia`
--

LOCK TABLES `Colonia` WRITE;
/*!40000 ALTER TABLE `Colonia` DISABLE KEYS */;
INSERT INTO `Colonia` VALUES ('Amatenango de la Frontera','EL CENTRO'),('Buenaventura','GARGANTILLO (LA HACIENDA)'),('Candelaria','EL AGOSTADERO'),('Candelaria','EL MIRADOR'),('Candelaria','EL TEMPISQUE'),('Candelaria','ENCARNACION DE DIAZ'),('Guadalupe Etla','CIENEGA GRANDE'),('Guadalupe Etla','EL ZOQUITE'),('Guaymas','BARRANCA DE SANTA CLARA'),('Huejúcar','EL SAUCITO'),('Huitiupán','EL PUESTO'),('Martínez de la Torre','EL TARAY'),('Martínez de la Torre','FRACCIONAMIENTO VISTAS DE'),('Mier y Noriega','GUADALAJARA'),('Nicolás Flores','AMATANEJO'),('Nicolás Flores','EL CRIADERO'),('Pesquería','FRANCISCO VILLA'),('San Diego de Alejandría','EL CORRIDO'),('San Diego de Alejandría','EL SALITRILLO (SALITRILLO'),('San Diego de Alejandría','GUADALAJARITA'),('San Miguel Aloápam','CHAMACUERO'),('San Pedro Jaltepetongo','EL SABINO'),('San Pedro Jaltepetongo','HACIENDA DE LA LABOR'),('Santa Catarina Zapoquila','CARREON (CARRION)'),('Santa Catarina Zapoquila','EL LAUREL'),('Santa Gertrudis','EL OCOTE DE ENMEDIO'),('Santa María Ixcatlán','EL GUAYABO DE ARRIBA'),('Santiago Laollaga','BARRERAS'),('Santiago Laollaga','CUALE'),('Santiago Zoochila','EL PITAYITO'),('Santiago Zoochila','EL PLAYON'),('Santo Domingo Armenta','AGUA PRIETA'),('Santo Domingo Armenta','EL SALTO GRANDE'),('Santo Domingo Petapa','HUAXTLA'),('Tampico Alto','FRANCISCO I. MADERO (EL N'),('Tenango del Aire','ALPIZAHUA'),('Tenango del Aire','EL JAG_EY'),('Tzicatlacoyan','ATACCO'),('Unión Juárez','CHAMELA'),('Uruachi','ATOTONILQUILLO'),('Uruachi','EL ATASCOSO'),('Victoria','CA'),('Victoria','EL QUINCE (SAN JOSE EL QU'),('Xoxocotla','EL SAUCILLO');
/*!40000 ALTER TABLE `Colonia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Delegacion`
--

DROP TABLE IF EXISTS `Delegacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Delegacion` (
  `nombreCiudad` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombreDelegacion` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`nombreDelegacion`),
  KEY `nombreCiudad` (`nombreCiudad`),
  CONSTRAINT `Delegacion_ibfk_1` FOREIGN KEY (`nombreCiudad`) REFERENCES `Ciudad` (`nombreCiudad`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Delegacion`
--

LOCK TABLES `Delegacion` WRITE;
/*!40000 ALTER TABLE `Delegacion` DISABLE KEYS */;
INSERT INTO `Delegacion` VALUES ('Cárdenas','Santa Gertrudis'),('Cárdenas','Tzicatlacoyan'),('Chilpancingo','Chacsinkín'),('Chilpancingo','Mier y Noriega'),('Chilpancingo','Santo Domingo Petapa'),('Ciudad del Carmen','Halachó'),('Ciudad del Carmen','San Pedro'),('Colima-Villa de Álvarez','Chilcuautla'),('Colima-Villa de Álvarez','Santiago Llano Grande'),('Colima-Villa de Álvarez','Uruachi'),('Cuernavaca','Candelaria'),('Cuernavaca','Tecolutla'),('Durango','Huejúcar'),('Durango','Santa María Ixcatlán'),('Guanajuato','San José Teacalco'),('Guanajuato','San Pedro Jaltepetongo'),('Guanajuato','Santa Catarina Zapoquila'),('Irapuato','Victoria'),('Manzanillo','Nicolás Flores'),('Manzanillo','Santo Domingo Armenta'),('Mazatlán','San Miguel Aloápam'),('Minatitlán','Unión Juárez'),('Monclova-Frontera','Buenaventura'),('Monclova-Frontera','Guadalupe Etla'),('Monclova-Frontera','San Diego de Alejandría'),('Monclova-Frontera','Santa María Nduayaco'),('Monterrey','Hoctún'),('Oaxaca','Martínez de la Torre'),('Ocotlán','Guaymas'),('Querétaro','Acuamanala de Miguel Hida'),('Querétaro','Jilotepec'),('Reynosa-Río Bravo','Amatenango de la Frontera'),('Reynosa-Río Bravo','Tetecala'),('San Luis Potosí-Soledad','Acaponeta'),('San Luis Potosí-Soledad','Santiago Laollaga'),('San Luis Potosí-Soledad','Santiago Zoochila'),('San Luis Potosí-Soledad','Tenango del Aire'),('Tepic','Mexicaltzingo'),('Tlaxcala-Apizaco','Tampico Alto'),('Tulancingo','Cuautla'),('Tulancingo','Huitiupán'),('Tulancingo','San Juan Quiahije'),('Villahermosa','Pesquería'),('Villahermosa','Santiago Tamazola'),('Xalapa','Xoxocotla');
/*!40000 ALTER TABLE `Delegacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DetalleDeVenta`
--

DROP TABLE IF EXISTS `DetalleDeVenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DetalleDeVenta` (
  `nombreTienda` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idVenta` int(11) NOT NULL,
  `anio` int(11) NOT NULL,
  `trimestre` int(11) NOT NULL,
  `nombreArticulo` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombreProveedor` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `piezasVendidas` int(11) DEFAULT NULL,
  PRIMARY KEY (`nombreTienda`,`idVenta`,`anio`,`trimestre`,`nombreArticulo`,`nombreProveedor`),
  KEY `nombreArticulo` (`nombreArticulo`,`nombreProveedor`),
  CONSTRAINT `DetalleDeVenta_ibfk_1` FOREIGN KEY (`nombreTienda`) REFERENCES `Tienda` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `DetalleDeVenta_ibfk_2` FOREIGN KEY (`nombreArticulo`, `nombreProveedor`) REFERENCES `Articulo` (`nombre`, `proveedor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DetalleDeVenta`
--

LOCK TABLES `DetalleDeVenta` WRITE;
/*!40000 ALTER TABLE `DetalleDeVenta` DISABLE KEYS */;
INSERT INTO `DetalleDeVenta` VALUES ('Abernathy Inc',28,2017,1,'CHAMARRA','Cato Corporation (The)',3),('Abernathy Inc',40,2017,3,'PLAYERA','ClearBridge Energy MLP Opportunity Fund Inc.',19),('Abernathy Inc',54,2018,1,'CASCO','Virtu Financial, Inc.',13),('Abernathy Inc',56,2018,1,'GORRA','Nuveen Municipal 2021 Target Term Fund',2),('Abernathy Inc',58,2018,4,'TENNIS','EDAP TMS S.A.',6),('Abernathy Inc',94,2018,2,'CARTERA','Kelly Services, Inc.',18),('Abernathy Inc',100,2017,4,'PELUCHE','Ottawa Bancorp, Inc.',3),('Anderson-Mitchell',1,2018,1,'POSTER','Community Health Systems, Inc.',1),('Anderson-Mitchell',1,2018,1,'TENNIS','The Obesity ETF',10),('Anderson-Mitchell',2,2017,1,'CARTERA','The Community Financial Corporation',18),('Anderson-Mitchell',2,2018,1,'TENNIS','The Obesity ETF',1),('Anderson-Mitchell',2,2018,1,'VASO','Scorpio Bulkers Inc.',3),('Anderson-Mitchell',3,2018,1,'VASO','Scorpio Bulkers Inc.',8),('Anderson-Mitchell',15,2018,1,'BALON','National Beverage Corp.',15),('Anderson-Mitchell',22,2017,2,'CUADRO','Frontline Ltd.',20),('Anderson-Mitchell',24,2018,2,'ESTAMPA','UMH Properties, Inc.',3),('Anderson-Mitchell',26,2017,3,'PLAYERA','Shaw Communications Inc.',16),('Anderson-Mitchell',36,2017,3,'HOODIE','PowerShares Russell 1000 Low Beta Equal Weight Por',2),('Anderson-Mitchell',93,2018,1,'PLAYERA','Motorcar Parts of America, Inc.',3),('Bartell, Hettinger and Sanford',56,2017,3,'TENNIS','Air T, Inc.',9),('Bartell, Hettinger and Sanford',64,2017,2,'POSTER','Frontline Ltd.',20),('Bartell, Hettinger and Sanford',77,2017,2,'CARTERA','Kelly Services, Inc.',9),('Bartell, Hettinger and Sanford',84,2018,1,'GORRA','W.W. Grainger, Inc.',14),('Bartell, Hettinger and Sanford',86,2017,2,'ESTAMPA','America First Multifamily Investors, L.P.',14),('Bartell, Hettinger and Sanford',89,2018,3,'BALON','National Beverage Corp.',9),('Braun-Altenwerth',27,2017,2,'CARTERA','Giga-tronics Incorporated',13),('Braun-Altenwerth',51,2018,2,'VASO','Brixmor Property Group Inc.',12),('Braun-Altenwerth',55,2017,3,'BALON','Mesabi Trust',9),('Braun-Altenwerth',72,2017,2,'TENNIS','Inseego Corp.',13),('Gusikowski Inc',2,2018,4,'BALON','Eagle Bulk Shipping Inc.',14),('Gusikowski Inc',16,2017,1,'GORRA','Live Oak Bancshares, Inc.',6),('Gusikowski Inc',41,2017,2,'JERSEY','UMH Properties, Inc.',15),('Gusikowski Inc',46,2017,1,'BALON','Scorpio Bulkers Inc.',6),('Gusikowski Inc',55,2017,1,'CHAMARRA','Yingli Green Energy Holding Company Limited',19),('Gusikowski Inc',59,2017,1,'JERSEY','Ingevity Corporation',16),('Gusikowski Inc',65,2018,1,'CARCASA DE CELULAR','Global Eagle Entertainment Inc.',15),('Gusikowski Inc',72,2018,2,'LLAVERO','The Obesity ETF',11),('Gusikowski Inc',75,2017,2,'CARCASA DE CELULAR','Air T, Inc.',19),('Gusikowski Inc',86,2017,1,'TENNIS','Inseego Corp.',2),('Jaskolski Inc',26,2017,1,'TENNIS','Inseego Corp.',3),('Jaskolski Inc',35,2017,3,'POSTER','Frontline Ltd.',2),('Jaskolski Inc',59,2018,1,'POSTER','Copa Holdings, S.A.',16),('Jaskolski Inc',74,2017,1,'BALON','Mesabi Trust',4),('Jaskolski Inc',90,2017,4,'BALON','Eagle Bulk Shipping Inc.',13),('Kerluke-Kutch',3,2017,2,'VASO','Virtu Financial, Inc.',17),('Kerluke-Kutch',67,2017,4,'HOODIE','Zafgen, Inc.',18),('Kerluke-Kutch',67,2018,3,'TENNIS','II-VI Incorporated',11),('Kerluke-Kutch',85,2018,1,'BUFFANDA','Alexander & Baldwin Holdings, Inc.',3),('Kerluke-Kutch',88,2017,2,'PELUCHE','Air T, Inc.',14),('Kerluke-Kutch',92,2018,3,'POSTER','Community Health Systems, Inc.',19),('Kerluke-Kutch',93,2018,1,'VASO','Virtu Financial, Inc.',2),('Kerluke-Kutch',100,2018,4,'TENNIS','Inseego Corp.',5),('Kohler and Sons',8,2018,4,'JERSEY','Ingevity Corporation',8),('Kohler and Sons',13,2018,3,'PELUCHE','Ottawa Bancorp, Inc.',3),('Kohler and Sons',19,2018,2,'BALON','Mesabi Trust',19),('Kohler and Sons',63,2018,4,'CARCASA DE CELULAR','Zillow Group, Inc.',17),('Marquardt-Sauer',14,2018,4,'CUADRO','W.W. Grainger, Inc.',11),('Marquardt-Sauer',52,2017,2,'GORRA','Zafgen, Inc.',8),('Marquardt-Sauer',53,2017,3,'CARTERA','Kelly Services, Inc.',20),('Smith-Kiehn',5,2017,2,'CARTERA','Yangtze River Development Limited',11),('Smith-Kiehn',6,2018,2,'VASO','Brixmor Property Group Inc.',13),('Smith-Kiehn',13,2017,4,'CARTERA','Douglas Dynamics, Inc.',10),('Smith-Kiehn',19,2018,4,'CARCASA DE CELULAR','Air T, Inc.',1),('Smith-Kiehn',45,2018,2,'GORRA','Giga-tronics Incorporated',2),('Smith-Kiehn',45,2018,4,'BALON','National Beverage Corp.',10),('Smith-Kiehn',48,2017,2,'JERSEY','Ingevity Corporation',19),('Smith-Kiehn',80,2017,1,'LLAVERO','MaxPoint Interactive, Inc.',14),('Smith-Kiehn',80,2018,3,'VASO','Brixmor Property Group Inc.',2),('Smith-Kiehn',84,2017,3,'BALON','Global Eagle Entertainment Inc.',18),('Smith-Kiehn',98,2018,1,'PLAYERA','Shaw Communications Inc.',6),('Ziemann, Bergstrom and Kerluke',23,2018,4,'CASCO','Motorcar Parts of America, Inc.',2),('Ziemann, Bergstrom and Kerluke',32,2018,1,'CARTERA','Kelly Services, Inc.',8),('Ziemann, Bergstrom and Kerluke',61,2017,1,'TENNIS','Air T, Inc.',5);
/*!40000 ALTER TABLE `DetalleDeVenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Empleado`
--

DROP TABLE IF EXISTS `Empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Empleado` (
  `CURP` varchar(18) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idTienda` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`CURP`,`idTienda`),
  KEY `idTienda` (`idTienda`),
  CONSTRAINT `Empleado_ibfk_1` FOREIGN KEY (`CURP`) REFERENCES `Persona` (`CURP`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Empleado_ibfk_2` FOREIGN KEY (`idTienda`) REFERENCES `Tienda` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Empleado`
--

LOCK TABLES `Empleado` WRITE;
/*!40000 ALTER TABLE `Empleado` DISABLE KEYS */;
INSERT INTO `Empleado` VALUES ('ACPM592338XMIDAR46','Anderson-Mitchell'),('ACPM592338XMIDAR46','Braun-Altenwerth'),('BDRW708138MEUMDF28','Abernathy Inc'),('CEYL342752XURURM48','Kerluke-Kutch'),('CIUP083798DKWVIT34','Gusikowski Inc'),('CTTF555648SXEYKN40','Bartell, Hettinger and Sanford'),('DBIW646404JURIWV18','Anderson-Mitchell'),('DGEU922478BBOJVG33','Anderson-Mitchell'),('EBXE148756YYMYDN82','Anderson-Mitchell'),('FNLM317555WXFXNH00','Kohler and Sons'),('FNLM317555WXFXNH00','Smith-Kiehn'),('GPBH057029TPDJQO60','Marquardt-Sauer'),('HEPR142132FGGAJD30','Abernathy Inc'),('IHAB887048KSHRBP82','Gusikowski Inc'),('IHAB887048KSHRBP82','Kerluke-Kutch'),('IHAB887048KSHRBP82','Kohler and Sons'),('IHAB887048KSHRBP82','Ziemann, Bergstrom and Kerluke'),('JCIS622298QAMLTL70','Jaskolski Inc'),('JHWR425096CFIIXV39','Gusikowski Inc'),('JHWR425096CFIIXV39','Kohler and Sons'),('KESX437064GTXVPX44','Bartell, Hettinger and Sanford'),('KJRI482628RIXCFH38','Jaskolski Inc'),('KJRI482628RIXCFH38','Ziemann, Bergstrom and Kerluke'),('LGCB642852AIPRUS02','Braun-Altenwerth'),('LGCB642852AIPRUS02','Kohler and Sons'),('LGCB642852AIPRUS02','Marquardt-Sauer'),('LSDN660866ZABWHR68','Braun-Altenwerth'),('LSDN660866ZABWHR68','Gusikowski Inc'),('LSDN660866ZABWHR68','Ziemann, Bergstrom and Kerluke'),('MFBT004501HYCMRL20','Braun-Altenwerth'),('MFBT004501HYCMRL20','Ziemann, Bergstrom and Kerluke'),('MGTZ586484YLNBTA49','Ziemann, Bergstrom and Kerluke'),('NJMY642015LBMXVX29','Jaskolski Inc'),('NWVE985020FUCQND96','Ziemann, Bergstrom and Kerluke'),('OEIT412541UTGVON32','Jaskolski Inc'),('OJDA417821YLYGTW81','Kerluke-Kutch'),('ORJT045437FOXQBF17','Braun-Altenwerth'),('OTCW167980MIIOIJ90','Kohler and Sons'),('OXSY629911QHZOTV70','Kohler and Sons'),('OYEL084442BZDDYS00','Kohler and Sons'),('PKWP394731JWURIC87','Abernathy Inc'),('PTQF806059LJDYNN38','Bartell, Hettinger and Sanford'),('RAPW052181GQODHE48','Anderson-Mitchell'),('SAFS235968YNIXNM79','Abernathy Inc'),('SCSF152059RYDTLX96','Braun-Altenwerth'),('SVQK604302JHYBDS47','Jaskolski Inc'),('TDHA395622RFSSAL83','Braun-Altenwerth'),('VFRD948441LLXTGA91','Smith-Kiehn'),('VOBY471272QAYAOB27','Braun-Altenwerth'),('WOLX756525XFYRVK72','Smith-Kiehn'),('WVOZ574821CGNTCV20','Gusikowski Inc'),('WVOZ574821CGNTCV20','Jaskolski Inc'),('XFOE549457ZRJQJW36','Bartell, Hettinger and Sanford'),('XFYU609781PATQGJ26','Smith-Kiehn'),('XNZW715562NUUHMS03','Marquardt-Sauer'),('XNZW715562NUUHMS03','Smith-Kiehn'),('XVGP462416GZWUTO63','Marquardt-Sauer'),('YFEK058057WKDCWC67','Bartell, Hettinger and Sanford'),('YFEK058057WKDCWC67','Ziemann, Bergstrom and Kerluke'),('YKZT813651GSYLBZ90','Jaskolski Inc'),('YKZT813651GSYLBZ90','Kohler and Sons'),('YTRY892050OMSUVD40','Bartell, Hettinger and Sanford'),('ZICF753541YRJXBI53','Gusikowski Inc'),('ZKVO530405DIZDLP53','Kohler and Sons');
/*!40000 ALTER TABLE `Empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EmpleadoTieneVentas`
--

DROP TABLE IF EXISTS `EmpleadoTieneVentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EmpleadoTieneVentas` (
  `vendedorCURP` varchar(18) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idVenta` int(11) NOT NULL,
  `anio` int(11) NOT NULL,
  `trimestre` int(11) NOT NULL,
  PRIMARY KEY (`vendedorCURP`,`idVenta`,`anio`,`trimestre`),
  CONSTRAINT `EmpleadoTieneVentas_ibfk_1` FOREIGN KEY (`vendedorCURP`) REFERENCES `Persona` (`CURP`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EmpleadoTieneVentas`
--

LOCK TABLES `EmpleadoTieneVentas` WRITE;
/*!40000 ALTER TABLE `EmpleadoTieneVentas` DISABLE KEYS */;
INSERT INTO `EmpleadoTieneVentas` VALUES ('ACPM592338XMIDAR46',1,2018,1),('ACPM592338XMIDAR46',2,2018,1),('ACPM592338XMIDAR46',3,2017,2),('ACPM592338XMIDAR46',3,2018,1),('ACPM592338XMIDAR46',17,2017,1),('ACPM592338XMIDAR46',69,2018,4),('BXRN906223QUHARS98',23,2018,4),('BXRN906223QUHARS98',55,2017,1),('COAV746762VTPQZD14',7,2017,2),('COAV746762VTPQZD14',13,2017,2),('COAV746762VTPQZD14',41,2017,2),('COAV746762VTPQZD14',80,2017,1),('COAV746762VTPQZD14',86,2017,1),('COAV746762VTPQZD14',90,2017,4),('CTTF555648SXEYKN40',28,2017,1),('CTTF555648SXEYKN40',56,2017,3),('CTTF555648SXEYKN40',86,2017,2),('DGEU922478BBOJVG33',65,2018,1),('DGEU922478BBOJVG33',67,2017,4),('DGEU922478BBOJVG33',72,2018,2),('DGEU922478BBOJVG33',84,2017,3),('EBXE148756YYMYDN82',45,2017,1),('EBXE148756YYMYDN82',64,2017,4),('EBXE148756YYMYDN82',69,2017,3),('EUOO189333ORFYYV60',69,2017,3),('EUOO189333ORFYYV60',76,2017,1),('FNLM317555WXFXNH00',7,2017,2),('FNLM317555WXFXNH00',14,2018,4),('FNLM317555WXFXNH00',40,2018,3),('FNLM317555WXFXNH00',91,2018,3),('GPBH057029TPDJQO60',64,2017,2),('GPBH057029TPDJQO60',93,2017,4),('IHAB887048KSHRBP82',2,2018,4),('IHAB887048KSHRBP82',61,2017,1),('IHAB887048KSHRBP82',94,2018,2),('IHAB887048KSHRBP82',100,2018,1),('JCIS622298QAMLTL70',54,2018,1),('JCIS622298QAMLTL70',84,2017,3),('JCIS622298QAMLTL70',86,2017,2),('JCIS622298QAMLTL70',99,2018,1),('JHWR425096CFIIXV39',67,2017,1),('KJRI482628RIXCFH38',22,2017,2),('KJRI482628RIXCFH38',51,2018,2),('KJRI482628RIXCFH38',89,2018,3),('KJRI482628RIXCFH38',92,2018,3),('KJRI482628RIXCFH38',100,2017,4),('LGCB642852AIPRUS02',24,2017,3),('LGCB642852AIPRUS02',27,2017,2),('LGCB642852AIPRUS02',46,2017,1),('LGCB642852AIPRUS02',63,2018,4),('LGCB642852AIPRUS02',69,2017,3),('LGCB642852AIPRUS02',74,2017,1),('MFBT004501HYCMRL20',13,2018,3),('MFBT004501HYCMRL20',67,2017,1),('MFBT004501HYCMRL20',84,2017,3),('NWVE985020FUCQND96',52,2017,2),('NWVE985020FUCQND96',93,2017,4),('NWVE985020FUCQND96',99,2018,1),('ORJT045437FOXQBF17',38,2018,2),('ORJT045437FOXQBF17',74,2017,1),('ORJT045437FOXQBF17',94,2018,2),('RAPW052181GQODHE48',77,2017,2),('SVQK604302JHYBDS47',55,2017,3),('SVQK604302JHYBDS47',63,2018,4),('SVQK604302JHYBDS47',69,2018,4),('SVQK604302JHYBDS47',84,2018,1),('TDHA395622RFSSAL83',26,2017,1),('TDHA395622RFSSAL83',40,2018,4),('TDHA395622RFSSAL83',67,2017,1),('TDHA395622RFSSAL83',72,2018,2),('TDHA395622RFSSAL83',80,2017,1),('TOAZ074452XHAFJG96',56,2017,3),('TOAZ074452XHAFJG96',63,2018,4),('TOAZ074452XHAFJG96',72,2018,2),('VOBY471272QAYAOB27',40,2017,3),('VOBY471272QAYAOB27',75,2017,2),('VOBY471272QAYAOB27',89,2018,3),('VTFQ285453HOZKCY98',13,2017,4),('VTFQ285453HOZKCY98',22,2017,2),('VTFQ285453HOZKCY98',38,2018,2),('VTFQ285453HOZKCY98',51,2018,2),('VTFQ285453HOZKCY98',72,2018,2),('WOLX756525XFYRVK72',100,2018,1),('WVOZ574821CGNTCV20',69,2018,4),('WVOZ574821CGNTCV20',100,2018,4),('XFOE549457ZRJQJW36',65,2018,1),('XFOE549457ZRJQJW36',79,2017,1),('XFOE549457ZRJQJW36',84,2017,3),('XFYU609781PATQGJ26',7,2017,2),('XNZW715562NUUHMS03',8,2018,4),('XNZW715562NUUHMS03',35,2017,3),('XVGP462416GZWUTO63',55,2017,1),('YFEK058057WKDCWC67',2,2017,1),('YFEK058057WKDCWC67',69,2017,1),('YKZT813651GSYLBZ90',53,2017,3),('YTRY892050OMSUVD40',79,2017,1),('ZICF753541YRJXBI53',2,2018,4),('ZICF753541YRJXBI53',40,2018,3),('ZICF753541YRJXBI53',59,2018,1),('ZKVO530405DIZDLP53',19,2018,2),('ZKVO530405DIZDLP53',56,2017,3),('ZKVO530405DIZDLP53',59,2017,1);
/*!40000 ALTER TABLE `EmpleadoTieneVentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Equipo`
--

DROP TABLE IF EXISTS `Equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Equipo` (
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `propietarioCURP` varchar(18) COLLATE utf8mb4_unicode_ci NOT NULL,
  `coachCURP` varchar(18) COLLATE utf8mb4_unicode_ci NOT NULL,
  `estadio` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`nombre`),
  KEY `propietarioCURP` (`propietarioCURP`),
  KEY `coachCURP` (`coachCURP`),
  KEY `estadio` (`estadio`),
  CONSTRAINT `Equipo_ibfk_1` FOREIGN KEY (`propietarioCURP`) REFERENCES `Persona` (`CURP`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Equipo_ibfk_2` FOREIGN KEY (`coachCURP`) REFERENCES `Persona` (`CURP`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Equipo_ibfk_3` FOREIGN KEY (`estadio`) REFERENCES `Estadio` (`nombreEstadio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Equipo`
--

LOCK TABLES `Equipo` WRITE;
/*!40000 ALTER TABLE `Equipo` DISABLE KEYS */;
INSERT INTO `Equipo` VALUES ('Atlanta Falcons','JHAS669011LGDAPV92','HEPR142132FGGAJD30','Estadio Victoria'),('Baltimore Ravens','WPHQ747500MYTCGB35','OXSY629911QHZOTV70','Estadio Víctor Manuel Reyna'),('Buffalo Bills','BVBD961193HEVCDP26','ZICF753541YRJXBI53','Estadio Caliente'),('BURROS BLANCOS','WOLX756525XFYRVK72','ACPM592338XMIDAR46','Estadio BBVA Bancomer'),('Carolina Panthers','TDHA395622RFSSAL83','COAV746762VTPQZD14','Estadio Hidalgo'),('Chicago Bears','EBXE148756YYMYDN82','JCIS622298QAMLTL70','Estadio Luis Pirata Fuente'),('Cincinnati Bengals','OXSY629911QHZOTV70','JLXK096536TPIOCS59','Estadio TSM Corona'),('Cleveland Browns','OWAI616503LXPPTT39','SVQK604302JHYBDS47','Estadio Camp Nou'),('Denver Broncos','KESX437064GTXVPX44','YTRY892050OMSUVD40','Estadio La Corregidora'),('Detroit Lions','HBIH833463UYZYYT30','YFEK058057WKDCWC67','Estadio Morelos'),('Green Bay Packers','TOAZ074452XHAFJG96','GPBH057029TPDJQO60','Estadio Universitario'),('Houston Texans','BVBD961193HEVCDP26','KESX437064GTXVPX44','Estadio Omnilife'),('Indianapolis Colts','LHJO581012HSXEHK34','JDXO495351KDBGBF67','Estadio BBVA Bancomer'),('Kansas City Chiefs','TGGH808329ZOABYG49','GNFF950357OVCXVR51','Estadio Olímpico Universitario'),('Los Angeles Chargers','HEPR142132FGGAJD30','NZMD987006RMADTV14','Estadio Jalisco'),('Los Angeles Rams','ACPM592338XMIDAR46','ICLB862951LSLSAP52','Estadio Azteca'),('Minnesota Vikings','EUOO189333ORFYYV60','PKWP394731JWURIC87','Estadio Victoria'),('New England Patriots','XVEQ055773UWQLQD60','EBXE148756YYMYDN82','Estadio Víctor Manuel Reyna'),('New Orleans Saints','BDRW708138MEUMDF28','ELXQ279168ICCUMY39','Estadio Caliente'),('New York Giants','RAPW052181GQODHE48','FTMA625415ERKGIB60','Estadio Hidalgo'),('New York Jets','LSDN660866ZABWHR68','NWVE985020FUCQND96','Estadio Luis Pirata Fuente'),('Oakland Raiders','OXSY629911QHZOTV70','HEPR142132FGGAJD30','Estadio TSM Corona'),('Philadelphia Eagles','FTMA625415ERKGIB60','DXEJ510999LVCQXU42','Estadio Camp Nou'),('San Francisco 49ers','NJXA896232IJPYGW02','FTMA625415ERKGIB60','Estadio La Corregidora'),('Seattle Seahawks','OJDA417821YLYGTW81','IEFF822431NLDPRJ42','Estadio Morelos'),('Tampa Bay Buccaneers','YRNY396147HDGNEX10','ELXQ279168ICCUMY39','Estadio Universitario'),('Tennessee Titans','BVBD961193HEVCDP26','ICLB862951LSLSAP52','Estadio Omnilife'),('Washington Redskins','WOLX756525XFYRVK72','ACPM592338XMIDAR46','Estadio BBVA Bancomer');
/*!40000 ALTER TABLE `Equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estadio`
--

DROP TABLE IF EXISTS `Estadio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Estadio` (
  `nombreEstadio` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `calle` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `capacidad` int(11) DEFAULT NULL,
  `colonia` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`nombreEstadio`),
  KEY `calle` (`calle`),
  KEY `colonia` (`colonia`),
  CONSTRAINT `Estadio_ibfk_1` FOREIGN KEY (`calle`) REFERENCES `Calle` (`nombreCalle`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Estadio_ibfk_2` FOREIGN KEY (`colonia`) REFERENCES `Colonia` (`nombreColonia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estadio`
--

LOCK TABLES `Estadio` WRITE;
/*!40000 ALTER TABLE `Estadio` DISABLE KEYS */;
INSERT INTO `Estadio` VALUES ('Estadio Azteca','Kinsman',43744,'EL SAUCILLO'),('Estadio BBVA Bancomer','Doe Crossing',53098,'EL AGOSTADERO'),('Estadio Caliente','Talisman',17220,'EL CORRIDO'),('Estadio Camp Nou','Briar Crest',52866,'EL ZOQUITE'),('Estadio Hidalgo','Merry',15200,'CARREON (CARRION)'),('Estadio Jalisco','Miller',66366,'CARREON (CARRION)'),('Estadio La Corregidora','Shoshone',59707,'CUALE'),('Estadio Luis Pirata Fuente','Fair Oaks',42513,'ALPIZAHUA'),('Estadio Morelos','Rusk',31566,'ENCARNACION DE DIAZ'),('Estadio Olímpico Universitario','Moose',33750,'EL SAUCITO'),('Estadio Omnilife','High Crossing',23666,'EL TARAY'),('Estadio TSM Corona','Linden',41090,'CARREON (CARRION)'),('Estadio Universitario','Welch',56732,'EL QUINCE (SAN JOSE EL QU'),('Estadio Víctor Manuel Reyna','Hauk',26164,'CUALE'),('Estadio Victoria','Reinke',25875,'CARREON (CARRION)');
/*!40000 ALTER TABLE `Estadio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estado`
--

DROP TABLE IF EXISTS `Estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Estado` (
  `nombreEstado` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`nombreEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estado`
--

LOCK TABLES `Estado` WRITE;
/*!40000 ALTER TABLE `Estado` DISABLE KEYS */;
INSERT INTO `Estado` VALUES ('Baja California Sur'),('Campeche'),('Chiapas'),('Chihuahua'),('Coahuila de Zaragoza'),('Colima'),('Distrito Federal'),('Durango'),('Guanajuato'),('Guerrero'),('Hidalgo'),('Jalisco'),('México'),('Michoacán de Ocampo'),('Morelos'),('Nayarit'),('Nuevo León'),('Oaxaca'),('Puebla'),('Querétaro'),('Quintana Roo'),('San Luis Potosí'),('Sinaloa'),('Sonora'),('Tabasco'),('Tamaulipas'),('Tlaxcala'),('Veracruz de Ignacio '),('Yucatán');
/*!40000 ALTER TABLE `Estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Jugador`
--

DROP TABLE IF EXISTS `Jugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Jugador` (
  `CURP` varchar(18) COLLATE utf8mb4_unicode_ci NOT NULL,
  `posicion` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `numero` int(11) NOT NULL,
  `salario` double(9,2) NOT NULL,
  `nombreEquipo` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bajaPorLesion` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`CURP`),
  KEY `nombreEquipo` (`nombreEquipo`),
  KEY `posicion` (`posicion`),
  CONSTRAINT `Jugador_ibfk_1` FOREIGN KEY (`nombreEquipo`) REFERENCES `Equipo` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Jugador_ibfk_2` FOREIGN KEY (`posicion`) REFERENCES `Posicion` (`posicion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Jugador`
--

LOCK TABLES `Jugador` WRITE;
/*!40000 ALTER TABLE `Jugador` DISABLE KEYS */;
INSERT INTO `Jugador` VALUES ('A','Cornerbacks',12,18.00,'BURROS BLANCOS',0),('DOEJ960826MMCMSN09','Corredor',9,1000000.00,'BURROS BLANCOS',0),('H','Cornerbacks',0,10.00,'BURROS BLANCOS',0),('HI','Cornerbacks',0,10.00,'BURROS BLANCOS',0),('j','Cornerbacks',14,18.00,'BURROS BLANCOS',0),('JIJOJO','Defensive tackle ',12,17.00,'BURROS BLANCOS',1),('jn','Cornerbacks',14,18.00,'BURROS BLANCOS',0),('VIP','Cornerbacks',10,9999.00,'BURROS BLANCOS',0),('VIPJ','Cornerbacks',10,54.00,'BURROS BLANCOS',0),('VIPs','Cornerbacks',10,9999.00,'BURROS BLANCOS',0),('VIPss','Cornerbacks',10,9999.00,'BURROS BLANCOS',0),('VIPsss','Cornerbacks',10,9999.00,'BURROS BLANCOS',0);
/*!40000 ALTER TABLE `Jugador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Partido`
--

DROP TABLE IF EXISTS `Partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Partido` (
  `temporada` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `noJornada` int(11) NOT NULL,
  `equipoLocal` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `equipoVisitante` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `marcadorLocal` int(11) DEFAULT NULL,
  `marcadorVisitante` int(11) DEFAULT NULL,
  `partidoFinalizado` tinyint(1) NOT NULL,
  PRIMARY KEY (`equipoLocal`,`equipoVisitante`,`temporada`,`noJornada`),
  KEY `equipoVisitante` (`equipoVisitante`),
  CONSTRAINT `Partido_ibfk_1` FOREIGN KEY (`equipoLocal`) REFERENCES `Equipo` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Partido_ibfk_2` FOREIGN KEY (`equipoVisitante`) REFERENCES `Equipo` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Partido`
--

LOCK TABLES `Partido` WRITE;
/*!40000 ALTER TABLE `Partido` DISABLE KEYS */;
INSERT INTO `Partido` VALUES ('2015',2,'Atlanta Falcons','Buffalo Bills','2018-03-23','03:37:33',45,10,1),('2017',1,'Atlanta Falcons','BURROS BLANCOS','2018-03-17','03:07:43',0,100,1),('2017',5,'Atlanta Falcons','BURROS BLANCOS','2018-03-30','10:30:00',40,15,1),('2017',31,'Atlanta Falcons','BURROS BLANCOS','2018-03-01','20:35:59',0,0,0),('2017',88,'Atlanta Falcons','BURROS BLANCOS','2018-03-09','20:39:07',0,0,0),('2017',1,'Atlanta Falcons','Chicago Bears','2018-03-08','03:11:00',15,78,1),('2017',11,'Baltimore Ravens','BURROS BLANCOS','2018-03-09','04:52:53',2,60,1),('2017',19,'BURROS BLANCOS','Atlanta Falcons','2018-03-31','20:37:46',0,0,0),('2015',7,'BURROS BLANCOS','Buffalo Bills','2018-03-23','03:37:33',0,0,1),('2015',10,'BURROS BLANCOS','Buffalo Bills','2018-03-23','03:37:33',45,10,1),('2017',10,'BURROS BLANCOS','Buffalo Bills','2018-03-09','04:52:53',8,0,1),('2017',13,'BURROS BLANCOS','Cincinnati Bengals','2018-03-17','04:55:12',0,0,0),('2017',87,'BURROS BLANCOS','Cleveland Browns','2018-03-30','20:09:13',0,0,0),('2017',1,'Chicago Bears','Cleveland Browns','2018-03-16','03:09:31',0,13,1),('2017',8,'Kansas City Chiefs','Tampa Bay Buccaneers','2018-03-31','03:56:47',0,9,1);
/*!40000 ALTER TABLE `Partido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Persona`
--

DROP TABLE IF EXISTS `Persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Persona` (
  `CURP` varchar(18) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `paterno` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `materno` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `edad` int(11) NOT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  PRIMARY KEY (`CURP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Persona`
--

LOCK TABLES `Persona` WRITE;
/*!40000 ALTER TABLE `Persona` DISABLE KEYS */;
INSERT INTO `Persona` VALUES ('A','A','A','A',15,'2018-03-08'),('ACPM592338XMIDAR46','Jenilee','O\'Cahill','Pfeffle',75,'1972-08-16'),('AUNP670731ODXXTH10','Euphemia','Abbate','De Avenell',50,'1935-03-05'),('BDRW708138MEUMDF28','Mikkel','Maciejewski','Cosbey',58,'1975-01-08'),('BVBD961193HEVCDP26','Elston','Ellwood','Achromov',49,'2000-05-25'),('BXRN906223QUHARS98','Anjela','Niesegen','Fursland',79,'2010-04-16'),('CEYL342752XURURM48','Gaile','Dunston','Burgum',28,'1958-08-29'),('CIUP083798DKWVIT34','Valentia','Finlayson','Jamot',77,'1982-01-17'),('COAV746762VTPQZD14','Clyde','Gheorghescu','Dumsday',35,'1985-12-02'),('CTTF555648SXEYKN40','Sheree','Bedle','Tulloch',48,'1947-08-01'),('CWDJ906876GRCCJT60','Cody','Wellings','Bulger',25,'2013-05-21'),('CXZY457500BTVACZ91','Cully','Crooke','McGeoch',78,'2012-08-20'),('DBIW646404JURIWV18','Arri','Pincked','Maria',45,'1971-04-27'),('DGEU922478BBOJVG33','Lyle','Woollcott','Tucknott',53,'1936-01-28'),('DOEJ960826MMCMSN09','ROSARIO','DOMINGUEZ','ESPINOZA',21,'1996-08-26'),('DXEJ510999LVCQXU42','Chrisse','Archard','Judkin',61,'1939-04-05'),('EBXE148756YYMYDN82','Gale','Robelet','Killelea',64,'1951-05-05'),('ELGY058786WULBOI26','Marcelle','Rain','Blackney',18,'1958-09-24'),('ELXQ279168ICCUMY39','Paloma','Stilwell','Kleinstub',62,'1977-08-04'),('EUOO189333ORFYYV60','Virgina','Valentelli','Caddan',74,'1935-01-17'),('FASOL960520','FABRICIO','SOLIS','MARTINEZ',21,'2018-03-30'),('FFPR216868ECUREU78','Jase','Loach','Peirpoint',45,'1982-06-10'),('FKMF029292UFAIWQ79','Reggi','Cornau','Duetschens',36,'1980-09-17'),('FNLM317555WXFXNH00','Yettie','Sherbrooke','Milland',20,'1973-08-25'),('FOBG848976XXWFJK57','Tammie','Dhennin','Naisbit',21,'2009-02-26'),('FTMA625415ERKGIB60','Kristan','Cobb','Siely',60,'1954-12-01'),('FUYI961792ROMMTK40','Dacy','Taree','Gogin',74,'1973-12-07'),('GAFO135544XMBBNJ66','Ignatius','MacCosty','Bonfield',32,'1943-02-27'),('GKNH042973QTZWOK54','Leilah','Grinham','Gilliatt',24,'1993-12-23'),('GNFF950357OVCXVR51','Herold','Blaker','McAirt',48,'1957-07-31'),('GPBH057029TPDJQO60','Bernardina','O\'Mohun','Hadny',78,'1947-05-25'),('H','H','J','S',21,'2018-03-22'),('HBIH833463UYZYYT30','Donalt','Lewsy','Doughartie',77,'1972-10-13'),('HEPR142132FGGAJD30','Claudetta','Rampley','Savage',18,'1930-04-25'),('HI','H','J','S',21,'2018-03-22'),('HXWM120476LRUQYC87','Smitty','Sebastian','Hymer',39,'1976-11-20'),('ICLB862951LSLSAP52','Stella','Johnes','Godber',60,'1998-03-11'),('IEFF822431NLDPRJ42','Betsey','Vasichev','Prene',42,'1969-02-23'),('IHAB887048KSHRBP82','Candace','Bellsham','O\'Carmody',69,'1947-03-07'),('j','l','j','k',100,'2018-03-16'),('JCIS622298QAMLTL70','Elora','Skynner','Helliar',21,'1933-09-10'),('JDXO495351KDBGBF67','Agace','Purshouse','Sutherel',38,'2013-07-19'),('JHAS669011LGDAPV92','Gideon','Hay','Brownrigg',67,'1944-12-25'),('JHWR425096CFIIXV39','Tandy','Stailey','Corro',37,'1951-11-19'),('JIJOJO','KKK','LLL','LLL',12,'2018-03-09'),('JLXK096536TPIOCS59','Spense','Dennehy','Suddick',72,'1932-11-25'),('jn','l','j','k',100,'2018-03-16'),('JPUH807790ZBIJIN99','Fleur','Filisov','Flucker',72,'2018-01-04'),('JUAN ','VILCHIS','PINEDA','PINEDA',21,'2018-03-25'),('JUWR973351OVRDAC88','Conan','Benoy','Aldie',26,'1950-04-18'),('KESX437064GTXVPX44','Ralph','Gaskamp','Gonsalo',45,'1993-03-13'),('KJRI482628RIXCFH38','Seana','Dyett','Chartres',65,'2013-11-23'),('KMYB817361DYEYGM97','Kassi','Gillion','Cornelisse',18,'2005-10-18'),('LGCB642852AIPRUS02','Townie','Rollinson','Kenlin',68,'1933-06-08'),('LHID573181EOPIRT64','Shir','Shrimpling','Enrietto',73,'1973-03-13'),('LHJO581012HSXEHK34','Sonia','Royan','Gibson',39,'2010-12-16'),('LSDN660866ZABWHR68','Caroline','Wickling','Mapham',64,'1950-04-11'),('LTXJ916973IWOZNN07','Izak','Enderby','Lapley',41,'1943-12-27'),('MFBT004501HYCMRL20','Leonie','Beasleigh','Crain',25,'2007-07-24'),('MGTZ586484YLNBTA49','Jacquie','Stapleford','Mapp',27,'1955-09-07'),('NICO','NICOLAS','PINEDA','PINEDA',21,'2018-03-25'),('NJMY642015LBMXVX29','Inglebert','Farebrother','Simpkins',44,'1969-02-19'),('NJXA896232IJPYGW02','Lyndsay','Spira','Serjent',24,'1932-11-16'),('NWVE985020FUCQND96','Raf','Hucke','Payley',54,'1991-09-14'),('NZMD987006RMADTV14','Uriah','MacClancey','Hess',43,'2016-04-13'),('OEIT412541UTGVON32','Octavia','Dickons','Caldera',62,'1974-06-29'),('OGBN158112SSYXMB66','Gaelan','Edgington','McKerron',67,'1989-12-28'),('OJDA417821YLYGTW81','Oliy','Burgoyne','Atlay',52,'1982-11-18'),('ORJT045437FOXQBF17','Fayre','Palfrey','Bradnum',18,'1995-07-06'),('OTCW167980MIIOIJ90','Tamar','Gallehock','Blackler',46,'1941-09-29'),('OWAI616503LXPPTT39','Mirabel','Rzehor','Stookes',27,'1935-08-31'),('OXSY629911QHZOTV70','Anita','Gallacher','Benardeau',46,'2016-05-26'),('OYEL084442BZDDYS00','Ailbert','Coathup','McLelland',18,'1984-04-13'),('OZNJ903710SCTPZH73','Hazel','Doneld','Michiel',75,'2015-12-15'),('PKWP394731JWURIC87','Lottie','Milsom','Postins',59,'1965-02-07'),('PTQF806059LJDYNN38','Willette','Bushill','Mc Grath',32,'1939-08-10'),('QJDN174639FLQABR61','Budd','Balint','Wendover',21,'1966-05-24'),('QWVV630277GYXYHE98','Fredek','Leyrroyd','Broxup',18,'1953-12-15'),('RAPW052181GQODHE48','Myrta','Leadbetter','Critch',68,'1980-12-28'),('SAFS235968YNIXNM79','Merrel','Darkins','Drinkhill',74,'1981-02-06'),('SCSF152059RYDTLX96','Berta','Surcombe','Eaves',48,'2015-02-10'),('SVQK604302JHYBDS47','Hiram','Knee','Wescott',30,'1944-12-17'),('TDHA395622RFSSAL83','Evyn','Yelden','Kemitt',23,'2002-09-03'),('TGGH808329ZOABYG49','Hoebart','Bathersby','Chason',70,'1978-09-24'),('TOAZ074452XHAFJG96','Samaria','Bierling','Batrip',50,'1931-08-15'),('VAIK116107TYYOVS45','Thedrick','Trencher','Eger',28,'1953-12-20'),('VFRD948441LLXTGA91','Bondie','Lamming','Rolin',25,'2013-05-12'),('VIP','JUAN MANUEL','VILCHIS','PINEDA',21,'2018-03-08'),('VIPJ','JUAN','VILCHIS','PINEDA',21,'2018-03-26'),('VIPJ86HDFLNN06','Juan Manuel','Vilchis','Pineda',21,'1996-09-25'),('VIPJ967','JUAN MANUEL','VILCHIS','PINEDA',21,'1996-09-25'),('VIPJ96HDFLNN06','JUAN','VILCHIS','PINEDA',21,'1996-09-25'),('VIPs','JUAN MANUEL','VILCHIS','PINEDA',21,'2018-03-08'),('VIPss','JUAN MANUEL','VILCHIS','PINEDA',21,'2018-03-08'),('VIPsss','JUAN MANUEL','VILCHIS','PINEDA',21,'2018-03-08'),('VOBY471272QAYAOB27','Michelle','Buckbee','Mulhall',34,'2007-01-24'),('VTFQ285453HOZKCY98','Zaccaria','Tebbett','Estick',25,'1969-08-16'),('VXWL969799PGJBBI58','Nathanael','Kaasman','MacEllen',28,'2004-01-13'),('W','R','R','R',21,'2018-03-24'),('WITV628296OQAANY73','Glendon','Amott','Korlat',36,'2011-01-12'),('WOJU440540OCAFIJ53','Bertram','Lung','Jorcke',47,'1976-04-13'),('WOLX756525XFYRVK72','Willdon','Leser','Wilcocks',36,'2010-07-03'),('WPHQ747500MYTCGB35','Maiga','Boseley','Baudinot',34,'2003-08-01'),('WVOZ574821CGNTCV20','Klement','Mackie','Wands',32,'1987-06-15'),('XFOE549457ZRJQJW36','Costa','Bebb','Boyington',60,'1935-03-18'),('XFYU609781PATQGJ26','Townsend','Guynemer','Palmar',46,'1980-02-20'),('XNZW715562NUUHMS03','Jeramie','Perot','Riddington',33,'1951-02-02'),('XRYE303662JADPTI70','Mallorie','McTrustam','Verrick',69,'1936-07-18'),('XVEQ055773UWQLQD60','Leandra','Derrell','Staves',49,'1954-12-19'),('XVGP462416GZWUTO63','Nell','Stookes','Ameer-Beg',39,'1953-07-06'),('YFEK058057WKDCWC67','Taber','Jouning','Ibbett',28,'1991-10-17'),('YKZT813651GSYLBZ90','Cari','Harron','Whapham',66,'1934-11-22'),('YRNY396147HDGNEX10','Ethelda','Gay','Gibb',62,'1945-09-18'),('YTRY892050OMSUVD40','Carlita','Klazenga','Rillatt',35,'2005-12-03'),('ZICF753541YRJXBI53','Gael','Aksell','Extance',66,'1984-07-21'),('ZKVO530405DIZDLP53','Corene','Islip','Kimmings',65,'1961-03-15'),('ZQQY854364DMOGXU40','Lauree','Shearsby','Vasyutochkin',42,'1945-07-24');
/*!40000 ALTER TABLE `Persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Posicion`
--

DROP TABLE IF EXISTS `Posicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Posicion` (
  `posicion` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`posicion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Posicion`
--

LOCK TABLES `Posicion` WRITE;
/*!40000 ALTER TABLE `Posicion` DISABLE KEYS */;
INSERT INTO `Posicion` VALUES ('Cornerbacks'),('Corredor'),('Defensive end'),('Defensive tackle '),('Gunner'),('Hands team'),('Holder'),('Linebackers'),('Mariscal de campo'),('Pateador'),('Receptor'),('Retornador de kickoff'),('Retornador de punt'),('Safeties'),('Tackle ofensivo'),('Wedge buster');
/*!40000 ALTER TABLE `Posicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Proveedor`
--

DROP TABLE IF EXISTS `Proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Proveedor` (
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ciudad` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`nombre`),
  KEY `ciudad` (`ciudad`),
  CONSTRAINT `Proveedor_ibfk_1` FOREIGN KEY (`ciudad`) REFERENCES `Ciudad` (`nombreCiudad`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Proveedor`
--

LOCK TABLES `Proveedor` WRITE;
/*!40000 ALTER TABLE `Proveedor` DISABLE KEYS */;
INSERT INTO `Proveedor` VALUES ('Copa Holdings, S.A.','Aguascalientes'),('Air T, Inc.','Cárdenas'),('Antares Pharma, Inc.','Cárdenas'),('Magic Software Enterprises Ltd.','Cárdenas'),('Nuveen Quality Preferred Income Fund 2','Cárdenas'),('Ottawa Bancorp, Inc.','Cárdenas'),('Caesars Acquisition Company','Chilpancingo'),('FCB Financial Holdings, Inc.','Chilpancingo'),('MaxPoint Interactive, Inc.','Chilpancingo'),('SG Blocks, Inc.','Chilpancingo'),('Symantec Corporation','Chilpancingo'),('Community Health Systems, Inc.','Ciudad del Carmen'),('GigaMedia Limited','Colima-Villa de Álvarez'),('Huntington Bancshares Incorporated','Colima-Villa de Álvarez'),('McClatchy Company (The)','Colima-Villa de Álvarez'),('Senomyx, Inc.','Colima-Villa de Álvarez'),('Workiva Inc.','Colima-Villa de Álvarez'),('Zions Bancorporation','Colima-Villa de Álvarez'),('American Vanguard Corporation','Cuernavaca'),('Changyou.com Limited','Culiacán'),('The Obesity ETF','Culiacán'),('Eldorado Resorts, Inc.','Durango'),('Global X S&P 500 Catholic Values ETF','Durango'),('Washington Real Estate Investment Trust','Durango'),('Arbor Realty Trust','Guanajuato'),('Global Eagle Entertainment Inc.','Guanajuato'),('Nuveen Municipal 2021 Target Term Fund','Guanajuato'),('Western Asset/Claymore U.S Treasury Inflation Prot','Guanajuato'),('American Capital Senior Floating, Ltd.','Manzanillo'),('ARCA biopharma, Inc.','Manzanillo'),('BioSpecifics Technologies Corp','Manzanillo'),('First Trust Latin America AlphaDEX Fund','Manzanillo'),('Ingevity Corporation','Manzanillo'),('Oritani Financial Corp.','Manzanillo'),('PennantPark Investment Corporation','Manzanillo'),('Rosehill Resources Inc.','Manzanillo'),('W.W. Grainger, Inc.','Manzanillo'),('Highland Funds I','Matamoros'),('U.S. Bancorp','Matamoros'),('Zafgen, Inc.','Matamoros'),('DWS High Income Opportunities Fund, Inc.','Mazatlán'),('PowerShares Russell 1000 Low Beta Equal Weight Por','Mazatlán'),('WisdomTree Emerging Markets Quality Dividend Growt','Mazatlán'),('Gabelli Convertible and Income Securities Fund, In','Mérida'),('Live Oak Bancshares, Inc.','Mexicali'),('Teekay Tankers Ltd.','Minatitlán'),('Cato Corporation (The)','Monclova-Frontera'),('Douglas Dynamics, Inc.','Monclova-Frontera'),('Frontline Ltd.','Monclova-Frontera'),('Kelly Services, Inc.','Monclova-Frontera'),('M B T Financial Corp','Monclova-Frontera'),('Motorcar Parts of America, Inc.','Monclova-Frontera'),('NextEra Energy, Inc.','Monclova-Frontera'),('Scorpio Bulkers Inc.','Monclova-Frontera'),('Shaw Communications Inc.','Monclova-Frontera'),('Alexander & Baldwin Holdings, Inc.','Monterrey'),('Esperion Therapeutics, Inc.','Monterrey'),('Goldman Sachs Group, Inc. (The)','Monterrey'),('II-VI Incorporated','Monterrey'),('UMH Properties, Inc.','Monterrey'),('EDAP TMS S.A.','Oaxaca'),('The Community Financial Corporation','Oaxaca'),('Amedica Corporation','Reynosa-Río Bravo'),('Coherent, Inc.','Reynosa-Río Bravo'),('SMART Global Holdings, Inc.','Reynosa-Río Bravo'),('Inseego Corp.','Salamanca'),('Luxoft Holding, Inc.','Salamanca'),('SGOCO Group, Ltd','Salamanca'),('Virtu Financial, Inc.','Salamanca'),('Flagstar Bancorp, Inc.','San Luis Potosí-Soledad'),('Insight Select Income Fund','San Luis Potosí-Soledad'),('Mesabi Trust','San Luis Potosí-Soledad'),('Terex Corporation','San Luis Potosí-Soledad'),('Cantel Medical Corp.','Tehuacán'),('Giga-tronics Incorporated','Tehuacán'),('Liberty Media Corporation','Tehuacán'),('Yangtze River Development Limited','Tehuacán'),('Global Partners LP','Tepic'),('L3 Technologies, Inc.','Tepic'),('Eagle Bulk Shipping Inc.','Tlaxcala-Apizaco'),('Zillow Group, Inc.','Tlaxcala-Apizaco'),('America First Multifamily Investors, L.P.','Tulancingo'),('Brixmor Property Group Inc.','Tulancingo'),('ClearBridge Energy MLP Opportunity Fund Inc.','Tulancingo'),('Finjan Holdings, Inc.','Tulancingo'),('National Beverage Corp.','Tulancingo'),('Silver Standard Resources Inc.','Tulancingo'),('Xencor, Inc.','Tulancingo'),('Yingli Green Energy Holding Company Limited','Tulancingo'),('PowerShares DWA NASDAQ Momentum Portfolio','Xalapa');
/*!40000 ALTER TABLE `Proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RecordDeEquipo`
--

DROP TABLE IF EXISTS `RecordDeEquipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RecordDeEquipo` (
  `temporada` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombreEquipo` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `partidosGanados` int(11) DEFAULT NULL,
  `partidosPerdidos` int(11) DEFAULT NULL,
  `partidosEmpatados` int(11) DEFAULT NULL,
  PRIMARY KEY (`temporada`,`nombreEquipo`),
  KEY `nombreEquipo` (`nombreEquipo`),
  CONSTRAINT `RecordDeEquipo_ibfk_1` FOREIGN KEY (`nombreEquipo`) REFERENCES `Equipo` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RecordDeEquipo`
--

LOCK TABLES `RecordDeEquipo` WRITE;
/*!40000 ALTER TABLE `RecordDeEquipo` DISABLE KEYS */;
INSERT INTO `RecordDeEquipo` VALUES ('2015','Atlanta Falcons',0,1,0),('2015','BURROS BLANCOS',0,2,0),('2017','Baltimore Ravens',0,1,0),('2017','Buffalo Bills',0,1,0),('2017','BURROS BLANCOS',2,0,0),('2017','Kansas City Chiefs',0,1,0),('2017','Tampa Bay Buccaneers',1,0,0);
/*!40000 ALTER TABLE `RecordDeEquipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RecordDeVentas`
--

DROP TABLE IF EXISTS `RecordDeVentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RecordDeVentas` (
  `nombreTienda` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idVenta` int(11) NOT NULL,
  `anio` int(11) NOT NULL,
  `trimestre` int(11) NOT NULL,
  `monto` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`nombreTienda`,`idVenta`,`anio`,`trimestre`),
  CONSTRAINT `RecordDeVentas_ibfk_1` FOREIGN KEY (`nombreTienda`) REFERENCES `Tienda` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RecordDeVentas`
--

LOCK TABLES `RecordDeVentas` WRITE;
/*!40000 ALTER TABLE `RecordDeVentas` DISABLE KEYS */;
INSERT INTO `RecordDeVentas` VALUES ('Abernathy Inc',28,2017,1,1191.39),('Abernathy Inc',56,2018,1,931.78),('Abernathy Inc',58,2018,4,676.61),('Abernathy Inc',100,2017,4,394.87),('Anderson-Mitchell',1,2018,1,7825.04),('Anderson-Mitchell',2,2018,1,3643.84),('Anderson-Mitchell',3,2018,1,7741.36),('Anderson-Mitchell',17,2017,1,46.60),('Anderson-Mitchell',22,2017,2,819.53),('Anderson-Mitchell',24,2018,2,1643.32),('Bartell, Hettinger and Sanford',76,2017,1,447.65),('Bartell, Hettinger and Sanford',84,2018,1,513.19),('Braun-Altenwerth',55,2017,3,166.95),('Braun-Altenwerth',72,2017,2,1850.75),('Gusikowski Inc',16,2017,1,1081.75),('Gusikowski Inc',55,2017,1,1480.93),('Gusikowski Inc',59,2017,1,391.35),('Gusikowski Inc',72,2018,2,1483.45),('Gusikowski Inc',75,2018,1,494.14),('Jaskolski Inc',35,2017,3,1374.33),('Jaskolski Inc',74,2017,1,239.61),('Jaskolski Inc',90,2017,4,670.66),('Kerluke-Kutch',67,2018,3,582.25),('Kerluke-Kutch',92,2018,3,148.95),('Kohler and Sons',8,2018,4,1898.53),('Kohler and Sons',13,2018,3,1498.46),('Kohler and Sons',63,2018,4,105.61),('Smith-Kiehn',5,2017,2,812.83),('Smith-Kiehn',6,2018,2,1171.80),('Smith-Kiehn',19,2018,4,1674.16),('Smith-Kiehn',48,2017,2,495.13),('Smith-Kiehn',98,2018,1,1859.37),('Ziemann, Bergstrom and Kerluke',13,2017,2,1037.33),('Ziemann, Bergstrom and Kerluke',32,2018,1,899.87),('Ziemann, Bergstrom and Kerluke',68,2018,3,928.39),('Ziemann, Bergstrom and Kerluke',79,2017,1,1873.53);
/*!40000 ALTER TABLE `RecordDeVentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tiempo`
--

DROP TABLE IF EXISTS `Tiempo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tiempo` (
  `hora` time NOT NULL,
  PRIMARY KEY (`hora`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tiempo`
--

LOCK TABLES `Tiempo` WRITE;
/*!40000 ALTER TABLE `Tiempo` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tiempo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tienda`
--

DROP TABLE IF EXISTS `Tienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tienda` (
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombreEstadio` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `curpGerente` varchar(18) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`nombre`),
  KEY `nombreEstadio` (`nombreEstadio`),
  KEY `curpGerente` (`curpGerente`),
  CONSTRAINT `Tienda_ibfk_1` FOREIGN KEY (`nombreEstadio`) REFERENCES `Estadio` (`nombreEstadio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Tienda_ibfk_2` FOREIGN KEY (`curpGerente`) REFERENCES `Persona` (`CURP`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tienda`
--

LOCK TABLES `Tienda` WRITE;
/*!40000 ALTER TABLE `Tienda` DISABLE KEYS */;
INSERT INTO `Tienda` VALUES ('Abernathy Inc','Estadio Víctor Manuel Reyna','IEFF822431NLDPRJ42'),('Anderson-Mitchell','Estadio Luis Pirata Fuente','ELXQ279168ICCUMY39'),('Bartell, Hettinger and Sanford','Estadio Victoria','VOBY471272QAYAOB27'),('Braun-Altenwerth','Estadio La Corregidora','KMYB817361DYEYGM97'),('Gusikowski Inc','Estadio Universitario','MGTZ586484YLNBTA49'),('Jaskolski Inc','Estadio BBVA Bancomer','OZNJ903710SCTPZH73'),('Kerluke-Kutch','Estadio Hidalgo','DBIW646404JURIWV18'),('Kohler and Sons','Estadio Morelos','BVBD961193HEVCDP26'),('Marquardt-Sauer','Estadio TSM Corona','LTXJ916973IWOZNN07'),('Smith-Kiehn','Estadio Camp Nou','BDRW708138MEUMDF28'),('Ziemann, Bergstrom and Kerluke','Estadio Omnilife','JHAS669011LGDAPV92');
/*!40000 ALTER TABLE `Tienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TiendaTieneArticulo`
--

DROP TABLE IF EXISTS `TiendaTieneArticulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TiendaTieneArticulo` (
  `nombreTienda` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombreArticulo` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombreProveedor` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `existencias` int(11) DEFAULT NULL,
  PRIMARY KEY (`nombreTienda`,`nombreArticulo`,`nombreProveedor`),
  KEY `nombreArticulo` (`nombreArticulo`),
  KEY `nombreProveedor` (`nombreProveedor`),
  CONSTRAINT `TiendaTieneArticulo_ibfk_1` FOREIGN KEY (`nombreTienda`) REFERENCES `Tienda` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `TiendaTieneArticulo_ibfk_2` FOREIGN KEY (`nombreArticulo`) REFERENCES `Articulo` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `TiendaTieneArticulo_ibfk_3` FOREIGN KEY (`nombreProveedor`) REFERENCES `Proveedor` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TiendaTieneArticulo`
--

LOCK TABLES `TiendaTieneArticulo` WRITE;
/*!40000 ALTER TABLE `TiendaTieneArticulo` DISABLE KEYS */;
INSERT INTO `TiendaTieneArticulo` VALUES ('Abernathy Inc','CARCASA DE CELULAR','U.S. Bancorp',63),('Abernathy Inc','CARCASA DE CELULAR','Workiva Inc.',60),('Abernathy Inc','ESTAMPA','America First Multifamily Investors, L.P.',21),('Abernathy Inc','PLAYERA','Amedica Corporation',17),('Abernathy Inc','PLAYERA','Motorcar Parts of America, Inc.',2),('Abernathy Inc','POSTER','Frontline Ltd.',65),('Abernathy Inc','VASO','Shaw Communications Inc.',24),('Anderson-Mitchell','BALON','Finjan Holdings, Inc.',18),('Anderson-Mitchell','CUADRO','Symantec Corporation',0),('Anderson-Mitchell','PLAYERA','L3 Technologies, Inc.',0),('Anderson-Mitchell','POSTER','Community Health Systems, Inc.',0),('Anderson-Mitchell','TENNIS','The Obesity ETF',39),('Anderson-Mitchell','VASO','Scorpio Bulkers Inc.',9),('Bartell, Hettinger and Sanford','ESTAMPA','America First Multifamily Investors, L.P.',10),('Bartell, Hettinger and Sanford','GORRA','W.W. Grainger, Inc.',15),('Bartell, Hettinger and Sanford','TENNIS','Air T, Inc.',3),('Braun-Altenwerth','BUFFANDA','Xencor, Inc.',97),('Braun-Altenwerth','CARCASA DE CELULAR','Air T, Inc.',83),('Braun-Altenwerth','CARCASA DE CELULAR','Mesabi Trust',80),('Braun-Altenwerth','CHAMARRA','Gabelli Convertible and Income Securities Fund, In',90),('Braun-Altenwerth','PLAYERA','Amedica Corporation',59),('Braun-Altenwerth','VASO','Virtu Financial, Inc.',43),('Gusikowski Inc','BALON','Global Eagle Entertainment Inc.',49),('Gusikowski Inc','CHAMARRA','Virtu Financial, Inc.',8),('Gusikowski Inc','GORRA','Live Oak Bancshares, Inc.',69),('Gusikowski Inc','VASO','American Capital Senior Floating, Ltd.',97),('Jaskolski Inc','CARCASA DE CELULAR','U.S. Bancorp',59),('Jaskolski Inc','CARTERA','Coherent, Inc.',52),('Jaskolski Inc','CASCO','Yingli Green Energy Holding Company Limited',96),('Jaskolski Inc','ESTAMPA','America First Multifamily Investors, L.P.',7),('Jaskolski Inc','GORRA','Live Oak Bancshares, Inc.',9),('Jaskolski Inc','PELUCHE','Symantec Corporation',55),('Jaskolski Inc','PLAYERA','L3 Technologies, Inc.',56),('Jaskolski Inc','TENNIS','Inseego Corp.',25),('Kerluke-Kutch','CARCASA DE CELULAR','UMH Properties, Inc.',68),('Kerluke-Kutch','CARTERA','The Community Financial Corporation',85),('Kerluke-Kutch','GORRA','Nuveen Municipal 2021 Target Term Fund',87),('Kohler and Sons','GORRA','SMART Global Holdings, Inc.',19),('Kohler and Sons','PLAYERA','Shaw Communications Inc.',45),('Kohler and Sons','PLAYERA','UMH Properties, Inc.',100),('Kohler and Sons','POSTER','Oritani Financial Corp.',58),('Marquardt-Sauer','CARCASA DE CELULAR','Global Eagle Entertainment Inc.',51),('Marquardt-Sauer','CARTERA','Coherent, Inc.',31),('Marquardt-Sauer','CUADRO','Symantec Corporation',48),('Marquardt-Sauer','LLAVERO','American Vanguard Corporation',61),('Marquardt-Sauer','PLAYERA','Shaw Communications Inc.',28),('Smith-Kiehn','CARCASA DE CELULAR','U.S. Bancorp',40),('Smith-Kiehn','CARCASA DE CELULAR','UMH Properties, Inc.',9),('Smith-Kiehn','CARCASA DE CELULAR','Zillow Group, Inc.',35),('Smith-Kiehn','CARTERA','Coherent, Inc.',41),('Ziemann, Bergstrom and Kerluke','BALON','Scorpio Bulkers Inc.',10),('Ziemann, Bergstrom and Kerluke','CARCASA DE CELULAR','Zillow Group, Inc.',10),('Ziemann, Bergstrom and Kerluke','CARTERA','The Community Financial Corporation',28),('Ziemann, Bergstrom and Kerluke','CHAMARRA','Virtu Financial, Inc.',81),('Ziemann, Bergstrom and Kerluke','GORRA','Magic Software Enterprises Ltd.',32),('Ziemann, Bergstrom and Kerluke','PLAYERA','L3 Technologies, Inc.',42),('Ziemann, Bergstrom and Kerluke','TENNIS','Air T, Inc.',3),('Ziemann, Bergstrom and Kerluke','TENNIS','Inseego Corp.',0),('Ziemann, Bergstrom and Kerluke','VASO','American Capital Senior Floating, Ltd.',50);
/*!40000 ALTER TABLE `TiendaTieneArticulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `CURP` varchar(18) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombreUsuario` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `contrasena` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `categoriaUsuario` varchar(25) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`CURP`,`nombreUsuario`),
  KEY `categoriaUsuario` (`categoriaUsuario`),
  CONSTRAINT `Usuario_ibfk_1` FOREIGN KEY (`CURP`) REFERENCES `Persona` (`CURP`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Usuario_ibfk_2` FOREIGN KEY (`categoriaUsuario`) REFERENCES `CategoriaUsuario` (`categoria`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES ('VIPJ967','MACHO','PASS','ADMINISTRADOR DE EQUIPO'),('VIPJ96HDFLNN06','JUAN','PASS','ADMINISTRADOR DE EQUIPO');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-10 22:55:43
