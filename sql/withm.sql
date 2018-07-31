set names utf8;
set foreign_key_checks = 0;
drop database if exists withm;

create database if not exists withm;
use withm;

/* 会員情報 */
drop table if exists user_info;

create table user_info(
	/* ID */
	id int not null primary key auto_increment,
	/* ユーザーID */
	user_id varchar(16) unique not null,
	/* パスワード */
	password varchar(16) not null,
	/* 姓 */
	family_name varchar(32) not null,
	/* 名 */
	first_name varchar(32) not null,
	/* 姓かな */
	family_name_kana varchar(32) not null,
	/* 名かな */
	first_name_kana varchar(32) not null,
	/* 性別 (0:男性 1:女性) */
	sex tinyint not null default 0,
	/* メールアドレス */
	email varchar(32) not null,
	/* 登録日 */
	insert_date datetime,
	/* 更新日 */
	update_date datetime,
	/* ステータス (0:一般 1:管理者) */
	admin tinyint not null default 0
);


/* 商品情報 */
drop table if exists product_info;

create table product_info(
	/* 商品ID */
	id int not null primary key auto_increment,
	/* 商品名 */
	product_name varchar(100) not null,
	/* 商品名かな */
	product_name_kana varchar(100) not null,
	/* 商品詳細 */
	product_description varchar(255) not null,
	/* カテゴリID */
	category_id int not null,
	/* 価格 */
	product_price int not null,
	/* 画像ファイル名 */
	image_file_name varchar(200),
	/* 登録日 */
	insert_date datetime,
	/* 更新日 */
	update_date datetime,
	foreign key(category_id) references master_category(category_id)
);


/* カテゴリマスター */
drop table if exists master_category;

create table master_category(
	/* ID */
	id int not null primary key auto_increment,
	/* カテゴリID */
	category_id int not null unique,
	/* カテゴリ名 */
	category_name varchar(20) not null unique,
	/* 登録日 */
	insert_date datetime,
	/* 更新日 */
	update_date datetime
);


/* カート情報 */
drop table if exists cart_info;

create table cart_info(
	/* ID */
	id int not null primary key auto_increment,
	/* ユーザーID */
	user_id varchar(16) not null,
	/* 仮ユーザーID */
	temp_user_id varchar(16),
	/* 商品ID */
	product_id int not null,
	/* 個数 */
	product_count int not null,
	/* 金額 */
	product_price int not null,
	/* 登録日 */
	insert_date datetime not null,
	/* 更新日 */
	update_date datetime
);


/* 購入情報履歴 */
drop table if exists buy_product_history;

create table buy_product_history(
	/* ID */
	id int not null primary key auto_increment,
	/* ユーザーID */
	user_id varchar(16) not null,
	/* 商品ID */
	product_id int not null,
	/* 個数 */
	product_count int not null,
	/* 金額 */
	product_price int not null,
	/* 宛先情報ID */
	destination_id int not null,
	/* 登録日 */
	insert_date datetime,
	/* 更新日 */
	update_date datetime,
	foreign key(user_id) references user_info(user_id)
);


/* 宛先情報 */
drop table if exists destination_info;

create table destination_info(
	/* ID */
	id int primary key not null auto_increment,
	/* ユーザーID */
	user_id varchar(16) not null,
	/* 姓 */
	family_name varchar(32) not null,
	/* 名 */
	first_name varchar(32) not null,
	/* 姓かな */
	family_name_kana varchar(32) not null,
	/* 名かな */
	first_name_kana varchar(32) not null,
	/* 住所 */
	user_address varchar(50) not null,
	/* 電話番号 */
	tel_number varchar(13) not null,
	/* 登録日 */
	insert_date datetime,
	/* 更新日 */
	update_date datetime
);


insert into user_info
(user_id, password, family_name, first_name, family_name_kana, first_name_kana, sex, email, admin)
values
("admin", "admin", "管理", "者", "かんり", "しゃ", 0, "admin@email.com", 1),
("guest", "guest", "ゲスト", "ユーザー", "げすと", "ゆーざー", 0, "guest@email.com", 0),
("taro", "123", "山田", "太郎", "やまだ", "たろう", 0, "yamadataro@email.com", 0);

insert into master_category
(category_id, category_name, insert_date, update_date)
values
(1, "全てのカテゴリー", now(), now()),
(2, "カテゴリ１", now(), now()),
(3, "カテゴリ２", now(), now()),
(4, "カテゴリ３", now(), now());

insert into product_info
(product_name, product_name_kana, product_description, category_id, product_price, image_file_name)
values
("商品１", "しょうひん１", "商品１の詳細", 2, 1000, "./images/sample.jpg"),
("商品２", "しょうひん２", "商品２の詳細", 2, 1000, "./images/sample.jpg"),
("商品３", "しょうひん３", "商品３の詳細", 2, 1000, "./images/sample.jpg"),
("商品４", "しょうひん４", "商品４の詳細", 2, 1000, "./images/sample.jpg"),
("商品５", "しょうひん５", "商品５の詳細", 2, 1000, "./images/sample.jpg"),
("商品６", "しょうひん６", "商品６の詳細", 2, 1000, "./images/sample.jpg"),
("商品７", "しょうひん７", "商品７の詳細", 3, 1000, "./images/sample.jpg"),
("商品８", "しょうひん８", "商品８の詳細", 3, 1000, "./images/sample.jpg"),
("商品９", "しょうひん９", "商品９の詳細", 3, 1000, "./images/sample.jpg"),
("商品１０", "しょうひん１０", "商品１０の詳細", 3, 1000, "./images/sample.jpg"),
("商品１１", "しょうひん１１", "商品１１の詳細", 3, 1000, "./images/sample.jpg"),
("商品１２", "しょうひん１２", "商品１２の詳細", 3, 1000, "./images/sample.jpg"),
("商品１３", "しょうひん１３", "商品１３の詳細", 4, 1000, "./images/sample.jpg"),
("商品１４", "しょうひん１４", "商品１４の詳細", 4, 1000, "./images/sample.jpg"),
("商品１５", "しょうひん１５", "商品１５の詳細", 4, 1000, "./images/sample.jpg"),
("商品１６", "しょうひん１６", "商品１６の詳細", 4, 1000, "./images/sample.jpg"),
("商品１７", "しょうひん１７", "商品１７の詳細", 4, 1000, "./images/sample.jpg"),
("商品１８", "しょうひん１８", "商品１８の詳細", 4, 1000, "./images/sample.jpg"),
("商品１９", "しょうひん１９", "商品１９の詳細", 4, 1000, "./images/sample.jpg"),
("商品２０", "しょうひん２０", "商品２０の詳細", 2, 1000, "./images/sample.jpg"),
("商品２１", "しょうひん２１", "商品２１の詳細", 2, 1000, "./images/sample.jpg"),
("商品２２", "しょうひん２２", "商品２２の詳細", 2, 1000, "./images/sample.jpg"),
("商品２３", "しょうひん２３", "商品２３の詳細", 2, 1000, "./images/sample.jpg"),
("商品２４", "しょうひん２４", "商品２４の詳細", 2, 1000, "./images/sample.jpg"),
("商品２５", "しょうひん２５", "商品２５の詳細", 2, 1000, "./images/sample.jpg"),
("商品２６", "しょうひん２６", "商品２６の詳細", 2, 1000, "./images/sample.jpg"),
("商品２７", "しょうひん２７", "商品２７の詳細", 2, 1000, "./images/sample.jpg");