# encoding=utf-8
import re,os
root = r'E:\Workspace\Github\leetcode'

Java = root+r'\Java'
Python = root+r'\Python'
Cpp = root+r'\CPP'

def getFileList(path):
    assert os.path.isdir(path), "Not a directory!"
    os.chdir(path)
    return os.listdir('./')
    
def dispSource(path=Java):
    list = getFileList(path)
    dict = {}
    p = re.compile('^\d+')
    for l in list:
        match = p.match(l)
        if match:
            dict[match.group()] = True
    m = max(map(int,dict.keys()))
    res = mylist()
    for i in xrange(1,m+1):
        key = str(i)
        if not dict.get(key, False):
            res.append(str(key))
    print path
    print res

def dispNames(path, extension = '.cc'):
    list = getFileList(path)
    p = re.compile('^\d+')
    print path
    for file in list:
        if p.match(file):
            continue
        file = file.replace('_', ' ').replace(extension, '')
        print file
    
def getMyList(self):
    assert type(self) is mylist, "Not a mylist"
    row = len(self)/10
    res = ""
    for i in xrange(0,len(self),10):
        res += "\t".join(self[i:i+10])
        res += "\n"
    res += "Total: %d"%(len(self))
    return res

class mylist(list):
    def __str__(self):
        return getMyList(self)

if __name__=='__main__':
    #dispSource(Java)
    #dispSource(Python)
    #dispSource(Cpp)
    dispNames(Cpp)