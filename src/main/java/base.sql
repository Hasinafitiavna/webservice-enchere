DROP DATABASE enchere;
CREATE DATABASE enchere;
\c enchere

drop table produit cascade;
drop table admin cascade;
drop table client cascade;
drop table cartebancaire cascade;
drop table enchere cascade;
drop table actionencherir cascade;
drop table lienenchereaction cascade;
--table niampy
drop table usedMoney cascade;
drop table rechargementcompte cascade;
drop table archive cascade;
drop table margebeneficiare cascade;

create table admin(
                      id serial,
                      nom varchar(40),
                      pass varchar(40),
                      primary key(id)
);

insert into admin(nom,pass) values ('james','j');

create table produit(
                        id serial,
                        nom varchar(40),
                        image varchar(40),
                        primary key(id)
);

insert into produit(nom,image) values ('voiture','lienimage');
insert into produit(nom,image) values ('moto','lienimage');
insert into produit(nom,image) values ('avion','lienimage');

create table client(
                       id serial,
                       nom varchar(40),
                       pass varchar(40),
                       primary key(id)
);

insert into client(nom,pass) values ('jones','j');
insert into client(nom,pass) values ('stones','s');
insert into client(nom,pass) values ('phillip','p');

create table cartebancaire(
                              id serial,
                              idclient int,
                              montant real,
                              primary key(id),
                              foreign key(idclient) references client(id)
);

insert into cartebancaire(idclient,montant) values (1,10000);
insert into cartebancaire(idclient,montant) values (2,20000);
insert into cartebancaire(idclient,montant) values (3,30000);

create table enchere(
                        id serial,
                        idproduit int,
                        idclientdetenteur int,
                        datedebut timestamp,
                        datefin timestamp,
                        montantdebase real,
                        primary key(id),
                        foreign key(idproduit) references produit(id),
                        foreign key(idclientdetenteur) references client(id)
);

insert into enchere(idproduit,idclientdetenteur,datedebut,datefin,montantdebase) values (1,1,'2011-03-10 21:35:15','2011-03-10 21:35:15',20000);
insert into enchere(idproduit,idclientdetenteur,datedebut,datefin,montantdebase) values (2,1,'2011-03-10 21:35:15','2011-03-10 21:35:15',30000);
insert into enchere(idproduit,idclientdetenteur,datedebut,datefin,montantdebase) values (3,2,'2011-03-10 21:35:15','2011-03-10 21:35:15',40000);

create table actionencherir(
                               id serial,
                               idenchere int,
                               idclient int,
                               montant real,
                               dateaction timestamp,
                               primary key(id),
                               foreign key(idclient) references client(id),
                               foreign key(idenchere) references enchere(id)
);

insert into actionencherir(idclient,idenchere,montant,dateaction) values (2,1,25000,'2011-03-10 21:35:15');
insert into actionencherir(idclient,idenchere,montant,dateaction) values (3,1,35000,'2011-03-10 22:35:15');
insert into actionencherir(idclient,idenchere,montant,dateaction) values (2,1,45000,'2011-03-10 23:35:15');
insert into actionencherir(idclient,idenchere,montant,dateaction) values (2,2,50000,'2011-03-10 23:45:15');

create table lienenchereaction(
                                  idenchere int,
                                  idaction int,
                                  foreign key(idenchere) references enchere(id),
                                  foreign key(idaction) references actionencherir(id)
);

insert into lienenchereaction(idenchere,idaction) values (1,1);
insert into lienenchereaction(idenchere,idaction) values (1,2);
insert into lienenchereaction(idenchere,idaction) values (1,3);

drop view venchereclient;

create or replace view venchereclient as
select l.idenchere idenchere,a.idclient,a.montant,a.dateaction from lienenchereaction l join actionencherir a on l.idaction = a.id
                                                                                        join client c on a.idclient = c.id order by dateaction asc;

select * from venchereclient where idenchere=1;


create or replace view listeenchere as
select enchere.id,produit.nom as nomproduit,client.nom as nomclient,datedebut,datefin,montantdebase from enchere join client on enchere.idclientdetenteur = client.id join produit  on enchere.idproduit = produit.id;


create table usedMoney(
                          id serial,
                          idclient int,
                          idenchere int,
                          montant real,
                          primary key(id),
                          foreign key(idclient) references client(id),
                          foreign key(idenchere) references enchere(id)
);

insert into usedMoney(idclient,idenchere,montant) values (1,1,1000);
insert into usedMoney(idclient,idenchere,montant) values (1,1,2000);
insert into usedMoney(idclient,idenchere,montant) values (1,1,3000);
insert into usedMoney(idclient,idenchere,montant) values (1,2,4000);
insert into usedMoney(idclient,idenchere,montant) values (1,2,5000);
insert into usedMoney(idclient,idenchere,montant) values (1,2,6000);

select * from usedmoney where idclient=1 and idenchere=1 order by montant desc limit 1;

create table rechargementcompte(
                                   id serial,
                                   idclient int,
                                   montant real,
                                   valid boolean default false,
                                   primary key(id),
                                   foreign key(idclient) references client(id)
);
insert into rechargementcompte ( idclient, montant) values (1,2000);
insert into rechargementcompte ( idclient, montant) values (2,2000);
select montant from cartebancaire where idclient=1;


create table margebeneficiare(
                                 id serial,
                                 pourcentage real,
                                 primary key(id)
);

insert into margebeneficiare(pourcentage) values (20);

create table archive(
                        id serial,
                        idenchere int,
                        idclientgagnat int,
                        montant real,
                        beneficeantsika real,
                        primary key(id),
                        foreign key(idclientgagnat) references client(id)
);

insert into archive(idenchere,idclientgagnat,montant,beneficeantsika) values (1,2,10000,2000);
insert into archive(idenchere,idclientgagnat,montant,beneficeantsika) values (2,2,20000,4000);
insert into archive(idenchere,idclientgagnat,montant,beneficeantsika) values (3,3,30000,1000);


select montant from cartebancaire where idclient=1;

select * from actionencherir where idenchere=1 order by dateaction desc limit 1;