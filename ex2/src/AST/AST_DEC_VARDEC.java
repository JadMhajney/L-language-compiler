package AST;

public class AST_DEC_VARDEC extends AST_DEC
{
    public AST_VAR_DEC varDec;

	public AST_DEC_VARDEC(AST_VAR_DEC varDec)
	{
        this.varDec=varDec;
        
	}
}