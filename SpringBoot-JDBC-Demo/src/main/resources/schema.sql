create table if not exists courses(
    courseId int primary key,
    title varchar(100) not null,
    description varchar(255),
    price int,
    category_id int not null,
    foreign key (category_id) references categories(id)
    on delete cascade
    on update cascade

);