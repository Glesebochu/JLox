package com.craftinginterpreters.lox;

public interface Visitor<R> {
    R visitBinaryExpr(Expr.Binary expr);
    R visitGroupingExpr(Expr.Grouping expr);
    R visitLiteralExpr(Expr.Literal expr);
    R visitUnaryExpr(Expr.Unary expr);
    R visitVariableExpr(Expr.Variable expr);
    R visitAssignExpr(Expr.Assign expr);
    R visitLogicalExpr(Expr.Logical expr);
    R visitCallExpr(Expr.Call expr);
    R visitGetExpr(Expr.Get expr);
    R visitSetExpr(Expr.Set expr);
    R visitThisExpr(Expr.This expr);
    R visitSuperExpr(Expr.Super expr);
}
