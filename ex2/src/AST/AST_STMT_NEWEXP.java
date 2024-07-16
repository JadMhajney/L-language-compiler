package AST;

public class AST_STMT_NEWEXP extends AST_STMT
{
        public AST_NEW_EXP Nexp;
        public AST_VAR v;

	public AST_STMT_NEWEXP(AST_VAR v,AST_NEW_EXP Nexp )
	{
                this.v = v ;
                this.Nexp = Nexp;

	}
}
