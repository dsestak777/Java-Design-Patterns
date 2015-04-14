package com.des.ordermanagement;

public interface OrderChain {

	public abstract void setNext(OrderChain nextInChain);
	public abstract void process(Order request);
}
