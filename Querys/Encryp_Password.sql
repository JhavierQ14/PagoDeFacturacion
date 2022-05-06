/* Encriptacion contraseñas/*

use pago_de_facturacion_db;

INSERT INTO `pago_de_facturacion_db`.`user_state` (`User_State_name`) VALUES ('activo');
SELECT * FROM pago_de_facturacion_db.user_state;

insert into pago_de_facturacion_db.user(User_State_id,User_Name,Email,Password,perfil_image) values ('1','admin','admin@gmail.com',md5('admin'),'default')

SELECT * FROM pago_de_facturacion_db.user;

update pago_de_facturacion_db.user set User_State_id = 0, User_Name = '', Email = '@gmail.com', perfil_image = '/image' where id_User = 0
update pago_de_facturacion_db.user set Password = md5('') where id_User = 0

update pago_de_facturacion_db.user set User_State_id = 0 where id_User = 0;

/*
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_I_USER`(p_user_state_id int, p_user_name varchar(64), p_email varchar(128), p_password varchar(32), p_perfil_image varchar(128))
BEGIN
	insert into pago_de_facturacion_db.user(User_State_id,User_Name,Email,Password,perfil_image) values (p_user_state_id,p_user_name,p_email,md5(p_password),p_perfil_image);

END

CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_U_USER`(p_user_state_id int, p_user_name varchar(64), p_email varchar(128), pPassword varchar(64), p_perfil_image varchar(128), p_id_user int)
BEGIN
	update pago_de_facturacion_db.user set User_State_id = p_user_state_id, User_Name = p_user_name, Email = p_email, Password = md5(pPassword), perfil_image = p_perfil_image where id_User = p_id_user;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_D_USER`(p_id_user int)
BEGIN
	update pago_de_facturacion_db.user set User_State_id = 3 where id_User = p_id_user;
END


*/


call pago_de_facturacion_db.SP_I_USER(0, '', '@unab.edu.sv', '', '/image');

call pago_de_facturacion_db.SP_U_USER(0, '', '@gmail.com', '', '/image', 1);

call pago_de_facturacion_db.SP_D_USER(0);

