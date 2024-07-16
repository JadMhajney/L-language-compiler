package AST;

public class AST_CLASS_DEC extends AST_Node
{
    public String ID1;
    public String ID2;
    public AST_CFIELD_LIST clist;

    public AST_CLASS_DEC(String ID1,String ID2,AST_CFIELD_LIST clist)
	{
        this.ID1=ID1;
        this.ID2=ID2;
        this.clist=clist;
	}
}