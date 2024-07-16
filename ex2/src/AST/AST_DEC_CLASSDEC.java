package AST;

public class AST_DEC_CLASSDEC extends AST_DEC
{
    public AST_CLASS_DEC classDec;

	public AST_DEC_CLASSDEC(AST_CLASS_DEC classDec)
	{
        this.classDec=classDec;
        
	}
}