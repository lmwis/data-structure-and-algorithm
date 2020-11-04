# [MYSQL]
一个页的大小一般是16K，也就是16384字节
一行最多 65535个数据，除了BLOGS之外

# 数据组织方式
#### Innodb
聚集索引
插入的时候按照主键排序，影响插入性能，提高查询性能
**页目录**
![552ae3b8dc718659ba2214daa506e24b.png](en-resource://database/2124:1)
**目录页**
![6e0ba5e197471265a58489314f2234aa.png](en-resource://database/2126:1)
在插入的时候会构造B+树
##### B+树
**Innodb底层存储数据的格式就是B+树**
双亲节点会冗余一份叶子节点的数据
#### MylSAM
堆表
#### 索引
核心是写入数据的排序
URL反写存入数据库从而用上索引
# 索引
- 索引是一种数据结构
- 是排好序的快速查找的数据结构
- 索引影响where后面的查找和orderby后面的排序
- 一般都是B树组织结构的索引
## 优势劣势
- 提高数据检索效率，降低数据库IO成本
- 降低数据排序成本，降低CPU消耗
*********
- 需要占额外的空间（类似空间换时间的感觉？）
- 提高了查询速度，降低了更新表的速度，因为更新数据时还要同时更新索引
- 索引的建立需要花一定的时间去考虑如何建立最优秀的索引
## 哪些情况需要创建索引
##### 1.主键自动建立唯一索引
##### 2.频繁作为查询条件的字段应该创建索引
##### 3.查询中与其他表关联的字段，外键关系建立索引
##### 4.查询中排序的字段
##### 5.查询中统计或者分组字段
## 哪些情况不需要创建索引
##### 1.表记录太少
##### 2.检测增删改的表和字段
##### 3.数据重复且平均分配的值建索引的意义不大
# SQL性能下降的原因
 - 查询语句写的烂，查了没必要的数据
 - 索引失效（where和orderby后面跟的语句不符合索引）
 - 关联查询太多join
 - 服务器调优及各个参数设置（缓冲、线程数）
# SQL执行加载顺序
机读顺序，从From开始
![e2ed5bf70de9002b9a78fef1d93b0e46.png](en-resource://database/2136:1)
# 七种Join理论
#### inner join
![8d3a9afa56046334684f09ff7d19838d.png](en-resource://database/2138:1)
#### left join
![d61b8052eba3b0beded8761d5a69cf9b.png](en-resource://database/2140:1)
#### right join
![f95c8cf3470a687e3d970f4786942bae.png](en-resource://database/2142:1)
#### left join (where B.key IS NULL)
![39a05adeebf0fcd49b180ca7cc5a0950.png](en-resource://database/2144:1)
#### right join (where A.key IS NULL)
![56a8e673a123400c7415e7a2df1d0efb.png](en-resource://database/2150:1)
#### full outer join
mysql不支持
![5920068d0694296c9cee735a822c47f2.png](en-resource://database/2146:1)
#### full outer join (where A.key IS NULL OR B.key IS NULL)
mysql不支持
![f7fbfc359e27aa5699ef83732ab99957.png](en-resource://database/2148:1)
#### mysql不支持full outer join，用union连接查询去重实现
![fc675eda3ed8ab439ca59822eacf39b4.png](en-resource://database/2152:1)
# explain + SQL
- 1.表的读取顺序 **id**
- 2.数据读取操作的操作类型
- 3.哪些索引可以使用
- 4.哪些索引实际被使用
- 5.表之间的引用
- 6.每张表有多少行被优化器查询
#### id
- 包含一组数字，id全部相同，执行顺序由上至下
- id全部不同，如果是子查询，id越大越先执行
- 有相同与不相同，id越大越先执行，id相同顺序由上执行
#### select_type
- 查询的类型，主要是用于区别普通索引、联合索引、子查询等复杂查询
#### type
**访问类型排序**
可取值：
![ad018ecb59a95e67408b01bccff61432.png](en-resource://database/2128:1)

最好->最坏的查询类型
system>const>eq_ref>ref>range>index>all
一般来说优化到range和ref级别就够了
- all：全表扫描
- system：表只有一行记录，一般是系统表
- const：表示通过索引一次就找到了，主要通过主键索引或者唯一索引，只匹配一行数据，所以MYSQL将查询转化为一个常量
- eq_ref：唯一性索引扫描，对于每个索引，表中只有一条与之对应。常见于主键或者唯一索引扫描
- ref：非唯一索引扫描，返回匹配某个单独值的所有行。本质上是索引扫描，但可能返回匹配到的多个行
- range：只检索给定范围的行，比如SQL中使用了between，<，>，in等查询
- index：比全表扫描好一些，全索引扫描，比如只查主键
- all：全表扫描，出现全表扫描需要优化
**一般优化为range或ref就可以了**
#### possible_keys
- 显示可能应用在这张表中的索引，一个或多个
#### key
- 实际使用到的索引，为NULL则没有使用索引
#### key_len
- 表示索引中使用的字节数。在不损失精确性的情况下，长度**越短越好**。并非实际使用长度，索引字段的最大可能长度
#### ref
- 显示索引的那一列被使用了，如果可能的话，是一个常数。哪些列或常量被用于查找索引列上的值
#### row
- 根据表统计信息及索引选用情况。找到所需记录大概要读取的行数（越小越好）
#### extra
额外说明
- **using filesort**： 文件排序，搜索出来之后又进行了排序，出现此字段**需要进行优化**
- **using temporary**：创建了临时表保存中间结果，MySQL在对查询结果排序时使用临时表。常见于order by和分组查询group by.**核心就是要按照索引顺序进行group by，需要进行优化**
- **using index**：表示相应的select操作中使用了覆盖索引，避免了查找，而直接读取数据。**性能不错**
- **using joinfuffer**：使用了连接缓存
- **impossible where**：where子句的值总是false
# 索引优化
## 索引优化举例
#### 单表查询
- 1.range后的索引会失效
#### 两表使用join连接
**建相反键**，即左连接给右表建索引。右连接给左表建索引
#### 三表使用join连接
- 同两表连接优化原理
- 优先优化内层循环
## 索引优化原则
#### 1.全值匹配我最爱
#### 2.最佳左前缀法则
如果索引了多列，要遵守最左前缀法则。指的是查询从索引的最左前列开始并且**不跳过索引中的列**
#### 3.不在索引列上做任何操作（计算、函数、(自动or手动)类型转换，会导致索引失效而转向全表扫描
sum left 等函数
#### 4.存储引擎不能使用索引中范围条件右边的列R
**范围之后全失效**
#### 5.尽量使用覆盖索引(只访问索引的查询(索引列和查询列一致))减少select *
 extra：uning index
#### 6. mysql在使用不等于(!=或者<>)的时候无法使用索引会导致全表扫描R
#### 7. is null ,is not null也无法使用索引
#### 8. like以通配符开头('%abc...')mysql索引失效会变成全表扫描的操作
百分like加右边
优化办法：**使用覆盖索引（建的索引和查询的字段最好顺序字段一致）**
#### 9.字符串不加单引号索引失效回
varchar绝对不能失去单引号，本质上是索引隐式的类型转换
#### 10.少用or,用它来连接时会索引失效11.小总结


【优化总结口诀】
全值匹配我最爱，最左前缀要遵守；
带头大哥不能死，中间兄弟不能断；
索引列上少计算，范围之后全失效；
Like百分写最右，覆盖索引不写星；
不等空值还有or，索引失效要少用；
VAR引号不可丢，SQL高级也不难！

## 面试相关
and 并列和顺序无关，不影响索引使用。
## 一般性建议
- 对于单键索引，尽量选择针对当前query过滤性更好的索引
- 在选择组合索引的时候，当前Query中过滤性最好的字段在索引字段顺序中，位置越靠左越好
- 在选择组合索引的时候，尽量选择可以能够包含当前query中的where字句中更多字段的索引
#### 小表驱动大表
当B属数据集小于A的数据集，用in优于exists
#### orderby 优化
尽量使用index排序，不使用filesort排序
## 索引排序总结
- MYSQL两种排序方式：usingfilesort和usingindex
- MYSQL能为排序与查询使用相同的索引
## 调优步骤
![bf8c0509d982623ed35c30d8b7b32fcd.png](en-resource://database/2166:1)
#### 慢查询
查看是否开启慢查询
```mysql
show variables like '%slow_query_log%';
```
开启慢查询
```mysql
set global slow_query_log=1;
```
慢查询时间
**long_query_time**，默认为10秒
```mysql
show variables like 'long_query_time%'
```
可以使用命令行修改，也可以在my.cnf修改
## MYSQL函数
批量向数据库插入测试数据
```mysql
DELIMITER $$ // 使sql结束符号变成两个$
CREATE FUNCTION rand_string(n INT) RETURNS VARCHAR(255)

BEGIN

RETURN xxx

END $$
```
## SQL诊断
开启profiles记录sql
```mysql
show variables like 'profiling' // 查看是否开启
set profiling=on
```
查看 profiles
```mysql
show profiles
```
![96dc900de46ffc85c6c61c28c532f7cd.png](en-resource://database/2168:0)

查看具体sql生命周期耗时
```mysql
show profiles cpu,block io for query id
```
其他参数
![4907bb84722339561a201d7c690eeea4.png](en-resource://database/2170:0)
#### 何时需要优化
出现以下四种情况
![b5028c694f8681b91d181bb302b5d2bc.png](en-resource://database/2172:0)
#### 全局查询日志
**只可测试环境用，不可生产环境用**
会将所有的sql查询记录到mysql.general_log表中
开启
```mysql
set global general_log=1;
set global log_output='TABLE';
```
# 锁
- 读锁（共享锁），写锁（排它锁）
- 行锁，表锁
**读锁会阻塞别人的写，但不会阻塞读，写锁会把别人的读和写都阻塞**
#### 读锁（共享锁）
读写锁偏向于Myisam，锁粒度大，并发度最低
```mysql
lock table table_name read
```
解锁
```mysql
unlock tables // 解锁
```
##### 规则
- 1.谁加锁谁就只能读该表，而不能写（修改和插入）
- 2.其他人也可以读该表，但执行写入会进入阻塞，当加锁用户解锁后立即执行写操作
#### 写锁（排他锁）
```mysql
lock table table_name write
```
##### 规则
- 1.加锁方只可以读和写该表，不能操作其他表
- 2.其他人不能执行的所有操作都会被阻塞，释放后立即执行
#### 读写锁结论
Myisam的读写锁调度时写优先，这也是myisam不适合做写为主表的引擎
#### 行锁
偏向于InnoDB，开销大，加锁慢，会出现死锁，发送锁冲突的概率最低，并发度最高
- myisam和innnodb最大区别就是**支持事务且采用了行级锁**