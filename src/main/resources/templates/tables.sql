create table tb_student(
	id integer primary key auto_increment,
    name varchar(100),
    email varchar(100) unique,
    password varchar(100)
)engine = InnoDB, charset = utf8mb4;
    
create table tb_course (
	id integer primary key auto_increment,
    last_day varchar(10),
    start_day varchar(10),
    study_time integer,
    name varchar(100),
    student_id integer,
    foreign key (student_id) references tb_student(id)
)engine = InnoDB, charset = utf8mb4;

create table tb_subject (
	id integer primary key auto_increment,
    last_day varchar(10),
    start_day varchar(10),
    study_time integer,
	name varchar(50),
	course_id integer,
    foreign key (course_id) references tb_course(id)
)engine = InnoDB, charset = utf8mb4;

create table tb_week (
	id integer primary key auto_increment,
    start_day varchar(10),
    last_day varchar(10),
    study_time integer,
    start_time integer,
    start_session_time integer,
    ended boolean,
    subject_id integer,
    foreign key (subject_id) references tb_subject(id)
)engine = InnoDB, charset = utf8mb4;

create table tb_study_goal(
	description varchar(100),
    id integer primary key auto_increment,
    done boolean,
    _week_id integer,
    foreign key (_week_id) references tb_week(id)
)engine = InnoDB, charset = utf8mb4;

create table tb_time_goal(
	time_goal integer,
    id integer primary key auto_increment,
    done boolean,
	week_id integer unique,
    foreign key (week_id) references tb_week(id)
)engine = InnoDB, charset = utf8mb4;