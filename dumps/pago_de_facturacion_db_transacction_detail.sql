-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pago_de_facturacion_db
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `transacction_detail`
--

DROP TABLE IF EXISTS `transacction_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transacction_detail` (
  `id_transaction_detail` int NOT NULL AUTO_INCREMENT,
  `transaction_id` int NOT NULL,
  `quantity` int NOT NULL,
  `description` varchar(128) NOT NULL,
  `unit_price` double NOT NULL,
  `iva` double NOT NULL,
  `amount` double NOT NULL,
  `I_invoice_type` int NOT NULL,
  PRIMARY KEY (`id_transaction_detail`),
  KEY `transaction_id_idx` (`transaction_id`),
  KEY `fk_transacction_detail_invoice_type1_idx` (`I_invoice_type`),
  CONSTRAINT `fk_transacction_detail_invoice_type1` FOREIGN KEY (`I_invoice_type`) REFERENCES `invoice_type` (`id_invoice`),
  CONSTRAINT `transaction_id` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id_transaction`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transacction_detail`
--

LOCK TABLES `transacction_detail` WRITE;
/*!40000 ALTER TABLE `transacction_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `transacction_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-31 17:38:28
