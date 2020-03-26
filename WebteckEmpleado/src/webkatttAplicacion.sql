
create database wektapp;
use wektapp;

create table plataformas(
id int not null primary key auto_increment,
nombre varchar (100)); 


create table generos(
id  int not null primary key auto_increment,
nombre varchar(100));


create table productos(
id int not null primary key auto_increment,
titulo varchar(100),
anyo int,
precio int,
stock int ,
foto varchar(200),
descripcion varchar(655),
idGenero int,
idPlataforma int,
foreign key (idGenero) 
	references generos(id)
    on update cascade
	on delete cascade,
foreign key (idPlataforma) 
	references plataformas(id)
	on update cascade
	on delete cascade);

create table ventas(
fecha date,
idProducto int,
emailUsuario varchar(100),
foreign key (idProducto) 
	references productos(id)
	on update cascade
	on delete cascade,
foreign key (emailUsuario) 
	references usuaris(emailUsuario)
	on update cascade
	on delete cascade);

create table usuaris(
emailUsuario varchar(100) not null primary key,
nombre varchar(100) ,
usuario varchar(100) not null,
`password` varchar(100) not null,
foto varchar(100),
administrador varchar(10),
pantalla varchar(30) default 'D',
activado varchar(50) default 'N');


create table empleados(
email varchar(100) not null primary key,
nombre varchar(100) ,
usuario varchar(100) not null,
`password` varchar(100) not null,
foto varchar(100));

create table claveregistro(
codigo int not null,
emailUsuario varchar(100) not null,
 primary key(emailUsuario),
  foreign key (emailUsuario) references usuaris(emailUsuario)
  on delete cascade);  



create table valoraciones(
id int not null primary key auto_increment,
idProducto int,
emailUsuario varchar(100),
valoraciones int,
comentarios varchar(200),
foreign key (idProducto) 
	references productos(id)
	on update cascade
	on delete cascade,
foreign key (emailUsuario) 
	references usuaris(emailUsuario)
	on update cascade
	on delete cascade);



insert into usuaris (emailUsuario,nombre,usuario,`password`,foto,administrador) values (  'pepe@gmail.com','pepe' ,'pepe1234','1234','usuario.jpg','');
insert into empleados (email,nombre,usuario,`password`,foto) values ('pepe@gmail.com','cristian' ,'cristian','1234','usuario.jpg');


insert into plataformas (nombre) values ('ordenadores');
insert into plataformas (nombre) values ('moviles');
insert into plataformas (nombre) values ('portatiles');
insert into plataformas (nombre) values ('consolas');


insert into generos (nombre) values ('Apple');
insert into generos (nombre) values ('Samsung');
insert into generos (nombre) values ('Xaomi');
insert into generos (nombre) values ('Playstation');
insert into generos (nombre) values ('Xbox');
insert into generos (nombre) values ('Hp');
insert into generos (nombre) values ('Acer');
insert into generos (nombre) values ('Lenovo');
insert into generos (nombre) values ('Huawei');
insert into generos (nombre) values ('Asus');




insert into productos (titulo,precio,anyo,foto,stock,descripcion,idGenero,idPlataforma) values ('Phone 11 pro MAX',1200,2019,'Phone11proMax.jpeg',30,' Ficha técnica de: iPhone 11 Pro Max 64 Gb - Gris Espacial - Libre

    Color : Gris Espacial
    Operador : Libre
    Dimensión de la pantalla (pulgadas) : 6,5
    Almacenamiento (Gb) : 64
    Modelo : iPhone 11 Pro Max
    Doble SIM : No
    Memoria RAM (Gb) : 4
    Megapíxeles : 12
    Sistema operativo : iOS
    Cobertura : 4G
    Fecha de lanzamiento : Septiembre 2019
    Puerto SD : No
    Año de lanzamiento : 2019
    eSIM : Si
    Abatible : No
    Marca : Apple
    Peso (g.) : 226 ',1,2);
insert into productos (titulo,precio,anyo,foto,stock,descripcion,idGenero,idPlataforma) values ('Samsung s20',1300,2020 ,'s20.jpeg',10,'General
Estado:
    Nuevo
Gama modelo:
    Galaxy S
Procesador:
Tipo de procesador:
    Octa Core
Características del procesador:
    Exynos 990
Tecnología:
Sistema Operativo:
    Android
Versión sistema operativo:
    10.0
Pantalla principal:
    Dynamic AMOLED
Tamaño de pantalla:
    17.02 cm / 6,7 "
Resolución cámara frontal:
    10 MP
Características cámara frontal:
    F2.2
Características cámara trasera:
    Cuádruple cámara trasera: 12 MP + 64 MP + 12 MP + VGA TOF
Memoria externa:
    Sí
    MicroSD:
    1 TB
Memoria interna:
    128 GB
Memoria RAM:
    12 GB
Capacidad de batería:
    4500 mA/h
Garantía:
    2 años',2,1);
insert into productos (titulo,anyo,precio,foto,stock,descripcion,idGenero,idPlataforma) values ('Playstatio 4 pro',2018 ,220,'playstation4pro.jpeg',25,'
Tipo:
    Consola
Modelo de consola:
    PRO 1TB
Mandos incluidos:
    mando inalámbrico Dualshock®4 rediseñado
Capacidad memoria:
    1 TB
Conexiones:
    USB
Color:
    Negro
Contenido:
    Sistema PlayStation 4 PRO de 1TB,mando inalámbrico... ',4,4);
insert into productos (titulo,precio,anyo,foto,descripcion,idGenero,idPlataforma) values ('Playstation 4 slim',200,2019 ,'playstation4slim.jpeg','
Tipo:
    Consola
Modelo de consola:
    Slim 1TB
Mandos incluidos:
    mando inalámbrico Dualshock®4 rediseñado
Capacidad memoria:
    1 TB
Conexiones:
    USB
Color:
    Negro
Contenido:
    Sistema PlayStation 4 Slim,Nuevo mando inalámbrico... ',4,4);
insert into productos (titulo,precio,anyo,stock,foto,descripcion,idGenero,idPlataforma) values ('Xbox one X',385,2018,100,'xboxoneX.jpeg','
Modelo de consola:
    Xbox One X
Tamaño memoria RAM:
    1 TB
Mandos incluidos:
    1
Juegos incluidos:
    1
Color:
    Negro
Peso:
    5 kg
Anchura:
    43 cm ',5,4);
insert into productos (titulo,precio,anyo,stock,foto,descripcion,idGenero,idPlataforma) values ('Xbox one slim',190,2019,12,'xboxone.jpeg','
Tipo:
    Consola Xbox one Slim
Mandos incluidos:
    1
Wi-Fi:
    Sí
Bluetooth:
    Sí
Juegos incluidos:
    1
Color:
    Blanco
Peso:
    5 kg ',5,4);
insert into productos (titulo,precio,anyo,stock,foto,descripcion,idGenero,idPlataforma) values ('Lenovo Legion Y540',800,2019 ,58,'lenovoLegion.jpeg','Procesador
    Intel Core i5-9300H de cuádruple núcleo a 2,4GHz y Turbo Boost de hasta 4,1GHz
Memoria total
    RAM de 8GB DDR4 a 2.666MHz
Unidad de disco duro
    Disco mecánico de 1TB a 7200 rpm
Tipo de pantalla
    Pantalla LED FHD,resolución 1920x1080 de 300 nits
Tarjeta gráfica
    NVIDIA GTX1660 6 GB GDDR6 192
Garantía
    2 año, depósito o con transporte
Unidad de disco duro
    Disco sólido de 256GB SSD NVMe
Teclado
    Teclado retroiluminado negro: español
Cámara
    Cámara HD de 720p con matriz de micrófonos
Batería
    Batería interna de 3 celdas de polímero de litio
Red inalámbrica
    Inalámbrico,Bluetooth 4.1',8,3);

insert into productos (titulo,precio,anyo,stock,foto,descripcion,idGenero,idPlataforma) values ('Acer Predator Helios 300',980,2019,43,'acerPredactor.jpeg','    Procesador Intel Core Coffeelake refresh i7-9750H+HM370
    Memoria 8 GB DDR4 2666MHz Memory + 8 GB DDR4 2666MHz Memory
    Almacenamiento 1024GB PCIe NVMe SSD
    Unidad óptica NO
    Display 15.6" FHD IPS slim bezel LCD 16 : 9 FHD IPS (1920 x 1080) 120Hz
    Controlador gráfico NVIDIA® GeForce RTX? 2060 6G-GDDR6 (2C*256*16*6)
    Conectividad
        802.11AX+BT M.2 Killer
        Bluetooth® 5.0
    Batería 59Wh Li-ion battery
    Conexiones
        2 x USB 3.1 Gen 1 + USB Type-C + USB 3.1 Gen 2 with power-off charging
        1 x HDMI
        1 x Displayport
        1 x RJ-45
    Sistema operativo Boot-up Linux
    Peso: 2,4Kg',7,3);
insert into productos (titulo,precio,anyo,stock,foto,descripcion,idGenero,idPlataforma) values ('HP Envy TE01-0002ns',850,2019,34,'hpEnvy.jpeg','Procesador
    Intel Core i7 9700
Velocidad del procesador
    3 GHz
Memoria Caché
    12 MB
Sistema operativo
    Windows 10 Home
Memoria Ram
    32 GB DDR4
Disco duro
    Tipo: SSD PCIe NVMe Capacidad: 1 TB
Tipo de tarjeta
    NVIDIA
Procesador gráfico
    GeForce GTX 1650
Tarjeta gráfica dedicada
    4Gb
Tipo unidad óptica
    No tiene
Sonido
    Sonido 5,1 Surround
Tipos de Lan inalámbrica
    Wi-Fi Realtek 802.11b/g/n/a/ac (2 x 2)
Bluetooth
    5.0
Peso
    5,96 kg',6,1);
insert into productos (titulo,precio,anyo,stock,foto,descripcion,idGenero,idPlataforma) values ('ASUS ROG Strix GL10CS-SP013T',760,2019 ,32,'asusROG.jp','Procesador
    Intel Core i7 8700
Velocidad del procesador
    3,2 GHz
Velocidad máxima del procesador: Hasta
    4,6GHz
Memoria Caché
    12 MB
Tipo de nivel
    6
Sistema operativo
    Windows 10 Home
Memoria Ram
    16 GB DDR4
Disco duro
    Tipo: SSD Capacidad: 256 GB
    Tipo: HDD Capacidad: 1 TB
Tipo de tarjeta
    Nvidia
Procesador gráfico
    GeForce GTX 1060
Tarjeta gráfica dedicada
    6Gb
Peso
    8 kg',10,1);
insert into productos (titulo,precio,anyo,stock,foto,descripcion,idGenero,idPlataforma) values ('Xaomi Laptop Air 13,3',799,2019 ,4,'milaptopAir.jpeg','Procesador i5 / 8 GB.
Procesador Intel®Core™i5 de 8ª generación.
Tarjeta gráfica NVidia dedicada GeForce® MX150.
GDDR5 de VRAM de 2 GB.
Permite identificación con huella dactilar.
8 GB DDR4.
256 GB PCIe SSD.
Ranura disponible para expansión de tarjeta SSD.
Gris oscuro.',3,3);
insert into productos (titulo,precio,anyo,stock,foto,descripcion,idGenero,idPlataforma) values ('Xaomi Black Shark 2 Pro',870,2019 ,20,'xaomiBlack Shark.jpeg','Un vistazo rápido a 6 características de Pro-Gaming
Dominación del juego Qualcomm® Snapdragon ™ 855+
Almacenamiento UFS 3.0

Juegos más rápidos y fluidos con velocidades de transferencia máximas
Refrigeración líquida 3.0+
La tecnología de enfriamiento por contacto directo más efectiva
Toque maestro

Pantalla sensible a la presión para un control personalizado
Precisión de grado deportivo

Precisión táctil de 0.3 mm para juegos profesionales
DC Dimming 2.0
Pantalla AMOLED premium con protección ocular avanzada
Metal esmerilado y vidrio. Impresionante RGB
Diseño característico del tiburón negro',3,2);

insert into valoraciones (idProducto,emailUsuario,valoraciones,comentarios) values (1,'pepe@gmail.com',8,'Buen producto');
insert into valoraciones (idProducto,emailUsuario,valoraciones,comentarios) values (2,'pepe@gmail.com',5,'Buen producto Calida Increible');
insert into valoraciones (idProducto,emailUsuario,valoraciones,comentarios) values (3,'pepe@gmail.com',6,'Producto Excelente');
insert into valoraciones (idProducto,emailUsuario,valoraciones,comentarios) values (4,'pepe@gmail.com',3,'Producto poco bueno');
insert into valoraciones (idProducto,emailUsuario,valoraciones,comentarios) values (5,'pepe@gmail.com',6,'Buen producto');
insert into valoraciones (idProducto,emailUsuario,valoraciones,comentarios) values (6,'pepe@gmail.com',7,'Bastante Bueno');
insert into valoraciones (idProducto,emailUsuario,valoraciones,comentarios) values (7,'pepe@gmail.com',9,'Increible super eficiente');
insert into valoraciones (idProducto,emailUsuario,valoraciones,comentarios) values (8,'pepe@gmail.com',2,'Nefasto el producto , esperaba mas');
insert into valoraciones (idProducto,emailUsuario,valoraciones,comentarios) values (9,'pepe@gmail.com',1,'Sin comentarios algo muy malo');
insert into valoraciones (idProducto,emailUsuario,valoraciones,comentarios) values (10,'pepe@gmail.com',5,'Decente dentro de lo que cabe');
insert into valoraciones (idProducto,emailUsuario,valoraciones,comentarios) values (11,'pepe@gmail.com',7,'Buen producto');
insert into valoraciones (idProducto,emailUsuario,valoraciones,comentarios) values (12,'pepe@gmail.com',4,'No tiene la calida suficiente ');

insert into ventas (fecha,idProducto,emailUsuario) values('2020/03/15',1,'pepe@gmail.com');

select
productos.titulo as ti,productos.precio,ventas.fecha,usuaris.nombre
from 
ventas ,productos,usuaris
where
ventas.idProducto= productos.id and ventas.emailUsuario= usuaris.emailUsuario and
 ventas.fecha  between '2020/02/05' and '2020/03/17';


select
productos.titulo ,productos.anyo,productos.precio,productos.descripcion,productos.foto
from 
productos ,valoraciones
where
productos.id = valoraciones.idProducto and
productos.id = 1;

select
*
from 
productos;


select
*
from 
empleados;

delete from productos where productos.id = 1;


select
productos.titulo,productos.anyo,productos.precio,productos.descripcion, generos.nombre as Genero , plataformas.nombre as Plataforma
from 
productos , plataformas,generos
where 
productos.idPlataforma = plataformas.id and productos.idGenero = generos.id and
productos.titulo like '%xbox%';

	select
		productos.titulo as titulo,productos.anyo as anyo, productos.precio as precio ,productos.descripcion as descripcion,
		generos.nombre as genero , plataformas.nombre as plataforma
		from
		productos , plataformas,generos
		where
		productos.idPlataforma = plataformas.id and productos.idGenero = generos.id and
		productos.titulo like '%xbox%';
        
      select
		productos.titulo,productos.anyo,productos.precio,productos.descripcion,productos.foto,
		productos.idGenero,productos.idPlataforma,productos.id
		from
		productos
		where
		productos.titulo like '%xbox%';