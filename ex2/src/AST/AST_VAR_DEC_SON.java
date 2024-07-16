package AST;

public class AST_VAR_DEC_SON extends AST_VAR_DEC
{
    public AST_TYPE t;
    public String ID;
    public AST_EXP e;
    public AST_NEW_EXP ne;

        public AST_VAR_DEC_SON(AST_TYPE t,String ID,AST_EXP e,AST_NEW_EXP ne)
	{
                this.t = t;
                this.ID = ID;
                this.e = e ;
                this.ne = ne;
	}
}