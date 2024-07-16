package AST;

public class AST_ARG extends AST_Node
{
    public AST_TYPE type;
	public String ID;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AST_ARG(AST_TYPE type, String ID)
	{
        this.type = type;
		this.ID = ID;
	}
}
