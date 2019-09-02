CREATE TABLE `aircraft` (
 `aircraft_id` int(20) NOT NULL AUTO_INCREMENT,
 `aircraft_type` varchar(45) NOT NULL,
 `aircraft_size` varchar(45) NOT NULL,
 `aircraft_creation_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 `aircraft_update_timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
 `aircraft_status` varchar(2) DEFAULT NULL,
 `aircraft_position` int(20) NOT NULL,
 PRIMARY KEY (`aircraft_id`),
 UNIQUE KEY `aircraft_id_UNIQUE` (`aircraft_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8
