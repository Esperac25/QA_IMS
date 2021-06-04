DROP DATABASE IF EXISTS `ims-test`;
CREATE SCHEMA IF NOT EXISTS `ims-test`;
USE `ims-test` ;
DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `ims-test`.`orders` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`customer_id` int NOT NULL,
	FOREIGN KEY (`customer_id`) REFERENCES customers(`id`),
	PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `ims-test`.`order_items`(
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`orders_id` INT(11) NOT NULL,
	`items_id` INT(11) NOT NULl,
	FOREIGN KEY (`orders_id`) REFERENCES orders(`id`),
	FOREIGN KEY (`items_id`) REFERENCES items(`id`),
	PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims-test`.`items`(
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(40) DEFAUlT NULL,
	`cost` INT DEFAULT NULL,
	PRIMARY KEY (`id`)
);