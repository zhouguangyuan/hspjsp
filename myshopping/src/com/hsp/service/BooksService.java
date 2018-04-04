package com.hsp.service;

import com.hsp.domain.Book;
import java.util.ArrayList;
import com.hsp.utils.SqlHelper;

public class BooksService {
	
		// �����ݿ���ʾ���ݳ���
	public ArrayList getAllBooks() {
		// �����ݿ�ȥ��ѯ

		String sql = "SELECT * FROM test.books where 1=?";
		String paras[] = {"1"};
		ArrayList al = new SqlHelper().executeQuery(sql, paras);
		ArrayList<Book> newAl = new ArrayList<Book>();
		//����ҵ���װ
        for(int i=0; i<al.size();i++){
        	Object obj[] = (Object [])al.get(i);
        	Book book = new Book();
        	book.setId(Integer.parseInt(obj[0].toString()));
        	book.setName(obj[1].toString());
        	book.setAuthor(obj[2].toString());
        	book.setPrice(Float.parseFloat(obj[3].toString()));
        	book.setPublishHouse(obj[4].toString());
        	book.setNums(Integer.parseInt(obj[5].toString()));
            newAl.add(book);
        }
		return newAl;

	}
}