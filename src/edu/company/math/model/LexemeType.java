package edu.company.math.model;

public enum LexemeType {
    LEFT_BRACKET, RIGHT_BRACKET, //Левая/правая скобка
    OP_MINUS, OP_PLUS, OP_MUL, OP_DIV, //Минус/Плюс/Умножение/Деление
    NUMBER, //Цифра
    EOF //Конец строки
}
