DROP TABLE IF EXISTS `medicamentos`;
CREATE TABLE `medicamentos` (
  `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
  `nome` VARCHAR(250) NOT NULL, 
  `created_at` timestamp NOT NULL DEFAULT current_timestamp 
);
