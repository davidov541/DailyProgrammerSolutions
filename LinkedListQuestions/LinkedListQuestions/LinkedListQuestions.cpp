// LinkedListQuestions.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "iLinkedList.h"
#include "iLinkedListNode.h"
#include "LinkedList.h"
#include "LinkedListNode.h"

template <class T>
void RemoveDuplicatesFromListNotBuffered(iLinkedList<T>* list)
{
	iLinkedListNode<T>* currSearched = list->GetHead();
	while (currSearched != NULL)
	{
		iLinkedListNode<T>* curr = currSearched->GetNext();
		while (curr != NULL)
		{
			if (*curr->GetData() == *currSearched->GetData())
			{
				iLinkedListNode<T>* newCurr = curr->GetNext();
				list->Remove(curr);
				curr = newCurr;
			}
			if (curr != NULL)
			{
				curr = curr->GetNext();
			}
		}
		currSearched = currSearched->GetNext();
	}
}

template <class T>
void MoveKthToLastIterative(iLinkedList<T>* list, int k)
{
	int currI = 0;
	iLinkedListNode<T>* node = list->GetHead();
	iLinkedListNode<T>* movableNode = NULL;
	iLinkedListNode<T>* prevNode = NULL;
	while (node != NULL)
	{
		if (currI == k)
		{
			prevNode->SetNext(node->GetNext());
			movableNode = node;
		}
		else
		{
			prevNode = node;
		}
		currI++;
		node = node->GetNext();
	}
	if (movableNode != NULL && prevNode != NULL)
	{
		prevNode->SetNext(movableNode);
		movableNode->SetNext(NULL);
	}
}

template <class T>
void MoveKthToLastRecursive(iLinkedList<T>* list, int k)
{
	iLinkedListNode<T>* movable = NULL;
	if (k == 0)
	{
		iLinkedListNode<T>* movable = list->GetHead();
		iLinkedListNode<T>* last = GetLast(movable);
		movable->SetNext(NULL);
		last->SetNext(movable);
	}
	MoveKthToLastRecursiveHelper(k, 0, list->GetHead());
}

template <class T>
void MoveKthToLastRecursiveHelper(int k, int i, iLinkedListNode<T>* current)
{
	if (i + 1 == k)
	{
		iLinkedListNode<T>* movable = current->GetNext();
		iLinkedListNode<T>* last = GetLast(current);
		current->SetNext(movable->GetNext());
		movable->SetNext(NULL);
		last->SetNext(movable);
	}
	if (current->GetNext() == NULL)
	{
		return;
	}
	MoveKthToLastRecursiveHelper(k, i + 1, current->GetNext());
}

template <class T>
iLinkedListNode<T>* GetLast(iLinkedListNode<T>* current)
{
	if (current->GetNext() == NULL)
	{
		return current;
	}
	return GetLast(current->GetNext());
}

template <class T>
iLinkedListNode<T>* GetKthFromLastIterative(iLinkedList<T>* list, int k)
{
	int currSeparation = 0;
	iLinkedListNode<T>* backNode = list->GetHead();
	iLinkedListNode<T>* frontNode = list->GetHead();
	while (frontNode != NULL && frontNode->GetNext() != NULL)
	{
		frontNode = frontNode->GetNext();
		if (k == currSeparation)
		{
			backNode = backNode->GetNext();
		}
		else
		{
			currSeparation++;
		}
	}
	return backNode;
}

template <class T>
iLinkedListNode<T>* GetKthFromLastRecursive(iLinkedList<T>* list, int k)
{
	int i = 0;
	return GetKthFromLastRecursiveHelper(list->GetHead(), k, &i);
}

template <class T>
iLinkedListNode<T>* GetKthFromLastRecursiveHelper(iLinkedListNode<T>* curr, int k, int* i)
{
	iLinkedListNode<T>* returnable = NULL;
	if (curr->GetNext() == NULL)
	{
		*i = 0;
	}
	else
	{
		returnable = GetKthFromLastRecursiveHelper(curr->GetNext(), k, i);
	}
	if (k == *i)
	{
		(*i)++;
		return curr;
	}
	(*i)++;
	return returnable;
}

template <class T>
iLinkedListNode<T>* AddNode(iLinkedListNode<T>* node, T* data)
{
	iLinkedListNode<T>* added = new LinkedListNode<T>(data);
	node->SetNext(added);
	return added;
}

int main()
{
	int firstData = 0;
	int secondData = 1;
	int thirdData = 2;
	int fourthData = 3;
	iLinkedList<int>* list = new LinkedList<int>();
	iLinkedListNode<int>* first = new LinkedListNode<int>(&firstData);
	list->SetHead(first);
	iLinkedListNode<int>* second = AddNode<int>(first, &secondData);
	iLinkedListNode<int>* third = AddNode<int>(second, &thirdData);
	iLinkedListNode<int>* fourth = AddNode<int>(third, &fourthData);

	std::cout << (*GetKthFromLastIterative(list, 2)->GetData()) << std::endl;

	list->Print();
	std::cin.ignore();
	return 0;
}

