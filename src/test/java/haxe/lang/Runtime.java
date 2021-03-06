package haxe.lang;
import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public  class Runtime
{
	
	public static Object getField(haxe.lang.IHxObject obj, String field, boolean throwErrors)
	{
		if (obj == null && !throwErrors) return null;
		return obj.__hx_getField(field, throwErrors, false, false);
	}

	public static double getField_f(haxe.lang.IHxObject obj, String field, boolean throwErrors)
	{
		if (obj == null && !throwErrors) return 0.0;
		return obj.__hx_getField_f(field, throwErrors, false);
	}

	public static Object setField(haxe.lang.IHxObject obj, String field, Object value)
	{
		return obj.__hx_setField(field, value, false);
	}

	public static double setField_f(haxe.lang.IHxObject obj, String field, double value)
	{
		return obj.__hx_setField_f(field, value, false);
	}

	public static Object callField(haxe.lang.IHxObject obj, String field, Array<?> args)
	{
		return obj.__hx_invokeField(field, args);
	}
	static 
	{
		Runtime.undefined = new haxe.lang.DynamicObject(new haxe.root.Array<String>(new String[]{}), new haxe.root.Array<Object>(new Object[]{}), new haxe.root.Array<String>(new String[]{}), new haxe.root.Array<Object>(new Object[]{}));
	}
	public    Runtime()
	{
		{
		}
		
	}
	
	
	public static  Object undefined;
	
	public static   Object closure(Object obj, String field)
	{
		
	return new Closure(obj, field);
	
	}
	
	
	public static   boolean eq(Object v1, Object v2)
	{
		
			if (v1 == v2)
				return true;
			if (v1 == null || v2 == null)
				return false;

			if (v1 instanceof Number)
			{
				if (!(v2 instanceof Number))
					return false;

				Number v1c = (Number) v1;
				Number v2c = (Number) v2;
				if (v1 instanceof Long || v2 instanceof Long)
					return v1c.longValue() == v2c.longValue();
				return v1c.doubleValue() == v2c.doubleValue();
			} else if (v1 instanceof String || v1 instanceof haxe.lang.IEquatable) { //TODO see what happens with Boolean cases
				return v1.equals(v2);
			}

			return false;
	
	}
	
	
	public static   boolean refEq(Object v1, Object v2)
	{
		
		if (v1 == v2)
			return true;

		if (v1 instanceof String || v1 instanceof haxe.lang.IEquatable)
		{
			return v1 != null && v1.equals(v2);
		} else {
			return v1 == v2;
		}
	
	}
	
	
	public static   boolean valEq(Object v1, Object v2)
	{
		
		return v1 == v2 || (v1 != null && v1.equals(v2));
	
	}
	
	
	public static   double toDouble(Object obj)
	{
		
		return (obj == null) ? 0.0 : ((Number) obj).doubleValue();
	
	}
	
	
	public static   boolean toBool(Object obj)
	{
		
		return (obj == null) ? false : ((Boolean) obj).booleanValue();
	
	}
	
	
	public static   int toInt(Object obj)
	{
		
		return (obj == null) ? 0 : ((Number) obj).intValue();
	
	}
	
	
	public static   boolean isDouble(Object obj)
	{
		
		if (obj != null && obj instanceof Number)
		{
			return true;
		} else {
			return false;
		}
	
	}
	
	
	public static   boolean isInt(Object obj)
	{
		
		if (obj != null && obj instanceof Number)
		{
			Number n = (Number) obj;
			return n.doubleValue() == n.intValue();
		} else {
			return false;
		}
	
	}
	
	
	public static   boolean slowHasField(Object o, String field)
	{
		
		Class cl = null;
		if (o instanceof Class)
		{
			if (o == String.class)
				return field.equals("fromCharCode");

			cl = (Class) o;
		} else if (o instanceof String) {
			return haxe.lang.StringRefl.handleGetField( (String) o, field, false) != null;
		} else {
			cl = o.getClass();
		}

		try
		{
			java.lang.reflect.Field f = cl.getField(field);
			return true;
		}
		catch(Throwable t)
		{
			java.lang.reflect.Method[] ms = cl.getMethods();
			for (int i = 0; i < ms.length; i++)
			{
				if (ms[i].getName().equals(field))
				{
					return true;
				}
			}
		}

		return false;
	
	}
	
	
	public static   int compare(Object v1, Object v2)
	{
		
			if (v1 == v2)
				return 0;
			if (v1 == null) return -1;
			if (v2 == null) return 1;

			if (v1 instanceof Number || v2 instanceof Number)
			{
				Number v1c = (Number) v1;
				Number v2c = (Number) v2;

				if (v1 instanceof Long || v2 instanceof Long)
				{
					long l1 = (v1 == null) ? 0L : v1c.longValue();
					long l2 = (v2 == null) ? 0L : v2c.longValue();
          return (l1 < l2) ? -1 : (l1 > l2) ? 1 : 0;
				} else {
					double d1 = (v1 == null) ? 0.0 : v1c.doubleValue();
					double d2 = (v2 == null) ? 0.0 : v2c.doubleValue();

          return (d1 < d2) ? -1 : (d1 > d2) ? 1 : 0;
				}
			}
			//if it's not a number it must be a String
			return ((String) v1).compareTo((String) v2);
	
	}
	
	
	public static   Object plus(Object v1, Object v2)
	{
		
			if (v1 instanceof String || v2 instanceof String)
				return toString(v1) + toString(v2);

			if (v1 instanceof Number || v2 instanceof Number)
			{
				Number v1c = (Number) v1;
				Number v2c = (Number) v2;

				double d1 = (v1 == null) ? 0.0 : v1c.doubleValue();
				double d2 = (v2 == null) ? 0.0 : v2c.doubleValue();

				return d1 + d2;
			}

			throw new IllegalArgumentException("Cannot dynamically add " + v1 + " and " + v2);
	
	}
	
	
	public static   Object slowGetField(Object obj, String field, boolean throwErrors)
	{
		

	if (obj == null)
		if (throwErrors)
			throw new NullPointerException("Cannot access field '" + field + "' of null.");
		else
			return null;

	Class cl = null;
	try
	{
		if (obj instanceof Class)
		{
			if (obj == String.class && field.equals("fromCharCode"))
				return new Closure(haxe.lang.StringExt.class, field);

			cl = (Class) obj;
			obj = null;
		} else if (obj instanceof String) {
			return haxe.lang.StringRefl.handleGetField((String) obj, field, throwErrors);
		} else {
			cl = obj.getClass();
		}

		java.lang.reflect.Field f = cl.getField(field);
		f.setAccessible(true);
		return f.get(obj);
	} catch (Throwable t)
	{
		try
		{
			java.lang.reflect.Method[] ms = cl.getMethods();
			for (int i = 0; i < ms.length; i++)
			{
				if (ms[i].getName().equals(field))
				{
					return new Closure(obj != null ? obj : cl, field);
				}
			}
		} catch (Throwable t2)
		{

		}

		if (throwErrors)
			throw HaxeException.wrap(t);

		return null;
	}

	
	}
	
	
	public static   Object slowSetField(Object obj, String field, Object value)
	{
		
		Class cl = null;
		if (obj instanceof Class)
		{
			cl = (Class) obj;
			obj = null;
		} else {
			cl = obj.getClass();
		}

		try {
			java.lang.reflect.Field f = cl.getField(field);
			f.setAccessible(true);

			//FIXME we must evaluate if field to be set receives either int or double
			if (isInt(value))
			{
				f.setInt(obj, toInt(value));
			} else if (isDouble(value)) {
				f.setDouble(obj, toDouble(value));
			} else {
				f.set(obj, value);
			}
			return value;
		}
		catch (Throwable t)
		{
			throw HaxeException.wrap(t);
		}
	
	}
	
	
	public static   Object slowCallField(Object obj, String field, haxe.root.Array args)
	{
		
		Class cl = null;
		if (obj instanceof Class)
		{
			if (obj == String.class && field.equals("fromCharCode"))
				return haxe.lang.StringExt.fromCharCode(toInt(args.__get(0)));

			cl = (Class) obj;
			obj = null;
		} else if (obj instanceof String) {
			return haxe.lang.StringRefl.handleCallField((String) obj, field, args);
		} else {
			cl = obj.getClass();
		}

		if (args == null) args = new Array();

		int len = args.length;
		Class[] cls = new Class[len];
		Object[] objs = new Object[len];

		java.lang.reflect.Method[] ms = cl.getMethods();
		int msl = ms.length;
		int realMsl = 0;
		for(int i =0; i < msl; i++)
		{
			if (!ms[i].getName().equals(field) || (!ms[i].isVarArgs() && ms[i].getParameterTypes().length != len))
			{
				ms[i] = null;
			} else {
				ms[realMsl] = ms[i];
				if (realMsl != i)
					ms[i] = null;
				realMsl++;
			}
		}

		boolean hasNumber = false;

		for (int i = 0; i < len; i++)
		{
			Object o = args.__get(i);
			if (o == null)
			{
				continue; //can be anything
			}
			objs[i]= o;
			cls[i] = o.getClass();
			boolean isNum = false;

			if (o instanceof Number)
			{
				cls[i] = Number.class;
				isNum = hasNumber = true;
			}

			msl = realMsl;
			realMsl = 0;

			for (int j = 0; j < msl; j++)
			{
				Class[] allcls = ms[j].getParameterTypes();
				if (i < allcls.length)
				{
					if (!  ((isNum && allcls[i].isPrimitive()) || allcls[i].isAssignableFrom(cls[i])) )
					{
						ms[j] = null;
					} else {
						ms[realMsl] = ms[j];
						if (realMsl != j)
							ms[j] = null;
						realMsl++;
					}
				}
			}

		}

		java.lang.reflect.Method found;
		if (ms.length == 0 || (found = ms[0]) == null)
			throw haxe.lang.HaxeException.wrap("No compatible method found for: " + field);

		if (hasNumber)
		{
			Class[] allcls = found.getParameterTypes();

			for (int i = 0; i < len; i++)
			{
				Object o = objs[i];
				if (o instanceof Number)
				{
					Class curCls = null;
					if (i < allcls.length)
					{
						curCls = allcls[i];
						if (!curCls.isAssignableFrom(o.getClass()))
						{
							String name = curCls.getName();
							if (name.equals("double") || name.equals("java.lang.Double"))
							{
								objs[i] = ((Number)o).doubleValue();
							} else if (name.equals("int") || name.equals("java.lang.Integer"))
							{
								objs[i] = ((Number)o).intValue();
							} else if (name.equals("float") || name.equals("java.lang.Float"))
							{
								objs[i] = ((Number)o).floatValue();
							} else if (name.equals("byte") || name.equals("java.lang.Byte"))
							{
								objs[i] = ((Number)o).byteValue();
							} else if (name.equals("short") || name.equals("java.lang.Short"))
							{
								objs[i] = ((Number)o).shortValue();
							} else if (name.equals("long") || name.equals("java.lang.Long"))
							{
								objs[i] = ((Number)o).longValue();
							}
						}
					} //else varargs not handled TODO
				}
			}
		}

		try {
			found.setAccessible(true);
			return found.invoke(obj, objs);
		}

		catch (java.lang.reflect.InvocationTargetException e)
		{
			throw haxe.lang.HaxeException.wrap(e.getCause());
		}

		catch (Throwable t)
		{
			throw haxe.lang.HaxeException.wrap(t);
		}
	
	}
	
	
	public static   Object callField(Object obj, String field, haxe.root.Array args)
	{
		
		if (obj instanceof haxe.lang.IHxObject)
		{
			return ((haxe.lang.IHxObject) obj).__hx_invokeField(field, args);
		}

		return slowCallField(obj, field, args);
	
	}
	
	
	public static   Object getField(Object obj, String field, boolean throwErrors)
	{
		

		if (obj instanceof haxe.lang.IHxObject)
			return ((haxe.lang.IHxObject) obj).__hx_getField(field, throwErrors, false, false);

		return slowGetField(obj, field, throwErrors);

	
	}
	
	
	public static   double getField_f(Object obj, String field, boolean throwErrors)
	{
		

		if (obj instanceof haxe.lang.IHxObject)
			return ((haxe.lang.IHxObject) obj).__hx_getField_f(field, throwErrors, false);

		return toDouble(slowGetField(obj, field, throwErrors));

	
	}
	
	
	public static   Object setField(Object obj, String field, Object value)
	{
		

		if (obj instanceof haxe.lang.IHxObject)
			return ((haxe.lang.IHxObject) obj).__hx_setField(field, value, false);

		return slowSetField(obj, field, value);

	
	}
	
	
	public static   double setField_f(Object obj, String field, double value)
	{
		

		if (obj instanceof haxe.lang.IHxObject)
			return ((haxe.lang.IHxObject) obj).__hx_setField_f(field, value, false);

		return toDouble(slowSetField(obj, field, value));

	
	}
	
	
	public static   String toString(Object obj)
	{
		if (( obj == null )) 
		{
			return null;
		}
		
		if (Runtime.isInt(obj))
		{
			return ( ((int) (Runtime.toInt(obj)) ) + "" );
		}
		
		return obj.toString();
	}
	
	
	public static   boolean isFinite(double v)
	{
		return ( ( v == v ) &&  ! (Double.isInfinite(((double) (v) )))  );
	}
	
	
}


