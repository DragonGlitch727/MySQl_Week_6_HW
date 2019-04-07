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
	state varchar(20) not null,
	zip int(5) not null,
	phone_number int(10) not null,
	primary key (id)
);

create table insurance (
	id int(12) not null auto_increment,
	name varchar(20) not null,
	description varchar(200),
	primary key (id),
    patient_id int(12) not null,
	foreign key (patient_id) references patients(id)
);

create table appointments (
	id int(15) not null auto_increment,
	date_time datetime not null,
	primary key (id),
    patient_id int(12) not null,
	foreign key (patient_id) references patients(id)
);