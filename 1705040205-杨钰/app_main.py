from mainwindow import Ui_MainWindow

import sys
import math
import xlrd
from PyQt5.QtWidgets import QApplication,QMainWindow,QDialog
from PyQt5 import QtCore, QtGui, QtWidgets
from PyQt5.QtWebEngineWidgets import *
from PyQt5.QtCore import QUrl
from PyQt5.QtCore import Qt
from PyQt5.QtWidgets import QDialog, QApplication,QHBoxLayout,QAction,QTableWidget
from PyQt5.QtWidgets import *
from PyQt5.QtGui import QBrush, QColor, QFont


#判断变量类型的函数
def typeof(variate):
    type=None
    if isinstance(variate,int):
        type = "int"
    elif isinstance(variate,str):
        type = "str"
    elif isinstance(variate,float):
        type = "float"
    elif isinstance(variate,list):
        type = "list"
    elif isinstance(variate,tuple):
        type = "tuple"
    elif isinstance(variate,dict):
        type = "dict"
    elif isinstance(variate,set):
        type = "set"
    return type
# 返回变量类型
def getType(variate):
    arr = {"int":"整数","float":"浮点","str":"字符串","list":"列表","tuple":"元组","dict":"字典","set":"集合"}
    vartype = typeof(variate)
    if not (vartype in arr):
        return "未知类型"
    return arr[vartype]

class MainWindow(QMainWindow,Ui_MainWindow):

    def __init__(self,parent=None):
        super(MainWindow,self).__init__(parent)
        self.setupUi(self)
        self.pushButton.clicked.connect(self.add1)
        self.pushButton_2.clicked.connect(self.add2)

    def add1(self):
        year=float(self.textEdit.toPlainText())
        long=int(self.textEdit_2.toPlainText())
        if long==16:
            sum1=4080*math.exp(0.28*(year-1960))
            sum=0.3*(0.72**(year-1974.0))*sum1
        else:
            sum1 = 4080 * math.exp(0.28 * (year - 1960))
            sum = 0.048 * (0.72**(year-1974.0))*sum1
        print(sum)
        self.textBrowser_2.setPlainText("需求估量："+str(sum1)+"\n存储器价格："+str(sum))
        print("aaa")

    def add2(self):
        long = float(self.textEdit_2.toPlainText())
        day = float(self.textEdit_3.toPlainText())
        wage = float(self.textEdit_4.toPlainText())
        sum = (long/(day*30.0))*wage
        print(sum)
        self.textBrowser_3.setPlainText(str(sum))


if __name__ == '__main__':
    app = QApplication(sys.argv)
    ui = MainWindow()
    # person_info.show()
    ui.show()
    sys.exit(app.exec_())
