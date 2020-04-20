## OR人事管理系统

## 资料
sql:
```mysql

#创建数据库hrm
CREATE DATABASE hrm;
#使用数据库hrm
USE hrm;
#创建表dept_inf(部门表)
CREATE TABLE dept_inf (
  ID INT(11) NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(50) NOT NULL,
  REMARK VARCHAR(300) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
INSERT  INTO dept_inf(ID,NAME,REMARK) VALUES (1,'技术部','技术部'),(2,'运营部','运营部'),(3,'财务部','财务部'),(5,'总公办','总公办'),(6,'市场部','市场部'),(7,'教学部','教学部');

#创建表job_inf（职位表）
CREATE TABLE job_inf (
  ID INT(11) NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(50) NOT NULL,
  REMARK VARCHAR(300) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
INSERT  INTO job_inf(ID,NAME,REMARK) VALUES (1,'职员','职员'),(2,'Java开发工程师','Java开发工程师'),(3,'Java中级开发工程师','Java中级开发工程师'),(4,'Java高级开发工程师','Java高级开发工程师'),(5,'系统管理员','系统管理员'),(6,'架构师','架构师'),(7,'主管','主管'),(8,'经理','经理'),(9,'总经理','总经理');
#创建表user_inf（用户表）STATUS=1，用户是管理员，否则是普通用户
CREATE TABLE user_inf (
  ID INT(11) NOT NULL AUTO_INCREMENT,
  loginname VARCHAR(20) NOT NULL,
  PASSWORD VARCHAR(16) NOT NULL,
  STATUS INT(11) NOT NULL DEFAULT '1',
  createdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  username VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
INSERT  INTO user_inf(ID,loginname,PASSWORD,STATUS,createdate,username) VALUES (1,'admin','123456',2,'2016-03-12 09:34:28','超级管理员');
#创建表employee_inf
CREATE TABLE employee_inf (
  ID INT(11) NOT NULL AUTO_INCREMENT,
  DEPT_ID INT(11) NOT NULL,
  JOB_ID INT(11) NOT NULL,
  NAME VARCHAR(20) NOT NULL,
  CARD_ID VARCHAR(18) NOT NULL,
  ADDRESS VARCHAR(50) NOT NULL,
  POST_CODE VARCHAR(50) DEFAULT NULL,
  TEL VARCHAR(16) DEFAULT NULL,
  PHONE VARCHAR(11) NOT NULL,
  QQ_NUM VARCHAR(10) DEFAULT NULL,
  EMAIL VARCHAR(50) NOT NULL,
  SEX INT(11) NOT NULL DEFAULT '1',
  PARTY VARCHAR(10) DEFAULT NULL,
  BIRTHDAY DATETIME DEFAULT NULL,
  RACE VARCHAR(100) DEFAULT NULL,
  EDUCATION VARCHAR(10) DEFAULT NULL,
  SPECIALITY VARCHAR(20) DEFAULT NULL,
  HOBBY VARCHAR(100) DEFAULT NULL,
  REMARK VARCHAR(500) DEFAULT NULL,
  CREATE_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ID),
  KEY FK_EMP_DEPT (DEPT_ID),
  KEY FK_EMP_JOB (JOB_ID),
  CONSTRAINT FK_EMP_DEPT FOREIGN KEY (DEPT_ID) REFERENCES dept_inf (ID),
  CONSTRAINT FK_EMP_JOB FOREIGN KEY (JOB_ID) REFERENCES job_inf (ID)
) ENGINE=INNODB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
INSERT  INTO employee_inf(ID,DEPT_ID,JOB_ID,NAME,CARD_ID,ADDRESS,POST_CODE,TEL,PHONE,QQ_NUM,EMAIL,SEX,PARTY,BIRTHDAY,RACE,EDUCATION,SPECIALITY,HOBBY,REMARK,CREATE_DATE) 
VALUES (1,1,8,'爱丽丝','4328011988','广州天河','510000','020-77777777','13902001111','36750066','251425887@qq.com',0,'党员','1980-01-01 00:00:00','满','本科','美声','唱歌','四大天王','2016-03-14 11:35:18'),
(2,2,1,'杰克','22623','43234','42427424','42242','4247242','42424','251425887@qq.com',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-03-14 11:35:18'),
 (3,1,2,'bb','432801197711251038','广州','510000','020-99999999','13907351532','36750064','36750064@qq.com',1,'党员','1977-11-25 00:00:00','汉','本科','计算机','爬山','无','2016-07-14 09:54:52');

#创建表document_inf
CREATE TABLE document_inf (
  ID INT(11) NOT NULL AUTO_INCREMENT,
  TITLE VARCHAR(50) NOT NULL,
  filename VARCHAR(300) NOT NULL,
  filetype VARCHAR(100) NOT NULL,
  filebytes longblob not null,
  REMARK VARCHAR(300) DEFAULT NULL,
  CREATE_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  USER_ID INT(11) DEFAULT NULL,
  PRIMARY KEY (ID),
  KEY FK_DOCUMENT_USER (USER_ID),
  CONSTRAINT FK_DOCUMENT_USER FOREIGN KEY (USER_ID) REFERENCES user_inf (ID)
) ENGINE=INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;



select e.NAME,d.* from employee_inf e left join dept_inf d on e.DEPT_ID=d.ID;

select JOB_ID,j.NAME as job_name from 
(
	select e.*,d.NAME as dept_name from employee_inf e 
	left join dept_inf d on e.DEPT_ID=d.ID) e 
left join job_inf j on e.JOB_ID=j.ID where 1=1 group by  JOB_ID;


select DEPT_ID,e.dept_name from 
(
	select e.*,d.NAME as dept_name from employee_inf e 
	left join dept_inf d on e.DEPT_ID=d.ID) e 
left join job_inf j on e.JOB_ID=j.ID where 1=1 group by  DEPT_ID;


select e.*,from employee_inf e,dept_inf d,job_inf j where e.



select * from(
select e.*,j.NAME as job_name from  (select e.*,d.NAME as dept_name from employee_inf e   
left join dept_inf d on e.DEPT_ID=d.ID ) e left join job_inf j on e.JOB_ID=j.ID  
) t
where 1=1 and t.JOB_ID = 2  limit 0,10



select count(*) from (select e.*,j.NAME as job_name from  (select e.*,d.NAME as dept_name from employee_inf e   left join dept_inf d on e.DEPT_ID=d.ID ) e left join job_inf j on e.JOB_ID=j.ID ) t where 1=1 



如何编写员工多表查询？

 select * from
 (
 select e.*,j.NAME as job_name from
 (select e.*,d.NAME as dept_name  from employee_inf e left join dept_inf d on e.DEPT_ID=d.ID) e
 left join job_inf j on  e.JOB_ID=j.ID
 ) t limit 0,3;

```


## 工具
[GitHub](https://git-scm.com/download)