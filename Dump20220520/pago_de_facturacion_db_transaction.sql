CREATE DATABASE  IF NOT EXISTS `pago_de_facturacion_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pago_de_facturacion_db`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: pago_de_facturacion_db
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `id_transaction` int NOT NULL AUTO_INCREMENT,
  `company_id` int NOT NULL,
  `transaction_type_id` int NOT NULL,
  `payment_method_id` int NOT NULL,
  `invoice_type_id` int NOT NULL,
  `user_id` int NOT NULL,
  `transaction_cod` varchar(128) NOT NULL,
  `transaction_date` datetime NOT NULL,
  `amount_transaction` double NOT NULL,
  PRIMARY KEY (`id_transaction`),
  KEY `company_id_idx` (`company_id`),
  KEY `transaction_type_id_idx` (`transaction_type_id`),
  KEY `payment_method_id_idx` (`payment_method_id`),
  KEY `invoice_type_id_idx` (`invoice_type_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `t_user_id_idx` (`user_id`),
  CONSTRAINT `company_id` FOREIGN KEY (`company_id`) REFERENCES `company` (`id_company`),
  CONSTRAINT `invoice_type_id` FOREIGN KEY (`invoice_type_id`) REFERENCES `invoice_type` (`id_invoice`),
  CONSTRAINT `payment_method_id` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`id_payment_method`),
  CONSTRAINT `t_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id_user`),
  CONSTRAINT `transaction_type_id` FOREIGN KEY (`transaction_type_id`) REFERENCES `transaction_type` (`id_transaction_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-20 22:20:23
