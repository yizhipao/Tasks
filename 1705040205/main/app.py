from inflight_gui import Ui_MainWindow
from open_file import Ui_Dialog
from info import Ui_Dialog1
import sys
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
btn = {}
person = [
    ["张伟", "男", "30", "6700", "20190321", "17050", "重要保持客户"],
    ["王伟", "男", "26", "5300", "20190103", "8500", "重要发展客户"],
    ["王芳", "女", "45", "3500", "20181112", "3500", "重要挽留客户"],
    ["李伟", "男", "33", "6500", "20190215", "10010", "重要发展客户"],
    ["王秀英", "女", "28", "2000", "20171223", "2005", "低价值客户"],
    ["李秀英", "女", "49", "4600", "20190202", "20010", "重要保持客户"],
    ["李娜", "女", "53", "3000", "20181026", "5000", "一般客户"],
    ["张秀英", "女", "34", "1000", "20180502", "2300", "低价值客户"],
    ["刘伟", "男", "28", "6000", "20190106", "8500", "重要发展客户"],
    ["张敏", "女", "26", "2356", "20180608", "4560", "一般客户"],
    ["李明", "男", "31", "500", "20180101", "3212", "低价值客户"],
    ["李勇", "男", "46", "12000", "20190321", "26031", "重要保持客户"],
    ["刘杰", "男", "49", "6000", "20181231", "9850", "重要发展客户"],
    ["王超", "男", "62", "1530", "20170302", "1500", "低价值客户"],
    ["刘琳", "女", "36", "6321", "20170315", "8300", "重要发展客户"],
    ["王涛", "男", "33", "4500", "20190212", "5600", "重要挽留客户"]
]


def read_excel(tableWidget3):
    # 打开文件
    workbook = xlrd.open_workbook('C:/Users/lyhoo/Desktop/person.xlsx')
    # 获取所有sheet
    #sheet2_name = workbook.sheet_names()[0]
    # 根据sheet索引或者名称获取sheet内容
    sheet1 = workbook.sheet_by_index(0) # sheet索引从0开始
    cols = sheet1.col_values(0)  # 获取第三列内容 品名
    # 获取整行和整列的值（数组）
    for i in range(len(cols)):
        rowslist = sheet1.row_values(i) # 获取excel每行内容
        for j in range(len(rowslist)):
            #在tablewidget中添加行
            row = tableWidget3.rowCount()
            tableWidget3.insertRow(row)
            #把数据写入tablewidget中
            newItem = QTableWidgetItem(rowslist[j])
            tableWidget3.setItem(i, j, newItem)



class MainWindow(QMainWindow,Ui_MainWindow):

    def __init__(self,parent=None):
        super(MainWindow,self).__init__(parent)
        self.setupUi(self)
        self.table()
        self.browser = QWebEngineView(self.stackedWidget)
        self.browser.load(
            QUrl("file:///E:/code/python/inflight_project/client.html"))
        hboxlayout = QHBoxLayout(self.frame_1)
        hboxlayout.addWidget(self.browser)
        self.tableWidget.setSelectionBehavior(QAbstractItemView.SelectRows)
        self.tableWidget.setEditTriggers(QAbstractItemView.NoEditTriggers)
        # QTableWidget.resizeColumnsToContents(self.tableWidget)
        # QTableWidget.resizeRowsToContents(self.tableWidget)
        self.tableWidget
        self.tableWidget.setColumnWidth(0, 100)
        self.tableWidget.setColumnWidth(1, 80)
        self.tableWidget.setColumnWidth(2, 80)
        self.pushButton.clicked.connect(self.table)
        self.pushButton_2.clicked.connect(self.table_person)
        self.pushButton_3.clicked.connect(self.table_person)
        self.pushButton_4.clicked.connect(self.table_person)
        self.pushButton_5.clicked.connect(self.table_person)
        self.pushButton_6.clicked.connect(self.table_person)
        self.pushButton_7.clicked.connect(self.line)
        self.pushButton_8.clicked.connect(self.pie)
        read_excel(self.tableWidget)


    def line(self):

        self.browser.load(
            QUrl("file:///E:/code/python/inflight_project/client.html"))
        hboxlayout = QHBoxLayout(self.frame_1)
        hboxlayout.addWidget(self.browser)
        # self.stackedWidget.setCurrentWidget(self.page)
        # self.stackedWidget.setCurrentIndex(0)

    def pie(self):

        self.browser.load(
            QUrl("file:///E:/code/python/inflight_project/line-client.html"))
        # hboxlayout1 = QHBoxLayout(self.frame_1)
        hboxlayout = QHBoxLayout(self.frame_1)
        hboxlayout.addWidget(self.browser)
        # self.stackedWidget.setCurrentWidget(self.page_2)
        # self.stackedWidget.setCurrentIndex(1)

    def table(self):
        self.tableWidget.clearContents()
        # for i in range(16):
        #     for j in range(7):
        #         newItem = QTableWidgetItem(person[i][j])
        #         newItem.setTextAlignment(Qt.AlignCenter)
        #         self.tableWidget.setItem(i, j, newItem)  # 设置i行j列的内容为Value
        #     btn[i] = QPushButton('查看'+person[i][0])
        #     # btn[i].setDown(True)
        #     btn[i].setStyleSheet('QPushButton{margin:3px}')
        #     self.tableWidget.setCellWidget(i, 7, btn[i])
        #     btn[i].clicked.connect(self.info)

    def table_person(self):
        sender = self.sender()
        self.statusBar().showMessage(sender.text())
        print("sender is "+getType(sender)+"\n")
        print(getType(person[0][6]))
        self.tableWidget.clearContents()
        q=0
        for i in range(16):
            if person[i][6]==sender.text():
                for j in range(7):
                    newItem = QTableWidgetItem(person[i][j])
                    newItem.setTextAlignment(Qt.AlignCenter)
                    self.tableWidget.setItem(q, j, newItem)  # 设置i行j列的内容为Value
                btn[q] = QPushButton('查看'+person[i][0])
                # btn[q].setDown(True)
                btn[q].setStyleSheet('QPushButton{margin:3px}')
                self.tableWidget.setCellWidget(q, 7, btn[q])
                btn[q].clicked.connect(self.info)
                q = q+1

    def info(self):
        sender = self.sender()
        name = sender.text()[2:]
        print(name)
        flag=0
        for i in range(16):
            if person[i][0]==name:
                flag=i
                break
        self.statusBar().showMessage(sender.text())
        # person_info = Dialog1()
        person_info.lineEdit.setText(person[flag][0])
        person_info.lineEdit_2.setText(person[flag][1])
        person_info.lineEdit_3.setText(person[flag][2])
        person_info.lineEdit_4.setText("18888888888")
        person_info.lineEdit_5.setText("湖南科技大学")
        person_info.lineEdit_6.setText(person[flag][3])
        person_info.lineEdit_7.setText(person[flag][4])
        person_info.lineEdit_8.setText(person[flag][5])
        person_info.lineEdit_9.setText("")
        person_info.lineEdit_10.setText("")
        person_info.lineEdit_11.setText(person[flag][6])
        person_info.show()


class Dialog1(QDialog,Ui_Dialog1):
    def __init__(self,parent=None):
        super(Dialog1,self).__init__(parent)
        self.setupUi(self)

class Dialog(QDialog,Ui_Dialog):
    def __init__(self,parent=None):
        super(Dialog,self).__init__(parent)
        self.setupUi(self)


if __name__ == '__main__':
    app = QApplication(sys.argv)
    ui = MainWindow()
    upload = Dialog()
    person_info = Dialog1()
    # person_info.show()
    ui.show()
    ui.pushButton_9.clicked.connect(upload.show)
    sys.exit(app.exec_())
