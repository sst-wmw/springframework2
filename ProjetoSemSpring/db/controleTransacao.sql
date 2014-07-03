/*
SQLyog Enterprise - MySQL GUI v6.5
MySQL - 5.6.12-log : Database - controletransacao
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

create database if not exists `controletransacao`;

USE `controletransacao`;

/*Table structure for table `itempedido` */

DROP TABLE IF EXISTS `itempedido`;

CREATE TABLE `itempedido` (
  `cdItemPedido` int(11) NOT NULL AUTO_INCREMENT,
  `cdPedido` int(11) DEFAULT NULL,
  `vlItem` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`cdItemPedido`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `itempedido` */

insert  into `itempedido`(`cdItemPedido`,`cdPedido`,`vlItem`) values (7,8,'15'),(8,8,'15'),(9,9,'15'),(10,9,'15'),(11,10,'25'),(12,10,'25');

/*Table structure for table `pedido` */

DROP TABLE IF EXISTS `pedido`;

CREATE TABLE `pedido` (
  `cdPedido` int(11) NOT NULL AUTO_INCREMENT,
  `vlPedido` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`cdPedido`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `pedido` */

insert  into `pedido`(`cdPedido`,`vlPedido`) values (8,'30'),(9,'30'),(10,'50');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
