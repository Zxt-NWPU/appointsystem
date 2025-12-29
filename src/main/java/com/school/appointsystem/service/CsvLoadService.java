package com.school.appointsystem.service;

import com.school.appointsystem.entity.Consultant;
import com.school.appointsystem.entity.CsvLoadLog;
import com.school.appointsystem.entity.Room;
import com.school.appointsystem.mapper.ConsultantMapper;
import com.school.appointsystem.mapper.CsvLoadLogMapper;
import com.school.appointsystem.mapper.RoomMapper;
import com.school.appointsystem.util.CsvUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.boot.CommandLineRunner;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CsvLoadService implements CommandLineRunner {

    // 读取application.yml中的CSV路径
    @Value("${spring.csv.consultant-path}")
    private Resource consultantCsv;

    @Value("${spring.csv.room-path}")
    private Resource roomCsv;

    @Autowired
    private ConsultantMapper consultantMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private CsvLoadLogMapper csvLoadLogMapper;

    // 系统启动时自动执行
    @Override
    public void run(String... args) throws Exception {
        log.info("开始加载CSV初始化数据...");
        loadConsultantData(); // 加载咨询师数据
        loadRoomData();       // 加载咨询室数据
        log.info("CSV数据加载完成！");
    }

    // 加载咨询师CSV数据
    private void loadConsultantData() {
        loadCsvData("consultant.csv", consultantCsv, rows -> {
            int successCount = 0;
            for (String[] row : rows) {
                Consultant consultant = new Consultant();
                consultant.setIdCard(row[0]);
                consultant.setName(row[1]);
                consultant.setPhone(row[2]);
                consultant.setSchool(row[3]);
                consultant.setCompany(row[4]);
                consultant.setIntro(row[5]);
                consultant.setType(Integer.parseInt(row[6]));

                if (consultantMapper.selectByIdCard(consultant.getIdCard()) == null) {
                    consultantMapper.insert(consultant);
                    successCount++;
                }
            }
            return successCount;
        });
    }

    // 加载咨询室CSV数据
    private void loadRoomData() {
        loadCsvData("room.csv", roomCsv, rows -> {
            int successCount = 0;
            for (String[] row : rows) {
                Room room = new Room();
                room.setRoomNo(row[0]);
                room.setCampus(row[1]);
                room.setBuilding(row[2]);
                room.setRoomNumber(row[3]);

                if (roomMapper.selectByRoomNo(room.getRoomNo()) == null) {
                    roomMapper.insert(room);
                    successCount++;
                }
            }
            return successCount;
        });
    }

    // 通用 CSV 加载方法
    private void loadCsvData(String fileName, Resource csvResource, CsvProcessor processor) {
        CsvLoadLog csvLoadLog = new CsvLoadLog();
        csvLoadLog.setFileName(fileName);
        csvLoadLog.setLoadTime(new Date());

        try {
            List<String[]> rows = CsvUtils.readCsv(csvResource);
            int successCount = processor.process(rows);

            csvLoadLog.setLoadCount(successCount);
            csvLoadLog.setStatus(1); // 1=成功
            csvLoadLog.setErrorMsg(null);
            log.info("{}CSV加载成功，新增{}条数据", fileName.replace(".csv", ""), successCount);
        } catch (Exception e) {
            csvLoadLog.setLoadCount(0);
            csvLoadLog.setStatus(0); // 0=失败
            csvLoadLog.setErrorMsg(e.getMessage());
            log.error("{}CSV加载失败", fileName, e);
        } finally {
            csvLoadLogMapper.insert(csvLoadLog);
        }
    }

    // CSV 处理函数式接口
    @FunctionalInterface
    private interface CsvProcessor {
        int process(List<String[]> rows) throws Exception;
    }
}
