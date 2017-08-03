/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.0.67-community-nt : Database - chat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`chat` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `chat`;

/*Table structure for table `chat1` */

DROP TABLE IF EXISTS `chat1`;

CREATE TABLE `chat1` (
  `from1` varchar(1000) default NULL,
  `to1` varchar(1000) default NULL,
  `chat_id` int(100) default NULL,
  `message` varchar(1000) default NULL,
  `date_time` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `chat1` */

insert  into `chat1`(`from1`,`to1`,`chat_id`,`message`,`date_time`) values ('rajat','user1',10,'Hello!','Thu Jul 20 22:34:00 IST 2017'),('user1','rajat',1093,'Hey','Thu Jul 20 22:34:08 IST 2017'),('user1','rajat',1093,'Dont know yet!','Thu Jul 20 22:34:31 IST 2017'),('user1','rajat',439,'so?','Thu Jul 20 22:37:45 IST 2017'),('user1','rajat',439,'so?','Thu Jul 20 22:40:17 IST 2017'),('user1','rajat',439,'so?','Thu Jul 20 22:40:50 IST 2017'),('rajat','user2',1640,'Hello you','Thu Jul 20 22:42:08 IST 2017'),('user2','rajat',305,'Hey','Thu Jul 20 22:42:25 IST 2017'),('rajat','user2',1640,'What is up???','Thu Jul 20 22:42:39 IST 2017'),('user3','user2',1288,'Hey 2','Thu Jul 20 22:44:44 IST 2017'),('user2','user3',1093,'Hey 3','Thu Jul 20 22:44:51 IST 2017'),('rajat','user3',1722,'Hey You saw my photography pic?','Thu Jul 20 23:10:57 IST 2017'),('user3','rajat',1819,'Yeah Yeah. So cool','Thu Jul 20 23:11:08 IST 2017'),('user3','user2',736,'Yo 2','Sat Jul 22 14:41:42 IST 2017'),('user3','user2',736,'Yo 2','Sat Jul 22 14:42:14 IST 2017'),('user3','user2',736,'Yo 2','Sat Jul 22 14:43:11 IST 2017'),('user2','user3',1243,'Hii','Sat Jul 22 14:43:25 IST 2017'),('user3','user2',703,'Saw the Chat Room?','Sat Jul 22 18:28:08 IST 2017'),('user2','user3',386,'Yes','Sat Jul 22 18:28:16 IST 2017'),('user3','user2',703,'Ok I\'m sharing a file. Check it out.','Sat Jul 22 18:28:36 IST 2017'),('user2','user3',386,'Ok','Sat Jul 22 18:28:41 IST 2017'),('user1','user3',1120,'Hello','Fri Jul 28 12:32:37 IST 2017'),('user3','user1',43,'Hi','Fri Jul 28 12:32:44 IST 2017');

/*Table structure for table `chatroom` */

DROP TABLE IF EXISTS `chatroom`;

CREATE TABLE `chatroom` (
  `username` varchar(100) default NULL,
  `message` varchar(5000) default NULL,
  `date_time` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `chatroom` */

insert  into `chatroom`(`username`,`message`,`date_time`) values ('user3','Hello Guys','Sat Jul 22 14:33:24 IST 2017'),('rajat','Hello','Sat Jul 22 14:35:07 IST 2017'),('user3','How are you all doing??','Sat Jul 22 14:35:19 IST 2017'),('user2','nothing much.','Sat Jul 22 14:36:13 IST 2017'),('rajat','Let\'s catch up?','Sat Jul 22 14:36:39 IST 2017'),('user3','Ok. When and Where?','Sat Jul 22 14:37:25 IST 2017'),('user2','Yeah! Let\'s.','Sat Jul 22 14:39:06 IST 2017'),('user3','Umm..I don\'t know. Let\'s decide?','Sat Jul 22 14:39:30 IST 2017'),('user2','Yeah','Sat Jul 22 18:27:19 IST 2017'),('user3','Hello\r\n','Fri Jul 28 15:56:23 IST 2017'),('user1','Hi','Fri Jul 28 15:56:36 IST 2017');

/*Table structure for table `files` */

DROP TABLE IF EXISTS `files`;

CREATE TABLE `files` (
  `id` int(100) default NULL,
  `title` varchar(100) default NULL,
  `file` longblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `files` */


/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `email` varchar(100) default NULL,
  `password` varchar(100) default NULL,
  `status` varchar(100) default NULL,
  `gender` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`email`,`password`,`status`,`gender`) values ('rajat','rajat','offline','male'),('user1','user1','online','male'),('user2','user2','offline','female'),('user3','user3','offline','Female');

/*Table structure for table `registration` */

DROP TABLE IF EXISTS `registration`;

CREATE TABLE `registration` (
  `fullName` varchar(100) default NULL,
  `email` varchar(100) default NULL,
  `password` varchar(100) default NULL,
  `dateOfBirth` varchar(100) default NULL,
  `gender` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `registration` */

insert  into `registration`(`fullName`,`email`,`password`,`dateOfBirth`,`gender`) values ('rajat','rajat','rajat','03-08-1994','male'),('user1','user1','user1','1992-02-02','Male'),('user2','user2','user2','1993-12-12','Female'),('user3','user3','user3','1992-11-11','Female');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;