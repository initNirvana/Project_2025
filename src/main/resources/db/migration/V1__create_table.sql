CREATE TABLE `like`(
    `id_user` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `id_post` BIGINT NOT NULL,
    `created_at` DATETIME NOT NULL
);

CREATE TABLE `user_profile`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `img_url` VARCHAR(255) NOT NULL,
    `updated_at` DATETIME NOT NULL
);

CREATE TABLE `user`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nickname` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `create_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL
);

CREATE TABLE `follow`(
    `id_from` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `id_to` BIGINT NOT NULL,
    `created_at` DATETIME NOT NULL
);

CREATE TABLE `post`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id` BIGINT NOT NULL,
    `contents` TEXT NOT NULL,
    `likes` BIGINT NOT NULL,
    `is_deleted` BOOLEAN NOT NULL,
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL
);

CREATE TABLE `post_image`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `post_id` BIGINT NOT NULL,
    `img_name` VARCHAR(255) NOT NULL,
    `img_path` BIGINT NOT NULL,
    `is_deleted` BOOLEAN NOT NULL,
    `created_at` DATETIME NOT NULL,
    `deleted_at` DATETIME NOT NULL
);

CREATE TABLE `notification`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(255) NOT NULL,
    `from_id` BIGINT NOT NULL,
    `to_id` BIGINT NOT NULL,
    `target_id` BIGINT NOT NULL,
    `is_read` BOOLEAN NOT NULL,
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL
);

CREATE TABLE `comment`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id` BIGINT NOT NULL,
    `parents_post_id` BIGINT NOT NULL,
    `parents_comment_id` BIGINT NOT NULL,
    `likes` BIGINT NOT NULL,
    `contents` TEXT NOT NULL,
    `is_deleted` BOOLEAN NOT NULL,
    `post_id` BIGINT NOT NULL,
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL
);