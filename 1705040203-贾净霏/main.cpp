#include "tw2.h"
#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    TW2 w;
    w.show();

    return a.exec();
}
