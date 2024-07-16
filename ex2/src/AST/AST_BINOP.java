package AST;

public class AST_BINOP extends AST_Node
{
	public int op;
	
	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AST_BINOP(int op)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		SerialNumber = AST_Node_Serial_Number.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.format("====================== exp -> INT( %d )\n", op);

		/*******************************/
		/* COPY INPUT DATA NENBERS ... */
		/*******************************/
		this.op = op;
	}

	public int getOP(){
		return this.op;
	}

	/************************************************/
	/* The printing message for an INT EXP AST node */
	/************************************************/
	public void PrintMe()
	{
		/*******************************/
		/* AST NODE TYPE = AST INT EXP */
		/*******************************/
		System.out.format("AST NODE INT( %d )\n",op);

		/*********************************/
		/* Print to AST GRAPHIZ DOT file */
		/*********************************/
		AST_GRAPHVIZ.getInstance().logNode(
			SerialNumber,
			String.format("INT(%d)",op));
	}
}
