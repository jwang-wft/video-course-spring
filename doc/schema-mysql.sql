use lesson;
select * from users;
select * from authorities;
select * from user_roles;
ALTER USER 'root'@'localhost'
  IDENTIFIED BY 'root'; 
  
select * from class_user;
select * from class_user_roles;

DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

CREATE TABLE `class_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_non_expired` bit(1) NOT NULL,
  `account_non_locked` bit(1) NOT NULL,
  `credentials_non_expired` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ljiwbmohfs9rbvheg0nah3sa0` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `class_user_roles` (
  `class_user_id` bigint(20) NOT NULL,
  `roles` varchar(255) DEFAULT NULL,
  KEY `FK2078vidyfrlsq1j4twogk1nf0` (`class_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);

 insert into users(username, password, enabled)values('javainuse','javainuse',true);
 insert into authorities(username,authority)values('javainuse','ROLE_ADMIN');
 
  insert into users(username, password, enabled)values('employee','employee',true);
 insert into authorities(username,authority)values('javainuse','ROLE_USER');
 
 