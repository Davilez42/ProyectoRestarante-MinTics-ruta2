Create table Mesas(
    id integer primary key,
    numero varchar(100) not null,
    constraint Mesa_numero_UQ UNIQUE (numero)
);

Create table Adicional(
    id integer primary key
    nombre varchar(100) not null,
    precio integer not null

);

create table Pedidos (
    id integer primary key,
    cliente varchar(100) not null,
    estado varchar(50) not null,
    id_mesa integer not null,
    id_adicional integer not null,
    constraint id_mesa_fk foreign key (id_mesa) references Mesa(id)
);

create table PedidoAdicional(
    id_pedido integer ,
    id_adicional integer ,
    constraint pedidoAdicional_pk primary key (id_adicional,id_pedido),
    constraint pedido_fk foreign key (id_pedido) references Pedido(id),
    constraint adicional_fk foreign key (id_adicional) references Adicional(id)

);


create table opcionesSopa(
    id integer primary key,
    nombre varchar(100) not null

);
create table opcionesJugo(
    id integer primary key,
    nombre varchar(100) not null

);
create table opcionesCarne(
    id integer primary key,
    nombre varchar(100) not null

);
create table opcionesEnsalada(
    id integer primary key,
    nombre varchar(100) not null

);
create table opcionesPrincipio(
    id integer primary key,
    nombre varchar(100) not null

);


create table Corrientazos(
    id integer primary key,
    precio integer not null,
    id_carne not null,
    id_sopa not null,
    id_jugo not null,
    id_principio not null,
    id_ensalada not null,
    constraint id_carne_fk foreign key (id_carne) references opcionesCarne(id),
    constraint id_sopa_fk foreign key (id_sopa) references opcionesSopa(id),
    constraint id_ensalada_fk foreign key (id_ensalada) references opcionesEnsalada(id),
    constraint id_jugo_fk foreign key (id_jugo) references opcionesJugo(id),
    constraint id_principio_fk foreign key (id_principio) references opcionesPrincipio(id)
);