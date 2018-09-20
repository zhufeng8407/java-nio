package com.nio.buffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 一、通道（Channel）：用于源节点与目标节点的连接。在 Java NIO 中负责缓冲区中数据的传输。Channel 本身不存储数据，因此需要配合缓冲区进行传输。
 * 
 * 二、通道的主要实现类
 * 	java.nio.channels.Channel 接口：
 * 		|--FileChannel
 * 		|--SocketChannel
 * 		|--ServerSocketChannel
 * 		|--DatagramChannel
 * 
 * 三、获取通道
 * 1. Java 针对支持通道的类提供了 getChannel() 方法
 * 		本地 IO：
 * 		FileInputStream/FileOutputStream
 * 		RandomAccessFile
 * 
 * 		网络IO：
 * 		Socket
 * 		ServerSocket
 * 		DatagramSocket
 * 		
 * 2. 在 JDK 1.7 中的 NIO.2 针对各个通道提供了静态方法 open()
 * 3. 在 JDK 1.7 中的 NIO.2 的 Files 工具类的 newByteChannel()
 * 
 * 四、通道之间的数据传输
 * transferFrom()
 * transferTo()
 * 
 * 五、分散(Scatter)与聚集(Gather)
 * 分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中
 * 聚集写入（Gathering Writes）：将多个缓冲区中的数据聚集到通道中
 * 
 * 六、字符集：Charset
 * 编码：字符串 -> 字节数组
 * 解码：字节数组  -> 字符串
 * 
 * @author zhufeng
 *
 */
public class TestChannel {

	public static void main(String[] args) throws IOException {
		testChannel1();
	}
	
	/**
	 * 利用通道完成文件的复制
	 * @throws IOException
	 */
	private static void testChannel1() throws IOException {
		FileInputStream fis = new FileInputStream("/Users/zhufeng/Downloads/study/测试环境二维码.png");
		FileOutputStream fos = new FileOutputStream("/Users/zhufeng/Downloads/study/测试环境二维码2.png");
		
		FileChannel inChannel = fis.getChannel();
		FileChannel outChannel = fos.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while(inChannel.read(buffer) != -1) {
			buffer.flip();
			outChannel.write(buffer);
			buffer.clear();
		}
		
		fis.close();
		fos.close();
		inChannel.close();
		outChannel.close();
		
	}
	
	/**
	 * 使用直接缓冲完成文件的复制
	 */
	private static void testMappedByteBuffer() {
		
	}

}
