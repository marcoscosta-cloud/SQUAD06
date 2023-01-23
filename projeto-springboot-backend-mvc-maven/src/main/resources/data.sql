
-- USERS
insert into tbl_users (ID, NAME, LOGIN, PASSWORD)
values (1, 'Alan', 'alans', 'f1bf226c0d04086df920c5028de9dd26');

insert into tbl_users (ID, NAME, LOGIN, PASSWORD)
values (2, 'Otavio', 'ocamargo', '7ffcc00c2e1fd78a91e8c4c8477bc6e8');

insert into tbl_users (ID, NAME, LOGIN, PASSWORD)
values (3, 'Natália', 'nnogueira', '8ffcc00c2e1fd78a91e8c4c8477bc6e9');



-- TRAIL
insert into tbl_trail (ID, TITLE, DESCRIPTION, URL, CODE)
values (1, 'Java Basico', 'Curso de Java Basico', 'https://cursos.alura.com.br/course/certificacao-java-basico', '1001');

insert into tbl_trail (ID, TITLE, DESCRIPTION, URL, CODE)
values (2, 'Java OO', 'Entendendo a orientacao a objetos', 'https://cursos.alura.com.br/course/java-introducao-orientacao-objetos?preRequirementFrom=certificacao-java-basico', '1002');

insert into tbl_trail (ID, TITLE, DESCRIPTION, URL, CODE)
values (3, 'Spring Boot', 'Entendendo a Spring Boot', 'https://cursos.alura.com.br/course/java-Spring-Boot?preRequirementFrom=certificacao-java-basico', '1003');



-- CONTENT
insert into tbl_content (ID, TITLE, DESCRIPTION, TYPE_CONTENT, URL_CONTENT, URL_IMAGE)
values (1, 'Java Basico', 'Curso de Java Basico', 'Curso de Java Basico', 'https://cursos.alura.com.br/course/certificacao-java-basico', 'https://4.bp.blogspot.com/-sBW9DpZ-x24/Vwb3_trq1YI/AAAAAAAARWU/wr9VZvFDaU8DnOV9VcE-wu0aQDolOj28Q/s1600/BANNER.jpg');
 
insert into tbl_content (ID, TITLE, DESCRIPTION, TYPE_CONTENT, URL_CONTENT, URL_IMAGE)
values (2, 'Java Basico1', 'Curso de Java Basico1', 'Curso de Java Basico1', 'https://cursos1.alura.com.br/course/certificacao-java-basico', 'https://4.bp.blogspot1.com/-sBW9DpZ-x24/Vwb3_trq1YI/AAAAAAAARWU/wr9VZvFDaU8DnOV9VcE-wu0aQDolOj28Q/s1600/BANNER.jpg');

insert into tbl_content (ID, TITLE, DESCRIPTION, TYPE_CONTENT, URL_CONTENT, URL_IMAGE)
values (3, 'Java Basico2', 'Curso de Java Basico2', 'Curso de Java Basico2', 'https://cursos2.alura.com.br/course/certificacao-java-basico', 'https://4.bp.blogspot2.com/-sBW9DpZ-x24/Vwb3_trq1YI/AAAAAAAARWU/wr9VZvFDaU8DnOV9VcE-wu0aQDolOj28Q/s1600/BANNER.jpg');

insert into tbl_content (ID, TITLE, DESCRIPTION, TYPE_CONTENT, URL_CONTENT, URL_IMAGE)
values (4, 'Java Basico3', 'Curso de Java Basico3', 'Curso de Java Basico3', 'https://cursos3.alura.com.br/course/certificacao-java-basico', 'https://4.bp.blogspot3.com/-sBW9DpZ-x24/Vwb3_trq1YI/AAAAAAAARWU/wr9VZvFDaU8DnOV9VcE-wu0aQDolOj28Q/s1600/BANNER.jpg');

insert into tbl_content (ID, TITLE, DESCRIPTION, TYPE_CONTENT, URL_CONTENT, URL_IMAGE)
values (5, 'Java Basico4', 'Curso de Java Basico4', 'Curso de Java Basico4', 'https://cursos4.alura.com.br/course/certificacao-java-basico', 'https://4.bp.blogspot4.com/-sBW9DpZ-x24/Vwb3_trq1YI/AAAAAAAARWU/wr9VZvFDaU8DnOV9VcE-wu0aQDolOj28Q/s1600/BANNER.jpg');

insert into tbl_content (ID, TITLE, DESCRIPTION, TYPE_CONTENT, URL_CONTENT, URL_IMAGE)
values (6, 'Java Basico5', 'Curso de Java Basico5', 'Curso de Java Basico5', 'https://cursos5.alura.com.br/course/certificacao-java-basico', 'https://4.bp.blogspot5.com/-sBW9DpZ-x24/Vwb3_trq1YI/AAAAAAAARWU/wr9VZvFDaU8DnOV9VcE-wu0aQDolOj28Q/s1600/BANNER.jpg');

insert into tbl_content (ID, TITLE, DESCRIPTION, TYPE_CONTENT, URL_CONTENT, URL_IMAGE)
values (7, 'Java Basico6', 'Curso de Java Basico6', 'Curso de Java Basico6', 'https://cursos6.alura.com.br/course/certificacao-java-basico', 'https://4.bp.blogspot6.com/-sBW9DpZ-x24/Vwb3_trq1YI/AAAAAAAARWU/wr9VZvFDaU8DnOV9VcE-wu0aQDolOj28Q/s1600/BANNER.jpg');

insert into tbl_content (ID, TITLE, DESCRIPTION, TYPE_CONTENT, URL_CONTENT, URL_IMAGE)
values (8, 'Java Basico7', 'Curso de Java Basico7', 'Curso de Java Basico7', 'https://cursos7.alura.com.br/course/certificacao-java-basico', 'https://4.bp.blogspot7.com/-sBW9DpZ-x24/Vwb3_trq1YI/AAAAAAAARWU/wr9VZvFDaU8DnOV9VcE-wu0aQDolOj28Q/s1600/BANNER.jpg');

insert into tbl_content (ID, TITLE, DESCRIPTION, TYPE_CONTENT, URL_CONTENT, URL_IMAGE)
values (9, 'Java Basico8', 'Curso de Java Basico8', 'Curso de Java Basico8', 'https://cursos8.alura.com.br/course/certificacao-java-basico', 'https://4.bp.blogspot8.com/-sBW9DpZ-x24/Vwb3_trq1YI/AAAAAAAARWU/wr9VZvFDaU8DnOV9VcE-wu0aQDolOj28Q/s1600/BANNER.jpg');



--USERS_CONTENTS
insert into tbl_users_contents (USER_MODEL_ID, CONTENTS_ID )
values (1, 1),(1, 2),(1, 3);

insert into tbl_users_contents (USER_MODEL_ID, CONTENTS_ID )
values (2, 1),(2, 2),(2, 6);

insert into tbl_users_contents (USER_MODEL_ID, CONTENTS_ID )
values (3, 7),(3, 8),(3, 9);



--CONTENTS-TRAILS
insert into tbl_contents_trails (CONTENTS_ID, TRAIL_ID)
values (1, 1),(2, 1),(3, 1);

insert into tbl_contents_trails (CONTENTS_ID, TRAIL_ID)
values (4, 2),(5, 2),(6, 2);

insert into tbl_contents_trails (CONTENTS_ID, TRAIL_ID)
values (7, 3),(8, 3),(9, 3);


