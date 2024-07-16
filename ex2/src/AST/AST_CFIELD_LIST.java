package AST;

public class AST_CFIELD_LIST extends AST_Node
{
	/****************/
	/* DATA MEMBERS */
	/****************/
	public AST_CFIELD head;
	public AST_CFIELD_LIST tail;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AST_CFIELD_LIST(AST_CFIELD head,AST_CFIELD_LIST tail)
	{

		this.head = head;
		this.tail = tail;
	}

	
}