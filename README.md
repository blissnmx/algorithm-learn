# algorithm-learn

# 老码农之剑指offer算法学习demo记录

### binary.整数除法.java

### 二进制（binary）

#### 总结

+ 编程语言（如 Java ）可能定义了多种占据不同内存空间的整数类型，内存空间不同的整数类型的值的范围也不相同。
  整数在计算机中使用二进制形式表示，每位不是0就是1。位运算是对二进制整数的运算，包括与运算、或运算、非运算、异或运算、左移运算和右移运算。只有深刻理解每种位运算的特点才能在需要的时候灵活地应用合适的位运算解决相应的问题。

+ 与：1+0=0；1+1=1；0+0=0

+ 或：1+0=1；1+1=1；0+0=0

+ 非：单个二进制数位运算，按位取反

+ 异或：不同得1，相同得0

+ 左移n位：左边n位丢弃，右边补n个零，相当于*2^n

#### 题目

1. 二进制中1的个数
2. 二进制加法
3. 数组中出现一次的数值
4. 单词长度的最大乘积
5. 数组中出现一次的数值

### 数组（array）

#### 总结

+ 若数组是排序的，那么可以使用双指针在数组中查找两个和为指定值的数组
+ 若数组中所有数字都是整数，可以用双指针找出和为指定值的子数组
+ 若题中没有限定数组中数字都是正数，可以尝试从第一个数字开始累加前面若干数字之和，两个累加的和的差值对应一个子数组之和

#### 题目

1. 乘积小于k的子数组
2. 二维子矩阵的和
3. 和大于等于k的最短子数组
4. 左右两边子数组的和相等
5. 排序数组中两个数字之和
6. 数组中和为0的三个数字
7. 零和1个数相同的子数组

### 字符串（str）

#### 总结

+ 如果两个字符串包含的字符及每个字符出现的次数都相同，只是字符出现的顺序不同，那么他们就是一组变位词。通常可以用一个哈希表来统计每个字符出现的次数，有了哈希表就很容易判断两个字符是不是一组变位词。
+ 回文是一类特殊的字符串。不管是从前往后还是从后往前读取其中每一个字符，得到的内容都是一样的。通常可以用两个指针来判断一个字符串是不是回文，要么两个指针从字符串的两端开始向中间移动，要么两个指针从中间开始向两端移动。

#### 题目

1. 不含重复字符的最长子字符串
2. 含有所有字符的最短字符串
3. 回文子字符串的个数
4. 字符串中的变位词
5. 字符串中的所有变位词的起始下标
6. 有效的回文
7. 最多删除一个字符得到回文

### 链表（linknode)

#### 总结

+ 链表的数据结构，由于节点在内存中的地址不连续，访问某个节点必须从头结点开始住逐个遍历节点，因此在链表中找到某个节点的时间复杂度是O(n)。
+ 如果一个操作可能产生新的头节点，则可以尝试在链表的最前面添加一个哨兵节点来简化代码逻辑，降低代码出现问题的可能性
+ 双指针是解决与链表相关的面试题的常用技术。前后双指针思路是让一个指针提前走若干步，然后将第2个指针指向头节点，两个指针以相同速度一起走。快慢双指针让快的指针每次走两步而慢的指针每次直走一步
+ 大部分与链表相关的面试题都是考察单向链表的操作。单向链表的特点是只能从前往后遍历而不能从后往前遍历。如果不得不从后往前遍历链表，则可以把链表反转之后再遍历。
+ 双向链表要确认前后指针都指向正确的位置
+ 循环链表要避免死循环问题，所有节点遍历完就要跳出循环

#### 题目

1. 删除倒数第k个结点
2. 反转链表
3. 两个链表的第一个重合结点
4. 链表中环的入口结点
5. 链表中的数字相加
6. 回文链表
7. 重排链表

### 哈希表

#### 总结

+ 添加、删除、查找的时间复杂度都是O(1)
+
设计哈希表需要一个数组，把每个键的哈希值映射到数组的一个位置。为了解决冲突，可以把映射到同一位置的多个键用链表存储。同时，为了避免链表太长，当哈希表中的元素数目与数组的长度的比值超过一定的阈值时，则增加数组的长度并根据新的长度重新映射每个键的位置。
+ 哈希表结合链表可以设计LRU（最近最少使用缓存）数据结构
+ 哈希表通常用来记录字符串中字母出现的次数、字符串中字符出现的位置信息
+ 如果哈希表的数目是固定的，并且数目不太大，那么可以用数组来模拟哈希表，数组的下标对应哈希表的键，而数组的值与哈希表的值对应

#### 题目

### 栈

#### 总结

+ 栈的插入、删除都发生在栈的顶部，顺序为“后入先出”

#### 题目

1. 后缀表达式
2. 小行星碰撞
3. 每日温度
4. 直方图中最大矩形面积
5. 矩阵中最大的矩形的面积

### 队列

#### 总结

+ 结合队列特点，使用广度优先遍历二叉树解决问题
+ 实现公平队列，求解滑动窗口问题

#### 题目

1. 二叉树最底层最左边的值
2. 二叉树每层的最大值
3. 二叉树的右侧视图
4. 往完全二叉树添加节点
5. 最近请求次数
6. 滑动窗口的平均值
7. 用栈实现队列
8. 链表实现队列

### 二叉树

#### 总结

+ 广度优先遍历：结合队列先进先出的特点，从上到下（根-走-右）依次遍历

#### 题目

1. 二叉树剪枝
2. 二叉树的三种遍历递归
3. 二叉树的三种遍历非递归
4. 从根结点到叶结点的路径数字之和
5. 序列化和反序列化二叉树

### 排序

#### 总结

+ 快速排序
    + 分治思想，随机选择数组中任一位置，双指针指向-1,0，使其左边的数字都小于指定值，右边都大于指定值，再对左边的子数组排序
    + 若每次选中的指定值正好是中间值，则时间复杂度为O(nlogn)，若每次选中的位置是最大或最小值，则时间复杂度为O(n^2)
+ 计数排序
    + 数组中元素的范围固定为k，则需要一个长度为k的数组，存储每个元素出现的次数，下标为元素的值（需要求出待排序数组的最大值和最小值）
    + 若范围k远小于n，时间复杂度可达到O(n)，平均复杂度为O(n+k|)
+ 归并排序
    + 分治思想，将数组分割长度为1的子数组，比较相邻位置进行排序，以此类推子数组长度2、4...，每次将排序后的子数组进行合并
    + 算法时间复杂度固定为O(nlogn)
+ 合并两个有序数组，需要一个长度为两个数组之和的辅助空间存储合并后的数组
    + 采用双指针，指针p1指定第一个数组的第一个元素，指针p2指向第二个数组的第二个元素，依次判断当前指针对应数值的大小添加到结果中

#### 算法分类

1. 快速排序
2. 计数排序
3. 归并排序
4. 合并两个有序数组

`持续更新中~~~~~~`
