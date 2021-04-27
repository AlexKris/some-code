package com.chris.some.code.study.geektime.datastructureandalgorithm.datastructure;

/**
 * 链表
 * <p>
 * 经典链表应用场景：LRU缓存淘汰算法
 * <p>
 * 缓存常见应用场景：CPU缓存，数据库缓存，浏览器缓存
 * <p>
 * 常见缓存淘汰策略：先进先出策略 FIFO（First In，First Out）、最少使用策略 LFU（Least Frequently Used）、最近最少使用策略 LRU（Least Recently Used）
 * <p>
 * 链表不需要连续空间，通过指针将一组零散内存串联起来
 * <p>
 * 常见链表结构：单链表、双向链表、循环链表
 * <p>
 * 单链表
 * <pre>
 *     时间复杂度
 *     <pre>
 *         1、插入/删除：只需要考虑相邻节点的指针改变，O(1)
 *         2、随机访问：O(n)
 *     </pre>
 * </pre>
 * 循环链表：尾节点指针只想头节点，处理具有环型结构特点的数据，例如：约瑟夫问题
 * <p>
 * 双向链表：双指针，后继指针指向后面的节点，前继指针指向前面的节点，支持O(1)时间找到前一个节点
 * <p>
 * 判断字符串是否回文
 */
public class LinkedStudy {
}
