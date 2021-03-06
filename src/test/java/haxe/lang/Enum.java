package haxe.lang;
import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public  class Enum
{
	public    Enum(int index, haxe.root.Array<Object> params)
	{
		this.index = index;
		this.params = params;
	}
	
	
	public  int index;
	
	public  haxe.root.Array<Object> params;
	
	public   String getTag()
	{
		Object cl = haxe.root.Type.getEnum(((Object) (this) ));
		return haxe.lang.Runtime.toString(haxe.lang.Runtime.callField(haxe.lang.Runtime.getField(cl, "constructs", true), "__get", new haxe.root.Array(new Object[]{this.index})));
	}
	
	
	@Override public   String toString()
	{
		if (( ( this.params == null ) || ( this.params.length == 0 ) )) 
		{
			return this.getTag();
		}
		
		haxe.root.StringBuf ret = new haxe.root.StringBuf();
		ret.add(this.getTag());
		ret.add("(");
		boolean first = true;
		{
			int _g = 0;
			haxe.root.Array<Object> _g1 = this.params;
			while (( _g < _g1.length ))
			{
				Object p = _g1.__get(_g);
				 ++ _g;
				if (first) 
				{
					first = false;
				}
				 else 
				{
					ret.add(",");
				}
				
				ret.add(p);
			}
			
		}
		
		ret.add(")");
		return ret.toString();
	}
	
	
	@Override public   boolean equals(Object obj)
	{
		if (haxe.lang.Runtime.eq(obj, this)) 
		{
			return true;
		}
		
		Enum obj1 = ((Enum) (obj) );
		boolean ret = ( ( ( obj1 != null ) && haxe.root.Std.is(obj1, haxe.root.Type.getEnum(((Object) (this) ))) ) && ( obj1.index == this.index ) );
		if ( ! (ret) ) 
		{
			return false;
		}
		
		if (( obj1.params == this.params )) 
		{
			return true;
		}
		
		int len = 0;
		if (( ( ( obj1.params == null ) || ( this.params == null ) ) || ( (len = this.params.length) != obj1.params.length ) )) 
		{
			return false;
		}
		
		{
			int _g = 0;
			while (( _g < ((int) (len) ) ))
			{
				int i = _g++;
				if ( ! (haxe.root.Type.enumEq(obj1.params.__get(i), this.params.__get(i))) ) 
				{
					return false;
				}
				
			}
			
		}
		
		return true;
	}
	
	
	@Override public   int hashCode()
	{
		int h = 19;
		if (( this.params != null )) 
		{
			int _g = 0;
			haxe.root.Array<Object> _g1 = this.params;
			while (( _g < _g1.length ))
			{
				Object p = _g1.__get(_g);
				 ++ _g;
				h = ( h * 31 );
				if (( ! (( p == null )) )) 
				{
					h += p.hashCode();
				}
				
			}
			
		}
		
		h += this.index;
		return h;
	}
	
	
}


