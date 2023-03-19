

# c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Kiki\Documents\zavrsni_rad\motosezona.sql

drop database if exists motovodic;
create database motovodic;
use motovodic;
create table motoklub(
    sifra int not null primary key auto_increment,
    naziv varchar(50),
    mjesto varchar(50),
    brojclanova int,
    registracija boolean
);

create table motodogadjaj(
    sifra int not null primary key auto_increment,
    naziv varchar(50),
    mjestoodrzavanja varchar(50),
    odgovorniclan varchar(50),
    datumpocetka datetime,
    motoklub int
    
);

create table smjestaj(
    sifra int not null primary key auto_increment,
    naziv varchar(50),
    vrsta varchar(50),
    cijena decimal(18,2),
    motodogadjaj int
 );

create table servis(
    sifra int not null primary key auto_increment,
    naziv varchar(50),
    mjesto varchar(50),
    radnovrijeme varchar(50),
    smjestaj int
);

create table smjestajservis(
    smjestaj int,
    servis int
);



alter table motodogadjaj add foreign key (motoklub) references motoklub(sifra);
alter table smjestaj add foreign key (motodogadjaj) references motodogadjaj(sifra);
alter table smjestajservis add foreign key (smjestaj) references smjestaj(sifra);
alter table smjestajservis add foreign key (servis) references servis(sifra);


insert into motoklub(naziv,mjesto,brojclanova,registracija)
values ('"MK Brod"', 'Slavonski Brod', 100, true), 
('"MK Osijek"', 'Osijek', 40, true),
('"MK Vukovar"', 'Vukovar',  50, true);

insert into motodogadjaj (naziv, mjestoodrzavanja, odgovorniclan, datumpocetka, motoklub)
VALUES ('Mega bikers susreti', 'Poloj', 'Mario Karakaš', '2023-05-12 17:00:00', 1),
('Osječki moto susreti', 'Tvrđa', 'Zdravko Bošnjak', '2023-06-25 17:00:00', 2),
('Moto party MK Vukovar', 'Dunavska šetnica Vukovar', 'Kristijan Komšić', '2023-06-27 17:00:00', 3);

insert into smjestaj(naziv,vrsta,cijena, motodogadjaj, servis)
values ('Guesthouse Coco', 'Hostel', 200.1, 1,1),
('Guest House Talas', 'Apartmani', 262.2, 2,2),
('Vila Rosa', 'Hostel', 360.1, 3,3);

insert into servis(naziv,mjesto,radnovrijeme)
values ('Big Bike', 'Slavonski Brod', '09-17h'),
('Moto silver', 'Osijek', '09-17h'),
('Docdyno tuning', 'Vinkovci', '08-16h');























