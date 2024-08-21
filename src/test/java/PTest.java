import org.junit.Test;
import com.craftinginterpreters.lox.Expr;
import com.craftinginterpreters.lox.Parser;
import com.craftinginterpreters.lox.Interpreter;
import com.craftinginterpreters.lox.Scanner;
import com.craftinginterpreters.lox.Token;
import com.craftinginterpreters.lox.Stmt;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PTest {

    @Test
    public void testForLoopExecution() {
        // Step 1: Define the source code for the for loop
        String source = "var a = 0; var temp; " +
                        "for (var b = 1; a < 10000; b = temp + b) { " +
                        "  print a; " +
                        "  temp = a; " +
                        "  a = b; " +
                        "}";

        // Step 2: Tokenize the source code
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        // Step 3: Parse the tokens into a list of statements
        Parser parser = new Parser(tokens);
        List<Stmt> statements = parser.parse(); // Ensure you're using the correct method

        // Step 4: Create an interpreter and capture the output
        Interpreter interpreter = new Interpreter();
        
        // Use a custom output stream to capture print statements
        TestOutputStream testOutput = new TestOutputStream();
        System.setOut(new java.io.PrintStream(testOutput));
        
        // Interpret the statements
        interpreter.interpret(statements);
        
        // Step 5: Check the output
        String expectedOutput = "0\n1\n1\n2\n3\n5\n8\n13\n21\n34\n55\n89\n144\n233\n377\n610\n987\n1597\n2584\n4181\n6765\n";
        String normalizedExpected = expectedOutput.replaceAll("\\s+", "");
        String normalizedActual = testOutput.getOutput().replaceAll("\\s+", "");
      //  assertEquals(expectedOutput, testOutput.getOutput().trim());
           assertEquals(normalizedExpected, normalizedActual);

        // Restore the original System.out
        System.setOut(System.out);
    }

    // Helper class to capture System.out output
    private static class TestOutputStream extends java.io.OutputStream {
        private final StringBuilder output = new StringBuilder();

        @Override
        public void write(int b) {
            output.append((char) b);
        }

        public String getOutput() {
            return output.toString();
        }
    }
}

