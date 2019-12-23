package org.rank.data.item;

public class ItemInfo {

	private long itemId; 
	private float score;
	private ItemAttribute itemAttribute;
    
	public ItemAttribute getItemAttribute(){ return itemAttribute; }
	public void setItemAttribute(ItemAttribute itemAttribute){ this.itemAttribute = itemAttribute; }
	public long getItemId(){ return itemId; }
	public void setItemId(long itemId){ this.itemId = itemId; } 

	public float getScore(){ return score; }
	public void setScore(float score){ this.score = score; }
}
