package com.revature.sampletests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;

import com.revature.assessors.RevAssess;
import com.revature.assessors.RevaTest;
import com.revature.sample.Sample;

// RevAssess acts as an extension to JUnit 5
// Anything you can do in JUnit you can do exactly the same in RevAssess
// The RevAssess dependency comes with JUnit 5 already in it. 
// It is unnecessary to place JUnit in the pom.xml.
// After running ANY test the results of the tests and source code are sent to the RevAssess server
// A test must be annotated with @RevaTest and use @ExtendWith(RevAssess.class) 
@ExtendWith(RevAssess.class)
class SampleTests {

	@RevaTest // @RevaTest is functionally identical to @Test and can be used interchangeably 
	void reverseWordCastle() {
		String castle = "castle";
		String reversed = Sample.reverseWord(castle);
		Assertions.assertEquals(reversed, "eltsac");
	}
	
	@RevaTest(points = 10) // You can award points for a test if it successfully passes
	void reverseWordCat() {
		String cat = "cat";
		String reversed = Sample.reverseWord(cat);
		Assertions.assertEquals(reversed, "tac");
	}
	
	@RevaTest(points = 15, tier = 1) // you can assign a test a tier to tell associates the order
	// in which they should attempt the test
	void biggerNumberTest() {
		int bigNum = Sample.biggerNumber(100, 300);
		Assertions.assertEquals(300, bigNum);
	}
	
	// if points or tier is not defined then it will get a default value of 0

}
