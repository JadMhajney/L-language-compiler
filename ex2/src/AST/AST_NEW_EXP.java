package AST;

public class AST_NEW_EXP extends AST_Node
{
        public AST_EXP e;
        public AST_TYPE t;

	public AST_NEW_EXP(AST_TYPE t, AST_EXP e)
	{
                this.t = t ;
                this.e = e;

	}
}