#pragma once
#include "iLinkedListNode.h"

template <class T>
class iLinkedList
{
public:
	virtual iLinkedListNode<T>* GetHead() = 0;
	virtual void SetHead(iLinkedListNode<T>* head) = 0;
	virtual void Remove(iLinkedListNode<T>* node) = 0;
	virtual void Print() = 0;
};