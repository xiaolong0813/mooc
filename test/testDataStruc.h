// #include <iostream>
// #include <cassert>

#include "Array.h"

template<class T>
class MaxHeap
{
private:
    /* data */
    Array<T> *data;

    int leftChild(int index) {return index * 2 + 1;}
    int rightChild(int index) {return index * 2 + 2;}

     void siftUp(int k) {
         while (k > 0 && data->get(parent(k)) < data->get(k))
         {
             data->swap(k, parent(k));
             k = parent(k);
         }         
     }

     void siftDown(int k) {
         if (leftChild(k) >= data->getSize())
            return;

        int maxIndex = leftChild(k);
        if (rightChild(k) < data->getSize() && data->get(maxIndex) < data->get(rightChild(k))) {
            maxIndex = rightChild(k)
        }
         
        if (data->get(k) > data->get(maxIndex))
            return;

        data->swap(k, maxIndex);
        siftDown(maxIndex);
     }

public:

    MaxHeap(int capacity){
        data = new Array<T>(capacity);
    };

    MaxHeap(){
        data = new Array<T>();
    };

    MaxHeap(T arr[], int n) {
        data = new Array<T>(arr, n);
        for (int i = parent(n - 1); i >= 0; i--)
        {
            siftDown(i)
        }
        
    }

    ~MaxHeap();

    class NoParent {
    };

    int parent(int index) {
        if (index == 0)
        {
            throw Noparent();
        }
        return (index - 1) / 2;
    };

    void add(T e) {
        data->addLast(e);
        siftUp(data->getSize() - 1)
    }

};

// MaxHeap::MaxHeap(/* args */)
// {
// }

// MaxHeap::~MaxHeap()
// {
// }
