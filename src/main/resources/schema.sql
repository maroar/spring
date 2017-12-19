DROP TABLE IF EXISTS `prescricoes_medicamentos`;
DROP TABLE IF EXISTS `prescricoes`;
DROP TABLE IF EXISTS `medicamentos`;
DROP TABLE IF EXISTS `medicos`;
DROP TABLE IF EXISTS `pacientes`;

CREATE TABLE `medicamentos` (
    `medicamento_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    `nome` VARCHAR(250) NOT NULL, 
    `created_at` timestamp NOT NULL DEFAULT current_timestamp 
);

CREATE TABLE `medicos` (
    `medico_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    `nome` VARCHAR(250) NOT NULL, 
    `cpf` VARCHAR(50) NOT NULL,
    `nascimento` VARCHAR(50),
    `cro` VARCHAR(50) NOT NULL,
    `created_at` timestamp NOT NULL DEFAULT current_timestamp 
);

CREATE TABLE pacientes (
    `paciente_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    `nome` VARCHAR(250) NOT NULL, 
    `cpf` VARCHAR(50) NOT NULL,
    `nascimento` VARCHAR(50),
    `created_at` timestamp NOT NULL DEFAULT current_timestamp 
);

CREATE TABLE `prescricoes` (
    `prescricao_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `data` VARCHAR(50) NOT NULL,
    `paciente_id` INT NOT NULL,
    `medico_id` INT NOT NULL,
    `created_at` timestamp NOT NULL DEFAULT current_timestamp,
    FOREIGN KEY (`paciente_id`) REFERENCES `pacientes`(`paciente_id`),
    FOREIGN KEY (`medico_id`) REFERENCES `medicos`(`medico_id`)
);

CREATE TABLE `prescricoes_medicamentos` (
  `prescricao_medicamento_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `prescricao_id` INT NOT NULL,
  `medicamento_id` INT NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp,
  FOREIGN KEY (`prescricao_id`) REFERENCES `prescricoes` (`paciente_id`),
  FOREIGN KEY (`medicamento_id`) REFERENCES `medicamentos` (`medicamento_id`)
);
