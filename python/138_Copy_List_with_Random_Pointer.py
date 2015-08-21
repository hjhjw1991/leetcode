# coding=utf-8
import unittest
class RandomListNode(object):
    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None
class Solution(object):
    def solve(self, case):
        return self.copyRandomList(case)
        
    def copyRandomList(self, head):
        dummy, current, mapping = RandomListNode(0), head, {None: None}
        prev  = dummy
        while current:
            #if current in mapping:
            #    node = mapping[current]
            #else:
            node = RandomListNode(current.label)
            mapping[current] = node
            if current.random in mapping:
                node.random = mapping[current.random]
            else:
                node.random = RandomListNode(current.random.label)
                # mapping[current.random]=node.random
                # 这里创建了新的节点但并没有放进map中，从效果来看这样是可以的，leetcode AC了
                # 但按理说会出现两个以上的random node, 所以正统的方法应该是在创建了新节点后与对应的原节点放进map中，即取消注释上面这行
                # 同时在开头去掉注释掉的几句，判断当前节点是否已经在map中
            # connect new list
            prev.next, prev = node, node
            current = current.next
        self.printList(dummy.next)
        self.printRandom(dummy.next)
        return dummy.next
    def printRandom(self, head):
        while head.random:
            print head.label, ".random->",
            head=head.random
        while head:
            print "->",head.label,
            head=head.next
        print 
    def printList(self, head):
        while head:
            if head.random:
                print "(", head.label, ".random->", head.random.label, ")",
            else:
                print "(", head.label, ".random->null", ")",
            if head.next:
                print "->",
            head=head.next
        print 
        
class Test(unittest.TestCase):
    #override
    def setUp(self):
        self.s=Solution()
        
    def tearDown(self):
        print "TestComplete"
        
    def genTestCase(self):
        head = RandomListNode(1)
        head.next = RandomListNode(2)
        head.next.next = RandomListNode(3)
        head.next.next.next = RandomListNode(4)
        head.next.next.next.next = RandomListNode(5)
        head.random=head.next.next
        head.next.next.next.next.random = head.next.next.next
        case=[
        head,
        ]
        self.cases=case
        
    def test(self):
        self.genTestCase()
        for case in self.cases:
            print "testcase: ", case
            res=self.s.solve(case)
            print "result: ",res
            # if assert is needed
            
unittest.main()

