create database if not exists patients;

use patients;

drop table if exists appointments;
drop table if exists insurance;
drop table if exists patients;

create table patients (
	id int(12) not null auto_increment,
	first_name varchar(20) not null,
	last_name varchar(20) not null,
	street varchar(20) not null,
	city varchar(20) not null,
	state String(2) not null,
	zip int(5) not null,
	phone_number String(10) not null,
	primary key (id)
);

create table insurance (
	id int(12) not null auto_increment,
	patient_id int(12) not null,
	name varchar(20) not null,
	description varchar(200),
	primary key (id),
	foreign key (patient_id) references patients(id)
);

create table appointments (
	id int(15) not null auto_increment,
	patient_id int(12) not null,
	date_time datetime not null,
	primary key (id),
	foreign key (patient_id) references patients(id)
);