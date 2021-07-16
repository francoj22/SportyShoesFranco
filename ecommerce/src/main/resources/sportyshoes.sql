CREATE DATABASE  IF NOT EXISTS `sportyshoes` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sportyshoes`;
-- MySQL dump 10.13  Distrib 8.0.25, for macos11 (x86_64)
--
-- Host: localhost    Database: sportyshoes
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `product_id` int NOT NULL,
  `qty` int NOT NULL,
  `product_size` varchar(1000) NOT NULL,
  `product_color` varchar(30) NOT NULL,
  PRIMARY KEY (`cart_id`),
  UNIQUE KEY `user_id` (`user_id`,`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (9,38,1,9,'9','Navy Blue');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `child_category`
--

DROP TABLE IF EXISTS `child_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `child_category` (
  `child_cat_id` int NOT NULL AUTO_INCREMENT,
  `child_cat_name` varchar(100) NOT NULL,
  `parent_cat_id` int NOT NULL,
  PRIMARY KEY (`child_cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `child_category`
--

LOCK TABLES `child_category` WRITE;
/*!40000 ALTER TABLE `child_category` DISABLE KEYS */;
INSERT INTO `child_category` VALUES (1,'Sport Shoes',1),(2,'Casual Shoes',1);
/*!40000 ALTER TABLE `child_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `main_parent_category`
--

DROP TABLE IF EXISTS `main_parent_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `main_parent_category` (
  `main_parent_cat_id` int NOT NULL AUTO_INCREMENT,
  `main_parent_cat_name` varchar(200) NOT NULL,
  PRIMARY KEY (`main_parent_cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `main_parent_category`
--

LOCK TABLES `main_parent_category` WRITE;
/*!40000 ALTER TABLE `main_parent_category` DISABLE KEYS */;
INSERT INTO `main_parent_category` VALUES (1,'Footwear');
/*!40000 ALTER TABLE `main_parent_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parent_category`
--

DROP TABLE IF EXISTS `parent_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parent_category` (
  `parent_cat_id` int NOT NULL AUTO_INCREMENT,
  `parent_cat_name` varchar(100) NOT NULL,
  `main_parent_cat_id` int NOT NULL,
  PRIMARY KEY (`parent_cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parent_category`
--

LOCK TABLES `parent_category` WRITE;
/*!40000 ALTER TABLE `parent_category` DISABLE KEYS */;
INSERT INTO `parent_category` VALUES (1,'Mens Footwear',1),(2,'Womens Footwear',1);
/*!40000 ALTER TABLE `parent_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_code` varchar(20) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `product_price` int DEFAULT NULL,
  `selling_price` int NOT NULL,
  `product_quantity` int NOT NULL,
  `product_size` varchar(1000) NOT NULL,
  `product_color_name` varchar(100) NOT NULL,
  `product_description` text NOT NULL,
  `main_parent_cat_id` int NOT NULL,
  `parent_cat_id` int NOT NULL,
  `child_cat_id` int NOT NULL,
  `product_images` text NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'PRD1','Puma Men Navy Blue Mesh Running Shoes',4000,2000,10,'9','Navy Blue','A pair of navy blue & orange running sports shoes, has regular styling, lace-up detail\r\nMesh upper\r\nCushioned footbed\r\nTextured and patterned outsole\r\nWarranty: 3 months\r\nWarranty provided by brand/manufacturer',1,1,1,'nike1.jpg,nike6.jpg'),(2,'PRD2','HRX by Hrithik Roshan\r\nWomen Pink Woven Design Metalite Running Shoes',5000,2999,1000,'7','pink','The HRX Performance Running Shoes from the Metalite Collection don\'t just hold your feet snugly as you run; they provide lateral support and stability too. These ultra lightweight shoes are just what you need to break your records.',1,2,1,'nike2.jpg,nike6.jpg'),(3,'PRD3','Nike\r\nWomen Black CITY TRAINER Training Shoes',4995,3999,100,'8','black','A pair of black training sports shoes, has lace-up detail\r\nTextile and mesh upper\r\nNike Comfort footbed\r\nTextured and patterned outsole\r\nWarranty: 6 months\r\nWarranty provided by Brand Owner / Manufacturer\r\n(warranty not valid on products with more than 20% discount)',1,2,1,'nike3.jpg,nike6.jpg'),(4,'PRD4','U.S. Polo Assn Men Navy Blue Slip-On Sneakers',2999,1999,100,'8','blue','A pair of round-toe navy blue slip-on sneakers, has regular styling, slip-on detail\r\nTextile upper\r\nCushioned footbed\r\nTextured and patterned outsole\r\nWarranty: 3 months\r\nWarranty provided by brand/manufacturer',1,1,2,'nike4.jpg,nike6.jpg'),(5,'PRD5','DressBerry Women Lavender Slip-On Sneakers',1899,1225,100,'7','lavender','A pair of round-toe lavender slip-on sneakers with applique detail, has regular styling, slip-on detail\r\nSynthetic upper\r\nCushioned footbed\r\nTextured and patterned outsole\r\nWarranty: 1 month\r\nWarranty provided by brand/manufacturer',1,2,2,'nike5.jpg,nike6.jpg');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `usersId` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(200) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  `phone` varchar(13) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`usersId`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (38,'Franco','Gutierrez','francogutierrezsalazar@gmail.com','0899405386','male','12345'),(39,'Admin','admin','admin@sportyshoes.com','0899405386','male','12345');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-16 21:56:46
