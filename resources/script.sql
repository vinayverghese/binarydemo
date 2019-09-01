CREATE TABLE `binary`.`aircraft` (
  `aircraft_id` INT(20) NOT NULL AUTO_INCREMENT,
  `aircraft_type` VARCHAR(45) NOT NULL,
  `aircraft_size` VARCHAR(2) NOT NULL,
  `aircraft_timestamp` TIMESTAMP NOT NULL,
  `aircraft_status` VARCHAR(2) NULL,
  `aircraft_position` INT(20) NULL,
  PRIMARY KEY (`aircraft_id`),
  UNIQUE INDEX `aircraft_id_UNIQUE` (`aircraft_id` ASC));
