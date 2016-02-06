// InterviewQuestion.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "Stack.h"
#include "iStack.h"
#include <iostream>
#include "ErrorCodes.h"

void PushPeek_Test()
{
	int errorCode = NOERR;
	Stack<int> stack = Stack<int>();
	if (stack.HasValue(&errorCode))
	{
		std::cout << "ERROR -- Data in stack before first push. PushPeek_Test failed!" << std::endl;
		return;
	}
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on first call to HasValue. PushPeek_Test failed!" << std::endl;
	}
	stack.Push(1, &errorCode);
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on first call to Push. PushPeek_Test failed!" << std::endl;
	}
	if (stack.Peek(&errorCode) != 1)
	{
		std::cout << "ERROR -- Peek did not produce what we pushed on. PushPeek_Test failed!" << std::endl;
		return;
	}
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on first call to Peek. PushPeek_Test failed!" << std::endl;
	}
	if (!stack.HasValue(&errorCode))
	{
		std::cout << "ERROR -- No data left after first peek. PushPeek_Test failed!" << std::endl;
		return;
	}
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on second call to HasValue. PushPeek_Test failed!" << std::endl;
	}
	stack.Push(2, &errorCode);
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on second call to Push. PushPeek_Test failed!" << std::endl;
	}
	if (stack.Peek(&errorCode) != 2)
	{
		std::cout << "ERROR -- Peek did not produce what we pushed on the second time. PushPeek_Test failed!" << std::endl;
		return;
	}
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on second call to Peek. PushPeek_Test failed!" << std::endl;
	}
	if (!stack.HasValue(&errorCode))
	{
		std::cout << "ERROR -- No data left after second peek. PushPeek_Test failed!" << std::endl;
		return;
	}
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on third call to HasValue. PushPeek_Test failed!" << std::endl;
	}
	std::cout << "SUCCESS -- PushPeek_Test" << std::endl;
}

void PushPop_Test()
{
	ERROR errorCode = NOERR;
	Stack<int> stack = Stack<int>();
	if (stack.HasValue(&errorCode))
	{
		std::cout << "ERROR -- Data in stack before first push. PushPop_Test failed!" << std::endl;
		return;
	}
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on first call to HasValue. PushPop_Test failed!" << std::endl;
	}
	stack.Push(1, &errorCode);
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on first call to Push. PushPop_Test failed!" << std::endl;
	}
	if (!stack.HasValue(&errorCode))
	{
		std::cout << "ERROR -- No data left after first push. PushPop_Test failed!" << std::endl;
		return;
	}
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on second call to HasValue. PushPop_Test failed!" << std::endl;
	}
	if (stack.Pop(&errorCode) != 1)
	{
		std::cout << "ERROR -- Peek did not produce what we pushed on. PushPop_Test failed!" << std::endl;
		return;
	}
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on first call to Pop. PushPop_Test failed!" << std::endl;
	}
	if (stack.HasValue(&errorCode))
	{
		std::cout << "ERROR -- Data in stack left after first pop. PushPop_Test failed!" << std::endl;
		return;
	}
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on third call to HasValue. PushPop_Test failed!" << std::endl;
	}
	stack.Push(2, &errorCode);
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on second call to Push. PushPop_Test failed!" << std::endl;
	}
	stack.Push(3, &errorCode);
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on third call to Push. PushPop_Test failed!" << std::endl;
	}
	if (!stack.HasValue(&errorCode))
	{
		std::cout << "ERROR -- No data left after second push. PushPop_Test failed!" << std::endl;
		return;
	}
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on fourth call to HasValue. PushPop_Test failed!" << std::endl;
	}
	if (stack.Pop(&errorCode) != 3)
	{
		std::cout << "ERROR -- Peek did not produce what we pushed on the second time. PushPop_Test failed!" << std::endl;
		return;
	}
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on second call to Pop. PushPop_Test failed!" << std::endl;
	}
	if (!stack.HasValue(&errorCode))
	{
		std::cout << "ERROR -- Data not left in stack after second pop. PushPop_Test failed!" << std::endl;
		return;
	}
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on fifth call to HasValue. PushPop_Test failed!" << std::endl;
	}
	std::cout << "SUCCESS -- PushPop_Test" << std::endl;
}

void StackExpansion_Test()
{
	ERROR errorCode = NOERR;
	Stack<int> stack = Stack<int>();
	stack.Push(1, &errorCode);
	stack.Push(2, &errorCode);
	stack.Push(3, &errorCode);
	stack.Push(4, &errorCode);
	stack.Push(5, &errorCode);
	stack.Push(6, &errorCode);
	stack.Push(7, &errorCode);
	stack.Push(8, &errorCode);
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on one of the pushes. StackExpansion_Test failed!" << std::endl;
	}
	if (!stack.HasValue(&errorCode))
	{
		std::cout << "ERROR -- Data not left in stack after pushes. StackExpansion_Test failed!" << std::endl;
		return;
	}
	if (stack.Pop(&errorCode) != 8 ||
		stack.Pop(&errorCode) != 7 ||
		stack.Pop(&errorCode) != 6 ||
		stack.Pop(&errorCode) != 5 ||
		stack.Pop(&errorCode) != 4 ||
		stack.Pop(&errorCode) != 3 ||
		stack.Pop(&errorCode) != 2 ||
		stack.Pop(&errorCode) != 1)
	{
		std::cout << "ERROR -- Data was not correct in the stack once it was expanded. StackExpansion_Test failed!" << std::endl;
	}
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- Got error on one of the pops. StackExpansion_Test failed!" << std::endl;
	}
	std::cout << "SUCCESS -- StackExpansion_Test" << std::endl;
}

void NoElementStack_Test()
{
	ERROR errorCode = NOERR;
	Stack<int> stack = Stack<int>();
	if (stack.HasValue(&errorCode))
	{
		std::cout << "ERROR -- HasValue returned true with no elements. NoElementStack_Test failed!" << std::endl;
	}
	if (errorCode != NOERR)
	{
		std::cout << "ERROR -- HasValue returned an error when called with no elements. NoElementStack_Test failed!" << std::endl;
	}
	stack.Pop(&errorCode);
	if (errorCode != NOELEMENTS)
	{
		std::cout << "ERROR -- Pop did not return correct error when called with no elements. NoElementStack_Test failed!" << std::endl;
	}
	stack.Peek(&errorCode);
	if (errorCode != NOELEMENTS)
	{
		std::cout << "ERROR -- Peek did not return correct error when called with no elements. NoElementStack_Test failed!" << std::endl;
	}
	std::cout << "SUCCESS -- NoElementStack_Test" << std::endl;
}

int main()
{
	PushPeek_Test();
	PushPop_Test();
	StackExpansion_Test();
	NoElementStack_Test();
	std::cin.ignore();
	return 0;
}