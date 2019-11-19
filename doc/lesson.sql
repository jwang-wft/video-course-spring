use file_demo;
select * from files;

use lesson;
select * from user;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
employee) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


select * from section;
select * from section_lectures;
select * from lecture;
select lectures_id from section_lectures where section_id = 1;
update lecture set source_path = 'default.txt' where id<3 or id=4;

insert into section_lectures values (1, 1);
insert into section_lectures values (1, 2);

drop table post_tags;

/*drop foriegn key bound tables*/
SET FOREIGN_KEY_CHECKS = 0;
SET UNIQUE_CHECKS = 0;
TRUNCATE TABLE topic;
TRUNCATE TABLE section;
TRUNCATE TABLE lecture;
drop table `topic`;
drop table `lecture`;
drop table `section`;

SET FOREIGN_KEY_CHECKS = 1;
SET UNIQUE_CHECKS = 1;

CREATE TABLE `lecture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `zip_path` varchar(255) DEFAULT NULL,
  `sequence` int(11) NOT NULL,
  `source_path` varchar(255) DEFAULT NULL,
  `video_path` varchar(255) DEFAULT NULL,
  `section_id` bigint(20) NOT NULL,
  `section` tinyblob,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9fwr8i3ihpgld6ymx6kaojgho` (`title`),
  KEY `FK568elaju5okd8k0hukt18mtk7` (`section_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



ALTER TABLE lecture DROP COLUMN sequence;

insert into lecture values (null, current_date(), current_date(), "John", "Eclipse开发环境安装", "assets/test.zip", 1, "assets/test.txt", "assets/Eclipse.mp4", 2);
insert into lecture values (null, current_date(), current_date(), "John", "Eclipse开发环境安装", "assets/test.zip", 1, "assets/test.txt", "assets/Eclipse.mp4", 1);
insert into lecture values (null, current_date(), current_date(), "John", "AngularJS动画字符显示", "assets/test.zip", 2, "assets/test.txt", "assets/Animation.mp4", 1);
insert into lecture values (null, current_date(), current_date(), "John", "Eclipse开发环境安装", "assets/test.zip", 1, "assets/test.txt", "assets/Eclipse.mp4", 4);
insert into lecture values (null, current_date(), current_date(), "John", "Spring Boot数据库一对多方案", "assets/test.zip", 2, "assets/test.txt", "assets/Animation.mp4", 4);
insert into lecture values (null, current_date(), current_date(), "John", "Spring Boot数据库多对多方案", "assets/test.zip", 3, "assets/test.txt", "assets/Animation.mp4", 4);
insert into lecture values (null, current_date(), current_date(), "John", "Vue语言第一讲", "vue.js", 1, "vue.txt", "vueStart.mp4", 1, "vue.png");
select * from lecture;

update lecture set poster = 'eclipse.jpg' where id<3;

CREATE TABLE `section` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `zip_path` varchar(255) DEFAULT NULL,
  `sequence` int(11) NOT NULL,
  `topic_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_l8sumqytf7g759uc0mweoilv4` (`title`),
  KEY `FK1luo5llot7ehfv52iucchaadr` (`topic_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


insert into section values (null, current_date(), current_date(), "John Q. Wang", "AngularJS动画字符显示", "assets/test.zip", 2, 1);
insert into section values (null, current_date(), current_date(), "John Q. Wang", "Eclipse开发环境安装", "assets/test.zip", 1, 1);
insert into section values (null, current_date(), current_date(), "John Q. Wang", "Visual Studio Code编辑软件安装", "assets/test.zip", 3, 1);
insert into section values (null, current_date(), current_date(), "John Q. Wang", "Spring Boot与JPA相关", "assets/test.zip", 4, 1);
select * from section;
update section set zip_path='eclipse-jee-oxygen-M7-win32-x86_64.zip' where id<5;
update section set zip_path='test.zip' where id=1;

CREATE TABLE `topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `zip_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_c5viuo4hbs2v5lqy4ns4jlb6x` (`title`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


insert into topic values (null, current_date(), current_date(), "John Q. Wang", "免费课程",  "assets/test.zip");
insert into topic values (null, current_date(), current_date(), "John Q. Wang", "AngularJS详解",  "assets/test.zip");
insert into topic values (null, current_date(), current_date(), "John Q. Wang", "AngularJS完整网络应用软件制作",  "assets/test.zip");
insert into topic values (null, current_date(), current_date(), "John Q. Wang", "Spring Boot完整网络应用软件制作",  "assets/test.zip");
select * from topic;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(50) DEFAULT NULL,
  `LAST_NAME` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert into employee values (null, "John", "Wang", "wangqianjiang@live.com");
insert into employee values (null, "Ailian", "Wang", "ailian.wang@hotmail.com");
insert into employee values (null, "Charles", "Wang", "wangchar@gmail.com");
insert into employee values (null, "Weiping", "Xing", "wxing@live.com");
insert into employee values (null, "David", "Pang", "david@hotmail.com");

select * from employee;

CREATE TABLE `post` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert into post values (null, "Created by Test4@gmail.com", "5c29657fcd61321f9073b9eb", "image path", "Title-1");
insert into post values (null, "Created by Test4@gmail.com", "5c29657fcd61321f9073b9eb", "image path", "Title-2");
insert into post values (null, "Created by Test5@gmail.com", "5c29657fcd61321f9073b9eb", "image path", "Title-3");
insert into post values (null, "Created by Test5@gmail.com", "5c29657fcd61321f9073b9eb", "image path", "Title-4"); 
insert into post values (null, "Created by Test5@gmail.com", "5c29657fcd61321f9073b9eb", "image path", "Title-11");

select * from post;

drop table `auth_data`;
CREATE TABLE `auth_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
