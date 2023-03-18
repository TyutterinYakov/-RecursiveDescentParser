package edu.company.math;


import edu.company.math.model.Lexeme;
import edu.company.math.model.LexemeBuffer;
import edu.company.math.service.LexicalAnalyze;
import edu.company.math.service.SyntaxAnalyze;

import java.util.List;

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

    private static final LexicalAnalyze lexAnalyze = new LexicalAnalyze();
    private static final SyntaxAnalyze syntaxAnalyze = new SyntaxAnalyze();

    public static void main(String[] args) {
        String expressionText = "2 + (4 + 2) + 2 + 2 - 3";
        List<Lexeme> lexemes = lexAnalyze.lexAnalyze(expressionText);
        int expr = syntaxAnalyze.expr(new LexemeBuffer(lexemes));
        System.out.println("Result: " + expr);
    }
}
