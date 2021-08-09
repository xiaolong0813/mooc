#include "testDataStruc.h"


int main() {


    int n = 100;
    int *test = new int[n];
    for (int i = 0; i < n; i++)
    {
        test[i] = rand() % INT32_MAX;
    }


    MaxHeap<int> *h = new MaxHeap<int>(test, n);
    
    

}