package com.jangle.mongotest_snr.mongotest_snr.api.tail;

public enum Type {

	IMAGE(1),VIDEO(2),SOUND(3);
	
	private Type(int typeId)
	{
		this.typeId=typeId;
	}
	
	private int typeId;
	
	public static Type getById(int id)
	{
		for(Type type : Type.values())
		{
			if(type.getTypeId()==id)
			{
				return type;
			}
		}
		return null;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	
}
