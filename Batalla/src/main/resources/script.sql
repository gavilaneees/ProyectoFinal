CREATE SCHEMA `bproyecto` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `bproyecto`.`pokemon` (
                                       `id` INT NOT NULL AUTO_INCREMENT,
                                       `nombre` VARCHAR(45) NULL,
                                       `nivel` INT NULL,
                                       `tipo1` VARCHAR(45) NULL,
                                       `tipo2` VARCHAR(45) NULL,
                                       PRIMARY KEY (`id`))
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


INSERT INTO `bproyecto`.`pokemon` (`id`, `nombre`, `nivel`, `tipo1`) VALUES ('1', 'Snorunt', '28', 'HIELO');
INSERT INTO `bproyecto`.`pokemon` (`id`, `nombre`, `nivel`, `tipo1`, `tipo2`) VALUES ('2', 'Heatran', '46', 'FUEGO', 'ACERO');
INSERT INTO `bproyecto`.`pokemon` (`id`, `nombre`, `nivel`, `tipo1`, `tipo2`) VALUES ('3', 'Pelipper', '30', 'VOLADOR', 'AGUA');
INSERT INTO `bproyecto`.`pokemon` (`id`, `nombre`, `nivel`, `tipo1`, `tipo2`) VALUES ('4', 'Wingull', '12', 'VOLADOR', 'AGUA');
INSERT INTO `bproyecto`.`pokemon` (`id`, `nombre`, `nivel`, `tipo1`) VALUES ('5', 'Pikachu', '33', 'ELÉCTRICO');

CREATE TABLE `bproyecto`.`entrenadores` (
                                            `id` INT NOT NULL AUTO_INCREMENT,
                                            `nombre` VARCHAR(45) NULL,
                                            PRIMARY KEY (`id`));
ALTER TABLE `bproyecto`.`entrenadores`
    ADD COLUMN `batallas_ganadas` INT NULL AFTER `nombre`,
ADD COLUMN `batallas_perdidas` INT NULL AFTER `batallas_ganadas`;

INSERT INTO `bproyecto`.`entrenadores` (`id`, `nombre`, `batallas_ganadas`, `batallas_perdidas`) VALUES ('1', 'Brock', '0', '0');
INSERT INTO `bproyecto`.`entrenadores` (`id`, `nombre`, `batallas_ganadas`, `batallas_perdidas`) VALUES ('2', 'Ash', '0', '0');
INSERT INTO `bproyecto`.`entrenadores` (`id`, `nombre`, `batallas_ganadas`, `batallas_perdidas`) VALUES ('3', 'Misty', '0', '0');
INSERT INTO `bproyecto`.`entrenadores` (`id`, `nombre`, `batallas_ganadas`, `batallas_perdidas`) VALUES ('4', 'Cynthia', '0', '0');

CREATE TABLE `bproyecto`.`batallas` (
                                        `id` INT NOT NULL AUTO_INCREMENT,
                                        `id_entrenador1` INT NULL,
                                        `id_entrenador2` INT NULL,
                                        `id_pokemon1` INT NULL,
                                        `id_pokemon2` INT NULL,
                                        `ganador` INT NULL,
                                        PRIMARY KEY (`id`));

ALTER TABLE `bproyecto`.`entrenadores`
    ADD COLUMN `pokemon_id` INT NULL AFTER `batallas_perdidas`;

UPDATE `bproyecto`.`entrenadores` SET `pokemon_id` = '1' WHERE (`id` = '1');
UPDATE `bproyecto`.`entrenadores` SET `pokemon_id` = '2' WHERE (`id` = '2');
UPDATE `bproyecto`.`entrenadores` SET `pokemon_id` = '3' WHERE (`id` = '3');
UPDATE `bproyecto`.`entrenadores` SET `pokemon_id` = '4' WHERE (`id` = '4');

