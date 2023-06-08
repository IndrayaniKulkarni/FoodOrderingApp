use restaurantdb;
-- drop table food_at_resto;-- 


CREATE TABLE products(
item_id int primary key not null unique,
item_name varchar(64) not null,
description varchar(128) not null,
price float not null
);

CREATE TABLE restaurant(
resto_id int primary key not null unique,
resto_name varchar(64) not null,
address varchar(128) not null
);


CREATE TABLE food_at_resto(
id INT PRIMARY KEY NOT NULL,
is_available BOOLEAN DEFAULT TRUE,
item_id INT,
resto_id INT,

FOREIGN KEY (item_id) REFERENCES products(item_id),
FOREIGN KEY (resto_id) REFERENCES restaurant(resto_id)
);

DESC food_at_resto;


CREATE TABLE cart(
cart_id INT PRIMARY KEY,
user_name VARCHAR(128) NOT NULL,
tot_bill FLOAT NOT NULL,
resto_id INT,
FOREIGN KEY (resto_id) REFERENCES restaurant(resto_id)
);

ALTER TABLE cart
MODIFY cart_id INT AUTO_INCREMENT;

ALTER TABLE cart
MODIFY cart_id VARCHAR(36);

CREATE TABLE items_in_cart(
cart_id INT,
item_id INT,
quantity INT DEFAULT 1,
price FLOAT, -- update on insert
tot_cost FLOAT,
FOREIGN KEY (item_id) REFERENCES products(item_id),
FOREIGN KEY (cart_id) REFERENCES cart(cart_id)
);


ALTER TABLE items_in_cart
ADD COLUMN id_i INT PRIMARY KEY AUTO_INCREMENT FIRST;

SHOW CREATE TABLE items_in_cart;

ALTER TABLE items_in_cart
ADD CONSTRAINT fk_cart_id FOREIGN KEY (cart_id) REFERENCES cart(cart_id);

ALTER TABLE items_in_cart
DROP  FOREIGN KEY fk_cart_id;

ALTER TABLE items_in_cart
MODIFY cart_id VARCHAR(36),
ADD CONSTRAINT fk_cart_idproducts FOREIGN KEY (cart_id) REFERENCES cart(cart_id);
