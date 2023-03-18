package edu.company.math.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public enum LexemeType {
    LEFT_BRACKET('('), RIGHT_BRACKET(')'), //Левая/правая скобка
    OP_MINUS('-'), OP_PLUS('+'), OP_MUL('*'), OP_DIV('/'), //Минус/Плюс/Умножение/Деление
    NUMBER(null), //Цифра
    EOF(null) //Конец строки
    ;

    private final Character value;

    LexemeType(Character value) {
        this.value = value;
    }

    public static Lexeme getLexeme(char elem) {
        Optional<LexemeType> first = Arrays.stream(LexemeType.values())
                .filter(l -> Objects.equals(l.value, elem)).findFirst();
        return first.map(lexemeType -> new Lexeme(lexemeType, elem)).orElse(null);
    }


}
