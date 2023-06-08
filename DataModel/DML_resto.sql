-- add data 

INSERT INTO products (item_id, item_name, description, price) VALUES
(1, 'Pizza', 'Delicious pizza topped with cheese and vegetables', 10.99),
(2, 'Burger', 'Juicy beef patty with fresh lettuce and special sauce', 7.99),
(3, 'Pasta', 'Classic Italian pasta with rich tomato sauce', 12.50),
(4, 'Salad', 'Fresh mixed greens with cherry tomatoes and vinaigrette dressing', 8.75);


INSERT INTO restaurant (resto_id, resto_name, address) VALUES
(10, 'The Spicy Spoon', '123 Main Street, City A'),
(20, 'Casa Bella Trattoria', '456 Elm Street, City B'),
(30, 'Mango Tree Bistro', '789 Oak Street, City C'),
(40, 'Oceanview Seafood Grill', '987 Pine Street, City D'),
(50, 'Green Leaf Cafe', '654 Maple Street, City E');

INSERT INTO food_at_resto (id, is_available, item_id, resto_id) VALUES
(101, TRUE, 1, 10),
(102, TRUE, 2, 10),
(103, FALSE, 3, 20),
(104, TRUE, 4, 30),
(105, TRUE, 2, 30);

INSERT INTO cart (cart_id, user_name, tot_bill, resto_id) VALUES
(501, 'John Doe', 25.99, 10),
(502, 'Jane Smith', 12.50, 10),
(503, 'Alice Johnson', 38.75, 20),
(504, 'Bob Thompson', 17.99, 10),
(505, 'Emily Davis', 10.25, 10);

INSERT INTO items_in_cart (cart_id, item_id, quantity, price, tot_cost) VALUES
(501, 1, 2, 10.99, 21.98),
(501, 3, 1, 8.50, 8.50),
(502, 2, 3, 19.99, 59.97),
(503, 4, 2, 15.75, 31.50),
(503, 2, 1, 12.49, 12.49);