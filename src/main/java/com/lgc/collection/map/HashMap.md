# HashMap

  **哈希桶 =哈希值+哈希桶+碰撞-->哈希表**

  **参考电话本，数据碰撞**

  **异或是不进位的加法 这个好记**

  

1. #### 数组（桶）长度为什么默认是2的幂

   ```
   hashmap创建出来是一个空的，在put的时候校验会将容量向上取整为2的幂
   indexFor(h,length){
   		return h & (lenhth-1)
   }
   只有length是2^n  2^n-1 和 key & 可以快速算出可以均匀散裂到各个桶里
   ```

2. #### Jdk8 hashMap 链表长度大于8才转换为红黑树

   ```
   根据柏松分布大于8概率很小，基本散列均匀不会达到8
   java8 在扩容的时候去保证了顺序（其实就是低位和高位两个桶） 但是并发的时候还是不会同步
   ```

3. ### java7

   ```
   基于哈希的桶和链表
   多线程的环境下 tranfer 扩容的时候会将旧的数据再次hash 散列 
   这个时候可能会造成环形链表 以至于在你去查找数据的时候查不到数据一直在循环 造成死锁
   退化成链表 太耗性能
   ```

4. 红黑树

   ```
   一种接近于平衡的二叉树
   性质
   每个节点要么是黑色，要么是红色
   根结点是黑色
   每个叶子结点是黑色
   每个红色结点的两个子节点一定都是黑色
   任意一节点到每个叶子子节点的路径都包含数量相同的黑节点
   ```

    

   ```
   左旋：以某个结点作为支点(旋转结点)，其右子结点变为旋转结点的父结点，右子结点的左子结点变为旋转结点的右子结点，左子结点保持不变。如图3。
   右旋：以某个结点作为支点(旋转结点)，其左子结点变为旋转结点的父结点，左子结点的右子结点变为旋转结点的左子结点，右子结点保持不变。如图4。
   变色：结点的颜色由红变黑或由黑变红。
   ```

   ```
   左旋只影响旋转结点和其右子树的结构，把右子树的结点往左子树挪了。
   右旋只影响旋转结点和其左子树的结构，把左子树的结点往右子树挪了。
   ```

   