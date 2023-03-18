package edu.company.math;


/*------------------------------------------------------------
*  PARSER RULES
*------------------------------------------------------------*/
// expr: plusminus* EOF
//
// plusminus: muldiv ( ( '+' | '-') multdiv )* ;
//
// multdiv : factor ( ( '*' | '/' ) factor )* ;
//
// factor : NUMBER | '(' expr ')' ;
//
public class Main {

    public static void main(String[] args) {
        String expressionText = "2 + 4 * 2 + (2 + 2) - 3";
    }
}
