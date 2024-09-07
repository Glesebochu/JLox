
![JLox2](https://github.com/user-attachments/assets/65a5db2d-401c-4b71-8b3a-bc59fb8ee95b)

## JLox - A Tree-Walk Interpreter for the Lox Programming Language

**JLox** is a tree-walk interpreter for the Lox programming language, implemented in Java. This project is based on the book *Crafting Interpreters* by Robert Nystrom and follows the development of the Lox interpreter step-by-step.

Lox is a dynamically-typed, garbage-collected, and simple scripting language with features like first-class functions, lexical scoping, closures, and object-oriented capabilities.

---

### Key Features:
- **Lexical Scoping**: Variables and functions follow strict block-based scoping.
- **Closures**: Functions can capture and remember variables from their enclosing environment.
- **Dynamic Typing**: No need to declare types for variables.
- **Functions**: First-class support for user-defined functions and recursion.
- **Control Flow**: If statements, while loops, and for loops are all supported.

---

### How It Works:

JLox interprets Lox source code using the following stages:
1. **Scanning**: Converts the source code into a list of tokens.
2. **Parsing**: Builds an Abstract Syntax Tree (AST) from the tokens.
3. **Resolving**: Analyzes variable bindings and scopes.
4. **Interpreting**: Walks the AST and executes the Lox program.

This project includes everything up to **Chapter 11** of *Crafting Interpreters*, covering control flow, function declarations, closures, and variable resolution.

---

### How to Get Started:

#### 1. Clone the repository:
```bash
git clone https://github.com/yourusername/JLox.git
cd JLox
```

#### 2. Compile the source code:
```bash
javac -d build src/com/craftinginterpreters/lox/*.java
```

#### 3. Run a Lox script:
You can run a Lox script by passing the file to the interpreter:
```bash
java -cp build com.craftinginterpreters.lox.Lox path/to/your_script.lox
```

#### 4. Run the interactive REPL:
You can also use JLox’s REPL to try out Lox interactively:
```bash
java -cp build com.craftinginterpreters.lox.Lox
```

---

### Example Lox Code:

```lox
// Define a simple function and call it
fun greet(name) {
  print "Hello, " + name + "!";
}

greet("World"); // Outputs: Hello, World!

// Test closures
fun makeCounter() {
  var count = 0;
  fun increment() {
    count = count + 1;
    return count;
  }
  return increment;
}

var counter = makeCounter();
print counter(); // Outputs: 1
print counter(); // Outputs: 2
```

---

### Contributing:

Contributions are welcome! If you'd like to add new features, fix bugs, or enhance documentation, feel free to open a pull request or raise an issue.

Here are a few ways to contribute:
1. **Add more features**: Object-oriented programming support, more built-in functions, or optimizations.
2. **Improve the interpreter**: Implement performance enhancements or refactor the current architecture.
3. **Write more tests**: Help extend the test coverage for edge cases and corner scenarios.

---

### The Team

1. Zelalem Amare (NV3369)
2. Abenezer Walelign (TG3042)
3. Intisar Anwar (EK9824)
4. Yanet Abrham (PM9785)

---

### Acknowledgments:

JLox is based on *Crafting Interpreters* by Robert Nystrom, an invaluable resource for anyone interested in building interpreters or compilers from scratch. Check out the book for a more detailed explanation of how JLox works under the hood.
