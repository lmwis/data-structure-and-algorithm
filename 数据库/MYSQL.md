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