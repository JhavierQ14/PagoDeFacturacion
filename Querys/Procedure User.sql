
/* PROCEDIMINETOS ALMACENADOS DE USER/*

use pago_de_facturacion_db;

/*CREATE USER*/
CREATE PROCEDURE SP_C_USER(p_user_state_id int, p_user_name varchar(64), p_email varchar(128), p_password varchar(32), p_perfil_image varchar(128))
	insert into pago_de_facturacion_db.user(User_State_id,User_Name,Email,Password,perfil_image) values (p_user_state_id,p_user_name,p_email,md5(p_password),p_perfil_image);

/*READ USER*/
CREATE PROCEDURE SP_R_USER()
	SELECT * FROM user; 

/*UPDATE USER*/
CREATE PROCEDURE SP_U_USER(p_user_state_id int, p_user_name varchar(64), p_email varchar(128), pPassword varchar(64), p_perfil_image varchar(128), p_id_user int)
	update pago_de_facturacion_db.user set User_State_id = p_user_state_id, User_Name = p_user_name, Email = p_email, Password = md5(pPassword), perfil_image = p_perfil_image where id_User = p_id_user;

/*DELETE LOGIC USER*/
CREATE PROCEDURE SP_D_USER(p_id_user int)
	update pago_de_facturacion_db.user set User_State_id = 3 where id_User = p_id_user;

/*********************************************************************************************************************************************/

/* VALIDATION USER*/
CREATE PROCEDURE SP_VALIDATION_USER(PUsername varchar(64), PEmail varchar(64), Ppass varchar(32))
	Select *from  user where (User_Name =PUsername|| Email= PEmail)  && Password = Ppass;






call pago_de_facturacion_db.SP_I_USER(0, '', '@unab.edu.sv', '', '/image');

call pago_de_facturacion_db.SP_U_USER(0, '', '@gmail.com', '', '/image', 1);

call pago_de_facturacion_db.SP_D_USER(0);
