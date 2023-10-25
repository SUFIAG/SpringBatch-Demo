/**
 * 
 */
package com.jgsudhakar.spring.batch.itemwriter;

import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.jgsudhakar.spring.batch.callback.FlatFileFooterCallBack;
import com.jgsudhakar.spring.batch.callback.FlatFileHeaderCallBack;
import com.jgsudhakar.spring.batch.dto.StudentResponseDto;

import lombok.extern.log4j.Log4j2;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.batch.itemwriter.StudentItemWriteToFile.java
 * @Date : 2021-10-05
 */
@Component
@Log4j2
public class StudentItemWriteToFile implements ItemWriter<StudentResponseDto> {
	
	@Value("${jgsudhakar.exportFileName}")
	private String fileName;

	@Override
	public void write(List<? extends StudentResponseDto> items) throws Exception {
		log.info(":: In the write ::");
		FlatFileItemWriter<StudentResponseDto> writer = new FlatFileItemWriter<StudentResponseDto>();
		writer.setAppendAllowed(true);
//		writer.setShouldDeleteIfExists(true);
		writer.setEncoding("UTF-8");
		writer.setResource(new FileSystemResource(fileName));
		DelimitedLineAggregator<StudentResponseDto> delLineAgg = new DelimitedLineAggregator<StudentResponseDto>();
		delLineAgg.setDelimiter(",");
		BeanWrapperFieldExtractor<StudentResponseDto> fieldExtractor = new BeanWrapperFieldExtractor<StudentResponseDto>();
		fieldExtractor.setNames(new String[] {"id", "name", "rollNo" ,"standard"});
		delLineAgg.setFieldExtractor(fieldExtractor);
		writer.setLineSeparator("\n");
		writer.setLineAggregator(delLineAgg);
		writer.setHeaderCallback(new FlatFileHeaderCallBack());
		writer.open(new ExecutionContext());
		writer.write(items);
		writer.setFooterCallback(new FlatFileFooterCallBack());
		writer.close();
	}

}
