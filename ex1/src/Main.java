   
import java.io.*;
import java.io.PrintWriter;
import java_cup.runtime.Symbol;


public class Main
{

	public static void print_token(PrintWriter file_writer,Lexer l,Symbol s){
		file_writer.print("[");
		file_writer.print(l.getLine());
		file_writer.print(",");
		file_writer.print(l.getTokenStartPosition());
		file_writer.print("]");
		file_writer.print("\n");
	}

	static public void main(String argv[])
	{
		Lexer l;
		Symbol s;
		FileReader file_reader;
		PrintWriter file_writer;
		String inputFilename = argv[0];
		String outputFilename = argv[1];


		
		try
		{
			/********************************/
			/* [1] Initialize a file reader */
			/********************************/
			file_reader = new FileReader(inputFilename);

			/********************************/
			/* [2] Initialize a file writer */
			/********************************/
			file_writer = new PrintWriter(outputFilename);
			
			/******************************/
			/* [3] Initialize a new lexer */
			/******************************/
			l = new Lexer(file_reader);

			/***********************/
			/* [4] Read next token */
			/***********************/
			s = l.next_token();

			/********************************/
			/* [5] Main reading tokens loop */
			/********************************/
			boolean continueLoop = true ;
			while (s.sym != TokenNames.EOF)
			{
				if (!continueLoop){
					break;
				}
				/************************/
				/* [6] Print to console */
				/************************/

				System.out.print("[");
				System.out.print(l.getLine());
				System.out.print(",");
				System.out.print(l.getTokenStartPosition());
				System.out.print("]:");
				System.out.print(s.value);
				System.out.print("\n"); 

            
				
				/*********************/
				/* [7] Print to file */
				/*********************/

				switch (s.sym){
					case 1:
						file_writer.print("PLUS");
						print_token(file_writer,l,s);
						break;
					case 2:
						file_writer.print("MINUS");
						print_token(file_writer,l,s);
						break;
					case 3:
						file_writer.print("TIMES");
						print_token(file_writer,l,s);
						break;
					case 4:
						file_writer.print("DIVIDE");
						print_token(file_writer,l,s);
						break;
					case 5:
						file_writer.print("LPAREN");
						print_token(file_writer,l,s);
						break;
					case 6:
						file_writer.print("RPAREN");
						print_token(file_writer,l,s);
						break;
					case 7:
						file_writer.print("INT");
						file_writer.print("(");
						file_writer.print(s.value);
						file_writer.print(")");
						print_token(file_writer,l,s);
						break;
					case 8:
						file_writer.print("ID");
						file_writer.print("(");
						file_writer.print(s.value);
						file_writer.print(")");
						print_token(file_writer,l,s);
						break;
					case 9:
						file_writer.print("STRING");
						file_writer.print("(");
						file_writer.print(s.value);
						file_writer.print(")");
						print_token(file_writer,l,s);
						break;
					case 10:
						file_writer.print("LBRACK");
						print_token(file_writer,l,s);
						break;
					case 11:
						file_writer.print("RBRACK");
						print_token(file_writer,l,s);
						break;
					case 12:
						file_writer.print("LBRACE");
						print_token(file_writer,l,s);
						break;
					case 13:
						file_writer.print("RBRACE");
						print_token(file_writer,l,s);
						break;
					case 14:
						file_writer.print("NIL");
						print_token(file_writer,l,s);
						break;
					case 15:
						file_writer.print("COMMA");
						print_token(file_writer,l,s);
						break;
					case 16:
						file_writer.print("DOT");
						print_token(file_writer,l,s);
						break;
					case 17:
						file_writer.print("SEMICOLON");
						print_token(file_writer,l,s);
						break;
					case 18:
						file_writer.print("TYPE_INT");
						print_token(file_writer,l,s);
						break;
					case 19:
						file_writer.print("TYPE_VOID");
						print_token(file_writer,l,s);
						break;
					case 20:
						file_writer.print("ASSIGN");
						print_token(file_writer,l,s);
						break;
					case 21:
						file_writer.print("EQ");
						print_token(file_writer,l,s);
						break;
					case 22:
						file_writer.print("LT");
						print_token(file_writer,l,s);
						break;
					case 23:
						file_writer.print("GT");
						print_token(file_writer,l,s);
						break;
					case 24:
						file_writer.print("ARRAY");
						print_token(file_writer,l,s);
						break;
					case 25:
						file_writer.print("CLASS");
						print_token(file_writer,l,s);
						break;
					case 26:
						file_writer.print("EXTENDS");
						print_token(file_writer,l,s);
						break;
					case 27:
						file_writer.print("RETURN");
						print_token(file_writer,l,s);
						break;
					case 28:
						file_writer.print("WHILE");
						print_token(file_writer,l,s);
						break;
					case 29:
						file_writer.print("IF");
						print_token(file_writer,l,s);
						break;
					case 30:
						file_writer.print("NEW");
						print_token(file_writer,l,s);
						break;
					case 31:
						file_writer.print("TYPE_STRING");
						print_token(file_writer,l,s);
						break;
					/*case 32:
						break;*/
					case 32:
						PrintWriter file_writer2 = new PrintWriter(outputFilename);
						file_writer = file_writer2;
						file_writer.print("ERROR");
						continueLoop=false;
						file_writer2.close();
						break;

				}
				
				/***********************/
				/* [8] Read next token */
				/***********************/
				s = l.next_token();
			}
			
			/******************************/
			/* [9] Close lexer input file */
			/******************************/
			l.yyclose();

			/**************************/
			/* [10] Close output file */
			/**************************/
			file_writer.close();
    	}
			     
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

