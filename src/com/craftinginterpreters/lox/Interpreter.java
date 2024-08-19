package com.craftinginterpreters.lox;


public class Interpreter {

    public Object evaluate(Expr expr) {
        if (expr instanceof Expr.Binary) {
            return evaluateBinaryExpr((Expr.Binary) expr);
        } else if (expr instanceof Expr.Literal) {
            return ((Expr.Literal) expr).value;
        }
        // Add more cases for other expression types
        return null;
    }

    private Object evaluateBinaryExpr(Expr.Binary expr) {
        Object left = evaluate(expr.left);
        Object right = evaluate(expr.right);

        switch (expr.operator.type) {
            case PLUS:
                return (double) left + (double) right;
            case MINUS:
                return (double) left - (double) right;
            case STAR:
                return (double) left * (double) right;
            case SLASH:
                return (double) left / (double) right;
        }

        return null;
    }
}
