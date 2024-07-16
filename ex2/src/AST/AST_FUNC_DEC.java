package AST;

public class AST_FUNC_DEC extends AST_Node
{
    public AST_TYPE t;
    public String ID;
    public AST_ARG_LIST arglist;
	public AST_STMT_LIST stmtlist;

    public AST_FUNC_DEC(AST_TYPE t,String ID,AST_ARG_LIST arglist,AST_STMT_LIST stmtlist)
	{
       this.t=t;
	   this.ID=ID;
	   this.arglist=arglist;
	   this.stmtlist=stmtlist;
	}
}


