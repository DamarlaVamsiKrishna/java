package com.thoughtFocus.treeSet;

import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {

		TreeSet<StringBuffer> t = new TreeSet<StringBuffer>();

		t.add(new StringBuffer("a"));
		t.add(new StringBuffer("z"));
		t.add(new StringBuffer("k"));
		t.add(new StringBuffer("l"));

		System.out.println(t);
	}
}
