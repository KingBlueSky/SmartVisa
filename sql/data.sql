/*
 create table
 ****************************************************************************************
 */
CREATE TABLE `areas` (
  `id` bigint(20) DEFAULT NULL,
  `area_id` int(10) DEFAULT NULL,
  `name` varchar(765) DEFAULT NULL,
  `code` varchar(765) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `father_id` int(11) DEFAULT NULL,
  `area_code` varchar(765) DEFAULT NULL,
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_by` bigint(20) DEFAULT NULL,
  `create_name` varchar(90) DEFAULT NULL,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_by` bigint(20) DEFAULT NULL,
  `update_name` varchar(90) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8

/*
insert into data
*********************************************************************
*/ 
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('1','1','北京市','110000','1','0','010','2016-06-15 17:35:58','0','','2016-06-15 17:35:58','0','');
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('2','2','北京市','110100','2','1','010','2016-06-15 17:35:58','0','','2016-06-30 16:19:52','0','');
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('3','3','东城区','110101','3','2','','2016-06-15 17:35:58','0','','2016-06-30 16:23:40','0','');
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('4','4','西城区','110102','3','2','','2016-06-15 17:35:58','0','','2016-06-15 17:37:14','0','');
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('5','5','崇文区','110103','3','2','','2016-06-15 17:35:58','0','','2016-06-15 17:37:14','0','');
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('6','6','宣武区','110104','3','2','','2016-06-15 17:35:58','0','','2016-06-15 17:37:14','0','');
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('7','7','朝阳区','110105','3','2','0421','2016-06-15 17:35:58','0','','2016-06-15 17:37:14','0','');
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('8','8','丰台区','110106','3','2','','2016-06-15 17:35:58','0','','2016-09-14 14:05:12','0','');
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('9','9','石景山区','110107','3','2','','2016-06-15 17:35:58','0','','2016-09-14 14:05:12','0','');
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('10','10','海淀区','110108','3','2','','2016-06-15 17:35:58','0','','2016-09-14 14:05:12','0','');
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('11','11','门头沟区','110109','3','2','','2016-06-15 17:35:58','0','','2016-06-15 17:37:14','0','');
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('12','12','房山区','110111','3','2','','2016-06-15 17:35:58','0','','2016-06-15 17:37:14','0','');
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('13','13','通州区','110112','3','2','','2016-06-15 17:35:58','0','','2016-06-15 17:37:14','0','');
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('14','14','顺义区','110113','3','2','','2016-06-15 17:35:58','0','','2016-06-15 17:37:14','0','');
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('15','15','昌平区','110114','3','2','','2016-06-15 17:35:58','0','','2016-06-15 17:37:14','0','');
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('16','16','大兴区','110115','3','2','','2016-06-15 17:35:58','0','','2016-06-15 17:37:14','0','');
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('17','17','平谷县','110226','3','2','','2016-06-15 17:35:58','0','','2016-06-15 17:37:14','0','');
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('18','18','怀柔县','110227','3','2','','2016-06-15 17:35:58','0','','2016-06-15 17:37:14','0','');
insert into `areas` (`id`, `area_id`, `name`, `code`, `level`, `father_id`, `area_code`, `create_at`, `create_by`, `create_name`, `update_at`, `update_by`, `update_name`) values('19','19','密云县','110228','3','2','','2016-06-15 17:35:58','0','','2016-06-15 17:37:14','0','');
