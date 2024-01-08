INSERT INTO users (id, login, password, salt, last_name, first_name, email, phone, sex, birthday, employee, inn, passport_number)
VALUES
    ('1f8a7f2d-b0fc-4b8b-88e5-859e674cda9b', 'alice_smith', 'hashed_password_1', 'salt_value_1', 'Smith', 'Alice', 'alice@example.com', '987654321', 'F', '1985-03-15', 1, '9876543210', 'CD9876543'),
    ('732619c1-83d9-401c-8e7c-cfe5556219f8', 'bob_jones', 'hashed_password_2', 'salt_value_2', 'Jones', 'Bob', 'bob@example.com', '654321987', 'M', '1990-08-22', 1, '8765432109', 'EF1234567'),
    ('f3ef907a-b7c0-49f0-aa1b-3b6f4427c2a7', 'carol_wilson', 'hashed_password_3', 'salt_value_3', 'Wilson', 'Carol', 'carol@example.com', '123789456', 'F', '1988-11-10', 0, '7654321098', 'GH2345678'),
    ('23a43b64-123a-4cd7-a567-123b5c45678d', 'dave_miller', 'hashed_password_4', 'salt_value_4', 'Miller', 'Dave', 'dave@example.com', '789456123', 'M', '1995-05-03', 0, '6543210987', 'IJ3456789'),
    ('567c2345-678a-4b23-90cd-345e456789ab', 'eva_roberts', 'hashed_password_5', 'salt_value_5', 'Roberts', 'Eva', 'eva@example.com', '456789012', 'F', '1987-09-18', 0, '5432109876', 'KL4567890');


-- Добавление характеристик товаров
INSERT INTO characteristics (id, weight, height, width, length, description, other)
VALUES
    ('4c6db7eb-ba5c-4ccf-8d33-1e5c5b6883f0', '1.5 kg', '15 in', '10 in', '1.5 ft', 'Slim and lightweight design', '{"color": "silver", "brand": "ABC"}'),
    ('3e405f58-8f03-4af3-b64c-b07fb25c2cfd', '2.0 kg', '14 in', '12 in', '2 ft', 'Powerful performance', '{"color": "black", "brand": "XYZ"}'),
('b654c345-6789-4c12-bc34-567890abc123', '1.2 kg', '12 in', '8 in', '1 ft', 'Compact design', '{"color": "white", "brand": "PQR"}'),
('c789d456-789a-4f56-de78-9012ef34567d', '2.5 kg', '16 in', '10 in', '1.8 ft', 'High-resolution display', '{"color": "blue", "brand": "LMN"}');

--

-- Добавление категорий
INSERT INTO category (id, name, description, permitted_age)
VALUES
    ('2a71e0d3-5f03-4e53-ae36-6a961174d3d3', 'Smartphones', 'Mobile devices', 16),
    ('fb2449d1-9ee6-4d15-8e90-5e4c3516f6a7', 'Headphones', 'Audio accessories', 0),
('901de234-5678-4890-abc1-2345de678901', 'Laptops', 'Portable computers', 18),
('abcd3456-789e-4abc-de01-23ef45678901', 'Smartwatches', 'Wearable technology', 12);
;

-- Добавление производителей
INSERT INTO manufacturer (id, name, description, site_url, year_of_foundation)
VALUES
    ('ed6a5d44-0fe7-4303-bc93-cf9d9ef2b762', 'Tech Innovators', 'Cutting-edge technology company', 'http://tech-innovators.com', 2005),
    ('12ce18e1-7e9d-4ad1-aeb3-8e98d2d509cb', 'SoundMasters', 'Premium audio solutions', 'http://sound-masters.com', 2010),
    ('36023e2e-312f-4db0-9f8e-212bd5d40678', 'ElectroTech', 'Innovative electronics manufacturer', 'http://electrotech.com', 2012),
    ('092771d0-1bba-4c1d-a2cd-1baf4283b7dd', 'VisualSounds', 'Audiovisual solutions provider', 'http://visualsounds.com', 2008);


-- Добавление товаров
INSERT INTO product (id, name, quantity, characteristics, price, photo, category, measure)
VALUES
    ('fa4ac245-74e3-41f3-bbe1-34af7a617ed3', 'Smartphone A', 100, '4c6db7eb-ba5c-4ccf-8d33-1e5c5b6883f0', 799.99, 'phone_a.jpg', '2a71e0d3-5f03-4e53-ae36-6a961174d3d3', 'unit'),
    ('98fe895a-27fe-4e8a-8c6a-3145c3c597d3', 'Headphones X', 50, '3e405f58-8f03-4af3-b64c-b07fb25c2cfd', 149.99, 'headphones_x.jpg', 'fb2449d1-9ee6-4d15-8e90-5e4c3516f6a7', 'pair'),
('a95cbd6e-78f8-49e2-9bcd-604af5f8fee1', 'Laptop B', 50, 'b654c345-6789-4c12-bc34-567890abc123', 1299.99, 'laptop_b.jpg', '901de234-5678-4890-abc1-2345de678901', 'unit'),
('3e174683-9546-45f9-9ecb-5dbdcd68a9a9', 'Smartwatch Y', 30, 'c789d456-789a-4f56-de78-9012ef34567d', 199.99, 'smartwatch_y.jpg', 'abcd3456-789e-4abc-de01-23ef45678901', 'unit');


-- Добавление корзин
INSERT INTO baskets (id, user_id)
VALUES
    ('0d13c902-79a4-40cf-a2ea-7da940a123e4', '1f8a7f2d-b0fc-4b8b-88e5-859e674cda9b'),
    ('234a5678-bcde-41f2-90de-123456abcdef', 'f3ef907a-b7c0-49f0-aa1b-3b6f4427c2a7'),
    ('3456bcd7-89ea-4c12-b345-67890abcde12', '567c2345-678a-4b23-90cd-345e456789ab');


INSERT INTO basket_items (basket_id, product_id, quantity)
VALUES
    ('0d13c902-79a4-40cf-a2ea-7da940a123e4', 'fa4ac245-74e3-41f3-bbe1-34af7a617ed3', 2),
    ('0d13c902-79a4-40cf-a2ea-7da940a123e4', 'a95cbd6e-78f8-49e2-9bcd-604af5f8fee1', 1),
    ('3456bcd7-89ea-4c12-b345-67890abcde12', 'fa4ac245-74e3-41f3-bbe1-34af7a617ed3', 3);

-- Добавление поставок товаров
INSERT INTO goods_delivery (id, product_id, quantity, description, created_at, updated_at)
VALUES
    ('1a2b3c4d-5e6f-7a8b-9c0d-abcdef123456', 'fa4ac245-74e3-41f3-bbe1-34af7a617ed3', 100, 'Delivery of Smartphones', current_timestamp, current_timestamp),
    ('2b3c4d5e-6f7a-8b9c-0d1e-abcdef987654', 'a95cbd6e-78f8-49e2-9bcd-604af5f8fee1', 50, 'Delivery of Smartwatches', current_timestamp, current_timestamp);

-- Добавление заказов
INSERT INTO orders (id, user_id, description, created_at, updated_at)
VALUES
    ('3c4d5e6f-7a8b-9c0d-1e2f-abcdef098765', '23a43b64-123a-4cd7-a567-123b5c45678d', 'Order for Smartphone X and Smartwatch Y', current_timestamp, current_timestamp),
    ('5e6f7a8b-9c0d-1e2f-3a4b-abcdef123456', '567c2345-678a-4b23-90cd-345e456789ab', 'Order for Smartwatch Y', current_timestamp, current_timestamp);

-- Добавление товаров в заказы
INSERT INTO order_items (order_id, product_id, quantity, created_at, updated_at)
VALUES
    ('3c4d5e6f-7a8b-9c0d-1e2f-abcdef098765', '98fe895a-27fe-4e8a-8c6a-3145c3c597d3', 2, current_timestamp, current_timestamp),
    ('3c4d5e6f-7a8b-9c0d-1e2f-abcdef098765', '3e174683-9546-45f9-9ecb-5dbdcd68a9a9', 1, current_timestamp, current_timestamp),
    ('5e6f7a8b-9c0d-1e2f-3a4b-abcdef123456', '98fe895a-27fe-4e8a-8c6a-3145c3c597d3', 1, current_timestamp, current_timestamp);

INSERT INTO shop_info (id, name, description, site_url, year_of_foundation, phone, inn, kpp)
VALUES
    ('98461a04-ba5b-44ff-9b27-c890de08caa1', 'ElectroMart', 'Your one-stop electronics store', 'http://electromart.com', 2000, '9876543210', '0123456789', '987654321');

UPDATE users SET created_at = current_timestamp - interval '5' day, updated_at = current_timestamp WHERE id = '1f8a7f2d-b0fc-4b8b-88e5-859e674cda9b';
UPDATE product SET created_at = current_timestamp - interval '25' day, updated_at = current_timestamp WHERE id = 'fa4ac245-74e3-41f3-bbe1-34af7a617ed3';
UPDATE baskets SET created_at = current_timestamp - interval '30' day, updated_at = current_timestamp WHERE id = '0d13c902-79a4-40cf-a2ea-7da940a123e4';
UPDATE basket_items SET created_at = current_timestamp - interval '35' day, updated_at = current_timestamp WHERE basket_id = '0d13c902-79a4-40cf-a2ea-7da940a123e4';
UPDATE orders SET created_at = current_timestamp - interval '40' day, updated_at = current_timestamp WHERE id = '3c4d5e6f-7a8b-9c0d-1e2f-abcdef098765';
