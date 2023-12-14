DROP DATABASE IF EXISTS textBoard01;
CREATE DATABASE `textBoard01`;
USE textBoard01;

CREATE TABLE article (
	id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(100) NOT NULL,
	content TEXT NOT NULL,
	regDate DATETIME NOT NULL,
	memberId int UNSIGNED
);

CREATE TABLE `member` (
	id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	userId VARCHAR(100) NOT NULL UNIQUE,
	`password` TEXT NOT NULL,
	regDate DATETIME NOT NULL
);

INSERT INTO article
SET title = '제목1',
content = '내용1',
regDate = NOW(),
memberId = 1;

INSERT INTO article
SET title = '제목2',
content = '내용2',
regDate = NOW(),
memberId = 2;

INSERT INTO `member`
SET userId = 'user1',
`password` = '1234',
regDate = NOW();

INSERT INTO `member`
SET userId = 'user2',
`password` = '1234',
regDate = NOW();

INSERT INTO `member`
SET userId = 'user3',
`password` = '1234',
regDate = NOW();