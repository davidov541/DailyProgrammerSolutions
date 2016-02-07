#include "iLinkedList.h"
#include "LinkedListNode.h"
#include <stdlib.h>
#include <iostream>

template <class T>
class LinkedList :
	public iLinkedList<T> {
public:
	LinkedList()
	{
		head = NULL;
	}

	iLinkedListNode<T>* GetHead()
	{
		return head;
	}

	void SetHead(iLinkedListNode<T>* head)
	{
		this->head = head;
	}

	void Remove(iLinkedListNode<T>* node)
	{
		iLinkedListNode<T>* prev = NULL;
		iLinkedListNode<T>* curr = head;
		while (curr != NULL)
		{
			if (curr == node)
			{
				prev->SetNext(curr->GetNext());
				delete curr;
				return;
			}
			prev = curr;
			curr = curr->GetNext();
		}
	}

	void Print()
	{
		iLinkedListNode<T>* curr = head;
		std::cout << "List: ";
		while (curr != NULL)
		{
			std::cout << *curr->GetData() << ", ";
			curr = curr->GetNext();
		}
		std::cout << std::endl;
	}

private:
	iLinkedListNode<T>* head;
};
