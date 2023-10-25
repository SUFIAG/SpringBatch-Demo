/**
 * 
 */
package com.jgsudhakar.spring.batch.callback;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

import lombok.extern.log4j.Log4j2;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.batch.callback.FlatFileHeaderCallBack.java
 * @Date : 2021-10-10
 */
@Log4j2
public class FlatFileHeaderCallBack implements FlatFileHeaderCallback {
	@Override
	public void writeHeader(Writer writer) throws IOException {
		log.info(":: Writing the Header to File ::");
		writer.write("Student Id,Student Name,Student Roll No,Standard");
	}

}
