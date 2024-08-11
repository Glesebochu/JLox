package com.craftinginterpreters.lox;

public class Set extends Expr {
    public final Expr object;
    public final Token name;
    public final Expr value;

    public Set(Expr object, Token name, Expr value) {
        this.object = object;
        this.name = name;
        this.value = value;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitSetExpr(this);
    }
}
