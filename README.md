# Dormitory_warranty_system
宿舍报修系统



fixer		维修人员表

~~~sql
CREATE TABLE fixer(
	fixer_id INT PRIMARY KEY AUTO_INCREMENT,
	user_name VARCHAR(20),
	PASSWORD VARCHAR(20),
	NAME VARCHAR(20),
	shenfen_num VARCHAR(50),
	phone VARCHAR(20),
	STATUS INT 
)
~~~



fix		   报修申请表

~~~sql
CREATE TABLE fix(
	fixId INT PRIMARY KEY AUTO_INCREMENT,
	user_name VARCHAR(20),
	gender VARCHAR(10),
	num VARCHAR(20),
	phone VARCHAR(20),
	DATE VARCHAR(20),
	object VARCHAR(100),
	info VARCHAR(500),
	image VARCHAR(500),
	STATUS INT,
    user_id int
)
~~~



用户(学生)

```
1代表还没申请    
2代表已经申请,等待维修人员接受   
3代表已经接受  
4代表已经完成
```

index2		宿舍报修申请表



维修人员		admin.boluo.com

index1		查看申请人员	+	接单

接单	把数据存到handle表中	再把用户status改成3

index2		我的任务	+	完成任务

显示	完成的话把handle表状态码从1改成2		再把用户status改成4

index5		完成过的单子

查看handle表中状态码为2的数据





admin.boluo.com		是维修人员的页面

fixer.boluo.com			是管理员的页面		---   

因为cookie的跨域问题,所以把他俩互换了一下



出Bug了吗?



handle表		维修人员接受维修申请之后,把数据存到这个表中

~~~sql
CREATE TABLE handle(
	handle_id INT PRIMARY KEY AUTO_INCREMENT,
	user_id INT,
	user_name VARCHAR(20),
	fix_id INT,
	handle_status INT
)

~~~































