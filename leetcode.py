#!/bin/python
# encoding=utf-8

'''
本文件帮助列出所在目录的指定目录下所有Leetcode源代码的名字
包括两种功能: 列出某目录下所有缺少的序号，列出某目录下所有不以序号开头的文件的名字
目前我只是用于统计缺失的内容
要求源代码按照 序号_名字.extension的格式命名,空格用下划线代替
'''

import re,os
root = r'.'

Java = root+r'/Java'
Python = root+r'/Python'
Cpp = root+r'/CPP'

def getFileList(path):
    assert os.path.isdir(path), "Not a directory!"
    os.chdir(path)
    return os.listdir('./')
    
def dispSource(path=Java):
    list = getFileList(path)
    dict = {}
    p = re.compile('(^\d+)_')
    for l in list:
        match = p.match(l)
        if match:
            dict[match.group(1)] = True
    m = max(map(int,dict.keys()))
    res = mylist()
    res.setTotal(m)
    for i in xrange(1,m+1):
        key = str(i)
        if not dict.get(key, False):
            res.append(str(key))
    print path
    print res

def dispNames(path, extension = '.cc'):
    list = getFileList(path)
    p = re.compile('^\d+')
    for file in list:
        if p.match(file):
            continue
        file = file.replace('_', ' ').replace(extension, '')
        print file
    
# 以带换行的字符串的形式打印列表元素
def getMyList(self, width=10):
    assert type(self) is mylist, "Not a mylist"
    assert type(width) is int, "Invalid width"
    row = len(self)/width
    res = ""
    for i in xrange(0,len(self),width):
        res += "\t".join(self[i:i+width])
        res += "\n"
    return res

# 重新定义了list类型，重写__str__方法，因为原list类型无法直接绑定__str__方法
class mylist(list):
    def setTotal(self, total=0):
        self.total = total
    def __str__(self):
        res = getMyList(self, 20)
        res+= "Solved: %d/%d\nUnlisted: %d/%d"%(self.total - len(self), self.total, len(self), self.total)
        return res

if __name__=='__main__':
    dispSource(Java)
    #dispSource(Python)
    #dispSource(Cpp)
    #dispNames(Cpp)
