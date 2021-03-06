#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
本文件帮助列出所在目录的指定目录下所有Leetcode源代码的名字
包括两种功能: 列出某目录下所有缺少的序号，列出某目录下所有不以序号开头的文件的名字
目前我只是用于统计缺失的内容
要求源代码按照 序号_名字.extension的格式命名,空格用下划线代替
"""

import re,os
# from argparser import argparser
root = r'.'

Java = root+r'/Java'
Python = root+r'/Python'
Cpp = root+r'/CPP'

def getFileList(path):
    assert os.path.isdir(path), "Not a directory!"
    cur = os.getcwd()
    os.chdir(path)
    ret = os.listdir('./')
    os.chdir(cur)
    return ret
    
def dispSource(path=Java):
    li = getFileList(path)
    dict = {}
    p = re.compile('(^\d+)_')
    for l in li:
        match = p.match(l)
        if match:
            dict[match.group(1)] = True
    m = max(list(map(int,list(dict.keys()))))
    res = mylist()
    res.total = m
    for i in range(1,m+1):
        key = str(i)
        if not dict.get(key, False):
            res.append(str(key))
    print(path)
    print(res)

def dispNames(path, extension = '.cc'):
    li = getFileList(path)
    p = re.compile('^\d+')
    for file in li:
        if p.match(file):
            continue
        file = file.replace('_', ' ').replace(extension, '')
        print(file)
    
# 以带换行的字符串的形式打印列表元素
def getMyList(self, width=10):
    assert type(self) is mylist, "Not a mylist"
    assert type(width) is int, "Invalid width"
    row = len(self)/width
    res = ""
    for i in range(0,len(self),width):
        res += "\t".join(self[i:i+width])
        res += "\n"
    return res

# 重新定义了list类型，重写__str__方法，原list类型无法直接绑定__str__方法
class mylist(list):
    @property
    def total(self):
        return self._total

    @total.setter
    def total(self, val):
        self._total = val
        
    def __str__(self):
        res = getMyList(self, 20)
        res+= "Solved: %d/%d\nUnlisted: %d/%d"%(self.total - len(self), self.total, len(self), self.total)
        return res

if __name__=='__main__':
    dispSource(Java)
    # dispSource(Python)
    # dispSource(Cpp)
    # dispNames(Cpp)
