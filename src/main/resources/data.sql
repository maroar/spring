INSERT INTO `medicamentos` (`medicamento_id`,`nome`, `created_at`) VALUES (NULL, "dramim", NULL);
INSERT INTO `medicamentos` (`medicamento_id`,`nome`, `created_at`) VALUES (NULL, "novalgina", NULL);
INSERT INTO `medicamentos` (`medicamento_id`,`nome`, `created_at`) VALUES (NULL, "benegripe", NULL);

INSERT INTO `medicos` (`medico_id`,`nome`,`cpf`,`nascimento`, `cro`, `created_at`) VALUES (NULL, "Fran", "011.667.556.91","01/07/2003", "123", NULL);
INSERT INTO `medicos` (`medico_id`,`nome`,`cpf`,`nascimento`, `cro`, `created_at`) VALUES (NULL, "Mateus", "025.617.556.91","12/03/1994", "456", NULL);
INSERT INTO `medicos` (`medico_id`,`nome`,`cpf`,`nascimento`, `cro`, `created_at`) VALUES (NULL, "Isabela", "094.123.356.91","02/06/1955", "789", NULL);
INSERT INTO `medicos` (`medico_id`,`nome`,`cpf`,`nascimento`, `cro`, `created_at`) VALUES (NULL, "Marco", "074.567.765.91","08/12/2006", "012", NULL);

INSERT INTO `pacientes` (`paciente_id`,`nome`,`cpf`,`nascimento`, `created_at`) VALUES (NULL, "Sandy", "094.667.556.91","01/07/2001", NULL);
INSERT INTO `pacientes` (`paciente_id`,`nome`,`cpf`,`nascimento`, `created_at`) VALUES (NULL, "Junior", "095.617.556.91","12/03/1991", NULL);
INSERT INTO `pacientes` (`paciente_id`,`nome`,`cpf`,`nascimento`, `created_at`) VALUES (NULL, "Zezé", "094.667.356.91","02/06/1956", NULL);
INSERT INTO `pacientes` (`paciente_id`,`nome`,`cpf`,`nascimento`, `created_at`) VALUES (NULL, "Camargo", "074.567.556.91","08/12/2002", NULL);

INSERT INTO `prescricoes` (`prescricao_id`,`data`, `paciente_id`, `medico_id`, `created_at`) VALUES (NULL, "01/01/2018", 1, 1, NULL);

INSERT INTO `prescricoes_medicamentos` (`prescricao_medicamento_id`,`prescricao_id`, `medicamento_id`, `created_at`) VALUES (NULL, 1, 1, NULL);
