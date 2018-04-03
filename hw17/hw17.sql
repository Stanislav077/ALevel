-- Вывести всю информацию из таблицы Departaments.
SELECT
  *
FROM employees.departments


-- Выбрать имена и фамилии сотрудников, дату начала работы.

SELECT
  first_name, last_name, hire_date
FROM employees.employees

-- Выбрать имена и фамилии сотрудников, указать годовую зарплату каждого, должность (там зарплата каждый год у каждого разная, по этому взял, чтобы была зарплата за первый год работы у них)

SELECT
  e.first_name, e.last_name, s.salary, t.title
FROM employees.employees e
  INNER join employees.salaries s on (e.emp_no = s.emp_no)
  inner join employees.titles t on (e.emp_no = t.emp_no) 
  group by e.emp_no

-- Выбрать имена и фамилии сотрудников, указать суммарную зарплату каждого, должность.

SELECT
  e.first_name, e.last_name, sum(s.salary), t.title
FROM employees.employees e
  INNER join employees.salaries s on (e.emp_no = s.emp_no)
  inner join employees.titles t on (e.emp_no = t.emp_no) 
  GROUP by e.emp_no

-- Вывести отдел, имена, фамилии, дату начала их работы, для тех сотрудников, которые были приняты на работу в  1992 году.

SELECT
 d.dept_name, e.first_name, e.last_name, e.hire_date
FROM employees.employees e
  INNER JOIN employees.dept_emp de on (e.emp_no = de.emp_no)
  INNER join employees.departments d on (de.dept_no = d.dept_no)
  where year(e.hire_date) = 1992

-- Вывести имена сотрудников, фамилии которых начинаются на буквы «K» или «L».

SELECT
  first_name
FROM employees.employees
  where last_name like "K%"
  or last_name like "L%"

-- Вывести фамилию, имя, размер зарплаты которых находится между двумя произвольными, выбранными нами значениями.

SELECT
  e.first_name, e.last_name, sum(s.salary) sal, t.title
FROM employees.employees e
  INNER join employees.salaries s on (e.emp_no = s.emp_no)
  inner join employees.titles t on (e.emp_no = t.emp_no) 
  GROUP by e.emp_no
  having sal BETWEEN 147923 and 460338

-- Вывести количество сотрудников в каждом отделе.

SELECT
  d.dept_name, count(1)
FROM employees.dept_emp de
  inner join employees.departments d on (de.dept_no = d.dept_no)
  GROUP by d.dept_no

-- Из строки «Intelligent Decision Support Systems» с помощью строковых функций получить «Intelligent Systems».

select CONCAT(SUBSTRING_INDEX("Intelligent Decision Support Systems", " ", 1), " ", SUBSTRING_INDEX("Intelligent Decision Support Systems", " ", -1)) string

-- Узнать текущую дату.

select current_date()

-- Вывести в алфавитном порядке отделы.

SELECT
  dept_name
FROM employees.departments
  ORDER by dept_name asc

-- Выбрать всю информацию о тех сотрудниках, которые проработали более 20 лет и все еще работают в компании.

SELECT
  e.first_name, e.last_name, e.birth_date, e.hire_date, de.from_date, de.to_date, s.salary, d.dept_name, t.title
FROM employees.employees e
  INNER join employees.dept_emp de on (e.emp_no = de.emp_no)
  INNER join employees.salaries s on (de.emp_no = s.emp_no)
  INNER join employees.departments d on (d.dept_no = de.dept_no)
  INNER join employees.titles t on (t.emp_no = e.emp_no)
  where TIMESTAMPDIFF(year, e.hire_date, CURRENT_DATE()) > 20
  AND de.to_date > CURRENT_DATE
  GROUP by e.emp_no

-- Вывести среднюю зарплату сотрудников каждого отдела за 2000 год.

SELECT
  d.dept_name, avg(s.salary)
FROM employees.dept_emp de
  INNER JOIN employees.departments d on (d.dept_no = de.dept_no)
  INNER join employees.salaries s on (de.emp_no = s.emp_no)
  where year(s.from_date) = 2000
  GROUP by d.dept_name

-- Указать количество работающих сотрудников.

SELECT
  count(1)
FROM employees.dept_emp
  WHERE to_date > CURRENT_DATE()



