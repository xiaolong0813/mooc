#include <iostream>
using namespace std;

class sales_data
{
private:
    /* data */
    double avg_price() const {
        return units_sold ? revenue / units_sold : 0;
    }
    unsigned units_sold = 0;
    double revenue = 0.0;
    string bookNo;
public:
    sales_data(/* args */) = default;
    sales_data(const string &s, unsigned n, double p):
        bookNo(s), units_sold(n), revenue(p*n) {}
    sales_data(const string &s): bookNo(s) {}
    sales_data(istream&); 
      string isbn() const {return bookNo;};]

        
};

sales_data::sales_data(/* args */)
{
}

sales_data::~sales_data()
{
}
