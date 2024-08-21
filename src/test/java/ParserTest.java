import org.junit.Test;

import com.craftinginterpreters.lox.Expr;
import com.craftinginterpreters.lox.Parser;
import com.craftinginterpreters.lox.Interpreter;
import com.craftinginterpreters.lox.Scanner;
import com.craftinginterpreters.lox.Token;
import java.util.List;
import com.craftinginterpreters.lox.Stmt;


import static org.junit.Assert.*;


public class ParserTest {

    // @Test
    // public void testBasic() {
    //     // A simple test to make sure JUnit is working
    //     // assertEquals(14, 7 * 2);
    // }

    @Test
    public void testExpressionEvaluation() {
        // Step 1: Define the source code
        String source = "1/0";
        // Step 2: Tokenize the source code
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();
        // Step 3: Parse the tokens into an AST
        Parser parser = new Parser(tokens);
        List<Stmt> statements = parser.parse();
        // Step 4: Evaluate the AST
        Interpreter interpreter = new Interpreter();
     //   Object result = interpreter.evaluate(statements);

    }

}