package testcases;

import java.lang.reflect.Method;

/**
 * TestCaseExecutor is a utility class for dynamically executing test methods using Java Reflection.
 * It allows for the invocation of any method within the 'testcases.TestMethods' class based on the method name and arguments.
 */
public class TestCaseExecutor {
    
    /**
     * Executes a specified test case method from the 'testcases.TestMethods' class.
     * It uses reflection to dynamically invoke the method.
     *
     * @param methodName The name of the method to execute.
     * @param args Varargs arguments to pass to the test method. These can be of any type.
     * @return boolean indicating whether the test passed or failed. Returns 'true' if the test passes, 'false' otherwise.
     */
    public static boolean executeTestCase(String methodName, Object... args) {
        boolean passed = false;
        try {
            // Load the 'testcases.TestMethods' class
            Class<?> c = Class.forName("testcases.TestMethods");
            // Create a new instance of the class
            Object obj = c.getDeclaredConstructor().newInstance();

            // Determine the argument types for the method
            Class<?>[] argTypes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                argTypes[i] = args[i].getClass();
            }

            // Find and get the method by name and parameter types
            Method method = c.getDeclaredMethod(methodName, argTypes);

            // Invoke the method with the provided arguments
            passed = (boolean) method.invoke(obj, args);
        } catch (Exception e) {
            // Log the exception and set passed to false
            e.printStackTrace();
            passed = false;
        }
        return passed;
    }
}
