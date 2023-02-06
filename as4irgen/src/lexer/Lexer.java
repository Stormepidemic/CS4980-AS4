/* This file was generated by SableCC (http://www.sablecc.org/). */

package lexer;

import java.io.*;
import node.*;

@SuppressWarnings("nls")
public class Lexer
{
    protected Token token;
    protected State state = State.INITIAL;

    private IPushbackReader in;
    private int line;
    private int pos;
    private boolean cr;
    private boolean eof;
    private final StringBuffer text = new StringBuffer();

    @SuppressWarnings("unused")
    protected void filter() throws LexerException, IOException
    {
        // Do nothing
    }

    public Lexer(@SuppressWarnings("hiding") final PushbackReader in)
    {
        this.in = new IPushbackReader() {

            private PushbackReader pushbackReader = in;
            
            @Override
            public void unread(int c) throws IOException {
                pushbackReader.unread(c);
            }
            
            @Override
            public int read() throws IOException {
                return pushbackReader.read();
            }
        };
    }
 
    public Lexer(@SuppressWarnings("hiding") IPushbackReader in)
    {
        this.in = in;
    }
 
    public Token peek() throws LexerException, IOException
    {
        while(this.token == null)
        {
            this.token = getToken();
            filter();
        }

        return this.token;
    }

    public Token next() throws LexerException, IOException
    {
        while(this.token == null)
        {
            this.token = getToken();
            filter();
        }

        Token result = this.token;
        this.token = null;
        return result;
    }

    protected Token getToken() throws IOException, LexerException
    {
        int dfa_state = 0;

        int start_pos = this.pos;
        int start_line = this.line;

        int accept_state = -1;
        int accept_token = -1;
        int accept_length = -1;
        int accept_pos = -1;
        int accept_line = -1;

        @SuppressWarnings("hiding") int[][][] gotoTable = Lexer.gotoTable[this.state.id()];
        @SuppressWarnings("hiding") int[] accept = Lexer.accept[this.state.id()];
        this.text.setLength(0);

        while(true)
        {
            int c = getChar();

            if(c != -1)
            {
                switch(c)
                {
                case 10:
                    if(this.cr)
                    {
                        this.cr = false;
                    }
                    else
                    {
                        this.line++;
                        this.pos = 0;
                    }
                    break;
                case 13:
                    this.line++;
                    this.pos = 0;
                    this.cr = true;
                    break;
                default:
                    this.pos++;
                    this.cr = false;
                    break;
                }

                this.text.append((char) c);

                do
                {
                    int oldState = (dfa_state < -1) ? (-2 -dfa_state) : dfa_state;

                    dfa_state = -1;

                    int[][] tmp1 =  gotoTable[oldState];
                    int low = 0;
                    int high = tmp1.length - 1;

                    while(low <= high)
                    {
                        // int middle = (low + high) / 2;
                        int middle = (low + high) >>> 1;
                        int[] tmp2 = tmp1[middle];

                        if(c < tmp2[0])
                        {
                            high = middle - 1;
                        }
                        else if(c > tmp2[1])
                        {
                            low = middle + 1;
                        }
                        else
                        {
                            dfa_state = tmp2[2];
                            break;
                        }
                    }
                }while(dfa_state < -1);
            }
            else
            {
                dfa_state = -1;
            }

            if(dfa_state >= 0)
            {
                if(accept[dfa_state] != -1)
                {
                    accept_state = dfa_state;
                    accept_token = accept[dfa_state];
                    accept_length = this.text.length();
                    accept_pos = this.pos;
                    accept_line = this.line;
                }
            }
            else
            {
                if(accept_state != -1)
                {
                    switch(accept_token)
                    {
                    case 0:
                        {
                            @SuppressWarnings("hiding") Token token = new0(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 1:
                        {
                            @SuppressWarnings("hiding") Token token = new1(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 2:
                        {
                            @SuppressWarnings("hiding") Token token = new2(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 3:
                        {
                            @SuppressWarnings("hiding") Token token = new3(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 4:
                        {
                            @SuppressWarnings("hiding") Token token = new4(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 5:
                        {
                            @SuppressWarnings("hiding") Token token = new5(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 6:
                        {
                            @SuppressWarnings("hiding") Token token = new6(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 7:
                        {
                            @SuppressWarnings("hiding") Token token = new7(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 8:
                        {
                            @SuppressWarnings("hiding") Token token = new8(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 9:
                        {
                            @SuppressWarnings("hiding") Token token = new9(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 10:
                        {
                            @SuppressWarnings("hiding") Token token = new10(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 11:
                        {
                            @SuppressWarnings("hiding") Token token = new11(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 12:
                        {
                            @SuppressWarnings("hiding") Token token = new12(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 13:
                        {
                            @SuppressWarnings("hiding") Token token = new13(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 14:
                        {
                            @SuppressWarnings("hiding") Token token = new14(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 15:
                        {
                            @SuppressWarnings("hiding") Token token = new15(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 16:
                        {
                            @SuppressWarnings("hiding") Token token = new16(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 17:
                        {
                            @SuppressWarnings("hiding") Token token = new17(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 18:
                        {
                            @SuppressWarnings("hiding") Token token = new18(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 19:
                        {
                            @SuppressWarnings("hiding") Token token = new19(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 20:
                        {
                            @SuppressWarnings("hiding") Token token = new20(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 21:
                        {
                            @SuppressWarnings("hiding") Token token = new21(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 22:
                        {
                            @SuppressWarnings("hiding") Token token = new22(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 23:
                        {
                            @SuppressWarnings("hiding") Token token = new23(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 24:
                        {
                            @SuppressWarnings("hiding") Token token = new24(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 25:
                        {
                            @SuppressWarnings("hiding") Token token = new25(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 26:
                        {
                            @SuppressWarnings("hiding") Token token = new26(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 27:
                        {
                            @SuppressWarnings("hiding") Token token = new27(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 28:
                        {
                            @SuppressWarnings("hiding") Token token = new28(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 29:
                        {
                            @SuppressWarnings("hiding") Token token = new29(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 30:
                        {
                            @SuppressWarnings("hiding") Token token = new30(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 31:
                        {
                            @SuppressWarnings("hiding") Token token = new31(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 32:
                        {
                            @SuppressWarnings("hiding") Token token = new32(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 33:
                        {
                            @SuppressWarnings("hiding") Token token = new33(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 34:
                        {
                            @SuppressWarnings("hiding") Token token = new34(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 35:
                        {
                            @SuppressWarnings("hiding") Token token = new35(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 36:
                        {
                            @SuppressWarnings("hiding") Token token = new36(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 37:
                        {
                            @SuppressWarnings("hiding") Token token = new37(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    }
                }
                else
                {
                    if(this.text.length() > 0)
                    {
                        throw new LexerException(
                            new InvalidToken(this.text.substring(0, 1), start_line + 1, start_pos + 1),
                            "[" + (start_line + 1) + "," + (start_pos + 1) + "]" +
                            " Unknown token: " + this.text);
                    }

                    @SuppressWarnings("hiding") EOF token = new EOF(
                        start_line + 1,
                        start_pos + 1);
                    return token;
                }
            }
        }
    }

    Token new0(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TBoolean(line, pos); }
    Token new1(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TClas(line, pos); }
    Token new2(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TElse(line, pos); }
    Token new3(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TFalse(line, pos); }
    Token new4(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TIf(line, pos); }
    Token new5(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TInt(line, pos); }
    Token new6(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TMain(line, pos); }
    Token new7(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TNew(line, pos); }
    Token new8(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TPrintln(line, pos); }
    Token new9(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TPublic(line, pos); }
    Token new10(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TReturn(line, pos); }
    Token new11(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TStatic(line, pos); }
    Token new12(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TString(line, pos); }
    Token new13(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TThis(line, pos); }
    Token new14(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TTrue(line, pos); }
    Token new15(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TVoid(line, pos); }
    Token new16(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TWhile(line, pos); }
    Token new17(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TLbracket(line, pos); }
    Token new18(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TRbracket(line, pos); }
    Token new19(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TSemi(line, pos); }
    Token new20(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TLparen(line, pos); }
    Token new21(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TRparen(line, pos); }
    Token new22(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TLbrace(line, pos); }
    Token new23(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TRbrace(line, pos); }
    Token new24(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TEqual(line, pos); }
    Token new25(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TDot(line, pos); }
    Token new26(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TBang(line, pos); }
    Token new27(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TComma(line, pos); }
    Token new28(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TPlus(line, pos); }
    Token new29(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TAnd(line, pos); }
    Token new30(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TLess(line, pos); }
    Token new31(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TMinus(line, pos); }
    Token new32(@SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TStar(line, pos); }
    Token new33(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TId(text, line, pos); }
    Token new34(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TNumber(text, line, pos); }
    Token new35(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TWhitespace(text, line, pos); }
    Token new36(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TLineComment(text, line, pos); }
    Token new37(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TSlashstarComment(text, line, pos); }

    private int getChar() throws IOException
    {
        if(this.eof)
        {
            return -1;
        }

        int result = this.in.read();

        if(result == -1)
        {
            this.eof = true;
        }

        return result;
    }

    private void pushBack(int acceptLength) throws IOException
    {
        int length = this.text.length();
        for(int i = length - 1; i >= acceptLength; i--)
        {
            this.eof = false;

            this.in.unread(this.text.charAt(i));
        }
    }

    protected void unread(@SuppressWarnings("hiding") Token token) throws IOException
    {
        @SuppressWarnings("hiding") String text = token.getText();
        int length = text.length();

        for(int i = length - 1; i >= 0; i--)
        {
            this.eof = false;

            this.in.unread(text.charAt(i));
        }

        this.pos = token.getPos() - 1;
        this.line = token.getLine() - 1;
    }

    private String getText(int acceptLength)
    {
        StringBuffer s = new StringBuffer(acceptLength);
        for(int i = 0; i < acceptLength; i++)
        {
            s.append(this.text.charAt(i));
        }

        return s.toString();
    }

    private static int[][][][] gotoTable;
/*  {
        { // INITIAL
            {{9, 9, 1}, {10, 10, 2}, {11, 11, 3}, {12, 12, 4}, {13, 13, 5}, {32, 32, 6}, {33, 33, 7}, {38, 38, 8}, {40, 40, 9}, {41, 41, 10}, {42, 42, 11}, {43, 43, 12}, {44, 44, 13}, {45, 45, 14}, {46, 46, 15}, {47, 47, 16}, {48, 57, 17}, {59, 59, 18}, {60, 60, 19}, {61, 61, 20}, {65, 82, 21}, {83, 83, 22}, {84, 90, 21}, {91, 91, 23}, {93, 93, 24}, {97, 97, 25}, {98, 98, 26}, {99, 99, 27}, {100, 100, 25}, {101, 101, 28}, {102, 102, 29}, {103, 104, 25}, {105, 105, 30}, {106, 108, 25}, {109, 109, 31}, {110, 110, 32}, {111, 111, 25}, {112, 112, 33}, {113, 113, 25}, {114, 114, 34}, {115, 115, 35}, {116, 116, 36}, {117, 117, 25}, {118, 118, 37}, {119, 119, 38}, {120, 122, 25}, {123, 123, 39}, {125, 125, 40}, },
            {{9, 32, -2}, },
            {{9, 32, -2}, },
            {{9, 32, -2}, },
            {{9, 32, -2}, },
            {{9, 32, -2}, },
            {{9, 32, -2}, },
            {},
            {{38, 38, 41}, },
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {{42, 42, 42}, {47, 47, 43}, },
            {{48, 57, 17}, },
            {},
            {},
            {},
            {{48, 57, 44}, {65, 90, 45}, {95, 95, 46}, {97, 122, 47}, },
            {{48, 95, -23}, {97, 115, 47}, {116, 116, 48}, {117, 120, 47}, {121, 121, 49}, {122, 122, 47}, },
            {},
            {},
            {{48, 122, -23}, },
            {{48, 95, -23}, {97, 110, 47}, {111, 111, 50}, {112, 122, 47}, },
            {{48, 95, -23}, {97, 107, 47}, {108, 108, 51}, {109, 122, 47}, },
            {{48, 107, -29}, {108, 108, 52}, {109, 122, 47}, },
            {{48, 95, -23}, {97, 97, 53}, {98, 122, 47}, },
            {{48, 95, -23}, {97, 101, 47}, {102, 102, 54}, {103, 109, 47}, {110, 110, 55}, {111, 122, 47}, },
            {{48, 95, -23}, {97, 97, 56}, {98, 122, 47}, },
            {{48, 95, -23}, {97, 100, 47}, {101, 101, 57}, {102, 122, 47}, },
            {{48, 95, -23}, {97, 116, 47}, {117, 117, 58}, {118, 122, 47}, },
            {{48, 100, -34}, {101, 101, 59}, {102, 122, 47}, },
            {{48, 115, -24}, {116, 116, 60}, {117, 122, 47}, },
            {{48, 95, -23}, {97, 103, 47}, {104, 104, 61}, {105, 113, 47}, {114, 114, 62}, {115, 122, 47}, },
            {{48, 110, -28}, {111, 111, 63}, {112, 122, 47}, },
            {{48, 103, -38}, {104, 104, 64}, {105, 122, 47}, },
            {},
            {},
            {},
            {{0, 41, 65}, {42, 42, 66}, {43, 127, 67}, },
            {{0, 9, 68}, {10, 10, 69}, {11, 11, 70}, {12, 12, 71}, {13, 127, 72}, },
            {{48, 122, -23}, },
            {{48, 122, -23}, },
            {{48, 122, -23}, },
            {{48, 122, -23}, },
            {{48, 95, -23}, {97, 113, 47}, {114, 114, 73}, {115, 122, 47}, },
            {{48, 95, -23}, {97, 114, 47}, {115, 115, 74}, {116, 122, 47}, },
            {{48, 110, -28}, {111, 111, 75}, {112, 122, 47}, },
            {{48, 95, -23}, {97, 97, 76}, {98, 122, 47}, },
            {{48, 114, -51}, {115, 115, 77}, {116, 122, 47}, },
            {{48, 107, -29}, {108, 108, 78}, {109, 122, 47}, },
            {{48, 122, -23}, },
            {{48, 115, -24}, {116, 116, 79}, {117, 122, 47}, },
            {{48, 95, -23}, {97, 104, 47}, {105, 105, 80}, {106, 122, 47}, },
            {{48, 95, -23}, {97, 118, 47}, {119, 119, 81}, {120, 122, 47}, },
            {{48, 95, -23}, {97, 97, 47}, {98, 98, 82}, {99, 122, 47}, },
            {{48, 115, -24}, {116, 116, 83}, {117, 122, 47}, },
            {{48, 95, -23}, {97, 97, 84}, {98, 122, 47}, },
            {{48, 104, -58}, {105, 105, 85}, {106, 122, 47}, },
            {{48, 116, -35}, {117, 117, 86}, {118, 122, 47}, },
            {{48, 104, -58}, {105, 105, 87}, {106, 122, 47}, },
            {{48, 104, -58}, {105, 105, 88}, {106, 122, 47}, },
            {{0, 127, -44}, },
            {{0, 41, 89}, {42, 42, 66}, {43, 46, 90}, {47, 47, 91}, {48, 127, 92}, },
            {{0, 127, -44}, },
            {{0, 127, -45}, },
            {},
            {{0, 127, -45}, },
            {{0, 127, -45}, },
            {{0, 127, -45}, },
            {{48, 104, -58}, {105, 105, 93}, {106, 122, 47}, },
            {{48, 115, -24}, {116, 116, 94}, {117, 122, 47}, },
            {{48, 107, -29}, {108, 108, 95}, {109, 122, 47}, },
            {{48, 114, -51}, {115, 115, 96}, {116, 122, 47}, },
            {{48, 100, -34}, {101, 101, 97}, {102, 122, 47}, },
            {{48, 114, -51}, {115, 115, 98}, {116, 122, 47}, },
            {{48, 122, -23}, },
            {{48, 95, -23}, {97, 109, 47}, {110, 110, 99}, {111, 122, 47}, },
            {{48, 122, -23}, },
            {{48, 107, -29}, {108, 108, 100}, {109, 122, 47}, },
            {{48, 116, -35}, {117, 117, 101}, {118, 122, 47}, },
            {{48, 115, -24}, {116, 116, 102}, {117, 122, 47}, },
            {{48, 114, -51}, {115, 115, 103}, {116, 122, 47}, },
            {{48, 100, -34}, {101, 101, 104}, {102, 122, 47}, },
            {{48, 95, -23}, {97, 99, 47}, {100, 100, 105}, {101, 122, 47}, },
            {{48, 107, -29}, {108, 108, 106}, {109, 122, 47}, },
            {{0, 41, 107}, {42, 42, 108}, {43, 127, 109}, },
            {{0, 127, -91}, },
            {},
            {{0, 127, -91}, },
            {{48, 109, -82}, {110, 110, 110}, {111, 122, 47}, },
            {{48, 100, -34}, {101, 101, 111}, {102, 122, 47}, },
            {{48, 100, -34}, {101, 101, 112}, {102, 122, 47}, },
            {{48, 114, -51}, {115, 115, 113}, {116, 122, 47}, },
            {{48, 122, -23}, },
            {{48, 100, -34}, {101, 101, 114}, {102, 122, 47}, },
            {{48, 122, -23}, },
            {{48, 104, -58}, {105, 105, 115}, {106, 122, 47}, },
            {{48, 113, -50}, {114, 114, 116}, {115, 122, 47}, },
            {{48, 104, -58}, {105, 105, 117}, {106, 122, 47}, },
            {{48, 122, -23}, },
            {{48, 122, -23}, },
            {{48, 122, -23}, },
            {{48, 100, -34}, {101, 101, 118}, {102, 122, 47}, },
            {{0, 127, -91}, },
            {{0, 41, 89}, {42, 42, 108}, {43, 127, -68}, },
            {{0, 127, -91}, },
            {{48, 95, -23}, {97, 102, 47}, {103, 103, 119}, {104, 122, 47}, },
            {{48, 95, -23}, {97, 108, 47}, {109, 109, 120}, {110, 122, 47}, },
            {{48, 95, -23}, {97, 97, 121}, {98, 122, 47}, },
            {{48, 122, -23}, },
            {{48, 122, -23}, },
            {{48, 95, -23}, {97, 98, 47}, {99, 99, 122}, {100, 122, 47}, },
            {{48, 109, -82}, {110, 110, 123}, {111, 122, 47}, },
            {{48, 98, -117}, {99, 99, 124}, {100, 122, 47}, },
            {{48, 122, -23}, },
            {{48, 122, -23}, },
            {{46, 46, 125}, {48, 122, -23}, },
            {{48, 109, -82}, {110, 110, 126}, {111, 122, 47}, },
            {{48, 122, -23}, },
            {{48, 122, -23}, },
            {{48, 122, -23}, },
            {{111, 111, 127}, },
            {{48, 122, -23}, },
            {{117, 117, 128}, },
            {{116, 116, 129}, },
            {{46, 46, 130}, },
            {{112, 112, 131}, },
            {{114, 114, 132}, },
            {{105, 105, 133}, },
            {{110, 110, 134}, },
            {{116, 116, 135}, },
            {{108, 108, 136}, },
            {{110, 110, 137}, },
            {},
        }
    };*/

    private static int[][] accept;
/*  {
        // INITIAL
        {35, 35, 35, 35, 35, 35, 35, 26, -1, 20, 21, 32, 28, 27, 31, 25, -1, 34, 19, 30, 24, 33, 33, 17, 18, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 22, 23, 29, -1, -1, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 4, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, -1, -1, -1, -1, 36, 36, 36, -1, 33, 33, 33, 33, 33, 33, 5, 33, 7, 33, 33, 33, 33, 33, 33, 33, -1, -1, 37, -1, 33, 33, 33, 33, 2, 33, 6, 33, 33, 33, 13, 14, 15, 33, -1, -1, -1, 33, 33, 33, 1, 3, 33, 33, 33, 16, 12, 33, 33, 9, 10, 11, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 8, },

    };*/

    public static class State
    {
        public final static State INITIAL = new State(0);

        private int id;

        private State(@SuppressWarnings("hiding") int id)
        {
            this.id = id;
        }

        public int id()
        {
            return this.id;
        }
    }

    static 
    {
        try
        {
            DataInputStream s = new DataInputStream(
                new BufferedInputStream(
                Lexer.class.getResourceAsStream("lexer.dat")));

            // read gotoTable
            int length = s.readInt();
            gotoTable = new int[length][][][];
            for(int i = 0; i < gotoTable.length; i++)
            {
                length = s.readInt();
                gotoTable[i] = new int[length][][];
                for(int j = 0; j < gotoTable[i].length; j++)
                {
                    length = s.readInt();
                    gotoTable[i][j] = new int[length][3];
                    for(int k = 0; k < gotoTable[i][j].length; k++)
                    {
                        for(int l = 0; l < 3; l++)
                        {
                            gotoTable[i][j][k][l] = s.readInt();
                        }
                    }
                }
            }

            // read accept
            length = s.readInt();
            accept = new int[length][];
            for(int i = 0; i < accept.length; i++)
            {
                length = s.readInt();
                accept[i] = new int[length];
                for(int j = 0; j < accept[i].length; j++)
                {
                    accept[i][j] = s.readInt();
                }
            }

            s.close();
        }
        catch(Exception e)
        {
            throw new RuntimeException("The file \"lexer.dat\" is either missing or corrupted.");
        }
    }
}
