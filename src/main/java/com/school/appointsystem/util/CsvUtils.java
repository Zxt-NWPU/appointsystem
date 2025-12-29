package com.school.appointsystem.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

// CSV文件读取工具类
public class CsvUtils {
    // 读取CSV文件，返回所有行数据（跳过表头）
    public static List<String[]> readCsv(Resource resource) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new InputStreamReader(resource.getInputStream()))) {
            List<String[]> allRows = reader.readAll();
            // 确保列表不为空且至少有一行数据（表头）
            if (allRows != null && !allRows.isEmpty()) {
                allRows.remove(0); // 跳过第一行表头
            }
            return allRows;
        }
    }
}
