package AST;

public class AST_CFIELD_funcDec extends AST_CFIELD
{
	public AST_FUNC_DEC funcDec;

	/*/
	/*  CONSTRUCTOR(S) */
	
	public AST_CFIELD_funcDec(AST_FUNC_DEC funcDec)
	{
		this.funcDec = funcDec;
	}
}