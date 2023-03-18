package edu.company.math;


import edu.company.math.model.Lexeme;
import edu.company.math.service.Analyze;

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

    private static final Analyze analyze = new Analyze();

    public static void main(String[] args) {
        String expressionText = "222222 + 4 * 2 + (2 + 2) - 3";
        List<Lexeme> lexemes = analyze.lexAnalyze(expressionText);

        System.out.println(lexemes);
    }
}
