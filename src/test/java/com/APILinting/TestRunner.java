package com.APILinting;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;


public class TestRunner {

	

		public static void main(String[] args) {
			
			        // Create a TestNG object
			        TestNG testNG = new TestNG();

			        // Add your TestNG XML file or classes to the TestNG object
			        testNG.setTestClasses(new Class[] { Demo.class });  // Add your test class here
			        
			        // Create listener
			        TestListenerAdapter tla = new TestListenerAdapter();
			        testNG.addListener(tla);

			        // Run the tests
			        testNG.run();
			    }
}
