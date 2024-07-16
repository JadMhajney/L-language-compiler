/***************************/
/* FILE NAME: LEX_FILE.lex */
/***************************/

/*************/
/* USER CODE */
/*************/
import java_cup.runtime.*;

/******************************/
/* DOLAR DOLAR - DON'T TOUCH! */
/******************************/

%%

/************************************/
/* OPTIONS AND DECLARATIONS SECTION */
/************************************/
   
/*****************************************************/ 
/* Lexer is the name of the class JFlex will create. */
/* The code will be written to the file Lexer.java.  */
/*****************************************************/ 
%class Lexer

/********************************************************************/
/* The current line number can be accessed with the variable yyline */
/* and the current column number with the variable yycolumn.        */
/********************************************************************/
%line
%column

/*******************************************************************************/
/* Note that this has to be the EXACT same name of the class the CUP generates */
/*******************************************************************************/
%cupsym TokenNames

/******************************************************************/
/* CUP compatibility mode interfaces with a CUP generated parser. */
/******************************************************************/
%cup

/****************/
/* DECLARATIONS */
/****************/
/*****************************************************************************/   
/* Code between %{ and %}, both of which must be at the beginning of a line, */
/* will be copied verbatim (letter to letter) into the Lexer class code.     */
/* Here you declare member variables and functions that are used inside the  */
/* scanner actions.                                                          */  
/*****************************************************************************/   
%{
	/*********************************************************************************/
	/* Create a new java_cup.runtime.Symbol with information about the current token */
	/*********************************************************************************/
	private Symbol symbol(int type)               {return new Symbol(type, yyline, yycolumn);}
	private Symbol symbol(int type, Object value) {return new Symbol(type, yyline, yycolumn, value);}

	/*******************************************/
	/* Enable line number extraction from main */
	/*******************************************/
	public int getLine() { return yyline + 1; } 

	/**********************************************/
	/* Enable token position extraction from main */
	/**********************************************/
	public int getTokenStartPosition() { return yycolumn + 1; } 


%}

/***********************/
/* MACRO DECALARATIONS */
/***********************/

LineTerminator	= \r|\n|\r\n
WhiteSpace		= [ \t\f] | {LineTerminator}
DIGIT           = [0-9]
LETTER          = [a-zA-Z]
INTEGER         = [1-9]({DIGIT}*) | 0
ID				= {LETTER}({LETTER} | {DIGIT})*
STRING          = \"[a-zA-Z]* \"

LEGAL_PUNC_NSS = [\(\)\[\]\{\}\?\!\+\-\.\;]  
LEGAL_PUNC_NO_STAR = {LEGAL_PUNC_NSS} |  "/" 
LEGAL_PUNC  = {LEGAL_PUNC_NO_STAR} | "*"

TABLE2_NO_PUNC = {LETTER} | {INTEGER} | {WhiteSpace} | {LineTerminator}
TABLE2_NO_STAR =  {TABLE2_NO_PUNC} | {LEGAL_PUNC_NO_STAR} 
TABLE2_NSS = {TABLE2_NO_PUNC} | {LEGAL_PUNC_NSS}

COMMENT_CHARS = {LETTER} | {INTEGER} | {LEGAL_PUNC} | [ \t\f]

TYPE_1_COMMENT  = "//" {COMMENT_CHARS}*{LineTerminator}

COMMENT_2_PREFIX= "/*"
TYPE_2_COMMENT= {COMMENT_2_PREFIX} ({TABLE2_NO_STAR}* | ({TABLE2_NO_STAR}* (\*)+ {TABLE2_NSS}+)* )* (\*)+ (\/)

COMMENT = {TYPE_1_COMMENT} | {TYPE_2_COMMENT}

ILLEGAL_INTEGER = [0]+{INTEGER}+
NON_LETTER = [^a-zA-Z\"] 
ILLEGAL_STRING_1= \"({LETTER}*{NON_LETTER}+{LETTER}*)+ \" 
ILLEGAL_STRING_2 = \" ({LETTER}* | {NON_LETTER}*)* 
ILLEGAL_STRING = {ILLEGAL_STRING_1}  | {ILLEGAL_STRING_2}

ILLEGAL_CHARS = [^0-9a-zA-Z\(\)\[\]\{\}\?\!\+\-\.\;\*\r|\\n|\r\n \t\f]

ILLEGAL_COMMENT_2 = {COMMENT_2_PREFIX}(({COMMENT_CHARS} | {ILLEGAL_CHARS})*{ILLEGAL_CHARS}+({COMMENT_CHARS})*)(\*)+"/"
ILLEGAL_COMMENT_1 = "//" (({COMMENT_CHARS} | {ILLEGAL_CHARS})*{ILLEGAL_CHARS}+({COMMENT_CHARS})*)+

ILLEGAL_COMMENT_3_CHARS = {LETTER} | {INTEGER} | {WhiteSpace} | {LineTerminator} | {LEGAL_PUNC_NSS}

ILLEGAL_COMMENT_3 = {COMMENT_2_PREFIX} (("*" | {ILLEGAL_COMMENT_3_CHARS}){ILLEGAL_COMMENT_3_CHARS}("/" | {ILLEGAL_COMMENT_3_CHARS}))*("/")*

ILLEGAL_COMMENT = {ILLEGAL_COMMENT_1} | {ILLEGAL_COMMENT_2} | {ILLEGAL_COMMENT_3}



/******************************/
/* DOLAR DOLAR - DON'T TOUCH! */
/******************************/

%%

/************************************************************/
/* LEXER matches regular expressions to actions (Java code) */
/************************************************************/

/**************************************************************/
/* YYINITIAL is the state at which the lexer begins scanning. */
/* So these regular expressions will only be matched if the   */
/* scanner is in the start state YYINITIAL.                   */
/**************************************************************/

<YYINITIAL> {


"("					{ return symbol(TokenNames.LPAREN);}
")"					{ return symbol(TokenNames.RPAREN);}
"["                 {return symbol(TokenNames.LBRACK);}
"]"                 {return symbol(TokenNames.RBRACK);}
"{"                 {return symbol(TokenNames.LBRACE);}
"}"                 {return symbol(TokenNames.RBRACE);}
"nil"               {return symbol(TokenNames.NIL);}
"+"					{ return symbol(TokenNames.PLUS);}
"-"					{ return symbol(TokenNames.MINUS);}
"*"					{ return symbol(TokenNames.TIMES);}
"/"					{ return symbol(TokenNames.DIVIDE);}
","                 {return symbol(TokenNames.COMMA);}
"."                 {return symbol(TokenNames.DOT);}
";"                 {return symbol(TokenNames.SEMICOLON);}
"int"               {return symbol(TokenNames.TYPE_INT);}
"void"              {return symbol(TokenNames.TYPE_VOID);}
":="				{ return symbol(TokenNames.ASSIGN);}
"="					{ return symbol(TokenNames.EQ);}
"<"					{ return symbol(TokenNames.LT);}
">"					{ return symbol(TokenNames.GT);}
"array"				{ return symbol(TokenNames.ARRAY);}
"class"				{ return symbol(TokenNames.CLASS);}
"extends"			{ return symbol(TokenNames.EXTENDS);}
"return"			{ return symbol(TokenNames.RETURN);}
"while"				{ return symbol(TokenNames.WHILE);}
"if"				{ return symbol(TokenNames.IF);}
"new"				{ return symbol(TokenNames.NEW);}
{INTEGER} {
    try {
        int intValue = Integer.parseInt(yytext());
        if (intValue < 0 || intValue >= Math.pow(2, 15)) {
            return symbol(TokenNames.ERROR);
        } else {
        return symbol(TokenNames.INT,new Integer(yytext()) );
         }
     }
     catch (NumberFormatException e) {
        return symbol(TokenNames.ERROR);
        }
     }


{STRING}            {return symbol(TokenNames.STRING, new String(yytext()));}
"string"			{ return symbol(TokenNames.TYPE_STRING);}
{ID}				{ return symbol(TokenNames.ID,     new String( yytext()));}

{COMMENT}   {}


{ILLEGAL_INTEGER} {return symbol(TokenNames.ERROR) ;}
{ILLEGAL_STRING}  {return  symbol(TokenNames.ERROR) ;} 
{ILLEGAL_COMMENT} {return symbol(TokenNames.ERROR);}
{ILLEGAL_CHARS} {return symbol(TokenNames.ERROR);}
{WhiteSpace}		{ /* just skip what was found, do nothing */ }


<<EOF>>				{ return symbol(TokenNames.EOF);}
}
