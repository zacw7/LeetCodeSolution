# 585. Investments in 2016

**Medium**

[Original Page](https://leetcode.com/problems/investments-in-2016/)

SQL Schema >
```
CREATE TABLE IF NOT EXISTS insurance (PID INTEGER(11), TIV_2015 NUMERIC(15,2), TIV_2016 NUMERIC(15,2), LAT NUMERIC(5,2), LON NUMERIC(5,2) )
Truncate table insurance
insert into insurance (PID, TIV_2015, TIV_2016, LAT, LON) values ('1', '10', '5', '10', '10')
insert into insurance (PID, TIV_2015, TIV_2016, LAT, LON) values ('2', '20', '20', '20', '20')
insert into insurance (PID, TIV_2015, TIV_2016, LAT, LON) values ('3', '10', '30', '20', '20')
insert into insurance (PID, TIV_2015, TIV_2016, LAT, LON) values ('4', '10', '40', '40', '40')
```

Write a query to print the sum of all total investment values in 2016 (__TIV_2016__), to a scale of 2 decimal places, for all policy holders who meet the following criteria:
1. Have the same __TIV_2015__ value as one or more other policyholders.
2. Are not located in the same city as any other policyholder (i.e.: the (latitude, longitude) attribute pairs must be unique).

##### Input Format:
The ___insurance___ table is described as follows:
```
| Column Name | Type          |
|-------------|---------------|
| PID         | INTEGER(11)   |
| TIV_2015    | NUMERIC(15,2) |
| TIV_2016    | NUMERIC(15,2) |
| LAT         | NUMERIC(5,2)  |
| LON         | NUMERIC(5,2)  |
```
where __PID__ is the policyholder's policy ID, __TIV_2015__ is the total investment value in 2015, __TIV_2016__ is the total investment value in 2016, __LAT__ is the latitude of the policy holder's city, and __LON__ is the longitude of the policy holder's city.

##### Sample Input
```
| PID | TIV_2015 | TIV_2016 | LAT | LON |
|-----|----------|----------|-----|-----|
| 1   | 10       | 5        | 10  | 10  |
| 2   | 20       | 20       | 20  | 20  |
| 3   | 10       | 30       | 20  | 20  |
| 4   | 10       | 40       | 40  | 40  |
```

##### Sample Output
```
| TIV_2016 |
|----------|
| 45.00    |
```

##### Explanation
```
The first record in the table, like the last record, meets both of the two criteria.
The TIV_2015 value '10' is as the same as the third and forth record, and its location unique.

The second record does not meet any of the two criteria. Its TIV_2015 is not like any other policyholders.

And its location is the same with the third record, which makes the third record fail, too.

So, the result is the sum of TIV_2016 of the first and last record, which is 45.
```
