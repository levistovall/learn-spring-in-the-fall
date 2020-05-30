CREATE TABLE `users` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `first_name` varchar(255),
  `last_name` varchar(255),
  `user_name` varchar(255),
  `created_at` timestamp
);

CREATE TABLE `goals` (
  `id` int PRIMARY KEY,
  `owner_id` int,
  `title` varchar(255),
  `description` varchar(255),
  `status` ENUM ('not_started', 'in_progress', 'met'),
  `goal_type` varchar(255),
  `created_at` timestamp,
  `last_updated` timestamp
);

CREATE TABLE `goal_hierarchy` (
  `parent_id` int,
  `child_id` int,
  `created_at` timestamp,
  `last_updated` timestamp,
  PRIMARY KEY (`parent_id`, `child_id`)
);

CREATE TABLE `goal_types` (
  `type_name` varchar(255) PRIMARY KEY,
  `created_at` timestamp,
  `last_updated` timestamp
);

CREATE TABLE `goal_hierarchy_rules` (
  `parent_type_name` varchar(255),
  `child_type_name` varchar(255),
  PRIMARY KEY (`parent_type_name`, `child_type_name`)
);

CREATE TABLE `user_defined_goal_attrs` (
  `user_id` int,
  `attr_name` varchar(255),
  `content_type` ENUM ('plain_text', 'time'),
  PRIMARY KEY (`attr_name`, `content_type`)
);

CREATE TABLE `user_defined_goal_attr_types` (
  `attr_name` varchar(255),
  `goal_type` varchar(255),
  PRIMARY KEY (`attr_name`, `goal_type`)
);

CREATE TABLE `goal_spectators` (
  `goal_id` int,
  `user_id` int,
  PRIMARY KEY (`goal_id`, `user_id`)
);

CREATE TABLE `goal_collaborators` (
  `goal_id` int,
  `user_id` int,
  PRIMARY KEY (`goal_id`, `user_id`)
);

ALTER TABLE `goals` ADD FOREIGN KEY (`owner_id`) REFERENCES `users` (`id`);

ALTER TABLE `goals` ADD FOREIGN KEY (`goal_type`) REFERENCES `goal_types` (`type_name`);

ALTER TABLE `goal_hierarchy` ADD FOREIGN KEY (`parent_id`) REFERENCES `goals` (`id`);

ALTER TABLE `goal_hierarchy` ADD FOREIGN KEY (`child_id`) REFERENCES `goals` (`id`);

ALTER TABLE `goal_hierarchy_rules` ADD FOREIGN KEY (`parent_type_name`) REFERENCES `goal_types` (`type_name`);

ALTER TABLE `goal_hierarchy_rules` ADD FOREIGN KEY (`child_type_name`) REFERENCES `goal_types` (`type_name`);

ALTER TABLE `user_defined_goal_attrs` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `goal_spectators` ADD FOREIGN KEY (`goal_id`) REFERENCES `goals` (`id`);

ALTER TABLE `goal_spectators` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `goal_collaborators` ADD FOREIGN KEY (`goal_id`) REFERENCES `goals` (`id`);

ALTER TABLE `goal_collaborators` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `user_defined_goal_attr_types` ADD FOREIGN KEY (`attr_name`) REFERENCES `user_defined_goal_attrs` (`attr_name`);

ALTER TABLE `user_defined_goal_attr_types` ADD FOREIGN KEY (`goal_type`) REFERENCES `goal_types` (`type_name`);

ALTER TABLE `goal_types`
ADD CONSTRAINT announcement_validUntil_check
CHECK (
    CASE
        WHEN extends IS NOT NULL
        THEN
            CASE
                WHEN extends in (select gt.type_name from goal_types gt where gt.type_name <> type_name
                THEN 1
                ELSE 0
            END
        ELSE 1
    END = 1
);

