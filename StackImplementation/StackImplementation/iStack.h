#pragma once
#include "ErrorCodes.h"

template <class T>
class iStack
{
public:
	virtual void Push(T element, ERROR* errorCode) = 0;
	virtual T Pop(ERROR* errorCode) = 0;
	virtual T Peek(ERROR* errorCode) = 0;
	virtual bool HasValue(ERROR* errorCode) = 0;
};

