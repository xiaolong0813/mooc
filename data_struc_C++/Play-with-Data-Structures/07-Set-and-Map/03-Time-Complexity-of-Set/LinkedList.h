//
// Created by hpf on 18-5-8.
//

#include <iostream>
#include <cassert>

template<typename T>
class LinkNode {
public:
    T e;
    LinkNode<T> *next;

    LinkNode(T e, LinkNode<T> *next) : e(e), next(next) {}

    LinkNode(T e) : e(e), next(nullptr) {}
    
    LinkNode() : next(nullptr) {}
};

template<typename T>
class LinkedList {
public:
    LinkedList() {
        head = new LinkNode<T>();
	    size = 0;
    }

    int getSize() {
        return size;
    }

    bool isEmpty() {
        return size == 0;
    }

    void add(int index, T e) {
        assert(index >= 0 && index <= size);
        LinkNode<T> *prev = head;
        for (int i = 0; i < index; ++i) {
            prev = prev->next;
        }
        prev->next = new LinkNode<T>(e, prev->next);
        size++;
    }

    void addFirst(T e) {
        add(0, e);
    }

    void addLast(T e) {
        add(size, e);
    }

    T get(int index) {
        assert(index >= 0 && index < size);
        LinkNode<T> *cur = head->next;
        for (int i = 0; i < index; ++i) {
            cur = cur->next;
        }
        return cur->e;
    }

    T getFirst() {
        return get(0);
    }

    T getLast() {
        return get(size - 1);
    }

    void set(int index, T e) {
        assert(index >= 0 && index < size);
        LinkNode<T> *cur = head->next;
        for (int i = 0; i < index; ++i) {
            cur = cur->next;
        }
        cur->e = e;
    }

    void setFirst(T e) {
        set(0, e);
    }

    void setLast(T e) {
        set(size - 1, e);
    }

    T remove(int index) {
        assert(index >= 0 && index < size);
        LinkNode<T> *prev = head;
        for (int i = 0; i < index; ++i) {
            prev = prev->next;
        }
        LinkNode<T> *retNode = prev->next;
        prev->next = retNode->next;
        retNode->next = nullptr;
        size--;
        return retNode->e;
    }

    T removeFirst() {
        return remove(0);
    }

    T removeLast() {
        return remove(size - 1);
    }

    void removeElement(T e) {
        LinkNode<T> *prev = head;
        while (prev->next != nullptr) {
            if (prev->next->e == e) {
                break;
            }
            prev = prev->next;
        }

        if (prev->next != nullptr) {
            LinkNode<T> *delNode = prev->next;
            prev->next = delNode->next;
            delNode->next = nullptr;
            size--;
        }
    }

    bool contains(T e) {
        LinkNode<T> *cur = head;
        for (int i = 0; i < size; ++i) {
            cur = cur->next;
            if (cur->e == e) {
                return true;
            }
        }
        return false;
    }

    void print() {
        LinkNode<T> *prev = head;
        std::cout << "LinkedList: size = " << size << std::endl;
        std::cout << "[";
        for (int i = 0; i < size; ++i) {
            prev = prev->next;
            std::cout << prev->e;
            if (i < size - 1) {
                std::cout << ", ";
            }
        }
        std::cout << "]" << std::endl;
    }

private:
    LinkNode<T> *head;
    int size;
};
