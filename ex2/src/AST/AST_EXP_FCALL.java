package AST;

public class AST_EXP_FCALL extends AST_EXP
{
	public AST_VAR var;
    public AST_EXP_LIST EXPList;
    public String ID;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AST_EXP_FCALL(AST_VAR var,String ID,AST_EXP_LIST EXPList)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		SerialNumber = AST_Node_Serial_Number.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		System.out.print("====================== exp -> var\n");

		/*******************************/
		/* COPY INPUT DATA NENBERS ... */
		/*******************************/
		this.var = var;
        this.EXPList=  EXPList;
        this.ID = ID;
	}
	
	/************************not changed yet***********************/
	/* The default message for an exp var AST node */
	/***********************************************/
	public void PrintMe()
	{
		/************************************/
		/* AST NODE TYPE = EXP VAR AST NODE */
		/************************************/
		System.out.print("AST NODE FCALL VAR\n");

		/*****************************/
		/* RECURSIVELY PRINT var ... */
		/*****************************/
		if (var != null) var.PrintMe();
		
		/*********************************/
		/* Print to AST GRAPHIZ DOT file */
		/*********************************/
		AST_GRAPHVIZ.getInstance().logNode(
			SerialNumber,
			"EXP\nVAR");

		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		AST_GRAPHVIZ.getInstance().logEdge(SerialNumber,var.SerialNumber);
			
	}
}
