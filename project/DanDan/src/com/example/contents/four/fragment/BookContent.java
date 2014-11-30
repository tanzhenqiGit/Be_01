/** 
* Copyright 2014 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2014-11-30 ÏÂÎç8:08:40.
*/ 
package com.example.contents.four.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public class BookContent {
	
	public static class Book
	{
		public String mTitle;
		public String mDesc;
		public Integer mId;
		public Book(Integer mId, String mTitle, String mDesc) {
			super();
			this.mId = mId;
			this.mTitle = mTitle;
			this.mDesc = mDesc;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return mTitle;
		}
		
	}
	public static List<Book> ITEMS = new ArrayList<Book>();
	public static Map<Integer, Book> ITEM_MAP
		= new HashMap<Integer, Book>();
	static
	{
		addItem(new Book(1,"Crazy Java Lecture",
				"a book, go to deeply explain Java, already as a Textbook is collage."));
		addItem(new Book(2,"Crazy Android Lecture",
				"First choice for Android Leaner,Sales is the first of all on web dangdang, yamaxun, and jingdong," +
				"perennial"));
		addItem(new Book(3,"Crazy JavaEE Lecture",
				"comprehensive introduce Java EE develop 1 Structs 2¡¢Spring 3¡¢Hibernate 4¡¢framework"));
	}
	
	private static void addItem(Book book)
	{
		ITEMS.add(book);
		ITEM_MAP.put(book.mId, book);
	}

	
}

