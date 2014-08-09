
create table usuario (id integer primary key
                  auto_increment,
                nombre varchar(80),
                sueldo float);

create table cliente (id_cliente  integer primary key auto_increment,
                     nombre varchar(80),
                     email varchar(80) );

create table pagos (id_pagos integer primary key auto_increment, id_cliente integer, primer_pago float,
                           segundo_pago  float, total float,
                           foreign key (id_cliente) references  
                            cliente (id_cliente));


create table nomina (id integer , id_nomina integer auto_increment primary key, fecha_pago date, saldo float,
                     constraint foreign key(id) references usuario(id));
