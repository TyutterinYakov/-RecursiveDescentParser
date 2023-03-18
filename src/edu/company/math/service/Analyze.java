package edu.company.math.service;

import edu.company.math.exception.UnexpectedCharacterException;
import edu.company.math.model.Lexeme;
import edu.company.math.model.LexemeType;

import java.util.ArrayList;
import java.util.List;

public class Analyze {

    public List<Lexeme> lexAnalyze(String expText) {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        int pos = 0;
        int length = expText.length();
        while (pos < length) {
            char c = expText.charAt(pos);
            Lexeme lexeme = LexemeType.getLexeme(c);
            if (lexeme != null) {
                lexemes.add(lexeme);
                pos++;
                continue;
            }

            if (c >= '0' && c <= '9') {
                StringBuilder sb = new StringBuilder();
                do {
                    sb.append(c);
                    pos++;
                    if (pos >= length) {
                        break;
                    }
                    c = expText.charAt(pos);

                } while (c <= '9' && c >= '0');
                lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
            } else if (c != ' ') {
                throw new UnexpectedCharacterException("Unexpected symbol \"" + c + "\"");
            }
            pos++;
        }

        lexemes.add(new Lexeme(LexemeType.EOF, ""));

        return lexemes;
    }


}
