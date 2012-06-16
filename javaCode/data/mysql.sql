# HeidiSQL Dump 
#
# --------------------------------------------------------
# Host:                 127.0.0.1
# Database:             mydb
# Server version:       6.0.10-alpha-community
# Server OS:            Win32
# Target-Compatibility: Standard ANSI SQL
# HeidiSQL version:     3.2 Revision: 1129
# --------------------------------------------------------

/*!40100 SET CHARACTER SET latin1;*/
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ANSI';*/
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;*/


#
# Database structure for database 'mydb'
#

CREATE DATABASE /*!32312 IF NOT EXISTS*/ "mydb" /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE "mydb";


#
# Table structure for table 'sys_users'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "sys_users" (
  "userid" int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  "userTypeID" int(11) DEFAULT NULL COMMENT '用户类型ID',
  "accounts" varchar(128) NOT NULL DEFAULT '' COMMENT '帐号',
  "password" varchar(128) DEFAULT NULL COMMENT '密码',
  "encryptionPassword" varchar(512) DEFAULT NULL COMMENT '加密密码',
  "userName" varchar(60) DEFAULT NULL COMMENT '用户名',
  "state" varchar(64) DEFAULT 'normal' COMMENT 'normal 正常',
  "locked" varchar(50) DEFAULT 'false' COMMENT '锁定标志',
  "foundIP" varbinary(64) DEFAULT NULL COMMENT '创建IP',
  "foundTime" date DEFAULT NULL COMMENT '创建时间',
  "foundPerson" varchar(128) DEFAULT NULL COMMENT '创建人',
  "amendTime" date DEFAULT NULL COMMENT '修改时间',
  "amendPerson" varchar(128) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY ("userid","accounts"),
  KEY "FK_Reference_4" ("userTypeID"),
  CONSTRAINT "FK_Reference_4" FOREIGN KEY ("userTypeID") REFERENCES "sys_usertype" ("userTypeID")
) AUTO_INCREMENT=2 /*!40100 DEFAULT CHARSET=utf8 COLLATE=utf8_bin*/;



#
# Dumping data for table 'sys_users'
#

LOCK TABLES "sys_users" WRITE;
/*!40000 ALTER TABLE "sys_users" DISABLE KEYS;*/
REPLACE INTO "sys_users" ("userid", "userTypeID", "accounts", "password", "encryptionPassword", "userName", "state", "locked", "foundIP", "foundTime", "foundPerson", "amendTime", "amendPerson") VALUES
	(1,NULL,'admin','123456',NULL,'系统管理员','normal','false',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE "sys_users" ENABLE KEYS;*/
UNLOCK TABLES;


#
# Table structure for table 'sys_usertype'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "sys_usertype" (
  "userTypeID" int(11) NOT NULL AUTO_INCREMENT,
  "userTypeCode" varchar(128) DEFAULT NULL COMMENT '编号',
  "userTypeName" varchar(128) DEFAULT NULL COMMENT '类型名称',
  "isReadOnly" tinyint(1) DEFAULT NULL COMMENT '是否只读',
  "isVisible" tinyint(1) DEFAULT NULL COMMENT '是否可见',
  PRIMARY KEY ("userTypeID")
) /*!40100 DEFAULT CHARSET=utf8 COLLATE=utf8_bin*/;



#
# Dumping data for table 'sys_usertype'
#

# (No data found.)

/*!40101 SET SQL_MODE=@OLD_SQL_MODE;*/
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;*/
