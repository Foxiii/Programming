// $ANTLR 3.1.3 Mar 18, 2009 10:09:25 Trs.g 2014-11-24 13:12:16

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class TrsLexer extends Lexer {
    public static final int WS=10;
    public static final int LPAR=7;
    public static final int TO=4;
    public static final int COMMA=8;
    public static final int FSID=6;
    public static final int RPAR=9;
    public static final int EOF=-1;
    public static final int VARID=5;

    // delegates
    // delegators

    public TrsLexer() {;} 
    public TrsLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public TrsLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Trs.g"; }

    // $ANTLR start "LPAR"
    public final void mLPAR() throws RecognitionException {
        try {
            int _type = LPAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Trs.g:46:7: ( '(' )
            // Trs.g:46:11: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAR"

    // $ANTLR start "RPAR"
    public final void mRPAR() throws RecognitionException {
        try {
            int _type = RPAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Trs.g:47:7: ( ')' )
            // Trs.g:47:11: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAR"

    // $ANTLR start "TO"
    public final void mTO() throws RecognitionException {
        try {
            int _type = TO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Trs.g:48:7: ( '->' )
            // Trs.g:48:11: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TO"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Trs.g:49:7: ( ',' )
            // Trs.g:49:11: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "VARID"
    public final void mVARID() throws RecognitionException {
        try {
            int _type = VARID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Trs.g:51:7: ( ( 'A' .. 'Z' ) ( 'a' .. 'z' )* )
            // Trs.g:51:11: ( 'A' .. 'Z' ) ( 'a' .. 'z' )*
            {
            // Trs.g:51:11: ( 'A' .. 'Z' )
            // Trs.g:51:12: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }

            // Trs.g:51:21: ( 'a' .. 'z' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Trs.g:51:22: 'a' .. 'z'
            	    {
            	    matchRange('a','z'); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VARID"

    // $ANTLR start "FSID"
    public final void mFSID() throws RecognitionException {
        try {
            int _type = FSID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Trs.g:52:7: ( ( 'a' .. 'z' )+ )
            // Trs.g:52:11: ( 'a' .. 'z' )+
            {
            // Trs.g:52:11: ( 'a' .. 'z' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Trs.g:52:12: 'a' .. 'z'
            	    {
            	    matchRange('a','z'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FSID"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Trs.g:54:7: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // Trs.g:54:11: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // Trs.g:1:8: ( LPAR | RPAR | TO | COMMA | VARID | FSID | WS )
        int alt3=7;
        switch ( input.LA(1) ) {
        case '(':
            {
            alt3=1;
            }
            break;
        case ')':
            {
            alt3=2;
            }
            break;
        case '-':
            {
            alt3=3;
            }
            break;
        case ',':
            {
            alt3=4;
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
            {
            alt3=5;
            }
            break;
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt3=6;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt3=7;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 3, 0, input);

            throw nvae;
        }

        switch (alt3) {
            case 1 :
                // Trs.g:1:10: LPAR
                {
                mLPAR(); 

                }
                break;
            case 2 :
                // Trs.g:1:15: RPAR
                {
                mRPAR(); 

                }
                break;
            case 3 :
                // Trs.g:1:20: TO
                {
                mTO(); 

                }
                break;
            case 4 :
                // Trs.g:1:23: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 5 :
                // Trs.g:1:29: VARID
                {
                mVARID(); 

                }
                break;
            case 6 :
                // Trs.g:1:35: FSID
                {
                mFSID(); 

                }
                break;
            case 7 :
                // Trs.g:1:40: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}