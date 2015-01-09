package com.atmecs.db.pages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactoryTestClass {
int a,b;

public int getA() {
	return a;
}

public void setA(int a) {
	this.a = a;
}

public int getB() {
	return b;
}

public void setB(int b) {
	this.b = b;
}

public FactoryTestClass(int a,int b){
	
	this.a=a;
	this.b=b;
}

@Test
public  void testEqual() { 
 Assert.assertEquals(a , b);
}

}
