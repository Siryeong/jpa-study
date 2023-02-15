drop table if exists `member`;

create table `member`
(
    member_id int not null auto_increment,
    username varchar(20) not null,
    password varchar(20) not null,
    primary key (member_id)
);