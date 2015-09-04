// $ANTLR 3.1.3 Mar 18, 2009 10:09:25 Trs.g 2014-11-24 13:12:15

import java.util.List;
import java.util.LinkedList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class TrsParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TO", "VARID", "FSID", "LPAR", "COMMA", "RPAR", "WS"
    };
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


        public TrsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public TrsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return TrsParser.tokenNames; }
    public String getGrammarFileName() { return "Trs.g"; }



    // $ANTLR start "trs"
    // Trs.g:12:1: trs returns [Trs trs] : ( decl[rules] )* ;
    public final Trs trs() throws RecognitionException {
        Trs trs = null;


                List<Rule> rules = new LinkedList<>();
            
        try {
            // Trs.g:16:5: ( ( decl[rules] )* )
            // Trs.g:16:9: ( decl[rules] )*
            {
            // Trs.g:16:9: ( decl[rules] )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=VARID && LA1_0<=FSID)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Trs.g:16:9: decl[rules]
            	    {
            	    pushFollow(FOLLOW_decl_in_trs51);
            	    decl(rules);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             trs = new Trs(rules.toArray(new Rule[rules.size()])); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return trs;
    }
    // $ANTLR end "trs"


    // $ANTLR start "decl"
    // Trs.g:19:1: decl[List<Rule> rules] : r= rule ;
    public final void decl(List<Rule> rules) throws RecognitionException {
        Rule r = null;


        try {
            // Trs.g:20:5: (r= rule )
            // Trs.g:20:9: r= rule
            {
            pushFollow(FOLLOW_rule_in_decl80);
            r=rule();

            state._fsp--;

            rules.add(r); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "decl"


    // $ANTLR start "rule"
    // Trs.g:22:1: rule returns [Rule rule] : l= term TO r= term ;
    public final Rule rule() throws RecognitionException {
        Rule rule = null;

        Term l = null;

        Term r = null;


        try {
            // Trs.g:23:5: (l= term TO r= term )
            // Trs.g:23:9: l= term TO r= term
            {
            pushFollow(FOLLOW_term_in_rule102);
            l=term();

            state._fsp--;

            match(input,TO,FOLLOW_TO_in_rule104); 
            pushFollow(FOLLOW_term_in_rule108);
            r=term();

            state._fsp--;

             rule = new Rule(l, r); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return rule;
    }
    // $ANTLR end "rule"


    // $ANTLR start "term"
    // Trs.g:25:1: term returns [Term t] : (s= var | s= funApp ) ;
    public final Term term() throws RecognitionException {
        Term t = null;

        Term s = null;


        try {
            // Trs.g:26:5: ( (s= var | s= funApp ) )
            // Trs.g:26:7: (s= var | s= funApp )
            {
            // Trs.g:26:7: (s= var | s= funApp )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==VARID) ) {
                alt2=1;
            }
            else if ( (LA2_0==FSID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // Trs.g:26:8: s= var
                    {
                    pushFollow(FOLLOW_var_in_term128);
                    s=var();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // Trs.g:26:16: s= funApp
                    {
                    pushFollow(FOLLOW_funApp_in_term136);
                    s=funApp();

                    state._fsp--;


                    }
                    break;

            }

             t = s; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return t;
    }
    // $ANTLR end "term"


    // $ANTLR start "var"
    // Trs.g:28:1: var returns [Term t] : name= VARID ;
    public final Term var() throws RecognitionException {
        Term t = null;

        Token name=null;

        try {
            // Trs.g:29:5: (name= VARID )
            // Trs.g:29:9: name= VARID
            {
            name=(Token)match(input,VARID,FOLLOW_VARID_in_var159); 
             t = new Variable(name.getText()); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return t;
    }
    // $ANTLR end "var"


    // $ANTLR start "funApp"
    // Trs.g:32:1: funApp returns [Term f] : fs= FSID ( LPAR (t= term ) ( COMMA (t= term ) )* RPAR )? ;
    public final Term funApp() throws RecognitionException {
        Term f = null;

        Token fs=null;
        Term t = null;


         LinkedList<Term> args = new LinkedList<>(); 
        try {
            // Trs.g:34:5: (fs= FSID ( LPAR (t= term ) ( COMMA (t= term ) )* RPAR )? )
            // Trs.g:34:9: fs= FSID ( LPAR (t= term ) ( COMMA (t= term ) )* RPAR )?
            {
            fs=(Token)match(input,FSID,FOLLOW_FSID_in_funApp198); 
            // Trs.g:35:9: ( LPAR (t= term ) ( COMMA (t= term ) )* RPAR )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==LPAR) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // Trs.g:36:13: LPAR (t= term ) ( COMMA (t= term ) )* RPAR
                    {
                    match(input,LPAR,FOLLOW_LPAR_in_funApp222); 
                    // Trs.g:37:13: (t= term )
                    // Trs.g:37:14: t= term
                    {
                    pushFollow(FOLLOW_term_in_funApp239);
                    t=term();

                    state._fsp--;

                     args.add(t); 

                    }

                    // Trs.g:38:13: ( COMMA (t= term ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==COMMA) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // Trs.g:39:17: COMMA (t= term )
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_funApp274); 
                    	    // Trs.g:40:17: (t= term )
                    	    // Trs.g:40:18: t= term
                    	    {
                    	    pushFollow(FOLLOW_term_in_funApp295);
                    	    t=term();

                    	    state._fsp--;

                    	     args.add(t); 

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    match(input,RPAR,FOLLOW_RPAR_in_funApp327); 

                    }
                    break;

            }

             f = new FunApp(new Symbol(fs.getText()), args.toArray(new Term[args.size()])); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return f;
    }
    // $ANTLR end "funApp"

    // Delegated rules


 

    public static final BitSet FOLLOW_decl_in_trs51 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_rule_in_decl80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_rule102 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TO_in_rule104 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_term_in_rule108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_in_term128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funApp_in_term136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARID_in_var159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FSID_in_funApp198 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_LPAR_in_funApp222 = new BitSet(new long[]{0x0000000000000360L});
    public static final BitSet FOLLOW_term_in_funApp239 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_COMMA_in_funApp274 = new BitSet(new long[]{0x0000000000000360L});
    public static final BitSet FOLLOW_term_in_funApp295 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_RPAR_in_funApp327 = new BitSet(new long[]{0x0000000000000002L});

}