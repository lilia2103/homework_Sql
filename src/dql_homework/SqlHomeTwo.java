package dql_homework;

//1
select Salesman.namee as "salesman", Customer.customer_name, Customer.city
        from Salesman, Customer
        where Salesman.city = Customer.city;

//2
        select orders.ord_no, orders.purch_amt, customer.cust_name, customer.city
        from orders, customers
        where orders.customer_id = customer.customer_id
        and orders.purch_amt between 500 and 2000;

//3
        select customer.customer_name, customer.city, salesman.namee, salesman.commission
        from customer
        join salesman
        on customer.salesman_id = salesman.salesman_i

//4
        select customer.customer_name, customer.city, salesman.namee, salesman.commission
        from customer
        join salesman
        on customer.salesman_id = salesman.salesman_id
        where salesman.commission > 0.12

//5
        select customer.customer_name, customer.city, salesman.namee, salesman.city, salesman.commission
        from customer
        join salesman
        on customer.salesman_id = salesman.salesman_id
        where customer.city <> salesman.city
        and salesman.commission > 0.12

//6
        select orders.order_no, orders.order_date, orders.purch_amt, customer.customer_name, customer.grade, salesman.namee, salesman.commission
        from orders
        join customer
        on orders.customer_id = customer.customer_id
        join salesman
        on customer.salesman_id = salesman.salesman_id

//7
        select *
        from orders
        natural join customer
        natural join salesman;

//8
        select customer.customer_name, customer.city, customer.grade, salesman.namee, salesman.city
        from customer
        join salesman
        on customer.salesman_id = salesman.salesman_id
        order by customer.customer_id

//9
        select customer.customer_name, customer.city, customer.grade, salesman.namee, salesman.city
        from customer
        left outer join salesman
        on customer.salesman_id = salesman.salesman_id
        where customer.grade < 300
        order by customer.customer_id

//10
        select customer.customer_name, customer.city, orders.order_no, orders.order_date, orders.purch_amt
        from customer
        left outer join orders
        on orders.customer_id = customer.customer_id
        order by orders.order_date

//11
        select customer.customer_name, customer.city, orders.order_no, orders.order_date, orders.purch_amt, salesman.namee, salesman.commission
        from customer
        left outer join orders
        on customer.customer_id = orders.customer_id
        left outer join salesman
        on salesman.salesman_id = orders.salesman_id

//12
        select customer.customer_name, customer.city, customer.grade, salesman.namee, salesman.city
        from customer
        right outer join salesman
        on customer.salesman_id = salesman.salesman_id
        order by customer.salesman_id

//13
        select customer.customer_name, customer.city, customer.grade, orders.order_no, orders.order_date, orders.purch_amt
        from customer
        right outer join salesman
        on customer.salesman_id = salesman.salesman_id
        right outer join orders
        on orders.customer_id = customer.customer_id

//14
        select customer.customer_name, customer.city, customer.grade, orders.order_no, orders.order_date, orders.purch_amt
        from customer
        right outer join salesman
        on customer.salesman_id = salesman.salesman_id
        right outer join orders
        on orders.customer_id = customer.customer_id
        where orders.purch_amt >= 2000
        and customer.grade is not null;


//15

        select customer.customer_name, customer.city, orders.order_no, orders.order_date, orders.purch_amt
        from customer
        left outer join orders
        on customer.customer_id = orders.customer_id

//16
        select customer.customer_name, customer.city, orders.order_no, orders.order_date, orders.purch_amt
        from customer
        left outer join orders
        on customer.customer_id = orders.customer_id
        where customer.grade is not null

//17
        select *
        from salesman
        cross join customer

//18
        select *
        from salesman
        cross join customer
        where salesman.city = customer.city


//19
        select *
        from salesman
        cross join customer
        where salesman.city = customer.city
        and customer.grade is not null

//20
        select *
        from salesman
        cross join customer
        where salesman.city <> customer.city
        and customer.grade is not null

//21
        select *
        from item_mast
        inner join company_mast
        on item_mast.pro_com = company_mast.com_id

//22
        select c.com_name, i.pro_name, i.pro_price
        from item_mast i
        inner join company_mast c
        on i.pro_com = c.com_id

//23
        select c.com_name, avg(i.pro_price) as "Average price"
        from item_mast i
        inner join company_mast c
        on i.pro_com = c.com_id
        group by c.com_name
        order by "Average price"

//24
        select c.com_name, avg(i.pro_price) as "Average price"
        from item_mast i
        inner join company_mast c
        on i.pro_com = c.com_id
        group by c.com_name
        having avg(i.pro_price) >= 350
        order by "Average price"

//25

        select i.pro_name, i.pro_price, c.com_name
        from item_mast i
        inner join company_mast c
        on i.pro_com = c.com_id
        and i.pro_price =
        (
        select max(i.pro_price)
        from item_mast i
        where i.pro_com = c.com_id
        )
        order by i.pro_price

//26

        select  e.*, d.*
        from emp_details e
        inner join emp_department d
        on e.emp_dept = d.dpt_code
//27
        select e.emp_fname, e.emp_lname, d.dpt_name, d.dpt_allotment
        from emp_details e
        inner join emp_department d
        on e.emp_dept = d.dpt_code
        order by d.dpt_allotmen

//28

        select e.emp_fname, e.emp_lname
        from emp_details e
        inner join emp_department d
        on e.emp_dept = d.dpt_code
        and d.dpt_allotment > 50000

//29
        select d.dpt_name
        from emp_details e
        inner join emp_department d
        on e.emp_dept = d.dpt_code
        group by d.dpt_name
        having count(*) > 2