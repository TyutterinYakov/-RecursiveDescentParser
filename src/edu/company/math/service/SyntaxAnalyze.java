package edu.company.math.service;

import edu.company.math.exception.UnexpectedCharacterException;
import edu.company.math.model.Lexeme;
import edu.company.math.model.LexemeBuffer;
import edu.company.math.model.LexemeType;

public class SyntaxAnalyze {


    public int plusminus(LexemeBuffer lexemeBuffer) {
        int value = multdiv(lexemeBuffer);
        while(true) {
            Lexeme lexeme = lexemeBuffer.next();
            switch (lexeme.getType()) {
                case OP_PLUS -> value += factor(lexemeBuffer);
                case OP_MINUS -> value -= factor(lexemeBuffer);
                case EOF, RIGHT_BRACKET -> {
                    lexemeBuffer.back();
                    return value;
                }
                default -> throw new UnexpectedCharacterException("Unexpected token: " + lexeme.getValue()
                        + " at position: " + lexemeBuffer.getPos());
            }
        }
    }

    public int expr(LexemeBuffer lexemeBuffer) {
        Lexeme lexeme = lexemeBuffer.next();
        if (lexeme.getType() == LexemeType.EOF) {
            return 0;
        } else {
            lexemeBuffer.back();
            return plusminus(lexemeBuffer);
        }

    }

    public int multdiv(LexemeBuffer lexemeBuffer) {
        int value = factor(lexemeBuffer);
        while(true) {
            Lexeme lexeme = lexemeBuffer.next();
            switch (lexeme.getType()) {
                case OP_MUL -> value *= factor(lexemeBuffer);
                case OP_DIV -> value /= factor(lexemeBuffer);
                case EOF, RIGHT_BRACKET, OP_MINUS, OP_PLUS -> {
                    lexemeBuffer.back();
                    return value;
                }
                default -> throw new UnexpectedCharacterException("Unexpected token: " + lexeme.getValue()
                        + " at position: " + lexemeBuffer.getPos());
            }
        }
    }

//    //Число, либо же выражение в скобках
    public int factor(LexemeBuffer lexemeBuffer) {
        Lexeme lexeme = lexemeBuffer.next();
        switch (lexeme.getType()) {
            case NUMBER -> {
                return Integer.parseInt(lexeme.getValue());
            } case LEFT_BRACKET -> {
                int value = plusminus(lexemeBuffer);
                lexeme = lexemeBuffer.next();
                if (lexeme.getType() != LexemeType.RIGHT_BRACKET) {
                    throw new UnexpectedCharacterException(
                            "Отсутствует закрывающая скобка. Позиция: " + lexemeBuffer.getPos());
                }
                return value;
            } default -> throw new UnexpectedCharacterException(
                    "Неожиданная лексема " + lexeme + " на позиции " + lexemeBuffer.getPos());
        }
    }

}
