package edu.company.math.model;

public class Lexeme {

    private LexemeType lexemeType;
    private String value;

    public Lexeme() {
    }

    public Lexeme(LexemeType lexemeType, String value) {
        this.lexemeType = lexemeType;
        this.value = value;
    }

    public Lexeme(LexemeType lexemeType, Character value) {
        this.lexemeType = lexemeType;
        this.value = value.toString();
    }

    public LexemeType getLexemeType() {
        return lexemeType;
    }

    public void setLexemeType(LexemeType lexemeType) {
        this.lexemeType = lexemeType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Lexeme{" +
                "lexemeType=" + lexemeType +
                ", value='" + value + '\'' +
                '}';
    }
}
