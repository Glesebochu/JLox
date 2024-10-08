package com.craftinginterpreters.lox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Lox {
    private static final Interpreter interpreter = new Interpreter();
    static boolean hadError = false;
    static boolean hadRuntimeError = false;

    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Usage: jlox [script]");
            System.exit(64);
        } else if (args.length == 1) {
            runFile(args[0]);
        } else {
            runPrompt();
        }
    }

    private static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes, Charset.defaultCharset()));
        if (hadError)
            System.exit(65);
        if (hadRuntimeError)
            System.exit(70);
    }

    private static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        for (;;) {
            System.out.print("> ");
            String line = reader.readLine();
            if (line == null)
                break;
            run(line);
            hadError = false;
        }
    }

    private static void run(String source) {
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        Parser parser = new Parser(tokens);
        List<Stmt> statements = parser.parse();

        // Stop if there was a syntax error.
        if (hadError)
            return;

        Resolver resolver = new Resolver(interpreter);
        resolver.resolve(statements);

        // Stop if there was a resolution error.
        if (hadError)
            return;
        interpreter.interpret(statements);
    }

    static void error(int line, String message) {
        report(line, "", message);
    }

    private static void report(int line, String where, String message) {
        System.err.println("[line " + line + "] Error" + where + ": " + message);
        hadError = true;
    }

    static void error(Token token, String message) {
        if (token.type == TokenType.EOF) {
            report(token.line, " at end", message);
        } else {
            report(token.line, " at '" + token.lexeme + "'", message);
        }
    }

    static void runtimeError(RuntimeError error) {
        System.err.println(error.getMessage() + "\n[line " + error.token.line + "]");
        hadRuntimeError = true;
    }
}

/*
 * package com.craftinginterpreters.lox;
 * import java.io.BufferedReader;
 * import java.io.IOException;
 * import java.io.InputStreamReader;
 * import java.nio.charset.Charset;
 * import java.nio.file.Files;
 * import java.nio.file.Paths;
 * import java.util.List;
 * 
 * public class Lox {
 * static boolean hadError = false;
 * 
 * public static void main(String[] args) throws IOException {
 * if (args.length > 1) {
 * System.out.println("Usage: jlox [script]");
 * System.exit(64);
 * } else if (args.length == 1) {
 * runFile(args[0]);
 * } else {
 * runPrompt();
 * }
 * }
 * 
 * private static void runFile(String path) throws IOException {
 * byte[] bytes = Files.readAllBytes(Paths.get(path));
 * run(new String(bytes, Charset.defaultCharset()));
 * if (hadError) System.exit(65);
 * }
 * 
 * private static void runPrompt() throws IOException {
 * InputStreamReader input = new InputStreamReader(System.in);
 * BufferedReader reader = new BufferedReader(input);
 * 
 * for (;;) {
 * System.out.print("> ");
 * String line = reader.readLine();
 * if (line == null) break;
 * run(line);
 * hadError = false;
 * }
 * }
 * 
 * private static void run(String source) {
 * // step 1: Lexical Analysis (Tokenization)
 * Scanner scanner = new Scanner(source);
 * List<Token> tokens = scanner.scanTokens();
 * 
 * System.out.
 * println("############### [Output] Lexical Analysis(Tokenization) #################"
 * );
 * // For now, this just print the tokens.
 * for (Token token : tokens) {
 * System.out.println(token);
 * }
 * 
 * System.out.println("############### [output] Parsing #################");
 * // Step 2: Parsing (Building the AST)
 * Parser parser = new Parser(tokens);
 * Expr expression = parser.parse();
 * 
 * // Step 3: Print the AST
 * if (expression != null) {
 * System.out.println(new ASTPrinter().print(expression));
 * }
 * 
 * // [output] Testcase1
 * // Expr exp = new Expr.Binary(
 * // new Expr.Unary(
 * // new Token(TokenType.MINUS, "-", null,1),
 * // new Expr.Literal(123)
 * // ),
 * // new Token(TokenType.STAR, "*", null, 1),
 * // new Expr.Grouping(
 * // new Expr.Literal(45.67)
 * // )
 * // );
 * 
 * // System.out.println("[output] Testcase1");
 * // System.out.println(new ASTPrinter().print(exp));
 * }
 * 
 * static void error(int line, String message) {
 * report(line, "", message);
 * }
 * 
 * private static void report(int line, String where, String message) {
 * System.err.println("[line " + line + "] Error" + where + ": " + message);
 * hadError = true;
 * }
 * }
 */