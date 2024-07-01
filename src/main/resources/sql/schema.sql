CREATE TABLE `users`
(
    `id`       INT NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(256) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `email`    VARCHAR(256) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `password` VARCHAR(256) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `role`     VARCHAR(255) NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
    PRIMARY KEY (`id`) USING BTREE
);

CREATE TABLE `income_categories`
(
    `id`          INT(10) NOT NULL AUTO_INCREMENT,
    `name`        VARCHAR(256) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `description` VARCHAR(256) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    PRIMARY KEY (`id`) USING BTREE
);

CREATE TABLE `expense_categories`
(
    `id`          INT(10) NOT NULL AUTO_INCREMENT,
    `name`        VARCHAR(256) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `description` VARCHAR(256) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    PRIMARY KEY (`id`) USING BTREE
);

CREATE TABLE `incomes`
(
    `id`          INT(10) NOT NULL AUTO_INCREMENT,
    `value`       DECIMAL(10, 2) NOT NULL DEFAULT '0.00',
    `description` VARCHAR(256) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `date`        DATE NULL DEFAULT NULL,
    `category_id` INT(10) NULL DEFAULT NULL,
    `user_id`     INT(10) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX         `category_id` (`category_id`) USING BTREE,
    INDEX         `FK_incomes_users` (`user_id`) USING BTREE,
    CONSTRAINT `FK_incomes_income_categories` FOREIGN KEY (`category_id`) REFERENCES `income_categories` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT `FK_incomes_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE `expenses`
(
    `id`          INT(10) NOT NULL AUTO_INCREMENT,
    `value`       DECIMAL(10, 2) NULL DEFAULT '0.00',
    `description` VARCHAR(256) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `date`        DATE NULL DEFAULT NULL,
    `category_id` INT(10) NULL DEFAULT NULL,
    `user_id`     INT(10) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX         `category_id` (`category_id`) USING BTREE,
    INDEX         `user_id` (`user_id`) USING BTREE,
    CONSTRAINT `FK_expenses_expense_categories` FOREIGN KEY (`category_id`) REFERENCES `expense_categories` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT `FK_expenses_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
);
