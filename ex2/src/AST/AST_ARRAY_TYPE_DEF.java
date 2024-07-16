package AST;

public class AST_ARRAY_TYPE_DEF extends AST_Node
{
    public String ID;
    public AST_TYPE t;

    public AST_ARRAY_TYPE_DEF(String ID, AST_TYPE t)
	{
        this.t = t ;
        this.ID = ID;

	}
}