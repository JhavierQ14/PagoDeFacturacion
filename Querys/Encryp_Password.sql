/* Encriptacion contraseñas*/

use pago_de_facturacion_db;

INSERT INTO `pago_de_facturacion_db`.`user_state` (`User_State_name`) VALUES ('activo');
SELECT * FROM pago_de_facturacion_db.user_state;

insert into pago_de_facturacion_db.user(User_State_id,User_Name,Email,Password,perfil_image) values ('1','admin','admin@gmail.com',md5('admin'),'default');

SELECT * FROM pago_de_facturacion_db.user;

update pago_de_facturacion_db.user set User_State_id = 0, User_Name = '', Email = '@gmail.com', perfil_image = '/image' where id_User = 0;
update pago_de_facturacion_db.user set Password = md5('') where id_User = 0;

update pago_de_facturacion_db.user set User_State_id = 0 where id_User = 0;



