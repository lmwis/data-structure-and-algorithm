# Redis相关题目
### 1.内存满了淘汰策略
https://juejin.cn/post/6844904166154846221
### 2.LRU原理和Redis实现
https://zhuanlan.zhihu.com/p/34133067
### 3.redis事务
以multi开始exec结束，中间的所有指令一次性按顺序执行
### 4.redis rehash时机
负载因子计算：
```
负载因子=
       哈希表已保存节点数量/
       哈希表大小
       load_factor = ht[0].used / ht[0].size
```
- 服务器目前没有在执行BGSAVE(后台RDB)命令或者BGREWRITEAOF(后台AOF)命令，并且哈希表的负载
  因子大于等于1。
- 服务器目前正在执行BGSAVE命令或者BGREWRITEAOF命令，并且哈希表的负载因
  子大于等于5
- 负载因子小于0.1时执行收缩
### 5.跳跃表
### 6.redis分片