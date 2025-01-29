-- 2)
INSERT INTO menu (type, name_en, name_uk, price) 
VALUES ('dessert', 'Macaron', 'Макарун', 90.00);

INSERT INTO staff (full_name, phone, address, position) 
VALUES ('Дмитро Лисенко', '380501112233', 'Київ, вул. Бульварна, 22', 'Бариста');

INSERT INTO staff (full_name, phone, address, position) 
VALUES ('Анастасія Грищенко', '380671234789', 'Київ, вул. Велика Васильківська, 10', 'Кондитер');

INSERT INTO customers (full_name, birth_date, phone, address, discount) 
VALUES ('Олександр Кравченко', '1988-07-19', '380931119988', 'Київ, вул. Андріївський узвіз, 15', 7);

INSERT INTO orders (customer_id) 
VALUES ((SELECT id FROM customers WHERE phone = '380931119988'));

WITH last_order AS (
    SELECT id FROM orders ORDER BY order_date DESC LIMIT 1
)
INSERT INTO order_items (order_id, menu_id, quantity) 
VALUES ((SELECT id FROM last_order), (SELECT id FROM menu WHERE name_en = 'Espresso'), 2);

INSERT INTO orders (customer_id) 
VALUES ((SELECT id FROM customers WHERE phone = '380931119988'));

WITH last_order_dessert AS (
    SELECT id FROM orders ORDER BY order_date DESC LIMIT 1
)
INSERT INTO order_items (order_id, menu_id, quantity) 
VALUES ((SELECT id FROM last_order_dessert), (SELECT id FROM menu WHERE name_en = 'Cheesecake'), 1);

INSERT INTO work_schedule (staff_id, work_date, shift)
SELECT id, 
       (CURRENT_DATE + ((8 - EXTRACT(DOW FROM CURRENT_DATE)::int) % 7))::DATE, 
       CASE WHEN position = 'Бариста' THEN 'Ранкова'
            WHEN position = 'Офіціант' THEN 'Денна'
            ELSE 'Вечірня'
       END
FROM staff;

INSERT INTO menu (type, name_en, name_uk, price) 
VALUES ('drink', 'Flat White', 'Флет Вайт', 85.00);


-- 3)
UPDATE menu 
SET price = 75.00 
WHERE name_en = 'Espresso';

UPDATE staff 
SET phone = '380501234567', address = 'Київ, вул. Грушевського, 5'
WHERE full_name = 'Анастасія Грищенко' 
AND position = 'Кондитер'
AND NOT EXISTS (SELECT 1 FROM staff WHERE phone = '380501234567');

UPDATE staff 
SET phone = '380669876543'
WHERE full_name = 'Дмитро Лисенко' 
AND position = 'Бариста'
AND NOT EXISTS (SELECT 1 FROM staff WHERE phone = '380669876543');

UPDATE customers 
SET discount = 10 
WHERE full_name = 'Олександр Кравченко';

UPDATE menu 
SET name_en = 'Creamy White', name_uk = 'Кремовий Вайт' 
WHERE name_en = 'Flat White';

UPDATE menu 
SET name_en = 'French Macaron', name_uk = 'Французький Макарун' 
WHERE name_en = 'Macaron';

-- 4)
DELETE FROM menu 
WHERE name_en = 'Cheesecake';

DELETE FROM staff 
WHERE full_name = 'Іван Петренко' 
AND position = 'Офіціант';

DELETE FROM staff 
WHERE full_name = 'Дмитро Лисенко' 
AND position = 'Бариста';

DELETE FROM customers 
WHERE full_name = 'Олександр Кравченко';

DELETE FROM order_items 
WHERE menu_id = (SELECT id FROM menu WHERE name_en = 'French Macaron');

DELETE FROM orders 
WHERE id = 15;

-- 5)
SELECT * FROM menu WHERE type = 'drink';

SELECT * FROM menu WHERE type = 'dessert';

SELECT * FROM staff WHERE position = 'Бариста';

SELECT * FROM staff WHERE position = 'Офіціант';

SELECT o.id AS order_id, o.customer_id, o.order_date, oi.quantity
FROM orders o
JOIN order_items oi ON o.id = oi.order_id
JOIN menu m ON oi.menu_id = m.id
WHERE m.name_en = 'French Macaron' AND m.type = 'dessert';

SELECT o.id AS order_id, o.order_date, oi.menu_id, m.name_en, oi.quantity
FROM orders o
JOIN customers c ON o.customer_id = c.id
JOIN order_items oi ON o.id = oi.order_id
JOIN menu m ON oi.menu_id = m.id
WHERE c.full_name = 'Олександр Кравченко';