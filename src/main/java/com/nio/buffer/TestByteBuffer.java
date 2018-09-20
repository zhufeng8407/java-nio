package com.nio.buffer;

import java.nio.ByteBuffer;

public class TestByteBuffer {

	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		
		System.out.println("============allocate=========");
		
		System.out.println("position: " + byteBuffer.position());
		System.out.println("limit: " + byteBuffer.limit());
		System.out.println("capacity: " + byteBuffer.capacity());
		
		String str = "abcde";
		byteBuffer.put(str.getBytes());
		System.out.println("============put=========");
		System.out.println("position: " + byteBuffer.position());
		System.out.println("limit: " + byteBuffer.limit());
		System.out.println("capacity: " + byteBuffer.capacity());
		
		byteBuffer.flip();
		System.out.println("============flip=========");
		System.out.println("position: " + byteBuffer.position());
		System.out.println("limit: " + byteBuffer.limit());
		System.out.println("capacity: " + byteBuffer.capacity());
		
		byte[] dst = new byte[byteBuffer.limit()];
		byteBuffer.get(dst);
		System.out.println("============get=========");
		System.out.println(new String(dst, 0, dst.length));
		System.out.println("position: " + byteBuffer.position());
		System.out.println("limit: " + byteBuffer.limit());
		System.out.println("capacity: " + byteBuffer.capacity());
		
		// 重新读取
		System.out.println("===========byteBuffer.rewind()=========");
		byteBuffer.rewind();
		System.out.println("position: " + byteBuffer.position());
		System.out.println("limit: " + byteBuffer.limit());
		System.out.println("capacity: " + byteBuffer.capacity());
	}

}
