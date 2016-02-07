#pragma once
#include "iLinkedListNode.h"

template <class T>
class LinkedListNode : public iLinkedListNode<T>
{
public:
	LinkedListNode(T* data)
	{
		next = NULL;
		this->data = data;
	}

	T* GetData()
	{
		return data;
	}

	iLinkedListNode<T>* GetNext()
	{
		return next;
	}

	void SetNext(iLinkedListNode<T>* next)
	{
		this->next = next;
	}

private:
	T* data;
	iLinkedListNode<T>* next;

};