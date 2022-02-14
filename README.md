Lab2 readme doc written by Lin Wencheng.
-It's a simple Java project powered by Maven.

Q1: What database did I select?
-chinook

Q2: Which table are you going to represent as a Java POJO?
-Artist

Q3: What fields did you select to map from table to Java class?
-title,artistId

Q4: What scope(s) did you select and why?
-the artist datetable I choosed beacause It's simple to try basic JDBC's operations.

Two kinds of test case：
①：Validation
1.validate @NotNull
-here is result（artistId's value is null）
![image](https://user-images.githubusercontent.com/22018496/153788488-27085f8e-ef61-450d-b9a6-f958b2883106.png)

-here is result (artistId's value is not null)
![image](https://user-images.githubusercontent.com/22018496/153789258-3f769988-b915-4091-83ae-4eb813cf1f66.png)

②：JDBC's operations
-Create
![image](https://user-images.githubusercontent.com/22018496/153791293-d5230067-fc8e-4ca6-bd69-ecc986610552.png)

-Update
![image](https://user-images.githubusercontent.com/22018496/153792024-915ce726-1dfb-4531-a84c-f6ca9bef62db.png)

-Read
![image](https://user-images.githubusercontent.com/22018496/153792351-8a91e602-cbc5-469c-88ab-b181280dcd84.png)

-Delete
![image](https://user-images.githubusercontent.com/22018496/153792760-cab6be7c-c0c1-41a1-b38f-857d391cc410.png)
