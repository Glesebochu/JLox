package com.craftinginterpreters.lox;

public class Variable extends Expr {
    public final Token name;

    public Variable(Token name) {
        this.name = name;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitVariableExpr(this);
    }
}
