#include <iostream>
#include <fstream>
using namespace std;

class testC
{
public:
    /* data */
    void setname(char *name);
    void setage(int age);
    void setsore(float score);
    void show();
private:
    // testC(/* args */);
    // ~testC();
    char *name;
    int age;
    float score;
};

void testC::setname(char *name)
{
    this->name = name;
}

void testC::setage(int age)
{
    this->age = age;
}

void testC::setsore(float score) {
    this->score = score;
}

void testC::show() {
    cout << this->name << "的年齡是" << this->age << ", 的成績是" << this->score << endl;
}

int main() {
    testC *t = new testC;
    t->setname("r");
    t->setage(13);
    t->setsore(333);
    t->show();

    return 0;
}
