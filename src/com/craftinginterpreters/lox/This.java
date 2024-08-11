package com.craftinginterpreters.lox;

public class This extends Expr {
    public final Token keyword;

    public This(Token keyword) {
        this.keyword = keyword;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitThisExpr(this);
    }
}
