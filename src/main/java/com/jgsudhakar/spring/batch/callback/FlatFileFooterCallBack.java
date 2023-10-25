/**
 * 
 */
package com.jgsudhakar.spring.batch.callback;

import java.io.IOException;
import java.io.Writer;
import java.time.ZonedDateTime;

import org.springframework.batch.item.file.FlatFileFooterCallback;

import lombok.extern.log4j.Log4j2;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.batch.callback.FlatFileFooterCallBack.java
 * @Date : 2021-10-10
 */
@Log4j2
public class FlatFileFooterCallBack implements FlatFileFooterCallback {
	
	@Override
	public void writeFooter(Writer writer) throws IOException {
		log.info(":: Writing the Footer details:: ");
		writer.write("File Generated at ::"+ ZonedDateTime.now());

	}

}
