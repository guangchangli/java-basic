synchronized
sync(obj)
标记obj 第一次 记录当前线程 id 偏向锁(偏向第一次)
如果发生线程争用 升级为自旋锁 其他线程 自旋 10次
10次之后升级为重量级锁  去os申请资源 os不占用cpu

自旋锁 用户态 不经过内核 占用cpu
执行时间长 线程多  重量级锁 os 
执行时间短(加锁代码) 线程数少 自旋锁


线程同步 锁定方法和非锁定方法同步执行
synchronized(obj)
obj 不能用String 常量 Integer Long 