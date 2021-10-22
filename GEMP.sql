/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.17 : Database - gehaequipmentmanagementplatform
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE
DATABASE /*!32312 IF NOT EXISTS*/`gehaequipmentmanagementplatform` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE
`gehaequipmentmanagementplatform`;

/*Table structure for table `br` */

DROP TABLE IF EXISTS `br`;

CREATE TABLE `br`
(
    `uid`     int(11) NOT NULL,
    `eid`     int(11) NOT NULL,
    `date`    date NOT NULL,
    `returns` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `br` */

insert into `br`(`uid`, `eid`, `date`, `returns`)
values (5, 1, '2021-10-22', 1),
       (5, 2, '2021-10-22', 1);

/*Table structure for table `equipment` */

DROP TABLE IF EXISTS `equipment`;

CREATE TABLE `equipment`
(
    `id`    int(11) NOT NULL AUTO_INCREMENT,
    `name`  varchar(20) NOT NULL,
    `inUse` tinyint(1) NOT NULL,
    KEY     `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `equipment` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `name`     varchar(20) NOT NULL,
    `gender`   varchar(5)  NOT NULL,
    `role`     varchar(20) NOT NULL,
    `year`     int(5) DEFAULT NULL,
    `password` varchar(20) DEFAULT NULL,
    `email`    varchar(50) DEFAULT NULL,
    `phone`    varchar(20) DEFAULT NULL,
    KEY        `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
