/* Encriptacion contraseñas*/

create database pago_de_facturacion_db;
use pago_de_facturacion_db;
ALTER TABLE user
ADD FOREIGN KEY (rol_id) REFERENCES rol(id_rol);

INSERT INTO `pago_de_facturacion_db`.`user_state` (`User_State_name`) VALUES ('activo');
SELECT * FROM pago_de_facturacion_db.user_state;

insert into pago_de_facturacion_db.user(User_State_id,User_Name,Email,Password,perfil_image) values ('1','admin','admin@gmail.com',md5('admin'),'default');

SELECT * FROM pago_de_facturacion_db.user;

update pago_de_facturacion_db.user set User_State_id = 0, User_Name = '', Email = '@gmail.com', perfil_image = '/image' where id_User = 0;
update pago_de_facturacion_db.user set Password = md5('') where id_User = 0;

update pago_de_facturacion_db.user set User_State_id = 0 where id_User = 0;


select user.User_Name, user.Email, user.Password, user_state.User_State_name,rol.rol_name from user
	inner join user_state on user.User_State_id = user_state.id_User_State
    inner join user_rol on user_rol.user_id = user.id_User
    inner join rol on /*rol.id_Rol*/user_rol.rol_id = /*user_rol.rol_id*/rol.id_Rol;

select user.id_User, user.User_Name, user.Email, employee.idEmployee, employee.Employee_name, employee.Employee_Lastname from employee
inner join user on employee.user_id = user.id_User where user.User_Name = 'admin' || user.Email = 'admin@gmail.com';
    


