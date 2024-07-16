package AST;

public class AST_CFIELD_varDec extends AST_CFIELD
{
	public AST_VAR_DEC varDec;

	
	/*  CONSTRUCTOR(S) */
	
	public AST_CFIELD_varDec(AST_VAR_DEC varDec)
	{
		this.varDec = varDec;
	}
}
