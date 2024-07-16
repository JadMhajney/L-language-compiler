package AST;

public class AST_STMT_VARDEC extends AST_STMT
{
    public AST_VAR_DEC varDec;

	public AST_STMT_VARDEC(AST_VAR_DEC varDec)
	{
        this.varDec=varDec;
        
	}
}