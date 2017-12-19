DROP TABLE IF EXISTS `medicamentos`;
CREATE TABLE `medicamentos` (
  `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
  `nome` VARCHAR(250) NOT NULL, 
  `created_at` timestamp NOT NULL DEFAULT current_timestamp 
);

DROP TABLE IF EXISTS `medicos`;
CREATE TABLE `medicos` (
  `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
  `nome` VARCHAR(250) NOT NULL, 
  `cpf` VARCHAR(50) NOT NULL,
  `nascimento` VARCHAR(50),
  `cro` VARCHAR(50) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp 
);
