CREATE TABLE `employee_table` (
  `employee_id` int(11) NOT NULL auto_increment,
  `employee_name` varchar(60) NOT NULL,
  `email` varchar(20) not null,
  `address` varchar(45) NOT NULL,
 `contact` int(10) not null,
 `skill` varchar(10) not null,
  PRIMARY KEY  (`employee_id`)
) ;	

desc employee_table;

ALTER TABLE `employee_table`
ADD email varchar(20) AFTER employee_name;

