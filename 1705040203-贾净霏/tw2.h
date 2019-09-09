#ifndef TW2_H
#define TW2_H

#include <QDialog>

namespace Ui {
class TW2;
}

class TW2 : public QDialog
{
    Q_OBJECT

public:
    explicit TW2(QWidget *parent = 0);
    ~TW2();

private slots:
    void on_pbt_clear_clicked();

    void on_pbt_count_clicked();

private:
    Ui::TW2 *ui;
};

#endif // TW2_H
