drop database if exists quan_ly_sinh_vien;
create database if not exists quan_ly_sinh_vien;
use quan_ly_sinh_vien;

CREATE TABLE Class
(
    Class_ID   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Class_Name VARCHAR(60) NOT NULL,
    Start_Date DATETIME    NOT NULL,
    Status    BIT
);

CREATE TABLE Student
(
    v   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Student_Name VARCHAR(30) NOT NULL,
    Address     VARCHAR(50),
    Phone       VARCHAR(20),
    Status      BIT,
    Class_Id     INT         NOT NULL,
    FOREIGN KEY (Class_Id) REFERENCES Class (Class_ID)
);

CREATE TABLE Subject
(
    SubId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Sub_Name VARCHAR(30) NOT NULL,
    Credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( Credit >= 1 ),
    Status  BIT                  DEFAULT 1
);

CREATE TABLE Mark
(
    Mark_Id    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Sub_Id     INT NOT NULL,
    Student_Id INT NOT NULL,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    Exam_Times TINYINT DEFAULT 1,
    UNIQUE (SubId, Student_Id),
    FOREIGN KEY (Sub_Id) REFERENCES Subject (Sub_Id),
    FOREIGN KEY (Student_Id) REFERENCES Student (Student_Id)
);

INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);

INSERT INTO Student (Student_Name, Address, Phone, Status, Class_Id)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (Student_Name, Address, Status, Class_Id)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (Student_Name, Address, Phone, Status, Class_Id)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO Subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
       
INSERT INTO Mark (Sub_Id, Student_Id, Mark, Exam_Times)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
select * from student
where student_name like '%h%';

select * from class
where month(Start_Date)  =12;

select * from Subject
where Credit >= 3 and Credit <=5;

update student
set classid = 2
where student_name = 'Hung' and student_id = 2;
select * from student;

select student.student_name, `Subject`.sub_name,  Mark.Mark from student
join mark on student.Student_Id = mark. Student_Id
join `Subject` on mark.sub_id = `Subject`.sub_id
order by mark desc, student_name asc ;