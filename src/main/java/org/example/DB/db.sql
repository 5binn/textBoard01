DROP DATABASE IF EXISTS `textBoard`;
CREATE DATABASE `textBoard`;

USE `textBoard`;

CREATE TABLE article (
id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT ,
title VARCHAR(100) NOT NULL ,
content VARCHAR(100) NOT NULL ,
regDate DATETIME NOT NULL ,
memberId int UNSIGNED NOT NULL
);

CREATE TABLE `member` (
id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT ,
userId VARCHAR(100) NOT NULL UNIQUE ,
`password` VARCHAR(100) NOT NULL ,
regDate DATETIME NOT NULL
);

INSERT INTO `member`
SET regDate = now(),
`userId` = 'user1',
`password` = '1234';

INSERT INTO `member`
SET regDate = now(),
`userId` = 'user2',
`password` = '1234';

INSERT INTO `member`
SET regDate = now(),
`userId` = 'user3',
`password` = '1234';

INSERT INTO `article`
SET regDate = now(),
`title` = '제목1',
`content` = '내용1',
memberId = 1;

INSERT INTO `article`
SET regDate = now(),
`title` = '제목2',
`content` = '내용2',
memberId = 2;