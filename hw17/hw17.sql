-- ������� ��� ���������� �� ������� Departaments.
SELECT
  *
FROM employees.departments


-- ������� ����� � ������� �����������, ���� ������ ������.

SELECT
  first_name, last_name, hire_date
FROM employees.employees

-- ������� ����� � ������� �����������, ������� ������� �������� �������, ��������� (��� �������� ������ ��� � ������� ������, �� ����� ����, ����� ���� �������� �� ������ ��� ������ � ���)

SELECT
  e.first_name, e.last_name, s.salary, t.title
FROM employees.employees e
  INNER join employees.salaries s on (e.emp_no = s.emp_no)
  inner join employees.titles t on (e.emp_no = t.emp_no) 
  group by e.emp_no

-- ������� ����� � ������� �����������, ������� ��������� �������� �������, ���������.

SELECT
  e.first_name, e.last_name, sum(s.salary), t.title
FROM employees.employees e
  INNER join employees.salaries s on (e.emp_no = s.emp_no)
  inner join employees.titles t on (e.emp_no = t.emp_no) 
  GROUP by e.emp_no

-- ������� �����, �����, �������, ���� ������ �� ������, ��� ��� �����������, ������� ���� ������� �� ������ �  1992 ����.

SELECT
 d.dept_name, e.first_name, e.last_name, e.hire_date
FROM employees.employees e
  INNER JOIN employees.dept_emp de on (e.emp_no = de.emp_no)
  INNER join employees.departments d on (de.dept_no = d.dept_no)
  where year(e.hire_date) = 1992

-- ������� ����� �����������, ������� ������� ���������� �� ����� �K� ��� �L�.

SELECT
  first_name
FROM employees.employees
  where last_name like "K%"
  or last_name like "L%"

-- ������� �������, ���, ������ �������� ������� ��������� ����� ����� �������������, ���������� ���� ����������.

SELECT
  e.first_name, e.last_name, sum(s.salary) sal, t.title
FROM employees.employees e
  INNER join employees.salaries s on (e.emp_no = s.emp_no)
  inner join employees.titles t on (e.emp_no = t.emp_no) 
  GROUP by e.emp_no
  having sal BETWEEN 147923 and 460338

-- ������� ���������� ����������� � ������ ������.

SELECT
  d.dept_name, count(1)
FROM employees.dept_emp de
  inner join employees.departments d on (de.dept_no = d.dept_no)
  GROUP by d.dept_no

-- �� ������ �Intelligent Decision Support Systems� � ������� ��������� ������� �������� �Intelligent Systems�.

select CONCAT(SUBSTRING_INDEX("Intelligent Decision Support Systems", " ", 1), " ", SUBSTRING_INDEX("Intelligent Decision Support Systems", " ", -1)) string

-- ������ ������� ����.

select current_date()

-- ������� � ���������� ������� ������.

SELECT
  dept_name
FROM employees.departments
  ORDER by dept_name asc

-- ������� ��� ���������� � ��� �����������, ������� ����������� ����� 20 ��� � ��� ��� �������� � ��������.

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

-- ������� ������� �������� ����������� ������� ������ �� 2000 ���.

SELECT
  d.dept_name, avg(s.salary)
FROM employees.dept_emp de
  INNER JOIN employees.departments d on (d.dept_no = de.dept_no)
  INNER join employees.salaries s on (de.emp_no = s.emp_no)
  where year(s.from_date) = 2000
  GROUP by d.dept_name

-- ������� ���������� ���������� �����������.

SELECT
  count(1)
FROM employees.dept_emp
  WHERE to_date > CURRENT_DATE()



