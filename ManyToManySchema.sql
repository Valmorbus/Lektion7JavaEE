create table bird(
id int primary key not null GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),   
birdname varchar (256) not null
);

create table observer(
id int primary key not null GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),   
observername varchar (256) not null
); 


create table observation (
birdid int, 
observerid int,
comment varchar (256),
constraint pk_observations PRIMARY KEY (birdid, observerid),
constraint fk_bird_id_ref foreign key (birdid) references bird(id),
constraint fk_observer_id_ref foreign key (observerid) references observer(id)
);
