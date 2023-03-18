package edu.company.math.model;


import java.util.List;

public class LexemeBuffer {
    private int pos;

    private final List<Lexeme> lexemes;

    public LexemeBuffer(List<Lexeme> lexemes) {
        this.lexemes = lexemes;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public Lexeme next() {
        return lexemes.get(pos++);
    }

    public void back() {
        --pos;
    }

}
