#pragma once
#include "iStack.h"
#include "ErrorCodes.h"

template <class T>
class Stack :
	public iStack<T>
{
private:
	T* _backingArray;
	int _arrayLength;
	int _lastElement;

	void GrowArray()
	{
		int newArrayLength = _arrayLength * 2;
		T* newArray = new T[newArrayLength];
		for (int i = 0; i < _arrayLength; i++)
		{
			newArray[i] = _backingArray[i];
		}
		_backingArray = newArray;
		_arrayLength = newArrayLength;
	}

public:
	Stack()
	{
		_arrayLength = 5;
		_lastElement = -1;
		_backingArray = new T[_arrayLength];
	}

	~Stack()
	{
		delete _backingArray;
		_backingArray = NULL;
		_arrayLength = 0;
		_lastElement = -1;
	}

	void Push(T element, ERROR* errorCode)
	{
		if (_lastElement + 1 == _arrayLength)
		{
			GrowArray();
		}
		_lastElement++;
		_backingArray[_lastElement] = element;
	}

	inline T Pop(ERROR* errorCode)
	{
		if (_lastElement < 0)
		{
			*errorCode = NOELEMENTS;
			return 0;
		}
		_lastElement--;
		return _backingArray[_lastElement + 1];
	}

	inline T Peek(ERROR* errorCode)
	{
		if (_lastElement < 0)
		{
			*errorCode = NOELEMENTS;
			return 0;
		}
		return _backingArray[_lastElement];
	}

	inline bool HasValue(ERROR* errorCode)
	{
		return _lastElement >= 0;
	}

};

