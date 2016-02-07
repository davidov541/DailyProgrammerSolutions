#pragma once

template <class T>
class iLinkedListNode
{
public:
	virtual T* GetData() = 0;
	virtual iLinkedListNode<T>* GetNext() = 0;
	virtual void SetNext(iLinkedListNode<T>* next) = 0;
};