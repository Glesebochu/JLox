package com.craftinginterpreters.lox;

import java.beans.Expression;

import com.craftinginterpreters.lox.Stmt.Block;
import com.craftinginterpreters.lox.Stmt.If;
import com.craftinginterpreters.lox.Stmt.Print;
import com.craftinginterpreters.lox.Stmt.Var;
import com.craftinginterpreters.lox.Stmt.While;

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
    R visitExpressionStmt(Expression stmt);
    R visitPrintStmt(Print stmt);
    R visitVarStmt(Var stmt);
    R visitBlockStmt(Block stmt);
    R visitIfStmt(If stmt);
    R visitWhileStmt(While stmt);
}
