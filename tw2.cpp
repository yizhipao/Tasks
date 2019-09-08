#include "tw2.h"
#include "ui_tw2.h"
#include "math.h"

TW2::TW2(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::TW2)
{
    ui->setupUi(this);
}

TW2::~TW2()
{
    delete ui;
}

//清空
void TW2::on_pbt_clear_clicked()
{
    ui->lineEdit_bit->clear();
    ui->lineEdit_cost->clear();
    ui->lineEdit_need->clear();
    ui->lineEdit_price->clear();
    ui->lineEdit_salary->clear();
}

//计算
void TW2::on_pbt_count_clicked()
{
    //计算需求
    QString str_year = ui->comboBox_year->currentText();
    int year = str_year.toInt();
    double x = 0.28;
    double y = x*(year-1960);
    double need = 4080*exp(y);
    str_year = str_year.sprintf("%0.1f",need);
    ui->lineEdit_need->setText(str_year);

    //计算价格
    QString str_bit = ui->lineEdit_bit->text();
    int bit = str_bit.toInt();
    double price = 0;
    price = 0.3*pow(0.72,(year-1974));
    price = (price*need)/100;
    str_bit = str_bit.sprintf("%0.1f",price);
    ui->lineEdit_price->setText(str_bit);

    //计算成本
    QString str_salary = ui->lineEdit_salary->text();
    QString str_codeline = ui->comboBox_codeline->currentText();
    int salary = str_salary.toInt();
    int codeline = str_codeline.toInt();
    if(str_salary == "")
    {
        ui->lineEdit_cost->setText("ERROR");
    }else
    {
        double a = codeline*bit;
        double b = ((need/a)/30)*salary;
        str_salary = str_salary.sprintf("%0.1f",b);
        ui->lineEdit_cost->setText(str_salary);
    }
}
