# AtyponProject

Read me:

This project aims to provide me with business basic knowledge to start my career.

Scenario:
Register first, you must view all uploaded articles.
To upgrade user privilege to admin, go to web admin, sign in as {username: admin, password: admin}
re-sign in, you must go to admin page, where admin can upload articles.

Admin can upload articles as zip file, where uploaded article processed in backstage and transformed into info.xml and article.html.

User can view articles, and read it’s abstract only.

Web admin  can CRUD users,  CR articles and journals.

Tools:
IDE→ I used intellij enterprise, eclipse  is good alternative
Web server → Tom-cat , Glass door is good alternative
Data base → MySQl


To run this code:
Set up your mysql database:

Database: dbProject
Password: password

Tables:
$create table articles (journal_name varchar(1024) ,issue_number int ,doi varchar(100), path varchar(1024));

$create table whoisDOI (title varchar(2048) , doi varchar(150));

$create table journals (journal_name varchar(450), publisher_name varchar(250),publisher_location varchar(150), publisher_id varchar(100), user_name varchar(100), issn_ppub varchar(100), issn_epub varchar(100));

$create tables users (uname varchar(100) , password  varchar(250) , privilage varchar(25), email          varchar(150), id int not null AUTO_INCREMENT);

Make sure to edit paths in backstage class to be compatible with your machine.
and you  need to add webadmin into data base manually. 

@aabudouleh@atypon.com
