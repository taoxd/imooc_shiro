# imooc_shiro
shiro学习

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


INSERT INTO `test`.`users` (`id`, `username`, `password`) VALUES ('1', 'Mark', '283538989cef48f3d7d8a1c1bdf2008f');


CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `role_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


INSERT INTO `test`.`user_roles` (`id`, `username`, `role_name`) VALUES ('1', 'Mark', 'admin');
INSERT INTO `test`.`user_roles` (`id`, `username`, `role_name`) VALUES ('2', 'Mark', 'user');
