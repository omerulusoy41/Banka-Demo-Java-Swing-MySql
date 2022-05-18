-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: proje
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `islem`
--

DROP TABLE IF EXISTS `islem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `islem` (
  `idislem` int NOT NULL AUTO_INCREMENT,
  `hesapId1` int DEFAULT NULL,
  `hesapId2` int DEFAULT NULL,
  `tutar` float DEFAULT NULL,
  `kaynakBakiye` float DEFAULT NULL,
  `hedefBakiye` float DEFAULT NULL,
  `icerik` varchar(45) DEFAULT NULL,
  `tarih` varchar(45) DEFAULT NULL,
  `musteriId` int DEFAULT NULL,
  PRIMARY KEY (`idislem`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `islem`
--

LOCK TABLES `islem` WRITE;
/*!40000 ALTER TABLE `islem` DISABLE KEYS */;
INSERT INTO `islem` VALUES (1,2,-1,100,0,0,'para Yatirma','13/06/2022',1),(2,2,-1,100,100,0,'para Cekme','13/06/2022',1),(3,2,0,1000,0,0,'KrediCekme','13/06/2022',1),(4,2,0,87.5,1000,0,'borc odeme','13/06/2022',1),(5,2,0,87.5,912.5,0,'borc odeme','13/06/2022',1),(6,2,0,87.5,825,0,'borc odeme','13/06/2022',1),(7,2,27,100,737.5,0,'Hesaba Transfer','13/06/2022',1);
/*!40000 ALTER TABLE `islem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-14 22:21:48
