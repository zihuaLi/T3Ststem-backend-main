-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `distance`
--

DROP TABLE IF EXISTS `distance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distance` (
  `distanceid` int NOT NULL AUTO_INCREMENT,
  `sitetoid` int DEFAULT NULL,
  `distance` int DEFAULT NULL,
  `site_siteid` int DEFAULT NULL,
  PRIMARY KEY (`distanceid`),
  KEY `fk_distance_site_idx` (`site_siteid`),
  KEY `FKjql6m6xi3eqh62pqqqfhc5f4c` (`sitetoid`),
  CONSTRAINT `fk_distance_site` FOREIGN KEY (`site_siteid`) REFERENCES `site` (`siteid`),
  CONSTRAINT `FKjql6m6xi3eqh62pqqqfhc5f4c` FOREIGN KEY (`sitetoid`) REFERENCES `site` (`siteid`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distance`
--

LOCK TABLES `distance` WRITE;
/*!40000 ALTER TABLE `distance` DISABLE KEYS */;
INSERT INTO `distance` VALUES (1,2,17,1),(2,16,10,1),(3,20,7,1),(4,3,15,2),(5,4,18,3),(6,7,6,3),(7,10,10,3),(8,14,7,3),(9,19,15,3),(10,27,6,3),(11,5,20,4),(12,7,10,4),(13,10,9,4),(14,11,8,4),(16,19,15,4),(17,27,9,4),(18,6,35,5),(19,30,20,5),(20,7,17,6),(21,8,15,7),(22,10,8,7),(23,11,5,7),(24,14,8,7),(25,19,10,7),(26,27,15,7),(27,9,25,8),(28,10,20,8),(29,11,17,10),(30,19,7,10),(31,27,10,10),(32,12,39,11),(33,19,6,11),(34,27,5,11),(35,13,24,12),(36,22,8,12),(37,14,35,13),(38,15,17,14),(39,19,4,14),(40,27,6,14),(41,16,21,15),(42,17,24,16),(43,20,10,16),(44,18,19,17),(45,19,31,18),(46,20,10,19),(47,27,5,19),(48,21,17,20),(49,22,15,21),(50,23,40,22),(51,24,35,23),(52,25,24,24),(53,26,17,25),(54,27,50,26),(55,28,15,27),(56,29,31,28),(57,15,7,28),(58,30,17,29),(59,1,50,30);
/*!40000 ALTER TABLE `distance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site`
--

DROP TABLE IF EXISTS `site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `site` (
  `siteid` int NOT NULL AUTO_INCREMENT,
  `sitename` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `starttime` varchar(255) DEFAULT NULL,
  `endtime` varchar(255) DEFAULT NULL,
  `period` varchar(255) DEFAULT NULL,
  `fee` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `sitetype` varchar(255) DEFAULT NULL,
  `besttime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`siteid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site`
--

LOCK TABLES `site` WRITE;
/*!40000 ALTER TABLE `site` DISABLE KEYS */;
INSERT INTO `site` VALUES (1,'The Louvre-Lens Museum','Satellite branch of the Louvre located in Lens.','8:00','18:00','Modern','10','Lens','Museum','3'),(2,'Puy du Fou','Historical theme park showcasing various periods.','8:00','18:00','Various','39','Les Epesses','Historic Site','4'),(3,'Louvre Museum','World\'s largest art museum and a historic','8:00','18:00','Medieval','17','Paris','Museum','5'),(4,'Eiffel Tower','Iconic wrought-iron lattice tower and observation deck','8:00','18:00','Modern','17','Paris','Monument','1'),(5,'Palace of Versailles','Opulent palace with gardens, fountains, and Hall of Mirrors.','8:00','18:00','Baroque','16','Versailles','Historic Site','2'),(6,'Mont Saint-Michel','Gothic abbey perched on a rocky tidal island.','8:00','18:00','Medieval','12','Normandy','Historic Site','3'),(7,'Notre-Dame Cathedral','Iconic Catholic cathedral with flying buttresses.','8:00','18:00','Gothic','2','Paris','Historic Site','2'),(8,'Château de Chambord','Renaissance castle with distinctive French architecture.','8:00','18:00','Renaissance','14','Chambord','Historic Site','3'),(9,'Pont du Gard','Ancient Roman aqueduct bridge.','8:00','18:00','Ancient Roman','9','Vers-Pont-du-Gard','Historic Site','3'),(10,'Sainte-Chapelle','Medieval Gothic chapel renowned for its stained glass.','8:00','18:00','Gothic','10','Paris','Historic Site','2'),(11,'Musée d\'Orsay','Art museum housed in a former railway station.','8:00','18:00','Modern','10','Paris','Museum','2'),(12,'Palace of the Popes','Historic palace associated with the Avignon Papacy.','8:00','18:00','Medieval','12','Avignon','Historic Site','3'),(13,'Saint-Malo Ramparts','Fortified walls surrounding the old town of Saint-Malo.','8:00','18:00','Medieval','2','Saint-Malo','Historic Site','2'),(14,'Centre Pompidou','Modern art museum known for its unique architectural design.','8:00','18:00','Modern','14','Paris','Museum','2'),(15,'Carcassonne','Medieval fortress with double walls and 53 towers.','8:00','18:00','Medieval','9','Carcassonne','Historic Site','2'),(16,'Musée du Louvre-Lens','Branch of the Louvre located in Lens.','8:00','18:00','Modern','10','Lens','Museum','3'),(17,'Palace of the Dukes of Burgundy','Former palace housing the Musée des Beaux-Arts de Dijon.','8:00','18:00','Gothic','8','Dijon','Historic Site','3'),(18,'Les Baux-de-Provence','Medieval village with ancient fortress ruins.','8:00','18:00','Medieval','13','Les Baux-de-Provence','Historic Site','3'),(19,'Musée Rodine','Museum showcasing works of sculptor Auguste Rodin.','8:00','18:00','Modern','12','Paris',' Museum','3'),(20,'Musée de l\'Orangerie','Art museum housing impressionist and post-impressionist works.','8:00','18:00','Modern','9','Lens',' Museum','3'),(21,'Sainte-Croix Museum','Museum showcasing archaeological and historical artifacts.','8:00','18:00','Various','7','Poitiers',' Museum','3'),(22,'Papal Palace of Avignon','Historic palace associated with the Avignon Papacy.','8:00','18:00','Medieval','12','Avignon','Historic Site','3'),(23,'Musée des Beaux-Arts de Lyon','Art museum showcasing European paintings and sculptures.','8:00','18:00','Modern','10','Lyon','Museum','3'),(24,'Arles Amphitheatre','Roman amphitheater still used for events and bullfights.','8:00','18:00','Ancient Roman','10','Arles','Historic Site','2'),(25,'Les Machines de l\'île','Artistic project featuring giant mechanical creatures.','8:00','18:00','Modern','12','Nantes','Museum','2'),(26,'Palace of the Kings of Majorca','Gothic palace offering panoramic views of Perpignan.','8:00','18:00','Gothic','12','Perpignan','Historic Site','2'),(27,'Musée Picasso','Museum dedicated to the works of Pablo Picasso.','8:00','18:00','Modern','14','Paris','Museum','3'),(28,'Cité de Carcassonne','Medieval fortified city with 52 towers.','8:00','18:00','Medieval','14','Carcassonne',' Historic Site','3'),(29,'Musée Matisse','Museum showcasing works of Henri Matisse.','8:00','18:00','Modern','14','Nice','Museum','3'),(30,'Musée Matisse','Opulent palace with gardens and Hall of Mirrors.','8:00','18:00','Baroque','14','Versailles','Historic Site','3');
/*!40000 ALTER TABLE `site` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-06 18:32:33
